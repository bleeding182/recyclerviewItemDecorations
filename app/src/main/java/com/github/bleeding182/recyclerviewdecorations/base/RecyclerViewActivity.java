package com.github.bleeding182.recyclerviewdecorations.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.github.bleeding182.recyclerviewdecorations.R;

public abstract class RecyclerViewActivity extends AppCompatActivity {

  protected RecyclerView recyclerView;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_with_recyclerview);
    recyclerView = findViewById(R.id.recycler_view);
    onCreateRecyclerView(savedInstanceState);
  }

  /**
   * Initialize the recycler view. {@link #recyclerView}
   *
   * @param savedInstanceState the saved state
   */
  public abstract void onCreateRecyclerView(Bundle savedInstanceState);
}
