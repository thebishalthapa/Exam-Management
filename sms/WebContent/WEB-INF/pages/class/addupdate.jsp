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
				a Class
			</legend>

			<form:form
				action='${pageContext.request.contextPath}/studentclass/register'
				method="post" commandName="studentClass">
				
				<div class="row vform">
					<label>	 <b><i class="fa fa-pencil fa-2x"></i> Class Name
							 </b></label>


					<form:input type="text" class="form-control" name="className"
						path="className" value="${studentClass.className}" />
					<form:errors path="className" cssClass="error"></form:errors>
				</div>
				<div class="row vform">
					<label>	 <b><i class="fa fa-check-square-o	 fa-2x"></i> Section
							 </b></label>
					<form:select class=" form-control" path="section">
						<form:option value="${studentClass.section}">
						</form:option>
						<form:option value="A">
						</form:option>
						<form:option value="B">
						</form:option>
						<form:option value="C">
						</form:option>
					</form:select>
					<form:errors path="section"></form:errors>
				</div>
				<div class="row vform">
					<label>	 <b><i class="fa  fa-check-square-o fa-2x"></i> Batch
							 </b></label>
					<form:select class=" form-control" path="batchDate">
						<form:option value="${studentClass.batchDate}">
						</form:option>
						<c:forEach var="i" begin="2072" end="2074">
							<form:option value="${i}">
							</form:option>
						</c:forEach>
					</form:select>
					<form:errors path="batchDate"></form:errors>
					<form:checkbox class="hide" path="status" value="${studentClass.status}"></form:checkbox>
					<form:hidden  path="classId" value="${studentClass.classId}"></form:hidden>
				</div>
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
				<a href="${pageContext.request.contextPath }/studentclass/"
					class="btn btn-danger glyphicon glyphicon-ban-circle col-lg-12 ">CANCEL
				</a>
			</form:form>
		
			

		</div>
	</div>
</div>

<%@ include file="/WEB-INF/pages/includes/footer.jsp"%>
