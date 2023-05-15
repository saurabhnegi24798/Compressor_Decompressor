/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import comp_decomp.compressor;
import comp_decomp.decompressor;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Saurabh Negi
 */
public class AppFrame extends JFrame implements ActionListener{
    JButton compressedButton;
    JButton decompressedButton;
    AppFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel header = new JLabel();
        header.setBounds(120,100,400,200);
        header.setText("File Compressor & Decompressor");
        header.setFont(new Font("Arial",Font.PLAIN,20));
        
        compressedButton = new JButton("Select File to Compress");
        compressedButton.setBounds(50, 100, 200, 30);
        compressedButton.addActionListener(this);
        
        decompressedButton = new JButton("Select File to Decompress");
        decompressedButton.setBounds(280, 100, 200, 30);   
        decompressedButton.addActionListener(this);
       
        this.setLayout(null);
        this.add(header);
        this.add(compressedButton);
        this.add(decompressedButton);
        this.setSize(1000,500);
        this.getContentPane().setBackground(new Color(0f,1f,0.7f,0.7f));
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == compressedButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                JOptionPane.showMessageDialog(this, "File Compressed Successfully");
                try{
                    compressor.method(file);
                } catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.toString());
                }
            }
        }
        if(e.getSource() == decompressedButton){
             JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                JOptionPane.showMessageDialog(this, "File Decompressed Successfully");
                try{
                    decompressor.method(file);
                } catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.toString());
                }
            }
        }
    }
}

