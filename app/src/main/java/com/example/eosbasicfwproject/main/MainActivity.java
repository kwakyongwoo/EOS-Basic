package com.example.eosbasicfwproject.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.eosbasicfwproject.R;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcv_todo;
    private MainListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcv_todo = (RecyclerView) findViewById(R.id.main_rcv_todo);

        adapter = new MainListAdapter();
        rcv_todo.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rcv_todo.setAdapter(adapter);

        adapter.setItemClickListener(new MainListAdapter.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, position + "clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
