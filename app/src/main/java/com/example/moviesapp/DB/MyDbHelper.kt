package com.example.moviesapp.DB

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.text.Layout
import android.view.LayoutInflater
import com.example.moviesapp.Models.User
import com.example.moviesapp.databinding.FragmentAddBinding

class MyDbHelper(context : Context) : SQLiteOpenHelper(context, NAME,null, DV_VERSIONS), MyDbInterface{
    companion object{
        const val DB_NAME = "Movie app2"

        const val DV_VERSIONS = 1

        const val TABLE_NAME = "Movies"

        const val ID = "id"

        const val NAME = "name"

        const val AUTHORS = "authors"

        const val ABOUT = "about"

        const val DATE = "date"
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        var query = "CREATE TABLE $TABLE_NAME($ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, $NAME TEXT NOT NULL, $AUTHORS TEXT NOT NULL, $ABOUT TEXT NOT NULL, $DATE TEXT NOT NULL)"

        p0!!.execSQL(query)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    override fun addUser(user: User) {
        var database = this.writableDatabase
        var contentValue = ContentValues()
        contentValue.put(NAME,user.name)
        contentValue.put(AUTHORS,user.authors)
        contentValue.put(ABOUT,user.about)
        contentValue.put(DATE,user.date)
        database.insert(TABLE_NAME,null,contentValue)
        database.close()
    }

    override fun getUser(): ArrayList<User> {
        val list = ArrayList<User>()
        val query = "select * from $TABLE_NAME"
        val database = this.readableDatabase
        val cursor = database.rawQuery(query, null )

        if (cursor.moveToFirst()){
            do {

                val user  = User(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4)
                )

                list.add(user)

            }while (cursor.moveToNext())
        }
        return list
    }

    override fun updateUser(user: User): Int {
        val database = this.writableDatabase
        val contentValue = ContentValues()
        contentValue.put(ID, user.id)
        contentValue.put(NAME, user.name)
        contentValue.put(AUTHORS, user.authors)
        contentValue.put(ABOUT, user.about)
        contentValue.put(DATE, user.date)

        return database.update(TABLE_NAME, contentValue, "${ID} = ?", arrayOf(user.id.toString()))
    }

    override fun deleteUser(user: User) {
        val database = this.writableDatabase
        database.delete(TABLE_NAME, "${ID} = ?", arrayOf(user.id.toString()))
        database.close()
    }
}