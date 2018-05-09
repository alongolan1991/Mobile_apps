package com.shenkar.birthdate;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shenkar.calculator.R;
import com.shenkar.calculator.birthdayEntity;

import java.util.List;

class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    List<birthdayEntity> birthDay;

    public UserAdapter(List<birthdayEntity> birthDay){
        this.birthDay = birthDay;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.birthdayrow,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(birthDay.get(position).getName());
        holder.datee.setText(birthDay.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return birthDay.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView datee;
        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            datee = itemView.findViewById(R.id.datee);
        }
    }
}
