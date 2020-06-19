package team.triplog.data.remote;

import retrofit2.Response;

public class ServerManager {
    private static ServerInterface SERVER = ServerDefine.retrofit.create(ServerInterface.class);

    Response<UserResponse> getUser() {
        return SERVER.getUser();
    }
}
