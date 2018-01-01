<g:each in="${numbers}" var="number">
    <g:hiddenField name="number.id" value="${number.id}"/>
    <g:render template="form" model="[number:number]"/>
</g:each>
<g:render template="form"/>