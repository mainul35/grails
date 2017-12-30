package com.hmtmcse.phonebook

class Member {
    Integer id
    String firstName
    String lastName
    String email
    String password

    Date created
    Date updated

    static constraints = {
        email(email: true, nullable: false, unique: true)
    }

    static mapping = {
        table("user")
        version(false)
    }
    static hasMany = [person: Person]
}
