package com.sajjady.di.legacy.di;

import com.sajjady.di.data.di.DataComponent;
import com.sajjady.di.legacy.ui.LegacyActivity;
import com.sajjady.di.legacy.ui.LegacyFragment;

import dagger.Component;

@LegacyScope
@Component(dependencies = DataComponent.class, modules = LegacyModule.class)
public interface LegacyComponent {
    void inject(LegacyActivity activity);

    void inject(LegacyFragment fragment);
}
