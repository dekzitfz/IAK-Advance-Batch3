package advance.iak.advance3;

import android.content.ContentValues;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import advance.iak.advance3.data.PeopleContract;

public class PeopleInputActivity extends AppCompatActivity {

    private EditText etName, etAddress;
    private Button btnSave;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_people);

        etName = findViewById(R.id.et_name);
        etAddress = findViewById(R.id.et_address);
        btnSave = findViewById(R.id.btn_save);

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
    }
}
