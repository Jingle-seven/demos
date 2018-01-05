/*
 * View.java
 *
 * Created on __DATE__, __TIME__
 */

package xz.day_9_21;

import java.util.*;

/**
 *
 * @author  __USER__
 */
public class View extends javax.swing.JFrame {
	//	tb0.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {},
	//			new String[] { "id", "name", "sex"}));
	Test test = new Test();

	/** Creates new form View */
	public View() {

		initComponents();
		tb0.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {},
				new String[] { "id", "name", "sex" }));
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		tb0 = new javax.swing.JTable();
		tf0 = new javax.swing.JTextField();
		tf1 = new javax.swing.JTextField();
		tf2 = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		bt0 = new javax.swing.JButton();
		bt1 = new javax.swing.JButton();
		bt2 = new javax.swing.JButton();
		bt3 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("users viewer");

		tb0.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null } },
				new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
		tb0.setToolTipText("id\tname\tsex");
		jScrollPane1.setViewportView(tb0);

		jLabel1.setText("id");

		jLabel2.setText("name");

		jLabel3.setText("sex");

		bt0.setText("Query");
		bt0.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				bt0ActionPerformed(evt);
			}
		});

		bt1.setText("Insert");
		bt1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				bt1ActionPerformed(evt);
			}
		});

		bt2.setText("Update");
		bt2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				bt2ActionPerformed(evt);
			}
		});

		bt3.setText("Delete");
		bt3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				bt3ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane1,
						javax.swing.GroupLayout.DEFAULT_SIZE, 400,
						Short.MAX_VALUE)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING,
												false)
												.addGroup(
														javax.swing.GroupLayout.Alignment.LEADING,
														layout.createSequentialGroup()
																.addComponent(
																		jLabel1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		18,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		tf0))
												.addComponent(
														bt0,
														javax.swing.GroupLayout.Alignment.LEADING))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										64, Short.MAX_VALUE)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addComponent(
																		bt1)
																.addGap(18, 18,
																		18)
																.addComponent(
																		bt2)
																.addGap(18, 18,
																		18)
																.addComponent(
																		bt3))
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addComponent(
																		jLabel2)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		tf1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		94,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(18, 18,
																		18)
																.addComponent(
																		jLabel3)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		tf2,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		65,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addComponent(jScrollPane1,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										202, Short.MAX_VALUE)
								.addGap(18, 18, 18)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(
														tf2,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel3)
												.addComponent(
														tf0,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel1)
												.addComponent(
														tf1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel2))
								.addGap(18, 18, 18)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(bt0)
												.addComponent(bt3)
												.addComponent(bt2)
												.addComponent(bt1))
								.addContainerGap()));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void bt3ActionPerformed(java.awt.event.ActionEvent evt) {
		test.delete(tf0.getText());
		updateTable(test.query(""));
	}

	private void bt2ActionPerformed(java.awt.event.ActionEvent evt) {
		test.update(tf0.getText(), tf1.getText(), tf2.getText());
		updateTable(test.query(""));
	}

	private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {
		test.insert(tf0.getText(), tf1.getText(), tf2.getText());
		updateTable(test.query(""));
	}

	private void bt0ActionPerformed(java.awt.event.ActionEvent evt) {
		updateTable(test.query(tf0.getText()));
	}

	/**
	 * @param args the command line arguments
	 */

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton bt0;
	private javax.swing.JButton bt1;
	private javax.swing.JButton bt2;
	private javax.swing.JButton bt3;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable tb0;
	private javax.swing.JTextField tf0;
	private javax.swing.JTextField tf1;
	private javax.swing.JTextField tf2;

	// End of variables declaration//GEN-END:variables

	public static void main(String args[]) {
		View v = new View();
		v.setLocation(200, 200);
		v.setVisible(true);
	}

	public void updateTable(Vector v) {
		Vector head = new Vector();
		head.add("id");
		head.add("name");
		head.add("sex");

		tb0.setModel(new javax.swing.table.DefaultTableModel(v, head));
	}

}