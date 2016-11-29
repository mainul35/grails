<meta name="layout" content="app">
<title><g:message code="operatorInstance" default="Operator"/> List</title>
<div class="row">
	<div class="panel panel-primary">
		<div class="panel-heading">
			Operator List
		</div>
		<div class="panel-body">
			<div class="navbar-form navbar-right" >
				<div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
					<div class="btn-group" role="group" aria-label="Third group">


						<g:form controller="Operator" action="index" method="GET">
							<div class="input-group" id="search-area">
								<div class="input-group-btn">
									<div class="btn-group">
										<button type="button" class="btn btn-default selected-column-label">Select</button>
										<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
											<span class="caret"></span>
											<span class="sr-only">Toggle Dropdown</span>
										</button>
										<ul class="dropdown-menu selected-column-name" role="menu" selected-data="${params.colName}">

											
											<li data="email"><a href="#"><g:message code="email" default="Email" /></a></li>
											
											<li data="name"><a href="#"><g:message code="name" default="Name" /></a></li>
											
											<li data="password"><a href="#"><g:message code="password" default="Password" /></a></li>
											
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
						<g:link action="create" controller="Operator" class="btn  btn-success">Add New</g:link>
						<g:link action="index" controller="Operator" class="btn  btn-info">Reload</g:link>
					</div>
				</div>
			</div>
			<table class="table table-bordered table-striped">
				<thead>
				<tr>
					
					<g:sortableColumn property="email" title="${message(code: 'email', default: 'Email')}" />
					
					<g:sortableColumn property="name" title="${message(code: 'name', default: 'Name')}" />
					
					<g:sortableColumn property="password" title="${message(code: 'password', default: 'Password')}" />
					
					<th class="action-row" >Action</th>
				</tr>
				</thead>
				<tbody>
				<g:each in="${operatorInstanceList}" status="i" var="operatorInstance">
					<tr class="text-center">
						
						<td>${operatorInstance?.email}</td>
						
						<td>${operatorInstance?.name}</td>
						
						<td>${operatorInstance?.password}</td>
						
						<td class="action-row">
							<div class="btn-toolbar">
								<div class="btn-group  btn-group-justified">
									<g:link controller="Operator" class="btn btn-default" action="show" params="[id:operatorInstance.id]"><i class="glyphicon glyphicon glyphicon glyphicon-eye-open"></i></g:link>
									<g:link controller="Operator" class="btn btn-default" action="edit" params="[id:operatorInstance.id]"><i class="glyphicon glyphicon glyphicon-pencil"></i></g:link>
									<a href="#" class="btn btn-default open-confirm-box" wizard-url="Operator/delete/${operatorInstance.id}" wizard-title="Delete"><i class="glyphicon glyphicon glyphicon-remove"></i></a>
								</div>
							</div>
						</td>
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="navbar-form navbar-right">
				<div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
					<div class="btn-group">
						<g:select class="number-of-item-per-page form-control" name="user.age" from="${[5,10,20,50,100,500]}" value="${params?.max?:com.boitalik.app.GlobalConfigService.itemsPerPage()}" />
					</div>
					<div class="btn-group paginate">
						<g:paginate total="${operatorInstanceCount ?: 0}" />
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

