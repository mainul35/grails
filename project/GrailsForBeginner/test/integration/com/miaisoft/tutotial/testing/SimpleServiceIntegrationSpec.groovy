package com.miaisoft.tutotial.testing

import com.miaisoft.tutorial.testing.SimpleService
import grails.test.spock.IntegrationSpec

/**
 *
 */
class SimpleServiceIntegrationSpec extends IntegrationSpec {

    SimpleService simpleService

    void "test something"() {
        when:
        def params = [:]
        params.name = "Touhid Mia"
        params.email = "hmtm.cse@gmail.com"
        def res = simpleService.create(params);
        then:
        res != false

    }
}
