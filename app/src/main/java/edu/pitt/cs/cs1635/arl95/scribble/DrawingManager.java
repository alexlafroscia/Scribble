package edu.pitt.cs.cs1635.arl95.scribble;

import android.app.Activity;
import android.content.Intent;

import java.util.ArrayList;

import static android.support.v4.app.ActivityCompat.startActivity;

/**
 * Drawing Manager
 *
 * Singleton for managing the list of classes
 *
 * Responsibilities include:
 *
 *  - Storing the list of drawings
 *  - Serializing and deserializing it from storage
 *  - Getting specific drawings from the list
 *  - Opening the Canvas view to editing an existing drawings
 */
public class DrawingManager {

    public final static String CANVAS_DRAWING = "canvas_drawing";

    private static DrawingManager ourInstance = new DrawingManager();
    private Activity mainActivity;

    private ArrayList<Drawing> data;

    public static DrawingManager getInstance() {
        return ourInstance;
    }

    private DrawingManager() {
        data = new ArrayList<>();
    }

    public Drawing get(int index) {
        return data.get(index);
    }

    public int size() {
        return data.size();
    }

    /**
     * Creates a new drawing and returns the index in the array
     * @return {int} index
     */
    public int createDrawing() {
        Drawing d = new Drawing();
        data.add(d);
        return data.indexOf(d);
    }

    public void setMainActivity(Activity main) {
        mainActivity = main;
    }

    public void startDrawing(int position) {
        Intent intent = new Intent(mainActivity, CanvasActivity.class);
        intent.putExtra(CANVAS_DRAWING, position);
        mainActivity.startActivity(intent);
    }
}
