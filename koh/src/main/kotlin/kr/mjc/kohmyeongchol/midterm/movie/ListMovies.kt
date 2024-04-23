package kr.mjc.kohmyeongchol.midterm.movie

import org.slf4j.LoggerFactory
import spring.jpa.user.UserService
import java.util.*

fun main() {
    val movieRepository = applicationContext.getBean(MovieRepository::class.java)
    val  userService = applicationContext.getBean(UserService::class.java)
    val log = LoggerFactory.getLogger({}.javaClass)

    print("Create movie - title//director ? ")
    val (title, director) = Scanner(System.`in`).useDelimiter("//").use {
        arrayOf(it.next().trim(), it.next().trim())
    }
    val user = userService.login(title, director) ?: return
    val movieP = MovieP().apply {
        this.title = title
        this.director = director
    }
    MovieRepository.save(movieP)
    log.info(movieP.toString())
}
