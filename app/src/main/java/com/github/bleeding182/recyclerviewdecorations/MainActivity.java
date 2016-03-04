package com.github.bleeding182.recyclerviewdecorations;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by David on 16.06.2015.
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // setup the view
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        // add some adapter with header and items
        HeaderItemTestAdapter adapter = new HeaderItemTestAdapter();
        recyclerView.setAdapter(adapter);

        ItemTouchHelper.Callback callback = new ItemTouchHelperCallback(adapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(recyclerView);

        recyclerView.addItemDecoration(new DismissDecoration(Color.rgb(10, 210, 25),
                BitmapFactory.decodeResource(getResources(), R.drawable.ic_archive_24dp),
                getResources().getDisplayMetrics().density));


        // add the decoration
//        recyclerView.addItemDecoration(new CardViewDecoration(getResources(), Color.WHITE, 0f));
//        SeparatorDecoration decoration = SeparatorDecoration
//                .with(this)
//                .build();
//        recyclerView.addItemDecoration(HeaderDecoration.with(recyclerView)
//                .inflate(R.layout.header)
//                .parallax(0.2f)
//                .dropShadowDp(4)
//                .build());
//        recyclerView.addItemDecoration(new CardViewDecoration(getResources(), Color.WHITE, 0f));
//        recyclerView.addItemDecoration(new DividerDecoration(this));
//        recyclerView.addItemDecoration(new ParallaxHeaderDecoration(this, R.drawable.night_png));
    }
}
