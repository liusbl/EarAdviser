package lt.liusbl.earadviser.base.database

import com.google.gson.Gson
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.json.JSONObject

class DatabaseBundleInitializerImpl(private val gson: Gson) : DatabaseBundleInitializer {
    override fun <T> initialize(
            json: String,
            genericClass: Class<T>,
            dao: BaseDao<T>,
            name: String
    ) {
        val jsonObject = JSONObject(json)
        val notes = jsonObject.getJSONArray(name)

        val noteItems = (0 until notes.length()).map { index ->
            gson.fromJson(notes.get(index).toString(), genericClass)
        }
        insertNotes(dao, noteItems)
    }

    private fun <T> insertNotes(dao: BaseDao<T>, noteItems: List<T>) {
        Completable.fromAction {
            dao.insertMany(noteItems.toMutableList())
        }.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe()
    }
}