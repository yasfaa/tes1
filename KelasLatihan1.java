import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JToggleButton;


public class KelasLatihan1 extends JFrame {
    private static String selectedShape = "Buat Garis";
    private static String selectedLine = "Tipe Garis Solid";
    private static Color selectedColor1 = Color.green;
    private static Color selectedColor2 = Color.blue;
    private static String selectedTransform = "Posisi Awal";
    private static boolean isTextureEnabled = false;

    public static void main(String[] args) {
        // create the frame
        JFrame jframe = new KelasLatihan1();
        jframe.setSize(1000, 2000);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create the menubar
        JMenuBar jmenu = new JMenuBar();

        // create jcombobox
        JComboBox<String> comboBox1 = new JComboBox<>(
                new String[]{"Buat Garis", "Buat Persegi Panjang", "Buat Ellips", "Buat Segitiga"});
        JComboBox<String> comboBox2 = new JComboBox<>(new String[]{"Tipe Garis Solid", "Tipe Garis Putus Panjang",
                "Tipe Garis Putus Pendek", "Tipe Garis Titik-Titik"});
        JComboBox<String> comboBox3 = new JComboBox<>(new String[]{"Posisi Awal", "Refleksi"});
        JToggleButton textureToggle = new JToggleButton("Aktifkan Tekstur");
jmenu.add(textureToggle);


        JMenu colorMenu = new JMenu("Warna Garis");
        // JMenuItem gradientItem = new JMenuItem("Gradient Warna");
        JMenu color1Menu = new JMenu("Warna 1");
        JMenu color2Menu = new JMenu("Warna 2");
        JMenuItem blackItem1 = new JMenuItem("Hitam");
        JMenuItem redItem1 = new JMenuItem("Merah");
        JMenuItem greenItem1 = new JMenuItem("Hijau");
        JMenuItem blueItem1 = new JMenuItem("Biru");
        JMenuItem blackItem2 = new JMenuItem("Hitam");
        JMenuItem redItem2 = new JMenuItem("Merah");
        JMenuItem greenItem2 = new JMenuItem("Hijau");
        JMenuItem blueItem2 = new JMenuItem("Biru");

        // add the combobox to the menu
        jmenu.add(comboBox1);
        jmenu.add(comboBox2);
        jmenu.add(comboBox3);
        jmenu.add(colorMenu);
        // colorMenu.add(gradientItem);
        colorMenu.add(color1Menu);
        colorMenu.add(color2Menu);
        color1Menu.add(blackItem1);
        color1Menu.add(redItem1);
        color1Menu.add(greenItem1);
        color1Menu.add(blueItem1);
        color2Menu.add(blackItem2);
        color2Menu.add(redItem2);
        color2Menu.add(greenItem2);
        color2Menu.add(blueItem2);

        // create the textfield
        JTextField textField = new JTextField(10);
        textField.setText("3");

        // add the menus to the menubar
        jmenu.add(textField);

        // create canvas for painting shapes
Canvas canvas = new Canvas() {
    public void paint(Graphics g) {
        super.paint(g);
        int thick = Integer.valueOf(textField.getText());
        // get the value comboBox1
        String selectedShape = (String) comboBox1.getSelectedItem();
        if (selectedShape.equals("Buat Garis")) {
            // draw line
            Graphics2D g2d = (Graphics2D) g;
            if (selectedLine.equals("Tipe Garis Solid")) {
                g2d.setStroke(new BasicStroke(thick, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
            } else if (selectedLine.equals("Tipe Garis Putus Panjang")) {
                g2d.setStroke(new BasicStroke(thick, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0,
                        new float[]{10}, 0));
            } else if (selectedLine.equals("Tipe Garis Putus Pendek")) {
                g2d.setStroke(new BasicStroke(thick, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0,
                        new float[]{4}, 0));
            } else if (selectedLine.equals("Tipe Garis Titik-Titik")) {
                g2d.setStroke(new BasicStroke(thick, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0,
                        new float[]{1}, 0));
            }
            GradientPaint gradientPaint = new GradientPaint(0, 0, selectedColor1, 300, 300, selectedColor2);
            g2d.setPaint(gradientPaint);
            if (selectedTransform.equals("Posisi Awal")) {
                g2d.drawLine(100, 100, 200, 200);
            } else if (selectedTransform.equals("Refleksi")) {
                int startX = 100;
                int startY = 100;
                int endX = 200;
                int endY = 200;
            
                int reflectedStartX = 200 - (startX - 200);
                int reflectedStartY = 200 - (startY - 200);
                int reflectedEndX = 200 - (endX - 200);
                int reflectedEndY = 200 - (endY - 200);
            
                g2d.drawLine(reflectedStartX, reflectedStartY, reflectedEndX, reflectedEndY);
            }            
        } if(selectedShape.equals("Buat Persegi Panjang")){
            //draw line
            Graphics2D g2d = (Graphics2D) g;
            if(selectedLine.equals("Tipe Garis Solid")){
                g2d.setStroke(new BasicStroke(thick, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
            } else if (selectedLine.equals("Tipe Garis Putus Panjang")){
                g2d.setStroke(new BasicStroke(thick, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{10}, thick));
            } else if (selectedLine.equals("Tipe Garis Putus Pendek")){
                g2d.setStroke(new BasicStroke(thick, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{4}, thick));
            } else if (selectedLine.equals("Tipe Garis Titik-Titik")){
                g2d.setStroke(new BasicStroke(thick, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{1}, thick));
            }

            if (isTextureEnabled) {
                // Terapkan tekstur pada objek
                // ...
            } else {
                GradientPaint gradientPaint = new GradientPaint(0, 0, selectedColor1, 300, 300, selectedColor2);
                g2d.setPaint(gradientPaint);
            }

            if (selectedTransform.equals("Posisi Awal")) {
                g2d.drawRect(100, 100, 100, 100);
            } else if (selectedTransform.equals("Refleksi")) {
                g2d.drawRect(200, 200, 100, 100);
            }
        }
        if(selectedShape.equals("Buat Ellips")){
            //draw line
            Graphics2D g2d = (Graphics2D) g;
            if(selectedLine.equals("Tipe Garis Solid")){
                g2d.setStroke(new BasicStroke(thick, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
            } else if (selectedLine.equals("Tipe Garis Putus Panjang")){
                g2d.setStroke(new BasicStroke(thick, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{10}, thick));
            } else if (selectedLine.equals("Tipe Garis Putus Pendek")){
                g2d.setStroke(new BasicStroke(thick, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{4}, thick));
            } else if (selectedLine.equals("Tipe Garis Titik-Titik")){
                g2d.setStroke(new BasicStroke(thick, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{1}, thick));
            }           
            GradientPaint gradientPaint = new GradientPaint(0, 0, selectedColor1, 300, 300, selectedColor2);
            g2d.setPaint(gradientPaint);
            if (selectedTransform.equals("Posisi Awal")) {
                g2d.drawOval(100, 100, 100, 100);
            } else if (selectedTransform.equals("Refleksi")) {
                g2d.drawOval(200, 200, 100, 100);
            }
        }
        if(selectedShape.equals("Buat Segitiga")){
            //draw line
            Graphics2D g2d = (Graphics2D) g;
            if(selectedLine.equals("Tipe Garis Solid")){
                g2d.setStroke(new BasicStroke(thick, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
            } else if (selectedLine.equals("Tipe Garis Putus Panjang")){
                g2d.setStroke(new BasicStroke(thick, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{10}, thick));
            } else if (selectedLine.equals("Tipe Garis Putus Pendek")){
                g2d.setStroke(new BasicStroke(thick, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{4}, thick));
            } else if (selectedLine.equals("Tipe Garis Titik-Titik")){
                g2d.setStroke(new BasicStroke(thick, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{1}, thick));
            }           
            GradientPaint gradientPaint = new GradientPaint(0, 0, selectedColor1, 300, 300, selectedColor2);
            g2d.setPaint(gradientPaint);
            if (selectedTransform.equals("Posisi Awal")) {
                int[] xPoints = {100, 150, 200};
                int[] yPoints = {200, 100, 200};
                g2d.drawPolygon(xPoints, yPoints, 3);
            } else if (selectedTransform.equals("Refleksi")) {
                int[] xPoints = {100, 150, 200};
                int[] yPoints = {200, 100, 200};
            
                int[] reflectedXPoints = new int[3];
                int[] reflectedYPoints = new int[3];
            
                for (int i = 0; i < 3; i++) {
                    reflectedXPoints[i] = 200 - (xPoints[i] - 200);
                    reflectedYPoints[i] = 200 - (yPoints[i] - 200);
                }
            
                g2d.drawPolygon(reflectedXPoints, reflectedYPoints, 3);
            }
              
        }
    }
};
        jframe.getContentPane().add(canvas);

        // add action listener for comboBox1,2,3
        comboBox1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedShape = (String) comboBox1.getSelectedItem();
                canvas.repaint(); // redraw the canvas when combobox1 is changed
            }
        });

        comboBox2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedLine = (String) comboBox2.getSelectedItem();
                canvas.repaint(); // redraw the canvas when combobox2 is changed
            }
        });

        comboBox3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedTransform = (String) comboBox3.getSelectedItem();
                canvas.repaint(); // redraw the canvas when combobox3 is changed
            }
        });

        // gradientItem.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {
        //         Color color1 = JColorChooser.showDialog(jframe, "Pilih Warna 1", selectedColor1);
        //         if (color1 != null) {
        //             selectedColor1 = color1;
        //         }
        //         Color color2 = JColorChooser.showDialog(jframe, "Pilih Warna 2", selectedColor2);
        //         if (color2 != null) {
        //             selectedColor2 = color2;
        //         }
        //         canvas.repaint();
        //     }
        // });

        blackItem1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedColor1 = Color.black;
                canvas.repaint();
            }
        });

        redItem1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedColor1 = Color.red;
                canvas.repaint();
            }
        });

        greenItem1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedColor1 = Color.green;
                canvas.repaint();
            }
        });

        blueItem1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedColor1 = Color.blue;
                canvas.repaint();
            }
        });

        blackItem2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedColor2 = Color.black;
                canvas.repaint();
            }
        });

        redItem2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedColor2 = Color.red;
                canvas.repaint();
            }
        });

        greenItem2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedColor2 = Color.green;
                canvas.repaint();
            }
        });

        blueItem2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedColor2 = Color.blue;
                canvas.repaint();
            }
        });

        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                canvas.repaint();
            }
        });

        textureToggle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean isTextureEnabled = textureToggle.isSelected();
                // Tambahkan kode yang mengatur penggunaan tekstur pada objek berdasarkan nilai isTextureEnabled
                canvas.repaint();
            }
        });
        

        // set the menubar for the frame
        jframe.setJMenuBar(jmenu);

        // show the frame
        jframe.setVisible(true);
    }
}
