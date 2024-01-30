package fr.mastersid.soetewey.stackoverflow.db

import androidx.room.Database
import androidx.room.RoomDatabase
import fr.mastersid.soetewey.stackoverflow.data.Question

@Database(
    entities = [Question::class],
    version = 1,
    exportSchema = false
)
abstract class StackDatabase : RoomDatabase(){
    abstract fun questionDao(): StackDao
}