<title>...:: Update <g:message code="studentInstance" default="Student"/> ::...</title>
<meta name="layout" content="my-layout"/>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Update <g:message code="studentInstance" default="Student"/></h3>
    </div>
    <div class="panel-body">
        <g:form action="update"  controller="Student" >
        <g:hiddenField name="id" value="${studentInstance?.id}" />
        <g:render template="form"/>
        <div class="form-action pull-right">
            <g:submitButton name="create" class="btn btn-primary" value="${message(code: 'update', default: 'Update')}" />
            <g:link action="index" controller="Student" class="btn  btn-danger">Cancel</g:link>
        </div>
        </g:form>
    </div>
</div>