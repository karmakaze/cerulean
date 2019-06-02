package org.keithkim.stories

sealed class Arg<T> {
    data class Value<T>(val value: T) : Arg<T>()
    data class Compute<T>(val compute: () -> T) : Arg<T>()
    data class Lazy<T>(val lazy: Lazy<T>) : Arg<T>()

    companion object {
        fun <T> arg(value: T): Arg<T> {
            return Value(value)
        }
        fun <T> arg(compute: () -> T): Arg<T> {
            return Compute(compute)
        }
        fun <T> arg(lazy: Lazy<T>): Arg<T> {
            return Lazy(lazy)
        }
    }

    fun get(): T = when(this) {
        is Value -> value
        is Compute -> compute.invoke()
        is Lazy -> lazy.get()
    }
}
