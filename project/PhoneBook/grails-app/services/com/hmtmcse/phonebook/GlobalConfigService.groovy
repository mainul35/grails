package com.hmtmcse.phonebook

import grails.web.servlet.mvc.GrailsParameterMap


class GlobalConfigService {

    MemberService memberService
    ContactGroupService contactGroupService

    public static boolean isBuilding = false;
    public static boolean isGeneratingSchema = false;

    def itemsPerPage() {
        return 5
    }

    public static String getUID(){
        return UUID.randomUUID().toString().toUpperCase();
    }


    def initializer(){
        Member member
        def params = [:]
        if (Member.count() == 0) {
            params.firstName = "Demo"
            params.lastName = "Account"
            params.email = "demo@hmtmcse.com"
            params.password = "demo"
            member = new Member(params)
            member.save()

            if (ContactGroup.count() == 0) {
                [
                        ["name": "Family"],
                        ["name": "Friend"],
                        ["name": "Office"],
                        ["name": "Other"],
                ].each { contactGroup ->
                    params = [:]
                    params.name = contactGroup.name
                    params.member = member
                    new ContactGroup(params).save(flush: true)
                }
            }
        }
    }

}
