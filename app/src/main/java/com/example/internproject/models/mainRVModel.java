package com.example.internproject.models;

import java.util.List;

public class mainRVModel {
    private String moduleName;
    private List<videoDetails> moduleItems;

    public String getModuleName() {
        return moduleName;
    }

    public List<videoDetails> getModuleItems() {
        return moduleItems;
    }

    public mainRVModel(String moduleName, List<videoDetails> moduleItems) {
        this.moduleName = moduleName;
        this.moduleItems = moduleItems;
    }
}
