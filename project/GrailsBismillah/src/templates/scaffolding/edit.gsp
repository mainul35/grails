<title>...:: Update <g:message code="${propertyName}" default="${className}"/> ::...</title>
<meta name="layout" content="my-layout"/>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Update <g:message code="${propertyName}" default="${className}"/></h3>
    </div>
    <div class="panel-body">
        <g:form action="update" <%=multiPart ? ' enctype="multipart/form-data"' : '' %> controller="${className}" >
        <g:hiddenField name="id" value="\${${propertyName}?.id}" />
        <g:render template="form"/>
        <div class="form-action pull-right">
            <g:submitButton name="create" class="btn btn-primary" value="\${message(code: 'update', default: 'Update')}" />
            <g:link action="index" controller="${className}" class="btn  btn-danger">Cancel</g:link>
        </div>
        </g:form>
    </div>
</div>