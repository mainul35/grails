package com.miaisoft.tutotial.testing

import com.miaisoft.tutorial.testing.Simple
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(SimpleController)
@Mock(Simple)
class SimpleControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test hello"() {
        when:
        controller.hello()
        then:
        response.text == 'hello'
    }

    void 'test index redirection'() {
        when:
        controller.index()
        then:
        response.redirectedUrl == '/simple/hello'
    }

    void 'test home page'() {
        when:
        controller.home()

        then:
        view == '/simple/homePage'
        model.title == 'Hello World'
    }

//    void 'test consume book xml'() {
//        when:
//        request.xml = '<book title="The Stand"/>'
//        controller.consumeBook()
//
//        then:
//        response.text == 'The XML Title Is The Stand.'
//    }


    void 'test consume book json'() {
        when:
        request.json = '{title: "Banglar Bag"}'
        controller.consumeBookJSON()

        then:
        response.text == 'The title is Banglar Bag.'
    }

    void "test saving an invalid Content"() {
        when:
        controller.save()

        then:
        model.bookInstance != null
        view == '/simple/create'
    }

    void "test saving a valid Content"() {
        when:
        params.name = "Touhid Mia"
        params.email = "hmtm.cse@gmail.com"
        controller.save()

        then:
        response.redirectedUrl == '/simple/show/1'
        flash.message != null
        Simple.count() == 1
    }

}
