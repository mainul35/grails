<%=packageName ? "package ${packageName}\n\n" : ''%>

class ${className}Controller {

    GlobalConfigService globalConfigService

    def index() {
        params.max = params.max?:globalConfigService.itemsPerPage();
        def list = ${className}.createCriteria().list(params) {
            if (params?.colName && params?.colValue){
                like(params.colName, "%" +  params.colValue + "%")
            }
            if (!params.sort){
                order("id","desc")
            }
        };
        [${propertyName}List:list,${propertyName}Count: ${className}.count(),params:params]
    }


    def show(Integer id) {
        if (id) {
            [${propertyName}: ${className}.get(id)]
        } else {
            flash.message = [info: "Invalid Request", success: false]
            redirect(action: "index")
            return;
        }
    }


    def create() {
        [${propertyName}Instance: chainModel?.${propertyName}]
    }


    def save() {
        ${className} ${propertyName} = new ${className}(params)
        ${propertyName}.save(flush:true)
        if (${propertyName}.hasErrors()){
            ${propertyName}.errors.each {
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
            [${propertyName}: ${className}.get(id)]
        }else{
            flash.message = [info:"Invalid Request",success:false]
            redirect(action:"index")
        }
    }

    def update() {
        ${className} ${propertyName} = ${className}.get(params.id)
        if (${propertyName} == null) {
            flash.message = [info:"Update Failed",success:false]
            redirect(action:"edit",params:params)
            return;
        }

        ${propertyName}.properties = params

        if (${propertyName}.hasErrors()) {
            flash.message = [info:"Update Failed",success:false]
            redirect(action:"edit",params:params)
            return;
        }
        ${propertyName}.save(flush:true)
        if (${propertyName}.hasErrors()){
            ${propertyName}.errors.each {
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
        def ${propertyName} = ${className}.get(id);
        if (${propertyName} != null) {
            ${propertyName}.delete(flush: true)
            flash.message = [info: "Deleted", success: true]
        } else {
            flash.message = [info: "Record Not Found", success: false]
        }
        redirect(action: "index")
    }

}
