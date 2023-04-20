package com.example.baithuchanh.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.baithuchanh.Database;
import com.example.baithuchanh.R;
import com.example.baithuchanh.adapter.WorkAdapter;
import com.example.baithuchanh.model.Work;

import java.util.List;

public class Works_Fragment extends Fragment {
    private ListView lv;
    private WorkAdapter adapter;
    private List<Work> list;
    private Database db;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.works_fragment,container,false);
        lv = view.findViewById(R.id.lv);
        db = new Database(getContext());
        list = db.getWork();
        adapter= new WorkAdapter(getContext(),list);
        lv.setAdapter(adapter);
        return view;
    }

}
