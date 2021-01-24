/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enum;

import java.util.Calendar;
/**
 *
 * @author Emilio Paez
 */
// assign a number of calender to week days as idDay
public enum Day {
    
    MON(Calendar.MONDAY,"MONDAY"), 
    TUE(Calendar.TUESDAY,"TUESDAY"), 
    WED(Calendar.WEDNESDAY,"WEDNESDAY"), 
    THU(Calendar.THURSDAY,"THURSDAY"), 
    FRI(Calendar.FRIDAY,"FRIDAY");
    
    private int idDay;
    private String name;

    private Day() {
    }

    private Day(int idDay, String name) {
        this.idDay = idDay;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdDay() {
        return idDay;
    }

    public void setIdDay(int idDay) {
        this.idDay = idDay;
    } 
}
