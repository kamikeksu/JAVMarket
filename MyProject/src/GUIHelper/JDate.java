/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIHelper;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JComboBox;
import javax.swing.JPanel;

/**
 *
 * @author ngoch_000
 */
public class JDate extends JPanel{
    private JComboBox cbmDateFrom=new JComboBox();
    private JComboBox cbmMonthFrom=new JComboBox();
    private JComboBox cbmYearFrom=new JComboBox();
     Calendar now=Calendar.getInstance();
    int dayNow=now.get(Calendar.DAY_OF_MONTH);
    int monthNow=now.get(Calendar.MONTH)+1;
    int yearNow=now.get(Calendar.YEAR);
    public JDate()
    {
        super();
        initComponent();
        JPanel panel=new JPanel(new FlowLayout());
        panel.add(cbmDateFrom);
        panel.add(cbmMonthFrom);
        panel.add(cbmYearFrom);
        add(panel);
    }

    private void initComponent() {
        for(int i=1;i<=31;i++)
        {
            cbmDateFrom.addItem(i);
        }
        for(int i=1;i<=12;i++)
        {
            cbmMonthFrom.addItem(i);
        }
        for(int i=2015;i>=1995;i--)
        {
            cbmYearFrom.addItem(i);
        }
        cbmMonthFrom.setSelectedItem(monthNow);
        cbmYearFrom.setSelectedItem(yearNow);
        checkDatecbm();
        cbmDateFrom.setSelectedItem(dayNow);
        GetDateTime();
        cbmDateFrom.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                GetDateTime();
            }
        });
        cbmMonthFrom.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                checkDatecbm();
                GetDateTime();
            }
        });
        cbmYearFrom.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                checkDatecbm();
                GetDateTime();
            }
        });
        
    }
    private String DateFrom="";
    private void GetDateTime()
    {
        DateFrom=cbmMonthFrom.getSelectedItem()+"/"+cbmDateFrom.getSelectedItem()+"/"+cbmYearFrom.getSelectedItem();
    }
    public String getDate()
    {
        return DateFrom;
    }
    private void checkDatecbm()
    {
        int n=0,month=0,year=0;
        month=Integer.parseInt(cbmMonthFrom.getSelectedItem().toString());
        year=Integer.parseInt(cbmYearFrom.getSelectedItem().toString());
       
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
        {
            n=31;
        }
        else
        {
            if(month==2)
            {
                if (year % 4 != 0 && year % 100 != 0 || year % 400 != 0)
                {
                    n=28;
                }
                else
                {
                    n=29;
                }
            }
            else
            {
                n=30;
            }
        }
        cbmDateFrom.removeAllItems();
        for(int i=1;i<=n;i++)
        {
            cbmDateFrom.addItem(i);
        }
    }
}
