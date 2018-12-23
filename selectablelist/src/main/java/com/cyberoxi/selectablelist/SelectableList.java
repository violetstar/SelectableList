package com.cyberoxi.selectablelist;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.cyberoxi.selectablelist.Adapter.Adapter;
import com.cyberoxi.selectablelist.model.items;

import java.util.List;

public class SelectableList extends LinearLayout {
    Context context;
    List<items> data;
    View view;
    LayoutInflater layoutInflater;
    RecyclerView recyclerView;
    int AccentColor = Color.RED;
    int UnSelectColor = Color.RED;

    public SelectableList(Context context) {
        super(context);
        this.context = context;


        layoutInflater = LayoutInflater.from(context);
        conster(context);


    }

    public SelectableList(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.SelectableList);
        AccentColor = attributes.getColor(R.styleable.SelectableList_colorAccent, Color.BLACK);
        UnSelectColor = attributes.getColor(R.styleable.SelectableList_colorUnSelect, Color.BLACK);
        conster(context);

    }

    public SelectableList(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.SelectableList, defStyleAttr, 0);
        AccentColor = attributes.getColor(R.styleable.SelectableList_colorAccent, Color.BLACK);
        UnSelectColor = attributes.getColor(R.styleable.SelectableList_colorUnSelect, Color.BLACK);
        conster(context);

    }


    public void setData(List<items> data) {
        this.data = data;
        init();
    }


    void conster(Context context) {
        view = LayoutInflater.from(context).inflate(R.layout.main_layout, this);
        recyclerView = view.findViewById(R.id.recyclerView);
        this.context = context;
    }

    void init() {


        recyclerView.setLayoutManager(new LinearLayoutManager(this.context));
        recyclerView.setAdapter(new Adapter(this.context, data, this.AccentColor,this.UnSelectColor));
    }

}
