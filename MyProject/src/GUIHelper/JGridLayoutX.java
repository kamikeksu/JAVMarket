/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIHelper;

import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author ngoch_000
 */
public class JGridLayoutX extends JPanel{
    public JGridLayoutX(int w,int h)
    {
        setSize(w, h);
    }
    public JGridLayoutX(int w,int h,int row,int col)
    {
        setSize(w, h);
        setLayout(new GridLayout(row, col));
    }
}
