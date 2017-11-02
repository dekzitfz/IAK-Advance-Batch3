package advance.iak.advance3.services;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class ServiceOne extends Service {

    private static final String TAG = ServiceOne.class.getSimpleName();
    private final IBinder mBinder = new ServiceOneBinder();

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand called");
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind");
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        //cancel your request / task
        Log.i(TAG, "onUnbind");
        return super.onUnbind(intent);
    }

    public void startSomething(){
        //do something
        Log.i(TAG, "startSomething");
    }

    public class ServiceOneBinder extends Binder {
        ServiceOne getService() {
            // Return this instance of LocalService so clients can call public methods
            return ServiceOne.this;
        }
    }
}
