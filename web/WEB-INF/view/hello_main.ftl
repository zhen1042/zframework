<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查詢列表</title>
<#include "/WEB-INF/view/linkScript.ftl"/>

<script type="text/javascript">
	$(function() {
		$("body").layout();
		
		$("#table").datagrid({
			url : "${path}/hello_page.do",
			sortName:"sl_id",    
            sortOrder:"asc",
			pageNumber : 1,
			pageSize : 20,
			queryParams:{"refresh":"1"},
			columns : [[
				{field : "sl_id", title : "主鍵", width : 130},
				{field : "sl_user_code", title : "用戶號碼", width : 130},
				{field : "sl_user_name", title : "用戶名", width : 130},
				{field : "sl_date", title : "時間", width : 130},
			]]
		});
	});
</script>

</head>
<body class="easyui-layout">
	<div region="center" title="当前位置：系统日志管理">
		<table id="table"
	           border="false"       <#--无边框-->
	           fit="true"           <#--自动填充宽度高度-->
	           singleSelect="false" <#--单选模式-->
	           pagination="true"    <#--是否显示翻页导航-->
	           rownumbers="true"    <#--是否显示行号-->
	           striped="true"       <#--奇偶行颜色交错-->
	           <#-- idField="sl_id"   主键字段-->
	           nowrap="true"        <#--单元格数据不换行-->
	           >
	    </table>
    </div>
</body>
</html>