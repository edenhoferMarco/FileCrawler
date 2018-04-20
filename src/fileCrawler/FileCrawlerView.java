package fileCrawler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FileCrawlerView extends JFrame {
	private JLabel rootDirLabel = new JLabel("Start directory for filesearch: ");
	private JTextField rootDirText = new JTextField();
	private JButton browseButton = new JButton("Browse...");
	private JButton startButton = new JButton("Start");
	private JTextArea outputWindow = new JTextArea();
	private JScrollPane scrollbar = new JScrollPane(outputWindow);
	
	public FileCrawlerView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setSize(300, 600);
		
		rootDirLabel.setBounds(10, 10, 250, 20);
		add(rootDirLabel);
		
		rootDirText.setBounds(10, 40, 280, 20);
		rootDirText.setEditable(false);
		add(rootDirText);
		
		browseButton.setBounds(10, 70, 120, 30);
		browseButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				JFileChooser fc = new JFileChooser();
				fc.setCurrentDirectory(new File("."));
				fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				if (fc.showOpenDialog(FileCrawlerView.this) == JFileChooser.APPROVE_OPTION) {
					rootDirText.setText(fc.getSelectedFile().getPath());
				}
			}
			
		});
		add(browseButton);
		
		startButton.setBounds(170, 70, 120, 30);
		add(startButton);
		
		outputWindow.setEditable(false);
		scrollbar.setBounds(10, 120, 280, 440);
		scrollbar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollbar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollbar);
		
		setVisible(true);
	}
	
	public void addStartListener(ActionListener startListener) {
		startButton.addActionListener(startListener);
	}
	
	public String getRootDirPath() {
		return rootDirText.getText();
	}
	
	public void appendToOutputWindow(String newMsg) {
		outputWindow.append(newMsg +"\n");
	}
}
