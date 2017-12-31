package com.hmtmcse.phonebook

class ContactGroup {

    Integer id
    String name

    Date dateCreated
    Date lastUpdated

    static belongsTo = ContactNumber
    static hasMany = [contactNumber: ContactNumber]

    static constraints = {
        name(blank: false, nullable: false)
    }

    static mapping = {
        version(false)
    }
}
