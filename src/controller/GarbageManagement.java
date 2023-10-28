/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import common.Library;
import view.Menu;


/**
 *
 * @author QuaVi
 */

public class GarbageManagement extends Menu<String>{
    Library lb;
    static String[] options = {"Input", "Print", "Exit"};
    public GarbageManagement() {
        super("===== COLLECTING GARBAGE MANAGEMENT =====", options);
        lb = new Library();
    }

    @Override
    public void execute(int n) {
        switch(n) {
            case 1 -> lb.getInputGarbageStations();
            case 2 -> lb.display();
            case 3 -> System.exit(0);
        }
    }
  
}





