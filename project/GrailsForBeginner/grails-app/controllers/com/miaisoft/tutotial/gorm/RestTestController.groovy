package com.miaisoft.tutotial.gorm

import com.miaisoft.longprocess.GlobalInformation
import com.miaisoft.longprocess.RunnableTesting
import grailsforbeginner.HttpRequesterService

class RestTestController {

    HttpRequesterService httpRequesterService

    static allowedMethods = [get:"GET",post: "POST", put: "PUT", delete: "DELETE"]

    def get() {
        render("Well done This is GET Request.")
    }
    def post() {
        def prms = request.JSON;
        render("Well done This is POST Request. Name = " + prms.name)
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


    def serverRequest(){
        def map = [:];
        map.put("name","Touhid");
        render(httpRequesterService.poster("localhost:8221/GrailsForBeginner/restTest/post",map));
    }

}
