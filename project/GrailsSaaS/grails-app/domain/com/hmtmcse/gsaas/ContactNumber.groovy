package com.hmtmcse.gsaas

class ContactNumber {

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
