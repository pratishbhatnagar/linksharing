<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.css"
	type="text/css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.css">
</head>
<body>
	<nav class="navbar">
	<div class="container"
		style="border: 1px solid grey; border-radius: 10px;">
		<div class="row">
			<div class="col-md-4">
				<div class="navbar-header">
					<a class="navbar-brand" href="dashboard"><ins>Link
							Sharing</ins></a>
				</div>
			</div>
			<div class="col-md-3">
				<form class="navbar-form navbar-right"
					style="border: 1px solid grey; border-radius: 15px;">
					<div class="input-group">
						<span class="input-group-btn">
							<button class="btn" style="background-color: transparent;">
								<span class="glyphicon glyphicon-search"></span>
							</button>
						</span> <input type="text" class="form-control" placeholder="Search"
							style="background-color: transparent;"> <span
							class="input-group-btn">
							<button class="btn" style="background-color: transparent;">
								<span class="glyphicon glyphicon-remove"></span>
							</button>
						</span>
					</div>
				</form>
			</div>
			<div class="col-md-1">
				<a class="btn" role="button" data-toggle="modal"
					data-target="#createtopicModal"> <span class="fa fa-comment"></span>
				</a>
			</div>
			<div class="col-md-1">
				<a class="btn" role="button" data-toggle="modal"
					data-target="#sendinviteModal"> <span
					class="glyphicon glyphicon-envelope"></span>
				</a>
			</div>
			<div class="col-md-1">
				<a class="btn" role="button" data-toggle="modal"
					data-target="#sharelinkModal"> <span
					class="glyphicon glyphicon-link"></span>
				</a>
			</div>
			<div class="col-md-1">
				<a class="btn" role="button" data-toggle="modal"
					data-target="#sharedocModal"> <span class="fa fa-file-o"></span>
				</a>
			</div>
			<div class="col-md-1">
				<div class="dropdown">
					<a class="btn dropdown-toggle" type="button" data-toggle="dropdown"><span
						class="glyphicon glyphicon-user"></span>${userDTO.firstName} <span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<!-- <li><a href="#">Profile</a></li>
                                <li><a href="#">Users</a></li>
                                <li><a href="#">Topics</a></li>
                                <li><a href="#">Posts</a></li> -->
						<li><a href="logout">Logout</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	</nav>
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<div class="row panel panel-default">
					<div class="col-md-4">
						<img src="#" class="img img-thumbnail img-responsive" alt="Image"
							id="uimg" style="width: 75px; height: 75px">
					</div>
					<div class="col-md-8">
						<span class="text-primary">${userDTO.firstName}
							${userDTO.lastName}</span><br /> <span class="text-muted">@${userDTO.username}</span>
						<div class="row">
							<div class="col-md-6">
								<span class="text-muted">Subscriptions</span><br /> <span
									class="text-primary">50</span>
							</div>
							<div class="col-md-6">
								<span class="text-muted">Topics</span><br /> <span
									class="text-primary">30</span>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="panel panel-default">
						<div class="panel-heading">
							Subscriptions
							<div class="pull-right">
								<a href="#">View All</a>
							</div>
						</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-md-4">
									<img src="#" class="img img-thumbnail img-responsive"
										alt="Image" id="uimg" style="width: 75px; height: 75px">
								</div>
								<div class="col-md-8">
									<span class="text-primary">Grails</span>
									<div class="row">
										<div class="col-md-4">
											<span class="text-muted">@uday</span> <a href="#">Unsubscribe</a>
										</div>
										<div class="col-md-4">
											<span class="text-muted">Subscriptions</span><br /> <span
												class="text-primary">50</span>
										</div>
										<div class="col-md-4">
											<span class="text-muted">Topics</span><br /> <span
												class="text-primary">30</span>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="panel-footer">
							<div class="row">
								<div class="col-md-4">
									<div class="dropdown">
										<button class="btn btn-default dropdown-toggle" type="button"
											data-toggle="dropdown">
											Serious <span class="caret"></span>
										</button>
										<ul class="dropdown-menu">
											<li><a href="#">...</a></li>
											<li><a href="#">...</a></li>
										</ul>
									</div>
								</div>
								<div class="col-md-4">
									<div class="dropdown">
										<button class="btn btn-default dropdown-toggle" type="button"
											data-toggle="dropdown">
											Private <span class="caret"></span>
										</button>
										<ul class="dropdown-menu">
											<li><a href="#">...</a></li>
											<li><a href="#">...</a></li>
										</ul>
									</div>
								</div>
								<div class="col-md-4">
									<a href="#"><span class="glyphicon glyphicon-envelope"
										style="font-size: 20px"></span></a> <a href="#"><span
										class="fa fa-file-o" style="font-size: 20px"></span></a> <a
										href="#"><span class="fa fa-trash" style="font-size: 20px"></span></a>
								</div>
							</div>
						</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-md-4">
									<img src="#" class="img img-thumbnail img-responsive"
										alt="Image" id="uimg" style="width: 75px; height: 75px">
								</div>
								<div class="col-md-8">
									<span class="text-primary">Grails</span>
									<div class="row">
										<div class="col-md-4">
											<span class="text-muted">@uday</span> <a href="#">Unsubscribe</a>
										</div>
										<div class="col-md-4">
											<span class="text-muted">Subscriptions</span><br /> <span
												class="text-primary">50</span>
										</div>
										<div class="col-md-4">
											<span class="text-muted">Topics</span><br /> <span
												class="text-primary">30</span>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="panel-footer">
							<div class="row">
								<div class="col-md-4 col-md-push-4">
									<div class="dropdown">
										<button class="btn btn-default dropdown-toggle" type="button"
											data-toggle="dropdown">
											Serious <span class="caret"></span>
										</button>
										<ul class="dropdown-menu">
											<li><a href="#">...</a></li>
											<li><a href="#">...</a></li>
										</ul>
									</div>
								</div>
								<div class="col-md-8 col-md-push-4">
									<a href="#"><span class="glyphicon glyphicon-envelope"
										style="font-size: 20px"></span></a>

								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="panel panel-default">
						<div class="panel-heading">Trending Topics</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-md-4">
									<img src="#" class="img img-thumbnail img-responsive"
										alt="Image" id="uimg" style="width: 75px; height: 75px">
								</div>
								<div class="col-md-8">
									<span class="text-primary">Grails</span>
									<div class="row">
										<div class="col-md-4">
											<span class="text-muted">@uday</span> <a href="#">Unsubscribe</a>
										</div>
										<div class="col-md-4">
											<span class="text-muted">Subscriptions</span><br /> <span
												class="text-primary">50</span>
										</div>
										<div class="col-md-4">
											<span class="text-muted">Topics</span><br /> <span
												class="text-primary">30</span>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-md-4">
									<img src="#" class="img img-thumbnail img-responsive"
										alt="Image" id="uimg" style="width: 75px; height: 75px">
								</div>
								<div class="col-md-8">
									<form class="navbar-form">
										<div class="input-group">
											<input type="text" class="form-control" placeholder="Grails">
										</div>
										<div class="input-group">
											<button type="submit" class="btn btn-default btn-primary">Save</button>
											<button type="submit" class="btn btn-default btn-primary">Cancel</button>
										</div>
									</form>
									<span class="text-primary">Grails</span>
									<div class="row">
										<div class="col-md-4">
											<span class="text-muted">@uday</span> <a href="#">Unsubscribe</a>
										</div>
										<div class="col-md-4">
											<span class="text-muted">Subscriptions</span><br /> <span
												class="text-primary">50</span>
										</div>
										<div class="col-md-4">
											<span class="text-muted">Topics</span><br /> <span
												class="text-primary">30</span>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="panel-footer">
							<div class="row">
								<div class="col-md-4">
									<div class="dropdown">
										<button class="btn btn-default dropdown-toggle" type="button"
											data-toggle="dropdown">
											Serious <span class="caret"></span>
										</button>
										<ul class="dropdown-menu">
											<li><a href="#">...</a></li>
											<li><a href="#">...</a></li>
										</ul>
									</div>
								</div>
								<div class="col-md-4">
									<div class="dropdown">
										<button class="btn btn-default dropdown-toggle" type="button"
											data-toggle="dropdown">
											Private <span class="caret"></span>
										</button>
										<ul class="dropdown-menu">
											<li><a href="#">...</a></li>
											<li><a href="#">...</a></li>
										</ul>
									</div>
								</div>
								<div class="col-md-4">
									<a href="#"><span class="glyphicon glyphicon-envelope"
										style="font-size: 20px"></span></a> <a href="#"><span
										class="fa fa-file-o" style="font-size: 20px"></span></a> <a
										href="#"><span class="fa fa-trash" style="font-size: 20px"></span></a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-7 col-md-push-1">
				<div class="row">
					<div class="panel panel-default">
						<div class="panel-heading">Inbox</div>
						<div class="panel-body"
							style="overflow: scroll; overflow-x: hidden; height: 300px">
							<c:choose>
								<c:when test="${empty resourceDTOs}">
                            			No unread items in your inbox!
                            		</c:when>
								<c:otherwise>
									<c:forEach items="${resourceDTOs}" var="resourceDTO">
										<div class="row">
											<div class="col-md-3">
												<img src="#" class="img img-thumbnail img-responsive"
													alt="Image" id="uimg" style="width: 150px; height: 150px">
											</div>
											<div class="col-md-9 panel">
												<span class="text-primary">${resourceDTO.createdBy.firstName}
													${resourceDTO.createdBy.lastName}</span> <span class="text-muted">@${resourceDTO.createdBy.username}</span>
												<span class="text-primary pull-right">${resourceDTO.topicDTO.topicName}</span>
												<div class="panel-body text-justify">${resourceDTO.description}</div>
												<div class="panel-footer">
													<a href="http://facebook.com" target="_blank"><span
														class="fa fa-facebook-square"
														style="font-size: 20px; color: blue"></span></a> <a
														href="http://tumblr.com" target="_blank"><span
														class="fa fa-tumblr" style="font-size: 20px"></span></a> <a
														href="http://plus.google.com" target="_blank"><span
														class="fa fa-google-plus"
														style="font-size: 20px; color: red"></span></a>
													<c:choose>
														<c:when test="${empty resourceDTO.url}">
															<a href="${resourceDTO.path}" class="pull-right"
																target="_blank">Download</a>
														</c:when>
														<c:otherwise>
															<a href="${resourceDTO.url}" class="pull-right"
																target="_blank">View Full Site</a>
														</c:otherwise>
													</c:choose>
													<a href="#" class="pull-right">Mark as Read</a> <a href="#"
														class="pull-right">View Post</a>
												</div>
											</div>
										</div>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="modal fade" id="createtopicModal" tabindex="-1"
			role="dialog" aria-labelledby="createtopicModal">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title" id="createtopicModalLabel">Create
							Topic</h4>
					</div>
					<form class="form" action="createTopic" method="post">
						<div class="modal-body table-responsive">
							<table class="table table-condensed">
								<tr>
									<td>
										<div class="form-group">
											<label for="topicName">Name *</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<input type="text" id="topicName" name="topicName" required>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="visibility">Visibility *</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<div class="dropdown">
												<select name="visibility" id="visibility">
													<option value="PUBLIC">Public</option>
													<option value="PRIVATE">Private</option>
												</select>
											</div>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<button type="submit" class="btn btn-primary">Save</button>
										</div>
									</td>
									<td>
										<div class="form-group">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">Close</button>
										</div>
									</td>
								</tr>
							</table>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="modal fade" id="sendinviteModal" tabindex="-1"
			role="dialog" aria-labelledby="sendinviteModal">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title" id="sendinviteModalLabel">Send
							Invitation</h4>
					</div>
					<form class="form">
						<div class="modal-body table-responsive">
							<table class="table table-condensed">
								<tr>
									<td>
										<div class="form-group">
											<label for="email">E-Mail *</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<input type="email" id="email" name="email" required>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="topic">Topic *</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<div class="dropdown">
												<button class="btn dropdown-toggle" type="button"
													data-toggle="dropdown" id="topic">
													<span class="glyphicon glyphicon-user"></span>Topic <span
														class="caret"></span>
												</button>
												<ul class="dropdown-menu">
													<li><a href="#">...</a></li>
													<li><a href="#">...</a></li>
												</ul>
											</div>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<button type="button" class="btn btn-primary">Invite</button>
										</div>
									</td>
									<td>
										<div class="form-group">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">Cancel</button>
										</div>
									</td>
								</tr>
							</table>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="modal fade" id="sharedocModal" tabindex="-1" role="dialog"
			aria-labelledby="sharedocModal">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title" id="sharedocModalLabel">Share Document</h4>
					</div>
					<form class="form" action="createDocumentResource" enctype="multipart/form-data" method="post">
						<div class="modal-body table-responsive">
							<table class="table table-condensed">
								<tr>
									<td>
										<div class="form-group">
											<label for="doc">Document *</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<input type="file" id="file" name="file" required>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="description">Description *</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<textarea id="description" name="description"></textarea>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="docTopic">Topic *</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<div class="dropdown">
												<select name="topicId" id="topic">
													<c:forEach items="${topicDTOs}" var="t">
														<option value="${t.topicId}">${t.topicName}</option>
													</c:forEach>
												</select>
											</div>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<button type="submit" class="btn btn-primary">Share</button>
										</div>
									</td>
									<td>
										<div class="form-group">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">Close</button>
										</div>
									</td>
								</tr>
							</table>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="modal fade" id="sharelinkModal" tabindex="-1"
			role="dialog" aria-labelledby="sharelinkModal">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title" id="sharelinkModalLabel">Share Link</h4>
					</div>
					<form class="form" action="createLinkResource" method="post">
						<div class="modal-body table-responsive">
							<table class="table table-condensed">
								<tr>
									<td>
										<div class="form-group">
											<label for="link">Link*</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<input type="url" id="link" name="url" required>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="description">Description*</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<textarea id="description" name="description"></textarea>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="docTopic">Topic*</label>
										</div>
									</td>
									<td>
										<div class="form-group">
											<div class="dropdown">
												<select name="topicId" id="topic">
													<c:forEach items="${topicDTOs}" var="t">
														<option value="${t.topicId}">${t.topicName}</option>
													</c:forEach>
												</select>
											</div>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<button type="submit" class="btn btn-primary">Share</button>
										</div>
									</td>
									<td>
										<div class="form-group">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">Close</button>
										</div>
									</td>
								</tr>
							</table>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-2.2.0.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.js"></script>
</body>
</html>