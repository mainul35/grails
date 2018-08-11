package com.hmtmcse.gsaas

import grails.gorm.MultiTenant

class Contact implements MultiTenant<Contact> {

    Integer id
    String name
    String image
    Member member

    Date dateCreated
    Date lastUpdated


    static hasMany = [contactNumber: ContactNumber, contactGroup: ContactGroup]


    static constraints = {
        image(nullable: true, blank: true)
    }

    static mapping = {
        version(false)
        contactNumber(cascade: 'all-delete-orphan')
    }
}
