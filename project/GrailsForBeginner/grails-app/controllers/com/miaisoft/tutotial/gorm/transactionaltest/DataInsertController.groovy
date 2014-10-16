package com.miaisoft.tutotial.gorm.transactionaltest

class DataInsertController {

    def index() {}

    def saveWithoutTransactional (){
        params.name = "Touhid";
        new Bar(params).save(flush:true)
        new Baz(params).save(flush:true)
        def fooInstance = new Foo(params)
        if (fooInstance.save(flush: true)) {
            render "Saved Successfully."
        }
        else {
            render "Can't Save Data"
        }
    }

    def save2Domain(){
        params.name = "mia";
        new Bar(params).save(flush:true)
        new Baz(params).save(flush:true)
        render "Saved Successfully."
    }

    def saveWithTransactional () {
        params.name = "mia";
        def fooInstance = new Foo(params)
        Foo.withTransaction{ status ->
            try{
                new Bar(params).save(flush:true, failOnError:true)
                new Baz(params).save(flush:true, failOnError:true)
                fooInstance.save(flush: true, failOnError:true);
            }catch(Exception exp){
                fooInstance.errors.reject(
                        'foo.name.inuse',
                        ["${params.name}"].toArray() as Object[],
                        'Sorry Name [{0}] is already used by either Foor, Bar or Baz!!!')

                status.setRollbackOnly()
            }
        }

        if (!fooInstance.hasErrors()) {
            render "Saved Successfully."
        }
        else {
            render "Can't Save Data. Error = " + fooInstance
        }
    }
}
