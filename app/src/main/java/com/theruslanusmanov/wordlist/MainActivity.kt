package com.theruslanusmanov.wordlist

import android.os.Bundle
import android.util.Log
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.gson.Gson
import com.theruslanusmanov.wordlist.question.Question
import com.theruslanusmanov.wordlist.ui.theme.WordListTheme
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.Reader


data class Wordlist(
    val image: String,
    val words: List<String>,
    val correct: Long
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val wordlistRaw = resources.openRawResource(R.raw.wordlist)
        val rd: Reader = BufferedReader(InputStreamReader(wordlistRaw))
        val obj = Gson().fromJson(rd, Array<Wordlist>::class.java)

        // Get the Wordlist objects array
        for (item in obj) {
            Log.d("gson_obj", item.words.toString())
        }

        val index = 0

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
                        val imageId = resources.getIdentifier(obj[index].image, "drawable", packageName)
                        Wordlist(imageId)
                    }
                }
            }
        }
    }
}

@Composable
fun Picture(imageId: Int) {
    Box(
        modifier = Modifier
            .border(width = 2.dp, color = Color.LightGray, shape = RoundedCornerShape(12))
            .padding(25.dp)
    ) {
        val image: Painter = painterResource(id = imageId)
        Image(
            painter = image, contentDescription = "", modifier = Modifier
                .width(50.dp)
                .height(50.dp)
        )
    }
}

@Composable
fun Wordlist(imageId: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
    ) {
        val lmd: (String) -> Unit = {answer: String -> Log.d("SELECTED", answer)}

        Picture(imageId)
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
            Question(
                possibleAnswers = listOf("apple", "grapes", "lemon", "watermelon"),
                selectedAnswers = listOf("apple", "grapes", "lemon", "watermelon"),
                onOptionSelected = lmd
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WordListTheme {
        Question(
            possibleAnswers = listOf("apple", "grapes", "lemon", "watermelon"),
            selectedAnswers = listOf("apple", "grapes", "lemon", "watermelon"),
            onOptionSelected = { _ ->  }
        )
    }
}