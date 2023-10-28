/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.util.ArrayList;
import java.util.Scanner;
import model.GarbageStation;

/**
 *
 * @author QuaVi
 */

public class Library {
    private int[] garbageAtStations;
    private GarbageStation gs;
    private int costPerHour = 120000;
    private int dumpCost = 57000;
    private ArrayList<GarbageStation> garbageStations ;
    public Library(){
        garbageStations = new ArrayList<>();
        gs = new GarbageStation();
    }
        public void getInputGarbageStations() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the amount of garbage at each station (in kg) separated by spaces:");
        String[] input = scanner.nextLine().split(" ");
        garbageAtStations = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            garbageAtStations[i] = Integer.parseInt(input[i]);
            gs.setAmount(garbageAtStations[i]);
            garbageStations.add(gs);
        }
    } 
        public int  costCalculate() {
        int total = 0;
        double time = 0.0; // thời gian được tính bằng giờ
        int cost ;
        int truckCapacity = 10000; // 10 tấn
        int count = 0;
        
        for (int garbage : garbageAtStations) {
            time += 8.0 / 60.0; // đổi phút sang giờ

            if (total + garbage >= truckCapacity) {
                total = 0;
                time += 30.0 / 60.0; // đổi phút sang giờ khi xe chuyển về
                count++;
            }
            total=total+garbage;
        }

        // nếu còn rác thì quay lại trạm và tính thêm chi phí
        if (total > 0) {
            time += 30.0 / 60.0; // đổi phút sang giờ
            count++;
        }

        // Thêm chi phí đổ rác
        cost = count*dumpCost + (int)(time * costPerHour);
        // Làm tròn tiền đến 10 gần nhất
        cost = Math.round((cost + 5) / 10) * 10;
        return cost;
    }
    public void display() {
        int cost= costCalculate();
        System.out.println("The total cost is " + cost + " VND");
    }
}

