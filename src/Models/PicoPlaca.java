/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Enum.Day;
import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Emilio Paez
 */
public class PicoPlaca {
    private Day day;
    private Schedule schedule;
    private List<Integer> lastDigit;

    public PicoPlaca() {
    }

    public PicoPlaca(Day day, Schedule schedule, ArrayList<Integer> lastDigit) {
        this.day = day;
        this.schedule = schedule;
        this.lastDigit = lastDigit;
    }

    public List<Integer> getLastDigit() {
        return lastDigit;
    }

    public void setLastDigit(ArrayList<Integer> lastDigit) {
        this.lastDigit = lastDigit;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
    
    public Boolean isInPicoPlaca(int day, int lastDigit, Calendar time){
        return this.day.getIdDay() == day && this.lastDigit.contains(lastDigit) && 
                this.schedule.isInPicoPlaca(time);
    }
    
}
