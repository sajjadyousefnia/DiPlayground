package com.sajjady.di.data.di.module

import com.sajjady.di.data.di.component.UserComponent
import dagger.Module

@Module(subcomponents = [UserComponent::class])
object SubcomponentsModule
