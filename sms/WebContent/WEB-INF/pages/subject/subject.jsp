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

	<div class="panel panel-danger "
		style="border-bottom-right-radius: 0; border-bottom-left-radius: 0;">
		<div class="panel-heading"
			style="background-color: #d9534f; color: white;">
			<a class="btn btn-default btn-xs pull-right "
				href="${pageContext.request.contextPath }/subject/addupdate"> <span
				class="glyphicon glyphicon-plus " aria-hidden="true"></span> ADD
			</a>
			<h3 class="panel-title">
				<i class="fa fa-book" aria-hidden="true"></i> Subject
			</h3>

		</div>
	</div>

	<table id="mytable" class="table table-bordered table-hover"
		width="100%">
		<thead>
			<tr>
				<th>ID</th>
				<th>Class Name</th>
				<th>Subject Name</th>
				<th>Practical</th>
				<th>TH - F:M</th>
				<th>PR - F:M</th>
				<th>TH - P:M</th>
				<th>PR - P:M</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${subjectList}" var="subject">
				<tr>

					<td>${subject.subjectId}</td>
					<td>${subject.className }</td>
					<td style="text-align: left;">${subject.subjectName}</td>
					<td>${subject.hasPractical}</td>
					<td>${subject.fullThMarks }</td>
					<td>${subject.fullPrMarks }</td>
					<td>${subject.passThMarks }</td>
					<td>${subject.passPrMarks}</td>
					<td><a
						href="${pageContext.request.contextPath }/subject/addupdate?id=${subject.subjectId }"
						class="btn btn-success glyphicon glyphicon-pencil"> Edit </a> <a
						href="${pageContext.request.contextPath }/subject/delete?id=${subject.subjectId}"
						class="btn btn-danger glyphicon glyphicon-trash 	confirmation">
							Delete </a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>




<%@ include file="/WEB-INF/pages/includes/footer.jsp"%>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/dataTables.bootstrap.min.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/dataTables.bootstrap.min.js"></script>


<script>
	$(document).ready(function() {
		$('#mytable').DataTable();
	});
	$(".alert-success").fadeTo(2000, 500).slideUp(300, function() {
		$(".alert-success").alert('close');
	});

	$('.confirmation').on('click', function() {
		return confirm('Are you sure?');
	});
</script>


