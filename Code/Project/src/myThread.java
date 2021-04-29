import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class myThread extends Thread {

	String URL = "http://www.jobkorea.co.kr/Search/?";
	String KEY_WORD;
	String Search;
	int i, count = 0, idx = 0;
	
	public myThread(String kew_word, String search, int i1) {
		KEY_WORD = kew_word;
		Search = search;
		i = i1 + 1;
	}
	
	public void run() {
		System.out.println("< " + i + "Page >\n\n");
		
		//1. Document�� �����´�.
		Document doc = null;		
		try {
			doc = Jsoup.connect(URL + getParameter(KEY_WORD, i)).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//2. ����� �����´�.
		Elements elements = doc.select(".recruit-info .list-default .post");
		
		//3. ���(�迭)���� ������ �����´�.
		for(Element element : elements)
		{
			System.out.println(idx +1 + " : " + element.select(".post-list-corp a").text());	// ��� �̸� ���
			System.out.println(element.select(".post-list-info a").text());		
			System.out.println(element.select(".post-list-info p").not(".etc").text());		
			System.out.println(element.select(".post-list-info p").not(".option").text()); 

			if(element.text().contains(Search))
			{
				System.out.println("URL" + " : " + element.select("a").attr("abs:href")); // 
				System.out.println("================================================================"
						+ "========================================================================================================\n\n");
				count++;
			}
			else
				System.out.println("================================================================"
						+ "========================================================================================================\n\n");
			idx++;
		}
		System.out.println("'" + Search + "'" + "��(��) �����ϴ� ä������� ���� : " + count +"�� �Դϴ�.\n\n");
	}
	
	public String getParameter(String KEY_WORD, int PAGE) {
		return "stext=" + KEY_WORD + ""
				      + "&tabType=recruit"				   
				      + "&Page_No=" + PAGE + "";
	}
			
}
