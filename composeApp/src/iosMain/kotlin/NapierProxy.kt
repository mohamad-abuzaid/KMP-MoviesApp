import io.github.aakira.napier.Antilog
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier

fun debugBuild() {
    Napier.base(DebugAntilog("Napier_iOS"))
}

fun releaseBuild(antilog: Antilog) {
    Napier.base(antilog)
}
