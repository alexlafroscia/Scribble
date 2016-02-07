package edu.pitt.cs.cs1635.arl95.scribble;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by alex on 2/5/16.
 */
public class DrawingViewAdapter extends RecyclerView.Adapter<DrawingViewAdapter.ViewHolder> {

    DrawingManager dm;

    public DrawingViewAdapter() {
        dm = DrawingManager.getInstance();
    }

    @Override
    public DrawingViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.drawing_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Drawing d = dm.get(position);
        holder.textView.setText(d.name);

        // Attach a drawing to the holder, so that the holder can pass the drawing to the canvas
        // when it is clicked on to launch that activity
        holder.setIndex(position);
    }

    @Override
    public int getItemCount() {
        return dm.size();
    }

    /**
     * ViewHolder
     *
     * Display a row in the drawingList
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView textView;
        private int position;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);

            final DrawingManager dm = DrawingManager.getInstance();

            CardView card = (CardView) itemView.findViewById(R.id.drawing_item);
            card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dm.startDrawing(position);
                }
            });
        }

        public void setIndex(int index) {
            position = index;
        }
    }
}
