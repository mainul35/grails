package com.miaisoft.tutotial.gorm.transactionaltest

class Foo {
    String name
    static constraints = {
        name unique:true
    }
}
