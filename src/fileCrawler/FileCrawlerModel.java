package fileCrawler;

import java.util.List;
import java.io.File;
import java.util.ArrayList;

public class FileCrawlerModel {
	private List<String> filePaths = new ArrayList<String>();
	
	
	void findFiles(File file, String fileType) {
		if (file.isFile() && file.getName().endsWith(fileType)) {
			filePaths.add(file.getAbsolutePath());
			
			return;
		}
		if (!file.isDirectory() || file.listFiles() == null) {
			return;
		}
		for (File subfile : file.listFiles()) {
			findFiles(subfile, fileType);
		}
	}
	
	public List<String> getFilePaths() {
		return filePaths;
	}

}
