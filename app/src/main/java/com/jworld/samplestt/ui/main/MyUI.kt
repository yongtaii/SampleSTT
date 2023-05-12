package com.jworld.samplestt.ui.main

import android.content.Intent
import android.speech.RecognizerIntent
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jworld.samplestt.MainViewModel
import com.jworld.samplestt.ui.SimpleButton
import com.jworld.samplestt.ui.SimpleTextField

@Composable
fun MyUI(
    viewModel : MainViewModel = viewModel()
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val context = LocalContext.current.applicationContext

//            Text(text = viewModel.sttResult.collectAsState().value)
            Text(text = viewModel.sttResult.collectAsState().value)
            Spacer(modifier = Modifier.height(20.dp))
            SimpleButton(
                title = "Start STT",
                onClick = {
                    Toast.makeText(context,"started!", Toast.LENGTH_SHORT).show()
                    viewModel.startListening()
                })
            Spacer(modifier = Modifier.height(20.dp))
            SimpleTextField(label = "TTS", ttsValue = viewModel.ttsValue.collectAsState(), onValueChange = { viewModel.setValueTTS(it)})
            Spacer(modifier = Modifier.height(20.dp))
            SimpleButton(
                title = "Start TTS",
                onClick = {
                    viewModel.speakOut(viewModel.ttsValue.value)
                }
            )
        }

    }
}

@Preview
@Composable
fun Test(){
    Text(text = "dddd")
}