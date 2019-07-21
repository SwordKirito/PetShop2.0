package com.ccx.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.ccx.dao.PetTypeDao;
import com.ccx.model.PetType;
import com.ccx.util.DbUtil;
import com.ccx.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;

public class PetTypeAddInterFrm extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField petTypeTxt;
	
	private DbUtil dbUtil=new DbUtil();
	private PetTypeDao petTypeDao=new PetTypeDao();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PetTypeAddInterFrm frame = new PetTypeAddInterFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PetTypeAddInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("宠物类别添加");
		setBounds(100, 100, 318, 149);
		
		JLabel label = new JLabel("宠物类别");
		
		petTypeTxt = new JTextField();
		petTypeTxt.setColumns(10);
		
		JButton button = new JButton("添加");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				petTypeAddActionPerformed(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(49)
							.addComponent(label)
							.addGap(53)
							.addComponent(petTypeTxt, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(120)
							.addComponent(button)))
					.addContainerGap(54, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(petTypeTxt, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(button)
					.addContainerGap(27, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

	protected void petTypeAddActionPerformed(ActionEvent evt) {
		String petTypeName=this.petTypeTxt.getText();
		if(StringUtil.isEmpty(petTypeName)){
			JOptionPane.showMessageDialog(null, "宠物类别不能为空！");
			return;
		}
		PetType petType=new PetType(petTypeName);
		Connection con=null;
		try{
			con=dbUtil.getCon();
			int n=petTypeDao.add(con, petType);
			if(n==1){
				JOptionPane.showMessageDialog(null, "添加成功");
				resetValue();
			}else{
				JOptionPane.showMessageDialog(null, "添加失败");
			}
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "添加失败");
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void resetValue() {
		// TODO Auto-generated method stub
		this.petTypeTxt.setText("");
		
	}

}
