package com.hmtmcse.phonebook

import grails.web.servlet.mvc.GrailsParameterMap


class ContactGroupService {

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
        List<ContactGroup> contactGroupList = ContactGroup.list()
        return contactGroupList
    }

}
