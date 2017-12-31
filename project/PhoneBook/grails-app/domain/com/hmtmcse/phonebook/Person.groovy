package com.hmtmcse.phonebook

class Person {

    Integer id
    String name
    String image
    Member member

    Date dateCreated
    Date lastUpdated


    static hasMany = [phoneNumber: PhoneNumber]


    static constraints = {
    }
}
