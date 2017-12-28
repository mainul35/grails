package com.hmtmcse.phonebook

class Member {


    Integer id
    String firstName
    String lastName
    String email
    String password

    Date created
    Date updated

    static hasMany = [person: Person]

    static constraints = {
    }
}
