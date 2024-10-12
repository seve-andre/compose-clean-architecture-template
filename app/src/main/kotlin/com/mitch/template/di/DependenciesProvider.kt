package com.mitch.template.di

import androidx.datastore.core.DataStore
import com.mitch.template.data.TemplateDatabase
import com.mitch.template.data.settings.UserSettingsRepository
import com.mitch.template.domain.models.UserPreferences
import com.mitch.template.util.network.NetworkMonitor
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope

interface DependenciesProvider {
    val networkMonitor: NetworkMonitor
    val userSettingsRepository: UserSettingsRepository
    val ioDispatcher: CoroutineDispatcher
    val defaultDispatcher: CoroutineDispatcher
    val coroutineScope: CoroutineScope
    val database: TemplateDatabase
    val preferencesDataStore: DataStore<UserPreferences>
}
