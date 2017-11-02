package advance.iak.advance3.services;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

public class ServiceTwo extends IntentService {

    private static final String TAG = ServiceTwo.class.getSimpleName();

    public ServiceTwo() {
        super("ServiceTwo");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.i(TAG, "onHandleIntent");
        for(int i=0 ; i<=10; i++){
            try {
                Thread.sleep(1000);
                Log.i(TAG, String.valueOf(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy");
        super.onDestroy();
    }
}
