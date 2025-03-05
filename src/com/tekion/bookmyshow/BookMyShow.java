package com.tekion.bookmyshow;

import com.tekion.bookmyshow.service.DashboardService;

public class BookMyShow {
    public static void main(String[] args) {
        DashboardService dashboardService = new DashboardService();
        dashboardService.startBookMyShow();
    }
}
