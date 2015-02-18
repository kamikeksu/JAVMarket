/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIHelper;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author ngoch_000
 */
public class ImplementDefaultJTree extends DefaultMutableTreeNode{
    public Object objmain=null;
    public String value="";
    public String id="";
    public ImplementDefaultJTree(Object obj,String val)
    {
        super(val);
        objmain=obj;
        value=val;
    }
     public ImplementDefaultJTree(String _ID,String val)
    {
        super(val);
        id=_ID;
        value=val;
    }

    /**
     * @return the objmain
     */
    public Object getObjmain() {
        return objmain;
    }
    
    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }
    
}
