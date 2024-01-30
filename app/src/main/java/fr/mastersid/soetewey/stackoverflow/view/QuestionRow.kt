package fr.mastersid.soetewey.stackoverflow.view

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.mastersid.soetewey.stackoverflow.data.Question
import fr.mastersid.soetewey.stackoverflow.ui.theme.StackOverflowTheme

@Composable
fun QuestionRow(question : Question){
    Row {
        Text(
            text = question.title,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = question.answerCount.toString())
    }
}

@Preview(showBackground = true )
@Composable
fun QuestionRowPreview () {
    StackOverflowTheme {
        QuestionRow(Question(1 , "Question", 7, 123))
    }
}
