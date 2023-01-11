package com.itwill.shop.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.shop.cart.CartService;
import com.itwill.shop.member.Member;
import com.itwill.shop.member.MemberService;
import com.itwill.shop.order.OrderService;
import com.itwill.shop.product.Product;
import com.itwill.shop.product.ProductService;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.Cursor;
import javax.swing.JTabbedPane;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import com.itwill.shop.ui.최민영.MemberLoginPanel_최민영;
import com.itwill.shop.ui.최민영.MemberJoinPanel_최민영;
import com.itwill.shop.ui.최민영.MemberDetailPanel_최민영;
import com.itwill.shop.ui.김민선.OrderCreatePanel_김민선;
import com.itwill.shop.ui.김세영.OrderListPanel_김세영;
import com.itwill.shop.ui.김세영.OrderDetailPanel_김세영;
import java.awt.Toolkit;
import java.awt.SystemColor;
import java.awt.Font;
import com.itwill.shop.ui.김준.ProductListPanel_김준;
import com.itwill.shop.ui.김준.ProductRecommendPanel_김준;
import com.itwill.shop.ui.김준.ProductDetailPanel_김준;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import com.itwill.shop.ui.김강산.CartListPanel_김강산;

public class ShopMainFrame extends JFrame {
	
	/*********************************************************/
	/*
	 * Panel 상수 선언
	 */
	public static final int PANEL_MEMBER_LOGIN = 1;
	public static final int PANEL_MEMBER_JOIN = 2;
	public static final int PANEL_MEMBER_INFO = 3;
	public static final int PANEL_PRODUCT_LIST = 4;
	public static final int PANEL_PRODUCT_RECOMMEND = 5;
	public static final int PANEL_PRODUCT_DETAIL = 6;
	public static final int PANEL_CART = 7;
	public static final int PANEL_ORDER_CREATE = 8;
	public static final int PANEL_ORDER_LIST = 9;
	public static final int PANEL_ORDER_DETAIL = 10;
	
	/*
	 * 1. Service 객체 선언
	 */
	public MemberService memberService;
	public OrderService orderService;
	public CartService cartService;
	public ProductService productService;
	/*
	 * 2. login Member 객체 선언(선택한 product 객체 선언)
	 */
	public Member loginMember = null;
	Product selectProduct;
	
	public JPanel contentPane;
	public JTabbedPane shopTabbedPane;
	public JTabbedPane memberTabbedPane;
	public JTabbedPane productTabbedPane;
	public JTabbedPane cartTabbedPane;
	public JTabbedPane orderTabbedPane;
	public MemberLoginPanel_최민영 memberLoginPanel;
	public MemberJoinPanel_최민영 memberJoinPanel;
	public MemberDetailPanel_최민영 memberDetailPanel;
	public ProductListPanel_김준 productListPanel;
	public ProductRecommendPanel_김준 productRecommendPanel;
	public ProductDetailPanel_김준 productDetailPanel;
	public OrderCreatePanel_김민선 orderCreatePanel;
	public OrderListPanel_김세영 orderListPanel;
	private CartListPanel_김강산 cartListPanel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopMainFrame frame = new ShopMainFrame();
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
	public ShopMainFrame() throws Exception{
		setFont(new Font("D2Coding", Font.PLAIN, 12));
		setBackground(SystemColor.info);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ShopMainFrame.class.getResource("/images/home 타이틀로고.png")));
		setTitle("든든마켓");
		initGUI();
	}
	private void initGUI() throws Exception{
		setPreferredSize(new Dimension(360, 640));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
				setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel globalNorthMenuPanel = new JPanel();
		globalNorthMenuPanel.setBackground(new Color(153, 102, 255));
		contentPane.add(globalNorthMenuPanel, BorderLayout.NORTH);
		globalNorthMenuPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel globalLogoLB = new JLabel("");
		globalLogoLB.setBorder(null);
		globalLogoLB.setHorizontalAlignment(SwingConstants.LEFT);
		globalLogoLB.setIcon(new ImageIcon(ShopMainFrame.class.getResource("/images/든든마켓화이트 상단.png")));
		globalNorthMenuPanel.add(globalLogoLB);
		
		JPanel globalSouthMenuPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) globalSouthMenuPanel.getLayout();
		flowLayout.setHgap(50);
		globalSouthMenuPanel.setBackground(new Color(153, 102, 255));
		contentPane.add(globalSouthMenuPanel, BorderLayout.SOUTH);
		
		JButton globalSearchMenuButton = new JButton("");
		globalSearchMenuButton.setContentAreaFilled(false);
		globalSearchMenuButton.setBorderPainted(false);
		globalSearchMenuButton.setOpaque(false);
		globalSearchMenuButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		globalSearchMenuButton.setBorder(null);
		globalSearchMenuButton.setIcon(new ImageIcon(ShopMainFrame.class.getResource("/images/search 50.png")));
		globalSouthMenuPanel.add(globalSearchMenuButton);
		
		JButton globalHomeMenuButton = new JButton("");
		globalHomeMenuButton.setContentAreaFilled(false);
		globalHomeMenuButton.setBorderPainted(false);
		globalHomeMenuButton.setOpaque(false);
		globalHomeMenuButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		globalHomeMenuButton.setBorder(null);
		globalHomeMenuButton.setIcon(new ImageIcon(ShopMainFrame.class.getResource("/images/home 50.png")));
		globalSouthMenuPanel.add(globalHomeMenuButton);
		
		JButton globalMemberMenuButton = new JButton("");
		globalMemberMenuButton.setContentAreaFilled(false);
		globalMemberMenuButton.setBorderPainted(false);
		globalMemberMenuButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		globalMemberMenuButton.setBorder(null);
		globalMemberMenuButton.setOpaque(false);
		globalMemberMenuButton.setIcon(new ImageIcon(ShopMainFrame.class.getResource("/images/cart50.png")));
		globalSouthMenuPanel.add(globalMemberMenuButton);
		
		shopTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(shopTabbedPane, BorderLayout.CENTER);
		
		memberTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		memberTabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				/***********탭이 2번(회원정보)으로 변경 시 회원 정보 보여주기************/
				int selectedTabIndex = memberTabbedPane.getSelectedIndex();
				if (selectedTabIndex == 2) {
					try {
						memberDetailPanel.displayMemberInfo(loginMember);
					} catch (Exception e1) {
						e1.getMessage();
					}
				}
				/************************/
				if (selectedTabIndex == 0) {
					memberLoginPanel.loginIdTF.setText("");
					memberLoginPanel.loginPassTF.setText("");
				}
			}
		});
		shopTabbedPane.addTab("회원", null, memberTabbedPane, null);
		
		memberLoginPanel = new MemberLoginPanel_최민영();
		memberTabbedPane.addTab("로그인", null, memberLoginPanel, null);
		
		memberJoinPanel = new MemberJoinPanel_최민영();
		memberTabbedPane.addTab("회원가입", null, memberJoinPanel, null);
		
		memberDetailPanel = new MemberDetailPanel_최민영();
		memberTabbedPane.addTab("회원정보", null, memberDetailPanel, null);
		
		productTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		shopTabbedPane.addTab("상품", null, productTabbedPane, null);
		
		productListPanel = new ProductListPanel_김준();
		productTabbedPane.addTab("상품목록", null, productListPanel, null);
		
		productRecommendPanel = new ProductRecommendPanel_김준();
		productTabbedPane.addTab("추천상품", null, productRecommendPanel, null);
		
		productDetailPanel = new ProductDetailPanel_김준();
		productTabbedPane.addTab("상품상세", null, productDetailPanel, null);
		
		
		cartTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		shopTabbedPane.addTab("장바구니", null, cartTabbedPane, null);
		
		cartListPanel = new CartListPanel_김강산();
		cartTabbedPane.addTab("New tab", null, cartListPanel, null);
		
		orderTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		shopTabbedPane.addTab("주문", null, orderTabbedPane, null);
		
		orderCreatePanel = new OrderCreatePanel_김민선();
		orderTabbedPane.addTab("주문하기", null, orderCreatePanel, null);
		
		orderListPanel = new OrderListPanel_김세영();
		orderTabbedPane.addTab("주문목록", null, orderListPanel, null);
		
	
		/***************************************************/
		/*
		 * 3. Service 객체 생성
		 */
		memberService = new MemberService();
		orderService = new OrderService();
		cartService = new CartService();
		productService = new ProductService();
		
		//loginMember = new Member("aaa", null, null, null, null, null, null);
		loginMember = new Member();
		
		/******* ShopMainFrame 참조를 Panel에 넘겨줌 *******/
		memberLoginPanel.setFrame(this);
		memberJoinPanel.setFrame(this);
		memberDetailPanel.setFrame(this);
		/***************수정**************/
		productListPanel.setFrame(this);
		productDetailPanel.setFrame(this);
		productRecommendPanel.setFrame(this);
		cartListPanel.setFrame(this);
		
		
	}// 생성자 끝
	/***************패널 변경 메소드******************/
	/*
	public void changePanel(int panel_no, Object data) {
		if (panel_no == PANEL_MEMBER_LOGIN) {
			shopTabbedPane.setSelectedIndex(0);
			memberTabbedPane.setSelectedIndex(0);
		} else if (panel_no == PANEL_MEMBER_JOIN) {
			shopTabbedPane.setSelectedIndex(0);
			memberTabbedPane.setSelectedIndex(1);
		} else if (panel_no == PANEL_MEMBER_INFO) {
			shopTabbedPane.setSelectedIndex(0);
			memberTabbedPane.setSelectedIndex(2);
		} else if (panel_no == PANEL_PRODUCT_LIST) {
			shopTabbedPane.setSelectedIndex(1);
			productTabbedPane.setSelectedIndex(0);
		} else if (panel_no == PANEL_PRODUCT_RECOMMEND) {
			shopTabbedPane.setSelectedIndex(1);
			productTabbedPane.setSelectedIndex(1);
		} else if (panel_no == PANEL_PRODUCT_DETAIL) {
			Product product = (Product)data;
			//System.out.println("recv product" + product);
			shopTabbedPane.setSelectedIndex(1);
			productTabbedPane.setSelectedIndex(2);
			productDetailPanel.displayProductDetail(product);
		} else if (panel_no == PANEL_CART) {
			loginMember = (Member)data;
			try {
				transferLoginMember(loginMember);
			} catch (Exception e) {
				e.printStackTrace();
			}
			shopTabbedPane.setSelectedIndex(2);
			cartTabbedPane.setSelectedIndex(0);
		} else if (panel_no == PANEL_ORDER_CREATE) {
			shopTabbedPane.setSelectedIndex(3);
			orderTabbedPane.setSelectedIndex(0);
		} else if (panel_no == PANEL_ORDER_LIST) {
			shopTabbedPane.setSelectedIndex(3);
			orderTabbedPane.setSelectedIndex(1);
		} else if (panel_no == PANEL_ORDER_DETAIL) {
			shopTabbedPane.setSelectedIndex(3);
			orderTabbedPane.setSelectedIndex(2);
		}

	}
	 public void transferLoginMember(Member member) throws Exception {
			memberLoginPanel.setLoginMember(member);
			memberJoinPanel.setLoginMember(member);
			memberDetailPanel.setLoginMember(member);
			productListPanel.setLoginMember(member);
			productDetailPanel.setLoginMember(member);
			productRecommendPanel.setLoginMember(member);
			cartListPanel.setLoginMember(member);
		}
		*/
	public void changePanel(int panel_no, Object data) {
		if (panel_no == PANEL_MEMBER_LOGIN) {
			shopTabbedPane.setSelectedIndex(0);
			memberTabbedPane.setSelectedIndex(0);
		} else if (panel_no == PANEL_MEMBER_JOIN) {
			shopTabbedPane.setSelectedIndex(0);
			memberTabbedPane.setSelectedIndex(1);
		} else if (panel_no == PANEL_MEMBER_INFO) {
			shopTabbedPane.setSelectedIndex(0);
			memberTabbedPane.setSelectedIndex(2);
		} else if (panel_no == PANEL_PRODUCT_LIST) {
			shopTabbedPane.setSelectedIndex(1);
			productTabbedPane.setSelectedIndex(0);
		} else if (panel_no == PANEL_PRODUCT_RECOMMEND) {
			shopTabbedPane.setSelectedIndex(1);
			productTabbedPane.setSelectedIndex(1);
		} else if (panel_no == PANEL_PRODUCT_DETAIL) {
			Product product = (Product)data;
			//System.out.println("recv product" + product);
			shopTabbedPane.setSelectedIndex(1);
			productTabbedPane.setSelectedIndex(2);
			productDetailPanel.displayProductDetail(product);
		} else if (panel_no == PANEL_CART) {
			shopTabbedPane.setSelectedIndex(2);
			cartTabbedPane.setSelectedIndex(0);
		} else if (panel_no == PANEL_ORDER_CREATE) {
			shopTabbedPane.setSelectedIndex(3);
			orderTabbedPane.setSelectedIndex(0);
		} else if (panel_no == PANEL_ORDER_LIST) {
			shopTabbedPane.setSelectedIndex(3);
			orderTabbedPane.setSelectedIndex(1);
		} else if (panel_no == PANEL_ORDER_DETAIL) {
			shopTabbedPane.setSelectedIndex(3);
			orderTabbedPane.setSelectedIndex(2);
		}

	}


}
