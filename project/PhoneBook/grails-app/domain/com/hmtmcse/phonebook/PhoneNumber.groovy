package com.hmtmcse.phonebook

class PhoneNumber {

    Integer id
    String number
    String type

    Date created
    Date updated

    static hasMany = [personGroup: PersonGroup]

    static constraints = {
    }
}
