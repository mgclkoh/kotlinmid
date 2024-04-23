package kr.mjc.kohmyeongchol.midterm.movie

class Movie
    (var id: Int = 0, var title: String = "",
    var director: String = "")
    {
        override fun toString(): String {
            return "Movie(id=$id, title='$title', director='$director')"
        }
    }
