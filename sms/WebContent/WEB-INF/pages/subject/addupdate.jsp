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
	padding: 5px;
	margin: 10px;
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
				a Subject
			</legend>
		</fieldset>

		<div class="col-lg-12">

			<form:form
				action='${pageContext.request.contextPath}/subject/register'
				method="post" commandName="subject" class="form-inline">

				<div class="form-group vform">
					<label> <b><i class="fa fa-sitemap fa-2x"></i> Select
							Class </b></label>
					<div class="controls">
             
						<form:select class=" form-control" path="classId">
						
							<c:forEach items="${stdClassList}" var="stdClass">
							      <form:option label="${stdClass.className }" value="${stdClass.classId}"> </form:option>
						    </c:forEach>
						    <form:option  value="${subject.classId}"> </form:option>
						</form:select>
						<form:errors path="classId"   cssClass="error"></form:errors>
					</div>
				</div>

				<div class="form-group vform">
					<label> <b><i class="fa fa-book   fa-2x"></i> Subject
							Name</b></label>
							<form:errors path="subjectName"  cssClass="error"></form:errors>
					<div class="controls">
						<form:input type="text" class="form-control" name="subjectName"
							path="subjectName" value="${subject.subjectName}" />
						
					</div>
				</div>

				<div class="form-group vform">

					<label> <b><i class="fa fa-pencil   fa-2x"></i>
							Theory-F:M</b></label>
					<div class="controls">
						<form:input type="text" class="form-control" name="fullThMarks"
							path="fullThMarks" value="${subject.fullThMarks}" />
						<form:errors path="fullThMarks" cssClass="error"></form:errors>
					</div>
				</div>
				<div class="form-group vform">

					<label> <b><i class="fa fa-pencil fa-2x"></i>
							Theory-P:M</b></label>
					<div class="controls">
						<form:input type="text" class="form-control" name="passThMarks"
							path="passThMarks" value="${subject.passThMarks}" />
						<form:errors path="passThMarks" cssClass="error"></form:errors>
					</div>
				</div>
				<div class="form-group  vform">

					<label> <b><i class="fa  fa-level-down  fa-2x"></i> Is
							Practical</b></label>
					<div class="controls ">
						<label> <form:checkbox class="pchk" path="hasPractical"
								value="${subject.hasPractical}" />
						</label>
					</div>
				</div>
				<div class="form-group vform practical" >

					<label> <b><i class="fa fa-pencil-square   fa-2x"></i>
							Practical-F:M</b></label>
					<div class="controls">
						<form:input type="text" class="form-control pr" name="fullPrMarks"
							path="fullPrMarks"  value="${subject.fullPrMarks}" />
						<form:errors path="fullPrMarks" cssClass="error"></form:errors>
					</div>
				</div>
				<div class="form-group vform practical" >

					<label> <b><i class="fa fa-pencil-square fa-2x"></i>
							Practical-P:M</b></label>
					<div class="controls">
						<form:input type="text" class="form-control pr" name="passPrMarks"
							path="passPrMarks"  value="${subject.passPrMarks}" />
						<form:errors path="passPrMarks" cssClass="error"></form:errors>
					</div>
				</div>

				<form:checkbox class="hide" path="status"
					value="${studentClass.status}"></form:checkbox>
				<form:hidden path="subjectId" value="${subject.subjectId}"></form:hidden>
				
		</div>
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
				href="${pageContext.request.contextPath }/subject/"
				class="btn btn-danger glyphicon glyphicon-ban-circle col-lg-12 ">CANCEL
			</a>
		</div>
		</form:form>



	</div>
</div>
</div>

<%@ include file="/WEB-INF/pages/includes/footer.jsp"%>

<script>
$(document).ready(function(){
	<c:choose>
	<c:when test="${ subject.hasPractical}">var update=1;</c:when>
	<c:when test="${ not subject.hasPractical}">var update=0;</c:when>
	</c:choose>
    if(update==1){
    	$('.practical').show();
    }
    else{
    	$('.practical').hide();
    }
});
</script>

<script>
$(document).ready(function(){
    $('.pchk').change(function(){
        if(this.checked){
            $('.practical').fadeIn('slow');
            $('input[name="fullPrMarks"]').val('0.0');
            $('input[name="passPrMarks"]').val('0.0');
        }
        else{
            $('.practical').fadeOut('slow');
        }

    });
    
});

</script>