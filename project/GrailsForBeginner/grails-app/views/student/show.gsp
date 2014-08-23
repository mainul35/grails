
<%@ page import="com.miaisoft.tutotial.gorm.Student" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'student.label', default: 'Student')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-student" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-student" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list student">
			
				<g:if test="${studentInstance?.intake}">
				<li class="fieldcontain">
					<span id="intake-label" class="property-label"><g:message code="student.intake.label" default="Intake" /></span>
					
						<span class="property-value" aria-labelledby="intake-label"><g:fieldValue bean="${studentInstance}" field="intake"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${studentInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="student.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${studentInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${studentInstance?.program}">
				<li class="fieldcontain">
					<span id="program-label" class="property-label"><g:message code="student.program.label" default="Program" /></span>
					
						<span class="property-value" aria-labelledby="program-label"><g:fieldValue bean="${studentInstance}" field="program"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${studentInstance?.section}">
				<li class="fieldcontain">
					<span id="section-label" class="property-label"><g:message code="student.section.label" default="Section" /></span>
					
						<span class="property-value" aria-labelledby="section-label"><g:fieldValue bean="${studentInstance}" field="section"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${studentInstance?.studentID}">
				<li class="fieldcontain">
					<span id="studentID-label" class="property-label"><g:message code="student.studentID.label" default="Student ID" /></span>
					
						<span class="property-value" aria-labelledby="studentID-label"><g:fieldValue bean="${studentInstance}" field="studentID"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${studentInstance?.subject}">
				<li class="fieldcontain">
					<span id="subject-label" class="property-label"><g:message code="student.subject.label" default="Subject" /></span>
					
						<g:each in="${studentInstance.subject}" var="s">
						<span class="property-value" aria-labelledby="subject-label"><g:link controller="subject" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:studentInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${studentInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
