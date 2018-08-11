package demo

import groovy.transform.CompileStatic
import org.grails.datastore.mapping.multitenancy.TenantResolver
import org.grails.datastore.mapping.multitenancy.exceptions.TenantNotFoundException
import org.springframework.web.context.request.RequestAttributes
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletWebRequest

import javax.servlet.http.HttpServletRequest

@CompileStatic
class CurrentUserByJwtTenantResolver implements TenantResolver {

    public static final String HEADER_NAME = 'Authorization'
    public static final String HEADER_VALUE_PREFFIX = 'Bearer '

    String headerName = HEADER_NAME
    String headerValuePreffix = HEADER_VALUE_PREFFIX


    @Override
    Serializable resolveTenantIdentifier() throws TenantNotFoundException {

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes()
        if(requestAttributes instanceof ServletWebRequest) {
            HttpServletRequest httpServletRequest = ((ServletWebRequest) requestAttributes).getRequest()
            return httpServletRequest.getParameter("tenant")
        }
        throw new TenantNotFoundException("Tenant could not be resolved outside a web request")
    }
}
