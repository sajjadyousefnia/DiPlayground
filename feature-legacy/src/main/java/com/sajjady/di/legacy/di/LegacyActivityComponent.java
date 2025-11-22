package com.sajjady.di.legacy.di;

import com.sajjady.di.data.di.component.AppComponent;
import com.sajjady.di.legacy.ui.LegacyNotesActivity;
import com.sajjady.di.legacy.ui.LegacyNotesFragment;

import dagger.BindsInstance;
import dagger.Component;

@LegacyActivityScope
@Component(dependencies = AppComponent.class, modules = LegacyActivityModule.class)
public interface LegacyActivityComponent {
    void inject(LegacyNotesActivity activity);
    void inject(LegacyNotesFragment fragment);

    @Component.Builder
    interface Builder {
        Builder appComponent(AppComponent appComponent);

        @BindsInstance
        Builder activity(LegacyNotesActivity activity);

        LegacyActivityComponent build();
    }
}
