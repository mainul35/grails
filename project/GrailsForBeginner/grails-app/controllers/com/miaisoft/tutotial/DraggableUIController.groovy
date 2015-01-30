package com.miaisoft.tutotial

import com.miaisoft.SortableDataHolder

class DraggableUIController {

    def index() {}

    def resizable(){}

    def saveSortable(){
        [items:SortableDataHolder.createCriteria().list{eq("isActive",true)}]
    }

}
