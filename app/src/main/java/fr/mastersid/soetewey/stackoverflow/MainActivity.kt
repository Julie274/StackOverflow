package fr.mastersid.soetewey.stackoverflow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import fr.mastersid.soetewey.stackoverflow.ui.theme.StackOverflowTheme
import fr.mastersid.soetewey.stackoverflow.view.QuestionsScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StackOverflowTheme {
                QuestionsScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StackOverflowTheme {
        QuestionsScreen()
    }
}