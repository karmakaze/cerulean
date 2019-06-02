package org.keithkim.stories

import kotlin.LazyThreadSafetyMode.NONE

data class Inner(val salutation: Lazy<String>, val name: Lazy<String>) {
    constructor(salutationFun: () -> String, nameFun: () -> String) :
            this(lazy(NONE) { salutationFun() }, lazy(NONE) { nameFun() })
}
