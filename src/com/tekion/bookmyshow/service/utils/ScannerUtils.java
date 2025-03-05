package com.tekion.bookmyshow.service.utils;

import java.util.Scanner;

public class ScannerUtils {
    public static final ScannerUtils INSTANCE = new ScannerUtils();
    private static final Scanner sc = new Scanner(System.in);

    private ScannerUtils() {
    }

    public static Scanner scanner() {
        return sc;
    }
}
