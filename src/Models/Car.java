/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author Emilio Paez
 */
public class Car {
    private String licencePlateNumber;

    public Car(String licencePlateNumber) {
        if (validateLicencePlateNumber(licencePlateNumber)) {
            this.licencePlateNumber = licencePlateNumber;
        } else {
            throw new InputMismatchException(
                    "The string is not a valid licence plate number");
        }
    }

    public String getLicencePlateNumber() {
        return licencePlateNumber;
    }

    public void setLicencePlateNumber(String licencePlateNumber) {
        this.licencePlateNumber = licencePlateNumber;
    }
    
    /**
     * @parameter licencePlateNumber it is the string to validate
     * @return boolean return true if it is a valid plate or false if its not
     * valid
     */
    //validate the license plate by creating a regular expresion that 
    //need to fins 3 letter and 3 or 4 numbers
    private boolean validateLicencePlateNumber(String licencePlateNumber) {
        String regularExpression = "[A-Za-z]{3}\\d{3,4}";
        Pattern pattern = Pattern.compile(regularExpression);
        Matcher matcher = pattern.matcher(licencePlateNumber);
        return matcher.matches();
    }

    /**
     * this method returns the last digit of the license plate
     * by using substring and turn in it to integer
     */
    public int getLicencePlateNumberLastDigit() {
        return Integer.parseInt(this.licencePlateNumber.substring(
                this.licencePlateNumber.length() - 1, 
                this.licencePlateNumber.length()));
    }


}
