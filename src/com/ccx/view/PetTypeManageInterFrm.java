package com.ccx.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.ccx.dao.PetTypeDao;
import com.ccx.model.PetType;
import com.ccx.util.DbUtil;
import com.ccx.util.StringUtil;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

public class PetTypeManageInterFrm extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField s_petTypeNameTxt;
	private JTable petTypeTable;
	private JTextField idTxt;
	private JTextField petTypeNameTxt;
	private DbUtil dbUtil=new DbUtil();
	private PetTypeDao petTypeDao = new PetTypeDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PetTypeManageInterFrm frame = new PetTypeManageInterFrm();
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
	public PetTypeManageInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("宠物类别维护");
		setBounds(100, 100, 450, 524);
		
		JLabel label = new JLabel("宠物类别名称：");
		
		s_petTypeNameTxt = new JTextField();
		s_petTypeNameTxt.setColumns(10);
		
		JButton button = new JButton("查询");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				petTypeSearchActionPerform(e);
			}
		});
		button.setIcon(new ImageIcon("E:\\程序试做\\java课\\PetShop2.0\\image\\search.png"));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(50)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 348, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 348, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(label)
								.addGap(39)
								.addComponent(s_petTypeNameTxt, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
								.addComponent(button)
								.addGap(35)))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(button)
						.addComponent(s_petTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(62, Short.MAX_VALUE))
		);
		
		JLabel label_1 = new JLabel("编号：");
		label_1.setBounds(24, 56, 53, 15);
		
		idTxt = new JTextField();
		idTxt.setBounds(82, 53, 66, 21);
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("名称：");
		label_2.setBounds(184, 56, 48, 15);
		
		petTypeNameTxt = new JTextField();
		petTypeNameTxt.setBounds(242, 53, 66, 21);
		petTypeNameTxt.setColumns(10);
		
		JButton button_1 = new JButton("修改");
		button_1.setBounds(50, 107, 109, 25);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				petTypeUpdateActionEvent(e);
				
				
			}
		});
		button_1.setIcon(new ImageIcon("E:\\程序试做\\java课\\PetShop2.0\\image\\modify.png"));
		
		JButton button_2 = new JButton("删除");
		button_2.setBounds(191, 107, 117, 25);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				petTypeDeleteActionEvent(e);
			}
		});
		button_2.setIcon(new ImageIcon("E:\\程序试做\\java课\\PetShop2.0\\image\\delete.png"));
		panel.setLayout(null);
		panel.add(label_1);
		panel.add(idTxt);
		panel.add(button_1);
		panel.add(label_2);
		panel.add(petTypeNameTxt);
		panel.add(button_2);
		
		petTypeTable = new JTable();
		petTypeTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				petTypeTableMousePressed(e);
				
			}
		});
		
	
		
		
		petTypeTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u5BA0\u7269\u7C7B\u522B\u540D\u79F0"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = -8342722547118927427L;
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(petTypeTable);
		getContentPane().setLayout(groupLayout);

		
		
		fillTable(new PetType());
	}

	protected void petTypeTableMousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int row=petTypeTable.getSelectedRow();
		idTxt.setText((String)petTypeTable.getValueAt(row, 0));
		petTypeNameTxt.setText((String)petTypeTable.getValueAt(row,1));
	}

	protected void petTypeSearchActionPerform(ActionEvent e) {
		// TODO Auto-generated method stub
		String s_petTypeName = this.s_petTypeNameTxt.getText();
		PetType petType = new PetType();
		petType.setPetTypeName(s_petTypeName);
		this.fillTable(petType);
	}

	private void fillTable(PetType petType){
		DefaultTableModel dtm=(DefaultTableModel) petTypeTable.getModel();
		dtm.setRowCount(0);//设置成0行
		Connection con=null;
		try{
			con=dbUtil.getCon();
			ResultSet rs = petTypeDao.list(con, petType);
			
			while(rs.next()){
				Vector<String> v=new Vector<String>();
				v.add(rs.getString("id"));
				v.add(rs.getString("petTypeName"));
				dtm.addRow(v);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
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
	
	
	/**
	 * 宠物类别修改事件处理
	 * @param e
	 */
	private void petTypeUpdateActionEvent(ActionEvent e) {
		// TODO Auto-generated method stub
		String id=idTxt.getText();
		String petTypeName=petTypeNameTxt.getText();
		if(StringUtil.isEmpty(id)){
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		if(StringUtil.isEmpty(petTypeName)){
			JOptionPane.showMessageDialog(null, "宠物类别名称不能为空");
			return;
		}
		PetType petType = new PetType(Integer.parseInt(id),petTypeName);
		Connection con = null;
		try{
			con=dbUtil.getCon();
			int modifyNum=petTypeDao.update(con, petType);
			if(modifyNum==1){
				JOptionPane.showMessageDialog(null, "修改成功");
				this.resetValue();
				this.fillTable(new PetType());
			}else{
				JOptionPane.showMessageDialog(null, "修改失败");
			}
		}catch (Exception e2) {
			e2.printStackTrace();

			JOptionPane.showMessageDialog(null, "修改失败");
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	/**
	 * 图书类别删除事件处理
	 * @param e
	 */
	private void petTypeDeleteActionEvent(ActionEvent e) {
		// TODO Auto-generated method stub
		String id=idTxt.getText();
		if(StringUtil.isEmpty(id)){
			JOptionPane.showMessageDialog(null, "请选择要删除的记录");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "确定要删除该记录吗？");
		if(n==0){
			Connection con=null;
			try {
				con=dbUtil.getCon();
				int deleteNum=petTypeDao.delete(con,id);
				if(deleteNum==1){
					JOptionPane.showMessageDialog(null, "删除成功");
					this.resetValue();
					this.fillTable(new PetType());
					
				}else{
					JOptionPane.showMessageDialog(null, "删除失败");
				}
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();

				JOptionPane.showMessageDialog(null, "删除失败");
			}finally{
				try{
					dbUtil.closeCon(con);
				}catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		}
	}

	private void resetValue() {
		// TODO Auto-generated method stub
		this.idTxt.setText("");
		this.petTypeNameTxt.setText("");
	}

}
