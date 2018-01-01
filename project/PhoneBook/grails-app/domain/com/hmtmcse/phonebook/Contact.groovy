package com.hmtmcse.phonebook

class Contact {

    Integer id
    String name
    String image
    Member member

    Date dateCreated
    Date lastUpdated


    static hasMany = [contactNumber: ContactNumber]


    static constraints = {
        image(nullable: true, blank: true)
        image(nullable: true, blank: true)
    }

    static mapping = {
        version(false)
    }
}
