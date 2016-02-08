package edu.pitt.cs.cs1635.arl95.scribble;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


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
        dm.restore();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index = dm.createDrawing();
                dm.startDrawing(index);
            }
        });

        drawingList = (RecyclerView) findViewById(R.id.drawing_list);
        drawingList.setHasFixedSize(true);
        drawingList.setLayoutManager(new LinearLayoutManager(this));
        drawingList.setNestedScrollingEnabled(true);

        drawingListAdapter = new DrawingViewAdapter();
        drawingList.setAdapter(drawingListAdapter);
    }

    protected void onResume() {
        super.onResume();
        this.repaintList();
    }

    protected void repaintList() {
        drawingListAdapter.notifyDataSetChanged();

        // Show empty label if the view is empty
        DrawingManager dm = DrawingManager.getInstance();
        TextView emptyLabel = (TextView) findViewById(R.id.empty_view);
        RecyclerView rv = (RecyclerView) findViewById(R.id.drawing_list);
        if (dm.size() == 0) {
            emptyLabel.setVisibility(View.VISIBLE);
            rv.setVisibility(View.GONE);
        } else {
            emptyLabel.setVisibility(View.GONE);
            rv.setVisibility(View.VISIBLE);
        }

        dm.save();
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

        // Option to clear drawings
        if (id == R.id.action_purge) {
            DrawingManager dm = DrawingManager.getInstance();
            if (dm.purge()) {
                this.repaintList();
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
