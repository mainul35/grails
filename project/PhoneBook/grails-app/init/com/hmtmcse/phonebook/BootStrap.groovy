package com.hmtmcse.phonebook

class BootStrap {

    def init = { servletContext ->

        [
                ["name": "Family"],
                ["name": "Friend"],
                ["name": "Office"],
                ["name": "Other"],
        ].each { name ->
            new PersonGroup(name: name).save(flush: true)
        }


    }
    def destroy = {
    }
}
