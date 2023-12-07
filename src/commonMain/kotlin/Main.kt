import io.github.oshai.kotlinlogging.KotlinLogging

private val logger = KotlinLogging.logger {}

fun main(args: Array<String>) {
    logger.info {
        "You forget a thousand things everyday, how bout you make sure this is one of em."
    }
}
