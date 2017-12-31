package com.hmtmcse.phonebook

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

    def update(GrailsParameterMap params) {

    }

    def get(Serializable id) {

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

}
