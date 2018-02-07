package com.example.user.qeestudiar.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.user.qeestudiar.OnItemClickListMentor;
import com.example.user.qeestudiar.R;
import com.example.user.qeestudiar.models.Mentor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 28/11/2017.
 */

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ViewHolder> {

    Context mContext;
    List<Mentor> mListMentor;
    OnItemClickListMentor clickListener;
    public ProfileAdapter(){
        mListMentor = new ArrayList<>();
    }

    public void setOnItemClickListener(OnItemClickListMentor clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_perfil,parent,false);
        ViewHolder mViewHolder = new ViewHolder(view);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Mentor mHolderMentor = mListMentor.get(position);
        holder.txtName.setText(mHolderMentor.getName());
        //holder.txtCarrer.setText(mHolderMentor.getCareer());
        Glide.with(mContext)
                .load(mHolderMentor.getPhotoPath())
                .apply(RequestOptions.circleCropTransform())
                .into(holder.imgPerfil);

        holder.txtSpecialization.setText(mHolderMentor.getSpecialization());
        if (this.clickListener != null) {
            holder.setOnItemClickListener(mListMentor.get(position), this.clickListener);
        }
    }

    @Override
    public int getItemCount() {
        return mListMentor.size();
    }

    public void setElement(List<Mentor> mListMentor){
        this.mListMentor = mListMentor;
        notifyDataSetChanged();
    }
    public void clear() {
        mListMentor.clear();
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtName;
        TextView txtCarrer;
        TextView txtSpecialization;
        ImageView imgPerfil;
        TextView txtNivel;

        public ViewHolder(View itemView) {
            super(itemView);
            txtName = (TextView)itemView.findViewById(R.id.txtName);
            txtCarrer = (TextView)itemView.findViewById(R.id.txtCarrer);
            txtNivel = (TextView)itemView.findViewById(R.id.txtNivel);
            imgPerfil = (ImageView)itemView.findViewById(R.id.imgPerdil);
            txtSpecialization = itemView.findViewById(R.id.txtEspecialid);
        }

        public void setOnItemClickListener(final Mentor element,final OnItemClickListMentor listener){

            itemView.setOnClickListener(view -> listener.onItemClick(element));

        }
    }
}
