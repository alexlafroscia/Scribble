package edu.pitt.cs.cs1635.arl95.scribble;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Drawing
 *
 * Represents a drawing.  Contains an array of lines, and those have arrays of dots.
 *
 * Includes the logic for rendering to a canvas, too.
 */
public class Drawing implements Serializable {

    static final long serialVersionUID = 8118714021354765330L;

    private ArrayList<Line> lines = new ArrayList<>();
    public String name;

    public Drawing() {
        name = "This is a new drawing";
    }

    public void makeLine(int color) {
        lines.add(new Line(color));
    }

    /**
     * Get the current line, which is the last one in the array
     * @return {Line}
     */
    public Line currentLine() {
       return lines.get(lines.size() - 1);
    }

    /**
     * Add a dot to the current line
     * @param touchX the X-coordinate of the dot
     * @param touchY the Y-coordinate of the dot
     */
    public void addDot(float touchX, float touchY) {
        Line line = currentLine();
        line.addDot(touchX, touchY);
    }

    /**
     * Draw a line on the canvas for each line in the drawing
     * @param canvas the canvas to draw to
     */
    public void draw(Canvas canvas) {
        for (Line line: lines) {
            line.draw(canvas);
        }
    }

    private class Line implements Serializable {

        static final long serialVersionUID = 8118714021354765330L;

        private ArrayList<Dot> dots = new ArrayList<>();
        private int color;

        public Line(int lineColor) {
            color = lineColor;
        }

        public void addDot(float touchX, float touchY) {
            dots.add(new Dot(touchX, touchY));
        }

        public void draw(Canvas canvas) {
            Paint paint = new Paint();
            paint.setColor(color);
            paint.setStrokeWidth(3);

            for (int i = 0; i < dots.size() - 1; i++) {
                Dot currentDot = dots.get(i);
                Dot nextDot = dots.get(i + 1);
                canvas.drawLine(currentDot.x, currentDot.y, nextDot.x, nextDot.y, paint);
            }
        }
    }

    private class Dot implements Serializable {

        static final long serialVersionUID = 8118714021354765330L;

        protected float x;
        protected float y;

        public Dot(float touchX, float touchY) {
            x = touchX;
            y = touchY;
        }
    }
}
