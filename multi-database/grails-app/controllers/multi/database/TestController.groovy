package multi.database

class TestController {

    def index() {
        TestMultiDb testMultiDb = TestMultiDb.last()
        render("Name=${testMultiDb?.name}")
    }
}