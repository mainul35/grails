
<%@ page import="com.hmtmcse.Student" %>
<meta name="layout" content="my-layout">
<title><g:message code="studentInstance" default="Student"/> List</title>
<div class="row">
	<div class="panel panel-primary">
		<div class="panel-heading">
			Student List
		</div>
		<div class="panel-body">
			<div class="navbar-form navbar-right" >
				<div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
					<div class="btn-group" role="group" aria-label="Third group">


						<g:form controller="Student" action="index" method="GET">
							<div class="input-group" id="search-area">
								<div class="input-group-btn">
									<div class="btn-group">
										<button type="button" class="btn btn-default selected-column-label">Select</button>
										<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
											<span class="caret"></span>
											<span class="sr-only">Toggle Dropdown</span>
										</button>
										<ul class="dropdown-menu selected-column-name" role="menu" selected-data="${params.colName}">

											
											<li data="name"><a href="#"><g:message code="name" default="Name" /></a></li>
											
											<li data="department"><a href="#"><g:message code="department" default="Department" /></a></li>
											
										</ul>
									</div>
								</div>
								<g:textField name="colValue" class="form-control" value="${params?.colValue}"/>
								<g:hiddenField name="colName" class="selected-column-name" value="${params?.colName}"/>
								<span class="input-group-btn">
									<button class="btn btn-default" type="submit">Search</button>
								</span>
							</div>
						</g:form>


					</div>
					<div class="btn-group" role="group" aria-label="First group">
						<g:link action="create" controller="Student" class="btn  btn-success">Add New</g:link>
						<g:link action="index" controller="Student" class="btn  btn-info">Reload</g:link>
					</div>
				</div>
			</div>
			<table class="table table-bordered table-striped">
				<thead>
				<tr>
					
					<g:sortableColumn property="name" title="${message(code: 'name', default: 'Name')}" />
					
					<g:sortableColumn property="department" title="${message(code: 'department', default: 'Department')}" />
					
					<th class="action-row" >Action</th>
				</tr>
				</thead>
				<tbody>
				<g:each in="${studentInstanceList}" status="i" var="studentInstance">
					<tr class="text-center">
						
						<td>${studentInstance?.name}</td>
						
						<td>${studentInstance?.department}</td>
						
						<td class="action-row">
							<div class="btn-toolbar">
								<div class="btn-group  btn-group-justified">
									<g:link controller="Student" class="btn btn-default" action="show" params="[id:studentInstance.id]"><i class="glyphicon glyphicon glyphicon glyphicon-eye-open"></i></g:link>
									<g:link controller="Student" class="btn btn-default" action="edit" params="[id:studentInstance.id]"><i class="glyphicon glyphicon glyphicon-pencil"></i></g:link>
									<a href="#" class="btn btn-default open-confirm-box" wizard-url="Student/delete/${studentInstance.id}" wizard-title="Delete"><i class="glyphicon glyphicon glyphicon-remove"></i></a>
								</div>
							</div>
						</td>
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="paginate">
				<g:paginate total="${studentInstanceCount ?: 0}" />
			</div>
		</div>
	</div>
</div>

