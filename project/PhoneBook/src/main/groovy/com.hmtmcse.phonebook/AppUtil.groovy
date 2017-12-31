package com.hmtmcse.phonebook

import org.grails.web.util.WebUtils

class AppUtil {


    static saveResponse(Boolean isSuccess, def model){
        return [isSuccess:isSuccess, model:model]
    }

    static getAppSession(){
       return WebUtils.retrieveGrailsWebRequest().session
    }

}
