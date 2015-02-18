/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import DTO.*;
import java.sql.*;
import java.util.*;
/**
 *
 * @author ngoch_000
 */
public class NhanvienDAO {
    DataProvider dtProvider=new DataProvider();
    public List<NhanvienDTO> LayThongTinNhanVien(String TenDN,String MK) throws Exception
    {
        List<NhanvienDTO> lstNV = new ArrayList<NhanvienDTO>();
        ResultSet rs=null;
        
        Connection connect=dtProvider.ConnectDB();
        try{
        CallableStatement cstmt=connect.prepareCall("{call dbo.usp_KiemTraDangNhap(?,?)}");
        cstmt.setString("tenDangNhap",TenDN);
        cstmt.setString("matKhau",MK);
        rs=cstmt.executeQuery();
        while(rs.next())
        {
            NhanvienDTO nv=new NhanvienDTO();
            nv.setMaNV(rs.getString("MaNV"));
            nv.setTenNV(rs.getString("HoTen"));
            nv.setTenDN(rs.getString("TenDangNhap"));
            nv.setMatKhau(rs.getString("MatKhau"));
            lstNV.add(nv);
        }
        rs.close();
        }
        catch(Exception ex)
        {
            throw new Exception("Couldnot execute to Server");
        }
        finally
        {
            connect.close();
        }
        return lstNV;
    }
}
