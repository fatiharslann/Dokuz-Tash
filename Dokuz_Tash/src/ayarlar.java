
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ayarlar extends JPanel{
    private ImageIcon icon=new ImageIcon(getClass().getResource("geri.png"));
    private ImageIcon onay=new ImageIcon(getClass().getResource("onay.png"));
    private JLabel label;
    private JButton geri,kaydet;
    static JComboBox combo,tas1,tas2,map;
    Font yazi = new Font("verdana", Font.BOLD, 15);
    Font baslik = new java.awt.Font("Algerian",Font.BOLD, 35);
   static ComboBoxModel arkaplan;
  
 
   
   
   static String t1="TAS-2",t2="TAS-3",mapp="MAP-1";
    private Image mp1 = new ImageIcon(getClass().getResource("MAP\\"+mapp+ ".png")).getImage();
    private  Image ot1 = new ImageIcon(getClass().getResource("OYUNCU-1\\"+t1+".png")).getImage();
    private Image ot2 = new ImageIcon(getClass().getResource("OYUNCU-2\\"+t2+".png")).getImage();
   static Color renk=new Color(149,117,114);
   
    public ayarlar() {
        kaydet=new JButton(onay);
        kaydet.setBounds(600,400,100,100);
        kaydet.setOpaque(false);
        kaydet.setContentAreaFilled(false);
        kaydet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                renk_belirle();
                taslari_belirle();
                mapi_belirle();
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
        setBounds(0,0,700,500);
        setLayout(null);
        setBackground(new Color(113, 99, 169));
        label=new JLabel("AYARLAR");
        label.setForeground(Color.WHITE);
        label.setFont(baslik);
        label.setBounds(200,20,200,50);
        add(label);
        label=new JLabel("ARKA PLAN RENGİ: ");
        label.setFont(yazi);
        label.setForeground(Color.WHITE);
        label.setBounds(50,150,200,50);
        add(label);
        combo=new JComboBox();
        combo.addItem("SIYAH");
        combo.addItem("BEYAZ");
        combo.addItem("GRI");
        combo.addItem("MAVI");
        combo.addItem("MAGENTA");
        combo.addItem("CYAN");
        combo.addItem("KIRMIZI");
        
        combo.setBounds(250,160,200,40);
        combo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
              renk_belirle();
               repaint();
            }
        });
        add(combo);
        renk_belirle();
        
        label=new JLabel("OYUNCU-1 TASI : ");
        label.setFont(yazi);
        label.setForeground(Color.WHITE);
        label.setBounds(50,250,200,50);
        add(label);
        tas1=new JComboBox();
        tas1.addItem("TAS-1");
        tas1.addItem("TAS-2");
        tas1.addItem("TAS-3");
        
        tas1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                
                taslari_belirle();
                ot1 = new ImageIcon(getClass().getResource("OYUNCU-1\\"+ayarlar.t1+".png")).getImage();
                repaint();
            }
        });
        tas1.setBounds(250,250,150,40);
        add(tas1);
       
        label=new JLabel("OYUNCU-2 TASI : ");
        label.setFont(yazi);
        label.setBounds(50,330,200,50);
        label.setForeground(Color.WHITE);
        add(label);
        tas2=new JComboBox();
        tas2.addItem("TAS-1");
        tas2.addItem("TAS-2");
        tas2.addItem("TAS-3");
        
        tas2.setBounds(250,330,150,40);
        tas2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                
                taslari_belirle();
                ot2 = new ImageIcon(getClass().getResource("OYUNCU-2\\"+ayarlar.t2+".png")).getImage();
                repaint();
            }
        });
        add(tas2);
        taslari_belirle();
        label=new JLabel("OYUN TAHTASI : ");
        label.setFont(yazi);
        label.setBounds(50,415,200,50);
        label.setForeground(Color.WHITE);
        add(label);
        map=new JComboBox();
       map.addItem("MAP-1");
        map.addItem("MAP-2");
        map.addItem("MAP-3");
        
        map.setBounds(250,420,150,40);
        map.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                
                mapi_belirle();
                mp1 = new ImageIcon(getClass().getResource("MAP\\"+ayarlar.mapp+".png")).getImage();
                repaint();
            }
        });
        
        add(map);
        
    }
    public void renk_belirle(){
        if(combo.getSelectedItem().toString()=="SIYAH"){
            renk=Color.BLACK;
        }else if(combo.getSelectedItem().toString()=="MAVI"){
            renk=Color.BLUE;
        }else if(combo.getSelectedItem().toString()=="KIRMIZI"){
            renk=Color.RED;
        }else if(combo.getSelectedItem().toString()=="CYAN"){
            renk=Color.CYAN;
        }else if(combo.getSelectedItem().toString()=="MAGENTA"){
            renk=Color.MAGENTA;
        }else if(combo.getSelectedItem().toString()=="GRI"){
            renk=Color.GRAY;
        }else if(combo.getSelectedItem().toString()=="BEYAZ"){
            renk=Color.WHITE;
        }
    }
    public void taslari_belirle(){
        if(tas1.getSelectedItem().toString()=="TAS-1"){
            t1="TAS-1";
        }else if(tas1.getSelectedItem().toString()=="TAS-2"){
            t1="TAS-2";
        }else if(tas1.getSelectedItem().toString()=="TAS-3"){
            t1="TAS-3";
        }
        if(tas2.getSelectedItem().toString()=="TAS-1"){
            t2="TAS-1";
        }else if(tas2.getSelectedItem().toString()=="TAS-2"){
            t2="TAS-2";
        }else if(tas2.getSelectedItem().toString()=="TAS-3"){
            t2="TAS-3";
        }
    }
    public void mapi_belirle(){
         if(map.getSelectedItem().toString()=="MAP-1"){
            mapp="MAP-1";
        }else if(map.getSelectedItem().toString()=="MAP-2"){
            mapp="MAP-2";
        }
         else if(map.getSelectedItem().toString()=="MAP-3"){
            mapp="MAP-3";
        }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(renk);
        g.fillRect(500,150  , 50, 50);
        g.drawImage(ot1 , 500, 240, 50,50,null);
        g.drawImage(ot2 , 500, 325, 50,50,null);
        g.drawImage(mp1,500,400,75,75,null);
    }
    
}
