package com.example.project.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.R;
import com.example.project.model.Setting;

import java.util.List;

public class SettingAdapter extends RecyclerView.Adapter<SettingAdapter.SettingHolder> {
    List<Setting> settings;
    public SettingAdapter (List<Setting> li) {
        this.settings = li;
    }

    @NonNull
    @Override
    public SettingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_setting, parent, false);
        return new SettingHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SettingHolder holder, int position) {
        holder.img.setBackgroundResource(settings.get(position).getImg());
        holder.tv_title.setText(settings.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return settings.size();
    }

    class SettingHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tv_title;
        public SettingHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imv_img);
            tv_title = itemView.findViewById(R.id.tv_setting);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                }
            });

        }
    }

}
