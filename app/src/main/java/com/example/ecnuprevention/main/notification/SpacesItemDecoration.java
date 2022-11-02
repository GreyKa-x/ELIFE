package com.example.ecnuprevention.main.notification;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
    private int space;

    public SpacesItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {
        outRect.left = space * 2;
        outRect.right = space * 2;
        outRect.top = space;

        // Add top margin only for the first item to avoid double space between items
        if (parent.getChildPosition(view) == parent.getAdapter().getItemCount() - 1)
            outRect.bottom = space;
    }
}