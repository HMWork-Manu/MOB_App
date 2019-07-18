package com.example.mobile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MenuFragment extends Fragment {
    Fragment fragment;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu,null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //code here
        ImageView discount=view.findViewById(R.id.discountMenuImg);
        ImageView promotion=view.findViewById(R.id.offerMenuImg);
        ImageView user=view.findViewById(R.id.userMenuImg);
        ImageView staff=view.findViewById(R.id.staffMenuImg);
        ImageView item=view.findViewById(R.id.itemMenuImg);
        ImageView company=view.findViewById(R.id.companyMenuImg);

        //Discount
        discount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //Promotion
        promotion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //user profile
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new UserFragment();
            }
        });

        //staff profile
        staff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new StaffFragment();
            }
        });


        //item list
        item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //company
        company.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new CompanyFragment();
            }
        });
    }
}
