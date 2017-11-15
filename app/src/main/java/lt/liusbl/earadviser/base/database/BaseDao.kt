package lt.liusbl.earadviser.base.database

import android.arch.persistence.room.*

@Dao
interface BaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMany(items: MutableList<T>)

    @Update
    fun update(item: T)

    @Update
    fun updateMany(items: MutableList<T>)

    @Delete
    fun delete(item: T)

    @Delete
    fun deleteAll(items: MutableList<T>)
}