package fpt.edu.pay.model.recycle;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import fpt.edu.pay.R;

public class VerticalSpaceItemDecoration extends RecyclerView.ItemDecoration {

    private final int dividerColor;
    private final int height;

    public VerticalSpaceItemDecoration(int height, int dividerColor) {
        this.dividerColor = dividerColor;
        this.height = height;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        outRect.top = view.getResources().getDimensionPixelSize(R.dimen.vertical_padding);
        outRect.bottom = view.getResources().getDimensionPixelSize(R.dimen.vertical_padding);
    }

    @Override
    public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        Paint paint = new Paint();
        paint.setColor(dividerColor);
        paint.setStrokeWidth(height);

        int childCount = parent.getChildCount();
        int width = parent.getWidth();
        int height = parent.getHeight();

        for (int i = 0; i < childCount - 1; i++) {
            View child = parent.getChildAt(i);
            int x = child.getRight();
            int y = child.getBottom();
            canvas.drawLine(0, y, width, y, paint);
        }
    }
}
