package fr.mastersid.soetewey.stackoverflow.db

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object StackDatabaseModule {

    @Provides
    fun provideQuestionDao(stackDatabase: StackDatabase): StackDao{
        return stackDatabase.questionDao()
    }

    @Provides
    @Singleton
    fun provideQuesionRoomDatabase(@ApplicationContext appContext: Context): StackDatabase{
        return Room.databaseBuilder(
            appContext.applicationContext,
            StackDatabase::class.java,
            "question_database"
        ).build()
    }
}