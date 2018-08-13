package com.hmtmcse.gsaas

import com.hmtmcse.gsaas.provision.DatabaseProvisioningService

import static grails.gorm.multitenancy.Tenants.withId


class BootStrap {

    DatabaseProvisioningService databaseProvisioningService

    def init = { servletContext ->
        databaseProvisioningService.placeHolderDb("hmtm_grails_saas")


        withId("hmtm_grails_saas") {
            AppInitializationService.initialize()
        }


    }

    def destroy = {
    }
}
