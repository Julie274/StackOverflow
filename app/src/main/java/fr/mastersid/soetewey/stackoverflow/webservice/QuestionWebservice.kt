package fr.mastersid.soetewey.stackoverflow.webservice

import fr.mastersid.soetewey.stackoverflow.data.ListQuestionJson
import fr.mastersid.soetewey.stackoverflow.data.Question
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface QuestionWebservice {
    @GET("questions?pagesize=20&order=desc&sort=activity&site=stackoverflow")
    suspend fun getQuestionList(
    ): List<Question>
}