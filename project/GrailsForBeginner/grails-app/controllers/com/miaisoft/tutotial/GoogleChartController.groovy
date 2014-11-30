package com.miaisoft.tutotial

import grails.converters.JSON

class GoogleChartController {

    def index() {}

    def circleChartData(){
        def row = [];
        def table = [];
        row.add("Effort")
        row.add("Amount given")
        table.add(row)

        row = []
        row.add("All")
        row.add(75)
        table.add(row)
        render(table as JSON);
    }


    def donutChartData(){
        def row = [];
        def table = [];
        row.add("Task")
        row.add("Hours per Day")
        table.add(row)

        row = []
        row.add("Work")
        row.add(11)
        table.add(row)

        row = []
        row.add("Eat")
        row.add(2)
        table.add(row)

        row = []
        row.add("Commute")
        row.add(2)
        table.add(row)

        row = []
        row.add("Watch TV")
        row.add(7)
        table.add(row)
        render(table as JSON);
    }


    def lineChartData(){

        def row = [];
        def table = [];

        row.add("Month")
        row.add("Criteria One")
        row.add("Criteria Two")
        table.add(row);

        row = []
        row.add("Jan")
        row.add(1000)
        row.add(400)
        table.add(row);

        row = []
        row.add("Feb")
        row.add(1170)
        row.add(460)
        table.add(row);

        row = []
        row.add("Mar")
        row.add(660)
        row.add(1120)
        table.add(row);

        row = []
        row.add("Apr")
        row.add(1030)
        row.add(540)
        table.add(row);

        row = []
        row.add("Apr")
        row.add(1030)
        row.add(540)
        table.add(row);


        row = []
        row.add("May")
        row.add(1030)
        row.add(540)
        table.add(row);


        row = []
        row.add("Jun")
        row.add(1030)
        row.add(540)
        table.add(row);

        row = []
        row.add("Jul")
        row.add(1030)
        row.add(540)
        table.add(row);

        row = []
        row.add("Aug")
        row.add(1030)
        row.add(540)
        table.add(row);

        row = []
        row.add("Sept")
        row.add(1030)
        row.add(540)
        table.add(row);

        row = []
        row.add("Oct")
        row.add(1030)
        row.add(540)
        table.add(row);

        row = []
        row.add("Nov")
        row.add(1030)
        row.add(540)
        table.add(row);

        row = []
        row.add("Dec")
        row.add(1030)
        row.add(540)
        table.add(row);

        render(table as JSON);
    }
}
