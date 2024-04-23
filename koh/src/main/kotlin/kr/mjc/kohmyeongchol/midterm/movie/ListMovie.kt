package kr.mjc.kohmyeongchol.midterm.movie

import jdbc.Page
import spring.jpa.applicationContext
import java.util.*

fun main() {
    val movieDao = applicationContext.getBean(MovieDao::class.java)
    print("List - pageNumber pageSize ? ")
    val page = Scanner(System.`in`).use { Page(it.nextInt(), it.nextInt()) }

    val movieList = movieDao.list(page)
    movieList.forEach(::println)
}