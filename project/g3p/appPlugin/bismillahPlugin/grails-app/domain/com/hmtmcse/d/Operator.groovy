package com.hmtmcse.d

class Operator {

    Integer id
    String name
    String email
    String password

    def beforeInsert() {
        this.password = this.password.encodeAsMD5();
    }
}
