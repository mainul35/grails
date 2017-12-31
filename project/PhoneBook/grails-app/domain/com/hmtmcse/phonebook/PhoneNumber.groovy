package com.hmtmcse.phonebook

class PhoneNumber {

    Integer id
    String number
    String type

    Date dateCreated
    Date lastUpdated

    static hasMany = [personGroup: PersonGroup]

    static constraints = {
    }
}
