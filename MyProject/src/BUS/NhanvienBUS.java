/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import DTO.*;
import DAO.*;
import static java.lang.System.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.JOptionPane;
/**
 *
 * @author ngoch_000
 */
public class NhanvienBUS {
    NhanvienDAO nvDAO=new NhanvienDAO();
    public void KiemTraNhanVien(String TenDN,String MK) throws Exception
    {
        int stt=0;
        try {
           List<NhanvienDTO> lstNV=nvDAO.LayThongTinNhanVien(TenDN,MK);
           for(NhanvienDTO nv : lstNV)
           {
               stt++;
               if(nv.getTenDN().contains(TenDN) && nv.getMatKhau().contains(MK)){
                if(nv.getTenDN().compareTo(TenDN)==0 && nv.getMatKhau().compareTo(MK)==0)
                {
                    JOptionPane.showMessageDialog(null,"Login Success");
                }
               }
              
           }
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        if(stt==0)
        {
             JOptionPane.showMessageDialog(null,"Account not exists");
        }
    }
}
