package com.example.mobile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class StaffFragment extends Fragment {

    String st_name,st_address,st_nic,st_mobile,st_email,st_location, st_loyaltyPoints,st_lastPurchDate;

    Connection connection;
    Statement stm;
    ResultSet rs;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_staff,null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView name,address,nic,mobile,email,location, loyaltyPoints,lastPurchDate;

        name=view.findViewById(R.id.textView28);
        address=view.findViewById(R.id.textView29);
        nic=view.findViewById(R.id.textView30);
        mobile=view.findViewById(R.id.textView31);
        email=view.findViewById(R.id.textView32);
        location=view.findViewById(R.id.textView33);
        loyaltyPoints=view.findViewById(R.id.textView34);
        lastPurchDate=view.findViewById(R.id.textView35);


        try{

            int a=1;

            ConnectionClass cn = new ConnectionClass();
            connection = cn.con();
            stm = connection.createStatement();
            String q="Select* from staff where id='"+a+"'";
            rs=stm.executeQuery(q);

            while (rs.next()) {
                st_name = rs.getString("name");
                st_address = rs.getString("address");
                st_nic = rs.getString("nic");
                st_mobile = rs.getString("mobile");
                st_email = rs.getString("email");
                st_location= rs.getString("location");
                st_loyaltyPoints = rs.getString("loyalty_points");
                st_lastPurchDate = rs.getString("lastPurDate");

            }

            name.setText(st_name);
            address.setText(st_address);
            nic.setText(st_nic);
            mobile.setText(st_mobile);
            email.setText(st_email);
            location.setText(st_location);
            loyaltyPoints.setText(st_loyaltyPoints);
            lastPurchDate.setText(st_lastPurchDate);







        }catch (Exception e){
            e.printStackTrace();
        }








    }
}
