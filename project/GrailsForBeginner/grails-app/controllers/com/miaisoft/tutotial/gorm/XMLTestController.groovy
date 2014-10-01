package com.miaisoft.tutotial.gorm

import grailsforbeginner.XmlParserService

class XMLTestController {

    XmlParserService xmlParserService

    def index() {

        def  CAR_RECORDS = "<configuration> <nic><ip>10.0.40.30</ip></nic><authentication><username>touhid</username><password>adfkadjflkajdlkjadlf</password></authentication></configuration>"

        def records = new XmlSlurper().parseText(CAR_RECORDS)
        xmlParserService.readXMLFromFile();
        render records;
    }
}
