package isd_lecture1;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import java.awt.event.*;

public class BadgeApplet2 extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jlabel1,jlabel2,jlabel3,jlabel4,jlabel5,jlabel6,jlabel7,jlabel8,jlabel9,jlabel10,jlabel11;
	private JComboBox<String> jcombobox1,jcombobox2,jcombobox3;
	private JTextField jtextfield1;
	private JButton jbutton1,jbutton2,jbutton3,jbutton4,jbutton5,jbutton6,jbutton7,jbutton_bc,jbutton_c;
	private int TWidth1,TWidth2,TWidth3,THeight,Ac,Dc,Ld,X,Y,X1,X2,X3,Y1,Y2,Y3,w=300,h=200,fs=14;
	private String uname="Molly",shapevalue="Rectangle",error_message="";
	private Badge badge;
	private ErrorBadge errorbadge;
	private int font=Font.PLAIN;
	private Color bColor=Color.white,fColor=Color.black;
	private boolean width_trigger=false, height_trigger=false;
	//String[] listcolor=new String[] {"black","blue","cyan","darkgray","gray","green","lightgray","magenta","orange","pink","red","white","yellow"};
	String[] sizelist=new String[] {"2","4","6","8","10","12","14","16","18","20","22","24","26","28","30","32","34","36","38","40","42","44","46","48","50"};
	private jslider_width jslider1;
	private jslider_height jslider2;
	private jpanel jpanel1,jpanel2,jpanel3,jpanel4,jpanel5,jpanel6,jpanel7,jpanel8,jpanel10;
	private setPanel setPanel;
	private showPanel showPanel;
	
	public void Setting() {
		//super("Setting Badge");
		Container c=getContentPane();
		c.setLayout(null);
		
		
		setPanel= new setPanel();
		setPanel.setBounds(0,0,500,600);
		showPanel=new showPanel();
		showPanel.setBounds(500,0,500,600);
		
		jpanel1=new jpanel();
		jpanel1.setBounds(0,0,500,70);
		jpanel1.setBorder(BorderFactory.createTitledBorder("Choose Background color"));
		jpanel2=new jpanel();
		jpanel2.setBounds(0,70,500,70);
		jpanel2.setBorder(BorderFactory.createTitledBorder("Input Name"));
		jpanel3=new jpanel();
		jpanel3.setBounds(0,140,500,70);
		jpanel3.setBorder(BorderFactory.createTitledBorder("Choose Shape"));
		jpanel4=new jpanel();
		jpanel4.setBounds(0,210,500,70);
		jpanel4.setBorder(BorderFactory.createTitledBorder("Set Border Width"));
		jpanel5=new jpanel();
		jpanel5.setBounds(0,280,500,70);
		jpanel5.setBorder(BorderFactory.createTitledBorder("Set Border Height"));
		jpanel6=new jpanel();
		jpanel6.setBounds(0,350,500,70);
		jpanel6.setBorder(BorderFactory.createTitledBorder("Choose Font Style"));
		jpanel7=new jpanel();
		jpanel7.setBounds(0,420,500,70);
		jpanel7.setBorder(BorderFactory.createTitledBorder("Choose Font Size"));
		jpanel8=new jpanel();
		jpanel8.setBounds(0,490,500,70);
		jpanel8.setBorder(BorderFactory.createTitledBorder("Choose Font Color"));
		
		/*
		jpanel jpanel9=new jpanel();
		jpanel9.setBounds(0,0,500,400);
		jpanel9.setOpaque(false);
		jpanel9.setBorder(BorderFactory.createTitledBorder("Show Panel"));
		*/
		badge=new Badge();
		badge.setBounds(0,0,500,400);
		badge.repaint();
		
		errorbadge=new ErrorBadge();
		errorbadge.setBounds(0,400,500,200);
		errorbadge.setOpaque(false);
		errorbadge.repaint();
		
		setPanel.add(jpanel1);
		setPanel.add(jpanel2);
		setPanel.add(jpanel3);
		setPanel.add(jpanel4);
		setPanel.add(jpanel5);
		setPanel.add(jpanel6);
		setPanel.add(jpanel7);
		setPanel.add(jpanel8);
		
		//showPanel.add(jpanel9);
		showPanel.add(badge);
		showPanel.add(errorbadge);
		
		
		
		//setPanel
		//jpanel1
		//jcombobox1=new JComboBox<String>(listcolor);
		//jcombobox1.setBounds(150,20,200,35);
		//jpanel1.add(jcombobox1);
		jbutton_bc=new JButton("Color Chooser");
		jbutton_bc.setBounds(125,25,125,25);
		jpanel1.add(jbutton_bc);
		jlabel1=new JLabel("        ");
		jlabel1.setOpaque(true);
		jlabel1.setBounds(275, 20, 100, 30);
		jpanel1.add(jlabel1);
		
		//jpanel2
		jlabel2=new JLabel("Name:");
		jlabel2.setBounds(100,20,250,35);
		jpanel2.add(jlabel2);
		jtextfield1=new JTextField(20);
		jtextfield1.setBounds(150,20,250,35);
		jpanel2.add(jtextfield1);
		
		//jpanel3
		//jlabel3=new JLabel("Shape:");
		//jlabel3.setBounds(100,20,250,35);
		//jpanel3.add(jlabel3);
		//Icon oval1=new ImageIcon("oval.png");
		//jlabel5=new JLabel("",oval1,SwingConstants.LEFT);
	    jbutton1=new JButton("Oval");
	    jbutton1.setBounds(100,20,75,35);
		jpanel3.add(jbutton1);
		//jpanel3.add(jlabel5);
		jbutton2=new JButton("Rectangle");
		jbutton2.setBounds(200,20,100,35);
		jpanel3.add(jbutton2);
		jbutton3=new JButton("Roundrec");
		jbutton3.setBounds(325,20,100,35);
		jpanel3.add(jbutton3);
		
		//jpanel4
		//jlabel5=new JLabel("Width:");
		//jlabel5.setBounds(75,20,250,35);
		//jpanel4.add(jlabel5);
		jslider1=new jslider_width();
		jslider1.setBounds(100,20,275,35);
		jpanel4.add(jslider1);
		jlabel7=new JLabel(""+jslider1.getValue());
		jlabel7.setBounds(400,20,30,30);
		jlabel7.setBorder(BorderFactory.createLoweredBevelBorder());
		jpanel4.add(jlabel7);
	
		//japnel5
		//jlabel6=new JLabel("Height:");
		//jlabel6.setBounds(75,20,250,35);
		//jpanel5.add(jlabel6);
		jslider2=new jslider_height();
		jslider2.setBounds(100,20,275,35);
		jpanel5.add(jslider2);
		jlabel8=new JLabel(""+jslider2.getValue());
		jlabel8.setBounds(400,20,30,30);
		jlabel8.setBorder(BorderFactory.createLoweredBevelBorder());
		jpanel5.add(jlabel8);
		
		//japnel6
		//jlabel9=new JLabel("Font Style:");
		//jlabel9.setBounds(75,20,250,35);
		//jpanel6.add(jlabel9);
		jbutton4=new JButton("R");
		jbutton4.setFont(new Font("Arial",Font.PLAIN,12));
		jbutton4.setBounds(110,25,30,25);
		jbutton4.setToolTipText("Regular");
		jpanel6.add(jbutton4);
		jbutton5=new JButton("B");
		jbutton5.setFont(new Font("Arial",Font.BOLD,12));
		jbutton5.setBounds(190,25,30,25);
		jbutton5.setToolTipText("Bold");
		jpanel6.add(jbutton5);
		jbutton6=new JButton("I");
		jbutton6.setFont(new Font("Arial",Font.ITALIC,12));
		jbutton6.setBounds(270,25,30,25);
		jbutton6.setToolTipText("Italic");
		jpanel6.add(jbutton6);
		jbutton7=new JButton("BI");
		jbutton7.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,12));
		jbutton7.setBounds(350,25,30,25);
		jbutton7.setToolTipText("BoldItalic");
		jpanel6.add(jbutton7);
		
		//jpanel7
		//jlabel10=new JLabel("F_Size:");
		//jlabel10.setBounds(150,20,250,35);
		//jpanel7.add(jlabel10);
		jcombobox2=new JComboBox<String>(sizelist);
		jcombobox2.setBounds(150,20,200,35);
		jcombobox2.setSelectedIndex(6);
		jpanel7.add(jcombobox2);
		
		//jpanel8
		//jcombobox3=new JComboBox<String>(listcolor);
		//jcombobox3.setBounds(150,20,200,35);
		//jpanel8.add(jcombobox3);
		jbutton_c=new JButton("Color Chooser");
		jbutton_c.setBounds(125, 25, 125, 25);
		jpanel8.add(jbutton_c);
		jlabel11=new JLabel("       ");
		jlabel11.setOpaque(true);
		jlabel11.setBounds(275,20,100,30);
		jpanel8.add(jlabel11);
		
		
		//showPanel
		//jpanel10
		//
		
		
		c.add("West",setPanel);
		c.add("East",showPanel);
		
		
		//ButtonHandler handler=new ButtonHandler();
		//jcombobox1.addActionListener(handler);
		//jtextfield1.addActionListener(handler);
		//ColorHandler color=new ColorHandler();
		//jbutton_bc.addActionListener(color);
		//jbutton_c.addActionListener(color);
		//jslider1.addChangeListener(handler1);
		//jslider2.addChangeListener(handler1);
		
		this.setSize(1000,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		//jframe=new JFrame();
		//jframe.setSize(300, 300);
       // jframe.setLocationRelativeTo(null);
       // jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
          
	}
	
	
	//Application
	private BadgeApplet2() {
		Setting();
		action();
	}
	
	
	//lots of child-class
	class setPanel extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public setPanel() {
			setLayout(null);
			setPreferredSize(new Dimension(500,300));
			setBackground(Color.lightGray);
		}
	}
	
	class showPanel extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public showPanel() {
			setLayout(null);
			setPreferredSize(new Dimension(500,300));
			setBackground(Color.white);
		}
	}
	
	class jpanel extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public jpanel() {
			setLayout(null);
			//setPreferredSize(new Dimension(500,50));
			setBackground(Color.lightGray);
		}
	}
	
	class jslider_width extends JSlider{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		public jslider_width() {
			setMajorTickSpacing(100);
			setMinorTickSpacing(25);
			setPaintTicks(true);
			setPaintLabels(true);
			setMinimum(100);
			setMaximum(500);
			setValue(300);
		}
	}
	
	class jslider_height extends JSlider{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		public jslider_height() {
			setMajorTickSpacing(100);
			setMinorTickSpacing(25);
			setPaintTicks(true);
			setPaintLabels(true);
			setMinimum(100);
			setMaximum(400);
			setValue(200);
		}
	}
	
	class ErrorBadge extends JPanel{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public void paint(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.setFont(new Font("Arial",Font.BOLD,16));
		//g.setColor(Color.WHITE);
		g.drawString("Error Alert: "+error_message,0,100);
		}
	}
	
	class Badge extends JPanel{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public void paint(Graphics g) {
			
			g.setColor(bColor);
			g.drawRect(0, 0, 500, 400);
			g.setColor(fColor);
			//g.fillRect(0, 0, 500, 400);
		
			g.setFont(new Font("Arial",font,fs));
			
			FontMetrics FM=g.getFontMetrics();
			THeight=FM.getHeight();
			TWidth1=FM.stringWidth("Hello");
			TWidth2=FM.stringWidth("My name is");
			TWidth3=FM.stringWidth(uname);
			
			Ac=FM.getAscent();
			Dc=FM.getDescent();
			Ld=FM.getLeading();
			
			
			//w=(int)w;
			//h=(int)h;
			
			X=(500-w)/2;
			Y=(400-h)/2;
			
			
			switch(shapevalue) {
			case "Oval":
				g.drawOval(X,Y,w,h);
				break;
				
			case "Rectangle":
				g.drawRect(X,Y,w,h);
				break;
				
			case "Roundrec":
				g.drawRoundRect(X,Y,w,h,15,15);
				break;
			}
				
			
			X1=(w-TWidth1)/2+(500-w)/2;
			X2=(w-TWidth2)/2+(500-w)/2;
			X3=(w-TWidth3)/2+(500-w)/2;
			
			Y1=(h-3*(Ac+Dc)-2*Ld)/2+(400-h)/2+Ac;
			Y2=(h-3*(Ac+Dc)-2*Ld)/2+(400-h)/2+(2*Ac+Dc)+Ld;
			Y3=(h-3*(Ac+Dc)-2*Ld)/2+(400-h)/2+(3*Ac+2*Dc)+2*Ld;
			
			
			g.drawString("Hello", X1, Y1);
			g.drawString("My name is", X2, Y2);
			g.drawString(uname, X3, Y3);
		}
	}
	
	
	
	/*
	class ColorHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Color color=JColorChooser.showDialog(jframe, "Choose color", null);
			if(color==null) {
				return;
			}
			if((JButton)e.getSource()==jbutton_bc) {
				jlabel1.setForeground(color);
				jlabel1.setBackground(color);
				bColor=color;
				//badge.repaint();
				}
			if((JButton)e.getSource()==jbutton_c) {
				jlabel11.setForeground(color);
				jlabel11.setBackground(color);
			}
		}
	}
	*/
	/*
	ChangeListener handler1=new ChangeListener() {
		public void stateChanged(ChangeEvent e) {
			if ((JSlider) e.getSource() == jslider1) {
				jlabel7.setText("" + jslider1.getValue());
			}
			if ((JSlider) e.getSource() == jslider2)
				jlabel8.setText("" + jslider2.getValue());
		}
		};
	*/
	
	public void colorcheck() {
		 //Don't compare the color directly, have to compare the RGB of the color
		 if(bColor.getRGB()==fColor.getRGB()) {
			bColor=Color.white;
			fColor=Color.black;
			badge.setBackground(bColor);
			error_message="Don't set same Background & Foreground Color!";
		}
	}
	
	
	public void check() {
		switch(shapevalue) { 
		case "Oval":
			if((TWidth2>w ||TWidth3>w) && 3*THeight<h) {
				error_message="Width too smamll";
			}
			else if(3*THeight>h && (TWidth2<w && TWidth3<w)) {
				error_message="Height too small";
			}
			else if((TWidth2>w || TWidth3>w) && 3*THeight>h) {
				error_message="Both Width & Height too small";
			}
			else error_message="";
			
		case "Rectangle":
			if((TWidth2>w ||TWidth3>w) && 3*THeight<h) {
				error_message="Width too smamll";
			}
			else if(3*THeight>h && (TWidth2<w && TWidth3<w)) {
				error_message="Height too small";
			}
			else if((TWidth2>w ||TWidth3>w) && 3*THeight>h) {
				error_message="Both Width & Height too smallm";
			}
			else error_message="";
			
		case "RoundRec":
			if((TWidth2>w ||TWidth3>w) && 3*THeight<h) {
				error_message="Width too smamll";
			}
			else if(3*THeight>h && (TWidth2<w && TWidth3<w)) {
				error_message="Height too small";
			}
			else if((TWidth2>w ||TWidth3>w) && 3*THeight>h) {
				error_message="Both Width & Height too small";
			}
			else error_message="";
		}
	}
	
	private void action() {
		jslider1.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				jlabel7.setText("" + jslider1.getValue());
				w=jslider1.getValue();
				check();
				System.out.println(error_message);
				errorbadge.repaint();
				System.out.println(w);
				badge.repaint();
				}
		});
		
		jslider2.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				jlabel8.setText("" + jslider2.getValue());
				h=jslider2.getValue();
				check();
				System.out.println(error_message);
				errorbadge.repaint();
				System.out.println(h);
				badge.repaint();
				}
		});
		
		jbutton1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				shapevalue = "Oval";
				check();
				errorbadge.repaint();
				System.out.println(error_message);
				System.out.println(shapevalue);
				badge.repaint();
			}
		});
		
		jbutton2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				shapevalue = "Rectangle";
				check();
				errorbadge.repaint();
				System.out.println(shapevalue);
                badge.repaint();			
			}
		});
		
		jbutton3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				shapevalue = "Roundrec";
				check();
				errorbadge.repaint();
				System.out.println(shapevalue);
                badge.repaint();			
			}
		});
		
		jbutton4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				font=Font.PLAIN;
				check();
				errorbadge.repaint();
				System.out.println(font);
                badge.repaint();			
			}
		});
		
		jbutton5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				font=Font.BOLD;
				check();
				errorbadge.repaint();
				System.out.println(font);
                badge.repaint();			
			}
		});
		
		jbutton6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				font=Font.ITALIC;
				check();
				errorbadge.repaint();
				System.out.println(font);
                badge.repaint();			
			}
		});
		
		jbutton7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				font=Font.BOLD+Font.ITALIC;
				check();
				errorbadge.repaint();
				System.out.println(font);
                badge.repaint();			
			}
		});
		
		//when the original bound is small than the font after we change the font,
		//the error message sometimes won't show! It's just because the system is not so flexible.
		jcombobox2.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				fs =Integer.valueOf((String)e.getItem());
				System.out.println(fs);
				badge.repaint();
				check();
				errorbadge.repaint();
				//System.out.println(fs);
				//badge.repaint();
			}
		});
		
		jtextfield1.getDocument().addDocumentListener(new DocumentListener() {
			  public void changedUpdate(DocumentEvent e) {
				  Document doc=e.getDocument();
				  try {
					uname=doc.getText(0, doc.getLength());
					badge.repaint();
					check();
					errorbadge.repaint();
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			  }
			  public void removeUpdate(DocumentEvent e) {
				  Document doc=e.getDocument();
				  try {
					uname=doc.getText(0, doc.getLength());
					badge.repaint();
					check();
					errorbadge.repaint();
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			  }
			  public void insertUpdate(DocumentEvent e) {
				  Document doc=e.getDocument();
				  try {
					uname=doc.getText(0, doc.getLength());
					badge.repaint();
					check();
					errorbadge.repaint();
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			  }
			});
		
		jbutton_bc.addActionListener(new ActionListener() {
      
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Color color=JColorChooser.showDialog(BadgeApplet2.this, "Choose color",null );
				System.out.println(color);
    			if(color==null) {
    				bColor=Color.WHITE;
    			}
    			else {
    				jlabel1.setForeground(color);
    				jlabel1.setBackground(color);
    				bColor=color;
    				badge.setBackground(bColor);
    				colorcheck();
    				errorbadge.repaint();
    				badge.repaint();
    				}
            }
        });
		
		jbutton_c.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Color color=JColorChooser.showDialog(BadgeApplet2.this, "Choose color",null );
				System.out.println(color);
    			if(color==null) {
    				fColor=Color.black;
    			}
    			else {
    				jlabel11.setForeground(color);
    				jlabel11.setBackground(color);
    				fColor=color;
    				badge.setBackground(bColor);
    				colorcheck();
    				errorbadge.repaint();
    				badge.repaint();
    				}
			}
			
		});
		
	}
		

	
	public static void main(String args[]){
		BadgeApplet2 app=new BadgeApplet2();
		app.addWindowListener(
		new WindowAdapter() {
			public void windowClosing( WindowEvent e ) {
				System.exit( 0 );
			}
		}
		);
	}
}

