package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

public class Welcome {

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(Welcome::new);
    }
    JFrame fr;

    public Welcome() {
        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame();
            fr = frame;
            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            frame.setLayout(new BorderLayout());
            try {
                frame.add(new AnimationPane());
            } catch (InterruptedException ex) {
                Logger.getLogger(Welcome.class.getName()).log(Level.SEVERE, null, ex);
            }
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    public class AnimationPane extends JPanel {

        private BufferedImage moltencake;
        private BufferedImage steak;
        private BufferedImage pizza;
        private BufferedImage tarte;
        private int xPos = 0;
        private int direction = 2;
        private int yPos = 0;
        private int flag = 0;

        public AnimationPane() throws InterruptedException {
            try {
                moltencake = ImageIO.read(new File("moltencake.jpg"));
                pizza = ImageIO.read(new File("pizza.jpg"));
                tarte = ImageIO.read(new File("tarte.jpg"));
                steak = ImageIO.read(new File("steak.jpg"));
                Timer timer;

                timer = new Timer(30, (ActionEvent e) -> {
                    if (xPos >= -200 && flag == 0) {
                        xPos -= direction;
                        yPos -= direction;
                        if (xPos == -200) {
                            flag = 1;
                        }
                    }
                    if (flag == 1) {
                        xPos += direction;
                        yPos += direction;
                    }
                    if (xPos == 2) {
                        try {
                            Login login;
                            login = new Login();
                            login.setVisible(true);
                            fr.dispose();
                        } catch (JAXBException | SAXException | IOException | ParserConfigurationException | TransformerException ex) {
                            Logger.getLogger(Welcome.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    repaint();
                });

                timer.setRepeats(true);
                timer.setCoalesce(true);
                timer.start();

            } catch (IOException ex) {
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(moltencake.getWidth() * 2, moltencake.getHeight() * 2);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(moltencake, xPos, 200 - yPos, this);
            g.drawImage(tarte, xPos, yPos, this);
            g.drawImage(steak, getWidth() - 300 - xPos, yPos, this);
            g.drawImage(pizza, getWidth() - 300 - xPos, 200 - yPos, this);

        }

    }

}
