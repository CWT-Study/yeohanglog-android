package team.triplog.presentation.main.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import team.triplog.data.local.User
import team.triplog.data.repository.TripReopository
import team.triplog.data.repository.UserRepository

class MainMoreViewModel (application: Application): AndroidViewModel(application) {
    private val userRepository: UserRepository

    init {
        userRepository = UserRepository(application)
    }

    fun readUser(userId: String): LiveData<User?>{
        return userRepository.readUser(userId)
    }
}