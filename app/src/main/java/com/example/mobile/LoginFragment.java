package com.example.mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginFragment extends Fragment {

    String un,pw,status;

     EditText uname,password;

    TextView reg;

    Button log_button;

    Fragment fragment;

    Connection connection;

    Statement stm;

    ResultSet rs;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login,null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //register new user
        reg=view.findViewById(R.id.regTxt);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.screen_area,new UserRegisterFragment());
                fr.commit();

            }
        });



        uname= view.findViewById(R.id.logingUsernameTxt);
        password=view.findViewById(R.id.loginPasswordTxt);

        //login button
        log_button= view.findViewById(R.id.loginBtn);

        log_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {


                    final String userName=uname.getText().toString();
                    final String passW=password.getText().toString();

                    ConnectionClass cn = new ConnectionClass();
                    connection = cn.con();
                    stm = connection.createStatement();
                    String q= "SELECT* FROM login WHERE username='"+userName+"'";
                    rs=stm.executeQuery(q);

                    while (rs.next()){
                        un=rs.getString("username");
                        pw=rs.getString("password");
                        status=rs.getString("status");
                    }


                    if (un.equals(userName) && pw.equals(passW)){
                        if(status.equals("user")){


                           FragmentTransaction fr = getFragmentManager().beginTransaction();
                           fr.replace(R.id.screen_area,new MenuFragment());
                           fr.commit();

                        }else if(status.equals("staff")){

                            FragmentTransaction fr = getFragmentManager().beginTransaction();
                            fr.replace(R.id.screen_area,new MenuFragment());
                            fr.commit();

                        }
                    }


                }catch (Exception e){}



            }
        });

    }
}
