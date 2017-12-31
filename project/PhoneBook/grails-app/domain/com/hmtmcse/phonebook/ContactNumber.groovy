package com.hmtmcse.phonebook

class ContactNumber {

    Integer id
    String number
    String type

    Date dateCreated
    Date lastUpdated

    static hasMany = [contactGroup: ContactGroup]

    static constraints = {
    }
}
