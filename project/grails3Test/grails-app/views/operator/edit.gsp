<title>...:: Update <g:message code="operatorInstance" default="Operator"/> ::...</title>
<meta name="layout" content="app"/>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Update <g:message code="operatorInstance" default="Operator"/></h3>
    </div>
    <div class="panel-body">
        <g:form action="update"  controller="Operator" >
        <g:hiddenField name="id" value="${operatorInstance?.id}" />
        <g:render template="form"/>
        <div class="form-action pull-right">
            <g:submitButton name="create" class="btn btn-primary" value="${message(code: 'update', default: 'Update')}" />
            <g:link action="index" controller="Operator" class="btn  btn-danger">Cancel</g:link>
        </div>
        </g:form>
    </div>
</div>