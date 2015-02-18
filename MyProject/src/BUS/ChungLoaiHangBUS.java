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
public class ChungLoaiHangBUS {
    public List<ChungLoaiHangDTO> LayDanhSachChungLoaiHang() throws Exception
    {
        List<ChungLoaiHangDTO> lstCL=new ArrayList<ChungLoaiHangDTO>();
        try {
            lstCL=(new ChungLoaiHangDAO().LayDSCLH());
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return lstCL;
    }
}
