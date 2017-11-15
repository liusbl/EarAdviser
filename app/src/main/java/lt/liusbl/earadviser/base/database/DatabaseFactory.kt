package lt.liusbl.earadviser.base.database

interface DatabaseFactory {
    fun create(): AppDatabase
}