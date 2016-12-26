
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fatih_ARSLAN
 */
public class nasil_oynanir extends JPanel{
    private JButton geri;
    private ImageIcon icon=new ImageIcon(getClass().getResource("geri.png"));
    private JLabel label;
  Font baslik = new java.awt.Font("Algerian",Font.BOLD, 25);
  Font yazi = new Font("verdana", Font.BOLD, 11);
    public nasil_oynanir() {
        String kural="--> Dokuztaş oyunu 2 kişi ile oynanır.\n" +
"\n" +
"--> Oyuncu-1 ilk taşı koyarak oyuna başlar. \n Sonra rakibi bir taş koyar. \n" +
"Her iki oyuncunun elindeki 9 taş bitinceye kadar sırası ile taşları oyun tahtası üzerine koyarlar.\n" +
" Bu esnada oyunculardan biri yatay ya da dikey olarak taşlarını üçlü yapmışsa (per) rakibinin bir taşını alır.\n" +
" Rakibin üçlü peri varsa üçlü bozulmaz. Üçlü olmayanlardan birini alır. \n" +
"Çapraz olarak yapılan üçlemeler taş yemek için geçerli değildir.\n" +
"\n" +
"--> Oyuncular ellerindeki 9 taşı da oyun alanına bırakmadan oyun alanındaki hiçbir taşı oynatamazlar. "+"\n"+"Yani hamle yapamazlar.\n" +
"\n" +
"--> Oyuncular yaptıkları üçlüleri ileri – geri yaparak rakibin taşını yiyebilirler.\n" +
"\n" +
"--> Herhangi bir oyuncunun taşı kalmamışsa oyun biter.";
        label=new JLabel();
        label.setBounds(150,20,600,50);
        label.setFont(baslik);
        label.setForeground(Color.WHITE);
        label.setText("9 tas oyunu amaç:");
        add(label);
        label=new JLabel();
        label.setBounds(150,50,600,50);
        label.setFont(yazi);
        label.setForeground(Color.WHITE);
        label.setText("--> Oyun alanında 3 tane aynı renk tasi yan yana getirerek müsabakaları kazanmak.");
        add(label);
        label=new JLabel();
        label.setBounds(150,90,600,50);
        label.setFont(baslik);
        label.setForeground(Color.WHITE);
        label.setText("9 tas oyunu beceri alani:");
        add(label);
        label=new JLabel();
        label.setBounds(150,130,600,50);
        label.setForeground(Color.WHITE);
        label.setFont(yazi);
        label.setText("--> Hafıza, konsantrasyon, strateji, düşünme becerisi.");
        add(label);
        label=new JLabel();
        label.setForeground(Color.WHITE);
        label.setBounds(50,170,600,50);
        label.setFont(baslik);
        label.setText("9 tas oyun kurallari:");
        add(label);
        TextArea kurallar=new TextArea(kural);
        kurallar.setBounds(50,200,600,250);
        kurallar.setForeground(Color.WHITE);
        kurallar.setFont(new Font("verdana", Font.BOLD, 11));
        kurallar.setEnabled(false);
        add(kurallar);
        geri=new JButton();
        geri.setBounds(10,10,100,100);
        setBackground(new Color(113, 99, 169));
        geri.setOpaque(false);
       // geri.setBorderPainted(false);
        geri.setContentAreaFilled(false);
        geri.setIcon(icon);
        geri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                setVisible(false);
                Anamenu x=new Anamenu();
                Giris_Ekrani.giris.add(x);
                
            }
        });
        add(geri);
        setBounds(0,0,700,500);
        setLayout(null);
        setVisible(true);
    }
    
}
