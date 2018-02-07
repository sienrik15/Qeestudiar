package com.example.user.qeestudiar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class LeadsActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leads);

        mRecyclerView = findViewById(R.id.txtListLeads);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager mLinearLeadsManager = new LinearLayoutManager(this);
        mLinearLeadsManager.setOrientation(LinearLayoutManager.VERTICAL);
        mLinearLeadsManager.setReverseLayout(false);
        mRecyclerView.setLayoutManager(mLinearLeadsManager);

    }
}
