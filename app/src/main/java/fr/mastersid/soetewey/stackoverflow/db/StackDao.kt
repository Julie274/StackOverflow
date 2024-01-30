package fr.mastersid.soetewey.stackoverflow.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import fr.mastersid.soetewey.stackoverflow.data.Question

@Dao
interface StackDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<Question>)

    @Query("SELECT * FROM question_table ORDER BY lastActivityDate")
    fun getQuestionListFlow(): kotlinx.coroutines.flow.Flow<List<Question>>
}