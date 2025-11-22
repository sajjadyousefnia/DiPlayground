package com.sajjady.di.data.di.scope

import javax.inject.Scope
import kotlin.annotation.AnnotationRetention.RUNTIME

@Scope
@Retention(RUNTIME)
annotation class AppScope

@Scope
@Retention(RUNTIME)
annotation class UserScope
