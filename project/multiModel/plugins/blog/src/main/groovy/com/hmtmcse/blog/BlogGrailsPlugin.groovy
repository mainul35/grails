package com.hmtmcse.blog

import com.hmtmcse.GrailsPluginBase


class BlogGrailsPlugin  extends GrailsPluginBase {


    def name = "touhidMia"

    def grailsVersion = "3.2.9 > *"
    def pluginExcludes = [
        "grails-app/views/error.gsp"
    ]
    def title = "Blog"
    def author = "Your name"
    def authorEmail = ""
    def description = ''' Brief summary/description of the plugin.'''
    def profiles = ['web']
    def documentation = "http://www.webcommander.com/plugin/blog"

}
