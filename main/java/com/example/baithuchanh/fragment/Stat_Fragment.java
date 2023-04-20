package com.example.baithuchanh.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;

import com.example.baithuchanh.Database;
import com.example.baithuchanh.R;
import com.example.baithuchanh.adapter.WorkAdapter;
import com.example.baithuchanh.model.Work;

import java.util.List;

public class Stat_Fragment extends Fragment {
    private SearchView search;
    private Database db;
    private ListView listView;
    private WorkAdapter adapter;
    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.stat_fragment,container,false);
        search = view.findViewById(R.id.search);
        listView = view.findViewById(R.id.listView);
        db = new Database(getContext());
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String key) {
                List<Work> list = db.searchWorkByName(key);
                adapter = new WorkAdapter(getContext(),list);
                listView.setAdapter(adapter);
                return true;
            }
        });

        return view;
    }
}
