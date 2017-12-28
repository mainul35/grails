package com.hmtmcse.phonebook

class PersonGroup {

    Integer id
    String name
    String type

    static belongsTo = PhoneNumber
    static hasMany = [phoneNumber: PhoneNumber]

    static constraints = {
    }
}
