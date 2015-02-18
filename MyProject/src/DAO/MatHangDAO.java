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
public class MatHangDAO {
    DataProvider dtProvider=new DataProvider();
    public List<MatHangDTO> LayDSMatHang(String MaLH) throws Exception
    {
        List<MatHangDTO> lstMH=new ArrayList<MatHangDTO>();
        Connection cnn=dtProvider.ConnectDB();
        try {
            Statement stsm=cnn.createStatement();
            String sql="Select mh.Ten as Ten,mh.MaMatHang as MaMatHang from LOAIHANG lh right join MATHANG mh on lh.MaLH=mh.MaLH where lh.MaLH like '"+MaLH+"'";
            ResultSet rs=stsm.executeQuery(sql);
            while(rs.next())
            {
                MatHangDTO mh =new MatHangDTO();
                mh.setTen(rs.getString("Ten"));
                mh.setMaMatHang(rs.getString("MaMatHang"));
                lstMH.add(mh);
            }
        } catch (SQLException ex) {
            throw new Exception("Data invalid");
        }
         finally
        {
            cnn.close();
        }
        return lstMH;
    }
    public List<MatHangDTO> LayDSHangHoa(int id,String _idCommodity,String ngayBD,String ngayKT) throws Exception
    {   
        String sql="";
        List<MatHangDTO> lstMH=new ArrayList<MatHangDTO>();
        Connection cnn=dtProvider.ConnectDB();
        try {
        CallableStatement csts=null;
        if(id==1)
        {
            sql="{call dbo.usp_LayDanhSachMatHangVaSoLuongBanTrongKhoangThoiGianTheoChungLoaiHang(?,?,?)}";
            csts=cnn.prepareCall(sql);
            csts.setString("maChungLoai", _idCommodity);
            csts.setString("ngayBatDau",ngayBD);
            csts.setString("ngayKetThuc",ngayKT);
            ResultSet rs=csts.executeQuery();
            while(rs.next())
            {
                MatHangDTO mh=new MatHangDTO();
                mh.setMaMatHang(rs.getString("MaMatHang"));
                mh.setTen(rs.getString("Ten"));
                mh.setSLBan(rs.getInt("SoLuongDaBan"));
                mh.setNgayNhap(rs.getDate("NgayNhap"));
                mh.setSLNhap(rs.getInt("SLNhap"));
                mh.setTenDVT(rs.getString("DVTinh"));
                mh.setTenLH(rs.getString("TenLoaiHang"));
                mh.setTenCL(rs.getString("TenChungLoaiHang"));
                lstMH.add(mh);
            }
        }
         if(id==2)
        {
            sql="{call dbo.usp_LayDanhSachTatCaMatHangVaSoLuongBanTrongKhoangThoiGianTheoLoaiHang(?,?,?)}";
            csts=cnn.prepareCall(sql);
            csts.setString("maLoaiHang", _idCommodity);
            csts.setString("ngayBatDau",ngayBD);
            csts.setString("ngayKetThuc",ngayKT);
            ResultSet rs=csts.executeQuery();
            while(rs.next())
            {
                MatHangDTO mh=new MatHangDTO();
                mh.setMaMatHang(rs.getString("MaMatHang"));
                mh.setTen(rs.getString("Ten"));
                mh.setSLBan(rs.getInt("SoLuongDaBan"));
                mh.setNgayNhap(rs.getDate("NgayNhap"));
                mh.setSLNhap(rs.getInt("SLNhap"));
                mh.setTenDVT(rs.getString("DVTinh"));
                mh.setTenLH(rs.getString("TenLoaiHang"));
                mh.setTenCL(rs.getString("TenChungLoaiHang"));
                lstMH.add(mh);
            }
        }
          if(id==3)
        {
            sql="{call dbo.usp_LayDanhSachTatCaMatHangVaSoLuongBanTrongKhoangThoiGian(?,?)}";
            csts=cnn.prepareCall(sql);
            csts.setString("ngayBatDau",ngayBD);
            csts.setString("ngayKetThuc",ngayKT);
            ResultSet rs=csts.executeQuery();
            while(rs.next())
            {
                MatHangDTO mh=new MatHangDTO();
                mh.setMaMatHang(rs.getString("MaMatHang"));
                mh.setTen(rs.getString("Ten"));
                mh.setSLBan(rs.getInt("SoLuongDaBan"));
                mh.setNgayNhap(rs.getDate("NgayNhap"));
                mh.setSLNhap(rs.getInt("SLNhap"));
                mh.setTenDVT(rs.getString("DVTinh"));
                mh.setTenLH(rs.getString("TenLoaiHang"));
                mh.setTenCL(rs.getString("TenChungLoaiHang"));
                lstMH.add(mh);
            }
        }
        } catch (SQLException ex) {
            throw new Exception("Data is null or invalid");
        }
        finally{
            cnn.close();
        }
        return lstMH;
    }
}
