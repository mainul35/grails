package com.hmtmcse.phonebook

class BootStrap {

    MemberService memberService

    def init = { servletContext ->

        if (ContactGroup.count() == 0) {
            [
                    ["name": "Family"],
                    ["name": "Friend"],
                    ["name": "Office"],
                    ["name": "Other"],
            ].each { contactGroup ->
                new ContactGroup(name: contactGroup.name).save(flush: true)
            }
        }

    }

    def destroy = {
    }
}
