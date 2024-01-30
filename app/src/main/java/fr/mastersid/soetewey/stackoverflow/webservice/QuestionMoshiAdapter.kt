package fr.mastersid.soetewey.stackoverflow.webservice

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import fr.mastersid.soetewey.stackoverflow.data.ListQuestionJson
import fr.mastersid.soetewey.stackoverflow.data.Question
import fr.mastersid.soetewey.stackoverflow.data.QuestionJson

class QuestionMoshiAdapter {
    @FromJson
    fun fromJson(listQuestionJson: ListQuestionJson): List<Question>{
        return listQuestionJson.items.map { questionJson ->
            Question(questionJson.question_id, questionJson.title, questionJson.answer_count, questionJson.last_activity_date)
        }
    }

    @ToJson
    fun toJson(listQuestion: List<Question>):ListQuestionJson {
        return ListQuestionJson(
            listQuestion.map { question ->
                QuestionJson(question.id, question.answerCount, question.title, question.lastActivityDate);

            }
        )
    }
}