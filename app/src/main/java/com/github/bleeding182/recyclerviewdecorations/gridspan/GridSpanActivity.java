/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 David Medenjak
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.bleeding182.recyclerviewdecorations.gridspan;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.view.ViewGroup;

import com.github.bleeding182.recyclerviewdecorations.R;
import com.github.bleeding182.recyclerviewdecorations.base.RecyclerViewActivity;
import com.github.bleeding182.recyclerviewdecorations.base.SimpleViewAdapter;

public class GridSpanActivity extends RecyclerViewActivity {

  @Override
  public void onCreateRecyclerView(Bundle savedInstanceState) {
    Context context = this;

    SimpleViewAdapter adapter = new SimpleViewAdapter(5000, R.layout.item_grid_span);
    recyclerView.setAdapter(adapter);

    GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 4);
    GridLayoutManager.SpanSizeLookup spanSizeLookup = new GridSpanSizeLookUp();

    recyclerView.setLayoutManager(gridLayoutManager);
    gridLayoutManager.setSpanSizeLookup(spanSizeLookup);

    int dp16 = (int) (getResources().getDisplayMetrics().density * 16);

    recyclerView.addItemDecoration(new GridSpanDecoration(dp16));
  }

}
