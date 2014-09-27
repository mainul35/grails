package com.miaisoft.tutotial.gorm

class ShellCommandController {

    def index() {
       Process process;
        process = Runtime.getRuntime().exec("ls -a");
        process.waitFor();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = "";
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append(System.getProperty("line.separator"));
        }
        render(reader.toString() + "   ------   " + process.exitValue())
    }
}
