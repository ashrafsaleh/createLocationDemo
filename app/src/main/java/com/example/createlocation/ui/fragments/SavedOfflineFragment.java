package com.example.createlocation.ui.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.renderscript.ScriptGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.createlocation.R;
import com.example.createlocation.databinding.FragmentSavedOfflineBinding;
import com.example.createlocation.pojo.CreateLocationDB;
import com.example.createlocation.pojo.RoomDB;
import com.example.createlocation.ui.main.RecycleAdapter;

import java.util.List;


public class SavedOfflineFragment extends Fragment {
    View view;
    FragmentSavedOfflineBinding binding;
    RoomDB roomDB;
    RecycleAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_saved_offline, container, false);
        view = binding.getRoot();
        binding.savedRecycle.setLayoutManager(new LinearLayoutManager(getContext()));
        roomDB = RoomDB.getInstance(getContext());
        List<CreateLocationDB> viewData= roomDB.dao().getData();
        adapter = new RecycleAdapter(viewData);
        binding.savedRecycle.setAdapter(adapter);
        return view;
    }
}