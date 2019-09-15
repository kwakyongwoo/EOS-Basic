package com.example.eosbasicfwproject.main;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.eosbasicfwproject.R;
import com.example.eosbasicfwproject.data.database.MyDatabase;
import com.example.eosbasicfwproject.data.entitiy.TodoItem;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainListAdapter extends RecyclerView.Adapter<MainTodoViewHolder> {

    private ArrayList<TodoItem> itemList = new ArrayList<TodoItem>();

    public void submitList(List<TodoItem> list){
        itemList.clear();
        itemList.addAll(list);
        notifyDataSetChanged();
    }

    public void addItem(TodoItem item) {
        itemList.add(item);
    }
    public void removeItem(int position) { itemList.remove(position); }

    @NonNull
    @Override
    public MainTodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final MainTodoViewHolder viewHolder = new MainTodoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_todo, parent, false));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TodoItem temp = itemList.get(viewHolder.getAdapterPosition());
                temp.setChecked(!temp.getChecked());
                MyDatabase db = MyDatabase.getInstance(v.getContext());
                db.todoDao().updateTodo(temp);
                notifyDataSetChanged();
            }
        });
        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(final View v) {
                final TodoItem temp = itemList.get(viewHolder.getAdapterPosition());
                final String[] list = {"수정", "삭제", "취소"};

                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                new AlertDialog.Builder(v.getContext())
                        .setTitle(temp.getTitle())
                        .setItems(list, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int position) {
                                switch (list[position]) {
                                    case "수정":
                                        //
                                        break;

                                    case "삭제":
                                        MyDatabase db = MyDatabase.getInstance(v.getContext());
                                        db.todoDao().deleteTodo(temp);
                                        removeItem(viewHolder.getAdapterPosition());
                                        notifyDataSetChanged();
                                        break;

                                    case "취소":
                                        break;
                                }
                            }
                        })
                        .show();
                return true;
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
