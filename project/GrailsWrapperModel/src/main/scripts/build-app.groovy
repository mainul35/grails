description "Example description", "grails example-usage"


String pluginLocation = "plugins/%s/build.gradle"
String pluginBuildList = "build/pluginList"
File pluginBuildListFile = new File(pluginBuildList)
pluginBuildListFile.delete()
File file
args.each {
    file = new File(String.format(pluginLocation, it))
    if (file.exists()){
        pluginBuildListFile << it + "\n"
    }else{
        println("Plugin $it not exists.")
    }
}
gradle.pluginBuild()
