package com.jworld.samplestt.di

import android.content.Context
import android.speech.SpeechRecognizer
import android.speech.tts.TextToSpeech
import android.util.Log
import com.jworld.samplestt.MyRecognitionListener
import com.jworld.samplestt.MyTextToSpeech
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.util.Locale

@Module
@InstallIn(SingletonComponent::class)
object ModuleTTS {

//    @Provides
//    fun provideMyTextToSpeech(@ApplicationContext appContext: Context): MyTextToSpeech {
//        Log.d("yong1234","provideMyTextToSpeech()")
//        return MyTextToSpeech(appContext)
//    }


}