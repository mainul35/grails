package com.miaisoft.tutorial.testing

import com.miaisoft.tutotial.gorm.Subject


class SubjectService {

    def create(def params) {
        Subject subject = new Subject(params);
        def res = subject.save()
        return res;
    }

    def test(){
        return "Hi This is Touhid"
    }
}
