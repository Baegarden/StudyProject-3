import java.util.Scanner;

public class MainApp {
	public static void main(String[] args) throws InterruptedException {		
		Scanner keyword = new Scanner(System.in);
		Scanner search = new Scanner(System.in);
		Scanner n = new Scanner(System.in);

		System.out.println("�˻��� �Է�");		
		String KEY_WORD = keyword.nextLine();;
		System.out.println("Ű���� �Է�");
		String Search = search.nextLine();
		
		myThread[] mt = new myThread[40];
		
	    for(int i = 0 ; i < 40 ; i++)
	    {
	    	mt[i] = new myThread(KEY_WORD, Search, i);
	        mt[i].start();
	        mt[i].join();
	    }    
	    System.out.println("ũ�Ѹ��� �Ϸ��Ͽ����ϴ�.");		
		
		String N = n.nextLine();
	}		
}
