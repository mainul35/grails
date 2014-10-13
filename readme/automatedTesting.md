### Welcme to Grails Automated Testing
##### Create Unit Test Class
```bash
1. grails create-unit-test
2. grails create-unit-test simple
3. grails create-unit-test com.miaisoft.tutotial.testing.Simple
```

##### Running Tests
```bash
grails test-app
```


##### Targeting Tests
```bash
1. grails test-app NameOfController
2. grails test-app *Controller
3. grails test-app some.org.*Controller
4. grails test-app NameOfController.methodName
```



##### Targeting Test Types and/or Phases
```bash
1. grails test-app integration:integration
2. grails test-app unit:
3. grails test-app :spock
```


##### Test Mixin Basics
1. @TestFor(BookController)            : The TestFor annotation defines the class under test and will automatically create a field for the type of class under test.
2. @Mock([Book, Author, BookService])  : The Mock annotation creates mock version of any collaborators. There is an in-memory implementation of GORM that will simulate most interactions with the GORM API.

#### Unit Testing Controllers Example
```groovy
import grails.test.mixin.TestFor
import spock.lang.Specification
@TestFor(SimpleController)
class SimpleControllerSpec extends Specification {

    void "test methodNameOfController or identifier"() {
    
    }
    
}
```


##### Test Hello World Method
```groovy
// Test Controller
class SimpleController {
    def hello() {
        render "hello"
    }
}

// Test class
import grails.test.mixin.TestFor
import spock.lang.Specification
@TestFor(SimpleController)
class SimpleControllerSpec extends Specification {

    void "test hello"() {
        when:
        controller.hello()

        then:
        response.text == 'hello'
    }
}
```

##### Redirection Test of a Controller
```groovy
// Test Controller
class SimpleController {
    def index() {
        redirect action: 'hello'
    }
}

// Test class
import grails.test.mixin.TestFor
import spock.lang.Specification
@TestFor(SimpleController)
class SimpleControllerSpec extends Specification {

    void 'test index'() {
        when:
        controller.index()

        then:
        response.redirectedUrl == '/simple/hello'
    }
}
```

##### Testing View Rendering
```groovy
// Test Controller
class SimpleController {
    def home() {
        render view: "homePage", model: [title: "Hello World"]
    }
}

// Test class
import grails.test.mixin.TestFor
import spock.lang.Specification
@TestFor(SimpleController)
class SimpleControllerSpec extends Specification {

    void 'test home page'() {
        when:
        controller.home()

        then:
        view == '/simple/homePage'
        model.title == 'Hello World'
    }
}
```

##### Testing Actions Which Return A Map
```groovy
// Test Controller
class SimpleController {
    def showBookDetails() {
        [title: 'The Nature Of Necessity', author: 'Alvin Plantinga']
    }
}

// Test class
import grails.test.mixin.TestFor
import spock.lang.Specification
@TestFor(SimpleController)
class SimpleControllerSpec extends Specification {

    void 'test show book details'() {
        when:
        def model = controller.showBookDetails()

        then:
        model.author == 'Alvin Plantinga'
    }
}
```

##### Testing XML Responses
```groovy
// Test Controller
class SimpleController {
def renderXml() {
    render(contentType:"text/xml") {
        book(title:"Great")
    }
}
}

// Test class
import grails.test.mixin.TestFor
import spock.lang.Specification
@TestFor(SimpleController)
class SimpleControllerSpec extends Specification {

    void 'test render xml'() {
        when:
        controller.renderXml()

        then:
        response.text == "<book title='Great'/>"
        response.xml.@title.text() == 'Great'
    }
}
// Note: The xml property is a parsed result from Groovy's XmlSlurper class which is very convenient for parsing XML.
```

##### Testing JSON Responses
```groovy
// Test Controller
class SimpleController {
def renderJson() {
    render(contentType:"application/json") {
        book = "Great"
    }
}
}

// Test class
import grails.test.mixin.TestFor
import spock.lang.Specification
@TestFor(SimpleController)
class SimpleControllerSpec extends Specification {

    void 'test render json'() {
        when:
        controller.renderJson()

        then:
        response.text == '{"book":"Great"}'
        response.json.book == 'Great'
    }
}
// Note: The json property is an instance of org.codehaus.groovy.grails.web.json.JSONElement which is a map-like structure that is useful for parsing JSON responses.
```

##### Testing JSON Request








##### Blocks and Phases
1. **setup**           :    The setup block is where we do any setup work for the feature that we are describing.
2. **when & then**     :    The when and then blocks always occur together. They describe a stimulus and the expected response. Whereas when blocks may contain arbitrary code, then blocks are restricted to conditions, exception conditions, interactions, and variable definitions. A feature method may contain multiple pairs of when-then blocks.
4. **expect**          :    An expect block is more limited than a then block in that it may only contain conditions and variable definitions.
5. **cleanup**         :    A cleanup block may only be followed by a where block, and may not be repeated.
6. **where**           :    A where block always comes last in a method, and may not be repeated. It is used to write data-driven feature methods.



### Unit Testing Domains
```groovy
// Test Controller
class SimpleController {
    def save() {
        def simple = new Simple(params)
        if (simple.save(flush: true)) {
            flash.message = message(
                    code: 'default.created.message',
                    args: [message(code: 'save', default: 'Saved'), simple.id])
            redirect(action: "show", id: simple.id)
        }
        else {
            render(view: "create", model: [bookInstance: simple])
        }
    }
}

// Test class
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
```


## Integration Testing
##### Create Integration  Test Class
```bash
1. grails create-integration-test
2. grails create-integration-test simple
3. grails create-integration-test com.miaisoft.tutotial.testing.Simple
```



### Testing Controllers with Services

### Functional Testing

## Note
1. response                     :   The response object has number of useful methods for inspecting the state of the response.
2. params                       :   Many actions make use of the parameter data associated with the request. For example, the 'sort', 'max', and 'offset' parameters are quite common. Providing these in the test is as simple as adding appropriate values to a special params variable.
3. request.method = 'POST'      :   This way we can specify request type like as POST, GET, PUT etc.
4. request.makeAjaxRequest()    :   For AjaxCall


### References
1. [Grails Testing - Reference Documentation](http://grails.org/doc/latest/guide/testing.html)
2. [Spock Basics](https://code.google.com/p/spock/wiki/SpockBasics)