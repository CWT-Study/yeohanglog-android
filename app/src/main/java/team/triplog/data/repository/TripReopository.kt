package team.triplog.data.repository

import android.annotation.SuppressLint
import android.app.Application
import androidx.lifecycle.LiveData
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import team.triplog.data.source.local.Trip
import team.triplog.data.source.local.TripDatabase
import team.triplog.data.source.local.dao.TripDao

class TripReopository(application: Application) {
    private var tripDatabase: TripDatabase
    private var tripDao: TripDao
    private var tripItems: LiveData<Trip>

    init {
        tripDatabase = TripDatabase.getInstance(application)
        tripDao = tripDatabase.tripDao()
        tripItems = tripDao.getTrip("")
    }

    fun getTrip(tripId: String): LiveData<Trip> {
        return tripDao.getTrip(tripId)
    }

    @SuppressLint("CheckResult")
    fun insertTrip(trip: Trip) {
        Observable.just(trip)
            .subscribeOn(Schedulers.io())
            .subscribe({
                tripDao.insertTrip(trip)
            }, {
                // Handle error.
            })
    }

    @SuppressLint("CheckResult")
    fun updateTrip(trip: Trip) {
        Observable.just(trip)
            .subscribeOn(Schedulers.io())
            .subscribe({
                tripDao.updateTrip(trip)
            }, {
                // Handle error.
            })
    }

    @SuppressLint("CheckResult")
    fun deleteTrip(trip: Trip) {
        Observable.just(trip)
            .subscribeOn(Schedulers.io())
            .subscribe({
                tripDao.deleteTrip(trip)
            }, {
                // Handle error.
            })
    }
}