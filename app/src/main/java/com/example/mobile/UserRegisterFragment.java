package com.example.mobile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.sql.Connection;
import java.sql.Statement;

public class UserRegisterFragment extends Fragment {

    String namet;
    String emailt;
    String aget;

    EditText name,address,nic;
    Button button;

    Connection connection;
    Statement stm;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user_registration,null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        name = view.findViewById(R.id.fullNameTxt);
        address = view.findViewById(R.id.addrTxt);
        nic = view.findViewById(R.id.nicTxt);

        button = view.findViewById(R.id.userRegBtn);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try{

                        final String namet =name.getText().toString();
                        final String emailt=address.getText().toString();
                        final String aget = nic.getText().toString();

                        //Class.forName("com.mysql.jdbc.Driver");
                        //String mysqlConnUrl = "jdbc:mysql://192.168.1.110:3306/abc";
                        //String mysqlUserName = "abcd";
                        //String mysqlPassword = "1234";
                        //connection = DriverManager.getConnection(mysqlConnUrl, mysqlUserName , mysqlPassword);

                        ConnectionClass cn = new ConnectionClass();
                        connection = cn.con();

                        stm = connection.createStatement();
                        String q= "INSERT INTO staff (name,email,age) VALUES ('"+namet+"','"+emailt+"','"+aget+"')";
                        stm.executeUpdate(q);



                        Toast.makeText(getActivity().getApplicationContext(),"User Registered",Toast.LENGTH_SHORT).show();

                    }catch (Exception e){
                        e.printStackTrace();
                    }



                }
            });




    }
}
