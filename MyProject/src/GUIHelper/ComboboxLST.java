/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIHelper;

/**
 *
 * @author ngoch_000
 */
public class ComboboxLST {
    public Object value;
    public Object id;
    public ComboboxLST(Object _id,Object _value)
    {
        value=_value;
        id=_id;
    }
    /**
     * @return the value
     */
    public Object getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(Object value) {
        this.value = value;
    }

    /**
     * @return the id
     */
    public Object getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Object id) {
        this.id = id;
    }
}
