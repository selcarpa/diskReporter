package utils

import okio.FileSystem
import okio.Path
import okio.buffer
import okio.use

actual fun readFile(path: Path): String {
    FileSystem.SYSTEM.source(path).use { fileSource ->
        var result = ""
        fileSource.buffer().use { bufferedFileSource ->
            result = bufferedFileSource.readUtf8()

        }
        return result
    }
}
