package advance.iak.advance3;

import android.app.Application;

import advance.iak.advance3.rest.RestClient;

public class MyApp extends Application {

    private static RestClient rest;

    @Override
    public void onCreate() {
        super.onCreate();
        rest = new RestClient();
    }

    public static RestClient getREST() {
        return rest;
    }
}
