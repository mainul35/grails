package grailsforbeginner

import com.miaisoft.SortableSave


class InitializerService {

   public static def initSortableContent() {
        def list = [
                ["name":"Content-1","sortOrder":0,"isActive":true,"description":"Lorem ipsum dolor sit amet, consectetuer adipiscing elit"],
                ["name":"Content-2","sortOrder":1,"isActive":true,"description":"Lorem ipsum dolor sit amet, consectetuer adipiscing elit"],
                ["name":"Content-3","sortOrder":2,"isActive":true,"description":"Lorem ipsum dolor sit amet, consectetuer adipiscing elit"],
                ["name":"Content-4","sortOrder":3,"isActive":true,"description":"Lorem ipsum dolor sit amet, consectetuer adipiscing elit"],
                ["name":"Content-5","sortOrder":4,"isActive":true,"description":"Lorem ipsum dolor sit amet, consectetuer adipiscing elit"],
                ["name":"Content-6","sortOrder":5,"isActive":true,"description":"Lorem ipsum dolor sit amet, consectetuer adipiscing elit"],
                ["name":"Content-7","sortOrder":6,"isActive":true,"description":"Lorem ipsum dolor sit amet, consectetuer adipiscing elit"],
                ["name":"Content-8","sortOrder":7,"isActive":true,"description":"Lorem ipsum dolor sit amet, consectetuer adipiscing elit"],
                ["name":"Content-9","sortOrder":8,"isActive":true,"description":"Lorem ipsum dolor sit amet, consectetuer adipiscing elit"],
        ]

        if (SortableSave.count() == 0){
            list.each {
                new SortableSave(name: it.name, sortOrder: it.sortOrder,isActive: it.isActive,description: it.description).save()
            }
        }


    }
}
