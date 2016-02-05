package edu.pitt.cs.cs1635.arl95.scribble;

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

    private ArrayList<String> dataSet;

    public DrawingViewAdapter(ArrayList<String> data) {
        dataSet = data;
    }

    @Override
    public DrawingViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.drawing_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(dataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    /**
     * ViewHolder
     *
     * Display a row in the drawingList
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }
    }
}
