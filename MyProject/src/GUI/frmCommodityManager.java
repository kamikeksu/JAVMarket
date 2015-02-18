/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.*;
import DTO.*;
import GUIHelper.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ngoch_000
 */
public class frmCommodityManager extends JFrame{
    private Vector vTitle=new Vector(Arrays.asList(new String[]{"STT","Mã MH","Tên","Ngày nhập","SL nhập","SL đã bán","ĐV Tính","Loại Hàng","Chủng Loại"}));
    private int width=GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getSize().width;
    private JPanel panel1=new JPanel(new BorderLayout());
    private JTextField txtNameCommoditySearch=new JTextField();
    private JButton btnSearch=new JButton("Tìm kiếm");
    private JButton btnBack=new JButton("Trở về");
    //
    private JTextField txtNameCommodity=new JTextField();
    private JDate cbmDateOut=new JDate();
    private JDate cbmExp=new JDate();
    private JTextField txtCostBuy=new JTextField();
    private JTextField txtCostSell=new JTextField();
    private JTextField txtCountIn=new JTextField();
    private JTextField txtCountSell=new JTextField();
    private JComboBox cbmDVT=new JComboBox();
    private JComboBoxX cbmLH=new JComboBoxX();
    private JTextField txtVAT=new JTextField();
    private JComboBox cbmBillIn=new JComboBox();
    private JButton btnAdd=new JButton("Thêm");
    private JButton btnDel=new JButton("Xóa");
    private JButton btnUp=new JButton("Sửa");
    private JButton btnDone=new JButton("Xong");
    private JButton btnCancel=new JButton("Hủy");
    private JTable tbCommodity=new JTable();
    public frmCommodityManager()
    {
        super();
        initComponent();
        setVisible(true);
        setTitle("Quản Lí Hàng Hóa");
        setSize(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getSize());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(panel1);
    }

    private void initComponent() {
        // panel search commodity
        JPanel panelSearch=new JPanel();
        JLabel lbName=new JLabel("QUẢN LÍ HÀNG HÓA");
        lbName.setAlignmentX(CENTER_ALIGNMENT);
        lbName.setFont(new Font("Segoe UI",NORMAL,28));
        /*
        btnSearch.setFont(new Font("Segoe UI",NORMAL,18));
        btnBack.setFont(new Font("Segoe UI",NORMAL,18));
        txtNameCommoditySearch.setFont(new Font("Segoe UI",Font.ITALIC,18));
        JLabelX lable1=new JLabelX("");
        panelSearch.add(txtNameCommoditySearch);
        panelSearch.add(lable1);
        panelSearch.add(btnSearch);
        panelSearch.add(btnBack);*/
        panelSearch.add(lbName);
        // panel Mainform
        JPanel panelMain=new JPanel(new BorderLayout());

        //panel info new commodity
        JPanel panelInfo=new JPanel(new BorderLayout());
        JPanel panelInput=new JPanel();
        
        panelInput.setBackground(Color.red);
        panelInput.setSize(300, 100);
        JPanel panelButton=new JPanel(new GridLayout(5,1));
        //lb List infomation Input
        JLabelX labelX1=new JLabelX("Tên mặt hàng :");
        JLabelX label2=new JLabelX("Ngày nhập :");
        JLabelX label3=new JLabelX(new JDateNow().getDateNow());
        JLabelX label4=new JLabelX("Ngày sản xuất :");
        JLabelX label5=new JLabelX("Hạn sử dụng :");
        JLabelX label6=new JLabelX("Giá mua :");
        JLabelX label7=new JLabelX("Giá bán :");
        JLabelX label8=new JLabelX("Số lượng nhập :");
        JLabelX label9=new JLabelX("Số lượng bán :");
        JLabelX label10=new JLabelX("Đơn vị tính :");
        JLabelX label11=new JLabelX("Loại hàng :");
        JLabelX label12=new JLabelX("VAT :");
        JLabelX label13=new JLabelX("Phiếu nhập :");
        //add control to panelInput
        panelInput.setLayout(new GridLayout(6,4,10,10));
        panelInput.add(labelX1);
        panelInput.add(txtNameCommodity);
        panelInput.add(label2);
        panelInput.add(label3);
        panelInput.add(label4);
        panelInput.add(cbmDateOut);
        panelInput.add(label5);
        panelInput.add(cbmExp);
        panelInput.add(label6);
        panelInput.add(txtCostBuy);
        panelInput.add(label7);
        panelInput.add(txtCostSell);
        panelInput.add(label8);
        panelInput.add(txtCountIn);
        panelInput.add(label9);
        panelInput.add(txtCountSell);
        panelInput.add(label10);
        panelInput.add(cbmDVT);
        panelInput.add(label11);
        panelInput.add(cbmLH);
        panelInput.add(label12);
        panelInput.add(txtVAT);
        panelInput.add(label13);
        panelInput.add(cbmBillIn);
        // panel button add
        panelButton.add(btnAdd);
        panelButton.add(btnDel);
        panelButton.add(btnUp);
        btnDone.setEnabled(false);
        panelButton.add(btnDone);
        panelButton.add(btnCancel);
        //---------------------------
        panelInfo.add(panelInput,BorderLayout.LINE_START);
        panelInfo.add(panelButton,BorderLayout.EAST);
        
        // panel table
        JPanel paneltbMain=new JPanel(new BorderLayout());
        
        //panel lb table
        JPanel panellb=new JPanel();
        panellb.setBackground(Color.gray);
        JLabelX lb2=new JLabelX("DANH SÁCH MẶT HÀNG");
        panellb.add(lb2);
        //panel table commodity
        tbCommodity.getTableHeader().setReorderingAllowed(false);
        JScrollPane scroll=new JScrollPane();
        scroll.setViewportView(tbCommodity);
        tbCommodity.getTableHeader().setPreferredSize(new Dimension(scroll.getWidth(),50));
        LoadDataToDB("");
        LoadDataToCombox();
        
        // add lb and Table to paneltbMain
        paneltbMain.add(panellb,BorderLayout.NORTH);
        paneltbMain.add(scroll,BorderLayout.CENTER);
        // add panel to main
        panelMain.add(panelInfo,BorderLayout.NORTH);
        panelMain.add(paneltbMain,BorderLayout.CENTER);
        //add control to from main
        panel1.add(panelSearch,BorderLayout.NORTH);
        panel1.add(panelMain,BorderLayout.CENTER);
        
        // event
        cbmLH.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, cbmLH.selectedValue());
            }
        });
    }
    private void LoadDataToDB(String idCommodity)
    {
        java.util.List<MatHangDTO> lstMH=new ArrayList<MatHangDTO>();
        try{
        lstMH=(new MatHangBUS().LayDanhSachHangHoaTheoLuaChon(idCommodity,"1/2/2000",new JDateNow().getDateNow()));
        Vector vData=new Vector();
        int i=1;
        for(MatHangDTO mh : lstMH)
        {
            Vector vI=new Vector();
            vI.add(i);
            vI.add(mh.getMaMatHang());
            vI.add(mh.getTen());
            vI.add(mh.getNgayNhap());
            vI.add(mh.getSLNhap());
            vI.add(mh.getSLBan());
            vI.add(mh.getTenDVT());
            vI.add(mh.getTenLH());
            vI.add(mh.getTenCL());
            vData.add(vI);
            i++;
        }
        DefaultTableModel tableModel=null;
        tableModel=new DefaultTableModel(vData,vTitle);
        tbCommodity.setModel(tableModel);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void LoadDataToCombox() {
        List<LoaiHangDTO> lstLH=new ArrayList<LoaiHangDTO>();
       try{ 
        lstLH=new LoaiHangBUS().LayDanhSachLoaiHang();
        for(LoaiHangDTO lh :lstLH)
        {
            cbmLH.addItem(lh.getMaLH(), lh.getTenLH());
        }
       }catch(Exception ex)
       {
           JOptionPane.showMessageDialog(null, ex.getMessage());
       }
    }
}
