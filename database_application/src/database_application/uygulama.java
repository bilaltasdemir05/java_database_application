package database_application;

import java.sql.Connection;
import java.sql.*;
import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.util.Random;
import java.util.Scanner;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;  
import java.awt.Image;
import javax.swing.JFrame;            
import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JLabel; 
import java.awt.BorderLayout;
import java.util.Random;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.*;
import java.util.Properties;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
//import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
//import org.opencv.videoio.VideoCapture;

 
public class uygulama extends JFrame  implements ActionListener{
	private static final long serialVersionUID = 1L;
	int x,y,z,v,q,g;
	 
    String s,t,w,h,u;
	    JFrame frame,frame2,frame3,frame4,frame5;
	    JPanel panel,panel2,panel3,panel4,panel5;
	    JButton btn_login,btn_kayit,btn_yenikayit,btn_güncelle,btn_bul,btn_ekle,btn_sil,btn_iptal,btn_memurekle,
	    btn_gözat,btn_resimgözat,btn_dosyaekle,btn_dosyagözat;
	    JPasswordField passF_password;
	    JLabel lbl_userName, lbl_password, lbl_Ad, lbl_Soyad,lbl_TCNO,lbl_TCNO2,lbl_KadroDerecesi,
	    lbl_YeniKayit,lbl_resimekle,lbl_resimekle2,lbl_resimekle3,lbl_KadroDerecesi2,lbl_Ad2,lbl_Soyad2,
	    lbl_TCNO3,lbl_resimgöster,lbl_kayitliresim,lbl_id,lbl_dosyaekle;
	    JTextField txt_isim,txt_userName,txt_kullaniciadi,txt_sifre,txt_Ad,txt_Soyad,txt_TCNO,txt_KadroDerecesi,
	    txt_TCNO2,txt_Ad2,txt_Soyad2,txt_TCNO3,txt_KadroDerecesi2,txt_id;
        JTextArea text_dosya;
	public uygulama(){
		super("GÝRÝÞ");
        setBounds(500, 100, 300, 250);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(null);
        lbl_userName = new JLabel("Kullanýcý Adý:");
        lbl_userName.setBounds(20, 20, 100, 20);
        txt_userName = new JTextField();
        txt_userName.setBounds(120, 20, 150, 20);
        lbl_password = new JLabel("Þifre:");
        lbl_password.setBounds(20, 50, 100, 20);
        lbl_resimekle2=new JLabel(new ImageIcon("C:\\Users\\Bilal\\Desktop\\y.jpg"));
		getContentPane().add(lbl_resimekle2);
		lbl_resimekle2.setBounds(10, 100, 100, 100);
		
        passF_password = new JPasswordField();
        passF_password.setBounds(120, 50, 150, 20);
        btn_login = new JButton("Giriþ");
        btn_login.setBounds(120, 80, 80, 20);
        btn_kayit=new JButton("Kayit");
        btn_kayit.setBounds(120,120,80,20);
        panel.add(lbl_resimekle2);
        panel.add(lbl_userName);
        panel.add(txt_userName);
        panel.add(lbl_password);
        panel.add(passF_password);
        panel.add(btn_login);
        panel.add(btn_kayit);
        add(panel); 
      
        btn_login.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            	try
                {
        			
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database", "root", "1234");
                    Statement komut = conn.createStatement();
                    ResultSet rs = komut.executeQuery("select * from adminler" );
                    int a;
                    rs.last();
                    a=rs.getInt("id");
                    
                       int i=1;
                       int z=0;
                      
                	   while(i <= a){
                		   String b,c,w;
                    	   rs.absolute(i);
                    	   b=rs.getString("kullaniciadi");
                    	   c=rs.getString("sifre");
                    	   w=rs.getString("isim");
                	      if(txt_userName.getText().equals(b) && passF_password.getText().equals(c)){
                		     JOptionPane.showMessageDialog(null, "Hosgeldin   " + w );
                		     ücüncüpanel();
                		     z++;
                	      }
                	      
                	    	  
                	       i=i+1;
                	    }
                	   if(z==0){
                		   JOptionPane.showMessageDialog(null, "Kulllanici Adi Veya Sifre Yanlis");
                		   g++;
                		   if(g==3){
                    		  System.load("C:\\Users\\Bilal\\Desktop\\opencv\\build\\java\\x64\\opencv_java2411.dll");
                    		  VideoCapture videoCapture = new VideoCapture();
                              videoCapture.open(0);
                              Mat kameraFotograf =new Mat();
                              if(videoCapture.isOpened()){
                             	 videoCapture.read(kameraFotograf);
                             	 Highgui.imwrite("D:\\kamera.jpg", kameraFotograf);
                             	 videoCapture.release();
                             	 JOptionPane.showMessageDialog(null, "3 Defa Hatalý Giriþ Yaptýnýz");
                		   }
                              
                    	   }
                	   
                	   
                	    
                	    conn.close();
                	      
                	    }
                }
            catch (Exception s)
            {
                System.out.print(s.getMessage());
            }
            	
            }
           
        });
        
        btn_kayit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            	
            JOptionPane.showMessageDialog(null,"Yetkili Kayýt Sayfasý Kapalý");
            	
            }
        });
        
   }
	public void ücüncüpanel(){
		
    	frame3=new JFrame("Calisanlar");
    	frame3.setBounds(450,200,800,500);
		frame3.setVisible(true);
		panel3=new JPanel();
		panel3.setLayout(null);
		txt_Ad=new JTextField();
		txt_Ad.setBounds(120, 220, 150, 20);
		lbl_YeniKayit=new JLabel("Arama Sonuçlarý");
		lbl_YeniKayit.setBounds(20,50,300,20);
		lbl_Ad=new JLabel("Ad");
		lbl_Ad.setBounds(20, 220, 100, 20);
		txt_Soyad=new JTextField();
		txt_Soyad.setBounds(120, 250, 150, 20);
		lbl_Soyad=new JLabel("Soyad");
		lbl_Soyad.setBounds(20, 250, 100, 20);
		txt_TCNO=new JTextField();
		txt_TCNO.setBounds(120,20,85,20);
		lbl_TCNO=new JLabel("TC NO GÝRÝNÝZ");
		lbl_TCNO.setBounds(20,20,100,20);
		txt_KadroDerecesi=new JTextField();
		txt_KadroDerecesi.setBounds(120, 280, 150, 20);
		lbl_KadroDerecesi=new JLabel("Kadro Derecesi");
		lbl_KadroDerecesi.setBounds(20,280,100,20);
		txt_TCNO2=new JTextField();
		txt_TCNO2.setBounds(120, 310, 150, 20);
		lbl_TCNO2=new JLabel("TC NO");
		lbl_TCNO2.setBounds(20, 310, 100, 20);
		btn_yenikayit=new JButton("Yeni Kayit");
		btn_yenikayit.setBounds(20,350,100,20);
		btn_güncelle=new JButton("Güncelle");
		btn_güncelle.setBounds(150,350,100,20);
		lbl_id=new JLabel("ÝD");
		lbl_id.setBounds(20,430,100,20);
		txt_id=new JTextField();
		txt_id.setBounds(50, 430, 40, 20);
		txt_id.setEnabled(false);
		btn_bul=new JButton("Bul");
		btn_bul.setBounds(220,20,80,20);
		btn_sil=new JButton("Sil");
		btn_sil.setBounds(280,350,80,20);
		btn_iptal=new JButton("Ýptal");
		btn_iptal.setBounds(390,350,80,20);
		lbl_resimekle=new JLabel(new ImageIcon("D:\\x.png"));
		getContentPane().add(lbl_resimekle);
		lbl_resimekle.setBounds(400, 10, 320, 320);
		lbl_kayitliresim=new JLabel();
		lbl_kayitliresim.setBounds(10, 70, 200, 140);
		btn_resimgözat=new JButton("Yeni Resim Seç");
		btn_resimgözat.setBounds(220,70,160,20);
		btn_dosyagözat=new JButton("Yeni Bir Belge Seç");
		btn_dosyagözat.setBounds(220,100,160,20);
		panel3.add(btn_dosyagözat);
		panel3.add(txt_id);
		panel3.add(lbl_id);
		panel3.add(btn_resimgözat);
		panel3.add(lbl_kayitliresim);
		panel3.add(lbl_resimekle);
		panel3.add(lbl_YeniKayit);
		panel3.add(btn_iptal);
		panel3.add(btn_sil);
		panel3.add(btn_bul);
		panel3.add(btn_güncelle);
		panel3.add(btn_yenikayit);
		panel3.add(txt_KadroDerecesi); 
		panel3.add(txt_TCNO2);
		panel3.add(txt_TCNO);
		panel3.add(lbl_TCNO2);
		panel3.add(lbl_TCNO);
		panel3.add(lbl_KadroDerecesi);
		panel3.add(lbl_Soyad);
		panel3.add(txt_Soyad);
		panel3.add(lbl_Ad);
        panel3.add(txt_Ad);
        frame3.add(panel3);
        
        
        btn_yenikayit.addActionListener(new ActionListener()
        {
        	

            public void actionPerformed(ActionEvent e)
            {
                 dördüncüpanel();
            }
        });
      
        btn_resimgözat.addActionListener(new ActionListener()
        {
        	
            public void actionPerformed(ActionEvent e)
            {
            	JFileChooser fileChooser =new JFileChooser();
            	fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            	FileNameExtensionFilter filter =new FileNameExtensionFilter("*.IMAGE","*.JPG","gif","png");
            	fileChooser.addChoosableFileFilter(filter);
            	int result=fileChooser.showSaveDialog(null);
            	if(result==JFileChooser.APPROVE_OPTION){
            		File selectedFile=fileChooser.getSelectedFile();
            		String Path=selectedFile.getAbsolutePath();
            		
            		w=Path;
            		JOptionPane.showMessageDialog(null,"Dosya Seçildi" );
            	}
            	else if(result==JFileChooser.CANCEL_OPTION){
            		System.out.println("No Data");
            	}
            }
        });
        btn_dosyagözat.addActionListener(new ActionListener()
        {
        	
            public void actionPerformed(ActionEvent e)
            {
            	JFileChooser fileChooser =new JFileChooser();
            	fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            	FileNameExtensionFilter filter =new FileNameExtensionFilter("*.IMAGE","jgp","gif","png");
            	fileChooser.addChoosableFileFilter(filter);
            	int result=fileChooser.showSaveDialog(null);
            	if(result==JFileChooser.APPROVE_OPTION){
            		File selectedFile=fileChooser.getSelectedFile();
            		String Path=selectedFile.getAbsolutePath();
            		
            		h=Path;
            		JOptionPane.showMessageDialog(null,"Dosya Seçildi" );
            	}
            	else if(result==JFileChooser.CANCEL_OPTION){
            		System.out.println("No Data");
            	}
            }
        });
        btn_sil.addActionListener(new ActionListener()
        {
        	
            public void actionPerformed(ActionEvent e)
            {
            	try
                {
            		Object [] noSaveOption = {"Evet","Hayýr" }; 
            		 
            		String message = "Bu Kiþiyi Veritabanýndan Silmek Ýstiyor musun?"; 
            		 
            		String title = "DÝKKAT!!";
            		 
            		int noSave = JOptionPane.showOptionDialog(null, message, title, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,null, noSaveOption, null);
            		 
            		if (noSave == JOptionPane.YES_OPTION )
            		 
            		{
            			  Class.forName("com.mysql.jdbc.Driver").newInstance();
                          System.out.print("sürücü yüklendi");
                          Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database", "root", "1234");
                          Statement komut = conn.createStatement();
                          //String sorgu = "DELETE FROM memurlar WHERE TCNO= '" + txt_TCNO2.getText() + "'";
                          //  komut.executeUpdate(sorgu);
                          String a=txt_id.getText();
               		   int b=Integer.parseInt(a);
               		   //ÝSMÝ GÜNCELLEYÝP NULL YAPIYORUZ
               		   String UpdateQueryAd="UPDATE memurlar SET ad = ? WHERE id = ?";
                   	   PreparedStatement psAd=conn.prepareStatement(UpdateQueryAd);
                   	   psAd.setInt(2, b);
                   	   psAd.setString(1, null);
                   	   psAd.executeUpdate();
                   	   //SOYADI GÜNCELLEYÝP NULL YAPIYORUZ
                   	   String UpdateQuerySoyad="UPDATE memurlar SET soyad = ? WHERE id = ?";
                   	   PreparedStatement psSoyad=conn.prepareStatement(UpdateQuerySoyad);
                   	   psSoyad.setInt(2, b);
                   	   psSoyad.setString(1, null);
                   	   psSoyad.executeUpdate();
                   	   // TCNO GÜNCELLEYÝP NULL YAPIYORUZ
                   	   String UpdateQueryTcno="UPDATE memurlar SET TCNO = ? WHERE id = ?";
                   	   PreparedStatement psTcno=conn.prepareStatement(UpdateQueryTcno);
                   	   psTcno.setInt(2, b);
                   	   psTcno.setString(1, null);
                   	   psTcno.executeUpdate();
                   	   //KADRO DERECESÝ GÜNCELLEYÝP NULL YAPIYORUZ
                   	   String UpdateQueryKadroderecesi="UPDATE memurlar SET kadroderecesi = ? WHERE id = ?";
                   	   PreparedStatement psKadroDerecesi=conn.prepareStatement(UpdateQueryKadroderecesi);
                   	   psKadroDerecesi.setInt(2, b);
                   	   psKadroDerecesi.setString(1, null);
                   	   psKadroDerecesi.executeUpdate();
                   	   //RESÝM GÜNCELLEYÝP NULL YAPIYORUZ
                   	   String UpdateQuery="UPDATE memurlar SET resim = ? WHERE id = ?"; 
                          PreparedStatement ps =conn.prepareStatement(UpdateQuery);
                          ps.setInt(2, b);
                          ps.setString(1,null);
              			   ps.executeUpdate();
              			   //DOSYA GÜNCELLEYÝP NULL YAPIYORUZ
              			    String UpdateQuery2="UPDATE memurlar SET dosya = ? WHERE id = ?";
           			   PreparedStatement pss=conn.prepareStatement(UpdateQuery2);
           			   pss.setInt(2, b);
           			   pss.setBinaryStream(1,null);
           			   pss.executeUpdate(); 
                       
                          JOptionPane.showMessageDialog(null, "Veritabanýndan " + txt_Ad.getText()+" isimli kiþi silindi");
                          conn.close();
            			
            			
            		}
            		 
            		else if (noSave == JOptionPane.NO_OPTION)
            		 
            		{
            		
            		}
            		 
            		else if (noSave == JOptionPane.CANCEL_OPTION)
            		 
            		{
            	       
            		}
                 
                   }
                   
                catch (Exception s)
                {
                    System.out.print(s.getMessage());
                }
            	
             }
            
        });
        
        
        btn_güncelle.addActionListener(new ActionListener()
        {
        	
         
            public void actionPerformed(ActionEvent e)
            {
            	
                 
                 try
                 {
         			
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    System.out.print("sürücü yüklendi");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database", "root", "1234");
                    Statement komut2 = conn.createStatement();
                    
                           String id=txt_id.getText();
                           String ad=txt_Ad.getText();
                           String soyad=txt_Soyad.getText();
                           String tcno=txt_TCNO2.getText();
                           String kadroderecesi=txt_KadroDerecesi.getText();
                           String a=txt_id.getText();
                		   int b=Integer.parseInt(a);
                           String adsoyad_kontrol="^[a-zA-Z]{1,20}$";
                           String tcno_kontrol="^[1-9]{1,1}[0-9]{9,9}[0,2,4,6,8]{1,1}$";
                           String kadroderecesi_kontrol="^[1-9]{1,1}$";
                           Pattern patternKadroDerecesi=Pattern.compile(kadroderecesi_kontrol);
                           Pattern patternAdSoyad =Pattern.compile(adsoyad_kontrol);
                           Pattern patternTcno= Pattern.compile(tcno_kontrol);
                           Matcher regexMatcherKadroDerecesi=patternKadroDerecesi.matcher(txt_KadroDerecesi.getText());
                           Matcher regexMatcherAd=patternAdSoyad.matcher(txt_Ad.getText());
                           Matcher regexMatcherSoyad=patternAdSoyad.matcher(txt_Soyad.getText());
                           Matcher regexMatcherTcno=patternTcno.matcher(txt_TCNO2.getText());
                           ResultSet rsl = komut2.executeQuery("select * from memurlar" );
	                        rsl.last();
	                        y=rsl.getInt("id");
	                        int j=1;
	                        int z=0;
	                        while(j <= y){
	                 		   String p;
	                     	   rsl.absolute(j);
	                     	   p=rsl.getString("TCNO");
	                     	   if(txt_TCNO.getText().equals(txt_TCNO2.getText())){
	                     		   
	                     	   }
	                     	   else{
	                     	        if(txt_TCNO2.getText().equals(p)){
	                     		       z++;
	                     	   }
	                     	   }
	                     	   j++;
	                        }
	                     	if(z>0){
	                     		JOptionPane.showMessageDialog(null, "Girdiðiniz TC Numarasý Ýle Zaten Bir Kayýt Mevcut");
	                     	}
	                     	else{
                           //ÝSÝM KONTROLÜ VE ÝSÝM GÜNCELLEMESÝ
                           if(!regexMatcherAd.matches()){
                        	   JOptionPane.showMessageDialog(null, "Ýsim Uygun Degil");
                           }
                           else{
                        	   
                        	   String UpdateQueryAd="UPDATE memurlar SET ad = ? WHERE id = ?";
                        	   PreparedStatement psAd=conn.prepareStatement(UpdateQueryAd);
                        	   psAd.setInt(2, b);
                        	   psAd.setString(1, txt_Ad.getText());
                        	   psAd.executeUpdate();
                        	   //SOYAD KONTROLÜ VE SOYAD GÜNCELLEME
                               if(!regexMatcherSoyad.matches()){
                            	   JOptionPane.showMessageDialog(null, "Soyad Uygun Degil");
                               }
                               else{
                            	   
                            	   String UpdateQuerySoyad="UPDATE memurlar SET soyad = ? WHERE id = ?";
                            	   PreparedStatement psSoyad=conn.prepareStatement(UpdateQuerySoyad);
                            	   psSoyad.setInt(2, b);
                            	   psSoyad.setString(1, txt_Soyad.getText());
                            	   psSoyad.executeUpdate();
                            	 //TCNO KONTROLÜ VE TCNO GÜNCELLEME
                                   if(!regexMatcherTcno.matches()){
                                	   JOptionPane.showMessageDialog(null, "TCNO Uygun Degil");
                                   }
                                   else{
                                	   
                                	   String UpdateQueryTcno="UPDATE memurlar SET TCNO = ? WHERE id = ?";
                                	   PreparedStatement psTcno=conn.prepareStatement(UpdateQueryTcno);
                                	   psTcno.setInt(2, b);
                                	   psTcno.setString(1, txt_TCNO2.getText());
                                	   psTcno.executeUpdate();
                                	// KADRO DERECESÝ KONTROLÜ VE GÜNCELLEME
                                       if(!regexMatcherKadroDerecesi.matches()){
                                    	   JOptionPane.showMessageDialog(null, "Kadro Derecesi Uygun Degil");
                                       }
                                       else{
                                    	   
                                    	   String UpdateQueryKadroderecesi="UPDATE memurlar SET kadroderecesi = ? WHERE id = ?";
                                    	   PreparedStatement psKadroDerecesi=conn.prepareStatement(UpdateQueryKadroderecesi);
                                    	   psKadroDerecesi.setInt(2, b);
                                    	   psKadroDerecesi.setString(1, txt_KadroDerecesi.getText());
                                    	   psKadroDerecesi.executeUpdate();
                                    	// RESÝM GÜNCELLEME ÝÞLEMÝ
                                           if(w != null){
                                           InputStream is=new FileInputStream(new File(w));
                                           String x=txt_id.getText();
                                		   int y=Integer.parseInt(x);
                                           String UpdateQuery="UPDATE memurlar SET resim = ? WHERE id = ?"; 
                                           PreparedStatement ps =conn.prepareStatement(UpdateQuery);
                                           ps.setInt(2, y);
                                           ps.setBlob(1,is);
                               			   ps.executeUpdate();
                                           }
                                        // DOSYA GÜNCELLEME ÝÞLEMÝ
                                           if(h != null){
                                   			   InputStream ist=new FileInputStream(new File(h));
                                   			   String c=txt_id.getText();
                                 		       int d=Integer.parseInt(c);
                                   			   String UpdateQuery2="UPDATE memurlar SET dosya = ? WHERE id = ?";
                                   			   PreparedStatement pss=conn.prepareStatement(UpdateQuery2);
                                   			   pss.setInt(2, d);
                                   			   pss.setBinaryStream(1,ist);
                                   			   pss.executeUpdate();
                                               }
                                    	   JOptionPane.showMessageDialog(null, "  Güncelleme Baþarýlý ");
                                       }
                                   }
                               }
                           }
	                     	}
                          
                           
                        	
                         /*  String sql="update memurlar set id='"+id+"' ,ad='"+ad+"' ,soyad='"+soyad+"' ,TCNO='"+tcno+"' ,kadroderecesi='"+kadroderecesi+"'   where id='"+id+"' ";
                           PreparedStatement pst = conn.prepareStatement(sql);
                           pst.execute();*/
                           
                          // JOptionPane.showMessageDialog(null, "  BÝLGÝLER GÜNCELLENDÝ  ");
                           
            			   conn.close();
               			   
                    }
                   
                 catch (Exception s)
                 {
                     System.out.print(s.getMessage());
                 }
             	
                 }
        });
        	 
        
        btn_bul.addActionListener(new ActionListener()
        {
        	
            public void actionPerformed(ActionEvent e)
            {

        		try
                {
        			
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    System.out.print("sürücü yüklendi");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database", "root", "1234");
                    Statement komut = conn.createStatement();
                    ResultSet rsl = komut.executeQuery("select * from memurlar" );
                    rsl.last();
                    y=rsl.getInt("id");
                    int j=1;
                    
                    while(j <= y){
             		   String k,l,m,n,p;
                 	   rsl.absolute(j);
                 	   p=rsl.getString("id");
                 	   k=rsl.getString("ad");
                 	   l=rsl.getString("soyad");
                 	   m=rsl.getString("TCNO");
                 	   n=rsl.getString("kadroderecesi");
                 	
                 	   if(txt_TCNO.getText().equals(m)){
                 		 
                          ResultSet rslt=komut.executeQuery("select * from memurlar where id='"+ j +"'");
                          
                          if(rslt.next()){
                        	byte[] img=rslt.getBytes("resim");
      						ImageIcon resim =new ImageIcon(img);
      						Image im=resim.getImage();
      						Image myImg=im.getScaledInstance(lbl_kayitliresim.getWidth(), lbl_kayitliresim.getHeight(), Image.SCALE_SMOOTH);
      						ImageIcon newImage=new ImageIcon(myImg);
      						lbl_kayitliresim.setIcon(newImage);
      						
                          }
                          else {
                        	  JOptionPane.showMessageDialog(null, "No ");
                          }
                         
                          txt_id.setText(p);
                 		  txt_Ad.setText(k);
                 		  txt_Soyad.setText(l);
                 		  txt_TCNO2.setText(m);
                 	      txt_KadroDerecesi.setText(n);
                 	   }
                 	   
                 	   j++; 
                }
                   
                    conn.close();
                    
                }
                catch (Exception s)
                {
                    System.out.print(s.getMessage());
                }
            	
            	
            	
        		
            }
        });
        btn_iptal.addActionListener(new ActionListener()
        {
        	
            public void actionPerformed(ActionEvent e)
            {
                frame3.setVisible(false);
            }
        });	
        }
	public void dördüncüpanel(){
		frame4=new JFrame("Calisanlar");
    	frame4.setBounds(450,200,800,500);
		frame4.setVisible(true);
		panel4=new JPanel();
		panel4.setLayout(null);
		btn_memurekle=new JButton("Ekle");
		btn_memurekle.setBounds(120,370,80,20);
	    btn_gözat=new JButton("Gözat");
	    btn_gözat.setBounds(120,10,100,20);
	    btn_dosyaekle=new JButton("Dosya Ekle");
	    btn_dosyaekle.setBounds(120,40,100,20);
	    lbl_resimekle3=new JLabel("Resim Ekle");
	    lbl_resimekle3.setBounds(10,10,100,20);
	    lbl_dosyaekle=new JLabel("Dosya Ekle");
	    lbl_dosyaekle.setBounds(10,40,100,20);
	    lbl_resimgöster=new JLabel();
	    lbl_resimgöster.setBounds(10, 40, 200, 200);
	    lbl_KadroDerecesi2=new JLabel("Kadro Derecesi");
	    lbl_KadroDerecesi2.setBounds(20,340,100,20);
	    lbl_Ad2=new JLabel("Ýsim");
	    lbl_Ad2.setBounds(20,250,100,20);
	    lbl_Soyad2=new JLabel("Soyisim");
	    lbl_Soyad2.setBounds(20,280,100,20);
	    lbl_TCNO3=new JLabel("TC NO");
	    lbl_TCNO3.setBounds(20,310,100,20);
	    txt_Ad2=new JTextField();
	    txt_Ad2.setBounds(120, 250, 150, 20);
	    txt_Soyad2=new JTextField();
	    txt_Soyad2.setBounds(120, 280, 150, 20);
	    txt_TCNO3= new JTextField();
	    txt_TCNO3.setBounds(120, 310, 150, 20);
	    txt_KadroDerecesi2=new JTextField();
	    txt_KadroDerecesi2.setBounds(120, 340, 150, 20);
	    panel4.add(btn_dosyaekle);
	    panel4.add(lbl_dosyaekle);
	    panel4.add(lbl_resimgöster);
	    panel4.add(lbl_resimekle3);
		panel4.add(lbl_KadroDerecesi2);
		panel4.add(lbl_Ad2);
		panel4.add(lbl_Soyad2);
		panel4.add(lbl_TCNO3);
		panel4.add(txt_Ad2);
		panel4.add(txt_Soyad2);
		panel4.add(txt_TCNO3);
		panel4.add(txt_KadroDerecesi2); 
		panel4.add(btn_memurekle);
		panel4.add(btn_gözat);
		frame4.add(panel4);
		btn_gözat.addActionListener(new ActionListener()
        {
        	
            public void actionPerformed(ActionEvent e)
            {
            	JFileChooser fileChooser =new JFileChooser();
            	fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            	FileNameExtensionFilter filter =new FileNameExtensionFilter("*.IMAGE","jgp","gif","png");
            	fileChooser.addChoosableFileFilter(filter);
            	int result=fileChooser.showSaveDialog(null);
            	if(result==JFileChooser.APPROVE_OPTION){
            		File selectedFile=fileChooser.getSelectedFile();
            		String Path=selectedFile.getAbsolutePath();
            		lbl_resimgöster.setIcon(ResizeImage(Path));
            		s=Path;
            		JOptionPane.showMessageDialog(null,"Dosya Seçildi" );
            	}
            	else if(result==JFileChooser.CANCEL_OPTION){
            		System.out.println("No Data");
            	}
            }
        });	
		btn_dosyaekle.addActionListener(new ActionListener()
        {
        	
            public void actionPerformed(ActionEvent e)
            {
            	JFileChooser fileChooser =new JFileChooser();
            	fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            	FileNameExtensionFilter filter =new FileNameExtensionFilter("*.IMAGE","jgp","gif","png","pdf","*.docx");
            	fileChooser.addChoosableFileFilter(filter);
            	int result=fileChooser.showSaveDialog(null);
            	if(result==JFileChooser.APPROVE_OPTION){
            		File selectedFile=fileChooser.getSelectedFile();
            		String Path=selectedFile.getAbsolutePath();
            		
            		h=Path;
            		JOptionPane.showMessageDialog(null,"Dosya Seçildi" );
            	}
            	else if(result==JFileChooser.CANCEL_OPTION){
            		System.out.println("No Data");
            	}
            }
        });	
		 btn_memurekle.addActionListener(new ActionListener()
	        {
	        	
	            public void actionPerformed(ActionEvent e)
	            {
	            	
	            		try
	                    {
	            			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database", "root", "1234");
	            			Statement komut = conn.createStatement();
	            			String adsoyad_kontrol2="^[a-zA-Z]{1,20}$";
	                        String tcno_kontrol2="^[1-9]{1,1}[0-9]{9,9}[0,2,4,6,8]{1,1}$";
	                        String kadroderecesi_kontrol2="^[1-9]{1,1}$";
	                        Pattern patternKadroDerecesi2=Pattern.compile(kadroderecesi_kontrol2);
	                        Pattern patternAdSoyad2 =Pattern.compile(adsoyad_kontrol2);
	                        Pattern patternTcno2= Pattern.compile(tcno_kontrol2);
	                        Matcher regexMatcherKadroDerecesi2=patternKadroDerecesi2.matcher(txt_KadroDerecesi2.getText());
	                        Matcher regexMatcherAd2=patternAdSoyad2.matcher(txt_Ad2.getText());
	                        Matcher regexMatcherSoyad2=patternAdSoyad2.matcher(txt_Soyad2.getText());
	                        Matcher regexMatcherTcno2=patternTcno2.matcher(txt_TCNO3.getText());
	                        ResultSet rsl = komut.executeQuery("select * from memurlar" );
	                        rsl.last();
	                        y=rsl.getInt("id");
	                        int j=1;
	                        int z=0;
	                        while(j <= y){
	                 		   String p;
	                     	   rsl.absolute(j);
	                     	   p=rsl.getString("TCNO");
	                     	   if(txt_TCNO3.getText().equals(p)){
	                     		   z++;
	                     	   }
	                     	   j++;
	                        }
	                     	if(z>0){
	                     		JOptionPane.showMessageDialog(null, "Girdiðiniz TC Numarasý Ýle Zaten Bir Kayýt Mevcut");
	                     	}
	                     	else{
	                     	  
	            			if(!regexMatcherKadroDerecesi2.matches()){
	            			   JOptionPane.showMessageDialog(null, "Kadro Derecesi Ýçin Hatalý Giriþ Yaptýnýz");
	            			}
	            			   else{
	            				    if(!regexMatcherAd2.matches()){
	            				    	JOptionPane.showMessageDialog(null,"Hatali Ýsim Girdiniz");
	            				    }
	            				    else{
	            					     if(!regexMatcherSoyad2.matches()){
	            					    	 JOptionPane.showMessageDialog(null, "Hatalý Soyad Girdiniz");
	            					     }
	            					     else{
	            						      if(!regexMatcherTcno2.matches()){
	            						    	  JOptionPane.showMessageDialog(null, "Hatalý Tcno Girdiniz");
	            						      }
	            						      else{
	            							       if(s == null){
	            							    	   JOptionPane.showMessageDialog(null, "Resim Seçmediniz");
	            							       }
	            							       else{
	            								        if(h == null){
	            								        	JOptionPane.showMessageDialog(null, "Dosya Seçmediniz");
	            								        }
	            								        else{
	            									ResultSet rse = komut.executeQuery("select * from memurlar" );
	            	            					PreparedStatement ps=conn.prepareStatement("insert into memurlar(id,ad,soyad,TCNO,kadroderecesi,resim,dosya) values(?,?,?,?,?,?,?)");
	            	    	            			InputStream is=new FileInputStream(new File(s));
	            	    	            			InputStream ist=new FileInputStream(new File(h));
	            	            					int a;
	            	    	            			rse.last();
	            	    	            			a=rse.getInt("id");
	            	                            	ps.setInt(1, ++a);
	            	    	            			ps.setString(2, txt_Ad2.getText());
	            	    	            			ps.setString(3, txt_Soyad2.getText());
	            	    	            			ps.setString(4, txt_TCNO3.getText());
	            	    	            			ps.setString(5, txt_KadroDerecesi2.getText());
	            	    	            			ps.setBlob(6, is);
	            	    	            			ps.setBinaryStream(7, ist);
	            	    	            			ps.executeUpdate();
	            	    	            			JOptionPane.showMessageDialog(null, "Kayit Olundu");
	            								}
	            							}
	            						}
	            					}
		            			} 
	            		   }
	                     	}
	            			
	            			
	            			conn.close();
	                    }
	                    catch (Exception s)
	                    {
	                        System.out.print(s.getMessage());
	                    }
	           
	            }
	        });	
		
	}
	

    protected Icon ResizeImage(String path) {
		// TODO Auto-generated method stub
		return null;
	}
	public static void main(String arg[]){
    	new uygulama().setVisible(true);
    
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
    