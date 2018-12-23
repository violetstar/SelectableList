package com.cyberoxi.selectablelist.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cyberoxi.selectablelist.R;
import com.cyberoxi.selectablelist.model.subItems;
import com.hanks.library.AnimateCheckBox;

import java.util.List;

public class SubAdapter extends RecyclerView.Adapter<SubAdapter.viewHolder> {


    LayoutInflater layoutInflater;
    Context context;
    List<subItems> data;
    int Color;
    int UnSelectColor;

    public SubAdapter(Context context, List<subItems> data, int Color, int UnSelectColor) {
        this.context = context;
        this.data = data;
        layoutInflater = LayoutInflater.from(context);
        this.Color = Color;
        this.UnSelectColor = UnSelectColor;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new viewHolder(layoutInflater.inflate(R.layout.item_sub, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder viewHolder, int i) {
        viewHolder.textViewTitle.setText(data.get(i).getTitle());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle;
        AnimateCheckBox animateCheckBox;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            animateCheckBox = itemView.findViewById(R.id.animateCheckBox);
            this.animateCheckBox.setCircleColor(Color);
            this.animateCheckBox.setUnCheckColor(UnSelectColor);
        }
    }
}
