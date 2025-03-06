package com.example.gestioncambiste.data.repository

import com.example.gestioncambiste.data.model.User
import com.example.gestioncambiste.data.dao.UserDao

class UserRepository(private val userDao: UserDao) {

    suspend fun insertUser(user: User) {
        userDao.insertUser(user)
    }

    suspend fun getUser(email: String, password: String): User? {
        return userDao.getUser(email, password)
    }

    suspend fun getUserByEmail(email: String): User? {
        return userDao.getUserByEmail(email)
    }
}