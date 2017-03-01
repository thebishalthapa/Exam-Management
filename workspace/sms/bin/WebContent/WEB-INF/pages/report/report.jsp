<%@ include file="/WEB-INF/pages/includes/header.jsp"%>
<%@ include file="/WEB-INF/pages/includes/nav.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<style>
input[type="text"] {
	border-top: 0;
	border-right: 0;
	border-left: 0;
	border-radius: 0;
	-webkit-box-shadow: none;
	box-shadow: none;
	font-size: 20px;
}

input[type="text"]:focus {
	-webkit-box-shadow: none;
	box-shadow: none;
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

	<div class="row ">
	<legend style="color:red"> <i class="fa fa-sticky-note" aria-hidden="true"></i> Report </legend>
		<div class="col-lg-4"></div>
		<div class="col-lg-3">
			


             <form action='${pageContext.request.contextPath}/report/showStudentList'
				method="get" >
			<div class=" form-group vform">
				<label> <b><i class="fa fa-sitemap fa-2x"
						aria-hidden="true"></i> Class </b></label>
				<div class="controls">
					<select class="form-control col-lg-3" name="classId">
						<c:forEach var="row" items="${stdClassList}">
							<option value=" ${row.classId} ">${row.className}
								${row.section}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class=" form-group vform">
				<label> <b><i class="fa fa-file-text fa-2x"
						aria-hidden="true"></i> Exam </b></label>

				<div class="controls ">
					<select class="form-control " name="examId">
						<c:forEach var="row" items="${examList}">
							<option value=" ${row.examId} ">${row.examName}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class=" form-group vform">
				<button type="submit" style="width: 150px;" class="btn btn-success">
					<i class="fa fa-id-badge" aria-hidden="true"></i> Get Report
				</button>
			</div>
			</form>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/pages/includes/footer.jsp"%>
