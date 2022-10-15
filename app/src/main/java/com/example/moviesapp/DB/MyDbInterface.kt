package com.example.moviesapp.DB

import com.example.moviesapp.Models.User

interface MyDbInterface {
    fun addUser(user: User)
    fun getUser() : ArrayList<User>
    fun updateUser(user: User) : Int
    fun deleteUser(user: User)
}