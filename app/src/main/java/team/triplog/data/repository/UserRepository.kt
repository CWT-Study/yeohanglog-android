package team.triplog.data.repository

import android.annotation.SuppressLint
import android.app.Application
import androidx.lifecycle.LiveData
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import team.triplog.data.local.TripLog
import team.triplog.data.local.User
import team.triplog.data.local.UserDatabase
import team.triplog.data.local.dao.UserDao

class UserRepository(application: Application) {
    private var userDatabase: UserDatabase
    private var userDao: UserDao
    private var user: LiveData<User?>

    init {
        userDatabase = UserDatabase.getInstance(application)
        userDao = userDatabase.userDao()
        user = userDao.read("")
    }


    fun readUser(userId: String): LiveData<User?> {
        return userDao.read(userId)
    }

    @SuppressLint("CheckResult")
    fun createUser(user: User) {
        Observable.just(user)
            .subscribeOn(Schedulers.io())
            .subscribe({
                userDao.create(user)
            }, {
                // Handle error.
            })
    }

}