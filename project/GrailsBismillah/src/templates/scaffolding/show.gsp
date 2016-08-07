<% import grails.persistence.Event %>
<meta name="layout" content="my-layout"/>
<title><g:message code="${propertyName}" default="${className}"/> Details</title>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title"><g:message code="${propertyName}" default="${className}"/> Details</h3>
    </div>
    <div class="panel-body">
        <%  excludedProps = Event.allEvents.toList() << 'id' << 'version'
        allowedNames = domainClass.persistentProperties*.name << 'dateCreated' << 'lastUpdated'
        props = domainClass.properties.findAll { allowedNames.contains(it.name) && !excludedProps.contains(it.name) && (domainClass.constrainedProperties[it.name] ? domainClass.constrainedProperties[it.name].display : true) }
        Collections.sort(props, comparator.constructors[0].newInstance([domainClass] as Object[]))
        props.each { p -> %>
        <g:if test="\${${propertyName}?.${p.name}}">
            <div class="input-group">
                <span class="input-group-addon"><g:message code="${p.name}" default="${p.naturalName}" /></span>
                    <%  if (p.isEnum()) { %>
                    <span class="form-control" aria-labelledby="${p.name}-label"><g:fieldValue bean="\${${propertyName}}" field="${p.name}"/></span>
                    <%  } else if (p.oneToMany || p.manyToMany) { %>
                    <g:each in="\${${propertyName}.${p.name}}" var="${p.name[0]}">
                        <span class="form-control" aria-labelledby="${p.name}-label"><g:link controller="${p.referencedDomainClass?.propertyName}" action="show" id="\${${p.name[0]}.id}">\${${p.name[0]}?.encodeAsHTML()}</g:link></span>
                    </g:each>
                    <%  } else if (p.manyToOne || p.oneToOne) { %>
                    <span class="form-control" aria-labelledby="${p.name}-label"><g:link controller="${p.referencedDomainClass?.propertyName}" action="show" id="\${${propertyName}?.${p.name}?.id}">\${${propertyName}?.${p.name}?.encodeAsHTML()}</g:link></span>
                    <%  } else if (p.type == Boolean || p.type == boolean) { %>
                    <span class="form-control" aria-labelledby="${p.name}-label"><g:formatBoolean boolean="\${${propertyName}?.${p.name}}" /></span>
                    <%  } else if (p.type == Date || p.type == java.sql.Date || p.type == java.sql.Time || p.type == Calendar) { %>
                    <span class="form-control" aria-labelledby="${p.name}-label"><g:formatDate date="\${${propertyName}?.${p.name}}" /></span>
                    <%  } else if (!p.type.isArray()) { %>
                    <span class="form-control" aria-labelledby="${p.name}-label"><g:fieldValue bean="\${${propertyName}}" field="${p.name}"/></span>
                    <%  } %>
            </div>
        </g:if>
        <%  } %>
    </div>
</div>