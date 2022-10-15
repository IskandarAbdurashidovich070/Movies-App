package com.example.moviesapp.Models

class User {
    var id = 0
    var name = ""
    var authors = ""
    var about = ""
    var date = ""

    constructor()
    constructor(name: String, authors: String, about: String, date: String) {
        this.name = name
        this.authors = authors
        this.about = about
        this.date = date
    }

    constructor(id: Int, name: String, authors: String, about: String, date: String) {
        this.id = id
        this.name = name
        this.authors = authors
        this.about = about
        this.date = date
    }

}