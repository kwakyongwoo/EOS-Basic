package com.example.eosbasicfwproject.data;

import java.util.ArrayList;

public class TempDummyData {
    public static ArrayList<ItemTodo> dummyList = new ArrayList<ItemTodo>();

    static {
        dummyList.add(new ItemTodo("1", false));
        dummyList.add(new ItemTodo("2", true));
        dummyList.add(new ItemTodo("3", true));
        dummyList.add(new ItemTodo("3", false));
    }
}
