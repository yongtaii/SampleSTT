package com.jworld.samplestt

import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.SpeechRecognizer
import android.util.Log

class MyRecognitionListener(
    private val listener : OnResultListener
) : RecognitionListener {

    override fun onReadyForSpeech(params: Bundle?) {
        Log.d("yong1234","onReadyForSpeech() 음성인식을 시작합니다")
//        Toast.makeText(applicationContext, "음성인식을 시작합니다.", Toast.LENGTH_SHORT).show()
    }

    override fun onBeginningOfSpeech() {

    }

    override fun onRmsChanged(rmsdB: Float) {

    }

    override fun onBufferReceived(buffer: ByteArray?) {

    }

    override fun onEndOfSpeech() {
        Log.d("yong1234","onEndOfSpeech()")
    }

    override fun onError(error: Int) {
        var message: String

        when (error) {
            SpeechRecognizer.ERROR_AUDIO ->
                message = "오디오 에러"
            SpeechRecognizer.ERROR_CLIENT ->
                message = "클라이언트 에러"
            SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS ->
                message = "퍼미션 없음"
            SpeechRecognizer.ERROR_NETWORK ->
                message = "네트워크 에러"
            SpeechRecognizer.ERROR_NETWORK_TIMEOUT ->
                message = "네트워크 타임아웃"
            SpeechRecognizer.ERROR_NO_MATCH ->
                message = "찾을 수 없음"
            SpeechRecognizer.ERROR_RECOGNIZER_BUSY ->
                message = "RECOGNIZER가 바쁨"
            SpeechRecognizer.ERROR_SERVER ->
                message = "서버가 이상함"
            SpeechRecognizer.ERROR_SPEECH_TIMEOUT ->
                message = "말하는 시간초과"
            else ->
                message = "알 수 없는 오류"
        }

        Log.d("yong1234","onError() 에러 발생 $message")
        listener.onError(message = message)

//        Toast.makeText(applicationContext, "에러 발생 $message", Toast.LENGTH_SHORT).show()
    }

    override fun onResults(results: Bundle?) {
        var matches: ArrayList<String> = results?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION) as ArrayList<String>

        for (i in 0 until matches.size) {
//            tvResult.text = matches[i]
            Log.d("yong1234","onResults() ${matches[i]}")
            listener.onSuccess(message = matches[i])
        }

    }

    override fun onPartialResults(partialResults: Bundle?) {

    }

    override fun onEvent(eventType: Int, params: Bundle?) {

    }

    interface OnResultListener {
        fun onSuccess(message: String)
        fun onError(message: String)
    }
}