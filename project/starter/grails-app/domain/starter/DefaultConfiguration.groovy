package starter

class DefaultConfiguration {

    String name
    String title

    static constraints = {
        title(nullable: true)
    }
}
