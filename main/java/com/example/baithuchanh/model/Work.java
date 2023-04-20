package com.example.baithuchanh.model;

import android.text.Editable;

public class Work {
    private int id;
    private String name;
    private String description;
    private String status;
    private boolean collaboration;

    public Work(Editable text, Editable eDesText, Editable eStatusText, boolean checked) {
    }

    public Work(int id, String name, String description, String status, boolean collaboration) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.collaboration = collaboration;
    }

    public Work(String name, String description, String status, boolean collaboration) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.collaboration = collaboration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isCollaboration() {
        return collaboration;
    }

    public void setCollaboration(boolean collaboration) {
        this.collaboration = collaboration;
    }
}
