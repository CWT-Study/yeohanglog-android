package team.triplog.data.remote;

import retrofit2.Response;
import retrofit2.http.GET;

interface ServerInterface {
    @GET
    Response<UserResponse> getUser();
}
