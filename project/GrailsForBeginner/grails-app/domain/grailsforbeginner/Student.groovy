package grailsforbeginner

class Student {

    Long id
    String name
    String studentID

    static hasMany = [subject:Subject]

    static constraints = {
    }
}
