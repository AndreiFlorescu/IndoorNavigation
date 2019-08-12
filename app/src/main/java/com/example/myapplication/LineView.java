package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class LineView extends View {

    static public Paint paint = new Paint();
    private List<Float> polyLine = new ArrayList<>();
    private float path[];

    public LineView(Context context) {
        super(context);
    }

    public LineView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LineView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        paint.setColor(Color.parseColor("#ffff00"));
        paint.setStrokeWidth(14);

        createArray(polyLine);
        canvas.drawLines(path, paint);

        super.onDraw(canvas);
    }

    private void createArray (List<Float> polyLine) {
        path = new float[polyLine.size()];

        for (int i = 0; i < polyLine.size(); ++i) {
            path[i] = polyLine.get(i);
        }
    }

    public void addPoint (double x, double y, int h, int w) {
        polyLine.add((float) y * w);
        polyLine.add((float) x * h);
    }

    public void draw () {
        invalidate();
        requestLayout();
    }
}
