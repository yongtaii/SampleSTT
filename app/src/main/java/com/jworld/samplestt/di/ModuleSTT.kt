package com.jworld.samplestt.di

import android.content.Context
import android.content.Intent
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import com.jworld.samplestt.MyRecognitionListener
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

@Module
@InstallIn(SingletonComponent::class)
object ModuleSTT {

    @Provides
    fun provideSpeechRecognizer(
        @ApplicationContext appContext: Context,
    ): SpeechRecognizer {
        return SpeechRecognizer.createSpeechRecognizer(appContext)
    }
}