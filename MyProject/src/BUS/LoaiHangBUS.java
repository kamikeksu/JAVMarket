/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.*;
import DTO.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ngoch_000
 */
public class LoaiHangBUS {
    public List<LoaiHangDTO> LayDanhSachLoaiHang(String maCL) throws Exception
    {
        List<LoaiHangDTO> lstLH=new ArrayList<LoaiHangDTO>();
        try {
            lstLH=(new LoaiHangDAO().LayDSLoaiHang(maCL));
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return lstLH;
    }
     public List<LoaiHangDTO> LayDanhSachLoaiHang() throws Exception
    {
        List<LoaiHangDTO> lstLH=new ArrayList<LoaiHangDTO>();
        try {
            lstLH=(new LoaiHangDAO().LayDSLoaiHang());
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return lstLH;
    }
        
            
}
