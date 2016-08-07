package com.hmtmcse

class Student {

    Integer id
    String name
    String department

    static constraints = {
        name()
        department()
    }
}
