package com.hmtmcse.phonebook

class Person {

    Integer id
    String name
    String image
    Member member

    Date created
    Date updated


    static hasMany = [phoneNumber: PhoneNumber]


    static constraints = {
    }
}
