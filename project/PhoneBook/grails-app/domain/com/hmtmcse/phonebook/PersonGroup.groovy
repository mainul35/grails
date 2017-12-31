package com.hmtmcse.phonebook

class PersonGroup {

    Integer id
    String name

    Date dateCreated
    Date lastUpdated

    static belongsTo = PhoneNumber
    static hasMany = [phoneNumber: PhoneNumber]

    static constraints = {
    }
}
