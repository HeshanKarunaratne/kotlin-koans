package classdelegation

/**
 * @author Heshan Karunaratne
 */
interface Logger {
    fun log(message: String)
}

class ConsoleLogger : Logger {
    override fun log(message: String) {
        println("Console: $message")
    }
}

class AdvancedLogger(logger: Logger) : Logger by logger {
    fun logError(error: String) {
        log("ERROR: $error")
    }
}

fun main() {
    val consoleLogger = ConsoleLogger()
    val advancedLogger = AdvancedLogger(consoleLogger)
    consoleLogger.log("console logger")
    advancedLogger.log("This is a standard log message.")
    advancedLogger.logError("This is an error message.")
}