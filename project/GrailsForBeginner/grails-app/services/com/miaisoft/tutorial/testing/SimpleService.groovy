package com.miaisoft.tutorial.testing


class SimpleService {

    def create(def params) {
        Simple simple = new Simple(params)
        def res = simple.save(flush: true);
        if (res.hasErrors()){
            res.errors.each {
                println(it)
            }
            return false
        }else{
            return true
        }
    }

    def read() {

    }

    def update() {

    }

    def delete() {

    }
}
