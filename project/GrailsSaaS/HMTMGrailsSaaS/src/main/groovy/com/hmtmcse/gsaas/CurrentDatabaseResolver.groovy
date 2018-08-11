package com.hmtmcse.gsaas

import org.grails.datastore.mapping.multitenancy.TenantResolver
import org.grails.datastore.mapping.multitenancy.exceptions.TenantNotFoundException

class CurrentDatabaseResolver implements TenantResolver {


    @Override
    Serializable resolveTenantIdentifier() throws TenantNotFoundException {
        return null
    }

}
