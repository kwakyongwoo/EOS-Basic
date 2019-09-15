package com.example.eosbasicfwproject.data.entitiy;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Todo")
public class TodoItem {
    @PrimaryKey(autoGenerate = true) private int id;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "checked")
    private Boolean checked;

    public TodoItem(String title) {
        this.title = title;
        checked = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }
}
