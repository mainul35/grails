package com.hmtmcse

class OperatorController {

    GlobalConfigService globalConfigService

    def index() {
        params.max = params.max?:globalConfigService.itemsPerPage();
        def list = Operator.createCriteria().list(params) {
            if (params?.colName && params?.colValue){
                like(params.colName, "%" +  params.colValue + "%")
            }
            if (!params.sort){
                order("id","desc")
            }
        };
        [operatorInstanceList:list, operatorInstanceCount: Operator.count(), params:params]
    }


    def show(Integer id) {
        if (id) {
            [operatorInstance: Operator.get(id)]
        } else {
            flash.message = [info: "Invalid Request", success: false]
            redirect(action: "index")
            return;
        }
    }


    def create() {
        [operatorInstanceInstance: chainModel?.operatorInstance]
    }


    def save() {
        Operator operatorInstance = new Operator(params)
        operatorInstance.save(flush:true)
        if (operatorInstance.hasErrors()){
            operatorInstance.errors.each {
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
            [operatorInstance: Operator.get(id)]
        }else{
            flash.message = [info:"Invalid Request",success:false]
            redirect(action:"index")
        }
    }

    def update() {
        Operator operatorInstance = Operator.get(params.id)
        if (operatorInstance == null) {
            flash.message = [info:"Update Failed",success:false]
            redirect(action:"edit",params:params)
            return;
        }

        operatorInstance.properties = params

        if (operatorInstance.hasErrors()) {
            flash.message = [info:"Update Failed",success:false]
            redirect(action:"edit",params:params)
            return;
        }
        operatorInstance.save(flush:true)
        if (operatorInstance.hasErrors()){
            operatorInstance.errors.each {
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
        def operatorInstance = Operator.get(id);
        if (operatorInstance != null) {
            operatorInstance.delete(flush: true)
            flash.message = [info: "Deleted", success: true]
        } else {
            flash.message = [info: "Record Not Found", success: false]
        }
        redirect(action: "index")
    }

}
