package com.sajjady.di.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.sajjady.di.core.api.RemoteConfig
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BootCompletedReceiver : BroadcastReceiver() {

    @Inject lateinit var remoteConfig: RemoteConfig

    override fun onReceive(context: Context?, intent: Intent?) {
        remoteConfig.getString("environment")
    }
}
