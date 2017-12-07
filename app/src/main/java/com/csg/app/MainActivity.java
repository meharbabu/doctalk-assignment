package com.csg.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.csg.app.models.Mediator;
import com.csg.app.network.NetworkUtils;

public class MainActivity extends Activity {

    public RecyclerView recyclerView;
    public ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Setting activity context
        Mediator.getInstance().setMainActivityContext(this);
        //getting the progressbar
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        // getting recycler view
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        // Connecting to the server
        final EditText searchName = (EditText)findViewById(R.id.search_name);
        searchName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                progressBar.setVisibility(View.VISIBLE);
                if(!searchName.getText().toString().isEmpty()) {
                    // Connecting to Server
                    NetworkUtils.connectServerAndGetData(searchName.getText().toString());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
