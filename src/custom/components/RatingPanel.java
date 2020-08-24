/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custom.components;

import UI.UIMethods;
import java.awt.GridBagConstraints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import java.awt.Color;

/**
 *
 * @author Sarthak
 */
public class RatingPanel extends javax.swing.JPanel implements MouseListener {
    private JLabel starLabel[] = new JLabel[5];
    private boolean emptyState=true;
    private static final Color EMPTY_STATE_COLOR = new Color(242, 242, 96);
    private static final Color NORMAL_STATE_COLOR = new Color(255,255,0);
    private int star=0;
    private boolean enabled=true;
    /**
     * Creates new form giveRatingPanel
     */
    public RatingPanel() {
        initComponents();
        setup();
        
        
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        emptyState =false; 
    }
    
    
    
    
    private void setup(){
        GridBagConstraints gbc= new java.awt.GridBagConstraints();
        
        for(int i=0;i<5;i++){
            starLabel[i] = new JLabel();
            starLabel[i].setFont(new java.awt.Font("FreeMono", 0, 48)); // NOI18N
            starLabel[i].setForeground(EMPTY_STATE_COLOR);
            starLabel[i].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            starLabel[i].setText(UIMethods.getEmptyStarString());
            starLabel[i].addMouseListener(this);
            gbc.fill = java.awt.GridBagConstraints.BOTH;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;
            add(starLabel[i], gbc);      
        }
    }
    
    private void refreshRating(){
        for(JLabel star: starLabel){
            star.setText(UIMethods.getEmptyStarString());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(25, 25, 25));
        setForeground(new java.awt.Color(242, 242, 96));
        setLayout(new java.awt.GridBagLayout());
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void mouseClicked(MouseEvent e) {
        if (enabled) {
            if (emptyState) {
                emptyState = false;
                for (JLabel tmpStar : starLabel) {
                    tmpStar.setForeground(NORMAL_STATE_COLOR);
                }
            }
            
            refreshRating();
            int i = 0;
            do {
                starLabel[i].setText(UIMethods.getStarString());
            } while (!starLabel[i++].equals(e.getComponent()) && i < 5);//NOTE: Point of contention
            star = i;
        }
        
    }

    public int getStar() {
        return star;
    }

    public void setStar(int s){
        star = s;
        refreshRating();
        
        for(int i=0;i<star&&i<5;i++){
            starLabel[i].setForeground(NORMAL_STATE_COLOR);
            starLabel[i].setText(UIMethods.getStarString());
         } 
        }
    
    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (enabled) {
            if (emptyState) {
                refreshRating();
                int i = 0;
                do {
                    starLabel[i].setText(UIMethods.getStarString());
                } while (!starLabel[i++].equals(e.getComponent()) && i < 5);//NOTE: Point of contention
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(emptyState)
            refreshRating();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}