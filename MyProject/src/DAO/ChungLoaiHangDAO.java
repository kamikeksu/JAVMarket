/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.*;
import DTO.*;
import java.sql.*;
/**
 *
 * @author ngoch_000
 */
public class ChungLoaiHangDAO {
    DataProvider dtProvider=new DataProvider();
    public List<ChungLoaiHangDTO> LayDSCLH() throws Exception
    {
        List<ChungLoaiHangDTO> lstCL=new ArrayList<ChungLoaiHangDTO>();
        Connection connect=dtProvider.ConnectDB();
        try{
            Statement stsm=connect.createStatement();
            ResultSet rs=stsm.executeQuery("Select * from CHUNGLOAIHANG");
            while(rs.next())
            {
                ChungLoaiHangDTO cl=new ChungLoaiHangDTO();
                cl.setMaCL(rs.getString("MaCL"));
                cl.setTenCL(rs.getString("Ten"));
                lstCL.add(cl);
            }
        }
        catch(Exception ex)
        {
            throw new Exception("Couldnot execute to Server");
        }
        finally
        {
            connect.close();
        }
        return lstCL;
    }
}
