package com.ccx.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class mainFrm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JDesktopPane table=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainFrm frame = new mainFrm();
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
	public mainFrm() {
		setTitle("宠物店管理系统2.0");
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\程序试做\\java课\\PetShop2.0\\image\\1151144.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 394);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("基本数据维护");
		menu.setIcon(new ImageIcon("E:\\程序试做\\java课\\PetShop2.0\\image\\base.png"));
		menuBar.add(menu);
		
		JMenu menu_1 = new JMenu("宠物类别管理");
		menu_1.setIcon(new ImageIcon("E:\\程序试做\\java课\\PetShop2.0\\image\\bookTypeManager.png"));
		menu.add(menu_1);
		
		JMenuItem menuItem = new JMenuItem("宠物类别添加");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PetTypeAddInterFrm petTypeAddInterFrm;
				try {
					petTypeAddInterFrm = new PetTypeAddInterFrm();//新建一个内部窗口
					petTypeAddInterFrm.setVisible(true);//显示内部窗口
					table.add(petTypeAddInterFrm);	//内部窗口添加到table上
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		menuItem.setIcon(new ImageIcon("E:\\程序试做\\java课\\PetShop2.0\\image\\add.png"));
		menu_1.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("宠物类别维护");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PetTypeManageInterFrm petTypeManageInterFrm;
				try {
					petTypeManageInterFrm = new PetTypeManageInterFrm();//新建一个内部窗口
					petTypeManageInterFrm.setVisible(true);//显示内部窗口
					table.add(petTypeManageInterFrm);	//内部窗口添加到table上
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		menuItem_1.setIcon(new ImageIcon("E:\\程序试做\\java课\\PetShop2.0\\image\\edit.png"));
		menu_1.add(menuItem_1);
		
		JMenu menu_2 = new JMenu("宠物管理");
		menu_2.setIcon(new ImageIcon("E:\\程序试做\\java课\\PetShop2.0\\image\\cat_dog_pet_16px_1143917_easyicon.net.png"));
		menu.add(menu_2);
		
		JMenuItem menuItem_2 = new JMenuItem("宠物添加");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				PetAddInterFrm petAddInterFrm;
				try {
					petAddInterFrm = new PetAddInterFrm();//新建一个内部窗口
					petAddInterFrm.setVisible(true);//显示内部窗口
					table.add(petAddInterFrm);	//内部窗口添加到table上
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		menuItem_2.setIcon(new ImageIcon("E:\\程序试做\\java课\\PetShop2.0\\image\\add.png"));
		menu_2.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("宠物维护");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PetManageInterFrm petManageInterFrm;
				try {
					petManageInterFrm = new PetManageInterFrm();//新建一个内部窗口
					petManageInterFrm.setVisible(true);//显示内部窗口
					table.add(petManageInterFrm);	//内部窗口添加到table上
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		menuItem_3.setIcon(new ImageIcon("E:\\程序试做\\java课\\PetShop2.0\\image\\edit.png"));
		menu_2.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("安全退出");
		menuItem_4.setIcon(new ImageIcon("E:\\程序试做\\java课\\PetShop2.0\\image\\exit.png"));
		menu.add(menuItem_4);
		
		JMenu menu_3 = new JMenu("关于我们");
		menu_3.setIcon(new ImageIcon("E:\\程序试做\\java课\\PetShop2.0\\image\\about.png"));
		menuBar.add(menu_3);
		
		JMenuItem menuItem_5 = new JMenuItem("宠物管理系统2.0");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				IntroduceUsInterFrm introduceUsInterFrm = new IntroduceUsInterFrm();
				introduceUsInterFrm.setVisible(true);
				table.add(introduceUsInterFrm);
				
				
			}
		});
		menuItem_5.setIcon(new ImageIcon("E:\\程序试做\\java课\\PetShop2.0\\image\\about.png"));
		menu_3.add(menuItem_5);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		table = new JDesktopPane();
		contentPane.add(table, BorderLayout.CENTER);
		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		
	}

}
