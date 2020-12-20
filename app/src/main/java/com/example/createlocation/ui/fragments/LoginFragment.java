package com.example.createlocation.ui.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.createlocation.R;
import com.example.createlocation.data.ApiClient;
import com.example.createlocation.databinding.FragmentLoginBinding;
import com.example.createlocation.databinding.FragmentLoginBinding;
import com.example.createlocation.pojo.LoginRequest;
import com.example.createlocation.pojo.LoginResponse;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginFragment extends Fragment {
    View view;
   FragmentLoginBinding binding ;
    String password;
    String email;
    String token;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false);
        view = binding.getRoot();
        binding.enterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 email = binding.email.getText().toString();
                 password = binding.password.getText().toString();
                if(email.isEmpty()||password.isEmpty()){
                    Toast.makeText(getContext(), "You must enter invalid email and password", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    login();

                }
            }
        });
        return view;
    }

    public void login(){
        LoginRequest loginRequest = new LoginRequest(email,password);
        Call<LoginResponse> call = ApiClient.getApiInterface("").userLogin(loginRequest);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()){
                    token = response.body().getToken();
                    Bundle bundle = new Bundle();
                    bundle.putString("token", token);
                    Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_detailsFragment,bundle);
                }
                else
                    Toast.makeText(getContext(), "wrong data", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(getContext(), "wrong data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}