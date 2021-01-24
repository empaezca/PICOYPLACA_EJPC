/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Enum.Day;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
/**
 *
 * @author Emilio Paez
 */
public class Predictor {

    private String licencePlateNumber;
    private String date;
    private String time;
    private Boolean valid;

    public Predictor(String licencePlateNumber, String date, String time) {
        this.licencePlateNumber = licencePlateNumber;
        this.date = date;
        this.time = time;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public String getLicencePlateNumber() {
        return licencePlateNumber;
    }

    public void setLicencePlateNumber(String licencePlateNumber) {
        this.licencePlateNumber = licencePlateNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

//join the input of date and time to create one simple date format
    public Calendar getDateTime() {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Calendar dateTime = null;
        try {
            dateTime = Calendar.getInstance();
            dateTime.setTime(format.parse(this.date + " " + this.time));
        } catch (ParseException e) {

        }

        return dateTime;
    }
//validates if the user has pico y placa or not
    public Boolean excuteValidation() {
        int lastDigit = Integer.parseInt(
                this.licencePlateNumber.substring(
                        this.licencePlateNumber.length() - 1,
                        this.licencePlateNumber.length())
        );

        for (PicoPlaca value : getPicoPlacaData()) {
            Boolean valid = value.isInPicoPlaca(
                    this.getDateTime().get(Calendar.DAY_OF_WEEK),
                    lastDigit,
                    this.getDateTime());

            if (valid) {
                this.valid=true;
                System.out.println(toString());
                return this.valid;
            }
        }
        
        this.valid = false;
        System.out.println(toString());
        return this.valid;

    }
//create the rules of pico y placa as the user need 
    private  List<PicoPlaca> getPicoPlacaData() {
        List<PicoPlaca> returnList = new ArrayList<>();
        returnList.add(new PicoPlaca(Day.MON,
                new Schedule(
                        createSchedule(7, 0, 0),
                        createSchedule(9, 30, 0)
                ),
                new ArrayList<>(Arrays.asList(1, 2))));
        returnList.add(new PicoPlaca(Day.MON,
                new Schedule(
                        createSchedule(16, 0, 0),
                        createSchedule(19, 30, 0)
                ),
                new ArrayList<>(Arrays.asList(1, 2))));
        returnList.add(new PicoPlaca(Day.TUE,
                new Schedule(
                        createSchedule(7, 0, 0),
                        createSchedule(9, 30, 0)
                ),
                new ArrayList<>(Arrays.asList(3, 4))));
        returnList.add(new PicoPlaca(Day.TUE,
                new Schedule(
                        createSchedule(16, 0, 0),
                        createSchedule(19, 30, 0)
                ),
                new ArrayList<>(Arrays.asList(3, 4))));
        returnList.add(new PicoPlaca(Day.WED,
                new Schedule(
                        createSchedule(7, 0, 0),
                        createSchedule(9, 30, 0)
                ),
                new ArrayList<>(Arrays.asList(5, 6))));
        returnList.add(new PicoPlaca(Day.WED,
                new Schedule(
                        createSchedule(16, 0, 0),
                        createSchedule(19, 30, 0)
                ),
                new ArrayList<>(Arrays.asList(5, 6))));
        returnList.add(new PicoPlaca(Day.THU,
                new Schedule(
                        createSchedule(7, 0, 0),
                        createSchedule(9, 30, 0)
                ),
                new ArrayList<>(Arrays.asList(7, 8))));
        returnList.add(new PicoPlaca(Day.THU,
                new Schedule(
                        createSchedule(16, 0, 0),
                        createSchedule(19, 30, 0)
                ),
                new ArrayList<>(Arrays.asList(7, 8))));
        returnList.add(new PicoPlaca(Day.FRI,
                new Schedule(
                        createSchedule(7, 0, 0),
                        createSchedule(9, 30, 0)
                ),
                new ArrayList<>(Arrays.asList(9, 0))));
        returnList.add(new PicoPlaca(Day.FRI,
                new Schedule(
                        createSchedule(16, 0, 0),
                        createSchedule(19, 30, 0)
                ),
                new ArrayList<>(Arrays.asList(9, 0))));

        return returnList;
    }
//creates a schedule to print on the users screen
    private static Calendar createSchedule(int hour, int minute, int second) {
        Calendar time = Calendar.getInstance();
        time.set(Calendar.HOUR_OF_DAY, hour);
        time.set(Calendar.MINUTE, minute);
        time.set(Calendar.SECOND, second);
        time.set(Calendar.MILLISECOND, 0);
        return time;
    }
//print if the user con by on the road or not
    @Override
    public String toString() {
        return "Plate: "+this.licencePlateNumber
                +"\nDate y Time: " + this.date 
                + " " + this.time
                +"\nDoes it have pico y placa? " 
                + (this.valid ? " Yes it Does": " No it Doesn't")
                +"\nCan my car be on the Road? " 
                + (this.valid ? "No it can't": " Yes it can");
    }
    
}
