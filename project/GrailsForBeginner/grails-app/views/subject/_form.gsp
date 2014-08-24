<%@ page import="com.miaisoft.tutotial.gorm.Subject" %>



<div class="fieldcontain ${hasErrors(bean: subjectInstance, field: 'courseCode', 'error')} required">
	<label for="courseCode">
		<g:message code="subject.courseCode.label" default="Course Code" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="courseCode" required="" value="${subjectInstance?.courseCode}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: subjectInstance, field: 'courseTitle', 'error')} required">
	<label for="courseTitle">
		<g:message code="subject.courseTitle.label" default="Course Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="courseTitle" required="" value="${subjectInstance?.courseTitle}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: subjectInstance, field: 'credit', 'error')} required">
	<label for="credit">
		<g:message code="subject.credit.label" default="Credit" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="credit" required="" value="${subjectInstance?.credit}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: subjectInstance, field: 'student', 'error')} ">
	<label for="student">
		<g:message code="subject.student.label" default="Student" />
		
	</label>
	

</div>

