package com.theruslanusmanov.wordlist.question

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.primarySurface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun Word(
    word: String,
    selected: Boolean,
    onOptionSelected: () -> Unit,
) {
    Text(
        text = word,
        modifier = Modifier
            .width(width = 250.dp)
            .padding(5.dp)
            .border(width = 2.dp, color = Color.LightGray, shape = RoundedCornerShape(12))
            .padding(10.dp)
            .clickable(onClick = onOptionSelected),
        fontWeight = FontWeight(700),
        color = if (selected) {
            MaterialTheme.colors.primary
        } else {
            MaterialTheme.colors.primarySurface
        },
        textAlign = TextAlign.Center,

        )
}


@Composable
fun Question(
    possibleAnswers: List<String>,
    selectedAnswers: List<String>,
    onOptionSelected: (answer: String) -> Unit,
) {
    possibleAnswers.forEach {
        val selected = selectedAnswers.contains(it)
        Word(word = it, true, onOptionSelected = { onOptionSelected(it) })
    }
}