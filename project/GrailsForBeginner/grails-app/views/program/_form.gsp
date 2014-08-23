<%@ page import="com.miaisoft.tutotial.gorm.Program" %>



<div class="fieldcontain ${hasErrors(bean: programInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="program.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${programInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: programInstance, field: 'student', 'error')} ">
	<label for="student">
		<g:message code="program.student.label" default="Student" />
		
	</label>
	<g:select name="student" from="${com.miaisoft.tutotial.gorm.Student.list()}" multiple="multiple" optionKey="id" size="5" value="${programInstance?.student*.id}" class="many-to-many"/>

</div>

