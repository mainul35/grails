package grailsforbeginner

import com.miaisoft.SortableSave


class SortItemService {

    def sort(def params) {

        String direction = params.direction;

        def condition = SortableSave.createCriteria().list {
            if (direction  && direction.equals("LOWER")){
                le("sortOrder",params.int("changeOrder"))
            }else{
                ge("sortOrder",params.int("changeOrder"))
            }

        }


        def items;

        condition.each{ordering ->
            items = SortableSave.get(ordering.id)
            if (direction  && direction.equals("LOWER")){
                items.sortOrder = items.sortOrder - 1
            }else{
                items.sortOrder = items.sortOrder + 1
            }
            items.save(flush: true);
        }
    }
}
