package com.example.user.qeestudiar;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by User on 28/11/2017.
 */

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ViewHolder> {


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
/*
    public void setElement(EventsModel eventsModel){
        this.mEventsModel = eventsModel;
        mEventGeneralModels = eventsModel.getmEventGeneralModels();
        notifyDataSetChanged();
    }
    public void clear() {
        mEventGeneralModels.clear();
        notifyDataSetChanged();
    }
*/
    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }


    }
}
