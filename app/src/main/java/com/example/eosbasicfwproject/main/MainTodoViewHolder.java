package com.example.eosbasicfwproject.main;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.eosbasicfwproject.R;
import com.example.eosbasicfwproject.data.ItemTodo;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainTodoViewHolder extends RecyclerView.ViewHolder {

    private CheckBox checkBox;
    private TextView tvTitle;

    public MainTodoViewHolder(@NonNull View itemView) {
        super(itemView);

        checkBox = itemView.findViewById(R.id.todo_cb);
        tvTitle = itemView.findViewById(R.id.todo_tv_title);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick();
            }
        });
    }

    public void onBind(ItemTodo item) {
        checkBox.setChecked(item.getChecked());
        tvTitle.setText(item.getTitle());
    }

    public void onItemClick() {

    }
}
