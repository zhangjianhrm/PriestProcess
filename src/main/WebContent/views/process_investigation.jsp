<%@page contentType = "text/html;charset=UTF-8" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html >
<style type="text/css">
body{ overflow-x:hidden;overflow-y:hidden; }
</style>
<%@include file="common/header.jsp"%> 
<body>
	
	<div class="wrap">
		<div class="rightBox">
			<div class="content">
				<!-- 页面主体开始 -->
				<div id="contentDiv" style="align: center; vertical-align: middle;">
					<div class="commonTitle">
					  <h2>流程变更审核</h2>
					</div>
					<br/>
					<br/>
					<dl>
						<dt>审核通过：<input type="radio" value="N" id="N" name="result" />&nbsp; &nbsp;审核不通过：<input type="radio" value="R" id="R" name="result" /></dt>
					</dl>	
                   	
                   	<br/>			
					<dl>
						<dt>审核意见：</dt>
						<dd>
							<textarea cols=115 rows="10" id="reason" name="reason"></textarea>
						</dd>
					</dl>																
					<div class="search-btn">
						<span class="btn btn-ok"  ><input type="button" onclick="validateInvestigation();" value="确定"  style="position: absolute;left:250px"></span>
					</div>					
				</div>
				<!-- 页面主体结束 -->
			</div>
		</div>
		<!-- 页脚开始 -->
		<%@include file="common/footer.jsp"%>
		<!-- 页脚结束 -->
	</div>
</body>
<script type="text/javascript">
	
	function validateInvestigation(){
		var processId = window.dialogArguments;
		var investigationReason = document.getElementById('reason').value;
		var resultState = '';
		var result=document.getElementsByName("result");
		  for(var i=0;i<result.length;i++){
			  if(result.item(i).checked){
				  resultState=result.item(i).getAttribute("value");
				  break;
				  }
		  }
		if (resultState == ''){
			alert("请选择流程审核结果!");
			return false;
		}  
		//请求地址
		$.ajax({
			type : "post",
			url : "<%=request.getContextPath()%>/process/validateProcess.do",
			async : true,
			data : {
				processId : processId,
				investigationReason      : investigationReason,
				resultState    : resultState
			},
			dataType : 'json',
			success : function(ret) {
				if (ret.err) {
					alert(ret.err);
				} else {
					alert("提交成功");
					window.close();
				}
					
			},
			error : function() {
				// 出错提示
				alert('System error!');
			}
		}); 	
		//防止事件向上冒
		return false;
	}
</script>
</html>