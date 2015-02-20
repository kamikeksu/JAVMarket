package BUS;

import DAO.*;
import DTO.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
