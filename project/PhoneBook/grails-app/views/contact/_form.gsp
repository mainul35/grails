<div class="form-group">
    <label><g:message code="contact.name"/> *</label>
    <g:textField name="name" class="form-control" value="${contact?.name}" placeholder="Please Enter Contact Name"/>
    <UIHelper:renderErrorMessage fieldName="firstName" model="${contact}" errorMessage="please.enter.name"/>
</div>
