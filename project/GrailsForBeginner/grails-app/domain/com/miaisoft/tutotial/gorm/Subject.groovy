
package com.miaisoft.tutotial.gorm

class Subject {

    Long id
    String courseCode
    String courseTitle
    String credit



    static belongsTo = Student
    static hasMany = [student:Student]


    static constraints = {
    }
}
