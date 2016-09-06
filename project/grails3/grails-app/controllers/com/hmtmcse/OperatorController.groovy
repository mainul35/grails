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
        [operatorList:list,operatorCount: Operator.count(),params:params]
    }


    def show(Integer id) {
        if (id) {
            [operator: Operator.get(id)]
        } else {
            flash.message = [info: "Invalid Request", success: false]
            redirect(action: "index")
            return;
        }
    }


    def create() {
        [operatorInstance: chainModel?.operator]
    }


    def save() {
        Operator operator = new Operator(params)
        operator.save(flush:true)
        if (operator.hasErrors()){
            operator.errors.each {
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
            [operator: Operator.get(id)]
        }else{
            flash.message = [info:"Invalid Request",success:false]
            redirect(action:"index")
        }
    }

    def update() {
        Operator operator = Operator.get(params.id)
        if (operator == null) {
            flash.message = [info:"Update Failed",success:false]
            redirect(action:"edit",params:params)
            return;
        }

        operator.properties = params

        if (operator.hasErrors()) {
            flash.message = [info:"Update Failed",success:false]
            redirect(action:"edit",params:params)
            return;
        }
        operator.save(flush:true)
        if (operator.hasErrors()){
            operator.errors.each {
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
        def operator = Operator.get(id);
        if (operator != null) {
            operator.delete(flush: true)
            flash.message = [info: "Deleted", success: true]
        } else {
            flash.message = [info: "Record Not Found", success: false]
        }
        redirect(action: "index")
    }

}
