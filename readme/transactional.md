## Q. What is Transactional?
A. Many man Explain many way. I think they all are right. Just I realize that if i have need Dependable DB Operation
 Then need Transactional use.
 
 Example:
    Let's we have Three Domain with one unique field.
    1. Foo
    2. Bar
    3. Baz
    We want if any name added any of three domain then we not save the name, Then we have need transactional.
    
Let's go Practical.

Domain Class

1. [Foo.class](https://github.com/hmtmcse/grails/blob/master/project/GrailsForBeginner/grails-app/domain/com/miaisoft/tutotial/gorm/transactionaltest/Foo.groovy)
2. [Bar.class](https://github.com/hmtmcse/grails/blob/master/project/GrailsForBeginner/grails-app/domain/com/miaisoft/tutotial/gorm/transactionaltest/Bar.groovy)
2. [Baz.class](https://github.com/hmtmcse/grails/blob/master/project/GrailsForBeginner/grails-app/domain/com/miaisoft/tutotial/gorm/transactionaltest/Baz.groovy)



Controller Class

1. [DataInsertController.class](https://github.com/hmtmcse/grails/blob/master/project/GrailsForBeginner/grails-app/controllers/com/miaisoft/tutotial/gorm/transactionaltest/DataInsertController.groovy)

