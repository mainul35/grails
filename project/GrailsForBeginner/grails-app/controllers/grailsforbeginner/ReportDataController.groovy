package grailsforbeginner

import com.miaisoft.ReportData
import com.miaisoft.constant.MyConstent

class ReportDataController {

    def index() {

        ReportData reportData = ReportData(createDate:new Date(), operation: MyConstent.CREATED, count:1, amount:10.10)
        reportData.save()

        if (reportData.hasErrors()){
            reportData.errors.each {
                println(it)
            }
        }
        render("Hi Janu")
    }
}
