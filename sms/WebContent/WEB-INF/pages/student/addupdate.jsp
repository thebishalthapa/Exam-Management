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
	font-size: 19px;
}

input[type="text"]:focus {
	-webkit-box-shadow: none;
	box-shadow: none;
}

.vform {
	padding: 10px;
	margin: 15px;
}

.error {
	padding: 4px;
	color: red;
}

label input[type="checkbox"] {
	display: block;
	height: 20px;
	width: 30px;
}
</style>

<div class="container" id="dashboardcontainer">

	<div class="row ">
		<fieldset>
			<legend>
				<c:choose>
					<c:when test="${ show}">Update</c:when>
					<c:when test="${not show}">Add</c:when>
				</c:choose>
				a Student <i class="fa fa-user-circle-o" aria-hidden="true"></i>
			</legend>
		</fieldset>

		<div class="col-lg-12">

			<form:form
				action='${pageContext.request.contextPath}/student/register'
				method="post" commandName="student" class="form-inline">

				<div class="form-group vform">
					<label> <b><i class="fa fa-sitemap fa-2x"></i> Select
							Class </b></label>
					<div class="controls">

						<form:select class=" form-control" path="classId">
							<form:option value="${student.classId}"/>
							
							<c:forEach items="${stdClassList}" var="stdClass">
								<form:option label="${stdClass.className }"
									value="${stdClass.classId}" />
								
							</c:forEach>
						</form:select>
						<form:errors path="classId" cssClass="error"></form:errors>
					</div>
				</div>

				<div class="form-group vform">
					<label> <b><i class="fa fa-user fa-2x"
							aria-hidden="true"></i> First Name</b></label>
					<form:errors path="firstName" cssClass="error"></form:errors>
					<div class="controls">
						<form:input type="text" class="form-control" name="firstName"
							path="firstName" value="${student.firstName}" />

					</div>
				</div>
				<div class="form-group vform">
					<label> <b><i class="fa fa-user-o fa-2x"
							aria-hidden="true"></i> Last Name</b></label>
					<form:errors path="lastName" cssClass="error"></form:errors>
					<div class="controls">
						<form:input type="text" class="form-control" name="lastName"
							path="lastName" value="${student.lastName}" />

					</div>
				</div>
				<div class="form-group vform">
					<label> <b><i class="fa fa-calendar fa-2x"
							aria-hidden="true"></i> Date of Birth </b></label>
					<form:errors path="birthday" cssClass="error"></form:errors>
					<div class="controls">
						<form:input type="text" id="nepaliDate5"
							class="nepali-calendar form-control" name="birthday"
							path="birthday" value="${student.birthday}" />
					</div>
				</div>
				<div class="form-group vform">
					<label> <b><i class="fa fa-medkit fa-2x"></i> 
							Blood Group</b></label>
					<div class="controls">
						<form:select class=" form-control" path="bloodGroup">
							<form:option value="${student.bloodGroup}"></form:option>
							<form:option value="AB+"></form:option>
							<form:option value="AB-"></form:option>
							<form:option value="A+"></form:option>
							<form:option value="A-"></form:option>
							<form:option value="B+"></form:option>
							<form:option value="B-"></form:option>
							<form:option value="O+"></form:option>
							<form:option value="O-"></form:option>
						</form:select>
						<form:errors path="bloodGroup" cssClass="error"></form:errors>
					</div>
				</div>
				<div class="form-group vform">
					<label> <b><i class="fa fa-phone-square fa-2x"
							aria-hidden="true"></i> Contact </b></label>
					<form:errors path="phone" cssClass="error"></form:errors>
					<div class="controls">
						<form:input type="text" class="form-control" name="phone"
							path="phone" value="${student.phone}" />

					</div>
				</div>
				<div class="form-group vform">
					<label> <b><i class="fa fa-envelope fa-2x"
							aria-hidden="true"></i> Email </b></label>
					<form:errors path="email" cssClass="error"></form:errors>
					<div class="controls">
						<form:input type="text" class="form-control" name="email"
							path="email" value="${student.email}" />

					</div>
				</div>
				<div class="form-group vform">
					<label> <b><i class="fa fa-street-view fa-2x"
							aria-hidden="true"></i> Address </b></label>
					<form:errors path="address" cssClass="error"></form:errors>
					<div class="controls">
						<form:input type="text" class="form-control" name="address"
							path="address" value="${student.address}" />

					</div>
				</div>
				<div class="form-group vform">
					<label> <b><i class="fa fa-users fa-2x"></i> 
							Origin/Ethics </b></label>
					<div class="controls">
						<form:select class=" form-control" path="origin">
							<form:option value="${student.origin}"></form:option>
							<form:option value="Dalit"></form:option>
							<form:option value="Janjati"></form:option>
							<form:option value="Others"></form:option>
							
						</form:select>
						<form:errors path="origin" cssClass="error"></form:errors>
					</div>
				</div>
				<div class="form-group vform">
					<label> <b><i class="fa fa-bookmark fa-2x"
							aria-hidden="true"></i> Roll No. </b></label>
					<form:errors path="roll" cssClass="error"></form:errors>
					<div class="controls">
						<form:input type="text" class="form-control" name="roll"
							path="roll" value="${student.roll}" />

					</div>
				</div>
				<div class="form-group vform">
					<label> <b><i class="fa fa-user fa-2x"
							aria-hidden="true"></i> Father Name</b></label>
					<form:errors path="fatherName" cssClass="error"></form:errors>
					<div class="controls">
						<form:input type="text" class="form-control" name="fatherName"
							path="fatherName" value="${student.fatherName}" />

					</div>
				</div>
				<div class="form-group vform">
					<label> <b><i class="fa fa-user-o fa-2x"
							aria-hidden="true"></i> Mother Name</b></label>
					<form:errors path="motherName" cssClass="error"></form:errors>
					<div class="controls">
						<form:input type="text" class="form-control" name="motherName"
							path="motherName" value="${student.motherName}" />

					</div>
				</div>

				<form:checkbox class="hide" path="status" value="${student.status}"></form:checkbox>
				<form:hidden path="studentId" value="${student.studentId}"></form:hidden>


				<hr>
				<div class="col-lg-3">
					<button type="submit" id="submit-button"
						class="btn btn-primary glyphicon glyphicon-plus col-lg-12 ">
						<c:choose>
							<c:when test="${ show}"> UPDATE</c:when>
							<c:when test="${not show}"> ADD</c:when>
						</c:choose>
					</button>

					<br> <br> <a
						href="${pageContext.request.contextPath }/student/"
						class="btn btn-danger glyphicon glyphicon-ban-circle col-lg-12 ">CANCEL
					</a>
				</div>
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
		npdMonth : true,
		npdYear : true,
		npdYearCount : 10 // Options | Number of years to show
	});
</script>