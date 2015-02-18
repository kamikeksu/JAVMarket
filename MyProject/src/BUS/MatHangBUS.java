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
public class MatHangBUS {
    public List<MatHangDTO> LayDanhSachMatHang(String maLH) throws Exception
    {
        List<MatHangDTO> lstLH=new ArrayList<MatHangDTO>();
        try {
            lstLH=(new MatHangDAO().LayDSMatHang(maLH));
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return lstLH;
    }
        
    public List<MatHangDTO> LayDanhSachHangHoaTheoLuaChon(String idCommodity,String ngayBD,String ngayKT) throws Exception
    {
        int id=0;
        if(idCommodity.contains("CL")==true)
        {
            id=1;
        }
        else
        {
            id=2;
        }
        if(idCommodity.isEmpty())
        {
            id=3;
        }
        List<MatHangDTO> lstLH=new ArrayList<MatHangDTO>();
        try {
            lstLH=(new MatHangDAO().LayDSHangHoa(id, idCommodity,ngayBD,ngayKT));
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return lstLH;
    }
}
