
<meta name="layout" content="app"/>
<title><g:message code="operatorInstance" default="Operator"/> Details</title>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title"><g:message code="operatorInstance" default="Operator"/> Details</h3>
    </div>
    <div class="panel-body">
        
        <g:if test="${operatorInstance?.email}">
            <div class="input-group">
                <span class="input-group-addon"><g:message code="email" default="Email" /></span>
                    
                    <span class="form-control" aria-labelledby="email-label"><g:fieldValue bean="${operatorInstance}" field="email"/></span>
                    
            </div>
        </g:if>
        
        <g:if test="${operatorInstance?.name}">
            <div class="input-group">
                <span class="input-group-addon"><g:message code="name" default="Name" /></span>
                    
                    <span class="form-control" aria-labelledby="name-label"><g:fieldValue bean="${operatorInstance}" field="name"/></span>
                    
            </div>
        </g:if>
        
        <g:if test="${operatorInstance?.password}">
            <div class="input-group">
                <span class="input-group-addon"><g:message code="password" default="Password" /></span>
                    
                    <span class="form-control" aria-labelledby="password-label"><g:fieldValue bean="${operatorInstance}" field="password"/></span>
                    
            </div>
        </g:if>
        
    </div>
</div>