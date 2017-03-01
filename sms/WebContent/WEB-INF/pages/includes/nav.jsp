<%@ include file="/WEB-INF/pages/includes/header.jsp"%>
<script>
	function clickedSearch() {
		document.getElementById("search_customer").focus();

	}
	function readyFunction() {
	}
</script>
<nav class="navbar navbar-inverse navbar-fixed-top  " id="mynavbar" > 
	<div class="container-fluid" >
	
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header" >
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		<a class="navbar-brand" href="#" style="color:white">Simple School Management </a>
	 </div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse">

			<ul class="nav navbar-nav navbar-right" id="navbarlist">
				<li  ><a href="${pageContext.request.contextPath}/fee" > <i class="fa fa-money" aria-hidden="true"></i> Billing </a> </li>
				<li  ><a href="${pageContext.request.contextPath}/report" > <i class="fa fa-sticky-note" aria-hidden="true"></i> Report</a> </li>
				<li  ><a href="${pageContext.request.contextPath}/marks" > <i class="fa fa-address-card" aria-hidden="true"></i> Marks</a> </li>
				<li ><a href="${pageContext.request.contextPath}/student" > <i class="fa fa-user-circle-o" aria-hidden="true"></i> Student</a> </li>
				<li ><a href="${pageContext.request.contextPath}/exam" ><i class="fa fa-file-text" aria-hidden="true"></i> Exam</a> </li>
				<li ><a href="${pageContext.request.contextPath}/subject" ><i class="fa fa-book" aria-hidden="true"></i> Subject</a> </li>
				<li><a href="${pageContext.request.contextPath}/studentclass" ><i class="fa fa-sitemap" aria-hidden="true"></i> Class</a> </li>
				<li class="dropdown "><a href="#" class="dropdown-toggle glyphicon glyphicon-user"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false"><span class="caret"></span></a>
					<ul class="dropdown-menu ">
						<li><a href="<c:url value='/j_spring_security_logout'/>" > Log out</a></li>
						 
					</ul>
				</li>
				
			</ul>


		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>