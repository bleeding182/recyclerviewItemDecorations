package com.github.bleeding182.recyclerviewdecorations;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

/**
 * Created by David on 16.06.2015.
 */
public class CardViewDecoration extends RecyclerView.ItemDecoration {

    final static float SHADOW_MULTIPLIER = 1.5f;
    /*
32 	 * This helper is set by CardView implementations. <p> Prior to API 17, canvas.drawRoundRect is expensive; which is
33 	 * why we need this interface to draw efficient rounded rectangles before 17.
34 	 */
//    static RoundRectHelper sRoundRectHelper;

    Paint mPaint;

    Paint mCornerShadowPaint;

    Paint mEdgeShadowPaint;

    final RectF mPreShadowBounds;

    float mCornerRadius;

    Path mCornerShadowPath;

    float mShadowSize;

    private boolean mDirty = true;

    private final int mShadowStartColor;

    private final int mShadowEndColor;


    public CardViewDecoration(Resources resources, int backgroundColor, float radius) {
        mShadowStartColor = resources.getColor(R.color.cardview_shadow_start_color);
        mShadowEndColor = resources.getColor(R.color.cardview_shadow_end_color);
        mShadowSize = resources.getDimension(R.dimen.cardview_shadow_size) * SHADOW_MULTIPLIER;

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        mPaint.setColor(backgroundColor);
        mCornerShadowPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        mCornerShadowPaint.setStyle(Paint.Style.FILL);
        mCornerShadowPaint.setDither(true);
        mCornerRadius = radius;
        mPreShadowBounds = new RectF();
        mEdgeShadowPaint = new Paint(mCornerShadowPaint);

        buildShadowCorners();
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);

        Resources resources = parent.getContext().getResources();
        float size16dp = 16f;
        int padding16dp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, size16dp, resources.getDisplayMetrics());

        buildShadowCorners();

        Log.d("CV", String.format("mCornerRadius: %f\nmShadowSize: %f", mCornerRadius, mShadowSize));

        for (int i = 0; i < parent.getChildCount(); i++) {
            int save = c.save();
            View child = parent.getChildAt(i);

            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            int position = params.getViewAdapterPosition();
            int viewType = parent.getAdapter().getItemViewType(position);

//            float cornerPathSize = 2 * (mCornerRadius + mShadowSize);
            float edgeShadowTop = -mCornerRadius - mShadowSize;
            final Rect bounds = new Rect(child.getLeft(), child.getTop(), child.getRight(), child.getBottom());

            if (viewType == HeaderItemTestAdapter.HEADER) {
                // LT
//                Log.d("CV", String.format("translate to: %f, %f", child.getLeft() + mCornerRadius, child.getTop() + mCornerRadius));
//                Log.d("CV", "view: " + bounds.flattenToString());
//                Log.d("CV", "draw to: " + bounds.right + " - (" + cornerPathSize + "), -" + mCornerRadius);

                c.translate(child.getLeft() + mCornerRadius, child.getTop() + mCornerRadius);
                c.drawPath(mCornerShadowPath, mCornerShadowPaint);
                c.drawRect(0, edgeShadowTop, bounds.right - 4 * mCornerRadius, -mCornerRadius, mEdgeShadowPaint);

                // RT
                c.rotate(90f);
                c.translate(0, -bounds.width() + 2 * mCornerRadius);
                c.drawPath(mCornerShadowPath, mCornerShadowPaint);
                c.drawRect(0, edgeShadowTop, bounds.height() - mCornerRadius, -mCornerRadius, mEdgeShadowPaint);

                // LBorder
                c.rotate(180f);
                c.translate(-bounds.height(), -bounds.width() + 2 * mCornerRadius);
                c.drawRect(mCornerRadius, edgeShadowTop, bounds.height(), -mCornerRadius, mEdgeShadowPaint);


            } else {
                if (parent.getAdapter().getItemViewType(position + 1) == HeaderItemTestAdapter.HEADER) {
                    Log.d("CV", "Last!");
                    // last item before next header
                    c.rotate(180f);
                    c.translate(-child.getLeft() - bounds.width() + mCornerRadius, -child.getTop() - bounds.height() + mCornerRadius);

                    c.drawPath(mCornerShadowPath, mCornerShadowPaint);
                    c.drawRect(0, edgeShadowTop, bounds.right - 4 * mCornerRadius, -mCornerRadius, mEdgeShadowPaint);

                    // RB
                    c.rotate(90f);
                    c.translate(0, -bounds.width() + 2 * mCornerRadius);
                    c.drawPath(mCornerShadowPath, mCornerShadowPaint);
                    c.drawRect(0, edgeShadowTop, bounds.height() - mCornerRadius, -mCornerRadius, mEdgeShadowPaint);

                    //
                    c.rotate(180f);
                    c.translate(-bounds.height(), -bounds.width() + 2 * mCornerRadius);
                    c.drawRect(mCornerRadius, edgeShadowTop, bounds.height(), -mCornerRadius, mEdgeShadowPaint);
                } else {
                    c.translate(child.getLeft(), child.getTop());
                    c.rotate(90f);
                    c.translate(0, -bounds.width() + mCornerRadius);
                    c.drawRect(0, edgeShadowTop, bounds.height(), -mCornerRadius, mEdgeShadowPaint);

                    c.rotate(180f);
                    c.translate(- bounds.height(), - bounds.width() + 2 * mCornerRadius );
                    c.drawRect(0, edgeShadowTop, bounds.height(), -mCornerRadius, mEdgeShadowPaint);

                    // LBorder
//                    c.rotate(180f);
//                    c.translate(-bounds.height(), -bounds.width() + 2 * mCornerRadius);
//                    c.drawRect(mCornerRadius, edgeShadowTop, bounds.height(), -mCornerRadius, mEdgeShadowPaint);
                }
            }
            c.restoreToCount(save);
        }
    }

    private Rect getBounds(View child) {
        return new Rect(child.getLeft(), child.getTop(), child.getLeft() + child.getWidth(), child.getTop() + child.getHeight());
    }


    private void buildShadowCorners() {
        RectF innerBounds = new RectF(-mCornerRadius, -mCornerRadius, mCornerRadius, mCornerRadius);
        RectF outerBounds = new RectF(innerBounds);
        outerBounds.inset(-mShadowSize, -mShadowSize);

        if (mCornerShadowPath == null) {
            mCornerShadowPath = new Path();
        } else {
            mCornerShadowPath.reset();
        }
        mCornerShadowPath.setFillType(Path.FillType.EVEN_ODD);
        mCornerShadowPath.moveTo(-mCornerRadius, 0);
        mCornerShadowPath.rLineTo(-mShadowSize, 0);
        // outer arc
        mCornerShadowPath.arcTo(outerBounds, 180f, 90f, false);
        // inner arc
        mCornerShadowPath.arcTo(innerBounds, 270f, -90f, false);
        mCornerShadowPath.close();

        float startRatio = mCornerRadius / (mCornerRadius + mShadowSize);
        mCornerShadowPaint.setShader(new RadialGradient(0, 0, mCornerRadius + mShadowSize, new int[]{
                mShadowStartColor, mShadowStartColor, mShadowEndColor}, new float[]{0f, startRatio, 1f},
                Shader.TileMode.CLAMP));

        // we offset the content shadowSize/2 pixels up to make it more realistic.
        // this is why edge shadow shader has some extra space
        // When drawing bottom edge shadow, we use that extra space.
        mEdgeShadowPaint.setShader(new LinearGradient(0, -mCornerRadius + mShadowSize, 0, -mCornerRadius - mShadowSize,
                new int[]{mShadowStartColor, mShadowStartColor, mShadowEndColor}, new float[]{0f, .5f, 1f},
                Shader.TileMode.CLAMP));
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        Resources resources = parent.getContext().getResources();

        float size16dp = 16f;
        int padding16dp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, size16dp, resources.getDisplayMetrics());

        RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) view.getLayoutParams();
        int position = params.getViewAdapterPosition();
        int viewType = parent.getAdapter().getItemViewType(position);

        if (viewType == HeaderItemTestAdapter.HEADER) {
            // header
            outRect.set(0, padding16dp, 0, 0);
        } else {
            if (parent.getAdapter().getItemViewType(position + 1) == HeaderItemTestAdapter.HEADER) {
                // last item before next header
                outRect.set(0, 0, 0, padding16dp);
            }
        }
//        outRect.inset((int) size16dp, 0);
        outRect.left = (int) size16dp;
        outRect.right = (int) size16dp;
    }
}
