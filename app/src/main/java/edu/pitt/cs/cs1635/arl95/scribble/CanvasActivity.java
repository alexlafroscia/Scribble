package edu.pitt.cs.cs1635.arl95.scribble;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        DrawingManager dm = DrawingManager.getInstance();

        Intent intent = getIntent();
        int drawingIndex =  intent.getIntExtra(dm.CANVAS_DRAWING, 0);
        Drawing drawing = dm.get(drawingIndex);

        TextView text = (TextView) findViewById(R.id.canvas_text_view);
        text.setText(drawing.name);

        CanvasView canvas = (CanvasView) findViewById(R.id.canvas_view);
        canvas.setDrawing(drawing);
    }
}
