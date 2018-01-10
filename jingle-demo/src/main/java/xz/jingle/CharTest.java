package xz.jingle;

/**
 * Created by admin on 2018/1/10.
 * char使用unicode编码，以下可证明。下面是unicode与中文，英文的一段对应
 * 4E00	一	丁	丂	七	丄	丅	丆	万	丈	三	上	下	丌	不	与	丏	丐	丑	丒	专	且	丕	世	丗	丘	丙	业	丛
 * 0060	`	a	b	c	d	e	f	g	h	i	j	k	l	m	n	o	p	q	r	s	t	u	v	w	x	y	z	{}
 */
public class CharTest {
    public static void main(String[] args) {
        char c = '一';
        char b = 'a';
        System.out.println((int)b);
        System.out.println((int)c);
        System.out.println(Integer.toHexString(b));
        System.out.println(Integer.toHexString(c));
        System.out.println(Integer.parseInt("4e00",16));
    }
}
