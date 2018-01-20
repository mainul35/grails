package com.hmtmcse.phonebook

class BootStrap {


    def init = { servletContext ->
        AppInitializationService.initialize()
    }

    def destroy = {
    }
}
