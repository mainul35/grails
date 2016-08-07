package com.hmtmcse



class StudentController {

    GlobalConfigService globalConfigService

    def index() {
        params.max = params.max?:globalConfigService.itemsPerPage();
        def list = Student.createCriteria().list(params) {
            if (params?.colName && params?.colValue){
                like(params.colName, "%" +  params.colValue + "%")
            }
            if (!params.sort){
                order("id","desc")
            }
        };
        [studentInstanceList:list,studentInstanceCount: Student.count(),params:params]
    }


    def show(Integer id) {
        if (id) {
            [studentInstance: Student.get(id)]
        } else {
            flash.message = [info: "Invalid Request", success: false]
            redirect(action: "index")
            return;
        }
    }


    def create() {
        [studentInstanceInstance: chainModel?.studentInstance]
    }


    def save() {
        Student studentInstance = new Student(params)
        studentInstance.save(flush:true)
        if (studentInstance.hasErrors()){
            studentInstance.errors.each {
                println(it)
            }
            flash.message = [info:"Failed",success:false]
            redirect(action:"create", params:params)
        }else{
            flash.message = [info:"Created",success:true]
            redirect(action:"index")
        }
    }

    def edit(Integer id) {
        if (id){
            [studentInstance: Student.get(id)]
        }else{
            flash.message = [info:"Invalid Request",success:false]
            redirect(action:"index")
        }
    }

    def update() {
        Student studentInstance = Student.get(params.id)
        if (studentInstance == null) {
            flash.message = [info:"Update Failed",success:false]
            redirect(action:"edit",params:params)
            return;
        }

        studentInstance.properties = params

        if (studentInstance.hasErrors()) {
            flash.message = [info:"Update Failed",success:false]
            redirect(action:"edit",params:params)
            return;
        }
        studentInstance.save(flush:true)
        if (studentInstance.hasErrors()){
            studentInstance.errors.each {
                println(it)
            }
            flash.message = [info:"Update Failed",success:false]
            redirect(action:"edit",params:params)
        }else{
            flash.message = [info:"Updated",success:true]
            redirect(action:"index")
        }
    }


    def delete(Integer id) {
        def studentInstance = Student.get(id);
        if (studentInstance != null) {
            studentInstance.delete(flush: true)
            flash.message = [info: "Deleted", success: true]
        } else {
            flash.message = [info: "Record Not Found", success: false]
        }
        redirect(action: "index")
    }

}
