
withConfig(configuration) {
    inline(phase: 'CONVERSION') { source, context, classNode ->
        classNode.putNodeMetaData('projectVersion', 'unspecified')
        classNode.putNodeMetaData('projectName', 'plugin')
        classNode.putNodeMetaData('isPlugin', 'true')
    }
}
