package fr.mastersid.soetewey.stackoverflow.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import fr.mastersid.soetewey.stackoverflow.ui.theme.StackOverflowTheme
import fr.mastersid.soetewey.stackoverflow.viewmodel.QuestionViewModel

@Composable
fun QuestionsScreen(questionViewModel: QuestionViewModel = viewModel()){

    val questionList by questionViewModel.questionList.observeAsState(initial = emptyList())
    val refreshing by questionViewModel.isUpdating.observeAsState(initial = false)

    Box{
        if (refreshing) {
            LinearProgressIndicator(
                modifier = Modifier.fillMaxWidth()
            )
        }
        LazyColumn(
            modifier = Modifier.fillMaxSize() ,
            contentPadding = PaddingValues(16.dp) ,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        )
        {

            items(questionList) { question ->
                QuestionRow(question = question)
            }
            item {
                Spacer(modifier = Modifier.height(64.dp))
            }

        }
        UpdateQuestionButton(
            updateQuestions = questionViewModel::updateQuestionsList,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(16.dp)

        )
    }
}

@Preview(showBackground = true)
@Composable
fun QuestionScreenPreview () {
    StackOverflowTheme {
       QuestionsScreen(
       )
    }
}