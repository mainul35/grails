package g3p

import grails.boot.GrailsApp
import grails.boot.config.GrailsApplicationPostProcessor
import grails.boot.config.GrailsAutoConfiguration
import org.springframework.context.annotation.Bean

class Application extends GrailsAutoConfiguration {
    static void main(String[] args) {
        GrailsApp.run(Application, args)
    }

    @Bean
    GrailsApplicationPostProcessor grailsApplicationPostProcessor() {


//        Basic Grails Plugin Loading
//        File file = new File("glib/bismillahPlugin-0.1.jar")
//        applicationContext.getClassLoader().addURL(file.toURI().toURL())
//        file = new File("glib/bismillahPlugin2-0.1.jar")
//        applicationContext.getClassLoader().addURL(file.toURI().toURL())


//        Basic Grails Plugin Loading With Library
//        File file = new File("glib/bismillahPlugin-0.1.jar")
//        applicationContext.getClassLoader().addURL(file.toURI().toURL())
//        file = new File("glib/bismillahPlugin2-0.1.jar")
//        applicationContext.getClassLoader().addURL(file.toURI().toURL())
//        file = new File("ex-libs/jartesting-1.0.jar")
//        applicationContext.getClassLoader().addURL(file.toURI().toURL())


        File file = new File("glib/bismillahPlugin-0.1.jar")
        File file2 = new File("ex-libs/jartesting-1.0.jar")
        URL[] urls = [file.toURI().toURL(),file2.toURI().toURL()]
        URLClassLoader urlClassLoader = new URLClassLoader (urls, applicationContext.getClassLoader())

        file = new File("glib/bismillahPlugin2-0.1.jar")
        file2 = new File("ex-libs/jartesting-1.1.jar")
        urls = [file.toURI().toURL(),file2.toURI().toURL()]
        urlClassLoader = new URLClassLoader (urls, urlClassLoader)


        Thread.currentThread().setContextClassLoader(urlClassLoader);


        return new ExperimentGrailsApplicationPostProcessor( this, applicationContext, classes() as Class[])
    }


}