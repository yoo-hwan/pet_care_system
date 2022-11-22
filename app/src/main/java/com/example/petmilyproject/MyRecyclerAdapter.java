package com.example.petmilyproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {
    private ArrayList<Pet> petList;

    @NonNull
    @Override
    public MyRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_pet_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerAdapter.ViewHolder holder, int position) {
        holder.onBind(petList.get(position));

        //아이템 클릭 이벤트
        holder.card_view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int mPosition = holder.getAdapterPosition();

                Context context = view.getContext();

                Intent PetScheduleDetail = new Intent(context, com.example.petmilyproject.PetScheduleDetail.class);

                ((PetSchedule)context).startActivity(PetScheduleDetail);
            }
        });
    }

    public void setFriendList(ArrayList<Pet> list){
        this.petList = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(petList!=null){
            return petList.size();
        }
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView profile;
        TextView name;
        TextView message;
        CardView card_view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            profile = (ImageView) itemView.findViewById(R.id.profile);
            name = (TextView) itemView.findViewById(R.id.name);
            message = (TextView) itemView.findViewById(R.id.message);
            card_view = itemView.findViewById(R.id.layout_container);
        }

        void onBind(Pet item){
            profile.setImageResource(item.getResourceId());
            name.setText(item.getName());
            message.setText(item.getMessage());
        }
    }
}
