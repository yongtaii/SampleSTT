package com.jworld.samplestt

import android.content.Context
import android.speech.tts.TextToSpeech
import android.util.Log
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.util.Locale
import javax.inject.Inject

class MyTextToSpeech @Inject constructor(@ApplicationContext val appContext: Context){

    var isInit = false
    private lateinit var tts: TextToSpeech

    init {
        init()
        Log.d("yong1234","init 1")
    }

    private fun init(){
        Log.d("yong1234","init 2")

        tts = TextToSpeech(appContext){
            val result = tts.setLanguage(Locale.KOREAN)
            if (result == TextToSpeech.SUCCESS) {
                val result = tts.setLanguage(Locale.KOREAN)

                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Log.d("yong1234","The Language not supported!")
                    isInit = false
                } else {
                    Log.d("yong1234","init success()")
                    isInit = true
//                btnSpeak!!.isEnabled = true
                }
            }else{
                isInit = false
                Log.d("yong1234","init failed()")
            }

        }
    }

    fun speakOut(text : String) {
        Log.d("yong1234","speakOut()")
        Log.d("yong1234","isInit : $isInit")
        if(isInit){
            tts.speak(text, TextToSpeech.QUEUE_ADD, null,"")
        }else{
            init()
        }

    }
}