package org.keithkim.stories

import io.javalin.Javalin
import org.keithkim.stories.db.Database

fun main(args: Array<String>) {
    val app = Javalin.create().start(7000)

    val db = Database.fromEnvVar()

    app.get("/") { ctx ->
        ctx.result("Hello World")
    }
}