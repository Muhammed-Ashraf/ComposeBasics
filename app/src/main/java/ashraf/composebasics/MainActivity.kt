package ashraf.composebasics

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ashraf.composebasics.ui.theme.ComposeBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicsTheme {
                var name by remember { mutableStateOf("") }
                var names by remember { mutableStateOf(listOf<String>()) }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        OutlinedTextField(value = name, onValueChange = { text ->
                            name = text
                        }, modifier = Modifier.weight(1f))
                        Spacer(modifier = Modifier.width(16.dp))
                        Button(onClick = {
                            if (name.isNotBlank()) {
                                if (names.contains(name)) {
                                    Toast.makeText(
                                        this@MainActivity, "Already In the list", Toast.LENGTH_SHORT
                                    ).show()
                                } else {
                                    names = names + name
                                    name = ""
                                }

                            } else {
                                Toast.makeText(
                                    this@MainActivity, "Please enter name", Toast.LENGTH_SHORT
                                ).show()
                            }
                        }) {
                            Text(text = "Add")
                        }
                    }

                    NameList(names = names, modifier = Modifier.fillMaxWidth())
                }
            }
        }
    }

    @Composable
    fun NameList(
        names: List<String>, modifier: Modifier
    ) {
        LazyColumn(modifier) {
            items(names) { it ->
                Text(
                    text = it, modifier = Modifier.padding(horizontal = 2.dp, vertical = 16.dp)
                )
                Divider(color = Color.Gray, thickness = .5.dp)
            }
        }
    }
}


