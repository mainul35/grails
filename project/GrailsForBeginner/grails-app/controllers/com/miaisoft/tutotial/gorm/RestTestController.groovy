package com.miaisoft.tutotial.gorm

import com.miaisoft.longprocess.GlobalInformation
import com.miaisoft.longprocess.RunnableTesting

class RestTestController {

    static allowedMethods = [get:"GET",post: "POST", put: "PUT", delete: "DELETE"]

    def get() {
        render("Well done This is GET Request.")
    }
    def post() {
        render("Well done This is POST Request. Name = " + params.name)
    }
    def put() {
        render("Well done This is PUT Request. Name = " + params.name)
    }
    def delete() {
        render("Well done This is DELETE Request. Name = " + params.name)
    }

    def loopRunner() {
        RunnableTesting runnableTesting = new RunnableTesting();
        new Thread(runnableTesting).start();
        render "Process Started. Message ID = " + runnableTesting.getMessageIndex()
    }

    def checkStatus() {
        if (params.id){
            String message = "Invalid ID";
            try {
              message = GlobalInformation.currentStatus.get(params.id.toString());
            }catch (Exception e){
             e.getMessage();
            }
            render "Current State " + message;
        }else{
            render("Id Required")
        }

    }

}
