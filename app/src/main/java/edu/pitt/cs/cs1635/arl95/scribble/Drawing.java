package edu.pitt.cs.cs1635.arl95.scribble;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;

/**
 * Created by alex on 2/6/16.
 */
public class Drawing {

    private ArrayList<Line> lines = new ArrayList<>();

    public void makeLine(int color) {
        lines.add(new Line(color));
    }

    public void addDot(float touchX, float touchY) {
        Line line = lines.get(lines.size() - 1);
        line.addDot(touchX, touchY);
    }

    public void draw(Canvas canvas) {
        for (Line line: lines) {
            line.draw(canvas);
        }
    }

    private class Line {
        private ArrayList<Dot> dots = new ArrayList<>();
        private Paint paint;

        public Line(int color) {
            paint = new Paint();
            paint.setColor(color);
            paint.setStrokeWidth(3);
        }

        public void addDot(float touchX, float touchY) {
            dots.add(new Dot(touchX, touchY));
        }

        public void draw(Canvas canvas) {
            for (int i = 0; i < dots.size() - 1; i++) {
                Dot currentDot = dots.get(i);
                Dot nextDot = dots.get(i + 1);
                canvas.drawLine(currentDot.x, currentDot.y, nextDot.x, nextDot.y, paint);
            }
        }
    }

    private class Dot {
        protected float x;
        protected float y;

        public Dot(float touchX, float touchY) {
            x = touchX;
            y = touchY;
        }
    }
}
