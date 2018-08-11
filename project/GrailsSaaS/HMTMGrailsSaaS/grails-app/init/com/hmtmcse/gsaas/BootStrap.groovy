package com.hmtmcse.gsaas

import com.hmtmcse.gsaas.provision.DatabaseProvisioningService


class BootStrap {

    DatabaseProvisioningService databaseProvisioningService

    def init = { servletContext ->
//        databaseProvisioningService.placeHolderDb("hmtm_grails_saas")


//        AppInitializationService.initialize()
    }

    def destroy = {
    }
}
