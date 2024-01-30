package fr.mastersid.soetewey.stackoverflow.repository

import fr.mastersid.soetewey.stackoverflow.data.CoroutineScopeIO
import fr.mastersid.soetewey.stackoverflow.data.QuestionResponse
import fr.mastersid.soetewey.stackoverflow.db.StackDao
import fr.mastersid.soetewey.stackoverflow.webservice.QuestionWebservice
import kotlinx.coroutines.CoroutineScope

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QuestionRepositoryImpl @Inject constructor(
    private val questionWebservice: QuestionWebservice,
    private val stackDao: StackDao,
    @CoroutineScopeIO private val coroutineScopeIO : CoroutineScope
) : QuestionRepository {
    override val questionResponse: MutableStateFlow<QuestionResponse> = MutableStateFlow(
        QuestionResponse.Success(emptyList())
    )

    init {
        coroutineScopeIO.launch {
            stackDao.getQuestionListFlow().collect() { list ->
                questionResponse.emit(QuestionResponse.Success(list))
            }
        }
    }

    override suspend fun updateQuestionsInfo() {
        questionResponse.emit(QuestionResponse.Pending)
        val list = questionWebservice
            .getQuestionList()
        stackDao.insertAll(list)
    }
}