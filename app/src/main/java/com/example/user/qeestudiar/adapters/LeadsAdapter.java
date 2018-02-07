package com.example.user.qeestudiar.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.qeestudiar.models.LeadsPerfil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by macintoshhd on 5/2/18.
 */

public class LeadsAdapter extends RecyclerView.Adapter<LeadsAdapter.ViewHolder> {

    List<LeadsPerfil> mLeadsPerfils;

    public LeadsAdapter(){
        mLeadsPerfils = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mLeadsPerfils.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
