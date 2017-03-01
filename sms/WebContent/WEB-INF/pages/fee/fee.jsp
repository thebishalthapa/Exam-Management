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
		
		<div class="col-lg-4"></div>
		<div class="col-lg-3">
			<legend style="color: red">
			<i class="fa fa-money" aria-hidden="true"></i> Billing
		</legend>
			<form
				action='${pageContext.request.contextPath}/fee/showStudentList'
				method="get" class="form-inline">

				<label for="email">Class:</label>
				<div class="form-group">
					<select
						class="form-control col-lg-3" name="classId">
						<c:forEach var="row" items="${stdClassList}">
							<option value=" ${row.classId} ">${row.className}
								${row.section}</option>
						</c:forEach>
					</select>
				</div>

				<button type="submit" class="btn btn-danger">Submit</button>

			</form>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/pages/includes/footer.jsp"%>
