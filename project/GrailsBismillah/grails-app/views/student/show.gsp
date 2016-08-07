
<meta name="layout" content="my-layout"/>
<title><g:message code="studentInstance" default="Student"/> Details</title>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title"><g:message code="studentInstance" default="Student"/> Details</h3>
    </div>
    <div class="panel-body">
        
        <g:if test="${studentInstance?.name}">
            <div class="input-group">
                <span class="input-group-addon"><g:message code="name" default="Name" /></span>
                    
                    <span class="form-control" aria-labelledby="name-label"><g:fieldValue bean="${studentInstance}" field="name"/></span>
                    
            </div>
        </g:if>
        
        <g:if test="${studentInstance?.department}">
            <div class="input-group">
                <span class="input-group-addon"><g:message code="department" default="Department" /></span>
                    
                    <span class="form-control" aria-labelledby="department-label"><g:fieldValue bean="${studentInstance}" field="department"/></span>
                    
            </div>
        </g:if>
        
    </div>
</div>