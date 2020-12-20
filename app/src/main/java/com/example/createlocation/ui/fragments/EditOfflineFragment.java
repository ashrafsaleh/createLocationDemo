package com.example.createlocation.ui.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.createlocation.R;
import com.example.createlocation.databinding.FragmentEditOfflineBinding;
import com.example.createlocation.pojo.CreateLocationDB;
import com.example.createlocation.pojo.FacilityModel;
import com.example.createlocation.pojo.LocationCategories;
import com.example.createlocation.pojo.RoomDB;
import com.example.createlocation.pojo.SafteyOffices;

import java.util.ArrayList;


public class EditOfflineFragment extends Fragment {
    FragmentEditOfflineBinding binding;
    View view;
    RoomDB roomDB;
    int id,postCode,safId,catId,typeId,statusId,contractId,facilityId,index,conId2,statusId2,typeId2,facId2,catId2,safId2;
    String name,streetName,address,buildingNum,neighborhood,longitude,latitude,buildingLice,touristLice,
            duration,guardName,guardNum,reason,officerName,officerNum,operator,owner,defenseLice,lifts,
            safetyFacility,hojaj,electricity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_edit_offline, container, false);
        view = binding.getRoot();
        roomDB = RoomDB.getInstance(getContext());
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
        setValue();
        viewData();
        binding.editButtonOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roomDB.dao().updateData(updateData());
                Toast.makeText(getContext(), "Your Data updated successfully !", Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }
    public void setValue(){
        id = getArguments().getInt("id");
        safId = getArguments().getInt("safetyOffice");
        catId = getArguments().getInt("locationCat");
        typeId = getArguments().getInt("type");
        statusId = getArguments().getInt("status");
        contractId = getArguments().getInt("contractID");
        facilityId = getArguments().getInt("facilityID");
        postCode = getArguments().getInt("postCode");
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
        binding.editNameOff.setText(name);
        binding.editStreetNameOff.setText(streetName);
        binding.editAddressOff.setText(address);
        binding.editBuildingNumberOff.setText(buildingNum);
        binding.editNeighborhoodOff.setText(neighborhood);
        binding.editPostCodeOff.setText(String.valueOf(postCode));
        binding.editLongitudeOff.setText(longitude);
        binding.editLatitudeOff.setText(latitude);
        binding.editBuildingLicenseOff.setText(buildingLice);
        binding.editTouristLicenseOff.setText(touristLice);
        binding.editDurationWorkOff.setText(duration);
        binding.editGuardNameOff.setText(guardName);
        binding.editGuardNumOff.setText(guardNum);
        binding.editReasonOff.setText(reason);
        binding.editResponsibleOff.setText(officerName);
        binding.editResponsibleNumOff.setText(officerNum);
        binding.editBuildingWorkerOff.setText(operator);
        binding.editBuildingOwnerOff.setText(owner);
        binding.editLicenseNumOff.setText(defenseLice);
        binding.editElevatorResponsibleOff.setText(lifts);
        binding.editSafetyResponsibleOff.setText(safetyFacility);
        binding.editHogagLicenseOff.setText(hojaj);
        binding.editElectricityOff.setText(electricity);
    }
    public CreateLocationDB updateData(){
        CreateLocationDB locationDB = new CreateLocationDB();
        locationDB.setId(id);
        locationDB.setName(binding.editNameOff.getText().toString());
        locationDB.setStreetName(binding.editStreetNameOff.getText().toString());
        locationDB.setAddressDescription(binding.editAddressOff.getText().toString());
        locationDB.setBuildingNo(binding.editBuildingNumberOff.getText().toString());
        locationDB.setNeighborhood(binding.editNeighborhoodOff.getText().toString());
        locationDB.setPostalCode(Integer.parseInt(binding.editPostCodeOff.getText().toString()));
        locationDB.setLongitude(binding.editLongitudeOff.getText().toString());
        locationDB.setLatitude(binding.editLatitudeOff.getText().toString());
        locationDB.setSaftyOfficeId(safId);
        locationDB.setLocationCategoryId(catId);
        locationDB.setType(typeId);
        locationDB.setConstructionLicenseNo(binding.editBuildingLicenseOff.getText().toString());
        locationDB.setTourismAuthorityLicenseNo(binding.editTouristLicenseOff.getText().toString());
        locationDB.setWorkingHours(binding.editDurationWorkOff.getText().toString());
        locationDB.setGuardName(binding.editGuardNameOff.getText().toString());
        locationDB.setGuardMobile(binding.editGuardNumOff.getText().toString());
        locationDB.setStatus(statusId);
        locationDB.setRecordStatus(2);
        locationDB.setLastModifiedDate("2023-06-10T00:00:00");
        locationDB.setClosureOrRemovalReasons(binding.editReasonOff.getText().toString());
        locationDB.setSafetyOfficerName(binding.editResponsibleOff.getText().toString());
        locationDB.setSafetyOfficerMobile(binding.editResponsibleNumOff.getText().toString());
        locationDB.setBuildingOperatorName(binding.editBuildingWorkerOff.getText().toString());
        locationDB.setBuildingOwnerName(binding.editBuildingOwnerOff.getText().toString());
        locationDB.setCivilDefenseLicenseNo(binding.editLicenseNumOff.getText().toString());
        locationDB.setLiftsFacility(binding.editElevatorResponsibleOff.getText().toString());
        locationDB.setSaftyFacility(binding.editSafetyResponsibleOff.getText().toString());
        locationDB.setContractType(contractId);
        locationDB.setHajHousingLicense(binding.editHogagLicenseOff.getText().toString());
        locationDB.setElectricitySubscription(binding.editElectricityOff.getText().toString());
        locationDB.setFacilityId(facilityId);
        return locationDB;
        
    }
}