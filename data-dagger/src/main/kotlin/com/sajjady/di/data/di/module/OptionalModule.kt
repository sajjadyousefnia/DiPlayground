package com.sajjady.di.data.di.module

import com.sajjady.di.data.User
import dagger.BindsOptionalOf
import dagger.Module
import dagger.hilt.migration.DisableInstallInCheck

@Module
@DisableInstallInCheck
abstract class OptionalModule {
    @BindsOptionalOf
    abstract fun bindOptionalUser(): User
}
