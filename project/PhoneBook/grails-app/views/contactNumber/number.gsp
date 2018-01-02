<g:each in="${numbers}" var="number">
    <g:hiddenField name="numberId" value="${number.id}"/>
    <g:render template="form" model="[number:number]"/>
</g:each>
<g:render template="form"/>