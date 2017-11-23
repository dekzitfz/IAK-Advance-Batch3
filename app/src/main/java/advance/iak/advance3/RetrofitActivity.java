package advance.iak.advance3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import advance.iak.advance3.model.User;
import advance.iak.advance3.rest.GithubAPI;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
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
        btnRetrofit.setOnClickListener(v -> service.getUser("dekzitfz")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        user -> Toast.makeText(RetrofitActivity.this, user.getName(), Toast.LENGTH_SHORT).show(),
                        error -> Toast.makeText(RetrofitActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show()
                ));
    }
}
