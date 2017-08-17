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

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

    class GridSpanDecoration extends RecyclerView.ItemDecoration {
      private final int padding;

      public GridSpanDecoration(int padding) {
        this.padding = padding;
      }

      @Override
      public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        GridLayoutManager gridLayoutManager = (GridLayoutManager) parent.getLayoutManager();
        int spanCount = gridLayoutManager.getSpanCount();

        GridLayoutManager.LayoutParams params = (GridLayoutManager.LayoutParams) view.getLayoutParams();

        int spanIndex = params.getSpanIndex();
        int spanSize = params.getSpanSize();

        // If it is in column 0 you apply the full offset on the start side, else only half
        if (spanIndex == 0) {
          outRect.left = padding;
        } else {
          outRect.left = padding / 2;
        }

        // If spanIndex + spanSize equals spanCount (it occupies the last column) you apply the full offset on the end, else only half.
        if (spanIndex + spanSize == spanCount) {
          outRect.right = padding;
        } else {
          outRect.right = padding / 2;
        }

        // just add some vertical padding as well
        outRect.top = padding / 2;
        outRect.bottom = padding / 2;

        if(isLayoutRTL(parent)) {
          int tmp = outRect.left;
          outRect.left = outRect.right;
          outRect.right = tmp;
        }
      }

      @SuppressLint({"NewApi", "WrongConstant"})
      private static boolean isLayoutRTL(RecyclerView parent) {
        return parent.getLayoutDirection() == ViewCompat.LAYOUT_DIRECTION_RTL;
      }
    }
