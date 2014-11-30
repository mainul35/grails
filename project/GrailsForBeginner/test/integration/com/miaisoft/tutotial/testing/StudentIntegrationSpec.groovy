package com.miaisoft.tutotial.testing

import com.miaisoft.tutorial.testing.StudentService
import com.miaisoft.tutorial.testing.SubjectService
import com.miaisoft.tutotial.gorm.Student
import spock.lang.*

/**
 *
 */
class StudentIntegrationSpec extends Specification {

    StudentService studentService
    SubjectService subjectService


    void "test create student add Subject"() {

        when:
        def student = studentService.create(map)

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
        map << {

            SubjectService subjectService1 = new SubjectService()

            def x = subjectService1.test()

            [
                    [ name: "Touhid Mia 1",studentID:"1",intake:x,program:"program",section:"section"],
                    [ name: "Touhid Mia 2",studentID:"1",intake:"intake",program:"program",section:"section"],
                    [ name: "Touhid Mia 3",studentID:"1",intake:"intake",program:"program",section:"section"],
            ]
        }()



    }

}
