package fr.mastersid.soetewey.stackoverflow.repository

import fr.mastersid.soetewey.stackoverflow.data.QuestionResponse

interface QuestionRepository {
    val questionResponse : kotlinx.coroutines.flow.Flow<QuestionResponse>

    suspend fun updateQuestionsInfo()

}