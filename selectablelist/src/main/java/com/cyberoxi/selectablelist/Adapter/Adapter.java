package com.cyberoxi.selectablelist.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.cyberoxi.selectablelist.R;
import com.cyberoxi.selectablelist.model.items;
import com.github.zagum.expandicon.ExpandIconView;
import com.hanks.library.AnimateCheckBox;

import net.cachapa.expandablelayout.ExpandableLayout;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.vieHolder> {

    LayoutInflater layoutInflater;
    Context context;
    static List<items> data;
    Boolean isExpanded = false;
    int Color;
    int UnSelectColor;

    public Adapter(Context context, List<items> data, int Color, int UnSelectColor) {
        this.context = context;
        this.data = data;
        this.Color = Color;
        this.UnSelectColor = UnSelectColor;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public vieHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new vieHolder(layoutInflater.inflate(R.layout.item_main, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final vieHolder vieHolder, int i) {
        vieHolder.tvName.setText(data.get(i).getName());
        vieHolder.imageViewIcon.setImageResource(data.get(i).getIcon());
        vieHolder.expandIconView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isExpanded) {
                    vieHolder.expandable_layout.collapse();
                } else {
                    vieHolder.expandable_layout.expand();

                }
                vieHolder.expandIconView.switchState();

                isExpanded = !isExpanded;
            }
        });
        vieHolder.recyclerViewSub.setLayoutManager(new LinearLayoutManager(context));
        vieHolder.recyclerViewSub.setAdapter(new SubAdapter(context, this.data.get(i).getListSubItem(),
                Color, UnSelectColor));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class vieHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        RecyclerView recyclerViewSub;
        AnimateCheckBox AnimChekedBox;
        ExpandIconView expandIconView;
        ImageView imageViewIcon;
        ExpandableLayout expandable_layout;

        public vieHolder(@NonNull View itemView) {
            super(itemView);

            this.tvName = itemView.findViewById(R.id.tvName);
            this.recyclerViewSub = itemView.findViewById(R.id.recyclerViewSub);
            this.AnimChekedBox = itemView.findViewById(R.id.cbSelectAll);
            this.expandIconView = itemView.findViewById(R.id.expandedIcon);
            this.imageViewIcon = itemView.findViewById(R.id.imageViewIcon);
            this.expandable_layout = itemView.findViewById(R.id.expandable_layout);
            this.AnimChekedBox.setCircleColor(Color);
            this.AnimChekedBox.setUnCheckColor(UnSelectColor);

        }
    }
}
