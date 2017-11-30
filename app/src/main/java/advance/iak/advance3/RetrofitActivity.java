package advance.iak.advance3;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.test.espresso.IdlingResource;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
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

    @Nullable
    private GithubIdlingResource idlingResource;

    @VisibleForTesting
    @NonNull
    public IdlingResource getIdlingResource(){
        if(idlingResource == null){
            idlingResource = new GithubIdlingResource();
        }

        return idlingResource;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        TextView githubName = findViewById(R.id.github_name);

        getIdlingResource();
        service = MyApp.getREST().getService();

        Button btnRetrofit = findViewById(R.id.btn_retrofit);
        btnRetrofit.setOnClickListener(v -> {
                if(idlingResource!=null) idlingResource.setIdleState(false);
                service.getUser("dekzitfz")
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            user -> {
                                githubName.setText(user.getName());
                                idlingResource.setIdleState(true);
                                },
                            error -> {
                                Toast.makeText(RetrofitActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                                idlingResource.setIdleState(true);
                            }
                    );
            }
        );
    }
}
