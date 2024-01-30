package fr.mastersid.soetewey.stackoverflow.repository

import fr.mastersid.soetewey.stackoverflow.data.QuestionResponse
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class QuestionRepositoryDummyImpl @Inject constructor() : QuestionRepository{
    override val questionResponse: MutableStateFlow<QuestionResponse> = MutableStateFlow(
        QuestionResponse.Success(emptyList())
    )

    override suspend fun updateQuestionsInfo() {
        questionResponse.emit(QuestionResponse.Pending)
        delay(5000)
        questionResponse.emit (
            QuestionResponse.Success (
                listOf (
                    /*
                    Question(1, "Kotlin doesn't work",(0..20).random()),
                    Question(2, "Short question",(0..20).random()),
                    Question(3, "A very very very very very very very very very long question",(0..20).random()),
                     */
                )
            )
        )
    }
}