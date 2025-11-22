package com.sajjady.di.data.di.module

import com.sajjady.di.data.di.component.UserComponent
import dagger.Module
import dagger.hilt.migration.DisableInstallInCheck

@Module(subcomponents = [UserComponent::class])
@DisableInstallInCheck
object SubcomponentsModule
