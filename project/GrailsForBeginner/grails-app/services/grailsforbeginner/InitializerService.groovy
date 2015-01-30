package grailsforbeginner

import com.miaisoft.SortableDataHolder


class InitializerService {

   public static def initSortableContent() {
        def list = [
                ["name":"Content-1","sortingOrder":0,"isActive":true,"description":"Lorem ipsum dolor sit amet, consectetuer adipiscing elit"],
                ["name":"Content-2","sortingOrder":1,"isActive":true,"description":"Lorem ipsum dolor sit amet, consectetuer adipiscing elit"],
                ["name":"Content-3","sortingOrder":2,"isActive":true,"description":"Lorem ipsum dolor sit amet, consectetuer adipiscing elit"],
                ["name":"Content-4","sortingOrder":3,"isActive":true,"description":"Lorem ipsum dolor sit amet, consectetuer adipiscing elit"],
                ["name":"Content-5","sortingOrder":4,"isActive":true,"description":"Lorem ipsum dolor sit amet, consectetuer adipiscing elit"],
                ["name":"Content-6","sortingOrder":5,"isActive":true,"description":"Lorem ipsum dolor sit amet, consectetuer adipiscing elit"],
                ["name":"Content-7","sortingOrder":6,"isActive":true,"description":"Lorem ipsum dolor sit amet, consectetuer adipiscing elit"],
                ["name":"Content-8","sortingOrder":7,"isActive":true,"description":"Lorem ipsum dolor sit amet, consectetuer adipiscing elit"],
                ["name":"Content-9","sortingOrder":8,"isActive":true,"description":"Lorem ipsum dolor sit amet, consectetuer adipiscing elit"],
        ]

        if (SortableDataHolder.count() == 0){
            list.each {
                def x  = new SortableDataHolder(name: it.name, sortingOrder: it.sortingOrder, isActive: it.isActive, description: it.description.toString())
                x.save();
                if (x.hasErrors()) {
                    x.errors.each {
                        println it
                    }
                }
            }
        }


    }
}
