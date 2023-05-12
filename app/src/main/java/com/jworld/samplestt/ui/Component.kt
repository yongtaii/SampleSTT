package com.jworld.samplestt.ui

import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleTextField(label: String, ttsValue : State<String>, onValueChange : (String) -> Unit ){

    TextField(
        value = ttsValue.value,
        onValueChange = onValueChange,
        label = {
            Text(text = label)
        },
        singleLine = true
    )
}

@Composable
fun SimpleButton(
    title : String,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        content= {
            Text(text = title)
        },
    )
}