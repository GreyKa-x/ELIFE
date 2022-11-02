package com.example.ecnuprevention.webservice.ResponseData;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class NotificationData {

    public NotificationData() {
        dataItems = new ArrayList<>();
    }

    @SerializedName("data_list")
    public List<Item> dataItems;

    public static class Item {

        @SerializedName("image_url")
        public String imageUrl;

        @SerializedName("title")
        public String title;

        @SerializedName("text")
        public String text;
    }
}
