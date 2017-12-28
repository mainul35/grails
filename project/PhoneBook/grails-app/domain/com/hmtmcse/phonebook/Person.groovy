package com.hmtmcse.phonebook

class Person {

    Integer id
    String name
    String image
    Member member


    static hasMany = [phoneNumber: PhoneNumber]


    static constraints = {
    }
}
