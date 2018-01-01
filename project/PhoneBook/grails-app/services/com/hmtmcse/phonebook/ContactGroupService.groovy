package com.hmtmcse.phonebook

import com.hmtmcse.phonebook.controllers.ContactGroupController
import grails.web.servlet.mvc.GrailsParameterMap


class ContactGroupService {

    GlobalConfigService globalConfigService

    def save(GrailsParameterMap params) {
        ContactGroup contactGroup = new ContactGroup(params)
        def response = AppUtil.saveResponse(false, contactGroup)
        if (contactGroup.validate()) {
            response.isSuccess = true
            contactGroup.save()
        }
        return response
    }

    def update(ContactGroup contactGroup, GrailsParameterMap params) {
        contactGroup.properties = params
        def response = AppUtil.saveResponse(false, contactGroup)
        if (contactGroup.validate()) {
            response.isSuccess = true
            contactGroup.save(flush:true)
        }
        return response
    }

    def get(Serializable id) {
        return ContactGroup.get(id)
    }

    def list(GrailsParameterMap params) {
        params.max = params.max?:globalConfigService.itemsPerPage()
        List<ContactGroup> contactGroupList = ContactGroup.createCriteria().list(params) {
            if (params?.colName && params?.colValue){
                like(params.colName, "%" +  params.colValue + "%")
            }
            if (!params.sort){
                order("id","desc")
            }
        }
        return [list:contactGroupList, count:ContactGroup.count()]
    }

    def delete(ContactGroup contactGroup) {
        try {
            contactGroup.delete(flush: true)
        }catch (Exception e){
            println(e.getMessage())
            return false
        }
        return true
    }

}
