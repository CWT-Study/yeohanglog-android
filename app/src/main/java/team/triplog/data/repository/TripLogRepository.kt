package team.triplog.data.repository

import android.annotation.SuppressLint
import android.app.Application
import androidx.lifecycle.LiveData
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import team.triplog.data.source.local.TripLog
import team.triplog.data.source.local.TripLogDatabase
import team.triplog.data.source.local.dao.TripLogDao

class TripLogRepository(application: Application) {
    private var tripLogDatabase: TripLogDatabase
    private var tripLogDao: TripLogDao
    private var tripLogItems: LiveData<List<TripLog>>

    init {
        tripLogDatabase = TripLogDatabase.getInstance(application)
        tripLogDao = tripLogDatabase.tripDao()
        tripLogItems = tripLogDao.getTripLogList()
    }

    fun getTripLogList(): LiveData<List<TripLog>> {
        return tripLogItems
    }

    @SuppressLint("CheckResult")
    fun insertTripLog(tripLog: TripLog) {
        Observable.just(tripLog)
            .subscribeOn(Schedulers.io())
            .subscribe({
                tripLogDao.insertTripLog(tripLog)
            }, {
                // Handle error.
            })
    }

    @SuppressLint("CheckResult")
    fun updateTripLog(tripLog: TripLog) {
        Observable.just(tripLog)
            .subscribeOn(Schedulers.io())
            .subscribe({
                tripLogDao.updateTripLog(tripLog)
            }, {
                // Handle error.
            })
    }

    @SuppressLint("CheckResult")
    fun deleteTripLog(tripLog: TripLog) {
        Observable.just(tripLog)
            .subscribeOn(Schedulers.io())
            .subscribe({
                tripLogDao.deleteTripLog(tripLog)
            }, {
                // Handle error.
            })
    }
}
