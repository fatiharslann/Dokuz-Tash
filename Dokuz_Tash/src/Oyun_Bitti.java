
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Oyun_Bitti extends JPanel {

    JLabel label, kazanan, kazanan1;
    Font font;
    ImageIcon icon = new ImageIcon(getClass().getResource("havaifisek1.gif"));
    Image k = new ImageIcon(getClass().getResource("kazanan.png")).getImage();
    JButton tekrar,bitir;
    public Oyun_Bitti() {
        font = new Font("Algerian", Font.BOLD, 50);
        label = new JLabel(icon);
        kazanan = new JLabel("KAZANAN ");
        kazanan.setFont(font);
        kazanan.setBounds(250, 50, 500, 70);

        kazanan1 = new JLabel(Oyun_Ekrani.kazanan);
        kazanan1.setFont(font);
        kazanan1.setBounds(290, 150, 500, 70);

        label.setFont(font);
        setBounds(0, 0, 600, 600);
        setLayout(null);
        label.setBounds(400, 100, 500, 200);
        tekrar=new JButton("T  E  K  R  A  R");
        bitir=new JButton("B  İ  T  İ  R");
        tekrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Oyun_Ekrani.pencere.setVisible(false);
                new Giris_Ekrani();
            }
        });
        bitir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        tekrar.setBounds(50,400,200,100);
        bitir.setBounds(300,400,200,100);
        bitir.setOpaque(false);
        bitir.setContentAreaFilled(false);
        bitir.setBorderPainted(false);
        tekrar.setOpaque(false);
        tekrar.setContentAreaFilled(false);
        tekrar.setBorderPainted(false);
        add(tekrar);
        add(bitir);
        add(kazanan1);
        add(kazanan);
        add(label);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(k, 10, 10, 200, 300, null);
    }
}
