package com.miaisoft.tutotial.shell

import com.miaisoft.tutorial.shell.ShellService
import grails.converters.JSON

class ShellController {


    ShellService shellService


    def index(){

    }

    def run() {
        def res
        if (!session.pid){
            res = shellService.run(params.command, 0);
            session.pid = res.pid
        }else{
            res = shellService.run(params.command, session.pid);
            session.pid = res.pid
        }
        render(res as JSON)
    }
}
