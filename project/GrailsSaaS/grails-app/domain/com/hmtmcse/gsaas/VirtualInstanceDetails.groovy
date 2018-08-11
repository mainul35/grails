package com.hmtmcse.gsaas

class VirtualInstanceDetails {

    Integer id
    String dbUsername
    String dbPassword
    String dbEngine = AppConstant.DB_ENGINE_MYSQL

    String memberUsername
    String memberPassword
    String memberUUID

    static constraints = {
    }
}
