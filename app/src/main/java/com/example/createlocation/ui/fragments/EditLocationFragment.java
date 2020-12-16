package com.example.createlocation.ui.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.createlocation.R;
import com.example.createlocation.data.ApiClient;
import com.example.createlocation.databinding.FragmentEditLocationBinding;
import com.example.createlocation.pojo.CreateLocationModel;
import com.example.createlocation.pojo.CreateLocationResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditLocationFragment extends Fragment {
    FragmentEditLocationBinding binding;
    View view;
    int id,postCode,safId,catId,typeId,statusId,contractId,facilityId;
    String name,streetName,address,buildingNum,neighborhood,longitude,latitude,buildingLice,touristLice,
            duration,guardName,guardNum,reason,officerName,officerNum,operator,owner,defenseLice,lifts,
            safetyFacility,hojaj,electricity;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_edit_location, container, false);
        view = binding.getRoot();
        setValue();
        return view;
    }
    public void setValue(){
        id = Integer.parseInt(getArguments().getString("id"));
        postCode = Integer.parseInt(getArguments().getString("postCode"));
        safId = Integer.parseInt(getArguments().getString("safetyOffice"));
        catId = Integer.parseInt(getArguments().getString("locationCat"));
        typeId = Integer.parseInt(getArguments().getString("type"));
        statusId = Integer.parseInt(getArguments().getString("status"));
        contractId = Integer.parseInt(getArguments().getString("contractID"));
        facilityId = Integer.parseInt(getArguments().getString("facilityID"));
        name = getArguments().getString("name");
        streetName = getArguments().getString("streetName");
        address = getArguments().getString("setAddress");
        buildingNum = getArguments().getString("buildingNum");
        neighborhood = getArguments().getString("neighborhood");
        longitude = getArguments().getString("longitude");
        latitude = getArguments().getString("latitude");
        buildingLice = getArguments().getString("buildingLice");
        touristLice = getArguments().getString("touristLice");
        duration = getArguments().getString("duration");
        guardName = getArguments().getString("guardName");
        guardNum = getArguments().getString("guardNum");
        reason = getArguments().getString("reason");
        officerName = getArguments().getString("officerName");
        officerNum = getArguments().getString("officerNum");
        operator = getArguments().getString("operator");
        owner = getArguments().getString("owner");
        defenseLice = getArguments().getString("defenseLice");
        lifts = getArguments().getString("lifts");
        safetyFacility = getArguments().getString("safetyFacility");
        hojaj = getArguments().getString("hojaj");
        electricity = getArguments().getString("electricity");
    }
    public void viewData(){
        binding.editName.setText(name);
        binding.editStreetName.setText(streetName);
        binding.editAddress.setText(address);
        binding.editBuildingNumber.setText(buildingNum);
        binding.editNeighborhood.setText(neighborhood);
        binding.editPostCode.setText(postCode);
        binding.editLongitude.setText(longitude);
        binding.editLatitude.setText(latitude);
        binding.editBuildingLicense.setText(buildingLice);
        binding.editTouristLicense.setText(touristLice);
        binding.editDurationWork.setText(duration);
        binding.editGuardName.setText(guardName);
        binding.editGuardNum.setText(guardNum);
        binding.editReason.setText(reason);
        binding.editResponsible.setText(officerName);
        binding.editResponsibleNum.setText(officerNum);
        binding.editBuildingWorker.setText(operator);
        binding.editBuildingOwner.setText(owner);
        binding.editLicenseNum.setText(defenseLice);
        binding.editElevatorResponsible.setText(lifts);
        binding.editSafetyResponsible.setText(safetyFacility);
        binding.editHogagLicense.setText(hojaj);
        binding.editElectricity.setText(electricity);
    }
    public void getRequest(int id,CreateLocationResponse createLocationResponse) {
        Call<Boolean> call = ApiClient.getApiInterface("").getRequest(id,createLocationResponse);
        call.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {

            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {

            }
        });
    }
}