package com.example.workout;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

public class WorkoutListFragment extends ListFragment {
    static interface WorkoutListListener {
        void itemClicked(long id);
    }

    private WorkoutListListener listener;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        String[] names =    new String[Workout.workouts.length];
        for (int i=0;i<names.length;i++) {
            names[i] = Workout.workouts[i].getName();
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1,names);
        setListAdapter(arrayAdapter);
        return super.onCreateView(inflater, container, savedInstanceState);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (WorkoutListListener) context;
    }

    @Override
    public void onListItemClick( ListView l, View v, int position, long id) {
        if (listener != null) {
            listener.itemClicked(id);
        }
    }
}
