package team.triplog.domain.usecase.trip

import kotlinx.coroutines.CoroutineDispatcher
import team.triplog.domain.model.Trip
import team.triplog.domain.repository.TripRepository
import team.triplog.domain.usecase.base.BaseUseCase
import java.util.*


/**
 * @author mjkim
 * @since 2021/06/06
 **/
class TripCreateUseCase(
    private val tripRepository: TripRepository,
    dispatcher: CoroutineDispatcher
) : BaseUseCase<TripCreateParameters, Unit>(dispatcher) {

    override suspend fun execute(parameters: TripCreateParameters) {
        val trip = Trip(
            name = parameters.name,
            startDate = parameters.startDate,
            endDate = parameters.endDate,
            image = parameters.image
        )

        return tripRepository.createTrip(trip = trip)
    }
}

data class TripCreateParameters(
    val name: String,
    val startDate: Date,
    val endDate: Date,
    val image: String
)