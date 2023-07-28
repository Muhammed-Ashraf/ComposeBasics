package ashraf.composebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ashraf.composebasics.ui.theme.ComposeBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            ComposeBasicsTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
            Greeting("Android")
//                }
//            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Column() {
        for (i in 1..10)
            Icon(imageVector = Icons.Default.Add, contentDescription = null)
    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeBasicsTheme {
        Greeting("Android")
    }
}