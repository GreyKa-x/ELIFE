package com.example.ecnuprevention.main.notification;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ecnuprevention.R;
import com.example.ecnuprevention.webservice.ResponseData.NotificationData;


public class NotificationListAdapter extends RecyclerView.Adapter<NotificationListAdapter.ItemHolder>{

    Fragment fragment;
    NotificationData ItemList;

    public NotificationListAdapter(Fragment fragment) {
        this.ItemList = new NotificationData();
        this.fragment = fragment;
    }

    public void updateData(NotificationData data) {
        this.ItemList.dataItems.clear();
        this.ItemList.dataItems.addAll(data.dataItems);
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.notification_item, parent, false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        NotificationData.Item item = ItemList.dataItems.get(position);
        holder.text.setText(item.text);
        holder.title.setText(item.title);
        Glide.with(fragment).load(item.imageUrl).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return ItemList.dataItems.size();
    }

    static class ItemHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title;
        TextView text;
        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.notification_image);
            title = itemView.findViewById(R.id.notification_title);
            text = itemView.findViewById(R.id.notification_text);
        }
    }
}
