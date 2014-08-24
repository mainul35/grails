
<%@ page import="com.miaisoft.tutotial.gorm.Subject" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'subject.label', default: 'Subject')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-subject" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-subject" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list subject">
			
				<g:if test="${subjectInstance?.courseCode}">
				<li class="fieldcontain">
					<span id="courseCode-label" class="property-label"><g:message code="subject.courseCode.label" default="Course Code" /></span>
					
						<span class="property-value" aria-labelledby="courseCode-label"><g:fieldValue bean="${subjectInstance}" field="courseCode"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${subjectInstance?.courseTitle}">
				<li class="fieldcontain">
					<span id="courseTitle-label" class="property-label"><g:message code="subject.courseTitle.label" default="Course Title" /></span>
					
						<span class="property-value" aria-labelledby="courseTitle-label"><g:fieldValue bean="${subjectInstance}" field="courseTitle"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${subjectInstance?.credit}">
				<li class="fieldcontain">
					<span id="credit-label" class="property-label"><g:message code="subject.credit.label" default="Credit" /></span>
					
						<span class="property-value" aria-labelledby="credit-label"><g:fieldValue bean="${subjectInstance}" field="credit"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${subjectInstance?.student}">
				<li class="fieldcontain">
					<span id="student-label" class="property-label"><g:message code="subject.student.label" default="Student" /></span>
					
						<g:each in="${subjectInstance.student}" var="s">
						<span class="property-value" aria-labelledby="student-label"><g:link controller="student" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:subjectInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${subjectInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
