<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用戶登錄</title>
<link rel="stylesheet" type="text/css" href="${path}/ui/jquery-easyui-1.4.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${path}/ui/jquery-easyui-1.4.3/themes/icon.css">
<script type="text/javascript" src="${path}/ui/jquery-easyui-1.4.3/jquery.min.js"></script>
<script type="text/javascript" src="${path}/ui/jquery-easyui-1.4.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${path}/ui/jquery-easyui-1.4.3/locale/easyui-lang-zh_TW.js"></script>
<script type="text/javascript" src="${path}/ui/js/md5.js"></script>

<script type="text/javascript">
	$(function() {
		$("body").layout();
		
		$("#loginWindow").window({
			title : "黃石ERP系統",
			width : 300,
			height : 230,
			collapsible : false,
			minimizable : false,
			maximizable : false,
			closable : false
		});
		$("#loginWindow").window("open");
	});
</script>

</head>
<body class="easyui-layout">
	<div id="loginWindow">
		<div style="text-align:center;">
			提示信息
		</div>
		<form id="form" name="form" method="post" action="${path}/sys/login.do">
			<div style="padding:20px">
				<table id="table">
			        <tr>
			        	<td style="width:60px;">用戶名：</td>
			            <td><input id="su_code" name="su_code" class="easyui-textbox" type="text" style="width:180px;" /></td>
			        </tr>
			        <tr>
			        	<td style="width:60px;">密&nbsp;&nbsp;&nbsp;碼：</td>
			            <td><input id="su_password" name="su_password" class="easyui-textbox" type="password" style="width:180px;" /></td>
			        </tr>
			    </table>
		    </div>
		    <div style="text-align:center;padding:5px">
		    	<a href="javascript:void(0)" class="easyui-linkbutton" style="width:100px;" onclick="">登錄</a>
		    	<a href="javascript:void(0)" class="easyui-linkbutton" style="width:100px;" onclick="">重置</a>
		    </div>
		</form>
	</div>
</body>
</html>