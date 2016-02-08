package edu.pitt.cs.cs1635.arl95.scribble;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * TODO: document your custom view class.
 */
public class CanvasView extends View {

    private Drawing drawing = new Drawing();
    int color = Color.BLACK;

    public CanvasView(Context context) {
        super(context);
        init();
    }

    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CanvasView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public void init() {
        final DrawingManager dm = DrawingManager.getInstance();
        this.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if ((event.getAction() & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_UP) {
                    drawing.makeLine(color);
                    dm.save();
                    invalidate();
                } else {
                    drawing.addDot(event.getX(), event.getY());
                    invalidate();
                }
                return true;
            }
        });
    }

    public void setDrawing(Drawing d) {
        drawing = d;
        drawing.makeLine(color); // Make a new line to start drawing on
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawing.draw(canvas);
    }

    public void setPaintColor(int newColor) {
        color = newColor;
        drawing.makeLine(color);
    }
}
