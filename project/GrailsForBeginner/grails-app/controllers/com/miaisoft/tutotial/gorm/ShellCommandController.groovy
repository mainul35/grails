package com.miaisoft.tutotial.gorm

class ShellCommandController {

    def index() {
       Process process;
        process = Runtime.getRuntime().exec("ls -a");
        process.waitFor();
        render(process.exitValue())
    }
}
