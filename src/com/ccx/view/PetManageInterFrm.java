package com.ccx.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.ccx.dao.PetDao;
import com.ccx.dao.PetTypeDao;
import com.ccx.model.Pet;
import com.ccx.model.PetType;
import com.ccx.util.DbUtil;
import com.ccx.util.StringUtil;


public class PetManageInterFrm extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable petTable;
	private JTextField s_petNameTxt;
	private JTextField s_petColorTxt;
	private JComboBox<PetType> s_petTypeJcb;
	private JComboBox<PetType> petTypeJcb ;
	
	private DbUtil dbUtil=new DbUtil();
	private PetTypeDao petTypeDao=new PetTypeDao();
	private PetDao petDao=new PetDao();
	private JTextField idTxt;
	private JTextField petNameTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField petColorTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PetManageInterFrm frame = new PetManageInterFrm();
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
	public PetManageInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("宠物信息维护");
		setBounds(100, 100, 382, 525);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 344, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(scrollPane, 0, 0, Short.MAX_VALUE)
								.addGap(11))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(panel_1, 0, 0, Short.MAX_VALUE)
								.addGap(11)))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("\u7F16\u53F7\uFF1A");
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("宠物名称：");
		
		petNameTxt = new JTextField();
		petNameTxt.setColumns(10);
		
		JLabel label_4 = new JLabel("颜色：");
		
		petColorTxt = new JTextField();
		petColorTxt.setColumns(10);
		
		JLabel label_5 = new JLabel("宠物类别：");
		
		petTypeJcb = new JComboBox<PetType>();
		
		JButton button_1 = new JButton("\u4FEE\u6539");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				petUpdateActionPerformed(evt);
			}
		});
		button_1.setIcon(new ImageIcon("E:\\程序试做\\java课\\PetShop2.0\\image\\modify.png"));
		
		JButton button_2 = new JButton("\u5220\u9664");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				petDeleteActionPerformed(evt);
			}
		});
		button_2.setIcon(new ImageIcon("E:\\程序试做\\java课\\PetShop2.0\\image\\delete.png"));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(19)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_4)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(petColorTxt))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(49)
							.addComponent(button_1)))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(26)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_5)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(petTypeJcb, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(petNameTxt, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(61)
							.addComponent(button_2)))
					.addContainerGap(11, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(petNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(petColorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5)
						.addComponent(petTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button_2))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel label = new JLabel("宠物名称：");
		
		s_petNameTxt = new JTextField();
		s_petNameTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("宠物颜色：");
		
		s_petColorTxt = new JTextField();
		s_petColorTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("宠物类别：");
		
		s_petTypeJcb = new JComboBox<PetType>();
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				petSearchActionPerformed(e);
			}
		});
		button.setIcon(new ImageIcon("E:\\程序试做\\java课\\PetShop2.0\\image\\search.png"));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(19)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(s_petTypeJcb, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(s_petNameTxt, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(s_petColorTxt, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(121)
							.addComponent(button)))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(s_petNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(s_petColorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(s_petTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(17)
					.addComponent(button)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		petTable = new JTable();
		petTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent met) {
				petTableMousePressed(met);
			}
		});
		scrollPane.setViewportView(petTable);
		petTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u5BA0\u7269\u540D\u79F0", "\u5BA0\u7269\u989C\u8272", "\u5BA0\u7269\u79CD\u7C7B"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		getContentPane().setLayout(groupLayout);

				
		this.fillPetType("search");
		this.fillPetType("modify");
		this.fillTable(new Pet());
	}
	

	private void petDeleteActionPerformed(ActionEvent evt) {
		String id=idTxt.getText();
		if(StringUtil.isEmpty(id)){
			JOptionPane.showMessageDialog(null, "编号不能为空！");
			return;
		}
		int n=JOptionPane.showConfirmDialog(null, "确定删除吗？");
		if(n==0){
			Connection con=null;
			try{
				con=dbUtil.getCon();
				int deleteNum=petDao.delete(con, id);
				if(deleteNum==1){
					JOptionPane.showMessageDialog(null, "删除成功！");
					this.resetValue();
					this.fillTable(new Pet());
				}else{
					JOptionPane.showMessageDialog(null, "删除失败！");
				}
			}catch(Exception e){
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "删除失败！");
			}finally{
				try {
					dbUtil.closeCon(con);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}


	private void petUpdateActionPerformed(ActionEvent evt) {
		String id=this.idTxt.getText();
		if(StringUtil.isEmpty(id)){
			JOptionPane.showMessageDialog(null, "请选择一个宠物");
			return;
		}
		
		String petName=this.petNameTxt.getText();
		String petColor=this.petColorTxt.getText();
		
		PetType petType=(PetType) petTypeJcb.getSelectedItem();
		int petTypeId=petType.getId();
		
		Pet pet=new Pet(Integer.parseInt(id),  petName,   petTypeId,  petColor);
		
		Connection con=null;
		try{
			con=dbUtil.getCon();
			int addNum=petDao.update(con, pet);
			if(addNum==1){
				JOptionPane.showMessageDialog(null, "修改成功");
				resetValue();
				this.fillTable(new Pet());
			}else{
				JOptionPane.showMessageDialog(null, "修改失败");
			}
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "修改失败");
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void resetValue(){
		this.idTxt.setText("");
		this.petNameTxt.setText("");
		this.petColorTxt.setText("");
		if(this.petTypeJcb.getItemCount()>0){
			this.petTypeJcb.setSelectedIndex(0);
		}
	}

	private void petTableMousePressed(MouseEvent met) {
		int row=this.petTable.getSelectedRow();
		this.idTxt.setText((String)petTable.getValueAt(row, 0));
		this.petNameTxt.setText((String)petTable.getValueAt(row, 1));
		this.petColorTxt.setText((String)petTable.getValueAt(row, 2));
		String petTypeName=(String)this.petTable.getValueAt(row, 3);
		
		
		int n=this.petTypeJcb.getItemCount();
		
		
		for(int i=0;i<n;i++){
			PetType item=(PetType)this.petTypeJcb.getItemAt(i);
			if(item.getPetTypeName().equals(petTypeName)){
				this.petTypeJcb.setSelectedIndex(i);
			}
		}
	}
	
	
	

	private void petSearchActionPerformed(ActionEvent evt) {
		String petName=this.s_petNameTxt.getText();
		PetType petType=(PetType) this.s_petTypeJcb.getSelectedItem();
		int petTypeId=petType.getId();
		String petColor=this.s_petColorTxt.getText();
		
		Pet pet=new Pet(petName,petTypeId,petColor);
		this.fillTable(pet);
	}

	
	
	private void fillPetType(String type){
		Connection con=null;
		PetType petType=null;
		try{
			con=dbUtil.getCon();
			ResultSet rs=petTypeDao.list(con, new PetType());
			if("search".equals(type)){
				petType=new PetType();
				petType.setPetTypeName("请选择...");
				petType.setId(-1);
				this.s_petTypeJcb.addItem(petType);
			}
			while(rs.next()){
				petType=new PetType();
				petType.setPetTypeName(rs.getString("petTypeName"));
				petType.setId(rs.getInt("id"));
				if("search".equals(type)){
					this.s_petTypeJcb.addItem(petType);
				}else if("modify".equals(type)){
					this.petTypeJcb.addItem(petType);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	private void fillTable(Pet pet){
		DefaultTableModel dtm=(DefaultTableModel) petTable.getModel();
		dtm.setRowCount(0);
		Connection con=null;
		try{
			con=dbUtil.getCon();
			ResultSet rs=petDao.list(con, pet);
			while(rs.next()){
				Vector<String> v=new Vector<String>();
				v.add(rs.getString("id"));
				v.add(rs.getString("petName"));
				v.add(rs.getString("petColor"));
				v.add(rs.getString("petTypeName"));
				dtm.addRow(v);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public ButtonGroup getButtonGroup() {
		return buttonGroup;
	}

}
