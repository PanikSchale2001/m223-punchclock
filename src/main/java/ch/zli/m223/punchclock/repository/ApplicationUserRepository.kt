package ch.zli.m223.punchclock.repository

import ch.zli.m223.punchclock.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface ApplicationUserRepository : JpaRepository<User, Long> {
    fun findByUsername(username: String): User?;
}