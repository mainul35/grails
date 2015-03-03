package com.miaisoft.tutotial.gorm

import com.miaisoft.longprocess.GlobalInformation
import com.miaisoft.longprocess.RunnableTesting
import com.sun.org.apache.xml.internal.security.utils.Base64
import grails.converters.JSON
import grailsforbeginner.BasicAuthenticationService
import grailsforbeginner.HttpRequesterService

import java.nio.charset.Charset

class RestTestController {

    HttpRequesterService httpRequesterService
    BasicAuthenticationService basicAuthenticationService

    static allowedMethods = [get:"GET",post: "POST", put: "PUT", delete: "DELETE"]

    def get() {
        render("Well done This is GET Request.")
    }

    def post() {
        render("Well done This is POST Request. Name = " + params.toString())
    }

    def postByJSON() {
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

    def authTesting(){
        basicAuthenticationService.check(request);
        String name = ""
        String authHeader = request.getHeader('Authorization').substring("Basic".length()).trim()
        def aByte = Base64.decode(authHeader);
        String userPass = new String(aByte,Charset.forName("UTF-8"))
        render("yes Working" + userPass)
    }
    
    def getNotice(){
        def map = [:]
        def list = []
        
        map.put("id","1")
        map.put("image","")
        map.put("teacher","teacher-1")
        map.put("subject","subject-1")
        map.put("message","message message message message message message message message message ")
        list.add(map)

        map = [:]
        map.put("id","2")
        map.put("image","")
        map.put("teacher","teacher-2")
        map.put("subject","subject-2")
        map.put("message","message message message message message message message message message ")
        list.add(map)

        map = [:]
        map.put("id","3")
        map.put("image","")
        map.put("teacher","teacher-3")
        map.put("subject","subject-3")
        map.put("message","message message message message message message message message message ")
        list.add(map)

        map = [:]
        map.put("id","4")
        map.put("image","")
        map.put("teacher","teacher-4")
        map.put("subject","subject-4")
        map.put("message","message message message message message message message message message ")
        list.add(map)

        map = [:]
        map.put("id","5")
        map.put("image","")
        map.put("teacher","teacher-5")
        map.put("subject","subject-5")
        map.put("message","message message message message message message message message message ")
        list.add(map)


        map = [:]
        map.put("id","5")
        map.put("image","")
        map.put("teacher","teacher-5")
        map.put("subject","subject-5")
        map.put("message","message message message message message message message message message ")
        list.add(map)


        map = [:]
        map.put("id","5")
        map.put("image","")
        map.put("teacher","teacher-5")
        map.put("subject","subject-5")
        map.put("message","message message message message message message message message message message message message message message message message message message message message message message message message message message message message message message message message message message message message ")
        list.add(map)


        map = [:]
        map.put("id","5")
        map.put("image","")
        map.put("teacher","teacher-5")
        map.put("subject","subject-5")
        map.put("message","message message message message message message message message message ")
        list.add(map)


        map = [:]
        map.put("id","5")
        map.put("image","")
        map.put("teacher","teacher-5")
        map.put("subject","subject-5")
        map.put("message","message message message message message message message message message message message message message message message message message message ")
        list.add(map)


        map = [:]
        map.put("id","5")
        map.put("image","")
        map.put("teacher","teacher-5")
        map.put("subject","subject-5")
        map.put("message","message message message message message message message message message message message message message message message message message message message message message message message message message message message ")
        list.add(map)


        map = [:]
        map.put("id","5")
        map.put("image","")
        map.put("teacher","teacher-5")
        map.put("subject","subject-5")
        map.put("message","message message message message message message message message message message message message message message message message message message message message message message message message message message message ")
        list.add(map)


        map = [:]
        map.put("id","5")
        map.put("image","")
        map.put("teacher","teacher-5")
        map.put("subject","subject-5")
        map.put("message","message message message message message message message message message ")
        list.add(map)


        map = [:]
        map.put("id","5")
        map.put("image","")
        map.put("teacher","teacher-5")
        map.put("subject","subject-5")
        map.put("message","message message message message message message message message message ")
        list.add(map)


        map = [:]
        map.put("id","5")
        map.put("image","")
        map.put("teacher","teacher-5")
        map.put("subject","subject-5")
        map.put("message","message message message message message message message message message ")
        list.add(map)


        map = [:]
        map.put("id","5")
        map.put("image","")
        map.put("teacher","teacher-5")
        map.put("subject","subject-5")
        map.put("message","message message message message message message message message message message message message message message message message message message message message message message message message message message message message message message message message message message message message ")
        list.add(map)



        render(["notices":list] as JSON);
    }

}
