<%@ include file="/WEB-INF/pages/includes/header.jsp"%>
<%@ include file="/WEB-INF/pages/includes/nav.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<style>
input[type="text"] {
	border-top: 0;
	border-right: 0;
	border-left: 0;
	border-radius: 0;
	-webkit-box-shadow: none;
	box-shadow: none;
	font-size: 14px;
	size: 6;
}

input[type="text"]:focus {
	-webkit-box-shadow: none;
	box-shadow: none;
}

th {
	font-size: 11px;
	color: red;
}

input[type="text"]:disabled {
	background: white;
	border: 0px;
}

.vform {
	padding: 15px;
	margin-top: 25px;
}

.error {
	padding: 4px;
	color: red;
}
</style>

<div class="container" id="dashboardcontainer">

	<div class="row">
		<div class="col-lg-3"></div>
		<div class="col-lg-6">
			<c:if test="${not empty message }">
				<div class="col-md-4 pull-right">
					<div class="alert alert-dismissible alert-success">
						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<c:out value="${message}"></c:out>

					</div>
				</div>
			</c:if>
			<input type="text" id="classId" value="${studentClass.classId}"
				readonly="true" hidden> <input type="text" id="examId"
				value="${exam.examId}" readonly="true" hidden>
			<legend style="color: red">
				<i class="fa fa-money" aria-hidden="true"></i> Billing <b
					class="pull-right" style="color: #d9534f;"> ${exam.examName} |
					Grade: ${studentClass.className } </b>
			</legend>

			<table id="mytable" class="table table-bordered table-hover">
				<thead>
					<tr>
						<th class="col-xs-8">Student Name</th>
						<th class="col-xs-2">Roll</th>
						<th>Action</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="strow" items="${studentList}">
						<tr>
							<td>${strow.firstName}${strow.lastName}</td>
							<td>${strow.roll}</td>
							<td><a
								href="${pageContext.request.contextPath }/fee/bill?classId=${studentClass.classId}&studentId=${strow.studentId }"
								class="btn btn-danger 	glyphicon glyphicon-edit"> Bill
							</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<br> <br>
	<div class="pull-right">
		<a href="${pageContext.request.contextPath }/fee/"
			class="btn btn-danger glyphicon glyphicon-arrow-left  "> Back </a>
	</div>
	<p></p>
</div>




<%@ include file="/WEB-INF/pages/includes/footer.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/dataTables.bootstrap.min.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/dataTables.bootstrap.min.js"></script>
