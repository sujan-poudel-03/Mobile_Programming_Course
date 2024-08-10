package com.example.myapplication;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        String[] food_listItem = {"Fulki", "Pani Puri", "Chawmin", "PIZZA", "MOMO", "Samosa", "Pakauda"};
        String[] food_listItemPrice = {"200", "300", "400", "500", "600", "700", "800"};

        RecyclerView recyclerView = view.findViewById(R.id.recyclerview_example);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity())); // Set the layout manager
//        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        // Set the adapter
        recyclerView.setAdapter(new FoodAdapter(food_listItem, food_listItemPrice));

        return view;
    }

    // Adapter class
    private static class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

        private final String[] foodList;
        private final String[] foodPriceList;

        FoodAdapter(String[] foodList, String[] foodPriceList) {
            this.foodList = foodList;
            this.foodPriceList = foodPriceList;
        }

        @NonNull
        @Override
        public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_food, parent, false);
            return new FoodViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
            holder.foodNameTextView.setText(foodList[position]);
            holder.foodPriceTextView.setText(foodPriceList[position]);
        }

        @Override
        public int getItemCount() {
            return foodList.length;
        }

        static class FoodViewHolder extends RecyclerView.ViewHolder {
            TextView foodNameTextView;
            TextView foodPriceTextView;
            FoodViewHolder(@NonNull View itemView) {
                super(itemView);
                    foodNameTextView = itemView.findViewById(R.id.textViewFoodName);
                    foodPriceTextView = itemView.findViewById(R.id.textViewFoodPrice);
            }
        }
    }
}
