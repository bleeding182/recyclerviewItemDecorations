package com.github.bleeding182.recyclerviewdecorations.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SimpleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

  private final int itemCount;
  private final int layout;

  public SimpleViewAdapter(int itemCount, int layout) {
    this.itemCount = itemCount;
    this.layout = layout;
  }

  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    final Context context = parent.getContext();
    final View view = LayoutInflater.from(context).inflate(layout, parent, false);
    return new RecyclerView.ViewHolder(view) {
    };
  }

  @Override
  public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

  }

  @Override
  public int getItemCount() {
    return itemCount;
  }
}
