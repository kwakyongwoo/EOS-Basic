package com.example.eosbasicfwproject.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.eosbasicfwproject.R;
import com.example.eosbasicfwproject.data.database.MyDatabase;
import com.example.eosbasicfwproject.data.entitiy.TodoItem;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcv_todo;
    private MainListAdapter adapter;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcv_todo = findViewById(R.id.main_rcv_todo);
        fab = findViewById(R.id.main_fab);

        adapter = new MainListAdapter();
        rcv_todo.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rcv_todo.setAdapter(adapter);

        final MyDatabase myDatabase = MyDatabase.getInstance(this);
        adapter.submitList(myDatabase.todoDao().getAllTodo());

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TodoItem item =new TodoItem("time: " + System.currentTimeMillis());
                myDatabase.todoDao().insertTodo(item);
                adapter.addItem(item);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
