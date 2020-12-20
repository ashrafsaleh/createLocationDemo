package com.example.createlocation.ui.main;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.createlocation.R;
import com.example.createlocation.pojo.CreateLocationDB;
import com.example.createlocation.pojo.FacilityModel;
import com.example.createlocation.pojo.LocationCategories;
import com.example.createlocation.pojo.RoomDB;
import com.example.createlocation.pojo.SafteyOffices;
import com.example.createlocation.ui.fragments.SavedOfflineFragment;

import java.util.ArrayList;
import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {
    List<CreateLocationDB> locationDBS;
    ArrayList<String> facilities = new ArrayList<>();
    ArrayList<String> contractTypes = new ArrayList<>();
    ArrayList<String> locationCat = new ArrayList<>();
    ArrayList<String> locationTypes = new ArrayList<>();
    ArrayList<String> locationStatus = new ArrayList<>();
    ArrayList<String> safetyOffices = new ArrayList<>();
    ArrayList<FacilityModel> facilityModels = new ArrayList<>();
    ArrayList<LocationCategories> categories = new ArrayList<>();
    ArrayList<SafteyOffices> offices = new ArrayList<>();
    View view;
    Bundle bundle;


    public RecycleAdapter(List<CreateLocationDB> locationDBS) {
        this.locationDBS = locationDBS;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         view = LayoutInflater.from(parent.getContext()).inflate(R.layout.saved_card,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.id.setText(String.valueOf(locationDBS.get(position).getId()));
        holder.name.setText(locationDBS.get(position).getName());
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateLocationDB createLocationDB = new CreateLocationDB();
                int id = locationDBS.get(position).getId();
                createLocationDB.setId(id);
                RoomDB.db.dao().deleteLocation(createLocationDB);
                AppCompatActivity activity = (AppCompatActivity)view.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.save_container,new SavedOfflineFragment(),null).commit();
            }
        });
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle = new Bundle();
                bundle.putInt("id", locationDBS.get(position).getId());
                bundle.putString("name",locationDBS.get(position).getName());
                bundle.putString("streetName",locationDBS.get(position).getStreetName());
                bundle.putString("setAddress",locationDBS.get(position).getAddressDescription());
                bundle.putString("buildingNum",locationDBS.get(position).getBuildingNo());
                bundle.putString("neighborhood",locationDBS.get(position).getNeighborhood());
                bundle.getInt("postCode",locationDBS.get(position).getPostalCode());
                bundle.putString("longitude",locationDBS.get(position).getLongitude());
                bundle.putString("latitude",locationDBS.get(position).getLatitude());
                bundle.putInt("safetyOffice",locationDBS.get(position).getSaftyOfficeId());
                bundle.putInt("locationCat",locationDBS.get(position).getLocationCategoryId());
                bundle.putInt("type",locationDBS.get(position).getType());
                bundle.putString("buildingLice",locationDBS.get(position).getConstructionLicenseNo());
                bundle.putString("touristLice",locationDBS.get(position).getTourismAuthorityLicenseNo());
                bundle.putString("duration",locationDBS.get(position).getWorkingHours());
                bundle.putString("guardName",locationDBS.get(position).getGuardName());
                bundle.putString("guardNum",locationDBS.get(position).getGuardMobile());
                bundle.putInt("status",locationDBS.get(position).getStatus());
                bundle.putString("reason",locationDBS.get(position).getClosureOrRemovalReasons());
                bundle.putString("officerName",locationDBS.get(position).getSafetyOfficerName());
                bundle.putString("officerNum",locationDBS.get(position).getSafetyOfficerMobile());
                bundle.putString("operator",locationDBS.get(position).getBuildingOperatorName());
                bundle.putString("owner",locationDBS.get(position).getBuildingOwnerName());
                bundle.putString("defenseLice",locationDBS.get(position).getCivilDefenseLicenseNo());
                bundle.putString("lifts",locationDBS.get(position).getLiftsFacility());
                bundle.putString("safetyFacility",locationDBS.get(position).getSaftyFacility());
                bundle.putInt("contractID",locationDBS.get(position).getContractType());
                bundle.putString("hojaj",locationDBS.get(position).getHajHousingLicense());
                bundle.putString("electricity",locationDBS.get(position).getElectricitySubscription());
                bundle.putInt("facilityID",locationDBS.get(position).getFacilityId());
                bundle.putStringArrayList("contractTypes",contractTypes);
                bundle.putStringArrayList("locationStatus",locationStatus);
                bundle.putStringArrayList("locationTypes",locationTypes);
                bundle.putSerializable("facilities", (ArrayList<FacilityModel>)facilityModels);
                bundle.putSerializable("categories", (ArrayList<LocationCategories>)categories);
                bundle.putSerializable("offices", (ArrayList<SafteyOffices>)offices);
                Navigation.findNavController(v).navigate(R.id.action_savedOfflineFragment_to_editOfflineFragment,bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return locationDBS.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,id;
        ImageButton edit,delete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.save_name);
            id = itemView.findViewById(R.id.save_id);
            edit = itemView.findViewById(R.id.save_update);
            delete = itemView.findViewById(R.id.saved_delete);
        }
    }


}
