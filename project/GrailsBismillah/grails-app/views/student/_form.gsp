<%@ page import="com.hmtmcse.Student" %>



<div class="form-group">
	<label for="name">
		<g:message code="name" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField class="form-control" name="name" required="" value="${studentInstance?.name}"/>

</div>

<div class="form-group">
	<label for="department">
		<g:message code="department" default="Department" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField class="form-control" name="department" required="" value="${studentInstance?.department}"/>

</div>

