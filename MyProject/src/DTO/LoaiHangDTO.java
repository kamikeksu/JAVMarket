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
public class LoaiHangDTO {
    public String MaLH;
    public String TenLH;

    /**
     * @return the MaLH
     */
    public String getMaLH() {
        return MaLH;
    }

    /**
     * @param MaLH the MaLH to set
     */
    public void setMaLH(String MaLH) {
        this.MaLH = MaLH;
    }

    /**
     * @return the TenLH
     */
    public String getTenLH() {
        return TenLH;
    }

    /**
     * @param TenLH the TenLH to set
     */
    public void setTenLH(String TenLH) {
        this.TenLH = TenLH;
    }
}
