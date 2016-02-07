package edu.pitt.cs.cs1635.arl95.scribble;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;

/**
 * Created by alex on 2/6/16.
 */
public class Drawing {

    private ArrayList<Line> lines = new ArrayList<>();

    public Drawing() {
        // Initialize the first line
        lines.add(new Line());
    }

    public void addDot(float touchX, float touchY) {
        Line line = lines.get(lines.size() - 1);
        line.addDot(touchX, touchY);
    }

    public void draw(Canvas canvas, Paint paint) {
        for (Line line: lines) {
            line.draw(canvas, paint);
        }
    }

    private class Line {
        private ArrayList<Dot> dots = new ArrayList<>();

        public void addDot(float touchX, float touchY) {
            dots.add(new Dot(touchX, touchY));
        }

        public void draw(Canvas canvas, Paint paint) {
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
