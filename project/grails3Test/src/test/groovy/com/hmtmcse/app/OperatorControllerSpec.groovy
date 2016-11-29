package com.hmtmcse.app

import com.hmtmcse.Operator
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.*


@TestFor(OperatorController)
@Mock(Operator)
class OperatorControllerSpec extends Specification {


    void "save test"() {

        when:
        params.name = "Test"
        params.email = "test@test.com"
        params.password = "pass"
        controller.save();

        then:
        response.redirectedUrl == "/operator/index1"
    }


    void "bismillah"() {
        when:
        controller.bismillah()

        then:
        response.text == "Bismillahir Rahmanier Rahim"
    }
}