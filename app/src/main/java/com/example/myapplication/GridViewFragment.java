package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class GridViewFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_grid_view, container, false);

        GridView gridView = (GridView) view.findViewById(R.id.grid_view_item);
        String noodels[] = {"waiwai","rumpum", "current","preeti"};

        final ArrayAdapter<String>  adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1,noodels);
        gridView.setAdapter(adapter);

        return view;
    }

}