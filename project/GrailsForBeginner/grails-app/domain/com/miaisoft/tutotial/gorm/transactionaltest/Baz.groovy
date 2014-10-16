package com.miaisoft.tutotial.gorm.transactionaltest

class Baz {

    String name
    static constraints = {
        name unique:true
    }
}
