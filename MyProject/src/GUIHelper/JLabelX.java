/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIHelper;

import java.awt.Font;
import static java.awt.Frame.NORMAL;
import javax.swing.JLabel;

/**
 *
 * @author ngoch_000
 */
public class JLabelX extends JLabel{
    public JLabelX()
    {
        super();
        setFont(new Font("Segoe UI",NORMAL,16));
    }
    public JLabelX(String val)
    {
        super(val);
        setFont(new Font("Segoe UI",NORMAL,16));
    }
}
