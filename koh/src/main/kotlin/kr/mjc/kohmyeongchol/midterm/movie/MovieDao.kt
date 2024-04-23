package kr.mjc.kohmyeongchol.midterm.movie

import jdbc.Page

interface MovieDao {
    fun list(page: Page): List<Movie>
}