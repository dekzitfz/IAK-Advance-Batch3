package advance.iak.advance3.rest;

import advance.iak.advance3.model.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubAPI {

    @GET("users/{username}")
    Call<User> getUser(@Path("username") String username);
}
