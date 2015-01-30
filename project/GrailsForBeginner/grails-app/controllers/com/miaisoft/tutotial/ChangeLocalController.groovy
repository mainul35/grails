package com.miaisoft.tutotial

import org.codehaus.groovy.grails.context.support.ReloadableResourceBundleMessageSource

class ChangeLocalController {

    ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource

    def index() {
        reloadableResourceBundleMessageSource.clearCache();
        render("Changed")
    }
}
