/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import controller.IOFile;
import model.Note;
import java.awt.Color;
import controller.BlankException;
import controller.TimeException;
import java.awt.Button;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import javax.swing.table.DefaultTableModel;
public class AllNote extends javax.swing.JPanel {
    
    private DefaultTableModel tm;
    List<Note> notes;
    String fAllNote;
    private boolean add, edit, save;
    private Calendar cal;
    String content, strDeadline;
    int year, month, day;
    String YearString, MonthString, DayString;
    Date deadline, tmpDate;
    Note note;
    
    public AllNote() throws IOException {
        
        initComponents();
        setSize(550, 550);
        String [] cols = {"Date", "To Do", "Deadline", "Status"};
        tm = new DefaultTableModel(cols, 0);
        AllNoteTable.setModel(tm);
        fAllNote = "src/controller/Noting.DAT";
        add = false;
        edit = false;
        save = false;
//        btnState(Boolean.TRUE);
        loadData();  
        YearCbb.removeAllItems();
        MonthCbb.removeAllItems();
        DayCbb.removeAllItems();
        for(int i = 1; i <= 31; i++) {
            DayCbb.addItem(String.valueOf(i));
        }
        for(int i = 2022; i <= 2100; i++) {
            YearCbb.addItem(String.valueOf(i));
        }
        for(int i = 1; i <= 12; i++) {
            MonthCbb.addItem(String.valueOf(i));
        }
        Filter.removeAllItems();
        Filter.addItem("All");
        Filter.addItem("Ongoing");
        Filter.addItem("Finished");
        Filter.addItem("Overdue");
        Sort.removeAllItems();
        Sort.addItem("Date created");
        Sort.addItem("Deadline");
        loadData();
        AllNoteTable.setShowGrid(false);
        Save.setEnabled(false);
//        setBackground(Color.BLUE);
//        Addbtn.setBorder(new RoundedBorder(60));

        System.out.println(jLabel1.getSize().height + " " + jLabel1.getSize().width);
    }

    
//    private void btnState(boolean state) {
//        Addbtn.setEnabled(state);
//        Updatebtn.setEnabled(!state);
//        Cancelbtn.setEnabled(!state);
//    }
    
    
    public void loadData() {
        File f = new File(fAllNote);
        if(f.exists()) {
            notes = IOFile.doc(fAllNote);
            tm.setRowCount(0);
            if(notes.size() > 0)
                for(Note i : notes) {
                    tm.addRow(i.toObject());
                    if(i.getDealine().before(Calendar.getInstance().getTime()) && i.getStatus() == 0) {
                        i.setStatus(2);
                    }
                }
        }
        else {
            notes = new ArrayList<>();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        AllNoteTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textField1 = new java.awt.TextField();
        Addbtn = new javax.swing.JButton();
        Editbtn = new javax.swing.JButton();
        Delbtn = new javax.swing.JButton();
        YearCbb = new javax.swing.JComboBox<>();
        MonthCbb = new javax.swing.JComboBox<>();
        DayCbb = new javax.swing.JComboBox<>();
        Save = new javax.swing.JButton();
        Filter = new javax.swing.JComboBox<>();
        Sort = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(150, 214, 255));
        setForeground(new java.awt.Color(150, 214, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N

        AllNoteTable.getTableHeader().setDefaultRenderer(new HeaderColor());
        AllNoteTable.setBackground(new java.awt.Color(255, 255, 255));
        AllNoteTable.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        AllNoteTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        AllNoteTable.setOpaque(false);
        AllNoteTable.setRowHeight(25);
        //AllNoteTable.getTableHeader().setBackground(new Color(0, 99, 236));
        //AllNoteTable.getTableHeader ().setForeground (new Color (0, 99, 236));

        AllNoteTable.getTableHeader().setOpaque(false);
        AllNoteTable.getTableHeader().setFont (new Font ("Courier new", Font.BOLD, 12));
        AllNoteTable.setSelectionBackground(new java.awt.Color(50, 102, 186));
        AllNoteTable.getTableHeader().setResizingAllowed(false);
        AllNoteTable.getTableHeader().setReorderingAllowed(false);
        //AllNoteTable.setFont (new Font ("Sergoe UI", Font.BOLD, 12));
        AllNoteTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AllNoteTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(AllNoteTable);

        jLabel1.setBackground(new Color(150, 214, 255));
        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        jLabel1.setText("To Do");

        jLabel2.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        jLabel2.setText("Deadline (mm/dd/yyyy)");
        jLabel2.setToolTipText("");
        jLabel2.setFont (jLabel2.getFont().deriveFont(12.f));
        jLabel2.setBackground(new Color(255,255,255));

        textField1.setFont(textField1.getFont());
        textField1.setForeground(new java.awt.Color(51, 51, 51));
        textField1.setText("textField1");
        textField1.setText("");
        textField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textField1MouseClicked(evt);
            }
        });
        textField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField1ActionPerformed(evt);
            }
        });

        //Addbtn.setIcon();
        Addbtn.setBackground(new java.awt.Color(50, 102, 186));
        Addbtn.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        Addbtn.setText("Add");
        //Addbtn.setBackground(new Color(51, 153, 255));
        //Addbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/images.Addbtn.png")));
        Addbtn.setOpaque(false);
        Addbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddbtnMouseClicked(evt);
            }
        });
        Addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddbtnActionPerformed(evt);
            }
        });

        Editbtn.setBackground(new java.awt.Color(50, 102, 186));
        Editbtn.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        Editbtn.setText("Edit");
        //Editbtn.setBackground(new Color(32, 136, 203));
        Editbtn.setOpaque(false);
        Editbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditbtnMouseClicked(evt);
            }
        });
        Editbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditbtnActionPerformed(evt);
            }
        });

        Delbtn.setBackground(new java.awt.Color(50, 102, 186));
        Delbtn.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        Delbtn.setText("Delete");
        //Delbtn.setBackground(new Color(51, 153, 255));
        Delbtn.setOpaque(false);
        Delbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelbtnActionPerformed(evt);
            }
        });

        YearCbb.setBackground(new java.awt.Color(255, 255, 255));
        YearCbb.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        YearCbb.setForeground(new java.awt.Color(255, 255, 255));
        YearCbb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        MonthCbb.setBackground(new java.awt.Color(255, 255, 255));
        MonthCbb.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        MonthCbb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        DayCbb.setBackground(new java.awt.Color(255, 255, 255));
        DayCbb.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        DayCbb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        Save.setBackground(new java.awt.Color(50, 102, 186));
        Save.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        Save.setText("Save");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });

        Filter.setBackground(new java.awt.Color(255, 255, 255));
        Filter.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        Filter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Filter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilterActionPerformed(evt);
            }
        });

        Sort.setBackground(new java.awt.Color(255, 255, 255));
        Sort.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        Sort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Sort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SortActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        jLabel4.setText("Sort");

        jLabel5.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        jLabel5.setText("Filter");

        jCheckBox1.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox1.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        jCheckBox1.setText("Status");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MonthCbb, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(DayCbb, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(YearCbb, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(178, 178, 178))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Addbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Delbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Editbtn)
                                    .addComponent(Save))
                                .addGap(187, 187, 187)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(59, 59, 59)
                                        .addComponent(jCheckBox1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(Filter, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(Sort, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(13, 13, 13)))
                        .addGap(17, 17, 17))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(MonthCbb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DayCbb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1)
                    .addComponent(YearCbb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Filter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Addbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                        .addComponent(Editbtn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Save)
                    .addComponent(Sort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(Delbtn))
                .addGap(129, 129, 129))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void textField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField1ActionPerformed
        textField1.setText("");
    }//GEN-LAST:event_textField1ActionPerformed

    private void textField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textField1MouseClicked

    }//GEN-LAST:event_textField1MouseClicked

    private void AddbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddbtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_AddbtnMouseClicked

    private void EditbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditbtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_EditbtnMouseClicked

    public class HeaderColor extends DefaultTableCellRenderer {

        public HeaderColor() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
            super.getTableCellRendererComponent(table, value, selected, focused, row, column);
           
           setBackground(new java.awt.Color(150, 214, 255));
//you can change the color that u want 
            return this;
        }

    }
    private void AddbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddbtnActionPerformed
//        btnState(false);
        
        if(notes == null) {
            notes = new ArrayList<>();
        }
        textField1.requestFocus();
        
        try {
            content = textField1.getText();
            year = Integer.parseInt(YearCbb.getSelectedItem().toString());
            month = Integer.parseInt(MonthCbb.getSelectedItem().toString());
            day = Integer.parseInt(DayCbb.getSelectedItem().toString());
//            System.out.println(year);

            if(content.isEmpty()) throw new BlankException();
            if(month == 4 || month == 6 || month == 9 || month == 11) {
                if(day > 30) throw new TimeException();
            }
            if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                if(month == 2 && day > 29) throw new TimeException();

            }
            else {
                if(month == 2 && day > 28) throw new TimeException();

            }

            DayString = "" + day;
            MonthString = "" + month;
            if(day < 10) DayString = "0" + DayString;
            if(month < 10) MonthString = "0" + MonthString;
            strDeadline = MonthString + "/" + DayString + "/" + year;
            deadline = new SimpleDateFormat("MM/dd/yyyy").parse(strDeadline);  

            note = new Note(content,deadline);
            note.setStrDeadline(strDeadline);
            if(deadline.before(note.getCreateDate())) throw new TimeException();
            String crD = note.getStrDate();
            tm.addRow(note.toObject());
//            tm.addColumn(new JCheckBox("yes", false));
            notes.add(note);
//                btnState(true);
            add = false;
            textField1.setText("");
            DayCbb.setSelectedIndex(0);
            MonthCbb.setSelectedIndex(0);
            YearCbb.setSelectedIndex(0);
            IOFile.viet(fAllNote, notes);
        }
        catch(BlankException e) {
            JOptionPane.showMessageDialog(this, "Enter What to do");
        }
        catch (TimeException e) {
            JOptionPane.showMessageDialog(this, "Invalid Date");
        }
        catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Invalid Date");
        }
    }//GEN-LAST:event_AddbtnActionPerformed

    private void EditbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditbtnActionPerformed
        int row = AllNoteTable.getSelectedRow();
        
        if(row < 0 || row > tm.getRowCount() - 1) {
            JOptionPane.showMessageDialog(this, "Choose a note ");
        }
        else
            Save.setEnabled(true);
    }//GEN-LAST:event_EditbtnActionPerformed

    private void AllNoteTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AllNoteTableMouseClicked
        int row = AllNoteTable.getSelectedRow();
        if(row < 0 || row > tm.getRowCount() - 1) {
            JOptionPane.showMessageDialog(this, "Choose a note");
        }
        else {
            
            textField1.setText(tm.getValueAt(row, 1).toString());
            strDeadline = tm.getValueAt(row, 2).toString();
            day = Integer.parseInt(Character.toString(strDeadline.charAt(3)) + Character.toString(strDeadline.charAt(4)) );
            month = Integer.parseInt(Character.toString(strDeadline.charAt(0)) + Character.toString(strDeadline.charAt(1)) );
            year = Integer.parseInt(Character.toString(strDeadline.charAt(6)) + Character.toString(strDeadline.charAt(7)) + Character.toString(strDeadline.charAt(8)) + Character.toString(strDeadline.charAt(9)));
            YearCbb.setSelectedIndex(year - 2022);
            DayCbb.setSelectedIndex(day - 1);
            MonthCbb.setSelectedIndex(month - 1);
            note = notes.get(AllNoteTable.convertRowIndexToModel(row));
            tmpDate = note.getCreateDate();
            int state = note.getStatus();
            boolean status = false;
            if(state == 0 || state == 2) status = false;
            else status = true;
            jCheckBox1.setSelected(status);
        }
        if(AllNoteTable.isEditing()) {
            JOptionPane.showMessageDialog(this, "Edit is not allowed");
        }
        
    }//GEN-LAST:event_AllNoteTableMouseClicked

    private void DelbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelbtnActionPerformed
        int row = AllNoteTable.getSelectedRow();
        
        if(row < 0 || row > AllNoteTable.getRowCount() - 1) {
            JOptionPane.showMessageDialog(this, "Choose a note");
        }
        else {
            tm.removeRow(row);
            notes.remove(row);
        }
        textField1.setText("");
        DayCbb.setSelectedIndex(0);
        MonthCbb.setSelectedIndex(0);
        YearCbb.setSelectedIndex(0);
        IOFile.viet(fAllNote, notes);
    }//GEN-LAST:event_DelbtnActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        textField1.requestFocus();

        try {
            content = textField1.getText();
            year = Integer.parseInt(YearCbb.getSelectedItem().toString());
            month = Integer.parseInt(MonthCbb.getSelectedItem().toString());
            day = Integer.parseInt(DayCbb.getSelectedItem().toString());
            System.out.println(year);

            if(content.isEmpty()) throw new BlankException();
            if(month == 4 || month == 6 || month == 9 || month == 11) {
                if(day > 30) throw new TimeException();
            }
            if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                if(month == 2 && day > 29) throw new TimeException();

            }
            else {
                if(month == 2 && day > 28) throw new TimeException();

            }
            
            DayString = "" + day;
            MonthString = "" + month;
            if(day < 10) DayString = "0" + DayString;
            if(month < 10) MonthString = "0" + MonthString;
            strDeadline = MonthString + "/" + DayString + "/" + year;
            deadline = new SimpleDateFormat("MM/dd/yyyy").parse(strDeadline);  
            
            note.setStrDeadline(strDeadline);
            
            if(deadline.before(note.getCreateDate())) throw new TimeException();
//                btnState(true);
//            add = false;
//            textField1.setText("");
            int row = AllNoteTable.getSelectedRow();
            note.SetDeadline(deadline);
            note.setContent(textField1.getText());
            tm.removeRow(row);
            notes.remove(row);
            notes.add(note);
            tm.addRow(note.toObject());
            Collections.sort(notes, new Comparator<Note>() {
                @Override
                public int compare(Note a, Note b) {
                    if(a.getCreateDate().before(b.getCreateDate())) return -1;
                    else if(a.getCreateDate().equals(b.getCreateDate())) {
                        if(a.getDealine().before(b.getDealine())) return -1;
                        else return 1;
                    }
                    else return 1;
                }
            });
            Save.setEnabled(false);
            textField1.setText("");
            DayCbb.setSelectedIndex(0);
            MonthCbb.setSelectedIndex(0);
            YearCbb.setSelectedIndex(0);
            IOFile.viet(fAllNote, notes);
        }
        catch(BlankException e) {
            JOptionPane.showMessageDialog(this, "Enter What to do");
        }
        catch (TimeException e) {
            JOptionPane.showMessageDialog(this, "Invalid Date");
        }
        catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Invalid Date");
        }
        
    }//GEN-LAST:event_SaveActionPerformed

    private void FilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FilterActionPerformed
        int row = Filter.getSelectedIndex();
        System.out.println(row);
        
        while(tm.getRowCount() > 0) {
            tm.removeRow(0);
        }
        if(row == 0) {
            for(Note i : notes) {
                tm.addRow(i.toObject());
            }
        }
        else if(row == 1) {
            
            for(Note i : notes) {
                if(i.getStatus() == 0) {
                    tm.addRow(i.toObject());
                }
            }
        }
        else if(row == 2) {
            for(Note i : notes) {
                if(i.getStatus() == 1) {
                    tm.addRow(i.toObject());
                }
            }
        }
        else  {
            for(Note i : notes) {
                if(i.getStatus() == 2) {
                    tm.addRow(i.toObject());
                }
            }
        }
    }//GEN-LAST:event_FilterActionPerformed

    private void SortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SortActionPerformed
//        while(tm.getRowCount() > 0) {
//            tm.removeRow(0);
//        }
        int row = Sort.getSelectedIndex();
        System.out.println(row);
        if(row == 0) {
            Collections.sort(notes, new Comparator<Note>() {
                @Override
                public int compare(Note a, Note b) {
                    if(a.getCreateDate().before(b.getCreateDate())) return -1;
                    else if(a.getCreateDate().equals(b.getCreateDate())) {
                        if(a.getDealine().before(b.getDealine())) return -1;
                        else return 1;
                    }
                    else return 1;
                }
            });
        }
        if(row == 1) {
            Collections.sort(notes, new Comparator<Note>() {
                @Override
                public int compare(Note a, Note b) {
                    if(a.getDealine().before(b.getDealine())) return -1;
                    else if(a.getDealine().after(b.getDealine())) return 1;
                    else  {
                        if(a.getCreateDate().before(b.getCreateDate())) return -1;
                        else return 1;
                    }
                }
            });
        }
        IOFile.viet(fAllNote, notes);
        loadData();
    }//GEN-LAST:event_SortActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        
        
        int row = AllNoteTable.getSelectedRow();
        
        if(row < 0 || row > tm.getRowCount() - 1) {
            jCheckBox1.setSelected(false);
            JOptionPane.showMessageDialog(this, "Choose a note ");
        }
        else {
            note = notes.get(AllNoteTable.convertRowIndexToModel(row));
            int state = note.getStatus();
            if(note.getStatus() == 0 || note.getStatus() == 2) {
                note.setStatus(1);
            }
            else {
                if(note.getDealine().before(Calendar.getInstance().getTime())) {
                    note.setStatus(2);
                }
                else {
                    note.setStatus(0);
                }
            }
            tm.removeRow(row);
            notes.remove(row);
            notes.add(note);
            tm.addRow(note.toObject());
            jCheckBox1.setSelected(false);
            IOFile.viet(fAllNote, notes);
        }
        SortActionPerformed(evt);
    }//GEN-LAST:event_jCheckBox1ActionPerformed
                         
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Addbtn;
    private javax.swing.JTable AllNoteTable;
    private javax.swing.JComboBox<String> DayCbb;
    private javax.swing.JButton Delbtn;
    private javax.swing.JButton Editbtn;
    private javax.swing.JComboBox<String> Filter;
    private javax.swing.JComboBox<String> MonthCbb;
    private javax.swing.JButton Save;
    private javax.swing.JComboBox<String> Sort;
    private javax.swing.JComboBox<String> YearCbb;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.TextField textField1;
    // End of variables declaration//GEN-END:variables
}
