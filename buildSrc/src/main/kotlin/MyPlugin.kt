import org.gradle.api.*
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction

open class HelloTask : DefaultTask() {

    @Input
    val args = mutableListOf<String>()

    fun withArg(s: String) {
        args.add(s)
    }

    @TaskAction
    fun run() {
        args.add(0, "running")
    }

    override fun doFirst(action: Action<in Task>): Task {
        args.add("doing first")
        return super.doFirst(action)
    }

    override fun doLast(action: Action<in Task>): Task {
        args.add("doing last")
        return super.doLast(action)
    }

}

class MyPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.tasks.register("hello", HelloTask::class.java)
    }
}
