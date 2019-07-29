package com.example.mobile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MenuFragment1 extends Fragment {
    Fragment fragment;
    Button logButton;

    TextView uname;
    String userN;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_menu1,null);




    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        logButton = view.findViewById(R.id.loginMenubtn);
        logButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.screen_area,new LoginFragment());
                fr.commit();
            }
        });


        //code here
        ImageView discount=view.findViewById(R.id.discountMenuImg);
        ImageView promotion=view.findViewById(R.id.offerMenuImg);
        ImageView user=view.findViewById(R.id.userMenuImg);
        ImageView staff=view.findViewById(R.id.staffMenuImg);
        ImageView item=view.findViewById(R.id.itemMenuImg);
        ImageView company=view.findViewById(R.id.companyMenuImg);

        staff.setEnabled(false);

        //Discount
        discount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.screen_area,new DiscountFragment());
                fr.commit();
            }
        });

        //Promotion
        promotion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.screen_area,new PromotionFragment());
                fr.commit();
            }
        });

        //user profile
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.screen_area,new UserFragment());
                fr.commit();
            }
        });

        //staff profile
        staff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.screen_area,new StaffFragment());
                fr.commit();
            }
        });


        //item list
        item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.screen_area,new ItemListFragment());
                fr.commit();
            }
        });

        //company
        company.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.screen_area,new CompanyFragment());
                fr.commit();
            }
        });



    }
}
