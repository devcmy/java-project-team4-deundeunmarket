package com.itwill.shop.ui.김세영;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;

import com.itwill.shop.member.Member;
import com.itwill.shop.order.Order;
import com.itwill.shop.order.OrderService;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OrderListPanel_김세영 extends JPanel {
	
	/******************************/
	/*
	 * Service객체 선언
	 */
	OrderService orderService;
	
	/*
	 * loginMember객체 선언
	 */
	Member loginMember;
	/******************************/
	private JPanel orderListPanel;

	/**
	 * Create the panel.
	 */
	public OrderListPanel_김세영() throws Exception {
		setLayout(null);
		
		JScrollPane orderListScrollPane = new JScrollPane();
		orderListScrollPane.setBounds(32, 31, 292, 414);
		add(orderListScrollPane);
		
		orderListPanel = new JPanel();
		orderListPanel.setPreferredSize(new Dimension(10, 700));
		orderListScrollPane.setViewportView(orderListPanel);
		/**********************주문패널생성**********************/
		
		JPanel orderPanel = new JPanel();
		orderPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * orderPanel을 마우스로 클릭시 상세보기 화면으로 이동
				 * 
				 * index 0 -> 주문하기
				 * index 1 -> 주문목록
				 * index 2 -> 주문상세보기
				 */
				
				//orderTabbedPane.setSelectedIndex(2);
				try {
					//goToOrderDetail();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		/*
		orderPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		orderPanel.setPreferredSize(new Dimension(270, 80));
		orderListPanel.add(orderPanel);
		orderPanel.setLayout(null);
		
		JLabel o_noDisplayLabel = new JLabel("");
		o_noDisplayLabel.setBounds(12, 30, 110, 15);
		orderPanel.add(o_noDisplayLabel);
		
		JLabel o_descDisplayLabel = new JLabel("");
		o_descDisplayLabel.setBounds(12, 50, 110, 15);
		orderPanel.add(o_descDisplayLabel);
		
		JLabel o_dateDisplayLabel = new JLabel("");
		o_dateDisplayLabel.setBounds(12, 10, 110, 15);
		orderPanel.add(o_dateDisplayLabel);
		
		JLabel o_addressDisplayLabel = new JLabel("");
		o_addressDisplayLabel.setBounds(148, 10, 110, 15);
		orderPanel.add(o_addressDisplayLabel);
		
		JLabel o_priceDisplayLabel = new JLabel("");
		o_priceDisplayLabel.setBounds(148, 30, 110, 15);
		orderPanel.add(o_priceDisplayLabel);
		
		JLabel o_paymentDisplayLabel = new JLabel("");
		o_paymentDisplayLabel.setBounds(148, 50, 110, 15);
		orderPanel.add(o_paymentDisplayLabel);
		*/
		
		/******************************/
		/*
		 * Service객체 생성
		 */
		orderService = new OrderService();
		
		/*
		 * loginMember객체 생성
		 */
		loginMember = new Member("sy0", null, null, null, null, null, null);
		/******************************/
		/*
		 * 메소드 사용
		 */
		orderList();
		/******************************/
	}//생성자 종료
	
	/******************************/
	/*
	 * 메소드 선언
	 */
	private void orderList() throws Exception {
		List<Order> orderList = orderService.orderList(loginMember.getM_id());
		for (Order order : orderList) {
			JPanel orderPanel = new JPanel();
			orderPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			orderPanel.setPreferredSize(new Dimension(270, 80));
			orderPanel.setLayout(null);
			
			JLabel o_noDisplayLabel = new JLabel(""+order.getO_no());
			o_noDisplayLabel.setBounds(12, 30, 110, 15);
			orderPanel.add(o_noDisplayLabel);
			
			JLabel o_descDisplayLabel = new JLabel(order.getO_desc());
			o_descDisplayLabel.setBounds(12, 50, 110, 15);
			orderPanel.add(o_descDisplayLabel);
			
			JLabel o_dateDisplayLabel = new JLabel(""+order.getO_date());
			o_dateDisplayLabel.setBounds(12, 10, 110, 15);
			orderPanel.add(o_dateDisplayLabel);
			
			JLabel o_addressDisplayLabel = new JLabel(order.getO_address());
			o_addressDisplayLabel.setBounds(148, 10, 110, 15);
			orderPanel.add(o_addressDisplayLabel);
			
			JLabel o_priceDisplayLabel = new JLabel(""+order.getO_price());
			o_priceDisplayLabel.setBounds(148, 30, 110, 15);
			orderPanel.add(o_priceDisplayLabel);
			
			JLabel o_paymentDisplayLabel = new JLabel(order.getO_payment());
			o_paymentDisplayLabel.setBounds(148, 50, 110, 15);
			orderPanel.add(o_paymentDisplayLabel);
			
			orderListPanel.add(orderPanel);
		}
	}
	
	private void goToOrderDetail(JPanel orderPanel) throws Exception {
		/*
		 * 패널을 클릭했을 때, 해당 패널의 o_no를 받아와서 다음 메소드에 전달해주고, 해당 order의 상세보기탭으로 전환하는 메소드.
		 */
		//orderPanel.disp
	}
}
