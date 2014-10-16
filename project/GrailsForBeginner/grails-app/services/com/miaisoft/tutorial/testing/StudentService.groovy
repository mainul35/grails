package com.miaisoft.tutorial.testing

import com.miaisoft.tutotial.gorm.Student


class StudentService {

    def create(def params) {
      Student student = new Student(params);
       def res = student.save();
        return res;
    }

    def list() {
        return Student.list();
    }

}
