package com.hmtmcse.gsaas

import grails.gorm.MultiTenant

class ContactGroup implements MultiTenant<ContactGroup> {

    Integer id
    String name
    Member member

    Date dateCreated
    Date lastUpdated

    static belongsTo = Contact
    static hasMany = [contact: Contact]

    static constraints = {
        name(blank: false, nullable: false)
        member(nullable: true)
    }

    static mapping = {
        version(false)
    }
}
