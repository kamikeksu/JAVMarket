/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIHelper;

import java.util.Calendar;

/**
 *
 * @author ngoch_000
 */
public class JDateNow {
    Calendar now=Calendar.getInstance();
    public int dayNow=now.get(Calendar.DAY_OF_MONTH);
    public int monthNow=now.get(Calendar.MONTH)+1;
    public int yearNow=now.get(Calendar.YEAR);
    public String getDateNow()
    {
        return getMonthNow()+"/"+getDayNow()+"/"+getYearNow();
    }

    /**
     * @return the dayNow
     */
    public int getDayNow() {
        return dayNow;
    }

    /**
     * @return the monthNow
     */
    public int getMonthNow() {
        return monthNow;
    }

    /**
     * @return the yearNow
     */
    public int getYearNow() {
        return yearNow;
    }
}
