package team.triplog.data.remote;

import com.google.gson.annotations.SerializedName;

public class UserResponse {
    @SerializedName("id")
    int id;
    @SerializedName("name")
    String name;
}
