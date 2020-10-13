package team.triplog.presentation.main.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import team.triplog.data.local.Trip
import team.triplog.data.local.TripLog
import team.triplog.data.local.User
import team.triplog.data.repository.TripLogRepository
import team.triplog.data.repository.TripReopository
import team.triplog.data.repository.UserRepository

class MainHomeViewModel(application: Application): AndroidViewModel(application) {
    private val tripLogRepository: TripLogRepository
    private var tripLogItems: LiveData<List<TripLog>>

    private val tripRepository: TripReopository

    private val userRepository: UserRepository

    init {
        tripLogRepository = TripLogRepository(application)
        tripLogItems = tripLogRepository.getTripLogList()

        tripRepository = TripReopository(application)

        userRepository = UserRepository(application)
    }

    fun insertTripLog(todoModel: TripLog) {
        tripLogRepository.insertTripLog(todoModel)
    }

    fun updateTripLog(todoModel: TripLog) {
        tripLogRepository.updateTripLog(todoModel)
    }

    fun deleteTripLog(todoModel: TripLog) {
        tripLogRepository.deleteTripLog(todoModel)
    }

    fun getTripLogList(): LiveData<List<TripLog>> {
        return tripLogItems
    }

    fun getTrip(tripId: String): LiveData<Trip> {
        return tripRepository.getTrip(tripId)
    }

    fun readUser(userId: String): LiveData<User?>{
        return userRepository.readUser(userId)
    }



}
