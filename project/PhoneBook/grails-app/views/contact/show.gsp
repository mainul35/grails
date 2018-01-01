<meta name="layout" content="main"/>

<div class="card">
    <div class="card-header">
        <g:message code="contact" args="['Details']"/>
    </div>
    <div class="card-body">
        <g:if test="${contact}">
            <table class="table">
                <tr>
                    <th class="text-right">Name</th><td class="text-left">${contact.name}</td>
                </tr>
            </table>
        </g:if>
        <div class="form-action-panel">
            <g:link controller="contact" action="index" class="btn btn-primary"><g:message code="cancel"/></g:link>
        </div>
    </div>
</div>