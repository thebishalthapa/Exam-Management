<%@ include file="/WEB-INF/pages/includes/header.jsp"%>
<%@ include file="/WEB-INF/pages/includes/nav.jsp"%>

<div class="container">

	<div id="loginbox" style="margin-top: 150px;"
		class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">Sign In</div>
				<div
					style="float: right; font-size: 80%; position: relative; top: -10px">
					<a href="#">Forgot password?</a>
				</div>
			</div>

			<div style="padding-top: 30px" class="panel-body">


				<form name='f'
					action='${pageContext.request.contextPath}/j_spring_security_check'
					method='POST'>

					<c:if test="${param.error !=null }">
						<p style="color: red"">Login Failed . Check your user name and
							password</p>
					</c:if>

					<div style="margin-bottom: 25px" class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span> <input class="form-control"
							type='text' name='j_username' value=''
							placeholder="username or email">
					</div>

					<div style="margin-bottom: 25px" class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-lock"></i></span> <input class="form-control"
							type='password' name='j_password' placeholder="password">
					</div>




					<div style="margin-top: 10px" class="form-group">
						<!-- Button -->

						<div class="col-sm-12 controls">

							<button name="submit" type="submit" value="Login"
								class="btn btn-success">Login</button>
						</div>
					</div>


					<div class="form-group">
						<div class="col-md-12 control">
							<divstyle ="border-top: 1pxsolid #888; padding-top: 15px; font-size: 85%">
							<br>
							<br>
							School Management System 
						</div>
					</div>
			</div>


			</form>



		</div>
	</div>
</div>

</div>






<%@ include file="/WEB-INF/pages/includes/footer.jsp"%>