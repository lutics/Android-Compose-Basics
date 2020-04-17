package com.example.android.compose.basics

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.Model
import androidx.ui.core.Text
import androidx.ui.core.setContent
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.layout.LayoutHeight
import androidx.ui.layout.LayoutPadding
import androidx.ui.material.*
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppTheme {
                Surface {
                    MyScreenContent()
                }
            }
        }
    }
}

@Preview("MyScreen preview")
@Composable
fun DefaultPreview() {
    MyAppTheme {
        Surface {
            MyScreenContent()
        }
    }
}

val green = Color(0xFF1EB980)
private val themeColors = lightColorPalette(
    primary = green,
    surface = Color.DarkGray,
    onSurface = green
)

@Composable
fun MyAppTheme(children: @Composable() () -> Unit) {
    MaterialTheme(colors = themeColors) {
        children()
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
        modifier = LayoutPadding(24.dp),
        style = MaterialTheme.typography().h1
    )
}

@Composable
fun MyScreenContent(
    names: List<String> = listOf("Android", "there"),
    counterState: CounterState = CounterState()
) {
    Column(modifier = LayoutHeight.Fill) {
        Column(modifier = LayoutWeight(1f)) {
            for (name in names) {
                Greeting(name = name)
                Divider(color = Color.Black)
            }
        }
        Counter(counterState)
    }
}

@Model
class CounterState(var count: Int = 0)

@Composable
fun Counter(state: CounterState) {
    Button(
        onClick = { state.count++ },
        backgroundColor = if (state.count > 5) Color.Green else Color.White
    ) {
        Text("I've been clicked ${state.count} times")
    }
}