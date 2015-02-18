/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ngoch_000
 */
public class LoaiHangDAO {
    DataProvider dtProvider=new DataProvider();
    public List<LoaiHangDTO> LayDSLoaiHang(String MaCL) throws Exception
    {
        List<LoaiHangDTO> lstLH=new ArrayList<LoaiHangDTO>();
        Connection cnn=dtProvider.ConnectDB();
        try {
            Statement stsm=cnn.createStatement();
            String sql="Select * from LOAIHANG lh join CHUNGLOAIHANG cl on cl.MaCL=lh.MaCL where cl.MaCL like '"+MaCL+"'";
            ResultSet rs=stsm.executeQuery(sql);
            while(rs.next())
            {
                LoaiHangDTO lh =new LoaiHangDTO();
                lh.setMaLH(rs.getString("MaLH"));
                lh.setTenLH(rs.getString("Ten"));
                lstLH.add(lh);
            }
        } catch (SQLException ex) {
            throw new Exception("Data invalid");
        }
         finally
        {
            cnn.close();
        }
        return lstLH;
    }
    public List<LoaiHangDTO> LayDSLoaiHang() throws Exception
    {
        List<LoaiHangDTO> lstLH=new ArrayList<LoaiHangDTO>();
        Connection cnn=dtProvider.ConnectDB();
        try {
            Statement stsm=cnn.createStatement();
            String sql="Select * from LOAIHANG";
            ResultSet rs=stsm.executeQuery(sql);
            while(rs.next())
            {
                LoaiHangDTO lh =new LoaiHangDTO();
                lh.setMaLH(rs.getString("MaLH"));
                lh.setTenLH(rs.getString("Ten"));
                lstLH.add(lh);
            }
        } catch (SQLException ex) {
            throw new Exception("Data invalid");
        }
         finally
        {
            cnn.close();
        }
        return lstLH;
    }
}
