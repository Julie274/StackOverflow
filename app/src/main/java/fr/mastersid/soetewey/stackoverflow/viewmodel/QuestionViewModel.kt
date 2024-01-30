package fr.mastersid.soetewey.stackoverflow.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.mastersid.soetewey.stackoverflow.data.Question
import fr.mastersid.soetewey.stackoverflow.data.QuestionResponse
import fr.mastersid.soetewey.stackoverflow.repository.QuestionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionViewModel @Inject constructor(
    private val questionRepository: QuestionRepository
) : ViewModel() {
    private val _questionList : MutableLiveData<List<Question>> = MutableLiveData(emptyList())
    val questionList: LiveData<List<Question>> = _questionList

    private val _isUpdating = MutableLiveData(false)
    val isUpdating : LiveData<Boolean> = _isUpdating

    init {
        viewModelScope.launch(Dispatchers.IO) {
            questionRepository.questionResponse.collect{ response ->
                when(response){
                    is QuestionResponse.Pending -> _isUpdating.postValue(true)
                    is QuestionResponse.Success -> {
                        _questionList.postValue(response.list.sortedBy { question -> question.lastActivityDate})
                        _isUpdating.postValue(false)
                    }
                }
            }
        }
    }
    fun updateQuestionsList() {
        viewModelScope.launch(Dispatchers.IO) {
            questionRepository.updateQuestionsInfo()
        }
    }
}