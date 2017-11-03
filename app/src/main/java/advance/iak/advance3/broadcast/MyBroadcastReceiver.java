package advance.iak.advance3.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = MyBroadcastReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "onReceive");
    }
}
