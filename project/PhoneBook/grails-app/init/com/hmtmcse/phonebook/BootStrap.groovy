package com.hmtmcse.phonebook

class BootStrap {

    GlobalConfigService globalConfigService

    def init = { servletContext ->
        globalConfigService.initializer()
    }

    def destroy = {
    }
}
