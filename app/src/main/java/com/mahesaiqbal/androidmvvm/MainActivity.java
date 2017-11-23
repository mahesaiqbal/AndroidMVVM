package com.mahesaiqbal.androidmvvm;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mahesaiqbal.androidmvvm.databinding.ActivityMainBinding;
import com.mahesaiqbal.androidmvvm.model.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_main);

        User user = new User("Mahesa", "Iqbal");
        binding.setUser(user);

    }
}
