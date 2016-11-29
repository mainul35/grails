package com.hmtmcse.basic

import grails.test.mixin.TestFor
import spock.lang.Specification


@TestFor(SimpleController)
class SimpleControllerSpec extends Specification {

    void "bismillah"() {
        when:
        controller.bismillah()

        then:
        response.text == "Bismillahir Rahmanier Rahim"
    }


    void "redirect test"() {
        when:
        controller.redirectTo()

        then:
        response.redirectedUrl == "/simple/redirectHere1"
    }


}
