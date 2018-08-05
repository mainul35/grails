package grailssqlite

class SearchIndex {

    Long id
    String autocomplete
    String url
    String pageTitle
    String bodyText

    Date dateCreated
    Date lastUpdated

    static constraints = {
    }

    static mapping = {
        version(false)
        bodyText(type: 'text')
        pageTitle(type: 'text')
    }
}
