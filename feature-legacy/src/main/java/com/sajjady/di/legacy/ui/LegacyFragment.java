package com.sajjady.di.legacy.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.sajjady.di.core.api.RemoteConfig;
import com.sajjady.di.core.api.UserSessionManager;
import com.sajjady.di.core.model.User;
import com.sajjady.di.legacy.R;

import javax.inject.Inject;

public class LegacyFragment extends Fragment {

    @Inject
    UserSessionManager userSessionManager;

    @Inject
    RemoteConfig remoteConfig;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        ((LegacyComponentOwner) requireActivity()).legacyComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_legacy, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView summary = view.findViewById(R.id.legacySummary);
        userSessionManager.login(new User("legacy", "Legacy User", false));
        String env = remoteConfig.getString("environment");
        summary.setText("User: " + userSessionManager.getCurrentUser().getName() + "@" + env);
    }
}
