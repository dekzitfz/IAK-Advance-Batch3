package advance.iak.advance3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity
        extends AppCompatActivity
        implements FragmentToHost{

    private static final String TAG = MainActivity.class.getSimpleName();

    private int currentData;
    private HostToFragment hostToFragmentListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().getBackStackEntryCount() > 0){
            getSupportFragmentManager().popBackStack();
        }else{
            super.onBackPressed();
        }
    }

    public void setListener(HostToFragment hostToFragment){
        hostToFragmentListener = hostToFragment;
    }

    @Override
    public void saveData(int plus) {
        currentData = currentData + plus;
        Log.d(TAG, "currentData --> "+currentData);
        hostToFragmentListener.sendData(currentData);
    }
}
