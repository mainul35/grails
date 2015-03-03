package com.miaisoft.myio


/**
 * Created by Tou on 3/03/2015.
 */
class FileReadWriter {
    
    Boolean writeFile(String pathFileName, String content){
        File file = new File(pathFileName);
        file.withWriter { out->
            out.write(content)
        }

    }

    String readFile(String pathFileName){
        File file = new File(pathFileName)
        StringBuilder build = new StringBuilder();
        file.eachLine { line -> build.append(line) }
        return build.toString()

    }
    
}
