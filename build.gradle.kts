apply<MyPlugin>()

tasks.withType<HelloTask> {
    args.clear()

    withArg("first arg")
    withArg("second arg")

    println(args)

    doFirst {
        println(args)
    }

    doLast {
        println(args)
    }
}
