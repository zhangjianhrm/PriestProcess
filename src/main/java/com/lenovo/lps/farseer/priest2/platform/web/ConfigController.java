package com.lenovo.lps.farseer.priest2.platform.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.lenovo.lps.farseer.priest2.common.util.AuditLog;
import com.lenovo.lps.farseer.priest2.platform.dal.ApplicationDao;
import com.lenovo.lps.farseer.priest2.platform.entity.AppEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.DbEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.DbTypeEnum;
import com.lenovo.lps.farseer.priest2.platform.entity.SysConfigEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.SysConfigTypeEnum;
import com.lenovo.lps.farseer.priest2.platform.entity.SysMapEntity;
import com.lenovo.lps.farseer.priest2.platform.entity.ThreadPoolEntity;
import com.lenovo.lps.farseer.priest2.platform.service.ApplicationService;
import com.lenovo.lps.farseer.priest2.platform.service.FileUploadService;
import com.lenovo.lps.farseer.priest2.platform.service.ScheduleService;
import com.lenovo.lps.farseer.priest2.platform.util.Constants;
import com.lenovo.lps.farseer.priest2.platform.util.FileUtils;

/**
 * 获取应用配制
 * 
 * @author niexm1
 * 
 */
@Controller
@RequestMapping("/config")
public class ConfigController {
	private final Logger logger = Logger.getLogger(ConfigController.class);

	@Resource
	private FileUploadService fileUploadService;

	@Autowired
	private ApplicationService appService;

	@Autowired
	private ApplicationDao aplicationDao;

	@Autowired
	private ScheduleService scheduleService;

	@RequestMapping(value = "getApps", method = RequestMethod.GET)
	public ModelAndView getApps(HttpServletRequest request) {
		ModelMap modelMap = new ModelMap();
		try {
			List<Map<String, String>> apps = appService.selectApp(request.getSession());

			modelMap.addAttribute(Constants.CONFIG_RET_KEY, apps);
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			modelMap.addAttribute("err", e.getMessage());
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		}
	}

	@RequestMapping(value = "uploadJar", method = RequestMethod.POST)
	public ModelAndView uploadJar(HttpServletRequest request, HttpServletResponse response) {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> files = multipartRequest.getFileMap();

		ModelMap modelMap = new ModelMap();

		List<String> fileNames = new ArrayList<String>();
		try {
			// 逐个文件copy
			for (MultipartFile filePart : files.values()) {
				String fileName = fileUploadService.uploadFile(filePart.getOriginalFilename(), filePart.getInputStream());
				fileNames.add(fileName);
			}
		} catch (Exception e) {
			modelMap.addAttribute("err", e.getMessage());
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		}

		modelMap.addAttribute(Constants.CONFIG_RET_KEY, fileNames);
		return new ModelAndView(new MappingJacksonJsonView(), modelMap);
	}

	@RequestMapping(value = "getAppVars", method = RequestMethod.GET)
	public ModelAndView getAppVars(Integer appId) {
		ModelMap modelMap = new ModelMap();
		try {
			Map<String, String> appInfo = aplicationDao.getAppInfo(appId);
			modelMap.addAttribute("appVars", appInfo.get("appVariables"));
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		} catch (Exception e) {
			modelMap.addAttribute("err", e.getMessage());
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		}
	}

	@RequestMapping(value = "getAppInfos", method = RequestMethod.POST)
	public ModelAndView getAppInfos(AppEntity entity) {
		ModelMap model = new ModelMap();
		try {
			List<AppEntity> apps = appService.getAppInfos(entity);
			model.addAttribute(Constants.RESPONSE_RESULT_COLLECTION, apps);
			return new ModelAndView(new MappingJacksonJsonView(), model);
		} catch (Exception e) {
			model.addAttribute("err", e.getMessage());
			return new ModelAndView(new MappingJacksonJsonView(), model);
		}
	}

	@RequestMapping(value = "addAppInfo", method = RequestMethod.POST)
	public ModelAndView addAppInfo(HttpServletRequest request, AppEntity entity) {
		ModelMap modelMap = new ModelMap();
		try {
			appService.addAppInfo(entity);
			AuditLog.log(request.getSession(), "addAppInfo",entity.toString());
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		} catch (Exception e) {
			modelMap.addAttribute("err", e.getMessage());
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		}
	}

	@RequestMapping(value = "updateAppInfo", method = RequestMethod.POST)
	public ModelAndView updateAppInfo(HttpServletRequest request, AppEntity entity) {
		ModelMap modelMap = new ModelMap();

		try {
			appService.updateAppInfo(entity);
			AuditLog.log(request.getSession(), "updateAppInfo",entity.toString());
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		} catch (Exception e) {
			modelMap.addAttribute("err", e.getMessage());
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		}
	}

	@RequestMapping(value = "getDatabases", method = RequestMethod.POST)
	public ModelAndView getDatabases(HttpServletRequest request, DbEntity entity) {
		ModelMap modelMap = new ModelMap();
		try {
			List<DbEntity> dbs = appService.getDatabases(entity);
			modelMap.addAttribute(Constants.RESPONSE_RESULT_COLLECTION, dbs);
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		} catch (Exception e) {
			modelMap.addAttribute("err", e.getMessage());
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		}
	}

	@RequestMapping(value = "addDatabase", method = RequestMethod.POST)
	public ModelAndView addDataBase(HttpServletRequest request, DbEntity entity) {
		ModelMap modelMap = new ModelMap();
		try {

			DbTypeEnum dbType = DbTypeEnum.fromValue(Integer.valueOf(entity.getDbType()));
			switch (dbType) {
			case MySQL:
				entity.setDriverClassName("com.mysql.jdbc.Driver");
				break;
			case Oracle:
				entity.setDriverClassName("oracle.jdbc.OracleDriver");
				break;
			}

			appService.addDatabase(entity);
			AuditLog.log(request.getSession(), "addDatabase",entity.toString());
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		} catch (Exception e) {
			logger.error("add database error:", e);
			modelMap.addAttribute("err", e.getMessage());
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		}
	}

	@RequestMapping(value = "updateDatabase", method = RequestMethod.POST)
	public ModelAndView updateDatabase(HttpServletRequest request, DbEntity entity) {
		ModelMap modelMap = new ModelMap();
		try {
			appService.updateDatabase(entity);
			AuditLog.log(request.getSession(), "addDatabase",entity.toString());
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		} catch (Exception e) {
			modelMap.addAttribute("err", e.getMessage());
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		}
	}

	@RequestMapping(value = "getAppDbNames", method = RequestMethod.GET)
	public ModelAndView getAppDbNames(Integer appId, Integer dbType) {
		ModelMap modelMap = new ModelMap();
		try {
			List<Map<String, String>> dbNames = appService.getAppDbNames(appId, DbTypeEnum.fromValue(dbType));
			modelMap.addAttribute(Constants.CONFIG_RET_KEY, dbNames);
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		} catch (Exception e) {
			modelMap.addAttribute("err", e.getMessage());
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		}
	}

	/**
	 * 获取系统调度线程池
	 * @return
	 */
	@RequestMapping(value = "gotoAppManage", method = RequestMethod.GET)
	public ModelAndView getThreadPools() {
		ModelMap modelMap = new ModelMap();
		try {
			List<ThreadPoolEntity> threadPools = appService.getThreadPoolCached();
			modelMap.addAttribute(Constants.CONFIG_RET_KEY, threadPools);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			modelMap.addAttribute("err", e.getMessage());
		}
		
		return new ModelAndView("app_manage", modelMap);
	}
	
	
	@RequestMapping(value = "getSysConfig", method = RequestMethod.POST)
	public ModelAndView getSysConfig(SysConfigEntity entity) {
		ModelMap model = new ModelMap();
		try {
			List<SysConfigEntity> apps = aplicationDao.getSysConfig(entity);
			model.addAttribute(Constants.RESPONSE_RESULT_COLLECTION, apps);
			return new ModelAndView(new MappingJacksonJsonView(), model);
		} catch (Exception e) {
			model.addAttribute("err", e.getMessage());
			return new ModelAndView(new MappingJacksonJsonView(), model);
		}
	}

	@RequestMapping(value = "addSysConfig", method = RequestMethod.POST)
	public ModelAndView addSysConfig(HttpServletRequest request, SysConfigEntity entity) {
		ModelMap modelMap = new ModelMap();
		try {
			SysConfigTypeEnum type = SysConfigTypeEnum.fromValue(Integer.valueOf(entity.getType()));
			switch (type) {
				case HIVE:
					entity.setTarget("org.apache.hive.jdbc.HiveDriver");
					break;
				case SPARK:
					entity.setTarget("org.apache.hive.jdbc.HiveDriver");
					break;
				case REDIS:
					Pattern pattern = Pattern.compile("^[0-9:\\.;]+$");
					Matcher m = pattern.matcher(entity.getUrl());
					if (!m.find()) {
						modelMap.addAttribute("err", "redis should be like format(ip:port;ip:port;...)");
						return new ModelAndView(new MappingJacksonJsonView(), modelMap);
					}
					break;
				default:
					break;
			}
			
			int priority = aplicationDao.getMaxPriority(entity);
			if (priority < 1) {
				priority = 1;
			} else {
				priority++;
			}
			 entity.setPriority(priority);
			aplicationDao.addSysConfig(entity);
			AuditLog.log(request.getSession(), "addSysConfig",entity.toString());
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		} catch (Exception e) {
			modelMap.addAttribute("err", e.getMessage());
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		}
	}

	@RequestMapping(value = "updateSysConfig", method = RequestMethod.POST)
	public ModelAndView updateSysConfig(HttpServletRequest request, SysConfigEntity entity) {
		ModelMap modelMap = new ModelMap();
		try {
			aplicationDao.addSysConfig(entity);
			AuditLog.log(request.getSession(), "updateSysConfig",entity.toString());
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		} catch (Exception e) {
			modelMap.addAttribute("err", e.getMessage());
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		}
	}
	
	@RequestMapping(value = "delSysConfig", method = RequestMethod.POST)
	public ModelAndView delSysConfig(HttpServletRequest request, SysConfigEntity entity) {
		ModelMap modelMap = new ModelMap();
		try {
			aplicationDao.delSysConfig(entity);
			AuditLog.log(request.getSession(), "delSysConfig",entity.toString());
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		} catch (Exception e) {
			modelMap.addAttribute("err", e.getMessage());
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		}
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "addSysMap", method = RequestMethod.POST)
	public ModelAndView addSysMap(HttpServletRequest request, String keys) {
		ModelMap modelMap = new ModelMap();
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			Map<String, String> entitys = mapper.readValue(keys, Map.class);
			request.getParameter("entitys");
			for (Entry<String, String> entity: entitys.entrySet()) {
				aplicationDao.addSysMap(entity.getKey(), entity.getValue());
			}
			aplicationDao.updateSysMap();
			AuditLog.log(request.getSession(), "addSysMap", entitys.toString());
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		} catch (Exception e) {
			modelMap.addAttribute("err", e.getMessage());
			return new ModelAndView(new MappingJacksonJsonView(), modelMap);
		}
	}
	
	@RequestMapping(value = "getSysMap", method = RequestMethod.POST)
	public ModelAndView getSysConfig(String key) {
		ModelMap model = new ModelMap();
		try {
			Map<String, String> keys = new HashMap<String, String>();
			List<SysMapEntity> sysMaps = aplicationDao.getSysMap(key);
			if (sysMaps != null && sysMaps.size() > 0) {
				for (SysMapEntity sysMap: sysMaps) {
					keys.put(sysMap.getKey(), sysMap.getValue());
				}
			}
			if (keys.get("hadoop.config.path") == null) {
				keys.put("hadoop.config.path", "/etc/hadoop/conf");
			}
			if (keys.get("hadoop.lib.path") == null) {
				keys.put("hadoop.lib.path", FileUtils.getClassFilePath("../lib_hadoop_ext"));
			}
			if (keys.get("hive.lib.path") == null) {
				keys.put("hive.lib.path", FileUtils.getClassFilePath("../lib_hive_ext"));
			}
			model.addAttribute(Constants.RESPONSE_RESULT_COLLECTION, keys);
			return new ModelAndView(new MappingJacksonJsonView(), model);
		} catch (Exception e) {
			model.addAttribute("err", e.getMessage());
			return new ModelAndView(new MappingJacksonJsonView(), model);
		}
	}
}
