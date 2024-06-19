package com.example.demo_lesson_OENk5IE5Et37.utils;

import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;

@Component
public class GeneralUtils {

  private HttpServletRequest httpServletRequest;

  public GeneralUtils(HttpServletRequest httpServletRequest) {
    super();
    this.httpServletRequest = httpServletRequest;
  }

  public String DateTime() {
    SimpleDateFormat waktu = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    waktu.setTimeZone(TimeZone.getDefault());

    return waktu.format(new Date());
  }

  public String GeneratingRandomAlphanumeric() {
    int leftLimit = 48;
    int rightLimit = 122;
    int targetStringLength = 40;
    Random random = new Random();

    String generatedString = random.ints(leftLimit, rightLimit + 1)
      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
      .limit(targetStringLength)
      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
      .toString();

    return generatedString;
  }

  public String getIPAddress(){
    String ipAddress = httpServletRequest.getHeader("X-Forwarded-For");
    if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
        ipAddress = httpServletRequest.getRemoteAddr();
    }
    return ipAddress;
  }

}