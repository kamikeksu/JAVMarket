/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIHelper;

import java.util.*;
import javax.swing.JComboBox;

/**
 *
 * @author ngoch_000
 */
public class JComboBoxX extends JComboBox{
    private List<ComboboxLST> lst=new ArrayList<ComboboxLST>();
    public JComboBoxX()
    {
        super();
    }
    public void addItem(Object id,Object value)
    {
        super.addItem(value);
        lst.add(new ComboboxLST(id,value));
    }
    public Object selectedValue()
    {
        Object obj=super.getSelectedItem();
        for(ComboboxLST cbm:lst)
        {
            if(obj==cbm.getValue())
            {
                return cbm.getId();
            }
        }
        return null;
    }
}
