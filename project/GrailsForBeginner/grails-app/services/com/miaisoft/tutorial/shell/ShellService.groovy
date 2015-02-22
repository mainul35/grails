package com.miaisoft.tutorial.shell





class ShellService {


   public static def status = [:]
    public static boolean isTerminatorStarted = false;
    public Integer terminateTime = 30000;


    public static int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(1000) + 1;
    }


    def run(String command, int pid = 0) {
        def map = [
                "lines":[],
                "lastReadLine":0,
                "lastAccess": System.currentTimeMillis(),
                "destroy":0,
                "isEnd":0
        ]
        def response = [
                "success":true,
                "pid":0,
                "lines":"",
                "isEnd":0
        ]
        if(pid && !status.get("process-"+ pid)){
            pid = 0
        }
        if (!pid){
            int id = getRandomNumber();
            status.put("process-"+ id, map);
            Thread.start {
                runShellCommand(command, id)
            }
            terminator();
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
                stringBuilder.append(System.getProperty("line.separator"));
            }
            currentStatus.put("lastReadLine",currentLine)
            currentStatus.put("lastAccess",System.currentTimeMillis())
            response.put("pid",pid)
            response.put("lines",stringBuilder.toString())

            if (currentStatus.get("isEnd")){
                response.put("isEnd",1)
                status.remove("process-"+ pid)
            }
            return response
        }
    }


    private void runShellCommand(String command, int pid){
         def commands = ""
        if (System.properties['os.name'].toLowerCase().contains('windows')) {
            commands = command;
        } else {
            commands = ['bash', '-c', command];
        }
        def process = commands.execute();
        process.in.eachLine { line ->
            if (status.get("process-"+ pid)){
                int isDestroy = (int) status.get("process-"+ pid).get("destroy");
                println(line + " isDestroy ==  " + isDestroy)
                if (isDestroy){
                    status.remove("process-"+ pid)
                    process.destroy();
                }else{
                    status.get("process-"+ pid).get("lines").add(line)
                }
            }
        }
        if (status.get("process-"+ pid)){
            status.get("process-"+ pid).put("isEnd",1)
        }
    }


    private void terminator(){
        if (!isTerminatorStarted){
            isTerminatorStarted = true
            Thread.start {
                while (true){
                    if (status.size() == 0){
                        isTerminatorStarted = false
                        break;
                    }
                    Thread.sleep(terminateTime);
                    def timeSpan = System.currentTimeMillis() - terminateTime;
                    status.each {
                        def lastAccess = it.value.get("lastAccess")
                        if (lastAccess < timeSpan){
                            it.value.put("destroy",1)
                        }
                    }
                }
            }
        }
    }



}
