package com.hmtmcse.phonebook

class PhoneNumber {

    Integer id
    String number
    String type

    static hasMany = [personGroup: PersonGroup]

    static constraints = {
    }
}
