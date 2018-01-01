package com.hmtmcse.phonebook

class ContactGroup {

    Integer id
    String name

    Date dateCreated
    Date lastUpdated

    static belongsTo = Contact
    static hasMany = [contact: Contact]

    static constraints = {
        name(blank: false, nullable: false)
    }

    static mapping = {
        version(false)
    }
}
