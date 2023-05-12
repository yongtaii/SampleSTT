package com.jworld.samplestt

import android.content.Context
import android.content.Intent
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

/**
 * @HiltViewModel 를 통해 자동으로 모듈 생성.
 * */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val speechRecognizer: SpeechRecognizer,
    private val tts : MyTextToSpeech,
    @ApplicationContext private val context:Context
) :  ViewModel() {

    private val _ttsValue: MutableStateFlow<String> = MutableStateFlow("NONE")
    val ttsValue: StateFlow<String>
        get() = _ttsValue

    private val _sttResult: MutableStateFlow<String> = MutableStateFlow("")
    val sttResult: StateFlow<String>
        get() = _sttResult

    init {
        Log.d("yong1234","init viewmodel()")
    }

    fun setValueTTS(newValue : String){
        _ttsValue.value = newValue
    }

    fun startListening(){
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
            putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, context.packageName)
            putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ko-KR")
        }
        speechRecognizer.setRecognitionListener(MyRecognitionListener(listenerSTT))
        speechRecognizer.startListening(intent)
    }

    private val listenerSTT = object : MyRecognitionListener.OnResultListener {
        override fun onSuccess(message: String) {
            _sttResult.value = message
        }

        override fun onError(message: String) {
            _sttResult.value = message
        }

    }

    fun speakOut(value : String){
        Log.d("yong1234","speakOut $value")
        tts.speakOut(value)
    }

}