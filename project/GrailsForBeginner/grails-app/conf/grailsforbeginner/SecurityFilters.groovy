package grailsforbeginner

import grails.converters.JSON

class SecurityFilters {

    BasicAuthenticationService basicAuthenticationService

    def filters = {
        all(controller:'*', action:'*') {
            before = {
                if (controllerName && controllerName.substring(0,3) == 'api'){
                    def response = basicAuthenticationService.check(request)
                    if (response){
                        return true
                    }else{
                        render (status: "401", text:  '{"success":"false","code":"041","message":"Access Forbidden"}', contentType: "application/json")
                        return false
                    }
                }
            }
            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }
    }
}
