package org.keithkim.stories

import org.keithkim.stories.Arg.Companion.arg

fun salutation(): String {
    println("entered salutation")
    return "Hello"
}

fun name(): String {
    println("entered name")
    return "world"
}

fun demoLazy() {
    val inner = Inner(::salutation, ::name)

    val outer = Outer(inner)

    println("name:")
    println(outer.name())
    println()
    println("greet:")
    println(outer.greet())
}

class DemoArg<A, B>(val arg1: Arg<A>, val arg2: Arg<B>) {
    val a1: A get() = arg1.get()
    val a2: B get() = arg2.get()

    constructor(arg1: A, arg2: B) : this(arg(arg1), arg(arg2))
    constructor(arg1: A, arg2: () -> B) : this(arg(arg1), arg(arg2))
    constructor(arg1: () -> A, arg2: B) : this(arg(arg1), arg(arg2))
    constructor(arg1: () -> A, arg2: () -> B) : this(arg(arg1), arg(arg2))

    fun combine(): Arg<String> {
        if (arg1 is Arg.Value && arg2 is Arg.Value) {
            return arg(a1.toString() +":"+ a2.toString())
        }
        return arg{ a1.toString() +":"+ a2.toString() }
    }
}

fun main(args: Array<String>) {
    val demoArg = DemoArg("String", { 1 })
    val combined = demoArg.combine()

    println(combined.get())
}
