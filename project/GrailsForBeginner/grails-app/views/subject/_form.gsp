<%@ page import="grailsforbeginner.Subject" %>



<div class="fieldcontain ${hasErrors(bean: subjectInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="subject.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${subjectInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: subjectInstance, field: 'student', 'error')} ">
	<label for="student">
		<g:message code="subject.student.label" default="Student" />
		
	</label>
	

</div>
