package lt.liusbl.earadviser.base.database

interface DatabaseBundleInitializer {
    fun <T> initialize(json: String, genericClass: Class<T>, dao: BaseDao<T>, name: String)
}