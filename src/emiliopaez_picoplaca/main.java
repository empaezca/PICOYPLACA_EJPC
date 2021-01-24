/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emiliopaez_picoplaca;

import Models.Predictor;
import Models.Car;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Emilio Paez
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String plateNumber = "";
        String date="";
        String time="";
        Boolean validator = true;
//validation of the input of the license plate
        do {
            try {
                System.out.println("Enter a License Plate as (PDB0555 o PDB555)");
                plateNumber = sc.nextLine();
                Car car = new Car(plateNumber);
                validator = true;
            } catch (InputMismatchException e) {
                validator=false;
                System.out.println("invalid License Plate");
            }
        } while (!validator);
        
//validation of the input of date
        do {
            try {
                System.out.println("Enter a date in format (dd-MM-yyyy)");
                date = sc.nextLine();
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                sdf.setLenient(false);
                sdf.parse(date);
                validator = true;
            } catch (ParseException ex) {
                validator=false;
                System.out.println("Wrong date input");
            }
        } while (!validator);
        
//validation of the input of time
        do {
            try {
                System.out.println("Enter time in 24 hour format (HH:mm)");
                time = sc.nextLine();
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                sdf.setLenient(false);
                sdf.parse(time);
                validator = true;
            } catch (ParseException ex) {
                validator=false;
                System.out.println("Wrong date input");
            }
        } while (!validator);
        Predictor predictor = new Predictor(plateNumber, date, time);
        predictor.excuteValidation();
    }
    
}
