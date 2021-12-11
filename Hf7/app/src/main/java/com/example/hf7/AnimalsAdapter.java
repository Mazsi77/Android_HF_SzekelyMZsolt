package com.example.hf7;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class AnimalsAdapter extends RecyclerView.Adapter<AnimalsAdapter.VH> {

    private Activity mContext;
    private List<Animal> mAnimals;

    public AnimalsAdapter(Activity mContext, List<Animal> mAnimals) {
        this.mContext = mContext;
        this.mAnimals = mAnimals;
    }

    @NonNull
    @Override
    public AnimalsAdapter.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_card, parent, false);
        return new VH(itemView, mContext);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalsAdapter.VH holder, int position) {
        Animal animal = mAnimals.get(position);
        holder.rootVIew.setTag(animal);
        holder.tvName.setText(animal.getName());
        holder.tvDetails.setText(animal.getDetails());
        Glide.with(mContext).load(animal.getImg()).centerCrop().into(holder.ivProfile);
    }

    @Override
    public int getItemCount() {
        return mAnimals.size();
    }

    public class VH  extends RecyclerView.ViewHolder{
        final View rootVIew;
        final ImageView ivProfile;
        final TextView tvName;
        final TextView tvDetails;

        public VH(@NonNull View itemView, final Context context) {
            super(itemView);
            rootVIew = itemView;
            ivProfile = itemView.findViewById(R.id.image);
            tvName = itemView.findViewById(R.id.name);
            tvDetails = itemView.findViewById(R.id.details);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name = tvName.getText().toString();
                    Toast.makeText(context, name, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
