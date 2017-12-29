package com.hmtmcse.phonebook

class PersonGroup {

    Integer id
    String name

    Date created
    Date updated

    static belongsTo = PhoneNumber
    static hasMany = [phoneNumber: PhoneNumber]

    static constraints = {
    }
}
