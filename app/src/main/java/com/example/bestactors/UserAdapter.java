package com.example.bestactors;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    Context context;

    private int [] images;
    private String [] titles;
    public UserAdapter(int [] images, String [] titles, Context context){

        this.images=images;
        this.titles=titles;
        this.context=context;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.user_items,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        int img=images[position];
        holder.ivIcon.setImageResource(img);

        String title=titles[position];
        holder.tvTitle.setText(title);


        holder.tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (position==0){
                    Intent intent = new Intent(context, DwayneJohnson.class);
                    context.startActivity(intent);
                }
                else if (position==1){
                    Intent intent = new Intent(context, TomHanks.class);
                    context.startActivity(intent);
                }
                else if (position==2){
                    Intent intent = new Intent(context, AdamSandler.class);
                    context.startActivity(intent);
                }
                else if (position==3){
                    Intent intent = new Intent(context, JeromeAllen.class);
                    context.startActivity(intent);
                }
                else if (position ==4) {
                    Intent intent = new Intent(context,RobertDowney.class);
                    context.startActivity(intent);
                }
                else if (position ==5) {
                    Intent intent = new Intent(context,TomeCruise.class);
                    context.startActivity(intent);
                }
                else if (position ==6) {
                    Intent intent = new Intent(context,BradleyCooper.class);
                    context.startActivity(intent);
                }
                else if (position ==7) {
                    Intent intent = new Intent(context,ChrisHemsworth.class);
                    context.startActivity(intent);
                }
                else if (position ==8) {
                    Intent intent = new Intent(context,LeonardoDiCaprio.class);
                    context.startActivity(intent);
                }
                else if (position ==9) {
                    Intent intent = new Intent(context,VinDiesel.class);
                    context.startActivity(intent);
                }
                else {
                    Toast.makeText(context, "No Match", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView ivIcon;
        TextView tvTitle;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            ivIcon = itemView.findViewById(R.id.ivIcon);
            tvTitle = itemView.findViewById(R.id.tvTitle);

        }
    }
}