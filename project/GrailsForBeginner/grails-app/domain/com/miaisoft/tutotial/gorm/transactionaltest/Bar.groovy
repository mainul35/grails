package com.miaisoft.tutotial.gorm.transactionaltest

class Bar {
    String name
    static constraints = {
        name unique:true
    }
}
