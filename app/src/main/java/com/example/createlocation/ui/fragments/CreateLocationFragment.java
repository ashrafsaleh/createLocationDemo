package com.example.createlocation.ui.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.createlocation.R;
import com.example.createlocation.data.ApiClient;
import com.example.createlocation.databinding.FragmentCreateLocationBinding;
import com.example.createlocation.databinding.FragmentLoginBinding;
import com.example.createlocation.pojo.FacilityModel;
import com.example.createlocation.pojo.GetAllDropDown;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CreateLocationFragment extends Fragment {
    FragmentCreateLocationBinding binding;
    ArrayList<String> facilities = new ArrayList<>();
    ArrayList<String> contractTypes = new ArrayList<>();
    ArrayList<String> locationCat = new ArrayList<>();
    ArrayList<String> locationTypes = new ArrayList<>();
    ArrayList<String> locationStatus = new ArrayList<>();
    ArrayList<String> safetyOffices = new ArrayList<>();
    ArrayList<Integer> facId = new ArrayList<>();
    String token;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_create_location, container, false);
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_create_location,container,false);
        token = getArguments().getString("token");
        view = binding.getRoot();
        binding.arrowDown.setImageResource(R.drawable.ic_baseline_expand_more_24);
        binding.arrowDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.constContainer.setVisibility(View.VISIBLE);
            }
        });
        binding.arrowDownLoc.setImageResource(R.drawable.ic_baseline_expand_more_24);
        binding.arrowDownLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.locContainer.setVisibility(View.VISIBLE);
            }
        });
        binding.arrowDownSafe.setImageResource(R.drawable.ic_baseline_expand_more_24);
        binding.arrowDownSafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.safeContainer.setVisibility(View.VISIBLE);
            }
        });
        binding.arrowDownLi.setImageResource(R.drawable.ic_baseline_expand_more_24);
        binding.arrowDownLi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.licenseContainer.setVisibility(View.VISIBLE);
            }
        });

        getFacilities();
        getAllDropDown();
        return view;
    }
    public void getFacilities(){
        Call<List<FacilityModel>> call = ApiClient.getApiInterface().getFacilities();
        call.enqueue(new Callback<List<FacilityModel>>() {
            @Override
            public void onResponse(Call<List<FacilityModel>> call, Response<List<FacilityModel>> response) {
                for (int i =0;i<response.body().size();i++){

                    facilities.add(response.body().get(i).getName());
                    facId.add(response.body().get(i).getId());
                    ArrayAdapter adapter = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item,facilities);
                    adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                    binding.firstSpinner.setAdapter(adapter);
                    //int idd = response.body().get(binding.firstSpinner.getSelectedItemPosition()).getId();
                }
            }

            @Override
            public void onFailure(Call<List<FacilityModel>> call, Throwable t) {
                Toast.makeText(getContext(), "failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void getAllDropDown(){
        Call <GetAllDropDown> call = ApiClient.getApiInterface().getDropDown();
        call.enqueue(new Callback<GetAllDropDown>() {
            @Override
            public void onResponse(Call<GetAllDropDown> call, Response<GetAllDropDown> response) {
                if(response.isSuccessful()){
                    for(int i =0;i<response.body().getContractType().size();i++) {
                        contractTypes.add(response.body().getContractType().get(i));
                        ArrayAdapter contractAdapter = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item, contractTypes);
                        contractAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        binding.contractSpinner.setAdapter(contractAdapter);
                    }
                    for(int i = 0;i<response.body().getLocationCategories().size();i++){
                        locationCat.add(response.body().getLocationCategories().get(i).getName());
                        ArrayAdapter catAdapter = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item, locationCat);
                        catAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        binding.contractKindSpinner.setAdapter(catAdapter);
                    }

                    for(int i = 0;i<response.body().getLocationTypes().size();i++){
                        locationTypes.add(response.body().getLocationTypes().get(i));
                        ArrayAdapter typeAdapter = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item, locationTypes);
                        typeAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        binding.trainSpinner.setAdapter(typeAdapter);
                    }
                    for(int i = 0;i<response.body().getLocationStatus().size();i++){
                        locationStatus.add(response.body().getLocationStatus().get(i));
                        ArrayAdapter statusAdapter = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item, locationStatus);
                        statusAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        binding.signerSpinner.setAdapter(statusAdapter);
                    }
                    for(int i = 0;i<response.body().getSaftyOffices().size();i++){
                        safetyOffices.add(response.body().getSaftyOffices().get(i).getName());
                        ArrayAdapter safetyAdapter = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item, safetyOffices);
                        safetyAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        binding.safeSpinner.setAdapter(safetyAdapter);
                    }

                }
            }

            @Override
            public void onFailure(Call<GetAllDropDown> call, Throwable t) {

            }
        });
    }
}