<%@ page import="grailsforbeginner.Student" %>



<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="student.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${studentInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'studentID', 'error')} required">
	<label for="studentID">
		<g:message code="student.studentID.label" default="Student ID" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="studentID" required="" value="${studentInstance?.studentID}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'subject', 'error')} ">
	<label for="subject">
		<g:message code="student.subject.label" default="Subject" />
		
	</label>
	<g:select name="subject" from="${grailsforbeginner.Subject.list()}" multiple="multiple" optionKey="id" size="5" value="${studentInstance?.subject*.id}" class="many-to-many"/>

</div>

