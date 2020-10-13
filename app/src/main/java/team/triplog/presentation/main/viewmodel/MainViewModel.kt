package team.triplog.presentation.main.viewmodel

import android.app.Application
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import io.realm.Realm
import team.triplog.R
import team.triplog.data.local.User
import team.triplog.data.repository.UserRepository
import team.triplog.presentation.fragment.MainHomeFragment
import team.triplog.presentation.fragment.MainMoreFragment
import team.triplog.presentation.fragment.MainSearchFragment
import team.triplog.presentation.fragment.MainTripFragment

class MainViewModel(application: Application): AndroidViewModel(application) {
    private val userRepository: UserRepository

    init {
        userRepository = UserRepository(application)
    }

    fun readUser(userId: String): LiveData<User?>{
        return userRepository.readUser(userId)
    }

}