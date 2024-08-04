package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
<<<<<<< Updated upstream
import android.widget.Button;
=======
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
>>>>>>> Stashed changes
import android.widget.PopupMenu;
import android.widget.Toast;

public class ListViewFragment extends Fragment {

<<<<<<< Updated upstream
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Toast.makeText(context, "Fragment ListView: onAttach", Toast.LENGTH_SHORT).show();
        Log.d("TAG", "onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(getActivity(), ":Fragment ListView : onCreate", Toast.LENGTH_SHORT).show();
        Log.d("TAG", "onCreate");
    }
=======

>>>>>>> Stashed changes

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Toast.makeText(getActivity(), "Fragment ListView: onCreateView", Toast.LENGTH_SHORT).show();
        Log.d("TAG", "onCreateView");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_view, container, false);
<<<<<<< Updated upstream

        // Initialize your button here
        Button button = view.findViewById(R.id.popup_menu); // Correct context for findViewById
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Toast.makeText(getActivity(), "FragmentTwo: onActivityCreated", Toast.LENGTH_SHORT).show();
        Log.d("TAG", "onActivityCreated");
    }


    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(getActivity(), "FragmentTwo: onStart", Toast.LENGTH_SHORT).show();
        Log.d("TAG", "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getActivity(), "FragmentTwo: onResume", Toast.LENGTH_SHORT).show();
        Log.d("TAG", "onResume");

    }

    @Override
    public void onPause() {
        super.onPause();
        Toast.makeText(getActivity(), "ListView: onPause", Toast.LENGTH_SHORT).show();
        Log.d("TAG", "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Toast.makeText(getActivity(), "ListView: onStop", Toast.LENGTH_SHORT).show();
        Log.d("TAG", "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Toast.makeText(getActivity(), "ListView: onDestroyView", Toast.LENGTH_SHORT).show();
        Log.d("TAG", "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getActivity(), "ListView: onDestroy", Toast.LENGTH_SHORT).show();
        Log.d("TAG", "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Toast.makeText(getActivity(), "ListView: onDetach", Toast.LENGTH_SHORT).show();
        Log.d("TAG", "onDetach");
    }

    private void showPopupMenu(View view) {
        PopupMenu popup = new PopupMenu(getActivity(), view);
        popup.getMenuInflater().inflate(R.menu.menu_items, popup.getMenu());

//        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.profile:
//                        Toast.makeText(getActivity(), "Profile Selected", Toast.LENGTH_SHORT).show();
//                        // Handle profile logic here
//                        return true;
//                    case R.id.logout:
//                        Toast.makeText(getActivity(), "Logout Selected", Toast.LENGTH_SHORT).show();
//                        // Handle logout logic here
//                        return true;
//                    default:
//                        return false;
//                }
//            }
//        });

        popup.show();
    }
=======
        ListView listView = (ListView) view.findViewById(R.id.listview_item);

        String food_listItem[] = {"Fulki", "Pani Puri", "Chawmin", "PIZZA", "MOMO", "Samosa", "Pakauda"};

        //Default Listview
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, food_listItem);
        listView.setAdapter(adapter);

        return view;
    }
>>>>>>> Stashed changes
}