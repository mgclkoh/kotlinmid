package kr.mjc.kohmyeongchol.midterm.movie

import kr.mjc.kohmyeongchol.midterm.movie.Movie
import kr.mjc.kohmyeongchol.midterm.movie.Movie.MovieDao
import jdbc.Page
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate

class MovieDaoImp1 {
    private val template: NamedParameterJdbcTemplate) : MovieDao {

    companion object {
            const val LIST_MOVIE =
                "select id, tilte, director from movie oreder by id desc limit :offset, :size"
        }
    private val rowMapper = BeanPropertyRowMapper(Movie::class.java)

    private val jdbcTemplate = template.jdbcTemplate

    override fun list(page: Page): List<Movie> =
        jdbcTemplate.query(LIST_MOVIE, page.toMap, rowMapper)
    }
}