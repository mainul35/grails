
package com.miaisoft.tutotial.gorm

class Subject {

    Long id
    String courseCode
    String courseTitle
    String credit

    static hasMany = ["student":Student]



    static constraints = {
    }
}
