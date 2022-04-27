package kr.co.composeex

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kr.co.composeex.ui.theme.ComposeExTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeExTheme {
                // A surface container using the 'background' color from the theme
//                Column(modifier = Modifier.padding(24.dp)) {
//                    Greeting(name = "안녕")
//                    Greeting(name = "잘지내")
//                    Greeting(name = "나야나")
//                }
//                Greeting(names = listOf<String>("안녕","잘가","잘지내"))
                MyApp()
            }
        }

//        lifecycleScope.launch {
//            val stTime = System.currentTimeMillis()
//            val lastName : Deferred<String> = async {
//                delay(1000)
//                "최"
//            }
//            val name : Deferred<String> = async {
//                delay(2000)
//                "효식"
//            }
//
//            Log.d("lastname" , "${lastName.await()}${name.await()} , time : ${System.currentTimeMillis() - stTime}")
//        }

    }
}

@Composable
fun MyApp(names: List<String> = listOf<String>("안녕", "잘가", "잘지내")) {
    Column(modifier = Modifier.padding(vertical = 4.dp)) {
        for (name in names) {
            Greeting(name = name)
        }
    }
}

@Composable
fun Greeting(name: String) {
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Hello, ")
                Text(text = name)
            }
            OutlinedButton(onClick = { /*TODO*/ }) {
                Text("Show more")
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    ComposeExTheme {
        MyApp()
    }
}