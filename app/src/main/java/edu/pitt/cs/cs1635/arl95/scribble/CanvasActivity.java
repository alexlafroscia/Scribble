package edu.pitt.cs.cs1635.arl95.scribble;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        final DrawingManager dm = DrawingManager.getInstance();

        Intent intent = getIntent();
        int drawingIndex =  intent.getIntExtra(dm.CANVAS_DRAWING, 0);
        final Drawing drawing = dm.get(drawingIndex);

        EditText text = (EditText) findViewById(R.id.drawingName);
        text.setText(drawing.name);
        text.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                drawing.name = v.getText().toString();
                dm.save();
                return false;
            }
        });

        final CanvasView canvas = (CanvasView) findViewById(R.id.canvas_view);
        canvas.setDrawing(drawing);

        final Switch colorSwitch = (Switch) findViewById(R.id.ink_color_switch);
        colorSwitch.setText(getString(R.string.text_label_black));
        colorSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    canvas.setPaintColor(Color.RED);
                    colorSwitch.setText(getString(R.string.text_label_red));
                } else {
                    canvas.setPaintColor(Color.BLACK);
                    colorSwitch.setText(getString(R.string.text_label_black));
                }
            }
        });

    }
}
