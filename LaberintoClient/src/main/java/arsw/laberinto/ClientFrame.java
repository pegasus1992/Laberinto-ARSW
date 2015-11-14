package arsw.laberinto;

import arsw.laberinto.gui.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author pegasusmax
 */
public class ClientFrame extends JFrame {

    private String idPlayer;

    public ClientFrame(String title, final Game game) {
        super(title);
        add(game);
        pack();
        WindowListener w = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                game.sacarName(idPlayer);
                exit();
            }
        };
        this.addWindowListener(w);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void exit() {
        dispose();
        System.exit(0);
    }

    public String getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(String idPlayer) {
        this.idPlayer = idPlayer;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
