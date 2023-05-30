package com.example.firstcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstcomposeapp.ui.theme.FirstComposeAppTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      FirstComposeAppTheme {
        // A surface container using the 'background' color from the theme
        Surface(
          modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
        ) {
          MyFirstUI()
        }
      }
    }
  }
}

@Composable
@Preview(
  name = "This is my awesome preview!", showBackground = true, showSystemUi = true
)
fun MyFirstUI() {
  Text(text = "Testing composable! :)", modifier = Modifier
    .width(200.dp)
    .height(50.dp)
    .clickable {
      println("this is clickable!")
    }
  )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
  Text(
    text = "Hello $name!", modifier = modifier
  )
}

@Preview()
@Composable
fun GreetingPreview() {
  FirstComposeAppTheme {
    Greeting("oh!")
  }
}