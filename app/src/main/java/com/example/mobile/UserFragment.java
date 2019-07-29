package com.example.mobile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserFragment extends Fragment {
String gen;

    String name,adddress,Nic,Gender,moBile,loyalTy,lastPur,emAil,locAtion;

    Connection connection;
    Statement stm;
    ResultSet rs;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user,null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tx=view.findViewById(R.id.textView);


        RadioButton m,f;
        TextView fullname,addres,gender,nic,mob,email,loyalty,lastLoc,loca;




        fullname=view.findViewById(R.id.nameTxt);
        addres=view.findViewById(R.id.addressTxt);
        nic=view.findViewById(R.id.nicTxt);
        mob=view.findViewById(R.id.mobileTxt);
        email=view.findViewById(R.id.emailTxt);
        loyalty = view.findViewById(R.id.LoyalPointTxt);
        loca=view.findViewById(R.id.locationTxt);
        lastLoc=view.findViewById(R.id.LastLocationTxt);
        gender=view.findViewById(R.id.genderTxt);

        try {

            int a=1;

            ConnectionClass cn = new ConnectionClass();
            connection = cn.con();
            stm = connection.createStatement();
            String q="Select* from userProfile where id='"+a+"'";
            rs=stm.executeQuery(q);

            while (rs.next()) {
                name = rs.getString("name");
                adddress = rs.getString("address");
                Nic = rs.getString("nic");
                Gender = rs.getString("gender");
                moBile = rs.getString("mobile");
                loyalTy = rs.getString("loyaltyPoint");
                lastPur = rs.getString("lastPurLocation");
                emAil = rs.getString("email");
                locAtion = rs.getString("location");
            }


            fullname.setText(name);
            addres.setText(adddress);
            nic.setText(Nic);
            gender.setText(Gender);
            System.out.println(Gender);
            mob.setText(moBile);
            loyalty.setText(loyalTy);
            lastLoc.setText(lastPur);
            email.setText(emAil);
            loca.setText(locAtion);


        }catch (Exception e){
            e.printStackTrace();
        }












    }
}
