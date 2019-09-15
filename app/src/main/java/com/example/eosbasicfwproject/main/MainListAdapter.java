package com.example.eosbasicfwproject.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.eosbasicfwproject.R;
import com.example.eosbasicfwproject.data.ItemTodo;
import com.example.eosbasicfwproject.data.TempDummyData;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainListAdapter extends RecyclerView.Adapter<MainTodoViewHolder> {

    private ArrayList<ItemTodo> itemList = new ArrayList<ItemTodo>();
    private ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    interface ItemClickListener {
        void onItemClick(View view,int position);
    }

    MainListAdapter(){
        itemList.addAll(TempDummyData.dummyList);
    }

    @NonNull
    @Override
    public MainTodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final MainTodoViewHolder viewHolder = new MainTodoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_todo, parent, false));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(itemClickListener != null) {
                    itemClickListener.onItemClick(v, viewHolder.getAdapterPosition());
                }
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainTodoViewHolder holder, int position) {
        holder.onBind(itemList.get(position));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
