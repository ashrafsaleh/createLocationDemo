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


public class DetailsFragment extends Fragment {
    FragmentDetailsBinding binding;
    View view;
    String token;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_details, container, false);
        view = binding.getRoot();
        token = getArguments().getString("token");
        Bundle bundle = new Bundle();
        bundle.putString("token", token);
        binding.addLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_detailsFragment_to_createLocationFragment,bundle);
            }
        });
        return view;
    }
}