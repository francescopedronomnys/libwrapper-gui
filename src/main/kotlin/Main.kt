import com.omnys.jni.java.NativeHost

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")

    val path = System.getProperty("java.library.path")
    path.split(";").forEach {
        println(it)
    }

    Runtime.getRuntime().loadLibrary("libwrapper")
    val value = NativeHost().callIncrementInt(42)
    println("Value from wrapper is $value")

    println("Doing curl get")
    NativeHost().curlGet()
}

