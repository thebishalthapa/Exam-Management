<%@ include file="/WEB-INF/pages/includes/header.jsp"%>
<%@ include file="/WEB-INF/pages/includes/nav.jsp"%>

<style>
tr{
 font-size:14px;
}
</style>

<div class="fluid-container" id="dashboardcontainer" style="margin-left:15px; margin-right:15px;">

	
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

	  <div>
	    <b>Import Class Details to Excel </b>
	      <form action='${pageContext.request.contextPath}/student/student_details'
				method="get"  class="form-inline">
				
			<div class=" form-group">
				<label> Class Name </label>
				<div class="controls">
					<select class="form-control"  name="classId">
						<c:forEach var="row" items="${stdClassList}">
							<option value=" ${row.classId} ">${row.className}
								${row.section}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class=" form-group ">
				<button type="submit"  class="btn btn-primary" style="margin-top:23px;">
					<i class="fa fa-download" aria-hidden="true"></i> Export 
				</button>
			</div>
			</form>
	  </div>
	  
	 

		<div class="panel panel-danger " style="border-bottom-right-radius: 0;border-bottom-left-radius: 0;">
		<div class="panel-heading" style="background-color: #d9534f; color: white;" >
		<a class="btn btn-default btn-xs pull-right "
					href="${pageContext.request.contextPath }/student/addupdate">
					<span class="glyphicon glyphicon-plus " aria-hidden="true"></span>
					ADD
		  </a>
			<h3 class="panel-title"> <i class="fa fa-user-circle-o" aria-hidden="true"></i> Student </h3>
			
		</div>
    </div>		
    <div class="col-lg-12"> 
	<table id="mytable" class="table table-bordered table-hover"   width="100%">
			<thead>
				<tr>
					<th>ID</th>
					<th>Class Name </th>
					<th>Student Name</th>
					<th>Roll</th>
					<th>Address</th>
					<th>Contact</th>
					<th>Email</th>
					<th>Origin</th>
					<th>Gender</th>
					<th>Blood Group</th>
					<th>D.O.B</th>
					<th>Father Name</th>
					<th>Mother Name</th>
					<th>Action</th>
					</tr>
			</thead>
			<tbody >
				<c:forEach items="${studentList}" var="student">
					<tr>

						<td>${student.studentId}</td>
						<td>${student.className}</td>
						<td style="text-align:left;">${student.firstName } ${student.lastName }</td>
						<td>${student.roll}</td>
						<td>${student.address }</td>
						<td>${student.phone }</td>
						<td>${student.email }</td>
						<td>${student.origin}</td>
						<td>${student.bloodGroup}</td>
						<td>${student.birthday}</td>
						<td>${student.fatherName}</td>
						<td>${student.motherName}</td>
						<td >
						<a href="${pageContext.request.contextPath }/student/addupdate?id=${student.studentId }" class="btn btn-success glyphicon glyphicon-pencil">
								Edit </a> 
								
						<a  href="${pageContext.request.contextPath }/student/delete?id=${student.studentId}"  class="btn btn-danger glyphicon glyphicon-trash 	confirmation">
								Delete </a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
</div>



<%@ include file="/WEB-INF/pages/includes/footer.jsp"%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/dataTables.bootstrap.min.css" />
<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/jquery.dataTables.min.js"></script>
<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/dataTables.bootstrap.min.js"></script>
		
		
<script>
$(document).ready(function() {
    $('#mytable').DataTable();
} );
$(".alert-success").fadeTo(2000, 500).slideUp(300, function(){
    $(".alert-success").alert('close');
});

    $('.confirmation').on('click', function () {
        return confirm('Are you sure?');
    });
</script>


