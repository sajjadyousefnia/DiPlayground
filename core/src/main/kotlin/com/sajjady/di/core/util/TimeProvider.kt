package com.sajjady.di.core.util

import java.time.Instant

interface TimeProvider {
    fun now(): Instant
}
