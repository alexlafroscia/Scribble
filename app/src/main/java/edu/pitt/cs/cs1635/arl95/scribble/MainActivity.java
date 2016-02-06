package edu.pitt.cs.cs1635.arl95.scribble;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private RecyclerView drawingList;
    private RecyclerView.Adapter drawingListAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final DrawingManager dm = DrawingManager.getInstance();
        dm.setMainActivity(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dm.startDrawing("This is a new drawing");
            }
        });

        drawingList = (RecyclerView) findViewById(R.id.drawing_list);
        drawingList.setHasFixedSize(true);
        drawingList.setLayoutManager(new LinearLayoutManager(this));
        drawingList.setNestedScrollingEnabled(true);

        ArrayList<String> testList = new ArrayList<>();
        testList.add("This is a test 1");
        testList.add("This is a test 2");
        testList.add("This is a test 3");
        testList.add("This is a test 4");
        testList.add("This is a test 5");
        testList.add("This is a test 6");
        testList.add("This is a test 7");
        testList.add("This is a test 8");
        testList.add("This is a test 9");
        testList.add("This is a test 10");
        testList.add("This is a test 11");
        testList.add("This is a test 12");
        testList.add("This is a test 13");
        testList.add("This is a test 14");
        testList.add("This is a test 15");
        testList.add("This is a test 16");
        drawingListAdapter = new DrawingViewAdapter(testList);
        drawingList.setAdapter(drawingListAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
