package com.example.createlocation.ui.main;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.createlocation.R;
import com.example.createlocation.pojo.CreateLocationDB;
import com.example.createlocation.pojo.RoomDB;
import com.example.createlocation.ui.fragments.SavedOfflineFragment;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {
    List<CreateLocationDB> locationDBS;


    public RecycleAdapter(List<CreateLocationDB> locationDBS) {
        this.locationDBS = locationDBS;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.saved_card,parent,false);
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

            }
        });
    }

    @Override
    public int getItemCount() {
        return locationDBS.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,id;
        ImageButton edit,preview,delete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.save_name);
            id = itemView.findViewById(R.id.save_id);
            edit = itemView.findViewById(R.id.save_update);
            preview = itemView.findViewById(R.id.save_view);
            delete = itemView.findViewById(R.id.saved_delete);
        }
    }


}
