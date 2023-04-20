package com.example.baithuchanh.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.baithuchanh.R;
import com.example.baithuchanh.model.Work;

import org.w3c.dom.Text;

import java.util.List;

public class WorkAdapter extends ArrayAdapter<Work> {
    private Context context;
    private List<Work> wList;

    public WorkAdapter(@NonNull Context context, List<Work> wList) {
        super(context, R.layout.work_item,wList);
        this.context=context;
        this.wList=wList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.work_item,null);
        TextView tName = view.findViewById(R.id.tName);
        TextView tDes = view.findViewById(R.id.tDes);
        TextView tStatus = view.findViewById(R.id.tStatus);
        TextView tCollab = view.findViewById(R.id.tCollab);
        Work t = wList.get(position);
        tName.setText(t.getId()+"-"+t.getName());
        tDes.setText("Description: " +t.getDescription());
        tStatus.setText("Status: " +t.getStatus());
        tCollab.setText("Collaboration: " + t.isCollaboration());
        return view;
    }

    public Work getItem(int position){
        return wList.get(position);
    }
}
