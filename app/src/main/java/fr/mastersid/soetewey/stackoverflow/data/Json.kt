package fr.mastersid.soetewey.stackoverflow.data

data class ListQuestionJson(
    val items: List<QuestionJson>
)

data class QuestionJson(
    val question_id : Int,
    val answer_count : Int,
    val title: String,
    val last_activity_date: Int
)
