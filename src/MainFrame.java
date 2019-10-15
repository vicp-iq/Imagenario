import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;


public class MainFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	JButton button_open, button_open2, button_save, button_process;
	JButton button_about, button_setting;
	JButton[] buttons_control = new JButton[7];
	private JButton nullbutton = new JButton();
	JFileChooser chooser1, chooser2;
	
	BufferedImage image;
	Canvas canvas;
	
	public MainFrame(){
		super();
		setSize(500, 400);
		this.center();
		setTitle("Imagenario by WAIFor"+" - v"+Imagenario.VERSION);
		
		chooser1 = new JFileChooser((String)Imagenario.settings.get("open_dict"));
		this.add(chooser1);
		chooser1.setFileFilter(new javax.swing.filechooser.FileFilter() {
		      public boolean accept(File f) { //脡猫露篓驴脡脫脙碌脛脦脛录镁碌脛潞贸脳潞脙没
		    	  return f.getName().endsWith(".bmp") || f.getName().endsWith(".jpg") ||
		        		  f.getName().endsWith(".jpeg") || f.getName().endsWith(".gif") ||
		        		  f.getName().endsWith(".png") ||f.isDirectory();
		        }
		        public String getDescription() {
		          return "脥录脝卢脦脛录镁(*.bmp, *.jpg, *.jpeg, *.gif, *.png)";
		        }
		      });
		
		chooser2 = new JFileChooser((String)Imagenario.settings.get("save_dict"));
		this.add(chooser2);
		chooser2.setFileFilter(new javax.swing.filechooser.FileFilter() {
		      public boolean accept(File f) { //脡猫露篓驴脡脫脙碌脛脦脛录镁碌脛潞贸脳潞脙没
		          return f.getName().endsWith(".scx") || f.isDirectory();
		        }
		        public String getDescription() {
		          return "戮莽脟茅脦脛录镁(*.scx)";
		        }
		      });
		
		button_open = new JButton("麓貌驴陋脥录脧帽...");
		button_open.setSize(120, 40);
		button_open.setLocation(320, 20);
		
		button_open2 = new JButton("麓貌驴陋赂脽露脠脥录...");
		button_open2.setSize(120, 40);
		button_open2.setLocation(320, 70);
		
		button_process = new JButton("驴陋脢录脡煤鲁脡");
		button_process.setSize(120, 40);
		button_process.setLocation(320, 120);
		
		button_save = new JButton("卤拢麓忙戮莽脟茅");
		button_save.setSize(120, 40);
		button_save.setLocation(320, 170);
		
		button_setting = buttonSet("脡煤鲁脡脡猫脰脙", 120, 40, 320, 220);
		
		button_about = new JButton("鹿脴脫脷...");
		button_about.setSize(120, 40);
		button_about.setLocation(320, 270);
		
		this.add(button_open);
		this.add(button_open2);
		this.add(button_save);
		this.add(button_process);
		this.add(button_about);
		
		canvas = new Canvas(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 5500715383718362373L;

			public void paint(Graphics g){
				g.drawImage(image, 0, 0, null);
			}
		};
		canvas.setBackground(Color.black);
		canvas.setSize(256, 256);
		canvas.setVisible(true);
		
		this.add(canvas);
		
		buttons_control[0] = new JButton("脭颅脥录脧帽");
		buttons_control[0].setSize(128, 25);
		buttons_control[0].setLocation(0, 256);
		
		buttons_control[1] = new JButton("碌脴脥录");
		buttons_control[1].setSize(128, 25);
		buttons_control[1].setLocation(128, 256);
		
		buttons_control[2] = new JButton("赂脽露脠脥录脧帽");
		buttons_control[2].setSize(128, 25);
		buttons_control[2].setLocation(0, 281);
		
		buttons_control[3] = new JButton("赂脽露脠碌脴脥录");
		buttons_control[3].setSize(128, 25);
		buttons_control[3].setLocation(128, 281);
		
		this.add(buttons_control[0]);
		this.add(buttons_control[1]);
		this.add(buttons_control[2]);
		this.add(buttons_control[3]);
		
		buttons_control[4]=buttonSet("脳贸脳陋", 85, 25, 0, 306);
		buttons_control[6]=buttonSet("脫脪脳陋", 85, 25, 171, 306);
		buttons_control[5]=buttonSet("脳陋脰脙", 86, 25, 85, 306);
		
		// To prevent compoments from enlarge
		add(nullbutton);
		nullbutton.setVisible(false);
		
	}
	
	public void center(){
		Dimension sd = Toolkit.getDefaultToolkit().getScreenSize();
		int width = sd.width;
		int height = sd.height;
		
		setLocation((width - this.getWidth())/2, (height-this.getHeight())/2);
	}

	public void repaintCanvas(){
		canvas.repaint();
	}
	public void setImage(BufferedImage image){
		this.image = image;
		canvas.repaint();
	}
	
	public JButton buttonSet(String label, int w, int h, int x, int y){
		JButton button = new JButton(label);
		button.setSize(w, h);
		button.setLocation(x, y);
		this.add(button);
		return button;
	}
	
	File tempfile;
	public void setDirectory(String path, int type){
		tempfile = new File(path);
		try{
			if (type == 1)
				chooser1.setCurrentDirectory(tempfile);
			else if (type == 2)
				chooser2.setCurrentDirectory(tempfile);
		}catch(ArrayIndexOutOfBoundsException e){
			return;
		}catch(NullPointerException e){
			return;
		}
	}
	public void setDirectory(File file, int type){
		if (type == 1)
			chooser1.setCurrentDirectory(file);
		else if (type == 2)
			chooser2.setCurrentDirectory(file);
	}
}
