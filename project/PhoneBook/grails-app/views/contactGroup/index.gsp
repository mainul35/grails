<meta name="layout" content="main"/>

<div class="card">
    <div class="card-header">
        <g:message code="contact.group" args="['']"/>
        <span class="float-right">
            <div class="btn-group">
                <g:link controller="contactGroup" action="create" class="btn btn-success"><g:message code="create"/></g:link>
                <g:link controller="contactGroup" action="index" class="btn btn-primary"><g:message code="reload"/></g:link>
            </div>
        </span>
    </div>
    <div class="card-body">
        <table class="table table-bordered">
            <thead class="thead-dark">
            <tr>
                <g:sortableColumn property="name" title="${g.message(code: "name")}"/>
                <th><g:message code="action"/></th>
            </tr>
            </thead>
            <tbody>
                <g:each in="${contactGroups}" var="group">
                    <tr>
                        <td>${group?.name}</td>
                        <td>Action</td>
                    </tr>
                </g:each>
            </tbody>
        </table>
    </div>
</div>