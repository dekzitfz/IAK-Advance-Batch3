package advance.iak.advance3.services;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import advance.iak.advance3.R;
import advance.iak.advance3.broadcast.MyBroadcastReceiver;

public class ServiceSampleActivity extends AppCompatActivity {

    private static final String TAG  = ServiceSampleActivity.class.getSimpleName();

    BroadcastReceiver br = new MyBroadcastReceiver();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_sample);

        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        this.registerReceiver(br, filter);

        Button btnStartService = findViewById(R.id.btn_start_service);
        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(new Intent(ServiceSampleActivity.this, ServiceTwo.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onStop() {
        Log.i(TAG, "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(br);
        super.onDestroy();
    }
}
