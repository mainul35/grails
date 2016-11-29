
<div class="form-group">
	<label for="email">
		<g:message code="email" default="Email" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField class="form-control" name="email" required="" value="${operatorInstance?.email}"/>

</div>

<div class="form-group">
	<label for="name">
		<g:message code="name" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField class="form-control" name="name" required="" value="${operatorInstance?.name}"/>

</div>

<div class="form-group">
	<label for="password">
		<g:message code="password" default="Password" />
		<span class="required-indicator">*</span>
	</label>
	<g:passwordField class="form-control" name="password" required="" value="${operatorInstance?.password}"/>

</div>

