package com.hmtmcse

class Operator {

    Integer id
    String name
    String email
    String password
    String uuid

    static constraints = {
        uuid(nullable: true)
    }

    def beforeInsert() {
        uuid = GlobalConfigService.getUID();
        this.password = this.password.encodeAsMD5();
    }
}
