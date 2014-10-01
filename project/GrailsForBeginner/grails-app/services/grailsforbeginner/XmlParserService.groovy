package grailsforbeginner

class XmlParserService {

    def readXMLFromFile() {

        String xmlText = new File("D:\\touhid\\grails\\project\\GrailsForBeginner\\grails-app\\conf\\serverConfig.xml").text
        def configuration = new XmlSlurper().parseText(xmlText);
        def nic = configuration.nic
        def authentication = configuration.authentication

        String serverIP;
        if (nic){
            serverIP = configuration.nic.ip.text()
        }

        String username;
        String password;
        if (authentication){
          username = configuration.authentication.username.text();
          password = configuration.authentication.password.text();
        }
        println(username + "  " + password + "  " + serverIP)

    }
}
