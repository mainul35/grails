package com.miaisoft.tutotial

import com.miaisoft.SortableSave

class DraggableUIController {

    def index() {}

    def resizable(){}

    def saveSortable(){
        [items:SortableSave.createCriteria().list{eq("isActive",true)}]
    }

}
