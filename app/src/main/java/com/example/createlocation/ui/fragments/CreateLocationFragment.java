package com.example.createlocation.ui.fragments;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.createlocation.R;
import com.example.createlocation.data.ApiClient;
import com.example.createlocation.databinding.FragmentCreateLocationBinding;
import com.example.createlocation.databinding.FragmentLoginBinding;
import com.example.createlocation.pojo.CreateLocationModel;
import com.example.createlocation.pojo.CreateLocationResponse;
import com.example.createlocation.pojo.FacilityModel;
import com.example.createlocation.pojo.GetAllDropDown;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CreateLocationFragment extends Fragment {
    View view;
    int facilityId,contractId,catId,typeId,statusId,safId;
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
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_create_location,container,false);
        token = getArguments().getString("token");
        Toast.makeText(getContext(), token, Toast.LENGTH_SHORT).show();
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
        binding.confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  if(binding.name.getText().toString().isEmpty()||binding.streetName.getText().toString().isEmpty()||binding.address.getText().toString().isEmpty()
                ||binding.buildingNumber.getText().toString().isEmpty()||binding.buildingWorker.getText().toString().isEmpty()||binding.buildingOwner.getText().toString().isEmpty()
                ||binding.licenseNum.getText().toString().isEmpty()||binding.reason.getText().toString().isEmpty()||Integer.getInteger(binding.postCode.getText().toString()) == null
                ||binding.buildingLicense.getText().toString().isEmpty()||binding.electricity.getText().toString().isEmpty()||binding.guardNum.getText().toString().isEmpty()
                ||binding.guardName.getText().toString().isEmpty()||binding.hogagLicense.getText().toString().isEmpty()||binding.latitude.getText().toString().isEmpty()
                ||binding.elevatorResponsible.getText().toString().isEmpty()||binding.longitude.getText().toString().isEmpty()||binding.neighborhood.getText().toString().isEmpty()
                ||binding.responsibleNum.getText().toString().isEmpty()||binding.responsible.getText().toString().isEmpty()||binding.safetyResponsible.getText().toString().isEmpty()
                ||binding.durationWork.getText().toString().isEmpty()||binding.touristLicense.getText().toString().isEmpty()){
                    Toast.makeText(getContext(), "Please fill all fields", Toast.LENGTH_SHORT).show();
                }*/
                CreateLocationModel createLocationModel = new CreateLocationModel();
                createLocationModel.setName(binding.name.getText().toString());
                createLocationModel.setStreetName(binding.streetName.getText().toString());
                createLocationModel.setAddressDescription(binding.address.getText().toString());
                createLocationModel.setBuildingNo(binding.buildingNumber.getText().toString());
                createLocationModel.setNeighborhood(binding.neighborhood.getText().toString());
                createLocationModel.setPostalCode(Integer.parseInt(binding.postCode.getText().toString()));
                createLocationModel.setLongitude(binding.longitude.getText().toString());
                createLocationModel.setLatitude(binding.latitude.getText().toString());
                createLocationModel.setSaftyOfficeId(safId);
                createLocationModel.setLocationCategoryId(catId);
                createLocationModel.setType(typeId);
                createLocationModel.setConstructionLicenseNo(binding.buildingLicense.getText().toString());
                createLocationModel.setTourismAuthorityLicenseNo(binding.touristLicense.getText().toString());
                createLocationModel.setWorkingHours(binding.durationWork.getText().toString());
                createLocationModel.setGuardName(binding.guardName.getText().toString());
                createLocationModel.setGuardMobile(binding.guardNum.getText().toString());
                createLocationModel.setStatus(statusId);
                createLocationModel.setRecordStatus(2);
                createLocationModel.setLastModifiedDate("2023-06-10T00:00:00");
                createLocationModel.setClosureOrRemovalReasons(binding.reason.getText().toString());
                createLocationModel.setSafetyOfficerName(binding.responsible.getText().toString());
                createLocationModel.setSafetyOfficerMobile(binding.responsibleNum.getText().toString());
                createLocationModel.setBuildingOperatorName(binding.buildingWorker.getText().toString());
                createLocationModel.setBuildingOwnerName(binding.buildingOwner.getText().toString());
                createLocationModel.setCivilDefenseLicenseNo(binding.licenseNum.getText().toString());
                createLocationModel.setLiftsFacility(binding.elevatorResponsible.getText().toString());
                createLocationModel.setSaftyFacility(binding.safetyResponsible.getText().toString());
                createLocationModel.setContractType(contractId);
                createLocationModel.setHajHousingLicense(binding.hogagLicense.getText().toString());
                createLocationModel.setElectricitySubscription(binding.electricity.getText().toString());
                createLocationModel.setFacilityId(facilityId);
                posData(createLocationModel);

            }
        });
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
                    binding.firstSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            facilityId = response.body().get(binding.firstSpinner.getSelectedItemPosition()).getId();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

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
                        binding.contractSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                contractId = parent.getSelectedItemPosition()+1;
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                    }
                    for(int i = 0;i<response.body().getLocationCategories().size();i++){
                        locationCat.add(response.body().getLocationCategories().get(i).getName());
                        ArrayAdapter catAdapter = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item, locationCat);
                        catAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        binding.contractKindSpinner.setAdapter(catAdapter);
                        binding.contractKindSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                catId = response.body().getLocationCategories().get(binding.contractSpinner.getSelectedItemPosition()).getId();
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                    }

                    for(int i = 0;i<response.body().getLocationTypes().size();i++){
                        locationTypes.add(response.body().getLocationTypes().get(i));
                        ArrayAdapter typeAdapter = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item, locationTypes);
                        typeAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        binding.trainSpinner.setAdapter(typeAdapter);
                        binding.trainSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                typeId = parent.getSelectedItemPosition()+1;
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                    }
                    for(int i = 0;i<response.body().getLocationStatus().size();i++){
                        locationStatus.add(response.body().getLocationStatus().get(i));
                        ArrayAdapter statusAdapter = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item, locationStatus);
                        statusAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        binding.signerSpinner.setAdapter(statusAdapter);
                        binding.signerSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                statusId = parent.getSelectedItemPosition()+1;
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                    }
                    for(int i = 0;i<response.body().getSaftyOffices().size();i++){
                        safetyOffices.add(response.body().getSaftyOffices().get(i).getName());
                        ArrayAdapter safetyAdapter = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item, safetyOffices);
                        safetyAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        binding.safeSpinner.setAdapter(safetyAdapter);
                        binding.safeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                safId = response.body().getSaftyOffices().get(binding.safeSpinner.getSelectedItemPosition()).getId();
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                    }

                }
            }

            @Override
            public void onFailure(Call<GetAllDropDown> call, Throwable t) {

            }
        });
    }
    public void posData(CreateLocationModel createLocationModel){

        Call<CreateLocationResponse> call = ApiClient.getApiInterface().postData(createLocationModel);
        call.enqueue(new Callback<CreateLocationResponse>() {
            @Override
            public void onResponse(Call<CreateLocationResponse> call, Response<CreateLocationResponse> response) {
                if(response.isSuccessful())
                Toast.makeText(getContext(), "Data saved successfully", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getContext(), "Not saved", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onFailure(Call<CreateLocationResponse> call, Throwable t) {
                Toast.makeText(getContext(), "failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}