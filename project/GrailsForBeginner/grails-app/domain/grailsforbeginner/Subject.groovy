package grailsforbeginner

class Subject {

    Long id
    String name

    static belongsTo = Student
    static hasMany = [student:Student]

    static constraints = {
    }
}
