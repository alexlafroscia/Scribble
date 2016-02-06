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
        String message = intent.getStringExtra(dm.CANVAS_DRAWING);

        TextView text = (TextView) findViewById(R.id.canvas_text_view);
        text.setText(message);
    }
}
