package org.keithkim.stories

class Outer(val greeting: Inner) {
    val greetingSalutation get() = greeting.salutation.value
    val greetingName get() = greeting.name.value

    fun greet(): String {
        return  greetingSalutation +", "+ greetingName +"."
    }

    fun salutation(): String {
        return greetingSalutation
    }

    fun name(): String {
        return greetingName
    }
}
