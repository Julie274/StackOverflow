package fr.mastersid.soetewey.stackoverflow.view

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.mastersid.soetewey.stackoverflow.ui.theme.StackOverflowTheme

@Composable
fun UpdateQuestionButton(
    updateQuestions : () -> Unit,
    modifier : Modifier
)
{
    Button(
        onClick = updateQuestions,
        modifier = modifier
    ) {
        Text("Update questions")
    }
}

@Preview(showBackground = true)
@Composable
fun UpdateQuestionButtonPreview () {
    StackOverflowTheme {
        UpdateQuestionButton(
            updateQuestions = {},
            modifier =Modifier.size(
                width = 400.dp,
                height = 100.dp)
        )
    }
}
