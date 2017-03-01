<%@ include file="/WEB-INF/pages/includes/header.jsp"%>
<%@ include file="/WEB-INF/pages/includes/nav.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="container" id="dashboardcontainer">
	<div class="row">
		<div class="col-lg-12">
			<!-- Nav tabs -->
			<div class="card">
				<ul class="nav nav-tabs" role="tablist">
					<li role="presentation" class="active"><a href="#home"
						aria-controls="home" role="tab" data-toggle="tab">Monthly Fee</a></li>
					<li role="presentation"><a href="#profile"
						aria-controls="profile" role="tab" data-toggle="tab">Profile</a></li>
					<li role="presentation"><a href="#messages"
						aria-controls="messages" role="tab" data-toggle="tab">Messages</a></li>
					<li role="presentation"><a href="#settings"
						aria-controls="settings" role="tab" data-toggle="tab">Settings</a></li>
				</ul>

				<!-- Tab panes -->
				<div class="tab-content">
					<div role="tabpanel" class="tab-pane active" id="home">Lorem
						Ipsum is simply dummy text of the printing and typesetting
						industry. Lorem Ipsum has been the industry's standard dummy text
						ever since the 1500s, when an unknown printer took a galley of
						type and scrambled it to make a type specimen book. It has
						survived not only five centuries, but also the leap into
						electronic typesetting, remaining essentially unchanged. It was
						popularised in the 1960s with the release of Letraset sheets
						containing Lorem Ipsum passages, and more recently with desktop
						publishing software like Aldus PageMaker including versions of
						Lorem Ipsum.</div>
					<div role="tabpanel" class="tab-pane" id="profile">Lorem
						Ipsum is simply dummy text of the printing and typesetting
						industry. Lorem Ipsum has been the industry's standard dummy text
						ever since the 1500s, when an unknown printer took a galley of
						type and scrambled it to make a type specimen book.</div>
					<div role="tabpanel" class="tab-pane" id="messages">Lorem
						Ipsum is simply dummy text of the printing and typesetting
						industry. Lorem Ipsum has been the industry's standard dummy text
						ever since the 1500s, when an unknown printer took a galley of
						type and scrambled it to make a type specimen book. It has
						survived not only five centuries, but also the leap into
						electronic typesetting, remaining essentially unchanged. It was
						popularised in the 1960s with the release of Letraset sheets
						containing Lorem Ipsum passages, and more recently with desktop
						publishing software like Aldus PageMaker including versions of
						Lorem Ipsum.</div>
					<div role="tabpanel" class="tab-pane" id="settings">Lorem
						Ipsum is simply dummy text of the printing and typesetting
						industry. Lorem Ipsum has been the industry's standard dummy text
						ever since the 1500s, when an unknown printer took a galley of
						type and scrambled it to make a type specimen book. It has
						survived not only five centuries, but also the leap into
						electronic typesetting, remaining essentially unchanged. It was
						popularised in the 1960s with the release of Letraset sheets
						containing Lorem Ipsum passage..</div>
				</div>
			</div>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/pages/includes/footer.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/dataTables.bootstrap.min.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/dataTables.bootstrap.min.js"></script>
