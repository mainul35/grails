package com.miaisoft.tutotial.gorm

class Program {

    Long id
    String name

    static hasMany = [student:Student]

    static constraints = {
    }
}
