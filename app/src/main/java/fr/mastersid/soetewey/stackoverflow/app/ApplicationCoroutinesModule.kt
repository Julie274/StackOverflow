package fr.mastersid.soetewey.stackoverflow.app

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fr.mastersid.soetewey.stackoverflow.data.CoroutineScopeIO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object ApplicationCoroutinesModule {
    @CoroutineScopeIO
    @Singleton
    @Provides
    fun providesApplicationCoroutineScopeIO(): CoroutineScope {
        return CoroutineScope(SupervisorJob() + Dispatchers.IO)
    }

}