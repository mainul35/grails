package com.hmtmcse.gsaas

import grails.gorm.MultiTenant

class ContactNumber implements MultiTenant<ContactNumber> {

    Integer id
    String number
    String type
    Contact contact

    Date dateCreated
    Date lastUpdated


    static constraints = {
    }

    static mapping = {
        version(false)
    }
}
