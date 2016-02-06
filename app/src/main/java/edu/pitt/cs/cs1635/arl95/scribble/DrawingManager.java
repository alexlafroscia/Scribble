package edu.pitt.cs.cs1635.arl95.scribble;

import android.app.Activity;
import android.content.Intent;

import static android.support.v4.app.ActivityCompat.startActivity;

/**
 * Created by alex on 2/6/16.
 */
public class DrawingManager {

    public final static String CANVAS_DRAWING = "canvas_drawing";

    private static DrawingManager ourInstance = new DrawingManager();
    private Activity mainActivity;

    public static DrawingManager getInstance() {
        return ourInstance;
    }

    private DrawingManager() {
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
