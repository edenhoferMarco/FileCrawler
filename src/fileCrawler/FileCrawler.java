package fileCrawler;

public class FileCrawler {

	public static void main(String[] args) {
		FileCrawlerView view = new FileCrawlerView();
		FileCrawlerModel model = new FileCrawlerModel();
		FileCrawlerController controller = new FileCrawlerController(model, view);

	}

}
