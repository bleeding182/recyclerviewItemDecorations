package com.github.bleeding182.recyclerviewdecorations;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by David on 16.06.2015.
 */
public class HeaderItemTestAdapter extends RecyclerView.Adapter<HeaderItemTestAdapter.SimpleViewHolder>
        implements ItemTouchHelperCallback.ItemTouchHelperAdapter {
    public static final int HEADER = 1;
    private static final int ITEM = 2;

    @Override
    public void onItemDismiss(int position) {
         
    }

    public static class SimpleViewHolder extends ViewHolder {

        TextView text;

        public SimpleViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView;
        }
    }

    @Override
    public HeaderItemTestAdapter.SimpleViewHolder onCreateViewHolder(ViewGroup viewGroup, int type) {
        final View view;
        if (type == HEADER) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vh_item_header, viewGroup, false);
        } else {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vh_item, viewGroup, false);
        }
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HeaderItemTestAdapter.SimpleViewHolder viewHolder, int i) {
        if (getItemViewType(i) == HEADER) {
            viewHolder.text.setText("Header " + i / 10);
        } else {
            viewHolder.text.setText("Item " + (i - (i / 10)));
        }
    }

    @Override
    public int getItemCount() {
        return 5000;
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 11 == 0) {
            return HEADER;
        } else {
            return ITEM;
        }
    }
}
