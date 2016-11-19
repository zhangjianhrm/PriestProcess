package com.lenovo.lps.farseer.priest2.platform.web;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.google.common.collect.Sets;
import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;
import com.lenovo.lps.farseer.priest2.common.util.AuditLog;
import com.lenovo.lps.farseer.priest2.common.util.CommUtils;
import com.lenovo.lps.farseer.priest2.common.util.ConfigUtil;
import com.lenovo.lps.farseer.priest2.common.util.DateUtils;
import com.lenovo.lps.farseer.priest2.platform.dal.ApplicationDao;
import com.lenovo.lps.farseer.priest2.platform.dal.IdDao;
import com.lenovo.lps.farseer.priest2.platform.entity.PagingResult;
import com.lenovo.lps.farseer.priest2.platform.entity.ProcessDependentEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.ProcessEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.ProcessRunGraph;
import com.lenovo.lps.farseer.priest2.platform.entity.ProcessStateEnum;
import com.lenovo.lps.farseer.priest2.platform.entity.ProcessTypeEnum;
import com.lenovo.lps.farseer.priest2.platform.entity.StatusEnum;
import com.lenovo.lps.farseer.priest2.platform.manager.ProcessManager;
import com.lenovo.lps.farseer.priest2.platform.manager.RedisSourceManager;
import com.lenovo.lps.farseer.priest2.platform.security.AccessSession;
import com.lenovo.lps.farseer.priest2.platform.service.FileUploadService;
import com.lenovo.lps.farseer.priest2.platform.service.ProcessDrawService;
import com.lenovo.lps.farseer.priest2.platform.service.ProcessService;
import com.lenovo.lps.farseer.priest2.platform.service.ScheduleService;
import com.lenovo.lps.farseer.priest2.platform.service.ZipOperateOfProcessService;
import com.lenovo.lps.farseer.priest2.platform.util.Constants;
import com.lenovo.lps.farseer.priest2.platform.util.DataTransformation;
import com.lenovo.lps.farseer.priest2.platform.util.JsonParseUtils;
import com.lenovo.lps.farseer.priest2.platform.util.ProcessExcel;
import com.lenovo.lps.farseer.priest2.platform.util.StringUtil;

@Controller
@RequestMapping("/process")
public class ProcessController {
	private static final String CONTENT_DISPOSITION = "Content-Disposition";
	private static final String ATTACHMENT_FILENAME = "attachment; filename=";
	private static final String ZIP_SUFFIX = ".zip";
	private final Logger logger = Logger.getLogger(ProcessController.class);
	// process id 未指定时json串
	private String emptyProcessIdJsonStr = "\"processId\":{\"value\":\"\"}";

	@Autowired
	@Qualifier("processManager")
	private ProcessManager processManager;
	
	@Autowired
	private RedisSourceManager manager;

	@Autowired
	private ProcessService processService;
	
	@Autowired
	private ProcessDrawService processDrawService;

	@Autowired
	private IdDao idDao;

	@Autowired
	private ApplicationDao aplicationDao;

	@Autowired
	private ProcessExcel processExcel;

	@Resource
	private ScheduleService scheduleService;

	@Autowired
	private ZipOperateOfProcessService zipOperateOfProcessService;

	@Autowired
	private FileUploadService fileUploadService;

	private static final String ERROR = "err";
	private static final String UTF_8 = "UTF-8";

	/**
	 * 查询流程定义
	 * 
	 * @param processId
	 * @param processName
	 * @param processApp
	 * @param createdBy
	 * @param createdDateStart
	 * @param createdDateEnd
	 * @param processStatus
	 * @param rows
	 *            每页显示记录数
	 * @param page
	 *            页号
	 * @param sidx
	 *            排序字段
	 * @param sord
	 *            排序类型 asc升序排序,desc按降序排
	 * @return
	 */
	@RequestMapping(value = "searchProcess", method = RequestMethod.POST)
	public ModelAndView searchProcess(ProcessEntity requestParam) {
		ModelMap modelMap = new ModelMap();
		try {
			PagingResult<ProcessEntity> result = processManager.getProcessDef(requestParam);
			modelMap.put(Constants.RESPONSE_RESULT_TOTALPAGES, result.getTotalPages());
			modelMap.put(Constants.RESPONSE_RESULT_TOTALRECORDS, result.getTotalRecords());
			modelMap.put(Constants.RESPONSE_RESULT_CURRENTPAGE, result.getPageNo());
			modelMap.addAttribute(Constants.RESPONSE_RESULT_COLLECTION, result.getResults());
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			modelMap.addAttribute(ERROR, StringUtils.isNotEmpty(e.getMessage()) ? e.getMessage() : e.toString());
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		}
	}

	/**
	 * <pre>
	 * json格式
	 * {states={rect1={type=start, text={text=开始}, attr={x=360, y=51, width=50, height=50}, props={text={value=开始}}}, rect2={type=end, text={text=结束}, attr={x=362, y=424, width=50, height=50}, props={text={value=结束}}}, rect3={type=transfer, text={text=数据迁移}, attr={x=336, y=251, width=100, height=50}, props={componentName={value=数据迁移}, taskId={value=143}, taskName={value=undefined}, transferMode={value=}, sourceData={value=}, dbUser={value=}, dbPass={value=}, connStr={value=}, overWrite={value=}, seperator={value=}, destData={value=}}}}, paths={path4={from=rect1, to=rect3, dots=[], text={text=TO 数据迁移}, textPos={x=0, y=-10}, props={text={value=}}},
	 * path5={from=rect3, to=rect2, dots=[], text={text=TO 结束}, textPos={x=0, y=-10}, props={text={value=}}}},
	 * props={props={processId={value=}, processName={value=abc}, processDesc={value=bde}, validate={value=2012-06-01}, priority={value=L}, appName={value=R}, scheduleType={value=O}, scheduleDate={value=2012-06-01}, scheduleTime={value=10:24 PM}, lateStartTime={value=09:21 PM}, alermMethod={value=E}, alermPerson={value=niexm1@lenovo.com}}}}
	 * </pre>
	 * 
	 * @param jsonDef
	 * @return
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public ModelAndView saveProcess(HttpServletRequest request, String jsonDef) {
		String userName = AccessSession.getAccessUser(request.getSession()) ;
		ModelMap modelMap = new ModelMap();
		try {
			ProcessEntity process = JsonParseUtils.parseProcessFromJson(jsonDef);
			if (process == null) {
				modelMap.addAttribute(ERROR, "One of the task id is 0, please delete it and create again!");
				return new ModelAndView(new MappingJacksonJsonView(), modelMap);
			}
			List<ProcessDependentEntity> deps = process.getDeps();
			ProcessEntity requestParam = new ProcessEntity();
			requestParam.setProcessName(process.getProcessName());
			requestParam.setRows(10000);
			PagingResult<ProcessEntity> existsProcesses = processService.getProcessDef(requestParam);
			// 流程ID为空时,表示新创建流程
			boolean isCreate = process.getProcessId() == null;
			// 重复流程名称检查
			if (existsProcesses.getTotalPages().longValue() > 0) {
				for (ProcessEntity proc : existsProcesses.getResults()) {
					AuditLog.log("create process:" + proc.getProcessName() + StringUtil.lowerStr(proc.getProcessName()).equals(StringUtil.lowerStr(process.getProcessName())));
					if (StringUtil.lowerStr(proc.getProcessName()).equals(StringUtil.lowerStr(process.getProcessName()))
							&& (isCreate || proc.getProcessId().intValue() != process.getProcessId().intValue())) {
						modelMap.addAttribute(ERROR, "Process name is duplication:" + process.getProcessName());
						return new ModelAndView(new MappingJacksonJsonView(), modelMap);
					}
				}
			}
			// 流程新增
			if (isCreate) {
				Integer processId = idDao.genProcessId().intValue();
				// 新流程Json属性没有流程ＩＤ,在此补充
				String processIdJsonStr = "\"processId\":{\"value\":\"" + processId + "\"}";
				String newJsonDef = jsonDef.replace(emptyProcessIdJsonStr, processIdJsonStr);
				process.setJsonDef(newJsonDef);
				// 新建流程状态为等待执行
				process.setProcessStatus(StatusEnum.W.name());
				process.setCreatedBy(userName);
				// 生成process Id
				process.setProcessId(processId);
			}
			// 流程修改
			else {
				ProcessEntity dbStoredProcess = processService.getProcessDef(String.valueOf(process.getProcessId()));
				// update前检查
				if (dbStoredProcess == null) {
					modelMap.addAttribute(ERROR, "Can't find the process,Process ID:" + process.getProcessId());
					return new ModelAndView(new MappingJacksonJsonView(), modelMap);
				}
				// 限定只能修改本人新增的流程
				String createdBy = dbStoredProcess.getCreatedBy();
				if (!createdBy.equals(userName)
						&& !Constants.USER_ADMIN.equals(userName)) {
					modelMap.addAttribute(ERROR, "Can't Modify the process if U aren't the creator, the creator is:" + createdBy);
					return new ModelAndView(new MappingJacksonJsonView(), modelMap);
				}
				process.setCreatedBy(createdBy);
				process.setUpdatedBy(userName);
			}
			// 从jsonDef中去除业务变量,业务变量保存在P_APPLICATION表中
			String appVarsJsonStr = ",\"appVariables\":{\"value\":\"" + process.getAppVariables().replaceAll("\n", "\\\\n") + "\"}";
			String jsonDefNoAppVars = process.getJsonDef().replace(appVarsJsonStr, "");
			process.setJsonDef(jsonDefNoAppVars);
			
			// check all process defined 
			String checkvarmsg = checkProcessVariables(process) ;
			if ( checkvarmsg != null ){
				modelMap.addAttribute(ERROR, "Parameter:" + checkvarmsg + " has not defined!");
				return new ModelAndView(new MappingJacksonJsonView(), modelMap);
			}
						
			// 保存流程时判断,内部应用不需要审核,外部应用需要审核
			assignProcessState(process);
			// json定义转为bmmn2.0定义
			byte[] bpmnDef = DataTransformation.jsonToBpmn2(process.getJsonDef());
			process.setBpmnDef(new String(bpmnDef, UTF_8));
			// JSON转对象时,不能指定流程ID,在此赋值
			if (deps.size() > 0) {
				for (ProcessDependentEntity dep : deps) {
					dep.setProcessId(process.getProcessId());
					final Integer processId = process.getProcessId();
					if (dep.getDependentProcessId().equals(processId)) {
						modelMap.addAttribute(ERROR, "Dependence processId and the processId is the same,Process ID:" + processId);
						return new ModelAndView(new MappingJacksonJsonView(), modelMap);
					}
				}
			}
			if (isCreate) {
				processService.insertProcess(process);
				// 返回新建流程ID
				modelMap.addAttribute("processId", process.getProcessId());
				AuditLog.log(request.getSession(), "create new process with processid", String.valueOf(process.getProcessId()));
			} else {
				processService.updateProcess(process);
				AuditLog.log(request.getSession(), "modify process with processid", String.valueOf(process.getProcessId()));
			}
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			modelMap.addAttribute(ERROR, StringUtils.isNotEmpty(e.getMessage()) ? e.getMessage() : e.toString());
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		}
	}

	private String checkProcessVariables(ProcessEntity process) {
		Set<String> builtinvars = Sets.newHashSet("now", "year","month","weekOfMonth","weekOfYear","dayOfMonth","dayOfWeek") ;
		Set<String> unkonwnvars = null ;
		String jsondef = process.getJsonDef() ;
		Matcher matcher = DataTransformation.PROCESS_VARIABLE_PATTERN.matcher(jsondef);
		while (matcher.find()) {			
			String variableName = matcher.group(1);
			if ( !builtinvars.contains(variableName)){
				if ( unkonwnvars == null ){ 
					unkonwnvars =Sets.newHashSet() ;
				}
				unkonwnvars.add(variableName);
			}	
		}
		if( unkonwnvars != null ) {
			// parse appvars and process vars ;
			String processVariablesStr = process.getProcessVariables();
			String appVariablesStr = process.getAppVariables();

			String varStr = StringUtils.isNotEmpty(appVariablesStr) ? appVariablesStr : "" ;// 业务变量处理
		  		varStr += StringUtils.isNotEmpty(processVariablesStr) ? processVariablesStr : "" ;// 用户设置的流程变量处理
				
			if(StringUtils.isNotEmpty(varStr)){
				String[] vars = varStr.split(DataTransformation.VARIABLES_SPLIT);		
				// ${a}=1
				for (String var : vars) {
					String[] variable = var.split(DataTransformation.VARIABLE_NAME_VALUE_SPLIT);
					// 变更名,值
					String variableName = variable[0] ;
					// 解析{a}输入,获取变更名
					Matcher matcher1 = DataTransformation.VARIABLE_NAME_PATTERN.matcher(variable[0]);
					if (matcher1.find()) {
						variableName = matcher1.group(1);
					}					
					if ( variableName != null && unkonwnvars.contains(variableName) ){
						unkonwnvars.remove(variableName) ;  // remove process variables .
					}
				}
			}
		}
		if ( unkonwnvars != null && unkonwnvars.size() >0 ){
			// parse task defined vars .
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			JsonNode rootNode = null ;
			try{
				rootNode = objectMapper.readTree(jsondef);
			}catch(Exception e ){
				return e.getMessage() ;
			}
			JsonNode statesNode = rootNode.get(Constants.JBPM_STATES_NAME);
			for( JsonNode var : statesNode.findValues("out")){
				JsonNode varnamenode = var.get("value") ;
				String varname = varnamenode == null ? null : varnamenode.getTextValue() ;
				if ( varname != null) {
					// 解析{a}输入,获取变更名
					Matcher matcher1 = DataTransformation.VARIABLE_NAME_PATTERN.matcher(varname);
					String variableName = null;
					if (matcher1.find()) {
						variableName = matcher1.group(1);
					}
					if ( variableName != null &&  unkonwnvars.contains(variableName)) {
						unkonwnvars.remove(variableName) ;  // remove process variables .
					}
				}
			}		
		}
		return (unkonwnvars != null && unkonwnvars.size()> 0) ? StringUtils.join(unkonwnvars,","): null ;
	}

	/**
	 * 判断：内部应用不需要审核,外部应用需要审核
	 * 
	 * @param process
	 */
	private void assignProcessState(ProcessEntity process) {
		String processAppId = process.getProcessApp();
		Map<String, String> app = aplicationDao.getAppInfo(Integer.valueOf(processAppId));
		if (app == null) {
			throw new PriestPlatformException("The process's app doesn't exists!");
		}
//		String processState = "";
//		if ("N".equals(app.get("investigation"))) {
//			processState = ProcessStateEnum.N.name();
//		} else {
//			processState = ProcessStateEnum.I.name();
//		}
		process.setProcessState(ProcessStateEnum.N.name());
	}

	@RequestMapping(value = "updateState", method = RequestMethod.GET)
	public ModelAndView modState(HttpServletRequest request, Integer processId, String processState) {

		ModelMap modelMap = new ModelMap();
		try {
			processService.updateProcessState(processId, processState, request.getSession());
			AuditLog.log(request.getSession(), "processid",String.valueOf(processId),"update state to" ,processState);
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			modelMap.addAttribute(ERROR, e.getMessage());
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		}
	}

	@RequestMapping(value = "validateProcess", method = RequestMethod.POST)
	public ModelAndView validateProcess(HttpServletRequest request, Integer processId, String resultState, String investigationReason) {
		// 验证审核人身份
		ModelMap modelMap = new ModelMap();
		if (!Constants.USER_ADMIN.equals(AccessSession.getAccessUser(request.getSession()))) {
			modelMap.addAttribute(ERROR, "Only administrators can audit the process");
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		}
		// 通过审核
		try {
			processService.validateProcess(processId, resultState, investigationReason);
			AuditLog.log(request.getSession(), "processid",String.valueOf(processId),"validate result" ,resultState,investigationReason);
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			modelMap.addAttribute(ERROR, e.getMessage());
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		}
	}

	@RequestMapping(value = "retryProcess", method = RequestMethod.POST)
	public ModelAndView retryProcess(HttpServletRequest request, String processId, String execDate, String taskStatus) {
		String message = null;
		try {
			processManager.retryProcess(processId, execDate, taskStatus, request.getSession());
			AuditLog.log(request.getSession(), "retry process",String.valueOf(processId),execDate ,taskStatus);
			message = "Successfully";
		} catch (Exception e) {
			message = e.getMessage();
			logger.error(e.getMessage(), e);
		}
		
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute(Constants.RESPONSE_MESSAGES, message);
		return new ModelAndView(new MappingJacksonJsonView(), modelMap);
	}
	
	@RequestMapping(value = "rerunProcessFails", method = RequestMethod.POST)
	public ModelAndView rerunProcessFails(HttpServletRequest request, ProcessEntity param) {
		ModelMap modelMap = new ModelMap();
		try {
			String scheduleDateAsString = param.getScheduleDate();
			String execDateAsString = param.getExecDate();
			String processType = param.getProcessType();
			// 流程实例页面不显示补跑流程
			if (!ProcessTypeEnum.H.name().equals(processType)) {
				param.setProcessType(ProcessTypeEnum.N.name());
			}
			// 重跑流程按原来的调度日期显示,不根据重跑时的调度日期显示
			if (!StringUtils.isBlank(scheduleDateAsString) && StringUtils.isBlank(execDateAsString)) {
				String execDate = DateUtils.getExecDateFromScheduleDate(scheduleDateAsString);
				param.setExecDate(execDate);
				param.setScheduleDate(null);
			}
			if (CommUtils.isEmpty(scheduleDateAsString)) {
				String execDate = DateUtils.getExecDateFromScheduleDate(DateUtils.getDayNow());
				param.setExecDate(execDate);
				param.setScheduleDate(null);
			}
			List<ProcessEntity> processFails = processService.getProcessFails(param);
			if (processFails != null) {
				for (ProcessEntity pro: processFails) {
					try {
						scheduleService.rerunProcesses(pro.getProcessId(), pro.getExecDate());
						AuditLog.log(request.getSession(), "rerunProcesses",String.valueOf(pro.getProcessId()),pro.getExecDate());
					} catch (Exception e) {
						logger.error(e.getMessage(), e);
					}
				}
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			modelMap.addAttribute(ERROR, e.getMessage());
		}

		return new ModelAndView(new MappingJacksonJsonView(), modelMap);
	}

	@RequestMapping(value = "getProcessRuns", method = RequestMethod.POST)
	public ModelAndView getProcessRuns(HttpServletRequest request, ProcessEntity param, String isDrawing, String depth) {
		ModelMap modelMap = new ModelMap();
		String message = null;
		try {
			String scheduleDateAsString = param.getScheduleDate();
			String execDateAsString = param.getExecDate();
			String processType = param.getProcessType();
			// 流程实例页面不显示补跑流程
			if (!ProcessTypeEnum.H.name().equals(processType)) {
				param.setProcessType(ProcessTypeEnum.N.name());
			}
			// 重跑流程按原来的调度日期显示,不根据重跑时的调度日期显示
			if (!StringUtils.isBlank(scheduleDateAsString) && StringUtils.isBlank(execDateAsString)) {
				String execDate = DateUtils.getExecDateFromScheduleDate(scheduleDateAsString);
				param.setExecDate(execDate);
				param.setScheduleDate(null);
			}

			// 绘图页面取SVG数据,列表页面取分页数据
			if ("Y".equals(isDrawing)) {
				if (StringUtil.isValidate(param.getProcessId())) {
					int depthInt = CommUtils.parseInt(depth);
					modelMap.put("svgData", processDrawService.getSvgXml(request.getSession(),
							String.valueOf(param.getProcessId()), "", param.getProcessApp(), param.getScheduleDate(), true, depthInt > 0 ? depthInt:100));
				} else {
					List<ProcessEntity> processRuns = processService.getProcessRunsIncDepId(param);
					// 生成SVG文件,读取为XML字符串
					drawSVG(modelMap, processRuns);
				}
			} else {
				param.setPage(param.getPage());
				param.setRows(param.getRows());
				PagingResult<ProcessEntity> processRuns = processService.getProcessRuns(param);

				modelMap.put(Constants.RESPONSE_RESULT_TOTALPAGES, processRuns.getTotalPages());
				modelMap.put(Constants.RESPONSE_RESULT_CURRENTPAGE, processRuns.getPageNo());
				modelMap.put(Constants.RESPONSE_RESULT_TOTALRECORDS, processRuns.getTotalRecords());
				modelMap.addAttribute(Constants.RESPONSE_RESULT_COLLECTION, processRuns.getResults());
			}

		} catch (Exception e) {
			message = e.getMessage();
			logger.error(message, e);
			modelMap.addAttribute(ERROR, message);
		}

		return new ModelAndView(new MappingJacksonJsonView(), modelMap);
	}

	private void drawSVG(ModelMap modelMap, List<ProcessEntity> results) throws UnsupportedEncodingException {
		ProcessRunGraph processRunGraph = new ProcessRunGraph(
				ConfigUtil.getContextProperty("process.run.graph.height", "2000"), 
				ConfigUtil.getContextProperty("process.run.graph.width", "100"));
		String svgXML = processRunGraph.generateGraph(results);
		modelMap.put("svgData", svgXML);
	}

	@RequestMapping(value = "processExcel")
	public void processExcel(ProcessEntity param, HttpServletResponse response) throws IOException {
		// 指定下载的文件名
		response.setHeader(CONTENT_DISPOSITION, "filename=process" + param.getScheduleDate() + ".xls");
		response.setContentType("application/vnd.ms-excel");
		try {
			// 默认只有一页,页面绘制全部
			param.setPage(1);
			param.setRows(Integer.MAX_VALUE);

			processExcel.processexcel(response.getOutputStream(), param);
		} catch (SQLException e) {
			response.getWriter().print(e.toString());

		} catch (IOException e) {

			response.getWriter().print(e.toString());

		}

	}

	/**
	 * 流程实例重跑
	 * 
	 * @param processId
	 * @param execDate
	 * @return
	 */
	@RequestMapping(value = "rerunProcess", method = RequestMethod.POST)
	public ModelAndView rerunProcess(HttpServletRequest request, Integer processId, String execDate) {
		ModelMap modelMap = new ModelMap();
		try {
			scheduleService.rerunProcess(processId, execDate, request.getSession());
			AuditLog.log(request.getSession(), "rerunProcess",String.valueOf(processId),execDate);
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			modelMap.addAttribute(ERROR, StringUtils.isNotEmpty(e.getMessage()) ? e.getMessage() : e.toString());
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		}
	}

	/**
	 * 检查重跑流程是否为已修改流程
	 * 
	 * @param processId
	 * @param execDate
	 * @return
	 */
	@RequestMapping(value = "checkRerunProcess", method = RequestMethod.POST)
	public ModelAndView checkRerunProcess(HttpServletRequest request, Integer processId, String execDate) {
		ModelMap modelMap = new ModelMap();
		try {
			String scheduleDate = DateUtils.getNextDayAsString(execDate);
			if (!DateUtils.getDayNow().equals(scheduleDate)) {
				String updateDate = processService.getProcessDef(String.valueOf(processId)).getUpdatedDate();
				if (scheduleDate.compareTo(updateDate) < 0) {
					modelMap.addAttribute("suc", updateDate);
				}
			}
		} catch (Exception e) {}
		return new ModelAndView(new MappingJacksonJsonView(), modelMap);
	}
	
	/**
	 * 流程依赖实例重跑
	 * 
	 * @param processId
	 * @param execDate
	 * @return
	 */
	@RequestMapping(value = "rerunProcesses", method = RequestMethod.POST)
	public ModelAndView rerunProcesses(HttpServletRequest request, Integer processId, String execDate) {
		ModelMap modelMap = new ModelMap();
		try {
			scheduleService.rerunProcesses(processId, execDate);
			AuditLog.log(request.getSession(), "rerunProcesses",String.valueOf(processId),execDate);
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			modelMap.addAttribute(ERROR, StringUtils.isNotEmpty(e.getMessage()) ? e.getMessage() : e.toString());
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		}
	}

	/**
	 * 终止流程运行
	 * 
	 * @param processId
	 * @param execDate
	 * @return
	 */
	@RequestMapping(value = "abortProcess", method = RequestMethod.POST)
	public ModelAndView abortProcess(HttpServletRequest request, Integer processId, String execDate) {
		ModelMap modelMap = new ModelMap();
		try {
			String userName = AccessSession.getAccessUser(request.getSession()) ;

			// 设置上一次运行流程变量
			ProcessEntity processRun = processService.getProcessRun(processId, execDate);

			// 限定只能重试本人新增的流程
			if (!processRun.getCreatedBy().equals(userName)
				&& !Constants.USER_ADMIN.equals(AccessSession.getAccessUser(request.getSession()))) {
				throw new PriestPlatformException("Can't abort the process if U aren't the creator, the creator is:" + processRun.getCreatedBy());
			}

			// 限定只能kill 内存排队或者正在执行流程
			if (!"Q".equals(processRun.getProcessStatus()) && !"R".equals(processRun.getProcessStatus()) && !"W".equals(processRun.getProcessStatus())) {
				throw new PriestPlatformException("Only waiting,queuing or running Process can be aborted,The process status is:" + processRun.getProcessStatus());
			}
			Set<Integer> ids = new HashSet<Integer>();
			if ("W".equals(processRun.getProcessStatus())) {
				scheduleService.abortWaitProcess(processId, execDate, userName, ids);
			} else {
				scheduleService.abortRunningProcesses(processId, execDate, ids);
			}
			AuditLog.log(request.getSession(), "abortRunningProcesses",String.valueOf(processId),execDate);
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			modelMap.addAttribute(ERROR, StringUtils.isNotEmpty(e.getMessage()) ? e.getMessage() : e.toString());
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		}
	}
	
	/**
	 * 终止流程运行
	 * 
	 * @param processId
	 * @param execDate
	 * @return
	 */
	@RequestMapping(value = "getProcessChildrenIds", method = RequestMethod.POST)
	public ModelAndView getProcessChildrenIds(HttpServletRequest request, Integer processId) {
		ModelMap modelMap = new ModelMap();
		try {
			String ids = "";
			Set<Integer> proIds = scheduleService.getProcessChildrenIds(processId, 100);
			if (proIds != null && proIds.size() > 0) {
				int size = proIds.size();
				Integer[] processIds = proIds.toArray(new Integer[size]);
				
				if (size > 5) {
					for (int i = 0; i < 4; i++) {
						ids += processIds[i] + ",";
					}
					ids += processIds[4] + "...";
				} else {
					for (int i = 0; i < size - 1; i++) {
						ids += processIds[i] + ",";
					}
					ids += processIds[size -1];
				}
				modelMap.put("size", size);
			}
			modelMap.put("ids", ids);
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			modelMap.addAttribute(ERROR, StringUtils.isNotEmpty(e.getMessage()) ? e.getMessage() : e.toString());
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		}
	}

	/**
	 * 导出单个流程
	 * 
	 * @param response
	 * @param processId
	 * @throws IOException
	 */
	@RequestMapping(value = "exportProcess", method = RequestMethod.GET)
	public void exportProcess(HttpServletRequest request, HttpServletResponse response, String processId) {
		OutputStream toClient = null;
		// 2012-11-26 review IO代码异常概率比较高,异常后堆栈直接打印在前端,用户效果不好,建议放try块
		try {
			String userName = AccessSession.getAccessUser(request.getSession()) ;
			ProcessEntity processEntity = processService.getProcessDef(processId);
			if (null == processEntity) {
				throw new PriestPlatformException("Process  is NOT exist!");
			}
			String createdBy = processEntity.getCreatedBy();
			if (!userName.equals(createdBy)
					&& !Constants.USER_ADMIN.equals(AccessSession.getAccessUser(request.getSession()))
				) {
				throw new PriestPlatformException("Can't export the process if U aren't the creator, the creator is:" + createdBy);
			}
			// 流程压缩打包
			String zipFilePath = zipOperateOfProcessService.zipProcess(processEntity);
			File file = new File(zipFilePath);
			String fileName = file.getName().trim();
			toClient = new BufferedOutputStream(response.getOutputStream());
			response.setContentType("application/octet-stream");
			response.setCharacterEncoding(UTF_8);
			// 中文文件名乱码处理　
			// FireFOX
			if (request.getHeader("User-Agent").toUpperCase().indexOf("FIREFOX") > -1) {
				response.setHeader(CONTENT_DISPOSITION, ATTACHMENT_FILENAME
						+ new String((fileName + ZIP_SUFFIX).getBytes(UTF_8), "ISO8859-1"));
			}
			// IE与chrome
			else {
				response.setHeader(CONTENT_DISPOSITION, ATTACHMENT_FILENAME + java.net.URLEncoder.encode(fileName + ZIP_SUFFIX, UTF_8));
			}
			// 下载压缩包
			fileUploadService.downloadFile(toClient, zipFilePath);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			// modified by niexiaoming 2012-12-15 :修复出错时,错误信息未写入response
			// outputstream bug
			try {
				response.getWriter().write(e.getMessage());
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			}
		} finally {
			try {
				if (toClient != null) {
					toClient.close();
				}
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			}

		}
	}

	/**
	 * 导出依赖流程（多个）
	 * 
	 * @param request
	 * @param response
	 * @param processId
	 * @throws IOException
	 */
	@RequestMapping(value = "exportProcesses", method = RequestMethod.GET)
	public void exportProcesses(HttpServletRequest request, HttpServletResponse response, String processId) {
		OutputStream toClient = null;
		File file = null;
		try {
			String userName = AccessSession.getAccessUser(request.getSession()) ;
			ProcessEntity processEntity = processService.getProcessDef(processId);
			if (null == processEntity) {
				throw new PriestPlatformException("Process  is NOT exist!");
			}
			String createdBy = processEntity.getCreatedBy();
			if (!userName.equals(createdBy)
					&& !Constants.USER_ADMIN.equals(AccessSession.getAccessUser(request.getSession()))
				) {
				throw new PriestPlatformException("Can't export the process if U aren't the creator, the creator is:" + createdBy);
			}
			String zipFilePath = zipOperateOfProcessService.zipProcesses(processEntity);
			file = new File(zipFilePath);
			String fileName = file.getName();
			toClient = new BufferedOutputStream(response.getOutputStream());
			response.setContentType("application/octet-stream");
			response.setCharacterEncoding(UTF_8);
			// 中文文件名乱码处理
			// FireFOX
			if (request.getHeader("User-Agent").toUpperCase().indexOf("FIREFOX") > -1) {
				response.setHeader(CONTENT_DISPOSITION, ATTACHMENT_FILENAME
						+ new String((fileName + ZIP_SUFFIX).getBytes(UTF_8), "ISO8859-1"));
			}
			// IE与chrome
			else {
				response.setHeader(CONTENT_DISPOSITION, ATTACHMENT_FILENAME + java.net.URLEncoder.encode(fileName + ZIP_SUFFIX, UTF_8));
			}
			// 下载压缩包
			fileUploadService.downloadFile(toClient, zipFilePath);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);

			// modified by niexiaoming 2012-12-15 :修复出错时,错误信息未写入response
			// outputstream bug
			try {
				response.getWriter().write(e.getMessage());
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			}
		} finally {
			try {
				if (toClient != null) {
					toClient.close();
				}
				FileUtils.deleteQuietly(file);
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			}

		}
	}

	/**
	 * 导入流程
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "importProcess", method = RequestMethod.POST)
	public ModelAndView importProcess(HttpServletRequest request, HttpServletResponse response) {
		String userName = AccessSession.getAccessUser(request.getSession()) ;
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> files = multipartRequest.getFileMap();
		ModelMap modelMap = new ModelMap();
		List<Integer> processIds = new ArrayList<Integer>();
		try {
			// 逐个文件copy
			for (MultipartFile filePart : files.values()) {
				String fileName = fileUploadService.uploadTmpFile(filePart.getOriginalFilename(), filePart.getInputStream());
				if (zipOperateOfProcessService.isMultipleProcesses(fileName)) {
					List<ProcessEntity> processes = zipOperateOfProcessService.unzipProcesses(fileName);
					for (ProcessEntity process : processes) {
						process.setCreatedBy(userName);
						// json定义转为bmmn2.0定义
						byte[] bpmnDef = DataTransformation.jsonToBpmn2(process.getJsonDef());
						process.setBpmnDef(new String(bpmnDef, UTF_8));
						assignProcessState(process);
						processService.insertProcess(process);
						processIds.add(process.getProcessId());
					}
					// 返回导入流程的ID
					if (processIds.size() > 0) {
						modelMap.addAttribute("processIds", "ID: " + processIds);
					} else {
						modelMap.addAttribute(ERROR, "No process imported. Process with same name in this priest.");
					}
				} else {
					ProcessEntity process = zipOperateOfProcessService.unzipProcess(fileName);
					if (process == null) {
						modelMap.addAttribute(ERROR, "No process imported. Process with same name in this priest.");
					} else {
						process.setCreatedBy(userName);
						// json定义转为bmmn2.0定义
						byte[] bpmnDef = DataTransformation.jsonToBpmn2(process.getJsonDef());
						process.setBpmnDef(new String(bpmnDef, UTF_8));
						assignProcessState(process);
						processService.insertProcess(process);
						// 返回导入流程jsonDef
						modelMap.addAttribute("processJsonDef", process.getJsonDef());
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			modelMap.addAttribute(ERROR, e.getMessage());
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		}
		return new ModelAndView(new MappingJacksonJsonView(), modelMap);
	}

	/**
	 * 补跑历史数据
	 * 
	 * @param processId
	 * @param startDataDate
	 * @param endDataDate
	 * @param dFlagState
	 * @return
	 */
	@RequestMapping(value = "historyRunProcesses", method = RequestMethod.POST)
	public ModelAndView historyRunProcesses(HttpServletRequest request, Integer processId, String startDataDate, String endDataDate, String dFlagState) {
		ModelMap modelMap = new ModelMap();
		try {
			String userName = AccessSession.getAccessUser(request.getSession()) ;
			ProcessEntity toRunProcess = processService.getProcessDef(String.valueOf(processId));
			if (toRunProcess == null) {
				throw new PriestPlatformException("Can't find the process. Process ID:" + processId);
			}
			if (!toRunProcess.getCreatedBy().equals(userName)
				 && !Constants.USER_ADMIN.equals(AccessSession.getAccessUser(request.getSession()))) {
				throw new PriestPlatformException("Can't rerun history of the process if U aren't the creator, the creator is:" + toRunProcess.getCreatedBy() + "!");
			}
					
			Date startDateOfData = DateUtils.parseString2Date(startDataDate, DateUtils.getDateDayFormat());
			Date endDateOfData = DateUtils.parseString2Date(endDataDate, DateUtils.getDateDayFormat());
			if (startDateOfData.after(endDateOfData)) {
				throw new PriestPlatformException("StartDate can't be later than endDate!");
			}
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DAY_OF_YEAR, -1);
			Date yesterday = cal.getTime();

			if (startDateOfData.after(yesterday) || endDateOfData.after(yesterday)) {
				throw new PriestPlatformException("StartDate and EndDate should be before today!");
			}
			scheduleService.historyRunProcesses(processId, startDataDate, endDataDate, dFlagState);
			AuditLog.log(request.getSession(), "historyRunProcesses",String.valueOf(processId),startDataDate, endDataDate, dFlagState);
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			modelMap.addAttribute(ERROR, StringUtils.isNotEmpty(e.getMessage()) ? e.getMessage() : e.toString());
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		}
	}

	/**
	 * 取消补跑
	 * 
	 * @param processId
	 * @param startDataDate
	 * @param endDataDate
	 * @return
	 */
	@RequestMapping(value = "historyCancelProcesses", method = RequestMethod.POST)
	public ModelAndView historyCancelProcesses(HttpServletRequest request, Integer processId, String startDataDate, String endDataDate) {
		ModelMap modelMap = new ModelMap();
		try {
			String userName = AccessSession.getAccessUser(request.getSession()) ;
			ProcessEntity toRunProcess = processService.getProcessDef(String.valueOf(processId));
			if (toRunProcess == null) {
				throw new PriestPlatformException("Can't find the process. Process ID:" + processId);
			}
			if (!toRunProcess.getCreatedBy().equals(userName)
				 && !Constants.USER_ADMIN.equals(AccessSession.getAccessUser(request.getSession()))) {
				throw new PriestPlatformException("Can't Cancel the process if U aren't the creator, the creator is:" + toRunProcess.getCreatedBy() + "!");
			}
			scheduleService.historyCancelProcesses(processId, startDataDate, endDataDate, userName);
			AuditLog.log(request.getSession(), "historyCancelProcesses",String.valueOf(processId),startDataDate, endDataDate);
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			modelMap.addAttribute(ERROR, StringUtils.isNotEmpty(e.getMessage()) ? e.getMessage() : e.toString());
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		}
	}

	@RequestMapping(value = "getHistoryRuns", method = RequestMethod.POST)
	public ModelAndView getHistoryRuns(ProcessEntity param) {
		ModelMap modelMap = new ModelMap();
		String message = null;
		try {
			String scheduleDateAsString = param.getScheduleDate();
			String execDateAsString = param.getExecDate();
			param.setProcessType(ProcessTypeEnum.H.name());
			// 重跑流程按原来的调度日期显示,不根据重跑时的调度日期显示
			if (!StringUtils.isBlank(scheduleDateAsString) && StringUtils.isBlank(execDateAsString)) {
				String execDate = DateUtils.getExecDateFromScheduleDate(scheduleDateAsString);
				param.setExecDate(execDate);
				param.setScheduleDate(null);
			}
			// 默认只有一页,页面绘制全部
			param.setPage(1);
			param.setRows(Integer.MAX_VALUE);
			// 固定写死1页
			modelMap.put(Constants.RESPONSE_RESULT_TOTALPAGES, 1);
			modelMap.put(Constants.RESPONSE_RESULT_CURRENTPAGE, 1);
			List<ProcessEntity> results = processService.getProcessRunsIncDepId(param);
			// 结果去重返回到前端
			Set<ProcessEntity> resultSet = new LinkedHashSet<ProcessEntity>(results);
			modelMap.put(Constants.RESPONSE_RESULT_TOTALRECORDS, resultSet.size());
			modelMap.addAttribute(Constants.RESPONSE_RESULT_COLLECTION, resultSet);
			// 生成SVG文件,读取为XML字符串
			drawSVG(modelMap, results);
		} catch (Exception e) {
			message = e.getMessage();
			logger.error(message, e);
			modelMap.addAttribute(ERROR, message);
		}

		return new ModelAndView(new MappingJacksonJsonView(), modelMap);
	}

	@RequestMapping(value = "checkSql", method = RequestMethod.POST)
	public ModelAndView checkSQL(HttpServletRequest request, String sqlType, String sql) {
		// 获取操作用户
		boolean isAdmin = Constants.USER_ADMIN.equals(AccessSession.getAccessUser(request.getSession()));
		ModelMap modelMap = null;
		sql = StringUtil.replaceSemicolon(sql);
		if ("msql".equals(sqlType)) {
			modelMap = processService.checkMysqlGrammar(sql, isAdmin);
		} else if ("hsql".equals(sqlType)) {
			modelMap = processService.checkHiveGrammar(sql, isAdmin);
		} else if ("ssql".equals(sqlType)) {
			modelMap = processService.checkSparkGrammar(sql, isAdmin);
		}

		return new ModelAndView(new MappingJacksonJsonView(), modelMap);
	}

	@RequestMapping(value = "getRunTimeHistory", method = RequestMethod.POST)
	public ModelAndView getRunTimeHistory(String processId, String startScheduleDate, String endScheduleDate) {
		List<ProcessEntity> runTimeHistory = processService.getRunTimeHistory(processId, startScheduleDate, endScheduleDate);

		// 将历史数据转化为横坐标和纵坐标列表
		List<String> xAxisList = new ArrayList<String>();
		List<Integer> yAxisList = new ArrayList<Integer>();
		// 列表按调度时间逆序排序,曲线图按调度时间正序排序
		LinkedList<ProcessEntity> reversedList = new LinkedList<ProcessEntity>(runTimeHistory);
		Collections.reverse(reversedList);
		for (ProcessEntity entity : reversedList) {
			xAxisList.add(entity.getScheduleDate());
			yAxisList.add(entity.getIntRunTime());
		}

		ModelMap model = new ModelMap();
		model.addAttribute(Constants.RESPONSE_RESULT_COLLECTION, runTimeHistory);
		model.addAttribute("scheduleDateList", xAxisList);
		model.addAttribute("runTimeList", yAxisList);

		return new ModelAndView(new MappingJacksonJsonView(), model);
	}

	@RequestMapping(value = "downProcessErrLog")
	public void downProcessErrLog(String errFileName, HttpServletResponse response) throws IOException {
		response.setHeader(CONTENT_DISPOSITION, "filename=" + errFileName);
		response.setContentType("application/x-msdownload");

		response.getWriter().write(processService.downProcessErrLog(errFileName));
	}

	/**
	 * 流程依赖实例重跑
	 * 
	 * @param processId
	 * @param execDate
	 * @return
	 */
	@RequestMapping(value = "getRunningLog", method = RequestMethod.POST)
	public ModelAndView getRunningLog(HttpServletRequest request, Integer processId, Integer taskId, String execDate, String jobId) {
		ModelMap modelMap = new ModelMap();
		try {
			if ("sparksql".equals(jobId)) {
				StringBuffer key = new StringBuffer(Constants.SPARK_LOG_LABEL).append(Constants.PROCESS_CONNECTOR).append(processId)
						.append(Constants.PROCESS_CONNECTOR).append(execDate).append(Constants.PROCESS_CONNECTOR).append(taskId),
						logs = new StringBuffer("");
				
				String sessionId = manager.get(key.toString());
				sessionId = manager.get(sessionId);
				Set<String> jobNums = manager.smembers(sessionId + "-job-set");
				for(String jobNum: jobNums) {
					for (String log: manager.lrange(sessionId + "-log-" + jobNum)) {
						logs.append(log + "<br>");
					}
				}
				
				modelMap.put("logs", StringUtil.isEmpty(logs.toString()) ? "No realtime log!":logs.toString());
			} else {
				StringBuffer key = new StringBuffer(Constants.TASK_LOG_LABEL).append(Constants.PROCESS_CONNECTOR).append(processId)
						.append(Constants.PROCESS_CONNECTOR).append(execDate).append(Constants.PROCESS_CONNECTOR).append(taskId);
				String logs = manager.get(key.toString());
				
				modelMap.put("logs", StringUtil.isEmpty(logs) ? "No realtime log!":logs.replaceAll("\n", "<br>"));
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			modelMap.addAttribute(ERROR, StringUtils.isNotEmpty(e.getMessage()) ? e.getMessage() : e.toString());
		}
		return new ModelAndView(new MappingJacksonJsonView(), modelMap);
	}
}
