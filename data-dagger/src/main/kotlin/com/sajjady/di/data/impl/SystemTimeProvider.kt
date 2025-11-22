package com.sajjady.di.data.impl

import com.sajjady.di.data.TimeProvider
import java.time.Instant
import javax.inject.Inject
import javax.inject.Singleton

class SystemTimeProvider @Inject constructor() : TimeProvider {
    override fun now(): Instant = Instant.now()
}
