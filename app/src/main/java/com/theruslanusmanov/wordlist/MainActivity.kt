package com.theruslanusmanov.wordlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.theruslanusmanov.wordlist.ui.theme.WordListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WordListTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceAround
                    ) {
                        val image: Painter = painterResource(id = R.drawable.watermelon)
                        WordPic(image)
                    }
                }
            }
        }
    }
}

@Composable
fun WordPic(image: Painter) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
    ) {
        Box(
            modifier = Modifier
                .border(width = 2.dp, color = Color.LightGray, shape = RoundedCornerShape(12))
                .padding(25.dp)
        ) {
            Image(
                painter = image, contentDescription = "", modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
            )
        }
        Text(
            text = "Guess the word",
            modifier = Modifier.padding(25.dp),
            fontWeight = FontWeight(700),
            color = Color.Gray
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Word("Watermelon")
            Word("Watermelon")
            Word("Watermelon")
            Word("Watermelon")
        }
    }
}

@Composable
fun Word(word: String) {
    Text(
        text = word,
        modifier = Modifier
            .width(width = 250.dp)
            .padding(5.dp)
            .border(width = 2.dp, color = Color.LightGray, shape = RoundedCornerShape(12))
            .padding(10.dp),
        fontWeight = FontWeight(700),
        color = Color.Gray,
        textAlign = TextAlign.Center
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WordListTheme {
        val image: Painter = painterResource(id = R.drawable.watermelon)
        WordPic(image)
        Word("Watermelon")
    }
}