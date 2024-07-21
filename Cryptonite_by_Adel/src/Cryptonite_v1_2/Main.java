package Cryptonite_v1_2;

import static Cryptonite_v1_2.Helper.*;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.JTextComponent;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/*
 * @author Adel Jabbour
 */
public class Main extends javax.swing.JFrame {

    public Main() {
        initComponents();
//        Image icon = new ImageIcon(this.getClass().getResource("/icon2000.png")).getImage();
//        this.setIconImage(icon);
        setPopupMenuForTextFields();
        setPopupMenuForTextAreas();
        des_key.setFont(new java.awt.Font("Consolas", 0, 14));
        des_text.setFont(new java.awt.Font("Consolas", 0, 14));
        des_out.setFont(new java.awt.Font("Consolas", 0, 14));
        key_sched_text.setFont(new java.awt.Font("Consolas", 0, 14));
        aes_key.setFont(new java.awt.Font("Consolas", 0, 14));
        auto_text.setFont(new java.awt.Font("Consolas", 0, 14));
        aes_error.setFont(new java.awt.Font("Consolas", 0, 14));
        auto_key.setFont(new java.awt.Font("Consolas", 0, 14));
        des_error.setFont(new java.awt.Font("Consolas", 0, 14));
        key_sched_error.setFont(new java.awt.Font("Consolas", 0, 14));
        addi_text.setFont(new java.awt.Font("Consolas", 0, 14));
        addi_key.setFont(new java.awt.Font("Consolas", 0, 14));
        addi_out.setFont(new java.awt.Font("Consolas", 0, 14));
        multi_text.setFont(new java.awt.Font("Consolas", 0, 14));
        multi_key.setFont(new java.awt.Font("Consolas", 0, 14));
        multi_error.setFont(new java.awt.Font("Consolas", 0, 14));
        multi_out.setFont(new java.awt.Font("Consolas", 0, 14));
        aff_text.setFont(new java.awt.Font("Consolas", 0, 14));
        aff_k1.setFont(new java.awt.Font("Consolas", 0, 14));
        aff_k2.setFont(new java.awt.Font("Consolas", 0, 14));
        aff_error.setFont(new java.awt.Font("Consolas", 0, 14));
        aff_out.setFont(new java.awt.Font("Consolas", 0, 14));
        auto_out.setFont(new java.awt.Font("Consolas", 0, 14));
        auto_error.setFont(new java.awt.Font("Consolas", 0, 14));
        vig_text.setFont(new java.awt.Font("Consolas", 0, 14));
        vig_key.setFont(new java.awt.Font("Consolas", 0, 14));
        vig_error.setFont(new java.awt.Font("Consolas", 0, 14));
        vig_out.setFont(new java.awt.Font("Consolas", 0, 14));
        playfair_key.setFont(new java.awt.Font("Consolas", 0, 14));
        playfair_text.setFont(new java.awt.Font("Consolas", 0, 14));
        playfair_out.setFont(new java.awt.Font("Consolas", 0, 14));
        adf_text.setFont(new java.awt.Font("Consolas", 0, 14));
        adf_k1.setFont(new java.awt.Font("Consolas", 0, 14));
        adf_k2.setFont(new java.awt.Font("Consolas", 0, 14));
        adf_out.setFont(new java.awt.Font("Consolas", 0, 14));
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        jTable1.setDefaultRenderer(String.class, centerRenderer);
        jTable1.setDefaultRenderer(Integer.class, centerRenderer);
    }

    private void setPopupMenuForTextFields() {
        JTextField[] textFields = {
            des_key, des_text, des_out, key_sched_text, aes_key, auto_text, aes_error, auto_key, des_error, key_sched_error,
            addi_text, addi_key, addi_out, multi_text, multi_key, multi_error, multi_out, aff_text, aff_k1, aff_k2, aff_error,
            aff_out, auto_out, auto_error, vig_text, vig_key, vig_error, vig_out, playfair_key, playfair_text, playfair_out,
            adf_text, adf_k1, adf_k2, adf_out, aesfile_block_text, aesfile_error, aesfile_key_text, aesfile_out
        };

        for (JTextField textField : textFields) {
            JPopupMenu popupMenu = new JPopupMenu();
            JMenuItem cutItem = new JMenuItem("Cut");
            JMenuItem copyItem = new JMenuItem("Copy");
            JMenuItem pasteItem = new JMenuItem("Paste");

            cutItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    textField.cut();
                }
            });

            copyItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    textField.copy();
                }
            });

            pasteItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    textField.paste();
                }
            });

            popupMenu.add(cutItem);
            popupMenu.add(copyItem);
            popupMenu.add(pasteItem);

            textField.setComponentPopupMenu(popupMenu);
        }
    }

    private void setPopupMenuForTextAreas() {
        JTextArea[] textAreas = {playfair_mat, adfgvx_mat, hill_text, hill_out, aes_text, aes_out};

        for (JTextArea textArea : textAreas) {
            JPopupMenu popupMenu = new JPopupMenu();
            JMenuItem cutItem = new JMenuItem("Cut");
            JMenuItem copyItem = new JMenuItem("Copy");
            JMenuItem pasteItem = new JMenuItem("Paste");

            cutItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    textArea.cut();
                }
            });

            copyItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    textArea.copy();
                }
            });

            pasteItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    textArea.paste();
                }
            });

            popupMenu.add(cutItem);
            popupMenu.add(copyItem);
            popupMenu.add(pasteItem);

            textArea.setComponentPopupMenu(popupMenu);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        buttonGroup8 = new javax.swing.ButtonGroup();
        buttonGroup9 = new javax.swing.ButtonGroup();
        buttonGroup10 = new javax.swing.ButtonGroup();
        buttonGroup12 = new javax.swing.ButtonGroup();
        buttonGroup13 = new javax.swing.ButtonGroup();
        buttonGroup14 = new javax.swing.ButtonGroup();
        buttonGroup15 = new javax.swing.ButtonGroup();
        buttonGroup16 = new javax.swing.ButtonGroup();
        buttonGroup17 = new javax.swing.ButtonGroup();
        InfoSec = new javax.swing.JTabbedPane();
        additive = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        addi_text = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        addi_key = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        addi_out = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        addi_enc = new javax.swing.JRadioButton();
        addi_dec = new javax.swing.JRadioButton();
        addi_submit = new javax.swing.JButton();
        jLabel55 = new javax.swing.JLabel();
        addi_error = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        multiplication = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        multi_text = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        multi_key = new javax.swing.JTextField();
        multi_submit = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        multi_error = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        multi_out = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        multi_enc = new javax.swing.JRadioButton();
        multi_dec = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();
        affine = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        aff_text = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        aff_k1 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        aff_k2 = new javax.swing.JTextField();
        aff_submit = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        aff_error = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        aff_out = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        aff_enc = new javax.swing.JRadioButton();
        aff_dec = new javax.swing.JRadioButton();
        jButton3 = new javax.swing.JButton();
        autokey = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        auto_text = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        auto_key = new javax.swing.JTextField();
        auto_key_mode = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        auto_enc = new javax.swing.JRadioButton();
        auto_dec = new javax.swing.JRadioButton();
        jLabel32 = new javax.swing.JLabel();
        auto_submit = new javax.swing.JButton();
        auto_out = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        auto_error = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel63 = new javax.swing.JLabel();
        autokey_num_key = new javax.swing.JTextField();
        vigenere = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        vig_text = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        vig_key = new javax.swing.JTextField();
        vig_key_mode = new javax.swing.JComboBox<>();
        jLabel36 = new javax.swing.JLabel();
        vig_enc = new javax.swing.JRadioButton();
        vig_dec = new javax.swing.JRadioButton();
        jLabel37 = new javax.swing.JLabel();
        vig_error = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        vig_out = new javax.swing.JTextField();
        vig_submit = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel64 = new javax.swing.JLabel();
        vig_num_key = new javax.swing.JTextField();
        playfair = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        playfair_key = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        playfair_mat = new javax.swing.JTextArea();
        jLabel41 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        playfair_text = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        playfair_out = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        playfair_enc = new javax.swing.JRadioButton();
        playfair_dec = new javax.swing.JRadioButton();
        jLabel52 = new javax.swing.JLabel();
        playfair_a_pad = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        playfair_error = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        adfgvx = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        adf_text = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        adf_k1 = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        adf_k2 = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        adf_dec = new javax.swing.JRadioButton();
        adf_submit = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        adfgvx_mat = new javax.swing.JTextArea();
        jLabel49 = new javax.swing.JLabel();
        adf_out = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        adf_error = new javax.swing.JTextField();
        adf_no_pad = new javax.swing.JRadioButton();
        adf_w_pad = new javax.swing.JRadioButton();
        jButton7 = new javax.swing.JButton();
        adf_k2_arr = new javax.swing.JLabel();
        hill_cipher = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        hill_mat = new javax.swing.JTable();
        hill_mat_size = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        hill_enc = new javax.swing.JRadioButton();
        hill_dec = new javax.swing.JRadioButton();
        jLabel59 = new javax.swing.JLabel();
        hill_book = new javax.swing.JRadioButton();
        hill_std = new javax.swing.JRadioButton();
        hill_submit = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        hill_text = new javax.swing.JTextArea();
        hill_clear = new javax.swing.JButton();
        jLabel60 = new javax.swing.JLabel();
        hill_error = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        hill_out = new javax.swing.JTextArea();
        despanel = new javax.swing.JPanel();
        des_key = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        des_enc = new javax.swing.JRadioButton();
        des_dec = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        des_text = new javax.swing.JTextField();
        des_out = new javax.swing.JTextField();
        des_submit = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        des_error = new javax.swing.JTextField();
        des_ch_count = new javax.swing.JLabel();
        des_key_count = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        des_savetofile = new javax.swing.JCheckBox();
        aes_w_output = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        aesfile_block_text = new javax.swing.JTextField();
        aesfile_key_text = new javax.swing.JTextField();
        aesfile_block_len = new javax.swing.JLabel();
        aesfile_key_len = new javax.swing.JLabel();
        aesfile_save = new javax.swing.JCheckBox();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        aesfile_error = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        aesfile_out = new javax.swing.JTextField();
        aespanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        aes_key = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        aes_block_enc = new javax.swing.JRadioButton();
        aes_block_dec = new javax.swing.JRadioButton();
        aes_cbc_enc = new javax.swing.JRadioButton();
        aes_cbc_dec = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        aes_submit = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        aes_error = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        aes_text = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        aes_out = new javax.swing.JTextArea();
        jLabel51 = new javax.swing.JLabel();
        aes_iv = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        aes_iv_count = new javax.swing.JLabel();
        aes_key_count = new javax.swing.JLabel();
        aes_text_ascii = new javax.swing.JRadioButton();
        aes_text_hex = new javax.swing.JRadioButton();
        aes_key_ascii = new javax.swing.JRadioButton();
        aes_key_hex = new javax.swing.JRadioButton();
        aes_iv_ascii = new javax.swing.JRadioButton();
        aes_iv_hex = new javax.swing.JRadioButton();
        jLabel62 = new javax.swing.JLabel();
        aes_out_ascii = new javax.swing.JRadioButton();
        aes_out_hex = new javax.swing.JRadioButton();
        keysched = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        des_keysched = new javax.swing.JRadioButton();
        aes_keysched = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        key_sched_text = new javax.swing.JTextField();
        key_sched_submit = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        key_sched_error = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        key_sched_ch_num = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        examplePanel = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        exampleTextArea = new javax.swing.JTextArea();
        contact_info = new javax.swing.JPanel();
        fb = new javax.swing.JLabel();
        my_img = new javax.swing.JLabel();
        telegram = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Information Security - 5th Year - Tishreen University - Author : Adel Azeez Jabbour");
        setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        setIconImage(new ImageIcon(this.getClass().getResource("/icon2000.png")).getImage());

        InfoSec.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(102, 102, 255), new java.awt.Color(0, 204, 204)));
        InfoSec.setAlignmentX(20.0F);
        InfoSec.setAlignmentY(20.0F);
        InfoSec.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N

        jLabel14.setText("Text :");

        addi_text.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel15.setText("Key :");

        addi_key.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel16.setText("Output :");

        addi_out.setEditable(false);
        addi_out.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel26.setText("Mode :");

        buttonGroup5.add(addi_enc);
        addi_enc.setSelected(true);
        addi_enc.setText("Encryption");

        buttonGroup5.add(addi_dec);
        addi_dec.setText("Decryption");

        addi_submit.setText("Submit");
        addi_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addi_submitActionPerformed(evt);
            }
        });

        jLabel55.setText("Errors :");

        addi_error.setEditable(false);
        addi_error.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        addi_error.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton1.setText("Clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout additiveLayout = new javax.swing.GroupLayout(additive);
        additive.setLayout(additiveLayout);
        additiveLayout.setHorizontalGroup(
            additiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(additiveLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(additiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(additiveLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(additiveLayout.createSequentialGroup()
                        .addGroup(additiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(additiveLayout.createSequentialGroup()
                                .addGroup(additiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel26))
                                .addGap(26, 26, 26)
                                .addGroup(additiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(additiveLayout.createSequentialGroup()
                                        .addComponent(addi_enc)
                                        .addGap(18, 18, 18)
                                        .addComponent(addi_dec))
                                    .addComponent(addi_key, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addi_text, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(additiveLayout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(addi_submit)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1))
                            .addGroup(additiveLayout.createSequentialGroup()
                                .addGroup(additiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel55))
                                .addGap(18, 18, 18)
                                .addGroup(additiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(addi_error)
                                    .addComponent(addi_out, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        additiveLayout.setVerticalGroup(
            additiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(additiveLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(additiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(addi_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(additiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(addi_key, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(additiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addi_enc)
                    .addComponent(addi_dec)
                    .addComponent(jLabel26))
                .addGap(18, 18, 18)
                .addGroup(additiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addi_submit)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(additiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(addi_error, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(additiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(addi_out, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(384, Short.MAX_VALUE))
        );

        InfoSec.addTab("Additive", additive);

        jLabel17.setText("Text :");

        multi_text.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel18.setText("Key :");

        multi_key.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        multi_submit.setText("Submit");
        multi_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multi_submitActionPerformed(evt);
            }
        });

        jLabel19.setText("Errors :");

        multi_error.setEditable(false);
        multi_error.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel20.setText("Output :");

        multi_out.setEditable(false);
        multi_out.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel28.setText("Mode :");

        buttonGroup6.add(multi_enc);
        multi_enc.setSelected(true);
        multi_enc.setText("Encryption");

        buttonGroup6.add(multi_dec);
        multi_dec.setText("Decryption");

        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout multiplicationLayout = new javax.swing.GroupLayout(multiplication);
        multiplication.setLayout(multiplicationLayout);
        multiplicationLayout.setHorizontalGroup(
            multiplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(multiplicationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(multiplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(multiplicationLayout.createSequentialGroup()
                        .addGroup(multiplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17)
                            .addComponent(jLabel28))
                        .addGap(23, 23, 23)
                        .addGroup(multiplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(multiplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(multi_key, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
                                .addComponent(multi_text)
                                .addComponent(multi_error))
                            .addGroup(multiplicationLayout.createSequentialGroup()
                                .addComponent(multi_submit)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2))
                            .addGroup(multiplicationLayout.createSequentialGroup()
                                .addComponent(multi_enc)
                                .addGap(18, 18, 18)
                                .addComponent(multi_dec, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(multiplicationLayout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(18, 18, 18)
                        .addComponent(multi_out)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        multiplicationLayout.setVerticalGroup(
            multiplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(multiplicationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(multiplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(multi_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(multiplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(multi_key, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(multiplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(multi_dec)
                    .addComponent(multi_enc))
                .addGap(18, 18, 18)
                .addGroup(multiplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(multi_submit)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(multiplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(multi_error, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(multiplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(multi_out, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(387, Short.MAX_VALUE))
        );

        InfoSec.addTab("Multiplication", multiplication);

        jLabel21.setText("Text :");

        aff_text.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel22.setText("Key1 :");

        aff_k1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel23.setText("Key2 :");

        aff_k2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        aff_submit.setText("Submit");
        aff_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aff_submitActionPerformed(evt);
            }
        });

        jLabel24.setText("Errors :");

        aff_error.setEditable(false);
        aff_error.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel25.setText("Output:");

        aff_out.setEditable(false);
        aff_out.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel27.setText("Mode :");

        buttonGroup4.add(aff_enc);
        aff_enc.setSelected(true);
        aff_enc.setText("Encryption");

        buttonGroup4.add(aff_dec);
        aff_dec.setText("Decryption");

        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout affineLayout = new javax.swing.GroupLayout(affine);
        affine.setLayout(affineLayout);
        affineLayout.setHorizontalGroup(
            affineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(affineLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(affineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(affineLayout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(18, 18, 18)
                        .addComponent(aff_out, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(affineLayout.createSequentialGroup()
                        .addGroup(affineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23)
                            .addComponent(jLabel27)
                            .addComponent(jLabel21))
                        .addGap(24, 24, 24)
                        .addGroup(affineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(aff_text, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(affineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton3)
                                .addGroup(affineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(aff_k2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(aff_k1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, affineLayout.createSequentialGroup()
                                        .addComponent(aff_enc)
                                        .addGap(18, 18, 18)
                                        .addComponent(aff_dec))))))
                    .addGroup(affineLayout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(20, 20, 20)
                        .addGroup(affineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(aff_submit)
                            .addComponent(aff_error))))
                .addGap(0, 0, 0))
        );
        affineLayout.setVerticalGroup(
            affineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(affineLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(affineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(aff_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(affineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(aff_k1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(affineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(aff_k2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(affineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(aff_enc)
                    .addComponent(aff_dec))
                .addGap(18, 18, 18)
                .addGroup(affineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aff_submit)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addGroup(affineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(aff_error, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(affineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(aff_out, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(122, 122, 122))
        );

        InfoSec.addTab("Affine", affine);

        jLabel29.setText("Text :");

        auto_text.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel30.setText("Key :");

        auto_key.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        auto_key_mode.setFont(new java.awt.Font("Consolas", 0, 14));
        auto_key_mode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Numbers", "Characters" }));
        auto_key_mode.setSelectedIndex(1);

        jLabel31.setText("Mode :");

        buttonGroup7.add(auto_enc);
        auto_enc.setSelected(true);
        auto_enc.setText("Encryption");

        buttonGroup7.add(auto_dec);
        auto_dec.setText("Decryption");

        jLabel32.setText("Output :");

        auto_submit.setText("Submit");
        auto_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                auto_submitActionPerformed(evt);
            }
        });

        auto_out.setEditable(false);
        auto_out.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel33.setText("Errors :");

        auto_error.setEditable(false);
        auto_error.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton4.setText("Clear");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel63.setText("Key as text:");

        autokey_num_key.setEditable(false);
        autokey_num_key.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        autokey_num_key.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout autokeyLayout = new javax.swing.GroupLayout(autokey);
        autokey.setLayout(autokeyLayout);
        autokeyLayout.setHorizontalGroup(
            autokeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(autokeyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(autokeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel63)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33)
                    .addComponent(jLabel31)
                    .addComponent(jLabel30)
                    .addComponent(jLabel29))
                .addGap(18, 18, 18)
                .addGroup(autokeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(autokeyLayout.createSequentialGroup()
                        .addComponent(auto_key, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(auto_key_mode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, autokeyLayout.createSequentialGroup()
                        .addGroup(autokeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, autokeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, autokeyLayout.createSequentialGroup()
                                    .addComponent(auto_submit)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton4))
                                .addGroup(autokeyLayout.createSequentialGroup()
                                    .addComponent(auto_enc)
                                    .addGap(18, 18, 18)
                                    .addComponent(auto_dec)))
                            .addComponent(auto_out, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(autokey_num_key, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(auto_text, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(auto_error, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        autokeyLayout.setVerticalGroup(
            autokeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(autokeyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(autokeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(auto_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(autokeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(auto_key, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(auto_key_mode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(autokeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(auto_enc)
                    .addComponent(auto_dec))
                .addGap(18, 18, 18)
                .addGroup(autokeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(auto_submit)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addGroup(autokeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(auto_error, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(autokeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel63)
                    .addComponent(autokey_num_key, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(autokeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(auto_out, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(344, Short.MAX_VALUE))
        );

        InfoSec.addTab("AutoKey", autokey);

        jLabel34.setText("Text :");

        vig_text.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel35.setText("Key :");

        vig_key.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        vig_key_mode.setFont(new java.awt.Font("Consolas", 0, 14));
        vig_key_mode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Numbers", "Characters" }));
        vig_key_mode.setSelectedIndex(1);

        jLabel36.setText("Mode :");

        buttonGroup8.add(vig_enc);
        vig_enc.setSelected(true);
        vig_enc.setText("Encryption");

        buttonGroup8.add(vig_dec);
        vig_dec.setText("Decryption");

        jLabel37.setText("Errors :");

        vig_error.setEditable(false);
        vig_error.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel38.setText("Output :");

        vig_out.setEditable(false);
        vig_out.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        vig_submit.setText("Submit");
        vig_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vig_submitActionPerformed(evt);
            }
        });

        jButton5.setText("Clear");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel64.setText("Key as text:");

        vig_num_key.setEditable(false);
        vig_num_key.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        vig_num_key.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout vigenereLayout = new javax.swing.GroupLayout(vigenere);
        vigenere.setLayout(vigenereLayout);
        vigenereLayout.setHorizontalGroup(
            vigenereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vigenereLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(vigenereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(vigenereLayout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addGap(44, 44, 44)
                        .addGroup(vigenereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(vigenereLayout.createSequentialGroup()
                                .addGroup(vigenereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(vig_key, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(vig_text, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(vig_key_mode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(vigenereLayout.createSequentialGroup()
                                .addComponent(vig_enc)
                                .addGap(18, 18, 18)
                                .addComponent(vig_dec))))
                    .addGroup(vigenereLayout.createSequentialGroup()
                        .addGroup(vigenereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel38)
                            .addComponent(jLabel37))
                        .addGap(36, 36, 36)
                        .addGroup(vigenereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(vig_error, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(vig_out, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(vigenereLayout.createSequentialGroup()
                                .addComponent(vig_submit)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5))))
                    .addComponent(jLabel34)
                    .addComponent(jLabel35)
                    .addGroup(vigenereLayout.createSequentialGroup()
                        .addComponent(jLabel64)
                        .addGap(18, 18, 18)
                        .addComponent(vig_num_key, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        vigenereLayout.setVerticalGroup(
            vigenereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vigenereLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(vigenereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(vig_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(vigenereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(vig_key_mode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vig_key, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(vigenereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(vig_enc)
                    .addComponent(vig_dec))
                .addGap(18, 18, 18)
                .addGroup(vigenereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vig_submit)
                    .addComponent(jButton5))
                .addGap(18, 18, 18)
                .addGroup(vigenereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(vig_error, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(vigenereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vig_num_key, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel64))
                .addGap(18, 18, 18)
                .addGroup(vigenereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(vig_out, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(344, Short.MAX_VALUE))
        );

        InfoSec.addTab("Vigenere", vigenere);

        jLabel39.setText("Key :");

        playfair_key.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel40.setText("Matrix Output :");

        playfair_mat.setEditable(false);
        playfair_mat.setColumns(20);
        playfair_mat.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        playfair_mat.setRows(6);
        jScrollPane4.setViewportView(playfair_mat);

        jLabel41.setText("Text :");

        jButton9.setText("Submit");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        playfair_text.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel42.setText("Output :");

        playfair_out.setEditable(false);
        playfair_out.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel43.setText("Mode :");

        buttonGroup9.add(playfair_enc);
        playfair_enc.setSelected(true);
        playfair_enc.setText("Encryption");

        buttonGroup9.add(playfair_dec);
        playfair_dec.setText("Decryption");

        jLabel52.setText("After Padding");

        playfair_a_pad.setEditable(false);
        playfair_a_pad.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        playfair_a_pad.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel54.setText("Errors :");

        playfair_error.setEditable(false);
        playfair_error.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        playfair_error.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton6.setText("Clear");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout playfairLayout = new javax.swing.GroupLayout(playfair);
        playfair.setLayout(playfairLayout);
        playfairLayout.setHorizontalGroup(
            playfairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playfairLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(playfairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(playfairLayout.createSequentialGroup()
                        .addGroup(playfairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel40)
                            .addComponent(jLabel54))
                        .addGap(18, 18, 18)
                        .addGroup(playfairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(playfairLayout.createSequentialGroup()
                                .addComponent(playfair_error)
                                .addGap(176, 176, 176))))
                    .addGroup(playfairLayout.createSequentialGroup()
                        .addGroup(playfairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(playfairLayout.createSequentialGroup()
                                .addGroup(playfairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel42)
                                    .addComponent(jLabel52))
                                .addGap(26, 26, 26)
                                .addGroup(playfairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(playfair_a_pad)
                                    .addComponent(playfair_out)))
                            .addGroup(playfairLayout.createSequentialGroup()
                                .addGroup(playfairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(playfairLayout.createSequentialGroup()
                                        .addGap(92, 92, 92)
                                        .addComponent(jButton9))
                                    .addComponent(jLabel43))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(playfairLayout.createSequentialGroup()
                                .addGroup(playfairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel39)
                                    .addComponent(jLabel41))
                                .addGap(63, 63, 63)
                                .addGroup(playfairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(playfair_text)
                                    .addGroup(playfairLayout.createSequentialGroup()
                                        .addComponent(playfair_enc)
                                        .addGap(18, 18, 18)
                                        .addGroup(playfairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(playfair_dec)
                                            .addComponent(jButton6)))
                                    .addComponent(playfair_key))))
                        .addGap(176, 176, 176))))
        );
        playfairLayout.setVerticalGroup(
            playfairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playfairLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(playfairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(playfair_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(playfairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(playfair_key, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(playfairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(playfair_enc)
                    .addComponent(playfair_dec))
                .addGap(18, 18, 18)
                .addGroup(playfairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9)
                    .addComponent(jButton6))
                .addGap(18, 18, 18)
                .addGroup(playfairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(playfair_error, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(playfairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel40)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(playfairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(playfair_a_pad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(playfairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(playfair_out, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        InfoSec.addTab("PlayFair", playfair);

        jLabel44.setText("Text :");

        adf_text.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel45.setText("Key1 :");

        adf_k1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel46.setText("Key2 :");

        adf_k2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        adf_k2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                adf_k2KeyReleased(evt);
            }
        });

        jLabel47.setText("Mode :");

        buttonGroup10.add(adf_dec);
        adf_dec.setText("Decryption");

        adf_submit.setText("Submit");
        adf_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adf_submitActionPerformed(evt);
            }
        });

        jLabel48.setText("Output Matrix :");

        adfgvx_mat.setEditable(false);
        adfgvx_mat.setColumns(20);
        adfgvx_mat.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        adfgvx_mat.setRows(8);
        jScrollPane5.setViewportView(adfgvx_mat);

        jLabel49.setText("Output :");

        adf_out.setEditable(false);
        adf_out.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        adf_out.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel53.setText("Errors :");

        adf_error.setEditable(false);
        adf_error.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        adf_error.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        buttonGroup10.add(adf_no_pad);
        adf_no_pad.setSelected(true);
        adf_no_pad.setText("Encrypt / No Padding");

        buttonGroup10.add(adf_w_pad);
        adf_w_pad.setText("Encrypt / With Padding");

        jButton7.setText("Clear");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        adf_k2_arr.setText("        ");
        adf_k2_arr.setFocusable(false);

        javax.swing.GroupLayout adfgvxLayout = new javax.swing.GroupLayout(adfgvx);
        adfgvx.setLayout(adfgvxLayout);
        adfgvxLayout.setHorizontalGroup(
            adfgvxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adfgvxLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(adfgvxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adfgvxLayout.createSequentialGroup()
                        .addComponent(jLabel47)
                        .addGap(59, 59, 59)
                        .addComponent(adf_no_pad)
                        .addGap(18, 18, 18)
                        .addComponent(adf_w_pad)
                        .addGap(18, 18, 18)
                        .addComponent(adf_dec))
                    .addGroup(adfgvxLayout.createSequentialGroup()
                        .addGroup(adfgvxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel45)
                            .addComponent(jLabel44))
                        .addGap(61, 61, 61)
                        .addGroup(adfgvxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(adf_text, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(adf_k1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(adfgvxLayout.createSequentialGroup()
                        .addComponent(jLabel48)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(adfgvxLayout.createSequentialGroup()
                        .addGroup(adfgvxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel49)
                            .addComponent(jLabel53))
                        .addGap(51, 51, 51)
                        .addGroup(adfgvxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(adf_out, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(adf_submit)
                            .addComponent(adf_error, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(adfgvxLayout.createSequentialGroup()
                        .addComponent(jLabel46)
                        .addGroup(adfgvxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(adfgvxLayout.createSequentialGroup()
                                .addGap(206, 206, 206)
                                .addComponent(jButton7))
                            .addGroup(adfgvxLayout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(adf_k2, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(adf_k2_arr)))))
                .addGap(0, 0, 0))
        );
        adfgvxLayout.setVerticalGroup(
            adfgvxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adfgvxLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(adfgvxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(adf_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(adfgvxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(adf_k1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(adfgvxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(adf_k2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adf_k2_arr))
                .addGap(18, 18, 18)
                .addGroup(adfgvxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(adf_no_pad)
                    .addComponent(adf_w_pad)
                    .addComponent(adf_dec))
                .addGap(18, 18, 18)
                .addGroup(adfgvxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adf_submit)
                    .addComponent(jButton7))
                .addGap(18, 18, 18)
                .addGroup(adfgvxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(adf_error, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(adfgvxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel48)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(adfgvxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel49)
                    .addComponent(adf_out, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        InfoSec.addTab("ADFGVX", adfgvx);

        hill_mat.setBackground(javax.swing.UIManager.getDefaults().getColor("TableHeader.background"));
        hill_mat.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        hill_mat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        hill_mat.setColumnSelectionAllowed(true);
        hill_mat.setEditingRow(1);
        hill_mat.setOpaque(false);
        hill_mat.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(hill_mat);
        hill_mat.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        hill_mat_size.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        hill_mat_size.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        hill_mat_size.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                hill_mat_sizeKeyReleased(evt);
            }
        });

        jLabel56.setText("Matrix Size :");

        jLabel57.setText("Text :");

        jLabel58.setText("Mode :");

        buttonGroup12.add(hill_enc);
        hill_enc.setSelected(true);
        hill_enc.setText("Encryption");

        buttonGroup12.add(hill_dec);
        hill_dec.setText("Decryption");

        jLabel59.setText("Mode 2 :");

        buttonGroup13.add(hill_book);
        hill_book.setSelected(true);
        hill_book.setText("As in the book");

        buttonGroup13.add(hill_std);
        hill_std.setText("Standard");

        hill_submit.setText("Submit");
        hill_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hill_submitActionPerformed(evt);
            }
        });

        hill_text.setColumns(20);
        hill_text.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        hill_text.setRows(5);
        jScrollPane7.setViewportView(hill_text);

        hill_clear.setText("Clear");
        hill_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hill_clearActionPerformed(evt);
            }
        });

        jLabel60.setText("Errors :");

        hill_error.setEditable(false);
        hill_error.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        hill_error.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel61.setText("Output :");

        hill_out.setEditable(false);
        hill_out.setColumns(20);
        hill_out.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        hill_out.setLineWrap(true);
        hill_out.setRows(5);
        hill_out.setWrapStyleWord(true);
        jScrollPane8.setViewportView(hill_out);

        javax.swing.GroupLayout hill_cipherLayout = new javax.swing.GroupLayout(hill_cipher);
        hill_cipher.setLayout(hill_cipherLayout);
        hill_cipherLayout.setHorizontalGroup(
            hill_cipherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hill_cipherLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(hill_cipherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(hill_cipherLayout.createSequentialGroup()
                        .addGroup(hill_cipherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel59)
                            .addComponent(jLabel58)
                            .addComponent(jLabel57))
                        .addGap(18, 18, 18)
                        .addGroup(hill_cipherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane7)
                            .addGroup(hill_cipherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(hill_cipherLayout.createSequentialGroup()
                                    .addComponent(hill_submit)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(hill_clear))
                                .addGroup(hill_cipherLayout.createSequentialGroup()
                                    .addGroup(hill_cipherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(hill_book)
                                        .addComponent(hill_enc))
                                    .addGap(18, 18, 18)
                                    .addGroup(hill_cipherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(hill_dec)
                                        .addComponent(hill_std)))))
                        .addGap(18, 18, 18)
                        .addGroup(hill_cipherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(hill_cipherLayout.createSequentialGroup()
                                .addComponent(jLabel56)
                                .addGap(18, 18, 18)
                                .addComponent(hill_mat_size, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(hill_cipherLayout.createSequentialGroup()
                        .addGroup(hill_cipherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel60)
                            .addComponent(jLabel61))
                        .addGroup(hill_cipherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(hill_cipherLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hill_cipherLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(hill_error, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        hill_cipherLayout.setVerticalGroup(
            hill_cipherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hill_cipherLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(hill_cipherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(hill_cipherLayout.createSequentialGroup()
                        .addGroup(hill_cipherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hill_mat_size, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel56)
                            .addComponent(jLabel57))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(hill_cipherLayout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(hill_cipherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel58)
                            .addComponent(hill_enc)
                            .addComponent(hill_dec))
                        .addGap(18, 18, 18)
                        .addGroup(hill_cipherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel59)
                            .addComponent(hill_book)
                            .addComponent(hill_std))
                        .addGap(18, 18, 18)
                        .addGroup(hill_cipherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hill_submit)
                            .addComponent(hill_clear))))
                .addGap(18, 18, 18)
                .addGroup(hill_cipherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60)
                    .addComponent(hill_error, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(hill_cipherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel61)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        InfoSec.addTab("Hill Cipher", hill_cipher);

        des_key.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        des_key.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                des_keyKeyReleased(evt);
            }
        });

        jLabel1.setText("Key :");

        buttonGroup1.add(des_enc);
        des_enc.setSelected(true);
        des_enc.setText("Encryption");

        buttonGroup1.add(des_dec);
        des_dec.setText("Decryption");

        jLabel2.setText("Mode :");

        jLabel3.setText("Text :");

        jLabel4.setText("Output :");

        des_text.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        des_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                des_textKeyReleased(evt);
            }
        });

        des_out.setEditable(false);
        des_out.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        des_submit.setText("Submit");
        des_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                des_submitActionPerformed(evt);
            }
        });

        jLabel12.setText("Errors :");

        des_error.setEditable(false);
        des_error.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        des_ch_count.setText("0 Characters");

        des_key_count.setText("0 Characters");

        jButton8.setText("Clear");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        des_savetofile.setSelected(true);
        des_savetofile.setText("Save Output to File");

        javax.swing.GroupLayout despanelLayout = new javax.swing.GroupLayout(despanel);
        despanel.setLayout(despanelLayout);
        despanelLayout.setHorizontalGroup(
            despanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(despanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(despanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(despanelLayout.createSequentialGroup()
                        .addGroup(despanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(despanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(des_out)
                            .addComponent(des_error)
                            .addGroup(despanelLayout.createSequentialGroup()
                                .addComponent(des_submit)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(despanelLayout.createSequentialGroup()
                        .addGroup(despanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(26, 26, 26)
                        .addGroup(despanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(des_key)
                            .addComponent(des_text)
                            .addGroup(despanelLayout.createSequentialGroup()
                                .addComponent(des_enc)
                                .addGap(18, 18, 18)
                                .addGroup(despanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(des_dec)
                                    .addGroup(despanelLayout.createSequentialGroup()
                                        .addComponent(jButton8)
                                        .addGap(18, 18, 18)
                                        .addComponent(des_savetofile)))
                                .addGap(0, 331, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(despanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(des_ch_count)
                    .addComponent(des_key_count))
                .addGap(204, 204, 204))
        );
        despanelLayout.setVerticalGroup(
            despanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(despanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(despanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(des_text)
                    .addComponent(des_ch_count))
                .addGap(18, 18, 18)
                .addGroup(despanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(des_key)
                    .addComponent(des_key_count))
                .addGap(18, 18, 18)
                .addGroup(despanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(des_enc)
                    .addComponent(des_dec)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(despanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(des_submit)
                    .addComponent(jButton8)
                    .addComponent(des_savetofile))
                .addGap(23, 23, 23)
                .addGroup(despanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(des_error, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(despanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(des_out)
                    .addComponent(jLabel4))
                .addGap(242, 242, 242))
        );

        InfoSec.addTab("DES", despanel);

        jLabel65.setText("Block:");

        jLabel66.setText("Key:");

        aesfile_block_text.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        aesfile_block_text.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        aesfile_block_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                aesfile_block_textKeyReleased(evt);
            }
        });

        aesfile_key_text.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        aesfile_key_text.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        aesfile_key_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                aesfile_key_textKeyReleased(evt);
            }
        });

        aesfile_block_len.setText("0 Characters");

        aesfile_key_len.setText("0 Characters");

        aesfile_save.setSelected(true);
        aesfile_save.setText("Save Output to File");

        jButton12.setText("Encrypt");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("Clear");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        aesfile_error.setEditable(false);
        aesfile_error.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        aesfile_error.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel67.setText("Errors:");

        jLabel68.setText("Output:");

        aesfile_out.setEditable(false);
        aesfile_out.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        aesfile_out.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout aes_w_outputLayout = new javax.swing.GroupLayout(aes_w_output);
        aes_w_output.setLayout(aes_w_outputLayout);
        aes_w_outputLayout.setHorizontalGroup(
            aes_w_outputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aes_w_outputLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(aes_w_outputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel65)
                    .addComponent(jLabel66)
                    .addComponent(jLabel67)
                    .addComponent(jLabel68))
                .addGap(18, 18, 18)
                .addGroup(aes_w_outputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(aes_w_outputLayout.createSequentialGroup()
                        .addComponent(jButton12)
                        .addGap(18, 18, 18)
                        .addComponent(jButton13)
                        .addGap(18, 18, 18)
                        .addComponent(aesfile_save))
                    .addGroup(aes_w_outputLayout.createSequentialGroup()
                        .addGroup(aes_w_outputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(aesfile_error, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(aesfile_block_text, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(aesfile_key_text, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                            .addComponent(aesfile_out, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(aes_w_outputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(aesfile_key_len)
                            .addComponent(aesfile_block_len))))
                .addContainerGap(309, Short.MAX_VALUE))
        );
        aes_w_outputLayout.setVerticalGroup(
            aes_w_outputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aes_w_outputLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(aes_w_outputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel65)
                    .addComponent(aesfile_block_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aesfile_block_len))
                .addGap(18, 18, 18)
                .addGroup(aes_w_outputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel66)
                    .addGroup(aes_w_outputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(aesfile_key_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(aesfile_key_len)))
                .addGap(18, 18, 18)
                .addGroup(aes_w_outputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton12)
                    .addComponent(jButton13)
                    .addComponent(aesfile_save))
                .addGap(18, 18, 18)
                .addGroup(aes_w_outputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aesfile_error, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel67))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(aes_w_outputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aesfile_out, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel68))
                .addContainerGap(406, Short.MAX_VALUE))
        );

        InfoSec.addTab("AES Encrypt with output to file", aes_w_output);

        aespanel.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N

        jLabel7.setText("Key :");

        aes_key.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        aes_key.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                aes_keyKeyReleased(evt);
            }
        });

        jLabel8.setText("Mode :");

        buttonGroup3.add(aes_block_enc);
        aes_block_enc.setSelected(true);
        aes_block_enc.setText("Block Encrytion");

        buttonGroup3.add(aes_block_dec);
        aes_block_dec.setText("Block Decryption");

        buttonGroup3.add(aes_cbc_enc);
        aes_cbc_enc.setText("CBC PKCS7 PADDING Encryption");

        buttonGroup3.add(aes_cbc_dec);
        aes_cbc_dec.setText("CBC PKCS7 PADDING Decryption");

        jLabel9.setText("Text :");

        aes_submit.setText("Submit");
        aes_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aes_cipher(evt);
            }
        });

        jLabel10.setText("Errors :");

        aes_error.setEditable(false);
        aes_error.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel11.setText("Output :");

        aes_text.setColumns(20);
        aes_text.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        aes_text.setLineWrap(true);
        aes_text.setRows(5);
        aes_text.setWrapStyleWord(true);
        jScrollPane2.setViewportView(aes_text);

        aes_out.setEditable(false);
        aes_out.setColumns(20);
        aes_out.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        aes_out.setLineWrap(true);
        aes_out.setRows(5);
        aes_out.setWrapStyleWord(true);
        jScrollPane3.setViewportView(aes_out);

        jLabel51.setText("IV :");

        aes_iv.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        aes_iv.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        aes_iv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                aes_ivKeyReleased(evt);
            }
        });

        jButton10.setText("Clear");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        aes_iv_count.setText("0 Characters");

        aes_key_count.setText("0 Characters");

        buttonGroup14.add(aes_text_ascii);
        aes_text_ascii.setSelected(true);
        aes_text_ascii.setText("ASCII");

        buttonGroup14.add(aes_text_hex);
        aes_text_hex.setText("HEX");

        buttonGroup15.add(aes_key_ascii);
        aes_key_ascii.setText("ASCII");

        buttonGroup15.add(aes_key_hex);
        aes_key_hex.setSelected(true);
        aes_key_hex.setText("HEX");

        buttonGroup16.add(aes_iv_ascii);
        aes_iv_ascii.setText("ASCII");

        buttonGroup16.add(aes_iv_hex);
        aes_iv_hex.setSelected(true);
        aes_iv_hex.setText("HEX");

        jLabel62.setText("Output Type:");

        buttonGroup17.add(aes_out_ascii);
        aes_out_ascii.setText("ASCII");
        aes_out_ascii.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aes_cipher(evt);
            }
        });

        buttonGroup17.add(aes_out_hex);
        aes_out_hex.setSelected(true);
        aes_out_hex.setText("HEX");
        aes_out_hex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aes_cipher(evt);
            }
        });

        javax.swing.GroupLayout aespanelLayout = new javax.swing.GroupLayout(aespanel);
        aespanel.setLayout(aespanelLayout);
        aespanelLayout.setHorizontalGroup(
            aespanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aespanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(aespanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(aespanelLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(28, 28, 28)
                        .addComponent(aes_block_enc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aes_block_dec)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(aes_cbc_enc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(aes_cbc_dec))
                    .addGroup(aespanelLayout.createSequentialGroup()
                        .addGroup(aespanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel51))
                        .addGap(40, 40, 40)
                        .addGroup(aespanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(aespanelLayout.createSequentialGroup()
                                .addComponent(aes_iv, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(aes_iv_count))
                            .addGroup(aespanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(aes_iv_ascii)
                                .addGap(18, 18, 18)
                                .addComponent(aes_iv_hex))))
                    .addGroup(aespanelLayout.createSequentialGroup()
                        .addGroup(aespanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aespanelLayout.createSequentialGroup()
                                .addGroup(aespanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(aespanelLayout.createSequentialGroup()
                                        .addGroup(aespanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(aes_text_ascii))
                                        .addGap(12, 12, 12))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aespanelLayout.createSequentialGroup()
                                        .addComponent(aes_text_hex)
                                        .addGap(18, 18, 18)))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aespanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(aespanelLayout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(aes_key_ascii)
                                    .addGap(18, 18, 18)
                                    .addComponent(aes_key_hex))
                                .addComponent(aes_key, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aes_key_count))
                    .addGroup(aespanelLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(aes_submit)
                        .addGap(18, 18, 18)
                        .addComponent(jButton10))
                    .addGroup(aespanelLayout.createSequentialGroup()
                        .addComponent(jLabel62)
                        .addGap(18, 18, 18)
                        .addComponent(aes_out_ascii)
                        .addGap(18, 18, 18)
                        .addComponent(aes_out_hex))
                    .addGroup(aespanelLayout.createSequentialGroup()
                        .addGroup(aespanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))
                        .addGroup(aespanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(aespanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 802, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(aespanelLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(aes_error, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        aespanelLayout.setVerticalGroup(
            aespanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aespanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(aespanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(aespanelLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(aes_text_ascii)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(aes_text_hex))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(aespanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(aes_key, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aes_key_count))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(aespanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aes_key_ascii)
                    .addComponent(aes_key_hex))
                .addGap(18, 18, 18)
                .addGroup(aespanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aes_iv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel51)
                    .addComponent(aes_iv_count))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(aespanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aes_iv_ascii)
                    .addComponent(aes_iv_hex))
                .addGap(18, 18, 18)
                .addGroup(aespanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(aes_block_enc)
                    .addComponent(aes_block_dec)
                    .addComponent(aes_cbc_enc)
                    .addComponent(aes_cbc_dec))
                .addGap(18, 18, 18)
                .addGroup(aespanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aes_submit)
                    .addComponent(jButton10))
                .addGap(18, 18, 18)
                .addGroup(aespanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(aes_error, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(aespanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62)
                    .addComponent(aes_out_ascii)
                    .addComponent(aes_out_hex))
                .addGap(18, 18, 18)
                .addGroup(aespanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        InfoSec.addTab("AES Swiss Army Knife", aespanel);

        jTable1.setBackground(javax.swing.UIManager.getDefaults().getColor("TableHeader.background"));
        jTable1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Round #", "Sub Key"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoscrolls(false);
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(60);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(60);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(60);
        }

        jLabel5.setText("Algorithm :");

        buttonGroup2.add(des_keysched);
        des_keysched.setSelected(true);
        des_keysched.setText("DES");

        buttonGroup2.add(aes_keysched);
        aes_keysched.setText("AES-128");

        jLabel6.setText("Key :");

        key_sched_text.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        key_sched_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                key_sched_textKeyReleased(evt);
            }
        });

        key_sched_submit.setText("Submit");
        key_sched_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                key_sched_submitActionPerformed(evt);
            }
        });

        jLabel13.setText("Errors :");

        key_sched_error.setEditable(false);
        key_sched_error.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel50.setText("Output :");

        key_sched_ch_num.setText("0 Characters");

        jButton11.setText("Clear");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout keyschedLayout = new javax.swing.GroupLayout(keysched);
        keysched.setLayout(keyschedLayout);
        keyschedLayout.setHorizontalGroup(
            keyschedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(keyschedLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(keyschedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel13)
                    .addComponent(jLabel50)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(keyschedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(keyschedLayout.createSequentialGroup()
                        .addGroup(keyschedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(keyschedLayout.createSequentialGroup()
                                .addComponent(key_sched_submit)
                                .addGap(18, 18, 18)
                                .addComponent(jButton11))
                            .addGroup(keyschedLayout.createSequentialGroup()
                                .addComponent(key_sched_text, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(key_sched_ch_num)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(keyschedLayout.createSequentialGroup()
                        .addGroup(keyschedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, keyschedLayout.createSequentialGroup()
                                .addComponent(des_keysched)
                                .addGap(18, 18, 18)
                                .addComponent(aes_keysched))
                            .addComponent(key_sched_error, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        keyschedLayout.setVerticalGroup(
            keyschedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, keyschedLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(keyschedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(key_sched_ch_num)
                    .addComponent(jLabel6)
                    .addComponent(key_sched_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(keyschedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(des_keysched)
                    .addComponent(aes_keysched))
                .addGap(18, 18, 18)
                .addGroup(keyschedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(key_sched_submit)
                    .addComponent(jButton11))
                .addGap(18, 18, 18)
                .addGroup(keyschedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(key_sched_error, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(keyschedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel50)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(195, 195, 195))
        );

        InfoSec.addTab("Key Schedule", keysched);

        examplePanel.setFocusable(false);

        jScrollPane9.setBorder(null);

        exampleTextArea.setEditable(false);
        exampleTextArea.setBackground(new java.awt.Color(204, 204, 204));
        exampleTextArea.setColumns(20);
        exampleTextArea.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        exampleTextArea.setRows(5);
        exampleTextArea.setText("keys for multiplication are\n    3 5 7 9 11 15 17 19 21 23 25\n\n\nexample texts and keys for the first 7 algorithms:\n\ntexts:\n\thello good Morning\n\tThe sun slowly dipped below the horizon\n\tcryptographic\n\nkeys for ADFGVX and Playfair:\n\tcipher\n\tsecure\n\tpython\n\n=======================================================\n\nHill Cipher Keys:\n\n| 6    24    1 |\n| 13   16   10 |\n| 20   17   15 | \n\n------------------\n\n| 5    8   23 |\n| 9    5    1 |\n| 7    7    8 |\n\n------------------\n\n| 3   8 |\n|       |\n| 2   5 |\n\n============================================================\n\nDES:\n\nExample 1:\nPlaintext (in hex): 0123456789ABCDEF\nKey (in hex): 133457799BBCDFF1\n\nResulting Ciphertext: 85E813540F0AB405\n\n\nExample 2:\nPlaintext (in hex): 85E813540F0AB405\nKey (in hex): 0123456789ABCDEF\n\nResulting Ciphertext: 8D0AAB998757B0AF\n\n\nExample 3:\nPlaintext (in hex): 4E6F772069732074\nKey (in hex): 0123456789ABCDEF\n\nResulting Ciphertext: 3FA40E8A984D4815\n\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\nDES full Example:\n\n* Generate subKeys:\n\t0- premutate using permute choice 1:\n\t   in binary ==> 10000111011001100101010111110010110100110110010001111000\n\t   in hex    ==> 876655F2D36478\n\n\tRound #1\n\t1- split to right and left half:\n\t   left = 1000011101100110010101011111\tright = 0010110100110110010001111000\n\n\t2- perform left circular shift on two halves based on roud number:\n\t   left = 0000111011001100101010111111\tright = 0101101001101100100011110000\n\n\t3- perform permuation Choice 2 on whole key to get round key:\n\t   round key #1  = 110101010111110010011010110000101110011000011001\n\t   in hexadecimal = D57C9AC2E619\n\n\n\tRound #2\n\t1- from step 2 in previous round:\n\t   left = 0000111011001100101010111111\tright = 0101101001101100100011110000\n\n\t2- perform left circular shift on two halves based on roud number:\n\t   left = 0001110110011001010101111110\tright = 1011010011011001000111100000\n\n\t3- perform permuation Choice 2 on whole key to get round key:\n\t   round key #2  = 000101000100101111101110101100011001110010001011\n\t   in hexadecimal = 144BEEB19C8B\n\n\n\tRound #3\n\t1- from step 2 in previous round:\n\t   left = 0001110110011001010101111110\tright = 1011010011011001000111100000\n\n\t2- perform left circular shift on two halves based on roud number:\n\t   left = 0111011001100101010111111000\tright = 1101001101100100011110000010\n\n\t3- perform permuation Choice 2 on whole key to get round key:\n\t   round key #3  = 101100100111100100110101000011100001011000110111\n\t   in hexadecimal = B279350E1637\n\n\n\tRound #4\n\t1- from step 2 in previous round:\n\t   left = 0111011001100101010111111000\tright = 1101001101100100011110000010\n\n\t2- perform left circular shift on two halves based on roud number:\n\t   left = 1101100110010101011111100001\tright = 0100110110010001111000001011\n\n\t3- perform permuation Choice 2 on whole key to get round key:\n\t   round key #4  = 100011010010111101100101000111110110100111100100\n\t   in hexadecimal = 8D2F651F69E4\n\n\n\tRound #5\n\t1- from step 2 in previous round:\n\t   left = 1101100110010101011111100001\tright = 0100110110010001111000001011\n\n\t2- perform left circular shift on two halves based on roud number:\n\t   left = 0110011001010101111110000111\tright = 0011011001000111100000101101\n\n\t3- perform permuation Choice 2 on whole key to get round key:\n\t   round key #5  = 110000110111011010111101001000001100100111010001\n\t   in hexadecimal = C376BD20C9D1\n\n\n\tRound #6\n\t1- from step 2 in previous round:\n\t   left = 0110011001010101111110000111\tright = 0011011001000111100000101101\n\n\t2- perform left circular shift on two halves based on roud number:\n\t   left = 1001100101010111111000011101\tright = 1101100100011110000010110100\n\n\t3- perform permuation Choice 2 on whole key to get round key:\n\t   round key #6  = 110111011001011111100000110000111010010000010111\n\t   in hexadecimal = DD97E0C3A417\n\n\n\tRound #7\n\t1- from step 2 in previous round:\n\t   left = 1001100101010111111000011101\tright = 1101100100011110000010110100\n\n\t2- perform left circular shift on two halves based on roud number:\n\t   left = 0110010101011111100001110110\tright = 0110010001111000001011010011\n\n\t3- perform permuation Choice 2 on whole key to get round key:\n\t   round key #7  = 110100101101101011101011111011110000011110001000\n\t   in hexadecimal = D2DAEBEF0788\n\n\n\tRound #8\n\t1- from step 2 in previous round:\n\t   left = 0110010101011111100001110110\tright = 0110010001111000001011010011\n\n\t2- perform left circular shift on two halves based on roud number:\n\t   left = 1001010101111110000111011001\tright = 1001000111100000101101001101\n\n\t3- perform permuation Choice 2 on whole key to get round key:\n\t   round key #8  = 101110011111001101000110000110000101001101001111\n\t   in hexadecimal = B9F34618534F\n\n\n\tRound #9\n\t1- from step 2 in previous round:\n\t   left = 1001010101111110000111011001\tright = 1001000111100000101101001101\n\n\t2- perform left circular shift on two halves based on roud number:\n\t   left = 0010101011111100001110110011\tright = 0010001111000001011010011011\n\n\t3- perform permuation Choice 2 on whole key to get round key:\n\t   round key #9  = 101101110011111000011110011111000000110101100100\n\t   in hexadecimal = B73E1E7C0D64\n\n\n\tRound #10\n\t1- from step 2 in previous round:\n\t   left = 0010101011111100001110110011\tright = 0010001111000001011010011011\n\n\t2- perform left circular shift on two halves based on roud number:\n\t   left = 1010101111110000111011001100\tright = 1000111100000101101001101100\n\n\t3- perform permuation Choice 2 on whole key to get round key:\n\t   round key #10  = 011011100011011011010000000010001110100011011110\n\t   in hexadecimal = 6E36D008E8DE\n\n\n\tRound #11\n\t1- from step 2 in previous round:\n\t   left = 1010101111110000111011001100\tright = 1000111100000101101001101100\n\n\t2- perform left circular shift on two halves based on roud number:\n\t   left = 1010111111000011101100110010\tright = 0011110000010110100110110010\n\n\t3- perform permuation Choice 2 on whole key to get round key:\n\t   round key #11  = 010111101101110001111100011001011111010010010001\n\t   in hexadecimal = 5EDC7C65F491\n\n\n\tRound #12\n\t1- from step 2 in previous round:\n\t   left = 1010111111000011101100110010\tright = 0011110000010110100110110010\n\n\t2- perform left circular shift on two halves based on roud number:\n\t   left = 1011111100001110110011001010\tright = 1111000001011010011011001000\n\n\t3- perform permuation Choice 2 on whole key to get round key:\n\t   round key #12  = 110011101110000101011010101010110000010001101011\n\t   in hexadecimal = CEE15AAB046B\n\n\n\tRound #13\n\t1- from step 2 in previous round:\n\t   left = 1011111100001110110011001010\tright = 1111000001011010011011001000\n\n\t2- perform left circular shift on two halves based on roud number:\n\t   left = 1111110000111011001100101010\tright = 1100000101101001101100100011\n\n\t3- perform permuation Choice 2 on whole key to get round key:\n\t   round key #13  = 001011101100111100101111100011101101101100000110\n\t   in hexadecimal = 2ECF2F8EDB06\n\n\n\tRound #14\n\t1- from step 2 in previous round:\n\t   left = 1111110000111011001100101010\tright = 1100000101101001101100100011\n\n\t2- perform left circular shift on two halves based on roud number:\n\t   left = 1111000011101100110010101011\tright = 0000010110100110110010001111\n\n\t3- perform permuation Choice 2 on whole key to get round key:\n\t   round key #14  = 111010110011100100001011000101000100011111110100\n\t   in hexadecimal = EB390B1447F4\n\n\n\tRound #15\n\t1- from step 2 in previous round:\n\t   left = 1111000011101100110010101011\tright = 0000010110100110110010001111\n\n\t2- perform left circular shift on two halves based on roud number:\n\t   left = 1100001110110011001010101111\tright = 0001011010011011001000111100\n\n\t3- perform permuation Choice 2 on whole key to get round key:\n\t   round key #15  = 001010011010111011111001110110011000100011000001\n\t   in hexadecimal = 29AEF9D988C1\n\n\n\tRound #16\n\t1- from step 2 in previous round:\n\t   left = 1100001110110011001010101111\tright = 0001011010011011001000111100\n\n\t2- perform left circular shift on two halves based on roud number:\n\t   left = 1000011101100110010101011111\tright = 0010110100110110010001111000\n\n\t3- perform permuation Choice 2 on whole key to get round key:\n\t   round key #16  = 101110011101000011011100011000011010001011111100\n\t   in hexadecimal = B9D0DC61A2FC\n\n** Encryption or Decryption Rounds:\n   text (a1b2c3d4e5f60987) and key (abcdef1234567890):\n\n0- permutate text using initial remutation:\n   binary ==> 0011110000101010101110001101010110111111001100110100000010100110\n   hex    ==> 3C2AB8D5BF3340A6\n\nBegin 16 Rounds:\n\nRound #1\n\t1- split input to right and left:\n\t   left = 3C2AB8D5\tright = BF3340A6\n\n\t2- Perform DES function on right half:\n\n\t\ta- expand right half using expantion D Box:\n\t\t   binary ==> 010111111110100110100110101000000001010100001101\n\t\t   hex    ==> 5FE9A6A0150D\n\n\t\tb- perform xor on result from step a with round key:\n\t\t   binary ==> 100010101001010100111100011000101111001100010100\n\t\t   hex    ==> 8A953C62F314\n\n\t\tc- use Subtitute box on step b :\n\t\t   result ==> 13C8DA83\n\n\t\td- Use permutation Box P on step c:\n\t\t   result ==> 71274943\n\n\t3- left side equals xor result between DES func output and old left side:\n\t   left = 4D0DF196\tright = BF3340A6\n\n\t4- swap between left and right:\n\t   left = BF3340A6\tright = 4D0DF196\n\n\nRound #2\n\t1- split input to right and left:\n\t   left = BF3340A6\tright = 4D0DF196\n\n\t2- Perform DES function on right half:\n\n\t\ta- expand right half using expantion D Box:\n\t\t   binary ==> 001001011010100001011011111110100011110010101100\n\t\t   hex    ==> 25A85BFA3CAC\n\n\t\tb- perform xor on result from step a with round key:\n\t\t   binary ==> 001100011110001110110101010010111010000000100111\n\t\t   hex    ==> 31E3B54BA027\n\n\t\tc- use Subtitute box on step b :\n\t\t   result ==> BA555D47\n\n\t\td- Use permutation Box P on step c:\n\t\t   result ==> F49F3A2A\n\n\t3- left side equals xor result between DES func output and old left side:\n\t   left = 4BAC7A8C\tright = 4D0DF196\n\n\t4- swap between left and right:\n\t   left = 4D0DF196\tright = 4BAC7A8C\n\n\nRound #3\n\t1- split input to right and left:\n\t   left = 4D0DF196\tright = 4BAC7A8C\n\n\t2- Perform DES function on right half:\n\n\t\ta- expand right half using expantion D Box:\n\t\t   binary ==> 001001010111110101011000001111110101010001011000\n\t\t   hex    ==> 257D583F5458\n\n\t\tb- perform xor on result from step a with round key:\n\t\t   binary ==> 100101110000010001101101001100010100001001101111\n\t\t   hex    ==> 97046D31426F\n\n\t\tc- use Subtitute box on step b :\n\t\t   result ==> 852DB34D\n\n\t\td- Use permutation Box P on step c:\n\t\t   result ==> A9B078F4\n\n\t3- left side equals xor result between DES func output and old left side:\n\t   left = E4BD8962\tright = 4BAC7A8C\n\n\t4- swap between left and right:\n\t   left = 4BAC7A8C\tright = E4BD8962\n\n\nRound #4\n\t1- split input to right and left:\n\t   left = 4BAC7A8C\tright = E4BD8962\n\n\t2- Perform DES function on right half:\n\n\t\ta- expand right half using expantion D Box:\n\t\t   binary ==> 011100001001010111111011110001010010101100000101\n\t\t   hex    ==> 7095FBC52B05\n\n\t\tb- perform xor on result from step a with round key:\n\t\t   binary ==> 111111011011101010011110110110100100001011100001\n\t\t   hex    ==> FDBA9EDA42E1\n\n\t\tc- use Subtitute box on step b :\n\t\t   result ==> D9FF5F92\n\n\t\td- Use permutation Box P on step c:\n\t\t   result ==> B6EFF14F\n\n\t3- left side equals xor result between DES func output and old left side:\n\t   left = FD438BC3\tright = E4BD8962\n\n\t4- swap between left and right:\n\t   left = E4BD8962\tright = FD438BC3\n\n\nRound #5\n\t1- split input to right and left:\n\t   left = E4BD8962\tright = FD438BC3\n\n\t2- Perform DES function on right half:\n\n\t\ta- expand right half using expantion D Box:\n\t\t   binary ==> 111111111010101000000111110001010111111000000111\n\t\t   hex    ==> FFAA07C57E07\n\n\t\tb- perform xor on result from step a with round key:\n\t\t   binary ==> 001111001101110010111010111001011011011111010110\n\t\t   hex    ==> 3CDCBAE5B7D6\n\n\t\tc- use Subtitute box on step b :\n\t\t   result ==> 1812AB6E\n\n\t\td- Use permutation Box P on step c:\n\t\t   result ==> 1D7A24A2\n\n\t3- left side equals xor result between DES func output and old left side:\n\t   left = F9C7ADC0\tright = FD438BC3\n\n\t4- swap between left and right:\n\t   left = FD438BC3\tright = F9C7ADC0\n\n\nRound #6\n\t1- split input to right and left:\n\t   left = FD438BC3\tright = F9C7ADC0\n\n\t2- Perform DES function on right half:\n\n\t\ta- expand right half using expantion D Box:\n\t\t   binary ==> 011111110011111000001111110101011011111000000001\n\t\t   hex    ==> 7F3E0FD5BE01\n\n\t\tb- perform xor on result from step a with round key:\n\t\t   binary ==> 101000101010100111101111000101100001101000010110\n\t\t   hex    ==> A2A9EF161A16\n\n\t\tc- use Subtitute box on step b :\n\t\t   result ==> D40824CE\n\n\t\td- Use permutation Box P on step c:\n\t\t   result ==> 089280FB\n\n\t3- left side equals xor result between DES func output and old left side:\n\t   left = F5D10B38\tright = F9C7ADC0\n\n\t4- swap between left and right:\n\t   left = F9C7ADC0\tright = F5D10B38\n\n\nRound #7\n\t1- split input to right and left:\n\t   left = F9C7ADC0\tright = F5D10B38\n\n\t2- Perform DES function on right half:\n\n\t\ta- expand right half using expantion D Box:\n\t\t   binary ==> 011110101011111010100010100001010110100111110001\n\t\t   hex    ==> 7ABEA28569F1\n\n\t\tb- perform xor on result from step a with round key:\n\t\t   binary ==> 101010000110010001001001011010100110111001111001\n\t\t   hex    ==> A864496A6E79\n\n\t\tc- use Subtitute box on step b :\n\t\t   result ==> 6E2605E3\n\n\t\td- Use permutation Box P on step c:\n\t\t   result ==> 405ABE1D\n\n\t3- left side equals xor result between DES func output and old left side:\n\t   left = B99D13DD\tright = F5D10B38\n\n\t4- swap between left and right:\n\t   left = F5D10B38\tright = B99D13DD\n\n\nRound #8\n\t1- split input to right and left:\n\t   left = F5D10B38\tright = B99D13DD\n\n\t2- Perform DES function on right half:\n\n\t\ta- expand right half using expantion D Box:\n\t\t   binary ==> 110111110011110011111010100010100111111011111011\n\t\t   hex    ==> DF3CFA8A7EFB\n\n\t\tb- perform xor on result from step a with round key:\n\t\t   binary ==> 011001101100111110111100100100100010110110110100\n\t\t   hex    ==> 66CFBC922DB4\n\n\t\tc- use Subtitute box on step b :\n\t\t   result ==> 9D781E8A\n\n\t\td- Use permutation Box P on step c:\n\t\t   result ==> 3CAB405F\n\n\t3- left side equals xor result between DES func output and old left side:\n\t   left = C97A4B67\tright = B99D13DD\n\n\t4- swap between left and right:\n\t   left = B99D13DD\tright = C97A4B67\n\n\nRound #9\n\t1- split input to right and left:\n\t   left = B99D13DD\tright = C97A4B67\n\n\t2- Perform DES function on right half:\n\n\t\ta- expand right half using expantion D Box:\n\t\t   binary ==> 111001010010101111110100001001010110101100001111\n\t\t   hex    ==> E52BF4256B0F\n\n\t\tb- perform xor on result from step a with round key:\n\t\t   binary ==> 010100100001010111101010010110010110011001101011\n\t\t   hex    ==> 5215EA59666B\n\n\t\tc- use Subtitute box on step b :\n\t\t   result ==> 6DEBF42A\n\n\t\td- Use permutation Box P on step c:\n\t\t   result ==> A94FC7DC\n\n\t3- left side equals xor result between DES func output and old left side:\n\t   left = 10D2D401\tright = C97A4B67\n\n\t4- swap between left and right:\n\t   left = C97A4B67\tright = 10D2D401\n\n\nRound #10\n\t1- split input to right and left:\n\t   left = C97A4B67\tright = 10D2D401\n\n\t2- Perform DES function on right half:\n\n\t\ta- expand right half using expantion D Box:\n\t\t   binary ==> 100010100001011010100101011010101000000000000010\n\t\t   hex    ==> 8A16A56A8002\n\n\t\tb- perform xor on result from step a with round key:\n\t\t   binary ==> 111001000010000001110101011000100110100011011100\n\t\t   hex    ==> E420756268DC\n\n\t\tc- use Subtitute box on step b :\n\t\t   result ==> A1D5D5BC\n\n\t\td- Use permutation Box P on step c:\n\t\t   result ==> AF857729\n\n\t3- left side equals xor result between DES func output and old left side:\n\t   left = 66FF3C4E\tright = 10D2D401\n\n\t4- swap between left and right:\n\t   left = 10D2D401\tright = 66FF3C4E\n\n\nRound #11\n\t1- split input to right and left:\n\t   left = 10D2D401\tright = 66FF3C4E\n\n\t2- Perform DES function on right half:\n\n\t\ta- expand right half using expantion D Box:\n\t\t   binary ==> 001100001101011111111110100111111000001001011100\n\t\t   hex    ==> 30D7FE9F825C\n\n\t\tb- perform xor on result from step a with round key:\n\t\t   binary ==> 011011100000101110000010111110100111011011001101\n\t\t   hex    ==> 6E0B82FA76CD\n\n\t\tc- use Subtitute box on step b :\n\t\t   result ==> 500DECF7\n\n\t\td- Use permutation Box P on step c:\n\t\t   result ==> 93169CEB\n\n\t3- left side equals xor result between DES func output and old left side:\n\t   left = 83C448EA\tright = 66FF3C4E\n\n\t4- swap between left and right:\n\t   left = 66FF3C4E\tright = 83C448EA\n\n\nRound #12\n\t1- split input to right and left:\n\t   left = 66FF3C4E\tright = 83C448EA\n\n\t2- Perform DES function on right half:\n\n\t\ta- expand right half using expantion D Box:\n\t\t   binary ==> 010000000111111000001000001001010001011101010101\n\t\t   hex    ==> 407E08251755\n\n\t\tb- perform xor on result from step a with round key:\n\t\t   binary ==> 100011101001111101010010100011100001001100111110\n\t\t   hex    ==> 8E9F528E133E\n\n\t\tc- use Subtitute box on step b :\n\t\t   result ==> C3228488\n\n\t\td- Use permutation Box P on step c:\n\t\t   result ==> 49C0C00D\n\n\t3- left side equals xor result between DES func output and old left side:\n\t   left = 2F3FFC43\tright = 83C448EA\n\n\t4- swap between left and right:\n\t   left = 83C448EA\tright = 2F3FFC43\n\n\nRound #13\n\t1- split input to right and left:\n\t   left = 83C448EA\tright = 2F3FFC43\n\n\t2- Perform DES function on right half:\n\n\t\ta- expand right half using expantion D Box:\n\t\t   binary ==> 100101011110100111111111111111111000001000000110\n\t\t   hex    ==> 95E9FFFF8206\n\n\t\tb- perform xor on result from step a with round key:\n\t\t   binary ==> 101110110010011011010000011100010101100100000000\n\t\t   hex    ==> BB26D0715900\n\n\t\tc- use Subtitute box on step b :\n\t\t   result ==> B8B1EDBD\n\n\t\td- Use permutation Box P on step c:\n\t\t   result ==> 9F8C2FAF\n\n\t3- left side equals xor result between DES func output and old left side:\n\t   left = 1C486745\tright = 2F3FFC43\n\n\t4- swap between left and right:\n\t   left = 2F3FFC43\tright = 1C486745\n\n\nRound #14\n\t1- split input to right and left:\n\t   left = 2F3FFC43\tright = 1C486745\n\n\t2- Perform DES function on right half:\n\n\t\ta- expand right half using expantion D Box:\n\t\t   binary ==> 100011111000001001010000001100001110101000001010\n\t\t   hex    ==> 8F825030EA0A\n\n\t\tb- perform xor on result from step a with round key:\n\t\t   binary ==> 011001001011101101011011001001001010110111111110\n\t\t   hex    ==> 64BB5B24ADFE\n\n\t\tc- use Subtitute box on step b :\n\t\t   result ==> 928A42F8\n\n\t\td- Use permutation Box P on step c:\n\t\t   result ==> 4AF40543\n\n\t3- left side equals xor result between DES func output and old left side:\n\t   left = 65CBF900\tright = 1C486745\n\n\t4- swap between left and right:\n\t   left = 1C486745\tright = 65CBF900\n\n\nRound #15\n\t1- split input to right and left:\n\t   left = 1C486745\tright = 65CBF900\n\n\t2- Perform DES function on right half:\n\n\t\ta- expand right half using expantion D Box:\n\t\t   binary ==> 001100001011111001010111111111110010100000000000\n\t\t   hex    ==> 30BE57FF2800\n\n\t\tb- perform xor on result from step a with round key:\n\t\t   binary ==> 000110010001000010101110001001101010000011000001\n\t\t   hex    ==> 1910AE26A0C1\n\n\t\tc- use Subtitute box on step b :\n\t\t   result ==> 1C0D4801\n\n\t\td- Use permutation Box P on step c:\n\t\t   result ==> 900C1852\n\n\t3- left side equals xor result between DES func output and old left side:\n\t   left = 8C447F17\tright = 65CBF900\n\n\t4- swap between left and right:\n\t   left = 65CBF900\tright = 8C447F17\n\n\nRound #16\n\t1- split input to right and left:\n\t   left = 65CBF900\tright = 8C447F17\n\n\t2- Perform DES function on right half:\n\n\t\ta- expand right half using expantion D Box:\n\t\t   binary ==> 110001011000001000001000001111111110100010101111\n\t\t   hex    ==> C582083FE8AF\n\n\t\tb- perform xor on result from step a with round key:\n\t\t   binary ==> 011111000101001011010100010111100100101001010011\n\t\t   hex    ==> 7C52D45E4A53\n\n\t\tc- use Subtitute box on step b :\n\t\t   result ==> 8448AF15\n\n\t\td- Use permutation Box P on step c:\n\t\t   result ==> 13A128F8\n\n\t3- left side equals xor result between DES func output and old left side:\n\t   left = 766AD1F8\tright = 8C447F17\n\n\t4- Do NOT swap between left and right:\n\t   left = 766AD1F8\tright = 8C447F17\n\n*** Finally, inverse initial permutation on text to get final output:\n\t final result = 0E5AEA994F597D85\n\n=================================================================\n\nAES-128:\n\nExample 1:\nPlaintext: 00112233445566778899AABBCCDDEEFF\nKey: 000102030405060708090A0B0C0D0E0F\n\nResulting Ciphertext: 69C4E0D86A7B0430D8CDB78070B4C55A\n\n\nExample 2:\nPlaintext: 5468697320697320616E204145532D31\nKey: 2B7E151628AED2A6ABF7158809CF4F3C\n\nResulting Ciphertext: C29750C8F67CB589EA3962C79B3DBCC6\n\n\nExample 3:\nPlaintext: 0123456789ABCDEF0123456789ABCDEF\nKey: 000102030405060708090A0B0C0D0E0F\n\nResulting Ciphertext: 3071708FFD2412229B2677BA5F1C52D2\n\n=====================================================================\n\nAES-128 Full Example:\n\n* Generating Keys:\n1- Split Main key into 4 words\n\n\tword 0 = 19A5C57E\n\tword 1 = D93CF54A\n\tword 2 = 238ED589\n\tword 3 = 4125ADFE\n\n2-Genrate the rest of words (words from 4 to 43):\n\t\n\ti = 4 and i % 4 is 0\n\n\t\tStep 1: rotate word 3 ==> result = 25ADFE41\n\t\tStep 2: perform subword on step 1 ==> result = 3F95BB83\n\t\tStep 3: perform xor between RCON (1) and step 2 ==> result = 3E95BB83\n\t\tStep 4: perfrom xor between word 0 and stepc c \n\n==> word 4 = 27307EFD\n\n\ti = 5 and i % 4 is NOT 0\n\t\tStep 1: just perform xor between word 4 and word 1\n\n==>  word 5 = FE0C8BB7\n\n\ti = 6 and i % 4 is NOT 0\n\t\tStep 1: just perform xor between word 5 and word 2\n\n==>  word 6 = DD825E3E\n\n\ti = 7 and i % 4 is NOT 0\n\t\tStep 1: just perform xor between word 6 and word 3\n\n==>  word 7 = 9CA7F3C0\n\n\t\n\ti = 8 and i % 4 is 0\n\n\t\tStep 1: rotate word 7 ==> result = A7F3C09C\n\t\tStep 2: perform subword on step 1 ==> result = 5C0DBADE\n\t\tStep 3: perform xor between RCON (2) and step 2 ==> result = 5E0DBADE\n\t\tStep 4: perfrom xor between word 4 and stepc c \n\n==> word 8 = 793DC423\n\n\ti = 9 and i % 4 is NOT 0\n\t\tStep 1: just perform xor between word 8 and word 5\n\n==>  word 9 = 87314F94\n\n\ti = 10 and i % 4 is NOT 0\n\t\tStep 1: just perform xor between word 9 and word 6\n\n==>  word 10 = 5AB311AA\n\n\ti = 11 and i % 4 is NOT 0\n\t\tStep 1: just perform xor between word 10 and word 7\n\n==>  word 11 = C614E26A\n\n\t\n\ti = 12 and i % 4 is 0\n\n\t\tStep 1: rotate word 11 ==> result = 14E26AC6\n\t\tStep 2: perform subword on step 1 ==> result = FA9802B4\n\t\tStep 3: perform xor between RCON (3) and step 2 ==> result = FE9802B4\n\t\tStep 4: perfrom xor between word 8 and stepc c \n\n==> word 12 = 87A5C697\n\n\ti = 13 and i % 4 is NOT 0\n\t\tStep 1: just perform xor between word 12 and word 9\n\n==>  word 13 = 00948903\n\n\ti = 14 and i % 4 is NOT 0\n\t\tStep 1: just perform xor between word 13 and word 10\n\n==>  word 14 = 5A2798A9\n\n\ti = 15 and i % 4 is NOT 0\n\t\tStep 1: just perform xor between word 14 and word 11\n\n==>  word 15 = 9C337AC3\n\n\t\n\ti = 16 and i % 4 is 0\n\n\t\tStep 1: rotate word 15 ==> result = 337AC39C\n\t\tStep 2: perform subword on step 1 ==> result = C3DA2EDE\n\t\tStep 3: perform xor between RCON (4) and step 2 ==> result = CBDA2EDE\n\t\tStep 4: perfrom xor between word 12 and stepc c \n\n==> word 16 = 4C7FE849\n\n\ti = 17 and i % 4 is NOT 0\n\t\tStep 1: just perform xor between word 16 and word 13\n\n==>  word 17 = 4CEB614A\n\n\ti = 18 and i % 4 is NOT 0\n\t\tStep 1: just perform xor between word 17 and word 14\n\n==>  word 18 = 16CCF9E3\n\n\ti = 19 and i % 4 is NOT 0\n\t\tStep 1: just perform xor between word 18 and word 15\n\n==>  word 19 = 8AFF8320\n\n\t\n\ti = 20 and i % 4 is 0\n\n\t\tStep 1: rotate word 19 ==> result = FF83208A\n\t\tStep 2: perform subword on step 1 ==> result = 16ECB77E\n\t\tStep 3: perform xor between RCON (5) and step 2 ==> result = 06ECB77E\n\t\tStep 4: perfrom xor between word 16 and stepc c \n\n==> word 20 = 4A935F37\n\n\ti = 21 and i % 4 is NOT 0\n\t\tStep 1: just perform xor between word 20 and word 17\n\n==>  word 21 = 06783E7D\n\n\ti = 22 and i % 4 is NOT 0\n\t\tStep 1: just perform xor between word 21 and word 18\n\n==>  word 22 = 10B4C79E\n\n\ti = 23 and i % 4 is NOT 0\n\t\tStep 1: just perform xor between word 22 and word 19\n\n==>  word 23 = 9A4B44BE\n\n\t\n\ti = 24 and i % 4 is 0\n\n\t\tStep 1: rotate word 23 ==> result = 4B44BE9A\n\t\tStep 2: perform subword on step 1 ==> result = B31BAEB8\n\t\tStep 3: perform xor between RCON (6) and step 2 ==> result = 931BAEB8\n\t\tStep 4: perfrom xor between word 20 and stepc c \n\n==> word 24 = D988F18F\n\n\ti = 25 and i % 4 is NOT 0\n\t\tStep 1: just perform xor between word 24 and word 21\n\n==>  word 25 = DFF0CFF2\n\n\ti = 26 and i % 4 is NOT 0\n\t\tStep 1: just perform xor between word 25 and word 22\n\n==>  word 26 = CF44086C\n\n\ti = 27 and i % 4 is NOT 0\n\t\tStep 1: just perform xor between word 26 and word 23\n\n==>  word 27 = 550F4CD2\n\n\t\n\ti = 28 and i % 4 is 0\n\n\t\tStep 1: rotate word 27 ==> result = 0F4CD255\n\t\tStep 2: perform subword on step 1 ==> result = 7629B5FC\n\t\tStep 3: perform xor between RCON (7) and step 2 ==> result = 3629B5FC\n\t\tStep 4: perfrom xor between word 24 and stepc c \n\n==> word 28 = EFA14473\n\n\ti = 29 and i % 4 is NOT 0\n\t\tStep 1: just perform xor between word 28 and word 25\n\n==>  word 29 = 30518B81\n\n\ti = 30 and i % 4 is NOT 0\n\t\tStep 1: just perform xor between word 29 and word 26\n\n==>  word 30 = FF1583ED\n\n\ti = 31 and i % 4 is NOT 0\n\t\tStep 1: just perform xor between word 30 and word 27\n\n==>  word 31 = AA1ACF3F\n\n\t\n\ti = 32 and i % 4 is 0\n\n\t\tStep 1: rotate word 31 ==> result = 1ACF3FAA\n\t\tStep 2: perform subword on step 1 ==> result = A28A75AC\n\t\tStep 3: perform xor between RCON (8) and step 2 ==> result = 228A75AC\n\t\tStep 4: perfrom xor between word 28 and stepc c \n\n==> word 32 = CD2B31DF\n\n\ti = 33 and i % 4 is NOT 0\n\t\tStep 1: just perform xor between word 32 and word 29\n\n==>  word 33 = FD7ABA5E\n\n\ti = 34 and i % 4 is NOT 0\n\t\tStep 1: just perform xor between word 33 and word 30\n\n==>  word 34 = 026F39B3\n\n\ti = 35 and i % 4 is NOT 0\n\t\tStep 1: just perform xor between word 34 and word 31\n\n==>  word 35 = A875F68C\n\n\t\n\ti = 36 and i % 4 is 0\n\n\t\tStep 1: rotate word 35 ==> result = 75F68CA8\n\t\tStep 2: perform subword on step 1 ==> result = 9D4264C2\n\t\tStep 3: perform xor between RCON (9) and step 2 ==> result = 864264C2\n\t\tStep 4: perfrom xor between word 32 and stepc c \n\n==> word 36 = 4B69551D\n\n\ti = 37 and i % 4 is NOT 0\n\t\tStep 1: just perform xor between word 36 and word 33\n\n==>  word 37 = B613EF43\n\n\ti = 38 and i % 4 is NOT 0\n\t\tStep 1: just perform xor between word 37 and word 34\n\n==>  word 38 = B47CD6F0\n\n\ti = 39 and i % 4 is NOT 0\n\t\tStep 1: just perform xor between word 38 and word 35\n\n==>  word 39 = 1C09207C\n\n\t\n\ti = 40 and i % 4 is 0\n\n\t\tStep 1: rotate word 39 ==> result = 09207C1C\n\t\tStep 2: perform subword on step 1 ==> result = 01B7109C\n\t\tStep 3: perform xor between RCON (10) and step 2 ==> result = 37B7109C\n\t\tStep 4: perfrom xor between word 36 and stepc c \n\n==> word 40 = 7CDE4581\n\n\ti = 41 and i % 4 is NOT 0\n\t\tStep 1: just perform xor between word 40 and word 37\n\n==>  word 41 = CACDAAC2\n\n\ti = 42 and i % 4 is NOT 0\n\t\tStep 1: just perform xor between word 41 and word 38\n\n==>  word 42 = 7EB17C32\n\n\ti = 43 and i % 4 is NOT 0\n\t\tStep 1: just perform xor between word 42 and word 39\n\n==>  word 43 = 62B85C4E\n\nFinally the keys are:\n\t00- 19A5C57ED93CF54A238ED5894125ADFE\n\t01- 27307EFDFE0C8BB7DD825E3E9CA7F3C0\n\t02- 793DC42387314F945AB311AAC614E26A\n\t03- 87A5C697009489035A2798A99C337AC3\n\t04- 4C7FE8494CEB614A16CCF9E38AFF8320\n\t05- 4A935F3706783E7D10B4C79E9A4B44BE\n\t06- D988F18FDFF0CFF2CF44086C550F4CD2\n\t07- EFA1447330518B81FF1583EDAA1ACF3F\n\t08- CD2B31DFFD7ABA5E026F39B3A875F68C\n\t09- 4B69551DB613EF43B47CD6F01C09207C\n\t10- 7CDE4581CACDAAC27EB17C3262B85C4E\n\n\n** Encrypting (796F75637261636B6564616573313238) using key (19A5C57ED93CF54A238ED5894125ADFE) :\n\t0- Initial Round: \n\t\tAdd Round Key to block\n\t\t==> Result = \n\t\t\t60 AB 46 32 \n\t\t\tCA 5D EA 14 \n\t\t\tB0 96 B4 9F \n\t\t\t1D 21 EC C6 \n\n\tROUND #1\n\t1- Subbyte\n\t\t==> Result = \n\t\t\tD0 62 5A 23 \n\t\t\t74 4C 87 FA \n\t\t\tE7 90 8D DB \n\t\t\tA4 FD CE B4 \n\n\n\t2- ShiftRow\n\t\t==> Result = \n\t\t\tD0 62 5A 23 \n\t\t\t4C 87 FA 74 \n\t\t\t8D DB E7 90 \n\t\t\tB4 A4 FD CE \n\n\n\t3- MixColumns\n\t\t==> Result = \n\t\t\t56 29 BB 84 \n\t\t\t70 A5 7A AE \n\t\t\t5A BF 69 25 \n\t\t\tD9 A9 12 06 \n\n\n\t4- Add Round Key\n\t\t==> Result = \n\t\t\t71 D7 66 18 \n\t\t\t40 A9 F8 09 \n\t\t\t24 34 37 D6 \n\t\t\t24 1E 2C C6 \n\n\tROUND #2\n\t1- Subbyte\n\t\t==> Result = \n\t\t\tA3 0E 33 AD \n\t\t\t09 D3 41 01 \n\t\t\t36 18 9A F6 \n\t\t\t36 72 71 B4 \n\n\n\t2- ShiftRow\n\t\t==> Result = \n\t\t\tA3 0E 33 AD \n\t\t\tD3 41 01 09 \n\t\t\t9A F6 36 18 \n\t\t\tB4 36 72 71 \n\n\n\t3- MixColumns\n\t\t==> Result = \n\t\t\t1D 1F 21 33 \n\t\t\t1F BB 19 E6 \n\t\t\t98 E2 C8 07 \n\t\t\tC4 C9 86 1F \n\n\n\t4- Add Round Key\n\t\t==> Result = \n\t\t\t64 98 7B F5 \n\t\t\t22 8A AA F2 \n\t\t\t5C AD D9 E5 \n\t\t\tE7 5D 2C 75 \n\n\tROUND #3\n\t1- Subbyte\n\t\t==> Result = \n\t\t\t43 46 21 E6 \n\t\t\t93 7E AC 89 \n\t\t\t4A 95 35 D9 \n\t\t\t94 4C 71 9D \n\n\n\t2- ShiftRow\n\t\t==> Result = \n\t\t\t43 46 21 E6 \n\t\t\t7E AC 89 93 \n\t\t\t35 D9 4A 95 \n\t\t\t9D 94 4C 71 \n\n\n\t3- MixColumns\n\t\t==> Result = \n\t\t\tAC 2E C4 9D \n\t\t\t7D E1 BA 0E \n\t\t\tEB E4 E8 D7 \n\t\t\tAF 8C 38 D5 \n\n\n\t4- Add Round Key\n\t\t==> Result = \n\t\t\t2B 2E 9E 01 \n\t\t\tD8 75 9D 3D \n\t\t\t2D 6D 70 AD \n\t\t\t38 8F 91 16 \n\n\tROUND #4\n\t1- Subbyte\n\t\t==> Result = \n\t\t\tF1 31 0B 7C \n\t\t\t61 9D 5E 27 \n\t\t\tD8 3C 51 95 \n\t\t\t07 73 81 47 \n\n\n\t2- ShiftRow\n\t\t==> Result = \n\t\t\tF1 31 0B 7C \n\t\t\t9D 5E 27 61 \n\t\t\t51 95 D8 3C \n\t\t\t47 07 73 81 \n\n\n\t3- MixColumns\n\t\t==> Result = \n\t\t\t53 12 D4 E6 \n\t\t\t64 2E 45 7B \n\t\t\t07 57 12 FD \n\t\t\t4A 96 04 C0 \n\n\n\t4- Add Round Key\n\t\t==> Result = \n\t\t\t1F 5E C2 6C \n\t\t\t1B C5 89 84 \n\t\t\tEF 36 EB 7E \n\t\t\t03 DC E7 E0 \n\n\tROUND #5\n\t1- Subbyte\n\t\t==> Result = \n\t\t\tC0 58 25 50 \n\t\t\tAF A6 A7 5F \n\t\t\tDF 05 E9 F3 \n\t\t\t7B 86 94 E1 \n\n\n\t2- ShiftRow\n\t\t==> Result = \n\t\t\tC0 58 25 50 \n\t\t\tA6 A7 5F AF \n\t\t\tE9 F3 DF 05 \n\t\t\tE1 7B 86 94 \n\n\n\t3- MixColumns\n\t\t==> Result = \n\t\t\t62 CA F2 DB \n\t\t\t56 78 67 8E \n\t\t\t97 8F 4E 52 \n\t\t\tCD 4A F8 69 \n\n\n\t4- Add Round Key\n\t\t==> Result = \n\t\t\t28 CC E2 41 \n\t\t\tC5 00 D3 C5 \n\t\t\tC8 B1 89 16 \n\t\t\tFA 37 66 D7 \n\n\tROUND #6\n\t1- Subbyte\n\t\t==> Result = \n\t\t\t34 4B 98 83 \n\t\t\tA6 63 66 A6 \n\t\t\tE8 C8 A7 47 \n\t\t\t2D 9A 33 0E \n\n\n\t2- ShiftRow\n\t\t==> Result = \n\t\t\t34 4B 98 83 \n\t\t\t63 66 A6 A6 \n\t\t\tA7 47 E8 C8 \n\t\t\t0E 2D 9A 33 \n\n\n\t3- MixColumns\n\t\t==> Result = \n\t\t\t64 56 A8 17 \n\t\t\t0E 63 76 A4 \n\t\t\t10 D4 40 FB \n\t\t\t84 A6 D2 96 \n\n\n\t4- Add Round Key\n\t\t==> Result = \n\t\t\tBD 89 67 42 \n\t\t\t86 93 32 AB \n\t\t\tE1 1B 48 B7 \n\t\t\t0B 54 BE 44 \n\n\tROUND #7\n\t1- Subbyte\n\t\t==> Result = \n\t\t\t7A A7 85 2C \n\t\t\t44 DC 23 62 \n\t\t\tF8 AF 52 A9 \n\t\t\t2B 20 AE 1B \n\n\n\t2- ShiftRow\n\t\t==> Result = \n\t\t\t7A A7 85 2C \n\t\t\tDC 23 62 44 \n\t\t\t52 A9 F8 AF \n\t\t\t1B 2B 20 AE \n\n\n\t3- MixColumns\n\t\t==> Result = \n\t\t\tC2 B2 6F 95 \n\t\t\t34 2A 72 E0 \n\t\t\t2F B0 6C C4 \n\t\t\t36 2E 4E D8 \n\n\n\t4- Add Round Key\n\t\t==> Result = \n\t\t\t2D 82 90 3F \n\t\t\t95 7B 67 FA \n\t\t\t6B 3B EF 0B \n\t\t\t45 AF A3 E7 \n\n\tROUND #8\n\t1- Subbyte\n\t\t==> Result = \n\t\t\tD8 13 60 75 \n\t\t\t2A 21 85 2D \n\t\t\t7F E2 DF 2B \n\t\t\t6E 79 0A 94 \n\n\n\t2- ShiftRow\n\t\t==> Result = \n\t\t\tD8 13 60 75 \n\t\t\t21 85 2D 2A \n\t\t\tDF 2B 7F E2 \n\t\t\t94 6E 79 0A \n\n\n\t3- MixColumns\n\t\t==> Result = \n\t\t\t83 F7 B1 7C \n\t\t\t74 11 C2 16 \n\t\t\tFB 72 38 9E \n\t\t\tBE 47 00 43 \n\n\n\t4- Add Round Key\n\t\t==> Result = \n\t\t\t4E 0A B3 D4 \n\t\t\t5F 6B AD 63 \n\t\t\tCA C8 01 68 \n\t\t\t61 19 B3 CF \n\n\tROUND #9\n\t1- Subbyte\n\t\t==> Result = \n\t\t\t2F 67 6D 48 \n\t\t\tCF 7F 95 FB \n\t\t\t74 E8 7C 45 \n\t\t\tEF D4 6D 8A \n\n\n\t2- ShiftRow\n\t\t==> Result = \n\t\t\t2F 67 6D 48 \n\t\t\t7F 95 FB CF \n\t\t\t7C 45 74 E8 \n\t\t\t8A EF D4 6D \n\n\n\t3- MixColumns\n\t\t==> Result = \n\t\t\t29 C0 6C 5F \n\t\t\tDF 76 C8 83 \n\t\t\t2D 52 19 FB \n\t\t\t7D BC 8B 25 \n\n\n\t4- Add Round Key\n\t\t==> Result = \n\t\t\t62 76 D8 43 \n\t\t\tB6 65 B4 8A \n\t\t\t78 BD CF DB \n\t\t\t60 FF 7B 59 \n\n\tROUND #10\n\t1- Subbyte\n\t\t==> Result = \n\t\t\tAA 38 61 1A \n\t\t\t4E 4D 8D 7E \n\t\t\tBC 7A 8A B9 \n\t\t\tD0 16 21 CB \n\n\n\t2- ShiftRow\n\t\t==> Result = \n\t\t\tAA 38 61 1A \n\t\t\t4D 8D 7E 4E \n\t\t\t8A B9 BC 7A \n\t\t\tCB D0 16 21 \n\n\n\t4- Add Round Key\n\t\t==> Result = \n\t\t\tD6 F2 1F 78 \n\t\t\t93 40 CF F6 \n\t\t\tCF 13 C0 26 \n\t\t\t4A 12 24 6F \n\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\nThe End.. I hope you achieve something Awesome !");
        exampleTextArea.setBorder(null);
        exampleTextArea.setCaretPosition(0);
        jScrollPane9.setViewportView(exampleTextArea);

        javax.swing.GroupLayout examplePanelLayout = new javax.swing.GroupLayout(examplePanel);
        examplePanel.setLayout(examplePanelLayout);
        examplePanelLayout.setHorizontalGroup(
            examplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(examplePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 941, Short.MAX_VALUE)
                .addContainerGap())
        );
        examplePanelLayout.setVerticalGroup(
            examplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(examplePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
                .addContainerGap())
        );

        InfoSec.addTab("Examples", examplePanel);

        contact_info.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        fb.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        fb.setForeground(new java.awt.Color(0, 51, 204));
        fb.setText("FaceBook");
        fb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fbMouseClicked(evt);
            }
        });

        my_img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cryptonite_v1_2/adel_pic.jpg"))); // NOI18N

        telegram.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        telegram.setForeground(new java.awt.Color(0, 51, 204));
        telegram.setText("Telegram");
        telegram.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        telegram.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                telegramMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout contact_infoLayout = new javax.swing.GroupLayout(contact_info);
        contact_info.setLayout(contact_infoLayout);
        contact_infoLayout.setHorizontalGroup(
            contact_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contact_infoLayout.createSequentialGroup()
                .addGroup(contact_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contact_infoLayout.createSequentialGroup()
                        .addGap(387, 387, 387)
                        .addGroup(contact_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(my_img)
                            .addComponent(fb)))
                    .addGroup(contact_infoLayout.createSequentialGroup()
                        .addGap(435, 435, 435)
                        .addComponent(telegram)))
                .addGap(387, 387, 387))
        );
        contact_infoLayout.setVerticalGroup(
            contact_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contact_infoLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(my_img)
                .addGap(18, 18, 18)
                .addComponent(fb)
                .addGap(18, 18, 18)
                .addComponent(telegram)
                .addContainerGap(243, Short.MAX_VALUE))
        );

        InfoSec.addTab("Contact Info", contact_info);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(InfoSec, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 970, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(InfoSec, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private static final Logger LOG = Logger.getLogger(Main.class.getName());

    private void fbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fbMouseClicked
        try {
            Desktop.getDesktop().browse(new URI("https://www.facebook.com/adel.azeez.ja"));
        }
        catch (IOException | URISyntaxException e1) {
        }
    }//GEN-LAST:event_fbMouseClicked

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        Component[] c = keysched.getComponents();
        for (Component c1 : c) {
            boolean a = c1.getClass().equals(addi_text.getClass());
            if (a) {
                JTextComponent a1 = (JTextComponent) c1;
                a1.setText(null);
            }
        }
        DefaultTableModel table = (DefaultTableModel) jTable1.getModel();
        table.setRowCount(0);
        key_sched_ch_num.setText(key_sched_text.getText().length() + " Characters");
    }//GEN-LAST:event_jButton11ActionPerformed

    private void key_sched_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_key_sched_submitActionPerformed
        DefaultTableModel table = (DefaultTableModel) jTable1.getModel();
        table.setRowCount(0);
        key_sched_error.setForeground(Color.red);
        try {
            if (des_keysched.isSelected()) {
                long g = Long.parseUnsignedLong(key_sched_text.getText(), 16);
                DES des = new DES(key_sched_text.getText());
                String[] a = des.getSub_keys();
                for (int i = 0; i < a.length; i++) {
                    table.addRow(new Object[]{(i + 1), a[i]});
                }
            }
            else if (aes_keysched.isSelected()) {
                AES128 aes = new AES128(key_sched_text.getText());
                String[] a = aes.getSub_keys();
                for (int i = 0; i < a.length; i++) {
                    String t = a[i].substring(0, 8) + " " + a[i].substring(8, 16) + " " + a[i].substring(16, 24) + " " + a[i].substring(24, 32);
                    table.addRow(new Object[]{(i), t});
                }
            }
            key_sched_error.setForeground(new Color(0, 255, 64));
            key_sched_error.setText("No Errors :)");
        }
        catch (java.lang.NumberFormatException ex) {
            key_sched_error.setText("Key is NOT entered in Hexadecimal format");
        }
        catch (Exception ex) {
            key_sched_error.setText(ex.getMessage());
        }
    }//GEN-LAST:event_key_sched_submitActionPerformed

    private void key_sched_textKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_key_sched_textKeyReleased
        key_sched_ch_num.setText(key_sched_text.getText().length() + " Characters");
    }//GEN-LAST:event_key_sched_textKeyReleased

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        Component[] c = despanel.getComponents();
        for (Component c1 : c) {
            boolean a = c1.getClass().equals(addi_text.getClass());
            if (a) {
                JTextComponent a1 = (JTextComponent) c1;
                a1.setText(null);
            }
        }
        des_ch_count.setText(des_text.getText().length() + " Characters");
        des_key_count.setText(des_key.getText().length() + " Characters");
    }//GEN-LAST:event_jButton8ActionPerformed

    private void des_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_des_submitActionPerformed
        String text = des_text.getText();
        String key = des_key.getText();
        des_out.setText("");
        des_error.setForeground(Color.red);
        try {
            DES des = new DES(key);
            if (des_enc.isSelected()) {
                String enc = des.cipher(text, DES.ENCRYPT).toUpperCase();
                des_out.setText(enc);
            }
            else if (des_dec.isSelected()) {
                String dec = des.cipher(text, DES.DECRYPT).toLowerCase();
                des_out.setText(dec);
            }
            des_error.setForeground(new Color(0, 255, 64));
            if (des_savetofile.isSelected()) {
                boolean saved = des.SaveToTextFile();
                if (saved) {
                    des_error.setText("No Errors And File Saved Successfully :)");
                }
                else {
                    des_error.setText("No Errors And File NOT Saved due to permission error :(");
                }
            }
            else {
                des_error.setText("No Errors :)");
            }
        }
        catch (java.lang.StringIndexOutOfBoundsException ex) {
            des_error.setText("Key and text must be entered in proper format");
        }
        catch (Exception ex) {
            des_error.setText(ex.getMessage());
        }
    }//GEN-LAST:event_des_submitActionPerformed

    private void des_textKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_des_textKeyReleased
        des_ch_count.setText(des_text.getText().length() + " Characters");
    }//GEN-LAST:event_des_textKeyReleased

    private void des_keyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_des_keyKeyReleased
        des_key_count.setText(des_key.getText().length() + " Characters");
    }//GEN-LAST:event_des_keyKeyReleased

    private void hill_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hill_clearActionPerformed
        Component[] c = hill_cipher.getComponents();
        for (Component c1 : c) {
            boolean a = c1.getClass().equals(addi_text.getClass());
            if (a) {
                JTextComponent a1 = (JTextComponent) c1;
                a1.setText(null);
            }
        }
        DefaultTableModel table = (DefaultTableModel) hill_mat.getModel();
        table.setRowCount(0);
        table.setColumnCount(0);
        hill_out.setText(null);
        hill_error.setText(null);
        hill_text.setText(null);
    }//GEN-LAST:event_hill_clearActionPerformed

    private void hill_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hill_submitActionPerformed
        hill_out.setText(null);
        hill_error.setText(null);
        hill_error.setForeground(Color.red);
        String text = hill_text.getText();
        text = text.replaceAll(" ", "");
        DefaultTableModel table = (DefaultTableModel) hill_mat.getModel();

        try {
            int num = Integer.parseInt(hill_mat_size.getText());
            if (num < 2) {
                throw new Exception("Matrix dimensions must be equal or bigger than 2");
            }
            int[][] key = new int[num][num];
            for (int i = 0; i < num; i++) {
                for (int j = 0; j < num; j++) {
                    if ((table.getValueAt(i, j) == null) || (table.getValueAt(i, j).equals(""))) {
                        throw new Exception("please complete entering the hill cipher matrix");
                    }
                    key[i][j] = Integer.parseInt((String) table.getValueAt(i, j));
                }
            }
            ClassicEncryption ce = new ClassicEncryption();
            String out;
            if (hill_enc.isSelected()) {
                if (hill_book.isSelected()) {
                    out = ce.book_hill_cipher(text, key);
                    hill_out.setText(out);
                }
                else if (hill_std.isSelected()) {
                    out = ce.std_hill_cipher(text, key);
                    hill_out.setText(out);
                }
            }
            else if (hill_dec.isSelected()) {
                if (hill_book.isSelected()) {
                    out = ce.book_hill_decipher(text, key);
                    hill_out.setText(out);
                }
                else if (hill_std.isSelected()) {
                    out = ce.std_hill_decipher(text, key);
                    hill_out.setText(out);
                }
            }
            hill_error.setForeground(new Color(0, 255, 64));
            hill_error.setText("No Errors :)");
        }
        catch (java.lang.NumberFormatException ex) {
            hill_error.setText("Error while parsing Matrix elements or size (must only contain numbers NOT letters)");
        }
        catch (java.lang.ArrayIndexOutOfBoundsException ex) {
            hill_error.setText("Please enter some text to encrypt or decrypt");
        }
        catch (java.lang.NullPointerException ex) {
            hill_error.setText("text must only conation alphapet charaters (NOT Numbers)");
        }
        catch (Exception ex) {
            hill_error.setText(ex.getMessage());
        }
    }//GEN-LAST:event_hill_submitActionPerformed

    private void hill_mat_sizeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hill_mat_sizeKeyReleased
        hill_error.setForeground(Color.red);
        try {
            int num = Integer.parseInt(hill_mat_size.getText());
            DefaultTableModel table = (DefaultTableModel) hill_mat.getModel();
            if (num < 2) {
                throw new Exception("Matrix dimensions must be equal or bigger than 2");
            }
            table.setColumnCount(num);
            table.setRowCount(num);
            hill_error.setText(null);
        }
        catch (java.lang.NumberFormatException ex) {
            hill_error.setText("matrix size must be numbers ONLY");
        }
        catch (Exception ex) {
            hill_error.setText(ex.getMessage());
        }
    }//GEN-LAST:event_hill_mat_sizeKeyReleased

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        Component[] c = adfgvx.getComponents();
        for (Component c1 : c) {
            boolean a = c1.getClass().equals(addi_text.getClass());
            if (a) {
                JTextComponent a1 = (JTextComponent) c1;
                a1.setText(null);
            }
        }
        adfgvx_mat.setText(null);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void adf_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adf_submitActionPerformed
        adf_out.setText("");
        adfgvx_mat.setText("");
        adf_error.setForeground(Color.red);
        try {
            Adfgvx adf = new Adfgvx(adf_k1.getText(), adf_k2.getText());
            char[][] arr = adf.getTable();
            String table_st = "";
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    table_st += arr[i][j] + " ";
                }
                table_st += "\n";
            }
            if (adf_no_pad.isSelected() || adf_w_pad.isSelected()) {
                String out;
                if (adf_no_pad.isSelected()) {
                    out = adf.cipher(adf_text.getText(), ' ');
                }
                else {
                    out = adf.cipher(adf_text.getText(), 'A');
                }
                adf_out.setText(out);
            }
            else if (adf_dec.isSelected()) {
                String plain = adf.decipher(adf_text.getText().toUpperCase());
                adf_out.setText(plain);
            }
            adfgvx_mat.setText(table_st);
            adf_error.setForeground(new Color(0, 255, 64));
            adf_error.setText("No Errors :)");
        }
        catch (Exception ex) {
            adf_error.setText(ex.getMessage());
        }
    }//GEN-LAST:event_adf_submitActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        Component[] c = playfair.getComponents();
        for (Component c1 : c) {
            boolean a = c1.getClass().equals(addi_text.getClass());
            if (a) {
                JTextComponent a1 = (JTextComponent) c1;
                a1.setText(null);
            }
        }
        playfair_mat.setText(null);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        playfair_out.setText("");
        playfair_error.setForeground(Color.red);
        try {
            if (playfair_enc.isSelected()) {
                PlayFair pf1 = new PlayFair(playfair_key.getText());
                String table = "";
                char[][] s = pf1.getTable();
                for (char[] item : s) {
                    for (int j = 0; j < s[0].length; j++) {
                        table += item[j] + " ";
                    }
                    table += "\n";
                }
                playfair_out.setText(pf1.cipher(playfair_text.getText()));
                playfair_a_pad.setText(pf1.formatPlayfairText(playfair_text.getText(),true));
                playfair_mat.setText(table);
            }
            else if (playfair_dec.isSelected()) {
                PlayFair pf2 = new PlayFair(playfair_key.getText());
                String table = "";
                char[][] s = pf2.getTable();
                for (char[] item : s) {
                    for (int j = 0; j < s[0].length; j++) {
                        table += item[j] + " ";
                    }
                    table += "\n";
                }
                playfair_out.setText(pf2.decipher(playfair_text.getText()));
                playfair_a_pad.setText(pf2.formatPlayfairText(playfair_text.getText(),true));
                playfair_mat.setText(table);
            }
            playfair_error.setForeground(new Color(0, 255, 64));
            playfair_error.setText("No Errors :)");
        }
        catch (Exception ex) {
            playfair_error.setText(ex.getMessage());
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Component[] c = vigenere.getComponents();
        for (Component c1 : c) {
            boolean a = c1.getClass().equals(addi_text.getClass());
            if (a) {
                JTextComponent a1 = (JTextComponent) c1;
                a1.setText(null);
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void vig_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vig_submitActionPerformed
        vig_out.setText("");
        vig_error.setForeground(Color.red);
        ClassicEncryption ce = new ClassicEncryption();
        String key = vig_key.getText();
        String text = vig_text.getText();
        String kk = "";
        try {
            if (vig_key_mode.getSelectedIndex() == 0) {
                int[] k = convertStringToIntArray(key);
                for (int i = 0; i < k.length; i++) {
                    kk += ce.indexToCharacterMap.get(k[i] % 26);
                }
                vig_num_key.setText(kk);
            }
            else if (vig_key_mode.getSelectedIndex() == 1) {
                kk = key;
                if (kk.equals("")) {
                    throw new java.lang.NullPointerException("Key is not entered correctly");
                }
                vig_num_key.setText(null);
            }
            if (vig_enc.isSelected()) {
                String out = ce.encryptVigenere(text, kk);
                vig_out.setText(out);
            }
            else if (vig_dec.isSelected()) {
                String out = ce.decryptVigenere(text, kk);
                vig_out.setText(out);
            }
            vig_error.setForeground(new Color(0, 255, 64));
            vig_error.setText("No Errors :)");
        }
        catch (java.lang.NullPointerException ex) {
            vig_error.setText("Text must contain alphapet only (Not NUMBERS)");
        }
        catch (java.lang.NumberFormatException | java.lang.StringIndexOutOfBoundsException ex) {
            vig_error.setText("Key is not entered correctly");
        }
        catch (Exception ex) {
            vig_error.setText(ex.getMessage());
        }
    }//GEN-LAST:event_vig_submitActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Component[] c = autokey.getComponents();
        for (Component c1 : c) {
            boolean a = c1.getClass().equals(addi_text.getClass());
            if (a) {
                JTextComponent a1 = (JTextComponent) c1;
                a1.setText(null);
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void auto_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_auto_submitActionPerformed
        auto_out.setText("");
        auto_error.setForeground(Color.red);
        ClassicEncryption ce = new ClassicEncryption();
        String key = auto_key.getText();
        String text = auto_text.getText();
        String kk = "";
        try {
            if (auto_key_mode.getSelectedIndex() == 0) {
                int[] k = convertStringToIntArray(key);
                for (int i = 0; i < k.length; i++) {
                    kk += ce.indexToCharacterMap.get(k[i] % 26);
                }
                autokey_num_key.setText(kk);
            }
            else if (auto_key_mode.getSelectedIndex() == 1) {
                kk = key;
                if (kk.equals("")) {
                    throw new java.lang.NullPointerException("Key is not entered correctly");
                }
                autokey_num_key.setText(null);
            }
            if (auto_enc.isSelected()) {
                String out = ce.encryptAutokey(text, kk);
                auto_out.setText(out);
            }
            else if (auto_dec.isSelected()) {
                String out = ce.decryptAutokey(text, kk);
                auto_out.setText(out);
            }
            auto_error.setText("No Errors :)");
            auto_error.setForeground(new Color(0, 255, 64));
        }
        catch (java.lang.NullPointerException ex) {
            auto_error.setText("Text must contain alphapet only (Not NUMBERS)");
        }
        catch (java.lang.NumberFormatException | java.lang.StringIndexOutOfBoundsException ex) {
            auto_error.setText("Key is not entered correctly");
        }
        catch (Exception ex) {
            auto_error.setText(ex.getMessage());
        }
    }//GEN-LAST:event_auto_submitActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Component[] c = affine.getComponents();
        for (Component c1 : c) {
            boolean a = c1.getClass().equals(addi_text.getClass());
            if (a) {
                JTextComponent a1 = (JTextComponent) c1;
                a1.setText(null);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void aff_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aff_submitActionPerformed
        aff_out.setText("");
        aff_error.setForeground(Color.red);
        ClassicEncryption ce = new ClassicEncryption();
        String text = aff_text.getText();
        String key1 = aff_k1.getText();
        String key2 = aff_k2.getText();
        try {
            int k1 = Integer.parseInt(key1);
            int k2 = Integer.parseInt(key2);
            if (aff_enc.isSelected()) {
                String out = ce.encryptAffine(text, k1, k2);
                aff_out.setText(out);
            }
            else if (aff_dec.isSelected()) {
                String out = ce.decryptAffine(text, k1, k2);
                aff_out.setText(out);
            }
            aff_error.setText("No Errors :)");
            aff_error.setForeground(new Color(0, 255, 64));
        }
        catch (java.lang.NullPointerException ex) {
            aff_error.setText("Text must contain alphapet only (Not NUMBERS)");
        }
        catch (java.lang.NumberFormatException ex) {
            aff_error.setText("Key is not entered correctly");
        }
        catch (Exception ex) {
            aff_error.setText(ex.getMessage());
        }
    }//GEN-LAST:event_aff_submitActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Component[] c = multiplication.getComponents();
        for (Component c1 : c) {
            boolean a = c1.getClass().equals(addi_text.getClass());
            boolean b = c1.getClass().equals(aes_text.getClass());
            if (a || b) {
                JTextField b1 = (JTextField) c1;
                b1.setText("");
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void multi_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multi_submitActionPerformed
        multi_out.setText("");
        multi_error.setForeground(Color.red);
        ClassicEncryption ce = new ClassicEncryption();
        String text = multi_text.getText();
        String key = multi_key.getText();
        try {
            int k = Integer.parseInt(key);
            if (multi_enc.isSelected()) {
                String out = ce.encryptMultiplicative(text, k);
                multi_out.setText(out);
            }
            else if (multi_dec.isSelected()) {
                String out = ce.decryptMultiplicative(text, k);
                multi_out.setText(out);
            }
            multi_error.setForeground(new Color(0, 255, 64));
            multi_error.setText("No Errors :)");
        }
        catch (java.lang.NullPointerException ex) {
            multi_error.setText("Text must contain alphapet only (Not NUMBERS)");
        }
        catch (java.lang.NumberFormatException ex) {
            multi_error.setText("Key is not entered correctly");
        }
        catch (Exception ex) {
            multi_error.setText(ex.getMessage());
        }
    }//GEN-LAST:event_multi_submitActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Component[] c = additive.getComponents();
        for (Component c1 : c) {
            boolean a = c1.getClass().equals(addi_text.getClass());
            boolean b = c1.getClass().equals(aes_text.getClass());
            if (a || b) {
                JTextField b1 = (JTextField) c1;
                b1.setText("");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void addi_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addi_submitActionPerformed
        addi_out.setText("");
        addi_error.setForeground(Color.red);
        ClassicEncryption ce = new ClassicEncryption();
        String text = addi_text.getText();
        String key = addi_key.getText();
        try {
            int k = Integer.parseInt(key);
            if (addi_enc.isSelected()) {
                String out = ce.encryptAdditive(text, k);
                addi_out.setText(out);
            }
            else if (addi_dec.isSelected()) {
                String out = ce.decryptAdditive(text, k);
                addi_out.setText(out);
            }
            addi_error.setForeground(new Color(0, 255, 64));
            addi_error.setText("No Errors :)");
        }
        catch (java.lang.NullPointerException ex) {
            addi_error.setText("Text must contain alphapet only (Not NUMBERS)");
        }
        catch (java.lang.NumberFormatException ex) {
            addi_error.setText("Key is not entered correctly");
        }
    }//GEN-LAST:event_addi_submitActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        Component[] c = aespanel.getComponents();
        for (Component c1 : c) {
            boolean a = c1.getClass().equals(addi_text.getClass());
            if (a) {
                JTextComponent a1 = (JTextComponent) c1;
                a1.setText(null);
            }
        }
        aes_text.setText(null);
        aes_out.setText(null);
        aes_key_count.setText(aes_key.getText().length() + " Characters");
        aes_iv_count.setText(aes_iv.getText().length() + " Characters");
    }//GEN-LAST:event_jButton10ActionPerformed

    private void aes_ivKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aes_ivKeyReleased
        aes_iv_count.setText(aes_iv.getText().length() + " Characters");
    }//GEN-LAST:event_aes_ivKeyReleased

    private void aes_keyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aes_keyKeyReleased
        aes_key_count.setText(aes_key.getText().length() + " Characters");
    }//GEN-LAST:event_aes_keyKeyReleased

    private void telegramMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_telegramMouseClicked
        try {
            Desktop.getDesktop().browse(new URI("https://t.me/adelazeez"));
        }
        catch (IOException | URISyntaxException e1) {
        }
    }//GEN-LAST:event_telegramMouseClicked

    private void aes_cipher(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aes_cipher
        aes_error.setText(null);
        aes_out.setText(null);
        aes_error.setForeground(Color.red);
        String text = aes_text.getText();
        String key = aes_key.getText();
        String iv = aes_iv.getText();
        if (iv.equals("")) {
            if (aes_iv_hex.isSelected()) {
                iv = "00000000000000000000000000000000";
            }
            else {
                iv = "0000000000000000";
            }
        }

        if (aes_text_ascii.isSelected()) {
            text = asciiToHex(text);
        }
        else {
            text = text.replaceAll(" ", "");
        }

        if (aes_key_ascii.isSelected()) {
            key = asciiToHex(key);
        }
        else {
            key = key.replaceAll(" ", "");
        }

        if (aes_iv_ascii.isSelected()) {
            iv = asciiToHex(iv);
        }
        else {
            iv = iv.replaceAll(" ", "");
        }

        try {
            AES128 aes = new AES128(key, iv);
            if (aes_block_enc.isSelected()) {
                String out = aes.cipher(text, AES128.BLOCK_ENCRYPT);
                if (aes_out_ascii.isSelected()) {
                    out = hexToAscii(out);
                }
                aes_out.setText(out);
            }
            else if (aes_block_dec.isSelected()) {
                String out = aes.cipher(text, AES128.BLOCK_DECRYPT);
                if (aes_out_ascii.isSelected()) {
                    out = hexToAscii(out);
                }
                aes_out.setText(out);
            }
            else if (aes_cbc_enc.isSelected()) {
                text = text.replaceAll(" ", "");
                String cipheredBlocks = aes.cipher(text, AES128.PKCS7_CBC_ENCRYPT);

                if (aes_out_ascii.isSelected()) {
                    cipheredBlocks = cipheredBlocks.replaceAll(" ", "");
                    cipheredBlocks = hexToAscii(cipheredBlocks);
                }
                aes_out.setText(cipheredBlocks);
            }
            else if (aes_cbc_dec.isSelected()) {
                text = text.replaceAll(" ", "");
                String decipheredBlocks = aes.cipher(text, AES128.PKCS7_CBC_DECRYPT);
                if (aes_out_ascii.isSelected()) {
                    decipheredBlocks = decipheredBlocks.replaceAll(" ", "");
                    decipheredBlocks = hexToAscii(decipheredBlocks);
                }
                aes_out.setText(decipheredBlocks);

            }
            aes_error.setForeground(new Color(0, 255, 64));
            aes_error.setText("No Errors :)");
        }
        catch (java.lang.NumberFormatException ex) {
            aes_error.setText("Key and Text must be in hexadecimal format");
        }
        catch (Exception ex) {
            aes_error.setText(ex.getMessage());
        }
    }//GEN-LAST:event_aes_cipher

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        aesfile_error.setText("");
        aesfile_out.setText("");
        aesfile_error.setForeground(Color.red);
        try {
            String text = aesfile_block_text.getText().replaceAll(" ", "");
            String key = aesfile_key_text.getText().replace(" ", "");
            AES128 aes = new AES128(key);
            String res = aes.cipher(text, AES128.BLOCK_ENCRYPT);
            aesfile_out.setText(res);
            aesfile_error.setForeground(new Color(0, 255, 64));
            if (aesfile_save.isSelected()) {
                boolean saved = aes.SaveToTextFile();
                if (saved) {
                    aesfile_error.setText("No Errors in Encryption And File Saved Successfully :)");
                }
                else {
                    aesfile_error.setText("No Errors in Encryption And File NOT Saved due to permission error :(");
                }
            }
            else {
                aesfile_error.setText("No Errors in Encryption :)");
            }
        }
        catch (Exception ex) {
            aesfile_error.setText(ex.getMessage());
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void aesfile_block_textKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aesfile_block_textKeyReleased
        aesfile_block_len.setText(aesfile_block_text.getText().length() + " Characters");
    }//GEN-LAST:event_aesfile_block_textKeyReleased

    private void aesfile_key_textKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aesfile_key_textKeyReleased
        aesfile_key_len.setText(aesfile_key_text.getText().length() + " Characters");
    }//GEN-LAST:event_aesfile_key_textKeyReleased

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        Component[] c = aes_w_output.getComponents();
        for (Component c1 : c) {
            boolean a = c1.getClass().equals(addi_text.getClass());
            if (a) {
                JTextComponent a1 = (JTextComponent) c1;
                a1.setText(null);
            }
        }
        aesfile_block_len.setText(aes_key.getText().length() + " Characters");
        aesfile_key_len.setText(aes_iv.getText().length() + " Characters");
    }//GEN-LAST:event_jButton13ActionPerformed

    private void adf_k2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_adf_k2KeyReleased
        StringBuilder sb = new StringBuilder();
        if (adf_k2.getText().length() > 0) {
            String k2 = adf_k2.getText();
            int n = adf_k2.getText().length();
            int[] res = Adfgvx.adfgvxKey2AsIntArray(k2);
            for (int i = 0; i < n; i++) {
                if (i < n - 1) {
                    sb.append(res[i] + "-");
                }
                else {
                    sb.append(res[i] + "");
                }
            }
        }
        adf_k2_arr.setText(sb.toString());
    }//GEN-LAST:event_adf_k2KeyReleased

    public static void main(String args[]) throws Exception {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
//            javax.swing.UIManager.setLookAndFeel( new com.sun.java.swing.plaf.windows.WindowsLookAndFeel() );
//            javax.swing.UIManager.setLookAndFeel( new com.formdev.flatlaf.FlatIntelliJLaf());
        }
        catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane InfoSec;
    private javax.swing.JRadioButton addi_dec;
    private javax.swing.JRadioButton addi_enc;
    private javax.swing.JTextField addi_error;
    private javax.swing.JTextField addi_key;
    private javax.swing.JTextField addi_out;
    private javax.swing.JButton addi_submit;
    private javax.swing.JTextField addi_text;
    private javax.swing.JPanel additive;
    private javax.swing.JRadioButton adf_dec;
    private javax.swing.JTextField adf_error;
    private javax.swing.JTextField adf_k1;
    private javax.swing.JTextField adf_k2;
    private javax.swing.JLabel adf_k2_arr;
    private javax.swing.JRadioButton adf_no_pad;
    private javax.swing.JTextField adf_out;
    private javax.swing.JButton adf_submit;
    private javax.swing.JTextField adf_text;
    private javax.swing.JRadioButton adf_w_pad;
    private javax.swing.JPanel adfgvx;
    private javax.swing.JTextArea adfgvx_mat;
    private javax.swing.JRadioButton aes_block_dec;
    private javax.swing.JRadioButton aes_block_enc;
    private javax.swing.JRadioButton aes_cbc_dec;
    private javax.swing.JRadioButton aes_cbc_enc;
    private javax.swing.JTextField aes_error;
    private javax.swing.JTextField aes_iv;
    private javax.swing.JRadioButton aes_iv_ascii;
    private javax.swing.JLabel aes_iv_count;
    private javax.swing.JRadioButton aes_iv_hex;
    private javax.swing.JTextField aes_key;
    private javax.swing.JRadioButton aes_key_ascii;
    private javax.swing.JLabel aes_key_count;
    private javax.swing.JRadioButton aes_key_hex;
    private javax.swing.JRadioButton aes_keysched;
    private javax.swing.JTextArea aes_out;
    private javax.swing.JRadioButton aes_out_ascii;
    private javax.swing.JRadioButton aes_out_hex;
    private javax.swing.JButton aes_submit;
    private javax.swing.JTextArea aes_text;
    private javax.swing.JRadioButton aes_text_ascii;
    private javax.swing.JRadioButton aes_text_hex;
    private javax.swing.JPanel aes_w_output;
    private javax.swing.JLabel aesfile_block_len;
    private javax.swing.JTextField aesfile_block_text;
    private javax.swing.JTextField aesfile_error;
    private javax.swing.JLabel aesfile_key_len;
    private javax.swing.JTextField aesfile_key_text;
    private javax.swing.JTextField aesfile_out;
    private javax.swing.JCheckBox aesfile_save;
    private javax.swing.JPanel aespanel;
    private javax.swing.JRadioButton aff_dec;
    private javax.swing.JRadioButton aff_enc;
    private javax.swing.JTextField aff_error;
    private javax.swing.JTextField aff_k1;
    private javax.swing.JTextField aff_k2;
    private javax.swing.JTextField aff_out;
    private javax.swing.JButton aff_submit;
    private javax.swing.JTextField aff_text;
    private javax.swing.JPanel affine;
    private javax.swing.JRadioButton auto_dec;
    private javax.swing.JRadioButton auto_enc;
    private javax.swing.JTextField auto_error;
    private javax.swing.JTextField auto_key;
    private javax.swing.JComboBox<String> auto_key_mode;
    private javax.swing.JTextField auto_out;
    private javax.swing.JButton auto_submit;
    private javax.swing.JTextField auto_text;
    private javax.swing.JPanel autokey;
    private javax.swing.JTextField autokey_num_key;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup10;
    private javax.swing.ButtonGroup buttonGroup12;
    private javax.swing.ButtonGroup buttonGroup13;
    private javax.swing.ButtonGroup buttonGroup14;
    private javax.swing.ButtonGroup buttonGroup15;
    private javax.swing.ButtonGroup buttonGroup16;
    private javax.swing.ButtonGroup buttonGroup17;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.ButtonGroup buttonGroup8;
    private javax.swing.ButtonGroup buttonGroup9;
    private javax.swing.JPanel contact_info;
    private javax.swing.JLabel des_ch_count;
    private javax.swing.JRadioButton des_dec;
    private javax.swing.JRadioButton des_enc;
    private javax.swing.JTextField des_error;
    private javax.swing.JTextField des_key;
    private javax.swing.JLabel des_key_count;
    private javax.swing.JRadioButton des_keysched;
    private javax.swing.JTextField des_out;
    private javax.swing.JCheckBox des_savetofile;
    private javax.swing.JButton des_submit;
    private javax.swing.JTextField des_text;
    private javax.swing.JPanel despanel;
    private javax.swing.JPanel examplePanel;
    private javax.swing.JTextArea exampleTextArea;
    private javax.swing.JLabel fb;
    private javax.swing.JRadioButton hill_book;
    private javax.swing.JPanel hill_cipher;
    private javax.swing.JButton hill_clear;
    private javax.swing.JRadioButton hill_dec;
    private javax.swing.JRadioButton hill_enc;
    private javax.swing.JTextField hill_error;
    private javax.swing.JTable hill_mat;
    private javax.swing.JTextField hill_mat_size;
    private javax.swing.JTextArea hill_out;
    private javax.swing.JRadioButton hill_std;
    private javax.swing.JButton hill_submit;
    private javax.swing.JTextArea hill_text;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel key_sched_ch_num;
    private javax.swing.JTextField key_sched_error;
    private javax.swing.JButton key_sched_submit;
    private javax.swing.JTextField key_sched_text;
    private javax.swing.JPanel keysched;
    private javax.swing.JRadioButton multi_dec;
    private javax.swing.JRadioButton multi_enc;
    private javax.swing.JTextField multi_error;
    private javax.swing.JTextField multi_key;
    private javax.swing.JTextField multi_out;
    private javax.swing.JButton multi_submit;
    private javax.swing.JTextField multi_text;
    private javax.swing.JPanel multiplication;
    private javax.swing.JLabel my_img;
    private javax.swing.JPanel playfair;
    private javax.swing.JTextField playfair_a_pad;
    private javax.swing.JRadioButton playfair_dec;
    private javax.swing.JRadioButton playfair_enc;
    private javax.swing.JTextField playfair_error;
    private javax.swing.JTextField playfair_key;
    private javax.swing.JTextArea playfair_mat;
    private javax.swing.JTextField playfair_out;
    private javax.swing.JTextField playfair_text;
    private javax.swing.JLabel telegram;
    private javax.swing.JRadioButton vig_dec;
    private javax.swing.JRadioButton vig_enc;
    private javax.swing.JTextField vig_error;
    private javax.swing.JTextField vig_key;
    private javax.swing.JComboBox<String> vig_key_mode;
    private javax.swing.JTextField vig_num_key;
    private javax.swing.JTextField vig_out;
    private javax.swing.JButton vig_submit;
    private javax.swing.JTextField vig_text;
    private javax.swing.JPanel vigenere;
    // End of variables declaration//GEN-END:variables
}
