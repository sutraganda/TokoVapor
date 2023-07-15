package com.example.tokovapor2.aplication

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.tokovapor2.dao.VaporsDao
import com.example.tokovapor2.model.Vapors

@Database(entities = [Vapors::class], version = 2, exportSchema = false)
abstract class VaporsDatabase: RoomDatabase() {
    abstract fun vaporsDao(): VaporsDao

    companion object {
        private var INSTANCE: VaporsDatabase? = null

        // migrasi database versi 1 ke 2, karena ada perubahan taable tadi

        private val migration1To2: Migration = object: Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE vapors_table ADD COLUMN latitude Double DEFAULT 0.0")
                 database.execSQL("ALTER TABLE vapors_table ADD COLUMN longitude Double DEFAULT 0.0")
            }

        }
        fun getDatabase(context: Context): VaporsDatabase {
            return  INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    VaporsDatabase::class.java,
                    "vapors_database_2"
                )
                    .addMigrations(migration1To2)
                    .allowMainThreadQueries()
                    .build()

                INSTANCE= instance
                instance
            }

        }
    }
}