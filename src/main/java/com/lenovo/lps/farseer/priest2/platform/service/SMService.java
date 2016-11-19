package com.lenovo.lps.farseer.priest2.platform.service;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.HttpException;

public interface SMService {
    boolean sendMessage(String ipAddr, String sendPhones, String context) throws IOException, HttpException, URISyntaxException;
}
