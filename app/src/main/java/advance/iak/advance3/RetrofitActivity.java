package advance.iak.advance3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import advance.iak.advance3.model.User;
import advance.iak.advance3.rest.GithubAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitActivity extends AppCompatActivity {

    private GithubAPI service;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        service = MyApp.getREST().getService();

        Button btnRetrofit = findViewById(R.id.btn_retrofit);
        btnRetrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                service.getUser("dekzitfz").enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        User anu = response.body();
                        Toast.makeText(RetrofitActivity.this, anu.getName(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(RetrofitActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
