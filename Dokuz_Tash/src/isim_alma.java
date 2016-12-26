

import java.awt.Color;
import java.awt.Font;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class isim_alma extends JPanel{
    JLabel oyuncu1=new JLabel("OYUNCU-1 ADI: "),oyuncu2=new JLabel("OYUNCU-2 ADI: ");
    static JTextField ad1,ad2; 
    private ImageIcon icon=new ImageIcon(getClass().getResource("geri.png"));
    private ImageIcon onay=new ImageIcon(getClass().getResource("onay.png"));
    private JButton geri,kaydet;
     Font tip = new Font("Algerian", Font.BOLD, 25);
     static JFrame pc;
     static String oyuncu_adi1,oyuncu_adi2;
    public isim_alma() {
        kaydet=new JButton(onay);
        kaydet.setBounds(600,400,100,100);
        kaydet.setOpaque(false);
        kaydet.setContentAreaFilled(false);
        kaydet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                
               if(ad1.getText().equals("")){
                   
                   JOptionPane.showMessageDialog(null, "Oyuncu-1 adını giriniz");
               }
               else if(ad2.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Oyuncu-2 adını giriniz");
               }else{
                   oyuncu_adi1=ad1.getText();
                   oyuncu_adi2=ad2.getText();
                   Giris_Ekrani.giris.setVisible(false);
                pc = new JFrame("9_ TAŞ");
                pc.setUndecorated(true);
                pc.setLocationRelativeTo(null);
                Oyun_Ekrani a = new Oyun_Ekrani();
                a.addKeyListener(a);
                a.setFocusable(true);
                pc.add(a);
                pc.setExtendedState(MAXIMIZED_BOTH);
                pc.setVisible(true);
               }
            }
        });
        add(kaydet);
        
         geri=new JButton(icon);
        geri.setBounds(0,0,100,100);
        geri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Giris_Ekrani.giris.add(new Anamenu());
            }
        });
        geri.setContentAreaFilled(false);
        geri.setOpaque(false);
        add(geri);
        ad1=new JTextField();
        ad2=new JTextField();
        oyuncu1.setBounds(150,100,200,50);
        oyuncu2.setBounds(150,300,200,50);
        oyuncu1.setFont(tip);
        oyuncu2.setFont(tip);
        ad1.setBounds(350,100,100,50);
        ad2.setBounds(350,300,100,50);
        add(oyuncu1);
        add(oyuncu2);
        add(ad1);
        add(ad2);
        setBounds(0,0,750,500);
        setBackground(new Color(113, 99, 169));
        setLayout(null);
        
    }
    
}
