package com.example.crud_app

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
//passing null means using the defult cursor factory for the pointer
class NoteDatabaseHelper(context: Context) :SQLiteOpenHelper(context,DATABASE_NAME,null,
    DATABASE_VERSION){
//    companion object is a way to define static-like members within a class.
    companion object{
        private const val  DATABASE_NAME="notes.db"
        private const val   DATABASE_VERSION=1
        private const val  TABLE_NAME="allnotes"
    private const val  COLOUMN_ID="id"
    private const val  COLOUMN_TITLE="title"
    private const val  COLUMN_CONTENT="content"


    }

    override fun onCreate(db: SQLiteDatabase?) {
        val create_table_query= "CREATE TABLE $TABLE_NAME($COLOUMN_ID INTEGER PRIMARY KEY,$COLOUMN_TITLE TEXT ,$COLUMN_CONTENT TEXT )"
        db?.execSQL(create_table_query)


    }

    override fun onUpgrade(db: SQLiteDatabase?, oldversion: Int, newVersion: Int) {
        val drop_table_query= "DROP TABLE IF EXISTS $TABLE_NAME"
        db?.execSQL(drop_table_query)
        onCreate(db)
}
    fun insertNote(note:Note){
        val db= writableDatabase
        val values=ContentValues().apply {
          put(COLOUMN_TITLE,note.title)
            put(COLUMN_CONTENT,note.content)
        }
        db.insert(TABLE_NAME,null,values)
        db.close()


    }    }