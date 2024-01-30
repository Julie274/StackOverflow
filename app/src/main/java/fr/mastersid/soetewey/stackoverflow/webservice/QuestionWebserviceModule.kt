package fr.mastersid.soetewey.stackoverflow.webservice

import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

private const val BASE_URL = "https://api.stackexchange.com/2.3/"

@Module
@InstallIn(SingletonComponent::class)
object QuestionWebserviceModule {
    @Provides
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory())
            .add(QuestionMoshiAdapter())
            .build()
    }

    @Provides
    fun provideRetrofit(moshi:Moshi) : Retrofit {
        return Retrofit.Builder ()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .build()
    }

    @Provides
    fun provideQuestionWebservice(retrofit: Retrofit): QuestionWebservice {
        return retrofit.create(QuestionWebservice::class.java)
    }
}