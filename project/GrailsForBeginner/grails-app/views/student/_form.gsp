<%@ page import="com.miaisoft.tutotial.gorm.Student" %>



<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'intake', 'error')} required">
	<label for="intake">
		<g:message code="student.intake.label" default="Intake" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="intake" required="" value="${studentInstance?.intake}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="student.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${studentInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'program', 'error')} required">
	<label for="program">
		<g:message code="student.program.label" default="Program" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="program" required="" value="${studentInstance?.program}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'section', 'error')} required">
	<label for="section">
		<g:message code="student.section.label" default="Section" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="section" required="" value="${studentInstance?.section}"/>

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
	<g:select name="subject" from="${com.miaisoft.tutotial.gorm.Subject.list()}" multiple="multiple" optionKey="id" size="5" value="${studentInstance?.subject*.id}" class="many-to-many"/>

</div>

