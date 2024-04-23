package kr.mjc.kohmyeongchol.midterm.movie

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class MovieP {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)var id: Long = 0

    lateinit var title: String
    lateinit var director: String

    override fun toString(): String =
        "Movie(id=$id, title= '$title',director= '$director')"

    }
