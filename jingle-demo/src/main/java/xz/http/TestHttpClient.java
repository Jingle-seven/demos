package xz.http;

import java.util.*;

public class TestHttpClient {

	public static void main(String[] args) throws InterruptedException {
		String idStr = "121542338";
		int id = 121542301;
		List<ThreadGroup> tgList = new ArrayList<ThreadGroup>();
		//55��ѧ��
		for (int i = 3; i < 55; i++) {
			
			ThreadGroup tg = new ThreadGroup("tg_"+i);
			tgList.add(tg);
			//12����
			for (int j = 1; j <=12; j++) {
				Runnable r = new MyHttpClient((id+i)+"",j);
				new Thread(tg,r).start();
				System.out.println(tg.activeCount());
				if(tg.activeCount()!=12){
					
				}
			}
		}
		
//		while(true){
//			Thread.sleep(10*1000);
//			for (int i = 0; i < tgList.size(); i++) {
//				ThreadGroup thg = tgList.get(i);
//				if(thg.activeCount()<12){
//					thg.interrupt();
//					System.out.println("hg.activeCount()"+thg.activeCount());
//					System.out.println(thg.getName()+"�Ѿ��˳�");
//					tgList.remove(i);
//				}
//			}
//		}
	}
}
