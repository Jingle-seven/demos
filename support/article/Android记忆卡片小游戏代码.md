## Android记忆卡片小游戏代码  

概述：游戏共有五个关卡，每个关卡出现不同数量的卡片，每一关的图片来自不同的图片库，从图片库中随机抽取一定数量的图片进行游戏，图片成对出现。游戏开始时所有的卡片显示为反面，用户随意点击翻转一张卡片，再翻转另一张卡片，如果翻出卡片图案相同，这两张卡片会消去；如果不相同，两张卡片会重新显示为反面。在所有卡片都被消去或者超过限定时间后，会弹出窗口提示进入下一关、重新开始或者退出。

因为懒，没怎么写注释。共用到四个类，主界面activity类、游戏界面activity类、BaseAdapter适配器适配游戏界面、自定义的util工具类。主要涉及的知识点有activity间跳转、SharedPreferences简单数据存取、隐式意图、AlertDialog.Builder弹出式窗口、获取设备宽高、GridView适配器、线程通过Handler向UI线程发送消息、Timer和TimerTask时间调度。不知道为什么代码会写得这么复杂，有不妥之处还恳请指出。

下面是代码，不久前写的：

1.主界面
```
package com.memorycard;
import com.tools.InitUtils;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class IndexActivity extends Activity implements OnClickListener {

	Intent intent;
	InitUtils util;
	SharedPreferences pf;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_index);
		pf = PreferenceManager.getDefaultSharedPreferences(this);
		util = new InitUtils(this);

//		设置开始游戏按钮的弹出列表（匿名内部类监听事件）
		findViewById(R.id.bt_start).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				AlertDialog.Builder myBuilder = new Builder(IndexActivity.this);
				myBuilder.setItems("第一关，第二关，第三关，第四关，第五关".split("，"),
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,int which) {
								
								util.startGame(which);
							}
						});
				myBuilder.create().show();
			}
		});

//		匿名内部类监听事件
		findViewById(R.id.bt_setting).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				util.showToast("功能不可用");
			}
		});
		findViewById(R.id.bt_score).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				util.showToast("你有"+pf.getInt("historySco", 0)+"分");
			}
		});
		findViewById(R.id.bt_about).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				AlertDialog.Builder myBuilder = new Builder(IndexActivity.this);
				myBuilder.setMessage("每个关卡有不同的图片库\n每次游戏从图片库中选取部分图片进行游戏");
				myBuilder.setNegativeButton("哦", null);
				myBuilder.create().show();
			}
		});
//		设置监听者为本activity
		findViewById(R.id.bt_alipay).setOnClickListener(this);


	}
//	activity类监听，根据事件源id不同选择行为
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt_start:

			break;
		case R.id.bt_setting:
			break;
		case R.id.bt_alipay:
			intent = new Intent(Intent.ACTION_SENDTO);
			intent.setData(Uri.parse("smsto:13631435802"));
			intent.putExtra("sms_body",
					"十分感谢你的游戏，我将往你的支付宝账号（13631435802）转入赞助资金100元");
			break;
		case R.id.bt_about:
//			隐士意图访问网页，原本是按钮“关于玩法”的事件
			intent = new Intent(Intent.ACTION_VIEW);
			intent.setData(Uri
					.parse("http://http://weibo.com/3108157575/AyQbdbUKz"));
			break;
		case R.id.bt_score:
			
			break;
		default:
			break;
		}
		startActivity(intent);
	}
}

```
2.工具类
```
package com.tools;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import com.memorycard.GameActivity;
import com.memorycard.IndexActivity;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class InitUtils {

	Context context;
	
	public InitUtils(Context context) {
		super();
		this.context = context;
	}
		//根据list获取随机子list
		public List getRandListFrom(List oldList,int length){
			
			Random rand = new Random();
			List randList = new ArrayList();
			for (int i = 0; i < length; i++) {
				int rmIndex = rand.nextInt(oldList.size());
				randList.add(oldList.remove(rmIndex));
			}
			return randList;
		}
		//将list元素加倍并打乱
		public void doubleAndshuffle(List list){
			int size = list.size();
			for (int i = 0; i < size; i++) {
				list.add(list.get(i));
			}
			Collections.shuffle(list);
		}
		public void exit(){
			//第一种
			Intent i = new Intent(Intent.ACTION_MAIN);
			i.addCategory(Intent.CATEGORY_HOME);
			i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(i);
			System.exit(0);
			//第二种
			//context.sendBroadcast(new Intent().setAction("ExitApp"));
			//((Activity) context).finish();
		}
		
		/**
		 * 全屏显示
		 */
		public void fullscreenShow(){
			// 隐藏标题
			((Activity) context).requestWindowFeature(Window.FEATURE_NO_TITLE);
			// 全屏显示
			((Activity) context).getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 0x400);
		}
		
		/**
		 * 弹出消息提示
		 * @param str 提示内容
		 */
		public void showToast(String msg){
			Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
		}
		
		public Intent setLevelPara(Intent gameIntent,int level,int colCount,int rowCount,int timeOut,
				int photoCount,String photoGroup){
			
			gameIntent.putExtra("level", level);
			gameIntent.putExtra("colCount", colCount);
			gameIntent.putExtra("rowCount", rowCount);
			gameIntent.putExtra("timeOut", timeOut);
			gameIntent.putExtra("photoCount",photoCount);
			gameIntent.putExtra("photoGroup", photoGroup);
			
			return gameIntent;
		}
		public void startGame(int level){
			Intent gameIntent = new Intent(context,GameActivity.class);
			switch (level) {
			case 0:
				//五个参数代表行数、列数、限时、图片库图片数量、图片库名称
				setLevelPara(gameIntent,level,3, 2, 10, 13, "00");
				break;
			case 1:
				setLevelPara(gameIntent,level,3, 4, 20, 14, "01");
				break;
			case 2:
				setLevelPara(gameIntent,level,4, 4, 40, 19, "02");
				break;
			case 3:
				setLevelPara(gameIntent,level,4, 5, 50, 45, "03");
				break;
			case 4:
				setLevelPara(gameIntent,level,5, 8, 90, 22, "04");
				break;
			default:
				break;
			}
			context.startActivity(gameIntent);
		}
}
```

3.游戏类
```
package com.memorycard;

import java.util.*;
import java.util.prefs.Preferences;
import com.tools.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.*;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;

public class GameActivity extends Activity implements OnItemClickListener {

	GridView gv_imgs;
	TextView tv_timeUsed,tv_score;
	InitUtils util;
	AlertDialog.Builder gameCompBudr,timeOutBudr;

	public int imgWidth,imgHeight;
	Handler handler;
	List<Integer> imgIdList;
	boolean clicked = false;
	int firstPosition,currentPosition;
	int score = 0,tryCount = 0;
	int photoNum;
	int timeOut;
	Timer timer;
	TimerTask tmtx;
	int level;
	int historySco;
	SharedPreferences pf;

	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
		setContentView(R.layout.activity_game);
		pf = PreferenceManager.getDefaultSharedPreferences(this);
		
//		获得设备宽高第一步
		WindowManager windowManager = (WindowManager) this  
                .getSystemService(this.WINDOW_SERVICE); 
		Display display = windowManager.getDefaultDisplay();  
//		getRealMetrics方法支持最小api17，目前是14，所以用过时方法代替
//		DisplayMetrics  dm = new DisplayMetrics();
//		display.getRealMetrics(dm);
//		devWidth = dm.heightPixels;
//		devHeight = dm.widthPixels;
		
		
		imgIdList = new ArrayList<Integer>();
		tv_score = (TextView) findViewById(R.id.tv_score);
		tv_timeUsed = (TextView) findViewById(R.id.tv_timeUsed);
		gv_imgs = (GridView) findViewById(R.id.gv_imgs);
		util = new InitUtils(this);
		gameCompBudr = new Builder(this);
		timeOutBudr = new Builder(this);
		timer = new Timer();
		historySco = pf.getInt("historySco", 0);

//		获得上个activity传来的行列数、照片数量、照片组名
		Intent gameIntent = getIntent();
		int colCount = gameIntent.getIntExtra("colCount", 3);
		int rowCount = gameIntent.getIntExtra("rowCount", 2);
		int photoCount = gameIntent.getIntExtra("photoCount", 9);
		String photoGroup = gameIntent.getStringExtra("photoGroup");
		timeOut = gameIntent.getIntExtra("timeOut", 20);
		level = gameIntent.getIntExtra("level", 0);
//		获取当前组名第一张相片的id
		int imgId = getResources().getIdentifier("photo_" + photoGroup + "_0",
				"drawable", getPackageName());
		photoNum = colCount * rowCount;
		gv_imgs.setNumColumns(colCount);
		imgWidth = display.getWidth()/colCount;  
		imgHeight = display.getHeight()/colCount; 

//		所有的图片（list内图片唯一）、背面图片
		List<Integer> singleImgIdList = new ArrayList<Integer>();
		List<Integer> face = new ArrayList<Integer>();
		for (int i = 0; i < photoCount; i++) {
			singleImgIdList.add(imgId + i);
		}

		for (int i = 0; i < photoNum; i++) {
			
			face.add(R.drawable.face_3);
		}
//		从所有图片中随机获取当前ListView的子项数量一半的图片
		imgIdList = util.getRandListFrom(singleImgIdList,photoNum/2);
		util.doubleAndshuffle(imgIdList);
		Collections.shuffle(face);
		gv_imgs.setAdapter(new ImgAdapter(this, face));
		gv_imgs.setOnItemClickListener(this);
		

//		处理点击事件线程传来的消息
		handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {

					switch (msg.what) {
					case 0://第一次点击

						//Log.w("xzdb", "currentPosition:" + msg.arg1);
						((ImageView) gv_imgs.getChildAt(msg.arg1))
								.setImageResource(imgIdList.get(msg.arg1));
						break;
					case 1://匹配成功
						gv_imgs.getChildAt(msg.arg1).setVisibility(View.GONE);
						gv_imgs.getChildAt(msg.arg2).setVisibility(View.GONE);

						if (++score == photoNum / 2){
							timer.cancel();
							pf.edit().putInt("historySco", historySco + score).commit();
							AlertDialog ad = gameCompBudr.create();
							ad.setCanceledOnTouchOutside(false);
							ad.setCancelable(false);
							ad.show();
						}
						break;
					case 2://匹配失败
						((ImageView) gv_imgs.getChildAt(msg.arg1))
								.setImageResource(R.drawable.face_3);
						((ImageView) gv_imgs.getChildAt(msg.arg2))
								.setImageResource(R.drawable.face_3);
						break;
					case 3://第二次点击，在sleep前将firstPosition归位
						firstPosition = -1;
						clicked = false;
						tryCount++;
						//Log.w("xzdb", "cP:" + msg.arg1+" fP:"+msg.arg2);
						break;
					case 4:
//						Log.w("xzdb", "time:" + msg.arg1);
						tv_timeUsed.setText(""+msg.arg1);
						if(msg.arg1<=0){
							timer.cancel();
							AlertDialog ad = timeOutBudr.create();
							ad.setCanceledOnTouchOutside(false);
							ad.setCancelable(false);
							ad.show();
						}
						break;
					default:
						break;
					}
					tv_score.setText(score+":"+tryCount);
				}
		};
		
		tmtx = new TimerTask() {
			int thrTime = timeOut;
			public void run() {
				--thrTime;
				Message.obtain(handler, 4, thrTime, 0).sendToTarget();
			}
		};
		timer.schedule(tmtx, 0,1000);
		
		gameCompBudr.setMessage("你赢了，现在你想做什么？")
			.setPositiveButton("下一关", 
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,int which) {
							GameActivity.this.finish();
							util.startGame(++level);
						}
				})
			.setNeutralButton("重玩",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,int which) {
							GameActivity.this.finish();
							util.startGame(level);
					}
				})
			.setNegativeButton("返回", 
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,int which) {
							GameActivity.this.finish();
							Intent indexIntent = new Intent(GameActivity.this,IndexActivity.class);
							GameActivity.this.startActivity(indexIntent);
					}
				});
		
		
		timeOutBudr.setTitle("晚安")
		.setMessage("时间不早了，去睡觉")
		.setPositiveButton("嗯，去睡觉", 
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int which) {
						Intent indexIntent = new Intent(GameActivity.this,IndexActivity.class);
						GameActivity.this.startActivity(indexIntent);
				}
			})
		.setNegativeButton("再战五百回合", 
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int which) {
						GameActivity.this.finish();
						util.startGame(level);
				}
			});
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		currentPosition = position;
		new Thread() {
			public void run() {

					 
				Message.obtain(handler, 0, currentPosition, 0).sendToTarget();
				
				if (!clicked) {
					firstPosition = currentPosition;
					clicked = true;
				} else {
//					在睡眠1000ms后，全局变量currentPosition等可能被改变，因此定义了局部变量
					int thrFirPostn = firstPosition;
					int thrCurPostn = currentPosition;
					Message.obtain(handler, 3, thrCurPostn,thrFirPostn).sendToTarget();
					SystemClock.sleep(500);
					
					if ((thrCurPostn!= thrFirPostn)&&
						imgIdList.get(thrCurPostn) == imgIdList.get(thrFirPostn)) {

						Message.obtain(handler, 1, thrCurPostn,thrFirPostn).sendToTarget();
						
					} else {
						Message.obtain(handler, 2, thrCurPostn,thrFirPostn).sendToTarget();
					}
					
				}
			}
			
		}.start();
	}
	
	
}
```

4.适配器类
```
package com.tools;
import java.util.List;
import com.memorycard.GameActivity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImgAdapter extends BaseAdapter {

	// 被适配的数据
	List<Integer> datas = null;
	Context gameAc = null;
	public ImgAdapter(Context ctx, List<Integer> datas) {
		this.datas = datas;
		this.gameAc = ctx;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// 每个格子布局内的图片
		ImageView iv = null;
		// 检查原有View，
		if (convertView != null) {
			// 若果有:强转成ImageView
			iv = (ImageView) convertView;
		} else {
			// 没有
			iv = new ImageView(gameAc);
		}

		// 将gameAc强制转换为GameActivity，访问imgWidth获得图片布局
		int imgWidth = ((GameActivity)gameAc).imgWidth;
		iv.setLayoutParams(new GridView.LayoutParams(imgWidth, imgWidth));
		iv.setPadding(5, 5, 5, 5);
		// 四面自适应
		iv.setScaleType(ImageView.ScaleType.FIT_XY);
		// 加载图片
		iv.setImageResource(datas.get(position));
		return iv;
	}


	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public int getCount() {
		return datas.size();
	}

}
```

图片命名参考下面这个图  
![name](https://github.com/Jingle-seven/demos/blob/master/support/article/img/6630309102677570779.png)   