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
@TestFor(BookController)            : The TestFor annotation defines the class under test and will automatically create a field for the type of class under test.
@Mock([Book, Author, BookService])  : The Mock annotation creates mock version of any collaborators. There is an in-memory implementation of GORM that will simulate most interactions with the GORM API.

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


##### Running Tests
```bash
grails test-app
```


##### Running Tests
```bash
grails test-app
```


##### Running Tests
```bash
grails test-app
```