description( "Make Jar of a WebCommander Plugin" ) {
    usage "grails build-wc-plugin"
}

gradle.assemble()
gradle.distributionPacking()