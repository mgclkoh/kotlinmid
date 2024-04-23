package kr.mjc.kohmyeongchol.midterm.movie

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.transaction.annotation.Transactional

interface MovieRepository : JpaRepository<MovieP, Long> {
    @Modifying
    @Transactional
    @Query("update movie set title=:title, director=:director where id=:id", nativeQuery = true)
    fun update(id: Long, title: String, director: String): Int
}