package com.miaisoft.tutotial.gorm

class ErrorHandalingController {

    def paramsTest() {
        //If not params then Return Null Value

       if (params.name){
           render(params.name)
       }
    }


    def mapTest(){
        //If not Value then Return Null Value
        def map = [:]
        map.put("name","Touhid")
        map.put("success",false)


        if (map.get("success")){
            render("Working Fine")
        }else{
            render("( `_` )")
        }

    }
}
