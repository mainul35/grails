package com.hmtmcse.gsaas


class BootStrap {


    def init = { servletContext ->
        AppInitializationService.initialize()
    }

    def destroy = {
    }
}
