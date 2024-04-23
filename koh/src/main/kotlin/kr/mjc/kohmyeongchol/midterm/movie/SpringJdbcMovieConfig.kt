package kr.mjc.kohmyeongchol.midterm.movie

import org.mariadb.jdbc.MariaDbDataSource
import org.springframework.context.annotation.*
import org.springframework.core.env.Environment
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate

@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
open class SpringJdbcMovieConfig(private val env: Environment) {
    @Bean
    open fun dataSource() = MariaDbDataSource(env.getProperty("db.url"))

    @Bean
    open fun nameParameterJdbcTemplate() =
        NamedParameterJdbcTemplate(dataSource())
}

val applicationContext =
    AnnotationConfigApplicationContext (SpringJdbcMovieConfig::class.java)

