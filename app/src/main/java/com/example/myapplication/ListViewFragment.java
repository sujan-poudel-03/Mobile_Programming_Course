package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class ListViewFragment extends Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Toast.makeText(context, "Fragment ListView : onAttach", Toast.LENGTH_SHORT).show();
        Log.d("TAG", "onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(getActivity(), ":Fragment ListView : onCreate", Toast.LENGTH_SHORT).show();
        Log.d("TAG", "onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Toast.makeText(getActivity(), "Fragment ListView: onCreateView", Toast.LENGTH_SHORT).show();
        Log.d("TAG", "onCreateView");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_view, container, false);
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
}