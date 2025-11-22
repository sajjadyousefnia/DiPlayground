package com.sajjady.di.data.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class LogcatLogger

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class FileLogger
