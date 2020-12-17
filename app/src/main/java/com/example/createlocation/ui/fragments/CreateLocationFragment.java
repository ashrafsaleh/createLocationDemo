package com.example.createlocation.ui.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Parcelable;
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
import com.example.createlocation.pojo.CreateLocationDB;
import com.example.createlocation.pojo.CreateLocationModel;
import com.example.createlocation.pojo.CreateLocationResponse;
import com.example.createlocation.pojo.FacilityModel;
import com.example.createlocation.pojo.GetAllDropDown;
import com.example.createlocation.pojo.LocationCategories;
import com.example.createlocation.pojo.RoomDB;
import com.example.createlocation.pojo.SafteyOffices;
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
    ArrayList<FacilityModel> facilityModels = new ArrayList<>();
    ArrayList<LocationCategories> categories = new ArrayList<>();
    ArrayList<SafteyOffices> offices = new ArrayList<>();
    ArrayList<Integer> facId = new ArrayList<>();
    String token,vv;
    RoomDB roomDB;
    int editID,index;
    Bundle bundle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_create_location,container,false);
        token = getArguments().getString("token");
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
        getFacilities();
        getAllDropDown();
        binding.confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.name.getText().toString().isEmpty()||binding.streetName.getText().toString().isEmpty()||binding.address.getText().toString().isEmpty()
                ||binding.buildingNumber.getText().toString().isEmpty()||binding.neighborhood.getText().toString().isEmpty()||Integer.parseInt(binding.postCode.getText().toString())==0
                ||binding.longitude.getText().toString().isEmpty() ||binding.latitude.getText().toString().isEmpty()||safId==0||catId==0||typeId==0
                ||binding.buildingLicense.getText().toString().isEmpty()||binding.touristLicense.getText().toString().isEmpty()||binding.durationWork.getText().toString().isEmpty()
                ||binding.guardName.getText().toString().isEmpty()||binding.guardNum.getText().toString().isEmpty()||statusId==0||binding.reason.getText().toString().isEmpty()
                ||binding.responsible.getText().toString().isEmpty()||binding.responsibleNum.getText().toString().isEmpty()||binding.buildingWorker.getText().toString().isEmpty()
                ||binding.buildingOwner.getText().toString().isEmpty()||binding.licenseNum.getText().toString().isEmpty()||binding.elevatorResponsible.getText().toString().isEmpty()
                ||binding.safetyResponsible.getText().toString().isEmpty()||contractId==0||binding.hogagLicense.getText().toString().isEmpty()
                ||binding.electricity.getText().toString().isEmpty()||facilityId==0
                ){
                    Toast.makeText(getContext(), "Please fill all fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    if (!isConnected()){
                        Toast.makeText(getContext(), "you are offline your data will be saved until to be connected", Toast.LENGTH_SHORT).show();
                        CreateLocationDB createLocationModel = new CreateLocationDB();
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
                        roomDB.dao().insertData(createLocationModel);
                    }
                    else {
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
                }

            }
        });

        return view;
    }
    public void getFacilities(){
        Call<List<FacilityModel>> call = ApiClient.getApiInterface("").getFacilities();
        call.enqueue(new Callback<List<FacilityModel>>() {
            @Override
            public void onResponse(Call<List<FacilityModel>> call, Response<List<FacilityModel>> response) {
                for (int i =0;i<response.body().size();i++){
                    facilityModels.add(response.body().get(i));
                    facilities.add(response.body().get(i).getName());
                    facId.add(response.body().get(i).getId());
                    ArrayAdapter adapter = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item,facilities);
                    adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                    binding.firstSpinner.setAdapter(adapter);
                    binding.firstSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            facilityId = response.body().get(binding.firstSpinner.getSelectedItemPosition()).getId();
                            index = binding.firstSpinner.getSelectedItemPosition();
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
        Call <GetAllDropDown> call = ApiClient.getApiInterface("").getDropDown();
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
                        categories.add(response.body().getLocationCategories().get(i));
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
                        offices.add(response.body().getSaftyOffices().get(i));
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

        Call<CreateLocationResponse> call = ApiClient.getApiInterface(token).postData(createLocationModel);
        call.enqueue(new Callback<CreateLocationResponse>() {
            @Override
            public void onResponse(Call<CreateLocationResponse> call, Response<CreateLocationResponse> response) {
                if(response.isSuccessful()) {
                    Toast.makeText(getContext(), "Data saved successfully", Toast.LENGTH_SHORT).show();
                   editID = response.body().getResult();
                    bundle = new Bundle();
                    bundle.putString("token",token);
                    bundle.putInt("id", editID);
                    bundle.putString("name",response.body().getLoc().getName());
                    bundle.putString("streetName",response.body().getLoc().getStreetName());
                    bundle.putString("setAddress",response.body().getLoc().getAddressDescription());
                    bundle.putString("buildingNum",response.body().getLoc().getBuildingNo());
                    bundle.putString("neighborhood",response.body().getLoc().getNeighborhood());
                    bundle.getInt("postCode",response.body().getLoc().getPostalCode());
                    bundle.putString("longitude",response.body().getLoc().getLongitude());
                    bundle.putString("latitude",response.body().getLoc().getLatitude());
                    bundle.putInt("safetyOffice",safId);
                    bundle.putInt("locationCat",catId);
                    bundle.putInt("type",typeId);
                    bundle.putString("buildingLice",response.body().getLoc().getConstructionLicenseNo());
                    bundle.putString("touristLice",response.body().getLoc().getTourismAuthorityLicenseNo());
                    bundle.putString("duration",response.body().getLoc().getWorkingHours());
                    bundle.putString("guardName",response.body().getLoc().getGuardName());
                    bundle.putString("guardNum",response.body().getLoc().getGuardMobile());
                    bundle.putInt("status",statusId);
                    bundle.putString("reason",response.body().getLoc().getClosureOrRemovalReasons());
                    bundle.putString("officerName",response.body().getLoc().getSafetyOfficerName());
                    bundle.putString("officerNum",response.body().getLoc().getSafetyOfficerMobile());
                    bundle.putString("operator",response.body().getLoc().getBuildingOperatorName());
                    bundle.putString("owner",response.body().getLoc().getBuildingOwnerName());
                    bundle.putString("defenseLice",response.body().getLoc().getCivilDefenseLicenseNo());
                    bundle.putString("lifts",response.body().getLoc().getLiftsFacility());
                    bundle.putString("safetyFacility",response.body().getLoc().getSaftyFacility());
                    bundle.putInt("contractID",contractId);
                    bundle.putString("hojaj",response.body().getLoc().getHajHousingLicense());
                    bundle.putString("electricity",response.body().getLoc().getElectricitySubscription());
                    bundle.putInt("facilityID",facilityId);
                    bundle.putInt("index",index);
                    bundle.putStringArrayList("contractTypes",contractTypes);
                    bundle.putStringArrayList("locationStatus",locationStatus);
                    bundle.putStringArrayList("locationTypes",locationTypes);
                    bundle.putSerializable("facilities", (ArrayList<FacilityModel>)facilityModels);
                    bundle.putSerializable("categories", (ArrayList<LocationCategories>)categories);
                    bundle.putSerializable("offices", (ArrayList<SafteyOffices>)offices);
                    Navigation.findNavController(view).navigate(R.id.action_createLocationFragment_to_editLocationFragment,bundle);

                }
                else
                    Toast.makeText(getContext(), "Not saved", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onFailure(Call<CreateLocationResponse> call, Throwable t) {
                Toast.makeText(getContext(), "failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private boolean isConnected (){
        ConnectivityManager connectivityManager = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobileInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if((wifiInfo !=null && wifiInfo.isConnected()) || (mobileInfo !=null && mobileInfo.isConnected()))
            return true;
        else
            return false;

    }
}