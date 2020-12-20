package com.example.createlocation.ui.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.createlocation.R;
import com.example.createlocation.databinding.FragmentDetailsBinding;
import com.example.createlocation.pojo.FacilityModel;
import com.example.createlocation.pojo.GetAllDropDown;
import com.example.createlocation.pojo.RoomDB;

import java.util.ArrayList;


public class DetailsFragment extends Fragment {
    FragmentDetailsBinding binding;
    View view;
    String token;
    RoomDB roomDB;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_details, container, false);
        view = binding.getRoot();
        roomDB = RoomDB.getInstance(getContext());
        token = getArguments().getString("token");
        Bundle bundle = new Bundle();
        bundle.putString("token", token);
        binding.addLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Navigation.findNavController(view).navigate(R.id.action_detailsFragment_to_createLocationFragment,bundle);
            }
        });
        binding.viewSavedLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_detailsFragment_to_savedOfflineFragment);
            }
        });

        return view;
    }
}