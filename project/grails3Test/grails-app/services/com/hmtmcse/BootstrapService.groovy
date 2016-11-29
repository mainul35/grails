package com.hmtmcse

class BootstrapService {

    def initOperator() {
        if (Operator.count() == 0) {
            new Operator(email: "test@grails.org", password: "test", name: "Touhid Mia").save();
        }
    }

}
