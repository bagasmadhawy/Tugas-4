package com.example.setelahgagal;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private RecyclerView rvUlar;
    private ArrayList<ModelUlar> listUlar = new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvUlar = view.findViewById(R.id.fragment_home_ular);
        rvUlar.setHasFixedSize(true);
        listUlar.addAll(DataUlar.getUlarList());

        showRecyclerList();
    }

    private void showRecyclerList() {
        rvUlar.setLayoutManager(new LinearLayoutManager(getActivity()));
        AdapterUlar adapterUlar = new AdapterUlar(DataUlar.getUlarList(), getActivity());
        rvUlar.setAdapter(adapterUlar);
    }

}
