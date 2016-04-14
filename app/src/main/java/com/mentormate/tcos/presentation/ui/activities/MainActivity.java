package com.mentormate.tcos.presentation.ui.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.mentormate.tcos.R;
import com.mentormate.tcos.domain.executor.impl.ThreadExecutor;
import com.mentormate.tcos.presentation.presenters.MainPresenter;
import com.mentormate.tcos.presentation.presenters.base.BasePresenter;
import com.mentormate.tcos.presentation.presenters.impl.MainPresenterImpl;
import com.mentormate.tcos.threading.impl.MainThreadImpl;

public class MainActivity extends AppCompatActivity implements MainPresenter.View {

    private BasePresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        mPresenter = new MainPresenterImpl(ThreadExecutor.getInstance(), MainThreadImpl.getInstance(), this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.resume();
    }

    @Override
    public void showProgress() {
        Log.d("MainActivity", "Showing progress");
    }

    @Override
    public void hideProgress() {
        Log.d("MainActivity", "Hiding progress");
    }

    @Override
    public void displayError(String errorMessage) {
        Log.d("MainActivity", "Success " + errorMessage);
    }

    @Override
    public void displayMessage(String msg) {
        Log.d("MainActivity", "Success " + msg);
    }
}
