package com.sajjady.di.legacy.di;

import dagger.Module;
import dagger.Provides;

@Module
public class LegacyModule {

    @Provides
    @LegacyScope
    String provideWelcomeMessage() {
        return "Legacy Dagger Activity";
    }
}
