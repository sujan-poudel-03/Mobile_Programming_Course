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

public class GridViewFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_grid_view, container, false);

        // Register the view for context menu
        View myView = view.findViewById(R.id.context_menu);
        registerForContextMenu(myView);

        return view;
    }
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//
//        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_grid_view, container, false);
//
//        // Register the view for context menu
//        View myView = view.findViewById(R.id.context_menu);
//        registerForContextMenu(myView);
//
//        return view;
//
//
//    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = requireActivity().getMenuInflater();
        inflater.inflate(R.menu.menu_items, menu);
    }

//    @Override
//    public boolean onContextItemSelected(MenuItem item) {
//        Log.d("GridViewFragment", "Menu item selected: " + item.getItemId());
//        switch (item.getItemId()) {
//            case R.id.profile_id:
//                return true;
//            case R.id.logout_id:
//                // Handle logout option
//                return true;
//            default:
//                return super.onContextItemSelected(item);
//        }
//    }


}