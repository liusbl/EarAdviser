package lt.liusbl.earadviser.base.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import lt.liusbl.earadviser.training.notes.NoteItem
import lt.liusbl.earadviser.training.notes.NoteItemDao

@Database(entities = [NoteItem::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteItemDao(): NoteItemDao
}

