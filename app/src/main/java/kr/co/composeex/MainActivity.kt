package kr.co.composeex

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
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
                MyOnboarding()
            //MyApp()
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
fun MyOnboarding() {
    var shouldShowOnboarding by remember { mutableStateOf(true) }

    if(shouldShowOnboarding) {
        OnboardingScreen(onContinueClicked = {shouldShowOnboarding = false})
    } else {
        MyApp()
    }
}

@Composable
fun OnboardingScreen(onContinueClicked : () -> Unit) {
    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Welcome to the Basics Codelab!")
            Button(
                modifier = Modifier.padding(vertical = 24.dp),
                onClick = onContinueClicked
            ) {
                Text("Continue")
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview() {
    ComposeExTheme {
        OnboardingScreen(onContinueClicked = { })
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
    /** remember를 사용하여 state가 다시 false로 리컴포지션 되는것을 방지 */
    val expanded = remember { mutableStateOf(false)}

    val extraPadding = if(expanded.value) 48.dp else 0.dp

    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding)
            ) {
                Text(text = "Hello, ")
                Text(text = name)
            }
            OutlinedButton(onClick = { expanded.value = !expanded.value }) {
                Text(if(expanded.value) "Show less" else "Show more")
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