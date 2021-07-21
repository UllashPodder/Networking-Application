
package com.example.networkingapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostManResponseModel {

    @SerializedName("json")
    @Expose
    private com.example.networkingapplication.model.Json json;
    @SerializedName("url")
    @Expose
    private String url;

    public com.example.networkingapplication.model.Json getJson() {
        return json;
    }

    public void setJson(com.example.networkingapplication.model.Json json) {
        this.json = json;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
