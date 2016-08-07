<% import grails.persistence.Event %>
<%=packageName%>
<meta name="layout" content="my-layout">
<title><g:message code="${propertyName}" default="${className}"/> List</title>
<div class="row">
	<div class="panel panel-primary">
		<div class="panel-heading">
			${className} List
		</div>
		<div class="panel-body">
			<div class="navbar-form navbar-right" >
				<div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
					<div class="btn-group" role="group" aria-label="Third group">


						<g:form controller="${className}" action="index" method="GET">
							<div class="input-group" id="search-area">
								<div class="input-group-btn">
									<div class="btn-group">
										<button type="button" class="btn btn-default selected-column-label">Select</button>
										<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
											<span class="caret"></span>
											<span class="sr-only">Toggle Dropdown</span>
										</button>
										<ul class="dropdown-menu selected-column-name" role="menu" selected-data="\${params.colName}">

											<%  excludedProps = Event.allEvents.toList() << 'id' << 'version'
											allowedNames = domainClass.persistentProperties*.name << 'dateCreated' << 'lastUpdated'
											props = domainClass.properties.findAll { allowedNames.contains(it.name) && !excludedProps.contains(it.name) && it.type != null && !Collection.isAssignableFrom(it.type) && (domainClass.constrainedProperties[it.name] ? domainClass.constrainedProperties[it.name].display : true) }
											Collections.sort(props, comparator.constructors[0].newInstance([domainClass] as Object[]))
											props.eachWithIndex { p, i ->
												if (i < 6) {
													if (p.isAssociation()) { %>
											<li data="${p.name}"><a href="#"><g:message code="${p.name}" default="${p.naturalName}" /></a></li>
											<%      } else { %>
											<li data="${p.name}"><a href="#"><g:message code="${p.name}" default="${p.naturalName}" /></a></li>
											<%  }   }   } %>
										</ul>
									</div>
								</div>
								<g:textField name="colValue" class="form-control" value="\${params?.colValue}"/>
								<g:hiddenField name="colName" class="selected-column-name" value="\${params?.colName}"/>
								<span class="input-group-btn">
									<button class="btn btn-default" type="submit">Search</button>
								</span>
							</div>
						</g:form>


					</div>
					<div class="btn-group" role="group" aria-label="First group">
						<g:link action="create" controller="${className}" class="btn  btn-success">Add New</g:link>
						<g:link action="index" controller="${className}" class="btn  btn-info">Reload</g:link>
					</div>
				</div>
			</div>
			<table class="table table-bordered table-striped">
				<thead>
				<tr>
					<%  excludedProps = Event.allEvents.toList() << 'id' << 'version'
					allowedNames = domainClass.persistentProperties*.name << 'dateCreated' << 'lastUpdated'
					props = domainClass.properties.findAll { allowedNames.contains(it.name) && !excludedProps.contains(it.name) && it.type != null && !Collection.isAssignableFrom(it.type) && (domainClass.constrainedProperties[it.name] ? domainClass.constrainedProperties[it.name].display : true) }
					Collections.sort(props, comparator.constructors[0].newInstance([domainClass] as Object[]))
					props.eachWithIndex { p, i ->
						if (i < 6) {
							if (p.isAssociation()) { %>
					<th><g:message code="${p.name}" default="${p.naturalName}" /></th>
					<%      } else { %>
					<g:sortableColumn property="${p.name}" title="\${message(code: '${p.name}', default: '${p.naturalName}')}" />
					<%  }   }   } %>
					<th class="action-row" >Action</th>
				</tr>
				</thead>
				<tbody>
				<g:each in="\${${propertyName}List}" status="i" var="${propertyName}">
					<tr class="text-center">
						<%  props.eachWithIndex { p, i ->
							if (i == 0) { %>
						<td>\${${propertyName}?.${p.name}}</td>
						<%      } else if (i < 6) {
							if (p.type == Boolean || p.type == boolean) { %>
						<td><g:formatBoolean boolean="\${${propertyName}.${p.name}}" /></td>
						<%          } else if (p.type == Date || p.type == java.sql.Date || p.type == java.sql.Time || p.type == Calendar) { %>
						<td><g:formatDate date="\${${propertyName}.${p.name}}" format="dd MMM yyyy" /></td>
						<%          } else { %>
						<td>\${${propertyName}?.${p.name}}</td>
						<%  }   }   } %>
						<td class="action-row">
							<div class="btn-toolbar">
								<div class="btn-group  btn-group-justified">
									<g:link controller="${className}" class="btn btn-default" action="show" params="[id:${propertyName}.id]"><i class="glyphicon glyphicon glyphicon glyphicon-eye-open"></i></g:link>
									<g:link controller="${className}" class="btn btn-default" action="edit" params="[id:${propertyName}.id]"><i class="glyphicon glyphicon glyphicon-pencil"></i></g:link>
									<a href="#" class="btn btn-default open-confirm-box" wizard-url="${className}/delete/\${${propertyName}.id}" wizard-title="Delete"><i class="glyphicon glyphicon glyphicon-remove"></i></a>
								</div>
							</div>
						</td>
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="paginate">
				<g:paginate total="\${${propertyName}InstanceCount ?: 0}" />
			</div>
		</div>
	</div>
</div>

