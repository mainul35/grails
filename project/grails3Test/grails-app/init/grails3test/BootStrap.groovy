package grails3test

import com.hmtmcse.BootstrapService

class BootStrap {

    BootstrapService bootstrapService

    def init = { servletContext ->
        bootstrapService.initOperator();
    }
    def destroy = {
    }
}
