package advance.iak.advance3.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import advance.iak.advance3.R;

public class ServiceSampleActivity extends AppCompatActivity {

    private static final String TAG  = ServiceSampleActivity.class.getSimpleName();

    private ServiceConnection serviceConnection;
    private boolean serviceBounded = false;
    ServiceOne serviceOne;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_sample);

        serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Log.i(TAG, "onServiceConnected");
                // bounded to ServiceOne, cast the IBinder and get ServiceOne instance
                ServiceOne.ServiceOneBinder binder = (ServiceOne.ServiceOneBinder) iBinder;
                serviceOne = binder.getService();
                serviceBounded = true;
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {
                Log.i(TAG, "onServiceDisconnected");
                serviceBounded = false;
            }
        };

        Button btnStartService = findViewById(R.id.btn_start_service);
        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(serviceBounded){
                    serviceOne.startSomething();
                }else{
                    Toast.makeText(ServiceSampleActivity.this, "not bounded", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        bindService(
                new Intent(ServiceSampleActivity.this, ServiceOne.class),
                serviceConnection,
                Context.BIND_AUTO_CREATE
        );
    }

    @Override
    protected void onStop() {
        Log.i(TAG, "onStop");
        super.onStop();
        unbindService(serviceConnection);
        serviceBounded = false;
    }
}
