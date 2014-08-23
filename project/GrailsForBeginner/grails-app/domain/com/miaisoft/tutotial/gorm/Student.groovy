package com.miaisoft.tutotial.gorm

class Student {

    Long id
    String name
    String studentID
    String intake
    String program
    String section



    static belongsTo = [program:Program]
    static hasMany = ["subject":Subject]



    static constraints = {
    }
}
