package com.miaisoft.tutotial.testing

import com.miaisoft.tutorial.testing.StudentService
import com.miaisoft.tutorial.testing.SubjectService
import com.miaisoft.tutotial.gorm.Student
import spock.lang.*

/**
 *
 */
class StudentIntegrationSpec extends Specification {

    static tran

    StudentService studentService
    SubjectService subjectService

    void "test create student add Subject"() {

        when:
        def student = studentService.create(["name":name,"studentID":studentID,"intake":intake,"program":program,"section":section])

        def params = [:]
        params.courseCode = "CSE-301"
        params.courseTitle = "Software Engineering"
        params.credit = "3"
        params.student = student
        def subject = subjectService.create(params)

        then:
        subject != null
        student != null
        Student.findById((Long) student.id) != null;

        where:
        name                |       intake        |        program        |        section        |        studentID
        "Touhid Mia"        |   "1"               |    "CSE"              |       "11th"          |       "5465465454"


    }

}
