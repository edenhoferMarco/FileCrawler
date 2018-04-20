package fileCrawler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FileCrawlerController {
	FileCrawlerModel model;
	FileCrawlerView view;
	String rootFilePath;
	
	public FileCrawlerController(FileCrawlerModel model, FileCrawlerView view) {
		this.model = model;
		this.view = view;
		
		this.view.addStartListener(new StartListener());
	}
	
	private class StartListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			view.appendToOutputWindow("Start FileSearch...\n");
			rootFilePath = view.getRootDirPath();
			model.findFiles(new File(rootFilePath), ".c");
			
			for (String path : model.getFilePaths()) {
				view.appendToOutputWindow(path);
			}
		}
		
	}
	
}
