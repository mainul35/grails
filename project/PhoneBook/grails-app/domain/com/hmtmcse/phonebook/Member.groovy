package com.hmtmcse.phonebook

class Member {


    Integer id
    String firstName
    String lastName
    String email
    String password

    static hasMany = [person: Person]

    static constraints = {
    }
}
