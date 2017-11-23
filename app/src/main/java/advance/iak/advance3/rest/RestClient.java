package advance.iak.advance3.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {
    private GithubAPI api;
    private static final String BASE_URL = "https://api.github.com/";

    public RestClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(GithubAPI.class);
    }

    public GithubAPI getService() {
        return api;
    }
}
