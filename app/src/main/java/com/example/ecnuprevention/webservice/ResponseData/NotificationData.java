package com.example.ecnuprevention.webservice.ResponseData;

import java.util.List;

public class NotificationData {

    public List<Item> dataItems;

    public static class Item {
        public String imageUrl;
        public String title;
        public String text;
    }
}
