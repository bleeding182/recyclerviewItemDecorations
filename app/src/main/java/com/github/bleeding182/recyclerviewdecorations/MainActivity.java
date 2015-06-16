package com.github.bleeding182.recyclerviewdecorations;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // add some adapter with header and items
        recyclerView.setAdapter(new HeaderItemTestAdapter());

        // add the decoration
        recyclerView.addItemDecoration(new CardViewDecoration(getResources(), Color.WHITE, 0f));
        recyclerView.addItemDecoration(new DividerDecoration(this));
    }
}
