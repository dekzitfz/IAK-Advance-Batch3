package advance.iak.advance3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        EditText etAngka1 = findViewById(R.id.angka1);
        EditText etAngka2 = findViewById(R.id.angka2);
        TextView tvResult = findViewById(R.id.tv_result);
        Button btnSum = findViewById(R.id.btn_sum);

        btnSum.setOnClickListener(v -> {
            int angka1 = Integer.parseInt(etAngka1.getText().toString());
            int angka2 = Integer.parseInt(etAngka2.getText().toString());

            int sumResult = angka1 + angka2;
            tvResult.setText(String.valueOf(sumResult));
        });

    }
}
