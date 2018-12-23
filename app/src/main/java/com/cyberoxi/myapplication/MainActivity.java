package com.cyberoxi.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cyberoxi.selectablelist.SelectableList;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SelectableList selectableList = findViewById(R.id.selecttable);

        List<com.cyberoxi.selectablelist.model.items> list = new ArrayList<>();
        com.cyberoxi.selectablelist.model.items i = new com.cyberoxi.selectablelist.model.items();
        com.cyberoxi.selectablelist.model.items i2 = new com.cyberoxi.selectablelist.model.items();
        i.setIcon(R.drawable.ic_agent);
        i.setName("Agent");
        i2.setIcon(R.drawable.ic_agent);
        i2.setName("Agent");
        List<com.cyberoxi.selectablelist.model.subItems> sList = new ArrayList<>();
        com.cyberoxi.selectablelist.model.subItems s = new com.cyberoxi.selectablelist.model.subItems();
        s.setSelected(false);
        s.setTitle("Sub1");
        com.cyberoxi.selectablelist.model.subItems s2 = new com.cyberoxi.selectablelist.model.subItems();
        s2.setSelected(false);
        s2.setTitle("Sub2");
        sList.add(s);
        sList.add(s2);
        i.setListSubItem(sList);
        i2.setListSubItem(sList);
        list.add(i);
        list.add(i2);

        selectableList.setData( list);

/*        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new Adapter(this,list));*/

    }
}
