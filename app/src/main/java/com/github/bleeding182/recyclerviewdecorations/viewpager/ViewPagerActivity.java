package com.github.bleeding182.recyclerviewdecorations.viewpager;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.view.ViewGroup;

import com.github.bleeding182.recyclerviewdecorations.R;
import com.github.bleeding182.recyclerviewdecorations.base.RecyclerViewActivity;
import com.github.bleeding182.recyclerviewdecorations.base.SimpleViewAdapter;


public class ViewPagerActivity extends RecyclerViewActivity {

  @Override
  public void onCreateRecyclerView(Bundle savedInstanceState) {
    int backgroundColor = 0xFF665F30;
    Context context = this;
    recyclerView.getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT;
    recyclerView.setBackgroundColor(backgroundColor);

    SimpleViewAdapter adapter = new SimpleViewAdapter(5, R.layout.item_view_pager_page);

    recyclerView.setAdapter(adapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));

    // add pager behavior
    PagerSnapHelper snapHelper = new PagerSnapHelper();
    snapHelper.attachToRecyclerView(recyclerView);

    // pager indicator
    recyclerView.addItemDecoration(new LinePagerIndicatorDecoration());

  }

}
