/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Emilio Paez
 */
public class Schedule {
    
    private Calendar startTime;
    private Calendar endTime;

    public Schedule(Calendar startTime, Calendar endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Calendar getStartTime() {
        return startTime;
    }

    public void setStartTime(Calendar startTime) {
        this.startTime = startTime;
    }

    public Calendar getEndTime() {
        return endTime;
    }

    public void setEndTime(Calendar endTime) {
        this.endTime = endTime;
    }

    /**
     * dsfsdfdsfdsfsdfsdfsdf
     * @param schedule Schedule corresponde a la placa a validar
     * @param time Calendar corresponde a la placa a validar
     * @return boolean retorna verdadero si la placa es valida o falso si no lo
     * es
     */
    public boolean isInPicoPlaca( Calendar time) {

        Calendar start = Calendar.getInstance();
        start.setTime(time.getTime());
        start.set(Calendar.HOUR_OF_DAY, this.getStartTime().get(Calendar.HOUR_OF_DAY));
        start.set(Calendar.MINUTE, this.getStartTime().get(Calendar.MINUTE));
        start.set(Calendar.SECOND, 0);
        start.set(Calendar.MILLISECOND, 0);
        Calendar end = Calendar.getInstance();
        end.setTime(time.getTime());
        end.set(Calendar.HOUR_OF_DAY, this.getEndTime().get(Calendar.HOUR_OF_DAY));
        end.set(Calendar.MINUTE, this.getEndTime().get(Calendar.MINUTE));
        end.set(Calendar.SECOND, 0);
        end.set(Calendar.MILLISECOND, 0);

        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");

        return (time.compareTo(start) >= 0 && time.compareTo(end) <= 0);
    }
}
