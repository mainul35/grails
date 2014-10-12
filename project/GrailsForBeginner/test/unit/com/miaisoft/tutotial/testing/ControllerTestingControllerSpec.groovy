package com.miaisoft.tutotial.testing

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(ControllerTestingController)
class ControllerTestingControllerSpec extends Specification {
    void "test hello"() {
        when:
        controller.hello()

        then:
        response.text == 'hello'
    }
}
