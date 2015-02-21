package com.miaisoft.tutorial.shell





class ShellService {


   public static def status = [:]
    public static boolean isTerminatorStarted = false;


    public static int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(1000) + 1;
    }


    def run(String command, int pid = 0) {
        def map = [
                "lines":[],
                "lastReadLine":0,
                "lastCheckLine":0
        ]
        def response = [
                "success":true,
                "pid":0,
                "lines":""
        ]


        if (!pid){
            int id = getRandomNumber();
            status.put("process-"+ id, map);
            Thread.start {
                runShellCommand(command, id)
            }
            response.put("pid",id)
            return response;
        }else{
           def currentStatus =  status.get("process-"+ pid);
            int lastReadLine = currentStatus.get("lastReadLine");
            int currentLine = currentStatus.get("lines").size()
            int startLine = lastReadLine;

            StringBuilder stringBuilder = new StringBuilder();
            for (int i = startLine; i < currentLine; i++){
                stringBuilder.append(currentStatus.get("lines").get(i));
            }
            currentStatus.put("lastReadLine",currentLine)
            response.put("pid",pid)
            response.put("lines",stringBuilder.toString())
            return response
        }
    }

    private void runShellCommand(String commands, int pid){
        def process = commands.execute();
        process.in.eachLine { line ->
            println line
            status.get("process-"+ pid).get("lines").add(line)
        }
    }


    private void tarminator(){
        if (!isTerminatorStarted){
            isTerminatorStarted = true
            Thread.start {

            }
        }
    }



}
