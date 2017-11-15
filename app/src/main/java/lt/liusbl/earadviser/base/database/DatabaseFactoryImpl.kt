package lt.liusbl.earadviser.base.database

import android.arch.persistence.room.Room
import android.content.Context

class DatabaseFactoryImpl(
        private val context: Context,
        private val initializer: DatabaseInitializer
) : DatabaseFactory {
    override fun create(): AppDatabase {
        val appDatabase = Room.databaseBuilder(context.applicationContext,
                AppDatabase::class.java, DATABASE_NAME).build()
        initializer.initialize(appDatabase)
        return appDatabase
    }

    companion object {
        private const val DATABASE_NAME = "ear_adviser_database.db"
    }
}