/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import GUIHelper.*;
import com.sun.imageio.plugins.jpeg.JPEG;
import com.sun.org.apache.xerces.internal.impl.dv.xs.DateTimeDV;
import javax.swing.*;
import java.sql.Date;
import java.util.List;
import javax.swing.event.*;
 

import DTO.*;
import BUS.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.ArrayList;
import java.util.*;
import java.util.logging.*;
import javax.swing.table.*;
import javax.swing.tree.*;
/**
 *
 * @author ngoch_000
 */
public class frmReport extends JFrame{
    int widthCenter=GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getSize().width/2;
    private JTree TreeMain=null;
    private JTable tbCommodity=new JTable(10,10);
    private Vector vTitle=new Vector(Arrays.asList(new String[]{"STT","Mã MH","Tên","Ngày nhập","SL nhập","SL đã bán","ĐV Tính","Loại Hàng","Chủng Loại"}));
    private String DateNow="";
    private String DateFrom="";
    private JComboBox cbmDateFrom=new JComboBox();
    private JComboBox cbmMonthFrom=new JComboBox();
    private JComboBox cbmYearFrom=new JComboBox();
    private JLabel lbDate=new JLabel();
    private JLabel lbSum=new JLabel();
    private int SumofCommodity=0;
    Calendar now=Calendar.getInstance();
    int dayNow=now.get(Calendar.DAY_OF_MONTH);
    int monthNow=now.get(Calendar.MONTH)+1;
    int yearNow=now.get(Calendar.YEAR);
    public frmReport()
    {
        super();
        initComponent();
        this.setTitle(" Thống kê hàng hóa");
        this.setVisible(true);
        this.setSize(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getSize());
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    private void initComponent()
    {
        JPanel panelMain=new JPanel();
        //panel title 
        JPanel panelTitle=new JPanel(new BorderLayout());
        JLabel lbMain=new JLabel(" Danh sách hàng hóa thống kê");
        lbMain.setFont(new Font("Segoe UI",NORMAL,24));
        lbMain.setForeground(Color.decode("#2980b9"));
        lbDate.setFont(new Font("Segoe UI",NORMAL,24));
        lbDate.setForeground(Color.decode("#2980b9"));
        lbDate.setText(" from ... to now");
        JPanel pn1=new JPanel();
        pn1.add(lbMain);
        pn1.setBackground(Color.white);
        JPanel pn2=new JPanel();
        pn2.setBackground(Color.white);
        pn1.add(lbDate);
        panelTitle.setBackground(Color.GRAY);
        panelTitle.add(pn1,BorderLayout.NORTH);
        panelTitle.add(pn2,BorderLayout.CENTER);
        
        
        // panel end,info
        JPanel panelEnd=new JPanel(new BorderLayout());
        JLabel lbEnd=new JLabel(" Development by Kami");
        lbEnd.setFont(new Font("Segoe UI",Font.ITALIC,15));
        lbEnd.setBackground(Color.red);
        panelEnd.setBackground(Color.GRAY);
        panelEnd.add(lbEnd,BorderLayout.EAST);
        //panel center
        JPanel panelCenter=new JPanel(new BorderLayout());
        panelCenter.setBackground(Color.BLACK);
        
        //panelsearch
        JPanel panelSearch=new JPanel(new BorderLayout());
        
        JLabel lbSearch=new JLabel("Thời điểm thống kê");
        lbSearch.setFont(new Font("Segoe UI",NORMAL,18));
        lbSearch.setForeground(Color.white);
        JPanel panel2=new JPanel();
        panel2.add(lbSearch);
        panel2.setBackground(Color.decode("#2980b9"));
        
        //
        JPanel panelMainSearch=new JPanel(new BorderLayout());
        // panel Datetime to
        JPanel panel1=new JPanel(new FlowLayout());
        JLabel lable1=new JLabel(" Từ ngày :");
        lable1.setFont(new Font("Segoe UI",NORMAL,12));
        
        
        for(int i=1;i<=31;i++)
        {
            cbmDateFrom.addItem(i);
        }
        for(int i=1;i<=12;i++)
        {
            cbmMonthFrom.addItem(i);
        }
        for(int i=2015;i>=1995;i--)
        {
            cbmYearFrom.addItem(i);
        }
        cbmDateFrom.setSelectedItem(dayNow);
        cbmMonthFrom.setSelectedItem(monthNow);
        cbmYearFrom.setSelectedItem(2014);
        GetDateTime();
        cbmDateFrom.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                GetDateTime();
            }
        });
        cbmMonthFrom.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                checkDatecbm();
                GetDateTime();
            }
        });
        cbmYearFrom.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                checkDatecbm();
                GetDateTime();
            }
        });
        panel1.add(lable1);
        panel1.add(cbmDateFrom);
        panel1.add(cbmMonthFrom);
        panel1.add(cbmYearFrom);
        // panel datetime to
        
       
        JPanel panel3=new JPanel(new BorderLayout());
        panel3.add(panel1,BorderLayout.NORTH);
        
        
        
        // create Tree
        createTree();
        JScrollPane scPanel=new JScrollPane(TreeMain);
        TreeMain.addTreeSelectionListener(new TreeSelectionListener() {

            @Override
            public void valueChanged(TreeSelectionEvent e) {
                ImplementDefaultJTree selectedElement=(ImplementDefaultJTree)TreeMain.getSelectionPath().getLastPathComponent();
                //JOptionPane.showMessageDialog(null,selectedElement.getId());
                String idCommodity=selectedElement.getId();
                if(!idCommodity.contains("MH"))
                {
                    LoadDataToDB(selectedElement.getId());
                }
            }
        });
        //lb and btn south
        lbSum.setFont(new Font("Segoe UI",NORMAL,22));
        lbSum.setForeground(Color.red);

        JButton btnExit=new JButton(" Thoát ");
        btnExit.setFont(new Font("Segoe UI",NORMAL,22));
        btnExit.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        JPanel pnEnd=new JPanel(new BorderLayout());
        pnEnd.add(lbSum,BorderLayout.WEST);
        pnEnd.add(btnExit,BorderLayout.EAST);
        // add control
        panelMainSearch.add(panel3,BorderLayout.NORTH);
        panelMainSearch.add(scPanel,BorderLayout.CENTER);
        // add control to panel
        panelSearch.add(panel2,BorderLayout.NORTH);
        panelSearch.add(panelMainSearch,BorderLayout.CENTER);
        //panel Main
        JPanel panelMainTable=new JPanel(new BorderLayout());
        tbCommodity.getTableHeader().setReorderingAllowed(false);
        JScrollPane scrollpanel1=new JScrollPane();
        scrollpanel1.setViewportView(tbCommodity);
        LoadDataToDB("");
        
        panelMainTable.add(scrollpanel1,BorderLayout.CENTER);
        panelMainTable.add(panelTitle,BorderLayout.NORTH);
        panelMainTable.add(pnEnd,BorderLayout.SOUTH);
        //add Panel to JFrame
        panelCenter.add(panelSearch,BorderLayout.LINE_START);
        panelCenter.add(panelMainTable,BorderLayout.CENTER);
        // set layout to mainForm
        panelMain.setLayout(new BorderLayout());
        panelMain.add(panelCenter,BorderLayout.CENTER);
        panelMain.add(panelEnd,BorderLayout.SOUTH);
        this.getContentPane().add(panelMain);
        tbCommodity.getTableHeader().setBackground(Color.decode("#2980b9"));
        tbCommodity.getTableHeader().setForeground(Color.white);
        tbCommodity.getTableHeader().setPreferredSize(new Dimension(scrollpanel1.getWidth(),50));
    }
    private void createTree()
    {
        List<ChungLoaiHangDTO> lstCL=new ArrayList<ChungLoaiHangDTO>();
        List<LoaiHangDTO> lstLH=null;
        List<MatHangDTO> lstMH=null;
        try {
            lstCL=(new ChungLoaiHangBUS().LayDanhSachChungLoaiHang());
        
        ImplementDefaultJTree rootNode=new ImplementDefaultJTree("","Hàng hóa");
        for(ChungLoaiHangDTO cl:lstCL)
        {
            ImplementDefaultJTree NodeCL=new ImplementDefaultJTree(cl.getMaCL(),cl.getTenCL());
            lstLH=new ArrayList<LoaiHangDTO>();
            lstLH=(new LoaiHangBUS().LayDanhSachLoaiHang(cl.getMaCL()));
            for(LoaiHangDTO lh: lstLH)
            {
                ImplementDefaultJTree NodeLH=new ImplementDefaultJTree(lh.getMaLH(),lh.getTenLH());
                NodeCL.add(NodeLH);
                lstMH=new ArrayList<MatHangDTO>();
                lstMH=(new MatHangBUS().LayDanhSachMatHang(lh.getMaLH()));
                for(MatHangDTO mh:lstMH)
                {
                    ImplementDefaultJTree NodeMH=new ImplementDefaultJTree(mh.getMaMatHang(), mh.getTen());
                    NodeLH.add(NodeMH);
                }
            }
            rootNode.add(NodeCL);
        }
        TreeMain=new JTree(rootNode);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    private void LoadDataToDB(String idCommodity)
    {
        List<MatHangDTO> lstMH=new ArrayList<MatHangDTO>();
        try{
        lstMH=(new MatHangBUS().LayDanhSachHangHoaTheoLuaChon(idCommodity,DateFrom,DateNow));
        Vector vData=new Vector();
        int i=1;
        SumofCommodity=0;
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
            SumofCommodity+=mh.getSLBan();
        }
        DefaultTableModel tableModel=null;
        tableModel=new DefaultTableModel(vData,vTitle);
        tbCommodity.setModel(tableModel);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        lbSum.setText("Tổng số lượng bán :"+SumofCommodity);
    }
    
    private void GetDateTime()
    {
        DateNow=monthNow+"/"+dayNow+"/"+yearNow;
        DateFrom=cbmMonthFrom.getSelectedItem()+"/"+cbmDateFrom.getSelectedItem()+"/"+cbmYearFrom.getSelectedItem();
        lbDate.setText(" từ ngày "+DateFrom+" đến hiện tại");
    }
    private void checkDatecbm()
    {
        int n=0,month=0,year=0;
        month=Integer.parseInt(cbmMonthFrom.getSelectedItem().toString());
        year=Integer.parseInt(cbmYearFrom.getSelectedItem().toString());
       
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
        {
            n=31;
        }
        else
        {
            if(month==2)
            {
                if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
                {
                    n=28;
                }
                else
                {
                    n=29;
                }
            }
            else
            {
                n=30;
            }
        }
        cbmDateFrom.removeAllItems();
        for(int i=1;i<=n;i++)
        {
            cbmDateFrom.addItem(i);
        }
    }
}
