<%@ include file="/WEB-INF/pages/includes/header.jsp"%>
<%@ include file="/WEB-INF/pages/includes/nav.jsp"%>

<div class="container" id="dashboardcontainer">

	
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

	<div class="panel"style="border-bottom-right-radius: 0;border-bottom-left-radius: 0;">
		<div class="panel-heading"   style="background-color: #d9534f; color: white;" >
		<a class="btn btn-default btn-xs pull-right "
					href="${pageContext.request.contextPath }/studentclass/addupdate">
					<span class="glyphicon glyphicon-plus " aria-hidden="true"></span>
					ADD
		  </a>
			<h3 class="panel-title"><i class="fa fa-sitemap" aria-hidden="true"></i> Class </h3>
			
		</div>
    </div>
		<table id="mytable" class="table table-bordered table-hover"   width="100%">
			<thead>
				<tr>
					<th>#</th>
					<th>Class</th>
					<th>Section</th>
					<th>Batch</th>
					<th style="text-align:center">Action</th>
			</thead>
			<tbody>
				<c:forEach items="${classList}" var="stdclass">
					<tr>

						<td>${stdclass.classId }</td>
						<td>${stdclass.className }</td>
						<td>${stdclass.section }</td>
						<td>${stdclass.batchDate}</td>
						<td style="text-align:center">
						<a href="${pageContext.request.contextPath }/studentclass/addupdate?id=${stdclass.classId }" class="btn btn-success glyphicon glyphicon-pencil">
								Edit </a> 
								
						<a  href="${pageContext.request.contextPath }/studentclass/delete?id=${stdclass.classId }"  class="btn btn-danger glyphicon glyphicon-trash 	confirmation">
								Delete </a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="col-lg-3"></div>

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

