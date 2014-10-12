### Welcme to Grails Automated Testing
##### Running Tests
```bash
grails test-app
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

##### Unit Testing Controllers Example
```groovy
import grails.test.mixin.TestFor
import spock.lang.Specification
@TestFor(SimpleController)
class SimpleControllerSpec extends Specification {

    void "test methodNameOfController"() {
    
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


##### Blocks and Phases
1. **setup**           :    The setup block is where we do any setup work for the feature that we are describing.
2. **when & then**     :    The when and then blocks always occur together. They describe a stimulus and the expected response. Whereas when blocks may contain arbitrary code, then blocks are restricted to conditions, exception conditions, interactions, and variable definitions. A feature method may contain multiple pairs of when-then blocks.
4. **expect**          :    An expect block is more limited than a then block in that it may only contain conditions and variable definitions.
5. **cleanup**         :    A cleanup block may only be followed by a where block, and may not be repeated.
6. **where**           :    A where block always comes last in a method, and may not be repeated. It is used to write data-driven feature methods.





### References
[Grails Testing - Reference Documentation](http://grails.org/doc/latest/guide/testing.html)
[Spock Basics](https://code.google.com/p/spock/wiki/SpockBasics)