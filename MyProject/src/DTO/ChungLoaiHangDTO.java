/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author ngoch_000
 */
public class ChungLoaiHangDTO {
    public String MaCL;
    public String TenCL;

    /**
     * @return the MaCL
     */
    public String getMaCL() {
        return MaCL;
    }

    /**
     * @param MaCL the MaCL to set
     */
    public void setMaCL(String MaCL) {
        this.MaCL = MaCL;
    }

    /**
     * @return the TenCL
     */
    public String getTenCL() {
        return TenCL;
    }

    /**
     * @param TenCL the TenCL to set
     */
    public void setTenCL(String TenCL) {
        this.TenCL = TenCL;
    }
}
