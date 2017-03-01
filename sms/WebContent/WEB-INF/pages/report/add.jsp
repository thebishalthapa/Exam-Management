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
	color:blue;
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

<div class="fluid-container" id="dashboardcontainer"
	style="margin-left: 15px; margin-right: 15px;">


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
	<legend>
		<i class="fa fa-address-card" aria-hidden="true"></i> Add Marks <b
			class="pull-right" style="color: #d9534f;"> ${exam.examName} |
			Grade: ${studentClass.className } </b>
	</legend>

	<table id="mytable" class="table table-bordered table-hover">
		<thead>
			<tr>
				<th class="col-xs-2">Student</th>
				<c:forEach var="subrow" items="${subjectList}">
					<th class="col-xs-1">${subrow.subjectName}- Th | Pr</th>
				</c:forEach>
				<th>Action</th>
			</tr>
		</thead>

		<tbody>
			<c:set var="count" value="1" scope="page" />
			<c:forEach var="strow" items="${studentList}">
				<tr>
					<td><input type="text" 
						name="${strow.studentId }"
						value="${strow.firstName} ${strow.lastName}" disableb
						readonly="true"></td>


					<c:forEach var="srow" items="${subjectList}">
						<td><input type="text" size="4" id="${srow.subjectId}"
							name="${srow.subjectId}" value="0.0"> <c:choose>
								<c:when test="${ srow.hasPractical}">
									<input type="text" size="4" id="${srow.subjectId}"
										name="${srow.subjectId}" value="0.0"
										style="background: silver;">
								</c:when>
								<c:when test="${not srow.hasPractical}">
									<input type="text" size="4" id="${srow.subjectId}"
										name="${srow.subjectId}" value="0.0"
										style="background: silver;" hidden>
								</c:when>
							</c:choose></td>
					</c:forEach>
					<td><a type="button" class="btn btn-primary glyphicon glyphicon-plus" id="submit${count}"
						onClick="rankStudent(${count})" >Add </a><c:set var="count"
							value="${count + 1}" scope="page" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<br>
	<div class="pull-right">
		<a href="${pageContext.request.contextPath }/marks/"
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

<script>
    var table = document.getElementById("mytable");
	function rankStudent(index) {
		
		var classId = document.getElementById("classId").value;
		var examId = document.getElementById("examId").value;

		var marks = {
			classId : 0,
			studentId : 0,
			examId : 0,
			subjectId : 0,
			theoryMarks : 0,
			practicalMarks : 0
		};
		var myarray = new Array();
		
		var studentId = table.rows[index].cells[0].children[0].name;
		
		for (var j = 1; j < table.rows[index].cells.length - 1; j++) {
			        marks = new Object();
					marks.classId = classId;
					marks.studentId = studentId;
					marks.examId = examId;
					marks.subjectId=table.rows[index].cells[j].children[0].name;
					marks.theoryMarks = table.rows[index].cells[j].children[0].value;
					marks.practicalMarks = +table.rows[index].cells[j].children[1].value;
					myarray[j-1]= marks;
	   }
		$.ajax({
			 headers: { 
			        'Accept': 'application/json',
			        'Content-Type': 'application/json' 
			    },
			type : "POST",
			dataType : 'json',
			url : "addMarks",
			data : JSON.stringify(myarray), // Note it is important
			success : function(result) {
				$("#submit"+index).removeClass('btn btn-danger').addClass('btn btn-success glyphicon glyphicon-ok disabled ');
				$("#submit"+index).html("Complete");
				disableRow(index);
			},
            error : function(result) {
				console.log("error");
			} 
		});

	}
	
	function disableRow(index){
		for (var j = 1; j < table.rows[index].cells.length - 1; j++) {
			$(table.rows[index].cells[j].children[0]).prop("disabled",true);
			$(table.rows[index].cells[j].children[1]).prop("disabled",true); 
	   }
	}
</script>


