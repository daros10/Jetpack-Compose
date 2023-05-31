package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MyApplicationTheme {
        // A surface container using the 'background' color from the theme
        Surface(
          modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
        ) {
          MyFirstStateExample()
        }
      }
    }
  }
}

@Composable
fun MyFirstStateExample() {
  // val counter = remember { mutableStateOf(0) } // remember reinicia el estado de la app si se destruye el activity (ciclo de vida)
                                                // debes usar counter.value para acceder al valor
  // val counter = rememberSaveable{ mutableStateOf(0) } // guarda el estado así se haya destruido el activity
                                                        // debes usar counter.value para acceder al valor
  var counter by rememberSaveable{ mutableStateOf(0) } // usando el by debemos importar lo siguiente:
                                                            // import androidx.compose.runtime.setValue
                                                            // import androidx.compose.runtime.getValue
                                                            // ya no se usa el .value y se declara como var
  Column(
    Modifier.fillMaxSize(),
    Arrangement.Center,
    Alignment.CenterHorizontally
  ) {
    Button(onClick = {
      counter+=1
    }) {
      Text(text = "Click me")
    }
    Divider(Modifier.height(10.dp), color = Color.Transparent)
    Text(text = "you are clicked $counter")
  }
}

@Composable
fun MyComplexLayout() {
  Column(
    Modifier.fillMaxSize()
  ) {
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .weight(1f)
        .background(Color.Yellow)
    ) {
      Text(text = "This is yellow box!", Modifier.align(Alignment.Center))
    }
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .weight(1f)
        .background(Color.Red)
    ) {
      Row(
        Modifier.fillMaxSize()
      ) {
        Box(
          modifier = Modifier
            .fillMaxHeight()
            .weight(1f)
            .background(Color.Blue)
        ) {
          Text(text = "This is blue box!", color = Color.White)
        }
        Box(
          modifier = Modifier
            .fillMaxHeight()
            .weight(1f)
            .background(Color.Green)
        ) {
          Text(text = "This is green box!", color = Color.White)
        }
      }
    }
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .weight(1f)
        .background(Color.Gray)
    ) {
      Column {
        Box(
          modifier = Modifier
            .background(Color.Red)
            .fillMaxWidth()
            .weight(1f)
        ) {
          Row {
            Box(
              modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .background(Color.Black),
              contentAlignment = Alignment.BottomEnd
            ) {
              Text(text = "black box!", color = Color.White)
            }
            Box(
              modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .background(Color.White),
              contentAlignment = Alignment.BottomEnd
            ) {
              Text(text = "white box!", color = Color.Black)
            }
            Box(
              modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .background(Color.DarkGray),
              contentAlignment = Alignment.BottomEnd
            ) {
              Text(text = "gray box!", color = Color.White)
            }
          }
        }
        Box(
          modifier = Modifier
            .background(Color.Magenta)
            .fillMaxWidth()
            .weight(1f),
        ) {
          Row {
            Box(
              modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .background(Color.Cyan),
              contentAlignment = Alignment.BottomCenter
            ) {
              Text(text = "cyan box!", color = Color.Black)
            }
            Box(
              modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .background(Color.LightGray),
              contentAlignment = Alignment.BottomCenter
            ) {
              Text(text = "cyan light!", color = Color.Black)
            }
            Box(
              modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .background(Color.Transparent),
              contentAlignment = Alignment.BottomCenter
            ) {
              Text(text = "tr box!", color = Color.Black)
            }
            Box(
              modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .background(Color.Yellow),
              contentAlignment = Alignment.BottomCenter
            ) {
              Text(text = "yellow box!", color = Color.Black)
            }
          }
        }
      }
    }
  }
}

@Composable
fun MyRow() {
  Row(
    Modifier.fillMaxSize(),
    horizontalArrangement = Arrangement.SpaceBetween
  ) {
    Text("This is my text 1", modifier = Modifier.background(Color.Magenta))
    Text("This is my text 2", modifier = Modifier.background(Color.Blue))
    Text("This is my text 3", modifier = Modifier.background(Color.Cyan))
  }
}

@Composable
fun MyColum() {
  Column(
    Modifier
      .fillMaxWidth()
      .verticalScroll(
        rememberScrollState()
      ),
  ) {
    Text("This is my text 1", modifier = Modifier.background(Color.Red))
    Text("This is my text 2", modifier = Modifier.background(Color.Cyan))
    Text("This is my text 3", modifier = Modifier.background(Color.Yellow))
    Text("This is my text 4", modifier = Modifier.background(Color.Green))
    Box {
      Text(
        "This is my text 6", modifier = Modifier
          .background(Color.Gray)
          .fillMaxWidth()
          .height(50.dp)
      )
    }
  }
}

@Composable
fun MyBox() {
  Box(
    modifier = Modifier.fillMaxSize(),
  ) {
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .height(80.dp)
        .background(Color.Red)
        .align(Alignment.TopCenter)
        .verticalScroll(
          rememberScrollState()
        )
    ) {
      Text(
        "this is mi text!!!!", modifier = Modifier.align(Alignment.Center)
      )
    }
  }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
  MyApplicationTheme {
    MyFirstStateExample()
  }
}