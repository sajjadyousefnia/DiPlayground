package com.sajjady.di.data

import javax.inject.Inject

class Initializer @Inject constructor() {
    var initialized = false
        private set

    @Inject
    fun markInitialized() {
        initialized = true
    }
}
