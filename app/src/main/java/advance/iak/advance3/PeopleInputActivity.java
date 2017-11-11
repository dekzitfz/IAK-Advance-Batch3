package advance.iak.advance3;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import advance.iak.advance3.data.PeopleContract;

public class PeopleInputActivity extends AppCompatActivity {

    private EditText etName, etAddress;
    private Button btnSave, btnLog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_people);

        etName = findViewById(R.id.et_name);
        etAddress = findViewById(R.id.et_address);
        btnSave = findViewById(R.id.btn_save);
        btnLog = findViewById(R.id.btn_log);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                String address = etAddress.getText().toString();

                ContentValues cv = new ContentValues();
                cv.put(PeopleContract.PeopleEntry.PEOPLE_NAME, name);
                cv.put(PeopleContract.PeopleEntry.PEOPLE_ADDRESS, address);

                getContentResolver().insert(PeopleContract.PeopleEntry.CONTENT_URI, cv);
            }
        });

        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor peoples = getContentResolver()
                        .query(
                                PeopleContract.PeopleEntry.CONTENT_URI,
                                null, null, null, null
                        );

                if(peoples!=null){
                    Log.i("LOG", "cursor count ---> "+peoples.getCount());
                    try{
                        while (peoples.moveToNext()) {
                            Log.i("LOG","people ---> "+peoples.getString(peoples.getColumnIndex(PeopleContract.PeopleEntry.PEOPLE_NAME)));
                        }
                    }finally {
                        peoples.close();
                    }
                }else{
                    Log.w("LOG", "cursor is null!");
                }

            }
        });
    }
}
