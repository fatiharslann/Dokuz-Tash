
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Giris_Ekrani  {

    Anamenu menu;
    static JFrame giris;
    public Giris_Ekrani() {
        giris=new JFrame("DOKUZ TAŞ");
        menu=new Anamenu();
        giris.setSize(700, 500);
         giris.setLayout(null);
         giris.setResizable(false);
         giris.setLocationRelativeTo(null);
         giris.setUndecorated(true);
         giris.setLayout(null);
         giris.add(menu);
         giris.setVisible(true);
    }

    public static void main(String[] args) {
        new Giris_Ekrani();
    }
}
