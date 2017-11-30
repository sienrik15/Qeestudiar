package com.example.user.qeestudiar;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.qeestudiar.models.Mentor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 28/11/2017.
 */

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ViewHolder> {

    Context mContext;
    List<Mentor> mListMentor;
    public ProfileAdapter(){
        mListMentor = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_perfil,parent,false);
        ViewHolder mViewHolder = new ViewHolder(view);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Mentor mHolderMentor = mListMentor.get(position);
        holder.txtName.setText(mHolderMentor.getName());
        holder.txtCarrer.setText(mHolderMentor.getCareer());
        holder.txtSpecialization.setText(mHolderMentor.getSpecialization());
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


    }
}
