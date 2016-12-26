
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Anamenu extends JPanel{

   
    private JButton basla, bitir,nasil_oynanir,ayarlar;
    private JLabel arka;
    private ImageIcon arkaplan = new ImageIcon(getClass().getResource("Giris.png"));
    
   public Anamenu(){
        setSize(700, 500);
        setLayout(null);
        basla = new JButton();
        basla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
               Giris_Ekrani.giris.add(new isim_alma());
                
           
            }
        });
        
        bitir = new JButton();
        bitir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        ayarlar=new JButton();
        ayarlar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Giris_Ekrani.giris.add(new ayarlar());
            }
        });
        ayarlar.setBounds(210,250,300,70);
        nasil_oynanir=new JButton();
        nasil_oynanir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                
               Giris_Ekrani.giris.add(new nasil_oynanir());
            }
        });
        nasil_oynanir.setBounds(210,160,300,70);
        nasil_oynanir.setOpaque(false);
        nasil_oynanir.setContentAreaFilled(false);
        nasil_oynanir.setBorderPainted(false);
        ayarlar.setOpaque(false);
        ayarlar.setContentAreaFilled(false);
        ayarlar.setBorderPainted(false);
        basla.setBounds(210, 80, 300, 70);
        basla.setOpaque(true);
        basla.setContentAreaFilled(false);
        basla.setBorderPainted(false);
        bitir.setBounds(210, 340, 300, 70);
        bitir.setOpaque(false);
        bitir.setContentAreaFilled(false);
        bitir.setBorderPainted(false);
        add(basla);
        add(bitir);
        add(nasil_oynanir);
        add(ayarlar);
        arka = new JLabel(arkaplan);
        arka.setBounds(0, 0, 700, 500);
        add(arka);
        
        
   }
}
