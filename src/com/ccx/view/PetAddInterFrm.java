package com.ccx.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

import com.ccx.dao.PetDao;
import com.ccx.dao.PetTypeDao;
import com.ccx.model.Pet;
import com.ccx.model.PetType;
import com.ccx.util.DbUtil;
import com.ccx.util.StringUtil;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;

public class PetAddInterFrm extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField petNameTxt;
	private JTextField petColorTxt;
	private DbUtil dbUtil = new DbUtil();
	private PetTypeDao petTypeDao = new PetTypeDao();
	private JComboBox<PetType> petTypeJcb;
	private PetDao petDao = new PetDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PetAddInterFrm frame = new PetAddInterFrm();
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
	public PetAddInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("宠物添加");
		setBounds(100, 100, 450, 216);
		
		JLabel label = new JLabel("宠物名称：");
		
		JLabel label_1 = new JLabel("宠物种类：");
		
		JLabel label_2 = new JLabel("宠物颜色：");
		
		petNameTxt = new JTextField();
		petNameTxt.setColumns(10);
		
		petColorTxt = new JTextField();
		petColorTxt.setColumns(10);
		
		petTypeJcb = new JComboBox<PetType>();
		
		JButton button = new JButton("添加");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PetAddActionPerformed(e);
				
			}
		});
		button.setIcon(new ImageIcon("E:\\程序试做\\java课\\PetShop2.0\\image\\add.png"));
		
		JButton button_1 = new JButton("重置");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				resetValue();
				
				
			}
		});
		button_1.setIcon(new ImageIcon("E:\\程序试做\\java课\\PetShop2.0\\image\\reset.png"));
		button_1.setSelectedIcon(null);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_2)
							.addGap(18)
							.addComponent(petColorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addComponent(button)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(button_1))
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addComponent(label)
								.addGap(18)
								.addComponent(petNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(23)
								.addComponent(label_1)
								.addGap(18)
								.addComponent(petTypeJcb, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(78, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(label_1)
						.addComponent(petNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(petTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(petColorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap(126, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		fillPetType();
	}
	/**
	 * 重置表单
	 */
	private void resetValue() {
		// TODO Auto-generated method stub
		this.petNameTxt.setText("");
		this.petColorTxt.setText("");
		this.petNameTxt.setText("");
		
		if(this.petTypeJcb.getItemCount()>0){
			this.petTypeJcb.setSelectedIndex(0);
		}
		
	}
	/**
	 * 初始化图书类别下拉框
	 */
	
	private void fillPetType(){
		Connection con = null;
		PetType petType = null;
		try{
			con = dbUtil.getCon();
			ResultSet rs = petTypeDao.list(con, new PetType());
		    while( rs.next() ){
		    	petType = new PetType();
		    	petType.setId(rs.getInt("id"));
		    	petType.setPetTypeName(rs.getString("petTypeName"));
		    	this.petTypeJcb.addItem(petType);
		     }
		 }catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			
		}
	}
	
	private void PetAddActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		 String petName = this.petNameTxt.getText();
		
		 if(StringUtil.isEmpty(petName)){
	        JOptionPane.showMessageDialog(null,"宠物名称不能为空");
	     }
		 
		 PetType petType =(PetType) petTypeJcb.getSelectedItem();
		 int petTypeId = petType.getId();
		 
		 String petColor = this.petColorTxt.getText();
		 
		 Pet pet = new Pet(petName,petTypeId,petColor);
		 
		 Connection con = null;
	        try{
	        	con=dbUtil.getCon();
	        	int addNum = petDao.add(con, pet);  	
	            if(addNum == 1){
	            	JOptionPane.showMessageDialog(null,"宠物添加成功");	
	                resetValue();
	            }else{
	            	JOptionPane.showMessageDialog(null,"宠物添加失败");
	            }
	        }catch(Exception e){
	        	e.printStackTrace();  
	        	JOptionPane.showMessageDialog(null,"宠物添加失败");
	        }finally{
	        	try{
	        	dbUtil.closeCon(con);
	        	}catch (Exception e) {
					// TODO: handle exception
	        		e.printStackTrace();	
				}
	        	
	        }
	    }
	
}
