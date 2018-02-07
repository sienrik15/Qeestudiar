package com.example.user.qeestudiar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.user.qeestudiar.adapters.ProfileAdapter;
import com.example.user.qeestudiar.models.Mentor;
import com.example.user.qeestudiar.services.QueryCallBack;
import com.example.user.qeestudiar.services.ServicesGraphql;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemClickListMentor {


 /*   private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    }; */

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private ServicesGraphql mQServicesGraphql;
    private ProfileAdapter mProfileAdapter;
    AVLoadingIndicatorView nAvi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView = findViewById(R.id.eventsTodayRecyclerView);
        nAvi = findViewById(R.id.avi);
        nAvi.show();
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mProfileAdapter = new ProfileAdapter();
        mRecyclerView.setAdapter(mProfileAdapter);
        mProfileAdapter.setOnItemClickListener(this);

        mQServicesGraphql = new ServicesGraphql();
        mQServicesGraphql.QueryMentors(new QueryCallBack() {
            @Override
            public void onSuccess(List<Mentor> mMentors) {
                mProfileAdapter.setElement(mMentors);
                nAvi.hide();
            }

            @Override
            public void onError(String mError) {
                Toast.makeText(getApplicationContext(),mError,Toast.LENGTH_SHORT).show();
                nAvi.hide();
                nAvi.setVisibility(View.INVISIBLE);
            }
        });

       /* BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);*/
    }

    @Override
    public void onItemClick(Mentor element) {
        Intent mIntent = new Intent(this,DetailPerfilActivity.class);
        startActivity(mIntent);
    }
}
