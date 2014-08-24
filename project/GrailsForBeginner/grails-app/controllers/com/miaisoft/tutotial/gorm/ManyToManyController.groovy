package com.miaisoft.tutotial.gorm

class ManyToManyController {

    def insert() {
        new Student(name: "Touhid Mia",studentID: "46",intake: "11th",program: "CSE", section: "1").save() // Normal Saving
        Student student = new Student(name: "Touhid Mia",studentID: "46",intake: "11th",program: "CSE", section: "1");
        student.addToSubject(courseTitle: "Algoritham",courseCode: "CSE-113",credit: "3.0").save()  //Cascade Save
        render ("Saved")
    }
}
