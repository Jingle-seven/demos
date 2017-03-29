package xz.jingle;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Jinhua on 2016/8/25.
 */
public class MapTest {
	public static void main(String[] args) {
		Map<String,Integer> resMap = new HashMap<>();
		resMap.put("job_total_num",0);
		resMap.put("job_critical_num",0);
		resMap.put("job_severe_num",0);
		resMap.put("job_moderate_num",0);
		resMap.put("job_normal_num",0);
		resMap.put("job_measure_num",0);
		resMap.put("user_num",0);
		
		resMap.put("job_total_num",resMap.get("job_total_num")+10);
		resMap.put("job_total_num",resMap.get("job_total_num")+10);
		
//		System.out.println(resMap.get("job_total_num"));
		Long  stampNow= System.currentTimeMillis();
		Long startTime  = stampNow/(1000*3600*24)*(1000*3600*24);
//		System.out.println(stampNow-startTime);
		
		//ConcurrentModificationException
//		for(Map.Entry<String,Integer> en: resMap.entrySet()){
//			if("job_total_num".equals(en.getKey()))
//				resMap.remove(en.getKey());
//		}
//		for(String k: resMap.keySet()){
//			if("job_total_num".equals(k));
//				resMap.remove(k);
//		}
		Iterator<String> it = resMap.keySet().iterator();
		while(it.hasNext()){
			String k = it.next();
			if("job_total_num".equals(k))
				it.remove();
		}
		System.out.println(resMap);
		resMap.remove("hahaha");
	}
}
