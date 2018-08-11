package com.hmtmcse.gsaas


class AppInitializationService {

    static initialize() {
        Member member = initMember()
        if (member){
            initContactGroup(member)
        }
    }

    private static initMember() {
        if (Member.count() == 0) {
            Member member = new Member()
            member.firstName = "Touhid"
            member.lastName = "Mia"
            member.email = "phonebook@hmtmcse.com"
            member.password = "123456"
            member.save(flash: true)
            return member
        }
        return null
    }

    private static initContactGroup(Member member){
        if (ContactGroup.count() == 0) {
            [
                    ["name": "Family"],
                    ["name": "Friend"],
                    ["name": "Office"],
                    ["name": "Other"],
            ].each { contactGroup ->
                new ContactGroup(name: contactGroup.name, member: member).save(flush: true)
            }
        }
    }

}
