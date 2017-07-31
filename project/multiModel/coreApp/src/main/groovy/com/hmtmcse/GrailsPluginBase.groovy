package com.hmtmcse

import grails.plugins.Plugin

class GrailsPluginBase extends Plugin{
    def dependsOn = [coreApp: "* > 1.0"]
}
