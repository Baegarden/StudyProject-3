import java.util.Scanner;

public class MainApp {
	public static void main(String[] args) throws InterruptedException {		
		Scanner keyword = new Scanner(System.in);
		Scanner search = new Scanner(System.in);
		Scanner n = new Scanner(System.in);

		System.out.println("검색어 입력");		
		String KEY_WORD = keyword.nextLine();;
		System.out.println("키워드 입력");
		String Search = search.nextLine();
		
		myThread[] mt = new myThread[40];
		
	    for(int i = 0 ; i < 40 ; i++)
	    {
	    	mt[i] = new myThread(KEY_WORD, Search, i);
	        mt[i].start();
	        mt[i].join();
	    }    
	    System.out.println("크롤링을 완료하였습니다.");		
		
		String N = n.nextLine();
	}		
}
