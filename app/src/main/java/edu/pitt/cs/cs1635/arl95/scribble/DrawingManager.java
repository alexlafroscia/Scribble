package edu.pitt.cs.cs1635.arl95.scribble;

import android.app.Activity;
import android.content.Intent;

import java.util.ArrayList;

import static android.support.v4.app.ActivityCompat.startActivity;

/**
 * Created by alex on 2/6/16.
 */
public class DrawingManager {

    public final static String CANVAS_DRAWING = "canvas_drawing";

    private static DrawingManager ourInstance = new DrawingManager();
    private Activity mainActivity;

    private ArrayList<String> data;

    public static DrawingManager getInstance() {
        return ourInstance;
    }

    private DrawingManager() {
        data = new ArrayList<>();
        data.add("This is a test 1");
        data.add("This is a test 2");
        data.add("This is a test 3");
        data.add("This is a test 4");
        data.add("This is a test 5");
        data.add("This is a test 6");
        data.add("This is a test 7");
        data.add("This is a test 8");
        data.add("This is a test 9");
        data.add("This is a test 10");
    }

    public String get(int index) {
        return data.get(index);
    }

    public int size() {
        return data.size();
    }

    public ArrayList<String> getData() {
        return data;
    }

    public void setMainActivity(Activity main) {
        mainActivity = main;
    }

    public void startDrawing(String message) {
        Intent intent = new Intent(mainActivity, CanvasActivity.class);
        intent.putExtra(CANVAS_DRAWING, message);
        mainActivity.startActivity(intent);
    }
}
