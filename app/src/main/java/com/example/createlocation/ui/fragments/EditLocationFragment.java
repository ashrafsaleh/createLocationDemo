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
import com.example.createlocation.data.ApiClient;
import com.example.createlocation.databinding.FragmentEditLocationBinding;
import com.example.createlocation.pojo.EditLocationModel;
import com.example.createlocation.pojo.FacilityModel;
import com.example.createlocation.pojo.LocationCategories;
import com.example.createlocation.pojo.SafteyOffices;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditLocationFragment extends Fragment {
    FragmentEditLocationBinding binding;
    View view;
    int id,postCode,safId,catId,typeId,statusId,contractId,facilityId,index,conId2,statusId2,typeId2,facId2,catId2,safId2;
    String name,streetName,address,buildingNum,neighborhood,longitude,latitude,buildingLice,touristLice,
            duration,guardName,guardNum,reason,officerName,officerNum,operator,owner,defenseLice,lifts,
            safetyFacility,hojaj,electricity,token;
    ArrayList<String> facilities = new ArrayList<>();
    ArrayList<String> contractTypes = new ArrayList<>();
    ArrayList<String> locationCat = new ArrayList<>();
    ArrayList<String> locationTypes = new ArrayList<>();
    ArrayList<String> locationStatus = new ArrayList<>();
    ArrayList<String> safetyOffices = new ArrayList<>();
    ArrayList<FacilityModel> facilityModels = new ArrayList<>();
    ArrayList<LocationCategories> categories = new ArrayList<>();
    ArrayList<SafteyOffices> offices = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_edit_location, container, false);
        view = binding.getRoot();
        token = getArguments().getString("token");
        setValue();
        viewData();

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
        binding.editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getRequest(editData());
            }
        });
        return view;
    }
    public void setValue(){
        index = getArguments().getInt("index");
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
        contractTypes = getArguments().getStringArrayList("contractTypes");
        locationStatus = getArguments().getStringArrayList("locationStatus");
        locationTypes = getArguments().getStringArrayList("locationTypes");
        facilityModels = ((ArrayList<FacilityModel>) getArguments().getSerializable("facilities"));
        categories = (ArrayList<LocationCategories>)getArguments().getSerializable("categories");
        offices = (ArrayList<SafteyOffices>)getArguments().getSerializable("offices");
        for(int i=0;i<facilityModels.size();i++){
            facilities.add(facilityModels.get(i).getName());
        }
        for(int i=0;i<categories.size();i++){
            locationCat.add(categories.get(i).getName());
        }
        for(int i=0;i<offices.size();i++){
            safetyOffices.add(offices.get(i).getName());
        }
    }
    public void viewData(){
        binding.editName.setText(name);
        binding.editStreetName.setText(streetName);
        binding.editAddress.setText(address);
        binding.editBuildingNumber.setText(buildingNum);
        binding.editNeighborhood.setText(neighborhood);
        binding.editPostCode.setText(String.valueOf(postCode));
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
       ArrayAdapter facAdapter = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item,facilities);
        facAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        binding.editFirstSpinner.setAdapter(facAdapter);
        binding.editFirstSpinner.setSelection(index);
        binding.editFirstSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                facId2 = facilityModels.get(binding.editFirstSpinner.getSelectedItemPosition()).getId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter cAdapter = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item,contractTypes);
        cAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        binding.editContractSpinner.setAdapter(cAdapter);
        binding.editContractSpinner.setSelection(contractId-1);
        binding.editContractSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                conId2 = parent.getSelectedItemPosition()+1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter locAdapter = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item,locationCat);
        locAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        binding.editContractKindSpinner.setAdapter(locAdapter);
        binding.editContractKindSpinner.setSelection(catId-1);
        binding.editContractSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                catId2 = categories.get(binding.editContractKindSpinner.getSelectedItemPosition()).getId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter typeAdapter = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item,locationTypes);
        typeAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        binding.editTrainSpinner.setAdapter(typeAdapter);
        binding.editTrainSpinner.setSelection(typeId-1);
        binding.editTrainSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                typeId = parent.getSelectedItemPosition()+1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter staAdapter = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item,locationStatus);
        staAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        binding.editSignerSpinner.setAdapter(staAdapter);
        binding.editSignerSpinner.setSelection(statusId-1);
        binding.editSignerSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                statusId = parent.getSelectedItemPosition()+1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter safAdapter = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item,safetyOffices);
        safAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        binding.editSafeSpinner.setAdapter(safAdapter);
        binding.editSafeSpinner.setSelection(safId-1);
        binding.editSafeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                safId2 = offices.get(binding.editSafeSpinner.getSelectedItemPosition()).getId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public EditLocationModel editData(){
        EditLocationModel editLocationModel = new EditLocationModel();
        editLocationModel.setId(id);
        editLocationModel.setName(binding.editName.getText().toString());
        editLocationModel.setStreetName(binding.editStreetName.getText().toString());
        editLocationModel.setAddressDescription(binding.editAddress.getText().toString());
        editLocationModel.setBuildingNo(binding.editBuildingNumber.getText().toString());
        editLocationModel.setNeighborhood(binding.editNeighborhood.getText().toString());
        editLocationModel.setPostalCode(Integer.parseInt(binding.editPostCode.getText().toString()));
        editLocationModel.setLongitude(binding.editLongitude.getText().toString());
        editLocationModel.setLatitude(binding.editLatitude.getText().toString());
        if(safId == safId2)
            editLocationModel.setSaftyOfficeId(safId);
        else
            editLocationModel.setSaftyOfficeId(safId2);
        if(catId == catId2)
            editLocationModel.setLocationCategoryId(catId);
        else
            editLocationModel.setLocationCategoryId(catId2);
        if(typeId == typeId2)
            editLocationModel.setType(typeId);
        else
            editLocationModel.setType(typeId2);
        editLocationModel.setConstructionLicenseNo(binding.editBuildingLicense.getText().toString());
        editLocationModel.setTourismAuthorityLicenseNo(binding.editTouristLicense.getText().toString());
        editLocationModel.setWorkingHours(binding.editDurationWork.getText().toString());
        editLocationModel.setGuardName(binding.editGuardName.getText().toString());
        editLocationModel.setGuardMobile(binding.editGuardNum.getText().toString());
        if(statusId==statusId2)
            editLocationModel.setStatus(statusId);
        else
            editLocationModel.setStatus(statusId2);
        editLocationModel.setRecordStatus(2);
        editLocationModel.setLastModifiedDate("2023-06-10T00:00:00");
        editLocationModel.setClosureOrRemovalReasons(binding.editReason.getText().toString());
        editLocationModel.setSafetyOfficerName(binding.editResponsible.getText().toString());
        editLocationModel.setSafetyOfficerMobile(binding.editResponsibleNum.getText().toString());
        editLocationModel.setBuildingOperatorName(binding.editBuildingWorker.getText().toString());
        editLocationModel.setBuildingOwnerName(binding.editBuildingOwner.getText().toString());
        editLocationModel.setCivilDefenseLicenseNo(binding.editLicenseNum.getText().toString());
        editLocationModel.setLiftsFacility(binding.editElevatorResponsible.getText().toString());
        editLocationModel.setSaftyFacility(binding.editSafetyResponsible.getText().toString());
        if(contractId == conId2)
            editLocationModel.setContractType(contractId);
        else
            editLocationModel.setContractType(conId2);
        editLocationModel.setHajHousingLicense(binding.editHogagLicense.getText().toString());
        editLocationModel.setElectricitySubscription(binding.editElectricity.getText().toString());
        if(facilityId == facId2)
            editLocationModel.setFacilityId(facilityId);
        else
            editLocationModel.setFacilityId(facId2);
        return editLocationModel;
    }
    public void getRequest( EditLocationModel editLocationModel) {
        Call<Boolean> call = ApiClient.getApiInterface(token).getRequest(editLocationModel);
        call.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if (response.isSuccessful()){
                    Toast.makeText(getContext(), "Your Data updated successfully"+ response.body().booleanValue(), Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getContext(), "something wrong", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {

            }
        });
    }
}