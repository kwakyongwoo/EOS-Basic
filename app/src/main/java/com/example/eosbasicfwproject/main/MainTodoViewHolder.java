package com.example.eosbasicfwproject.main;

import android.text.SpannableString;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.eosbasicfwproject.R;
import com.example.eosbasicfwproject.data.entitiy.TodoItem;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainTodoViewHolder extends RecyclerView.ViewHolder {

    private CheckBox checkBox;
    private TextView tvTitle;

    public MainTodoViewHolder(@NonNull View itemView) {
        super(itemView);

        checkBox = itemView.findViewById(R.id.todo_cb);
        tvTitle = itemView.findViewById(R.id.todo_tv_title);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
    }

    public void onBind(TodoItem item) {
        checkBox.setChecked(item.getChecked());
        tvTitle.setText(item.getTitle());
        if(item.getChecked() == true) {
            SpannableString contentSp = new SpannableString(item.getTitle());
            contentSp.setSpan(new StrikethroughSpan(), 0, item.getTitle().length(), 0);
            tvTitle.setText(contentSp);
        }
    }
}
