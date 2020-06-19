package com.example.appnewst3h.adapter;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.appnewst3h.R;
import com.example.appnewst3h.item.Item;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {
    private List<Item>items;

    public NewsAdapter(List<Item> items) {
        this.items = items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).
               inflate(R.layout.item, parent,false);
        return new NewsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final NewsHolder holder, int position) {
        final Item item = items.get(position);
        holder.tvTitle.setText(item.getTitle());
        holder.tvContent.setText(item.getContent());
        Glide.with(holder.itemView.getContext()).load(item.getLinkImage())
    //            .error(R.drawable.cat)
                .into(holder.imgAvatar);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(item.getLinkDetail()));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (items==null){
            return 0;
        }
        return items.size();
    }

    static class NewsHolder extends RecyclerView.ViewHolder{
        ImageView imgAvatar;
        TextView tvTitle;
        TextView tvContent;
        public NewsHolder(@NonNull View itemView) {
            super(itemView);
            imgAvatar = itemView.findViewById(R.id.img_resource);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvContent = itemView.findViewById(R.id.tv_description);
        }
    }
}
