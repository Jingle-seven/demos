package com.xz.designPattern;

/**
 * Created by Jinhua on 2016/10/25.
 */
public class AdapterDemo {
	public static void main(String[] args) {
		Iphone7 iphone7  = new Iphone7();
		EarPhone35mm earPhone35mm = new EarPhone35mm();
		Earphone adpt = new EarPhoneAdapter();
		
		adpt.setEarPhone(earPhone35mm);//将耳机接上适配器
		iphone7.playMusic(adpt);//将适配器插到手机上并且播放音乐
	}
}

class Iphone7{
	public void playMusic(){System.out.println("well you done done me...");}
	public void playMusic(Earphone earphone){earphone.acceptAudio("well you done done me...");}
}

//耳机
class EarPhone35mm{
	public void playWith35(String song) {System.out.println("EarPhone35mm playing: "+song);}
}

//适配器接口
interface Earphone{
	void setEarPhone(EarPhone35mm earPhone);
	void acceptAudio(String song);
}

//3.5mm耳机适配器
class EarPhoneAdapter implements Earphone{
	EarPhone35mm earPhone;
	public void setEarPhone(EarPhone35mm earPhone){this.earPhone = earPhone;};
	public void acceptAudio(String song) {earPhone.playWith35(song);}
}