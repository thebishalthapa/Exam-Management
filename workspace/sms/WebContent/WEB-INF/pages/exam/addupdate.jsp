<%@ include file="/WEB-INF/pages/includes/header.jsp"%>
<%@ include file="/WEB-INF/pages/includes/nav.jsp"%>

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

textarea[type="text"] {
	border-top: 0;
	border-right: 0;
	border-left: 0;
	border-radius: 0;
	-webkit-box-shadow: none;
	box-shadow: none;
	font-size: 17px;
	padding-bottom:40px;
}
input[type="text"]:focus {
	-webkit-box-shadow: none;
	box-shadow: none;
}

.vform {
	padding-left: 15px;
	margin-top: 25px;
}

.error {
	padding: 4px;
	color: red;
}
</style>

<div class="container" id="dashboardcontainer">

	<div class="row ">
		<div class="col-lg-4"></div>
		<div class="col-lg-4">
			<legend>
				<c:choose> 
					<c:when test="${ show}">Update</c:when>
					<c:when test="${not show}">Add</c:when>
				</c:choose> 
				a Exam
			</legend>

			<form:form
				action='${pageContext.request.contextPath}/exam/register'
				method="post" commandName="exam">
				
				<div class="row vform">
					<label> <b><i class="fa fa-pencil fa-2x"></i> Exam Name
							 </b></label>

					<form:input type="text" class="form-control" name="examName"
						path="examName" value="${exam.examName}" />
					<form:errors path="examName" cssClass="error"></form:errors>
				</div>
				
				<div class="row vform">
					<label> <b><i class="fa fa-calendar fa-2x"></i> Exam Date
							 </b></label>
	
					<form:input type="text" id="nepaliDate5" class="nepali-calendar form-control" name="examDate"
						path="examDate" value="${exam.examDate}" />
					<form:errors path="examDate" cssClass="error"></form:errors>
				</div>
				<div class="row vform">
					<label> <b><i class="fa fa-indent fa-2x"></i> Description
							</b></label>

					<form:textarea type="text" class="form-control" name="description"
						path="description" value="${exam.description}" />
					<form:errors path="description" cssClass="error"></form:errors>
				</div>
				<form:hidden path="examId" value="${exam.examId}"></form:hidden>
				<form:checkbox class="hide" path="status" value="${exam.status}"></form:checkbox>
				<hr>
				<button type="submit" id="submit-button"
					class="btn btn-primary glyphicon glyphicon-plus col-lg-12 ">
					<c:choose>
						<c:when test="${ show}"> UPDATE</c:when>
						<c:when test="${not show}"> ADD</c:when>
					</c:choose>
				</button>
				
				<br>
				<br>
				<a href="${pageContext.request.contextPath }/exam/"
					class="btn btn-danger glyphicon glyphicon-ban-circle col-lg-12 ">CANCEL
				</a>
			</form:form>
		
			

		</div>
	</div>
</div>
<%@ include file="/WEB-INF/pages/includes/footer.jsp"%>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/nepali.datepicker.v2.1.min.css"
	type="text/css" />
	
<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/nepali.datepicker.v2.1.min.js"></script>
		

<script>
$('#nepaliDate5').nepaliDatePicker({
	npdMonth: true,
	npdYear: true,
	npdYearCount: 10 // Options | Number of years to show
});

</script>
