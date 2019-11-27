<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/head.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>">

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>华西云采平台一级采购公开招标各项目开标时间公示栏</title>


	<!-- Bootstrap 3.3.7 -->
	<link rel="stylesheet" href="statics/js/adminLTE/AdminLTE/bower_components/bootstrap/dist/css/bootstrap.min.css">
	<!-- Font Awesome -->
	<link rel="stylesheet" href="statics/js/adminLTE/AdminLTE/bower_components/font-awesome/css/font-awesome.min.css">
	<!-- Ionicons -->
	<link rel="stylesheet" href="statics/js/adminLTE/AdminLTE/bower_components/Ionicons/css/ionicons.min.css">
	<!-- DataTables -->
	<link rel="stylesheet" href="statics/js/adminLTE/AdminLTE/bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">
	<!-- Theme style -->
	<link rel="stylesheet" href="statics/js/adminLTE/AdminLTE/dist/css/AdminLTE.min.css">
	<!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
	<link rel="stylesheet" href="statics/js/adminLTE/AdminLTE/dist/css/skins/_all-skins.min.css">

	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->

	<!-- Google Font -->
	<link rel="stylesheet"
		  href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
	<style type="text/css">
		table{
			table-layout:fixed;

		}
		th, td {
			word-break: keep-all;
			white-space: nowrap;
			overflow: hidden;
			text-overflow: ellipsis;
			-moz-text-overflow: ellipsis;
		}

		th,td { text-align: center; vertical-align: middle!important; }
	</style>
</head>

<body class="hold-transition skin-blue sidebar-mini">

	<div  >

		<!-- Main content -->
		<section class="content">
			<div class="row">
				<div class="col-xs-12">


					<div class="box" style="border: 0px;">

						<div align="center" style="color: #009688;"><h3>——&nbsp; &nbsp; &nbsp; 华西云采平台一级采购公开招标各项目开标时间公示栏&nbsp; &nbsp; &nbsp; ——</h3><br></div>
						<div class="box-header" align="right">


							开标时间：<input id='openTenderTime' type='text' placeholder="开标时间" onClick='WdatePicker()' style='width: 110px;'/>
							&nbsp;&nbsp;&nbsp;&nbsp;<button class="btn btn-info" id="selectLedger"  onclick="select()">查询</button>
							<%--<button class="btn btn-primary" id ="export" audit="4">excel导出</button>--%>


						</div>

						<!-- /.box-header -->
						<div class="box-body">
							<table   id="dt_travel_list" class="table table-bordered table-striped" >
								<thead>
								    <tr style="color: #009688;">
										<th colspan="3" align="center"  id="weekTitle">本周开标项目</th>
										<th colspan="3" align="center"  id="nextWeekTitle">下周开标项目</th>
									</tr>
									<tr>
 										<th style="width: 20px">公司名称</th>
										<th style="width: 400px">项目名称</th>
										<th style="width: 60px">开标时间</th>
 										<th style="width: 20px">公司名称</th>
										<th style="width: 400px">项目名称</th>
										<th style="width: 60px">开标时间</th>

 									</tr>
								</thead>
								<tbody></tbody>

							</table>

						</div>
						<!-- /.box-body -->
					</div>
					<!-- /.box -->
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</section>
		<!-- /.content -->
	</div>



<!-- jQuery 3 -->
<script src="statics/js/adminLTE/AdminLTE/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="statics/js/adminLTE/AdminLTE/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- DataTables -->
<script src="statics/js/adminLTE/AdminLTE/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="statics/js/adminLTE/AdminLTE/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<!-- SlimScroll -->
<script src="statics/js/adminLTE/AdminLTE/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="statics/js/adminLTE/AdminLTE/bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="statics/js/adminLTE/AdminLTE/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="statics/js/adminLTE/AdminLTE/dist/js/demo.js"></script>

<script type="text/javascript" src="statics/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="statics/js/bidBond.js"></script>
<script type="text/javascript" src="statics/js/date.js"></script>

<!-- page script -->
<script>



$(function(){
    selectBond();
});

function select(){
    var datatable = $("#dt_travel_list").dataTable();
     if (datatable) {
        datatable.fnClearTable();    //清空数据
        datatable.fnDestroy();         //销毁datatable
    }

    $("#dt_travel_list tbody").html("");
    selectBond();
}



</script>
</body>




</html>