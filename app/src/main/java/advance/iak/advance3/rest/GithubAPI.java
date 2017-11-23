package advance.iak.advance3.rest;

import advance.iak.advance3.model.User;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubAPI {

    @GET("users/{username}")
    Single<User> getUser(@Path("username") String username);
}
