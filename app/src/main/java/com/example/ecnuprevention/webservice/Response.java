package com.example.ecnuprevention.webservice;

import com.google.gson.annotations.SerializedName;

public class Response<T> {
    @SerializedName("code")
    public int code;

    @SerializedName("message")
    public String message;

    @SerializedName("data")
    public T data;

}


