package com.example.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.retrofit.pojo.Register;

import java.io.IOException;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_Net = findViewById(R.id.btn_Net);
        btn_Net.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("register", "onResponse: one");
                StoreClient client = ServiceGenerator.createService(StoreClient.class);
                Log.d("register", "onResponse: one");
                //Get Register element
                Call<Register> registerCall = client.regCall("Ostov456@Gmail.Com", "123456789", "Mahmoud45", "Alipour45", "09901228192");
                Log.d("register", "onResponse: two");
                registerCall.enqueue(new Callback<Register>() {
                    @Override
                    public void onResponse(Call<Register> call, Response<Register> response) {
                        Toast.makeText(MainActivity.this, "Ok", Toast.LENGTH_SHORT).show();
                        Log.d("register", "onResponse: Ok");
                    }

                    @Override
                    public void onFailure(Call<Register> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Fail", Toast.LENGTH_SHORT).show();
                        Log.d("register", "onResponse: Fail");
                    }
                });
            }
        });


    }
}
