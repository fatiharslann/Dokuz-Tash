
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.URL;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Oyun_Ekrani extends JPanel implements MouseListener, MouseMotionListener, KeyListener {
URL yupi=getClass().getResource("yupi.wav");
URL surukle=getClass().getResource("surukle.wav");
URL yeme=getClass().getResource("yeme.wav");
 static JFrame pencere ;
    Font tip = new Font("Algerian", Font.BOLD, 30);
    JButton bitir = new JButton("KAPAT");
    JLabel lx, l1 = new JLabel(isim_alma.oyuncu_adi1), l2 = new JLabel(isim_alma.oyuncu_adi2);
    final int[] xkor = {385, 650, 915, 465, 650, 835, 552, 650, 750, 385, 465, 552, 750, 835, 915, 552, 650, 750, 465, 650, 835, 385, 650, 915};
    final int[] ykor = {85, 85, 85, 165, 165, 165, 252, 252, 252, 350, 350, 350, 350, 350, 350, 450, 450, 450, 535, 535, 535, 615, 615, 615};

    int[] oyuncu1_oncekikoordinatx, oyuncu1_oncekikoordinaty, oyuncu2_oncekikoordinatx, oyuncu2_oncekikoordinaty,
            konumindexi1, konumindexi2;
    int x, y, temp, temp2, sayac = 0, konumtut, tiklanan = -1, tempkonum, sayac1 = 0, suruklebiraktakikonum = -1, yenenindex;
    ArrayList<Oyuncu_1> oyuncu_1;
    ArrayList<Oyuncu_2> oyuncu_2;
    ArrayList<alandurumu> map;
    static String kazanan;
    boolean oyuncu1oyna = true, oyuncu2oyna = false, klavyehareket = false, yeme1 = false, yeme2 = false;
    Image icon = new ImageIcon(getClass().getResource("MAP\\" + ayarlar.mapp + ".png")).getImage();
    Image tas1 = new ImageIcon(getClass().getResource("OYUNCU-1\\" + ayarlar.t1 + ".png")).getImage();
    Image tas2 = new ImageIcon(getClass().getResource("OYUNCU-2\\" + ayarlar.t2 + ".png")).getImage();
    Image yuvarlak = new ImageIcon(getClass().getResource("yuvarlak.png")).getImage();
 Image yuvarlak1 = new ImageIcon(getClass().getResource("yuvarlak1.png")).getImage();
    public Oyun_Ekrani() {
        setBackground(ayarlar.renk);
        oyuncu_1 = new ArrayList<Oyuncu_1>();
        oyuncu_2 = new ArrayList<Oyuncu_2>();
        map = new ArrayList<alandurumu>();
        elemanlari_olustur();
        lx = new JLabel("OYUNA BASLAYABILIRSIN "+l1.getText());
        l1.setBounds(30, 50, 300, 50);
        l2.setBounds(1080, 50, 300, 50);
        l1.setFont(tip);
        l2.setFont(tip);
        lx.setFont(tip);
        add(lx);
        lx.setBounds(300, 710, 600, 50);
        add(l1);
        add(l2);

        bitir.setBounds(1250, 700, 100, 50);
        bitir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(bitir);
        setBounds(0, 0, 1300, 700);
        setLayout(null);
        setVisible(true);
        addMouseListener(this);
        addMouseMotionListener(this);
        konumindexi1 = new int[9];
        konumindexi2 = new int[9];
        alanlari_belirle();
        oyuncu1_oncekikoordinatx = new int[9];
        oyuncu1_oncekikoordinaty = new int[9];
        oyuncu2_oncekikoordinatx = new int[9];
        oyuncu2_oncekikoordinaty = new int[9];
        eski_konumlari_tut();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(icon, 300, 0, 700, 700, this);
        g.drawImage(tas1, 250, 50, 50, 50, null);
        g.drawImage(tas2, 1300, 50, 50, 50, null);

        for (int i = 0; i < oyuncu_1.size(); i++) {
            g.drawImage(tas1, oyuncu_1.get(i).getX(), oyuncu_1.get(i).getY(), oyuncu_1.get(i).getCap(),
                    oyuncu_1.get(i).getCap(), null);

        }

        for (int i = 0; i < oyuncu_2.size(); i++) {
            g.drawImage(tas2, oyuncu_2.get(i).getX(), oyuncu_2.get(i).getY(), oyuncu_2.get(i).getCap(),
                    oyuncu_2.get(i).getCap(), null);
        }

        if (tiklanan != -1&&!map.get(tiklanan).getDurum()) {
            if(oyuncu1oyna&&map.get(tiklanan).getA()==1){
                 g.drawImage(yuvarlak, map.get(tiklanan).getX() - 48, map.get(tiklanan).getY() - 48, 95, 95, null);
                if(map.get(tiklanan).sag!=null&&map.get(tiklanan).sag.getDurum()){
                    g.drawImage(yuvarlak1, map.get(tiklanan).sag.getX() - 48, map.get(tiklanan).sag.getY() - 48, 95, 95, null);
                }
                if(map.get(tiklanan).sol!=null&&map.get(tiklanan).sol.getDurum()){
                    g.drawImage(yuvarlak1, map.get(tiklanan).sol.getX() - 48, map.get(tiklanan).sol.getY() - 48, 95, 95, null);
                }
                if(map.get(tiklanan).asagi!=null&&map.get(tiklanan).asagi.getDurum()){
                    g.drawImage(yuvarlak1, map.get(tiklanan).asagi.getX() - 48, map.get(tiklanan).asagi.getY() - 48, 95, 95, null);
                }
                if(map.get(tiklanan).yukari!=null&&map.get(tiklanan).yukari.getDurum()){
                    g.drawImage(yuvarlak1, map.get(tiklanan).yukari.getX() - 48, map.get(tiklanan).yukari.getY() - 48, 95, 95, null);
                }
            }else if(oyuncu2oyna&&map.get(tiklanan).getA()==2){
                g.drawImage(yuvarlak, map.get(tiklanan).getX() - 48, map.get(tiklanan).getY() - 48, 95, 95, null);
                if(map.get(tiklanan).sag!=null&&map.get(tiklanan).sag.getDurum()){
                    g.drawImage(yuvarlak1, map.get(tiklanan).sag.getX() - 48, map.get(tiklanan).sag.getY() - 48, 95, 95, null);
                }
                if(map.get(tiklanan).sol!=null&&map.get(tiklanan).sol.getDurum()){
                    g.drawImage(yuvarlak1, map.get(tiklanan).sol.getX() - 48, map.get(tiklanan).sol.getY() - 48, 95, 95, null);
                }
                if(map.get(tiklanan).asagi!=null&&map.get(tiklanan).asagi.getDurum()){
                    g.drawImage(yuvarlak1, map.get(tiklanan).asagi.getX() - 48, map.get(tiklanan).asagi.getY() - 48, 95, 95, null);
                }
                if(map.get(tiklanan).yukari!=null&&map.get(tiklanan).yukari.getDurum()){
                    g.drawImage(yuvarlak1, map.get(tiklanan).yukari.getX() - 48, map.get(tiklanan).yukari.getY() - 48, 95, 95, null);
                }
            
            }
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        try {
            x = e.getX();
            y = e.getY();
            koordinat_kontrol(x, y);
            if (sayac < 18) {
                elemanlari_yerlestir();
                suruklebiraktakikonum = koordinat_kontrol(x, y);
                kontrol();
            }

            repaint();
        } catch (Exception ex) {

        }
        eski_konumlari_tut();
        mapi_sifirla();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        tiklanan = koordinat_kontrol(x, y);
        temp = oyuncu1_bas_kor_kontrol(x, y);
        temp2 = oyuncu2_bas_kor_kontrol(x, y);
        if (yeme1) {
            
            if (tiklanan != -1 && map.get(tiklanan).getA() == 2) {
                muzikCal(yeme, 0, true);
                oyuncu_2.get(map.get(tiklanan).getOyuncu_indexi()).setCap(0);
                oyuncu_2.get(map.get(tiklanan).getOyuncu_indexi()).setX(0);
                oyuncu_2.get(map.get(tiklanan).getOyuncu_indexi()).setY(0);
                oyuncu_2.get(map.get(tiklanan).getOyuncu_indexi()).setKonumindexi(-1);
                map.get(tiklanan).setA(0);
                map.get(tiklanan).setDurum(true);
                map.get(tiklanan).setOyuncu_indexi(-1);
                yeme1 = false;
                for (int i = 0; i < oyuncu_2.size(); i++) {
                oyuncu_2.get(i).setDurum(true);
            }
            }
           
        } else if (yeme2 ) {
             for (int i = 0; i < oyuncu_1.size(); i++) {
                oyuncu_1.get(i).setDurum(false);
            }
             muzikCal(yeme, 0, true);
            if(tiklanan != -1 && map.get(tiklanan).getA() == 1){
            oyuncu_1.get(map.get(tiklanan).getOyuncu_indexi()).setCap(0);
            oyuncu_1.get(map.get(tiklanan).getOyuncu_indexi()).setX(0);
            oyuncu_1.get(map.get(tiklanan).getOyuncu_indexi()).setY(0);
            oyuncu_1.get(map.get(tiklanan).getOyuncu_indexi()).setKonumindexi(-1);
            map.get(tiklanan).setA(0);
            map.get(tiklanan).setDurum(true);
            map.get(tiklanan).setOyuncu_indexi(-1);
            yeme2 = false;
             for (int i = 0; i < oyuncu_1.size(); i++) {
                oyuncu_1.get(i).setDurum(true);
            }
            }
            
        }
       
        eski_konumlari_tut();
        mapi_sifirla();
        repaint();
        if (!yeme2) {
            yon_kontrol1();
        }
        oyun_bitti();

    }

    @Override
    public void mousePressed(MouseEvent e) {
        tiklanan = koordinat_kontrol(x, y);
        temp = oyuncu1_bas_kor_kontrol(x, y);
        temp2 = oyuncu2_bas_kor_kontrol(x, y);
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (sayac1 < 18) {
            x = e.getX();
            y = e.getY();
            tempkonum = koordinat_kontrol(x, y);
            
            if (temp != -1 && oyuncu1oyna && oyuncu_1.get(temp).getDurum()) {
                oyuncu_1.get(temp).setCap(80);
                oyuncu_1.get(temp).setX(x - 35);
                oyuncu_1.get(temp).setY(y - 35);

            }
            if (temp2 != -1 && oyuncu2oyna && oyuncu_2.get(temp2).getDurum()) {
                oyuncu_2.get(temp2).setCap(80);
                oyuncu_2.get(temp2).setX(x - 35);
                oyuncu_2.get(temp2).setY(y - 35);

            }
        }
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (sayac1 < 18) {
            x = e.getX();
            y = e.getY();

        }
        if(yeme1){
            for (int i = 0; i < oyuncu_2.size(); i++) {
                oyuncu_2.get(i).setDurum(false);
            }
        }else if(yeme2){
            for (int i = 0; i < oyuncu_1.size(); i++) {
                oyuncu_1.get(i).setDurum(false);
            }
        }
        yenenindex = koordinat_kontrol(x, y);
        repaint();
    }

    public void eski_konumlari_tut() {
        for (int i = 0; i < oyuncu_1.size(); i++) {
            oyuncu1_oncekikoordinatx[i] = oyuncu_1.get(i).getX();
            oyuncu1_oncekikoordinaty[i] = oyuncu_1.get(i).getY();

            konumindexi1[i] = oyuncu_1.get(i).getKonumindexi();

        }
        for (int i = 0; i < oyuncu_2.size(); i++) {
            oyuncu2_oncekikoordinatx[i] = oyuncu_2.get(i).getX();
            oyuncu2_oncekikoordinaty[i] = oyuncu_2.get(i).getY();
            konumindexi2[i] = oyuncu_2.get(i).getKonumindexi();
        }
    }

    public void mapi_sifirla() {
        for (int i = 0; i < 24; i++) {
            map.get(i).setDurum(true);
        }
        for (int i = 0; i < 9; i++) {
            if (konumindexi1[i] != -1) {
                map.get(konumindexi1[i]).setDurum(false);
            }
            if (konumindexi2[i] != -1) {
                map.get(konumindexi2[i]).setDurum(false);
            }
        }
    }

    public void elemanlari_yerlestir() {
        konumtut = koordinat_kontrol(x, y);
        if (elemanmi(x, y) && map.get(konumtut).getDurum()) {
            if (!yeme2 && oyuncu1oyna && oyuncu_1.get(temp).getDurum()) {
                oyuncu_1.get(temp).setX(x - 40);
                oyuncu_1.get(temp).setY(y - 40);
                oyuncu_1.get(temp).setDurum(false);
                oyuncu_1.get(temp).setKonumindexi(konumtut);
                oyuncu_1.get(temp).setHamlesayisi(1);
                map.get(oyuncu_1.get(temp).getKonumindexi()).setA(1);
                map.get(oyuncu_1.get(temp).getKonumindexi()).setOyuncu_indexi(oyuncu_1.get(temp).getIndex());
                oyuncu_degistir();
                sayac1++;
                sayac++;
                muzikCal(surukle, 0, true);
                repaint();
            } else if (!yeme1 && oyuncu2oyna && oyuncu_2.get(temp2).getDurum()) {
                oyuncu_2.get(temp2).setX(x - 40);
                oyuncu_2.get(temp2).setY(y - 40);
                oyuncu_2.get(temp2).setDurum(false);
                oyuncu_2.get(temp2).setHamlesayisi(1);
                oyuncu_2.get(temp2).setKonumindexi(konumtut);
                map.get(oyuncu_2.get(temp2).getKonumindexi()).setA(2);
                map.get(oyuncu_2.get(temp2).getKonumindexi()).setOyuncu_indexi(oyuncu_2.get(temp2).getIndex());
                sayac++;
                sayac1++;
                oyuncu_degistir();
                muzikCal(surukle, 0, true);
                repaint();

            }
        } else {
            if (oyuncu1oyna && oyuncu_1.get(temp).getDurum()) {
                oyuncu_1.get(temp).setX(oyuncu1_oncekikoordinatx[temp]);
                oyuncu_1.get(temp).setY(oyuncu1_oncekikoordinaty[temp]);
                if (oyuncu_1.get(temp).getHamlesayisi() == 0) {
                    oyuncu_1.get(temp).setCap(40);
                }
                repaint();

            }
            if (oyuncu2oyna && oyuncu_2.get(temp2).getDurum()) {
                oyuncu_2.get(temp2).setX(oyuncu2_oncekikoordinatx[temp2]);
                oyuncu_2.get(temp2).setY(oyuncu2_oncekikoordinaty[temp2]);
                if (oyuncu_2.get(temp2).getHamlesayisi() == 0) {
                    oyuncu_2.get(temp2).setCap(40);
                }
                repaint();

            }
        }
        if (sayac >= 18) {
            for (int i = 0; i < oyuncu_1.size(); i++) {
                oyuncu_1.get(i).setDurum(true);

            }
            for (int i = 0; i < oyuncu_2.size(); i++) {
                oyuncu_2.get(i).setDurum(true);
            }

        }

        repaint();
    }

    public int oyuncu1_bas_kor_kontrol(int a, int b) {
        for (int i = 0; i < oyuncu_1.size(); i++) {
            if (a > oyuncu_1.get(i).getX() && a < oyuncu_1.get(i).getX() + 80 && b > oyuncu_1.get(i).getY()
                    && b < oyuncu_1.get(i).getY() + 80) {
                return i;
            }
        }
        return -1;
    }

    public int oyuncu2_bas_kor_kontrol(int a, int b) {
        for (int i = 0; i < oyuncu_2.size(); i++) {
            if (a > oyuncu_2.get(i).getX() && a < oyuncu_2.get(i).getX() + 80 && b > oyuncu_2.get(i).getY()
                    && b < oyuncu_2.get(i).getY() + 80) {
                return i;
            }
        }
        return -1;
    }

    public void elemanlari_olustur() {
        int temp1 = 100, temp2 = 200;
        for (int i = 0; i < 9; i++) {
            oyuncu_1.add(new Oyuncu_1(temp1, temp2, 0, 40, true, -1, i));
            temp2 += 50;
        }
        temp1 = 1150;
        temp2 = 200;
        for (int i = 0; i < 9; i++) {

            oyuncu_2.add(new Oyuncu_2(temp1, temp2, 0, 40, true, -1, i));
            temp2 += 50;
        }

    }

    public boolean elemanmi(int a, int b) {
        for (int i = 0; i < xkor.length; i++) {
            if (a == xkor[i]) {
                for (int j = 0; j < ykor.length; j++) {
                    if (y == ykor[i]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int koordinat_kontrol(int a, int b) {
        for (int i = 0; i < xkor.length; i++) {
            if (a > xkor[i] - 40 && a < xkor[i] + 40 && b > ykor[i] - 40 && b < ykor[i] + 40) {
                x = xkor[i];
                y = ykor[i];
                return i;
            }
        }
        return -1;
    }

    public void oyuncu_degistir() {
        if (oyuncu1oyna) {
            oyuncu2oyna = true;
            oyuncu1oyna = false;
            lx.setText("SIRA "+ l2.getText()+ " 'DE");
        } else {
            oyuncu2oyna = false;
            oyuncu1oyna = true;
            lx.setText("SIRA "+l1.getText()+ " 'DE");
        }
    }

    public void alanlari_belirle() {
        for (int i = 0; i < 24; i++) {
            alandurumu a = new alandurumu(xkor[i], ykor[i], true, i, 0, -1);
            map.add(a);
        }
        map.get(0).sag = map.get(1);
        map.get(0).asagi = map.get(9);
        map.get(1).sol = map.get(0);
        map.get(1).asagi = map.get(4);
        map.get(1).sag = map.get(2);
        map.get(2).sol = map.get(1);
        map.get(2).asagi = map.get(14);
        map.get(3).asagi = map.get(10);
        map.get(3).sag = map.get(4);
        map.get(4).sol = map.get(3);
        map.get(4).asagi = map.get(7);
        map.get(4).sag = map.get(5);
        map.get(4).yukari = map.get(1);
        map.get(5).sol = map.get(4);
        map.get(5).asagi = map.get(13);
        map.get(6).asagi = map.get(11);
        map.get(6).sag = map.get(7);
        map.get(7).sol = map.get(6);
        map.get(7).yukari = map.get(4);
        map.get(7).sag = map.get(8);
        map.get(8).sol = map.get(7);
        map.get(8).asagi = map.get(12);
        map.get(9).yukari = map.get(0);
        map.get(9).asagi = map.get(21);
        map.get(9).sag = map.get(10);
        map.get(10).yukari = map.get(3);
        map.get(10).asagi = map.get(18);
        map.get(10).sag = map.get(11);
        map.get(10).sol = map.get(9);
        map.get(11).asagi = map.get(15);
        map.get(11).yukari = map.get(6);
        map.get(11).sol = map.get(10);
        map.get(12).yukari = map.get(8);
        map.get(12).asagi = map.get(17);
        map.get(12).sag = map.get(13);
        map.get(13).yukari = map.get(5);
        map.get(13).asagi = map.get(20);
        map.get(13).sag = map.get(14);
        map.get(13).sol = map.get(12);
        map.get(14).yukari = map.get(2);
        map.get(14).asagi = map.get(23);
        map.get(14).sol = map.get(13);
        map.get(15).yukari = map.get(11);
        map.get(15).sag = map.get(16);
        map.get(16).sag = map.get(17);
        map.get(16).sol = map.get(15);
        map.get(16).asagi = map.get(19);
        map.get(17).yukari = map.get(12);
        map.get(17).sol = map.get(16);// tamam
        map.get(18).yukari = map.get(10);
        map.get(18).sag = map.get(19);
        map.get(19).sag = map.get(20);
        map.get(19).sol = map.get(18);
        map.get(19).yukari = map.get(16);
        map.get(19).asagi = map.get(22);
        map.get(20).sol = map.get(19);
        map.get(20).yukari = map.get(13);
        map.get(21).yukari = map.get(9);
        map.get(21).sag = map.get(22);
        map.get(22).sag = map.get(23);
        map.get(22).sol = map.get(21);
        map.get(22).yukari = map.get(19);
        map.get(23).yukari = map.get(14);
        map.get(23).sol = map.get(22);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        try {
            if (e.getKeyCode() == e.VK_RIGHT && tiklanan != -1) {
                if (map.get(tiklanan).sag != null && map.get(tiklanan).sag.getDurum()) {
                    if (oyuncu1oyna) {
                        oyuncu_1.get(temp).setX(map.get(tiklanan).sag.getX() - 40);
                        oyuncu_1.get(temp).setY(map.get(tiklanan).sag.getY() - 40);
                        oyuncu_1.get(temp).setKonumindexi(map.get(tiklanan).sag.getIndex());
                        map.get(tiklanan).setDurum(true);
                        map.get(tiklanan).sag.setDurum(false);
                        map.get(tiklanan).setA(0);
                        map.get(tiklanan).setOyuncu_indexi(-1);
                        map.get(tiklanan).sag.setOyuncu_indexi(oyuncu_1.get(temp).getIndex());
                        map.get(tiklanan).sag.setA(1);
                        repaint();
                        oyuncu_degistir();
                        suruklebiraktakikonum = map.get(tiklanan).sag.getIndex();
                        kontrol();
                        yon_kontrol1();
                        muzikCal(surukle, 0, true);

                    } else if (oyuncu2oyna) {
                        oyuncu_2.get(temp2).setX(map.get(tiklanan).sag.getX() - 40);
                        oyuncu_2.get(temp2).setY(map.get(tiklanan).sag.getY() - 40);
                        oyuncu_2.get(temp2).setKonumindexi(map.get(tiklanan).sag.getIndex());
                        map.get(tiklanan).setOyuncu_indexi(-1);
                        map.get(tiklanan).sag.setOyuncu_indexi(oyuncu_2.get(temp2).getIndex());
                        map.get(tiklanan).setDurum(true);
                        map.get(tiklanan).sag.setDurum(false);
                        map.get(tiklanan).setA(0);
                        map.get(tiklanan).sag.setA(2);
                        repaint();
                        oyuncu_degistir();
                        suruklebiraktakikonum = map.get(tiklanan).sag.getIndex();
                        kontrol();
                        yon_kontrol1();
                        muzikCal(surukle, 0, true);
                    }

                }
            }
            if (e.getKeyCode() == e.VK_LEFT && tiklanan != -1) {
                if (map.get(tiklanan).sol != null && map.get(tiklanan).sol.getDurum()) {
                    if (oyuncu1oyna) {
                        oyuncu_1.get(temp).setX(map.get(tiklanan).sol.getX() - 40);
                        oyuncu_1.get(temp).setY(map.get(tiklanan).sol.getY() - 40);
                        oyuncu_1.get(temp).setKonumindexi(map.get(tiklanan).sol.getIndex());
                        map.get(tiklanan).setDurum(true);
                        map.get(tiklanan).sol.setDurum(false);
                        map.get(tiklanan).setOyuncu_indexi(-1);
                        map.get(tiklanan).sol.setOyuncu_indexi(oyuncu_1.get(temp).getIndex());
                        map.get(tiklanan).setA(0);
                        map.get(tiklanan).sol.setA(1);
                        oyuncu_degistir();
                        repaint();
                        suruklebiraktakikonum = map.get(tiklanan).sol.getIndex();
                        kontrol();
                        yon_kontrol1();
                        muzikCal(surukle, 0, true);
                    } else if (oyuncu2oyna) {
                        oyuncu_2.get(temp2).setX(map.get(tiklanan).sol.getX() - 40);
                        oyuncu_2.get(temp2).setY(map.get(tiklanan).sol.getY() - 40);
                        oyuncu_2.get(temp2).setKonumindexi(map.get(tiklanan).sol.getIndex());
                        map.get(tiklanan).setDurum(true);
                        map.get(tiklanan).sol.setDurum(false);
                        map.get(tiklanan).setOyuncu_indexi(-1);
                        map.get(tiklanan).sol.setOyuncu_indexi(oyuncu_2.get(temp2).getIndex());
                        map.get(tiklanan).setA(0);
                        map.get(tiklanan).sol.setA(2);
                        oyuncu_degistir();
                        repaint();
                        suruklebiraktakikonum = map.get(tiklanan).sol.getIndex();
                        kontrol();
                        yon_kontrol1();
                        muzikCal(surukle, 0, true);
                    }

                }
            }
            if (e.getKeyCode() == e.VK_UP && tiklanan != -1) {
                if (map.get(tiklanan).yukari != null && map.get(tiklanan).yukari.getDurum()) {
                    if (oyuncu1oyna) {
                        oyuncu_1.get(temp).setX(map.get(tiklanan).yukari.getX() - 40);
                        oyuncu_1.get(temp).setY(map.get(tiklanan).yukari.getY() - 40);
                        oyuncu_1.get(temp).setKonumindexi(map.get(tiklanan).yukari.getIndex());
                        map.get(tiklanan).setDurum(true);
                        map.get(tiklanan).yukari.setDurum(false);
                        map.get(tiklanan).setOyuncu_indexi(-1);
                        map.get(tiklanan).yukari.setOyuncu_indexi(oyuncu_1.get(temp).getIndex());
                        map.get(tiklanan).setA(0);
                        map.get(tiklanan).yukari.setA(1);
                        oyuncu_degistir();
                        repaint();
                        suruklebiraktakikonum = map.get(tiklanan).yukari.getIndex();
                        kontrol();
                        yon_kontrol1();
                        muzikCal(surukle, 0, true);
                    } else if (oyuncu2oyna) {
                        oyuncu_2.get(temp2).setX(map.get(tiklanan).yukari.getX() - 40);
                        oyuncu_2.get(temp2).setY(map.get(tiklanan).yukari.getY() - 40);
                        oyuncu_2.get(temp2).setKonumindexi(map.get(tiklanan).yukari.getIndex());
                        map.get(tiklanan).setDurum(true);
                        map.get(tiklanan).yukari.setDurum(false);
                        map.get(tiklanan).setOyuncu_indexi(-1);
                        map.get(tiklanan).yukari.setOyuncu_indexi(oyuncu_2.get(temp2).getIndex());
                        map.get(tiklanan).setA(0);
                        map.get(tiklanan).yukari.setA(2);
                        oyuncu_degistir();
                        repaint();
                        suruklebiraktakikonum = map.get(tiklanan).yukari.getIndex();
                        kontrol();
                        yon_kontrol1();
                        muzikCal(surukle, 0, true);
                    }

                }
            }
            if (e.getKeyCode() == e.VK_DOWN && tiklanan != -1) {
                if (map.get(tiklanan).asagi != null && map.get(tiklanan).asagi.getDurum()) {
                    if (oyuncu1oyna) {
                        oyuncu_1.get(temp).setX(map.get(tiklanan).asagi.getX() - 40);
                        oyuncu_1.get(temp).setY(map.get(tiklanan).asagi.getY() - 40);
                        oyuncu_1.get(temp).setKonumindexi(map.get(tiklanan).asagi.getIndex());
                        map.get(tiklanan).setDurum(true);
                        map.get(tiklanan).asagi.setDurum(false);
                        map.get(tiklanan).setOyuncu_indexi(-1);
                        map.get(tiklanan).asagi.setOyuncu_indexi(oyuncu_1.get(temp).getIndex());
                        map.get(tiklanan).setA(0);
                        map.get(tiklanan).asagi.setA(1);
                        oyuncu_degistir();
                        repaint();
                        suruklebiraktakikonum = map.get(tiklanan).asagi.getIndex();
                        kontrol();
                        yon_kontrol1();
                        muzikCal(surukle, 0, true);
                    } else if (oyuncu2oyna) {
                        oyuncu_2.get(temp2).setX(map.get(tiklanan).asagi.getX() - 40);
                        oyuncu_2.get(temp2).setY(map.get(tiklanan).asagi.getY() - 40);
                        oyuncu_2.get(temp2).setKonumindexi(map.get(tiklanan).asagi.getIndex());
                        map.get(tiklanan).setDurum(true);
                        map.get(tiklanan).asagi.setDurum(false);
                        map.get(tiklanan).setOyuncu_indexi(-1);
                        map.get(tiklanan).asagi.setOyuncu_indexi(oyuncu_2.get(temp2).getIndex());
                        map.get(tiklanan).setA(0);
                        map.get(tiklanan).asagi.setA(2);
                        oyuncu_degistir();
                        repaint();
                        suruklebiraktakikonum = map.get(tiklanan).asagi.getIndex();
                        kontrol();
                        yon_kontrol1();
                        muzikCal(surukle, 0, true);
                    }

                }
            }
        } catch (Exception a) {

        }

        eski_konumlari_tut();
        mapi_sifirla();
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public boolean yatay_kontrol(int index) {
        if (index != -1) {
            alandurumu aktif = map.get(index);
            if (aktif.sol == null) {
                if (aktif.getA() == aktif.sag.getA() && aktif.getA() == aktif.sag.sag.getA()) {
                    return true;
                }
            } else if (aktif.sag == null) {
                if (aktif.getA() == aktif.sol.getA() && aktif.getA() == aktif.sol.sol.getA()) {
                    return true;
                }
            } else if (aktif.sag != null && aktif.sol != null) {
                if (aktif.getA() == aktif.sag.getA() && aktif.getA() == aktif.sol.getA()) {
                    return true;
                }
            }
        }
        return false;

    }

    public boolean dikey_kontrol(int index) {
        if (index != -1) {
            alandurumu aktif = map.get(index);
            if (aktif.yukari == null) {
                if (aktif.getA() == aktif.asagi.getA() && aktif.getA() == aktif.asagi.asagi.getA()) {
                    return true;
                }
            } else if (aktif.asagi == null) {
                if (aktif.getA() == aktif.yukari.getA() && aktif.getA() == aktif.yukari.yukari.getA()) {
                    return true;
                }
            } else if (aktif.asagi != null && aktif.yukari != null) {
                if (aktif.getA() == aktif.asagi.getA() && aktif.getA() == aktif.yukari.getA()) {
                    return true;
                }
            }
        }
        return false;

    }

    public void kontrol() {

        if (yatay_kontrol(suruklebiraktakikonum) || dikey_kontrol(suruklebiraktakikonum)) {
            muzikCal(yupi, 0, true);
            if (oyuncu2oyna) {
                JOptionPane.showMessageDialog(null, "YENECEK TAŞ SEÇ "+l1.getText());
                yeme1 = true;

            } else if (oyuncu1oyna) {
                JOptionPane.showMessageDialog(null, "YENECEK TAŞ SEÇ "+l2.getText());
                yeme2 = true;

            }
        }
    }

    public int oyun_bitti_mi_1() {
        int sayac = 0;
        for (int i = 0; i < oyuncu_1.size(); i++) {
            if (oyuncu_1.get(i).getCap() == 0) {
                sayac++;

            }
        }
        return sayac;
    }

    public int oyun_bitti_mi_2() {
        int sayac = 0;
        for (int i = 0; i < oyuncu_2.size(); i++) {
            if (oyuncu_2.get(i).getCap() == 0) {
                sayac++;

            }
        }
        return sayac;
    }

    public boolean oyun_bitti_mi_kontrol() {
        if (oyun_bitti_mi_1() == 7  ) {
            kazanan=l2.getText();
            return true;
        }else if(oyun_bitti_mi_2() == 7){
             kazanan=l1.getText();
            return true;
        }
        return false;
    }

    public void oyun_bitti() {
        if (oyun_bitti_mi_kontrol()) {
            isim_alma.pc.setVisible(false);
            Giris_Ekrani.giris.setVisible(false);
             pencere = new JFrame("OYUN BİTTİ");
            pencere.setSize(800, 500);
            pencere.add(new Oyun_Bitti());
            pencere.setLocationRelativeTo(null);
            pencere.setUndecorated(true);
            pencere.setResizable(false);
            pencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            pencere.setVisible(true);

        }
    }

    public void yon_kontrol1() {
        int kapaliTas = 0, map_icerisinde = 0;

        for (int i = 0; i < oyuncu_1.size(); i++) {
            int sayac = 0;
            if (oyuncu_1.get(i).getKonumindexi() != -1) {
                if (map.get(oyuncu_1.get(i).getKonumindexi()).sag != null) {
                    if (!(map.get(oyuncu_1.get(i).getKonumindexi()).sag.getDurum())) {
                        sayac++;
                    }
                } else {
                    sayac++;
                }
                if (map.get(oyuncu_1.get(i).getKonumindexi()).asagi != null) {
                    if (!(map.get(oyuncu_1.get(i).getKonumindexi()).asagi.getDurum())) {
                        sayac++;
                    }
                } else {
                    sayac++;
                }
                if (map.get(oyuncu_1.get(i).getKonumindexi()).sol != null) {
                    if (!(map.get(oyuncu_1.get(i).getKonumindexi()).sol.getDurum())) {
                        sayac++;
                    }
                } else {
                    sayac++;
                }
                if (map.get(oyuncu_1.get(i).getKonumindexi()).yukari != null) {
                    if (!(map.get(oyuncu_1.get(i).getKonumindexi()).yukari.getDurum())) {
                        sayac++;
                    }
                } else {
                    sayac++;
                }
                if (sayac == 4) {
                    kapaliTas++;
                }

                map_icerisinde++;
            }

        }
        if (map_icerisinde == kapaliTas) {
            JOptionPane.showMessageDialog(null, "Köşeye sıkıştı!!");

            oyun_bitti();
        }
    }
 public static void muzikCal(URL yol,int tekrar,boolean devam)
{
    
   
    try {
    AudioInputStream sesDosyasi = AudioSystem.getAudioInputStream(yol);
    Clip sesGetir = AudioSystem.getClip();
    sesGetir.open(sesDosyasi);
    sesGetir.start();
    sesGetir.loop(tekrar);
        if (!devam) {
          sesGetir.stop();
        }
} catch(Exception ex) {
    System.out.println("Ses dosyasında hata!!!");
    ex.printStackTrace();
}

}
 
}
