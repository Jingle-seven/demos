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
        System.out.println(Integer.parseInt("2CEA1",16));
        System.out.println(Integer.parseInt("4E00",16));
    }
}
/*
 汉字有的超过65535，有的不超过，所以有的用两个字节表示，有的用三个(对应utf-8三个字节，四个字节)
 unicode中汉字占据的部分：CJK中日韩统一汉字编码字符集
 基本区　　　　　4E00-9FA5　　　　共20902字
 扩展A区 　　　　3400-4DB5　　　　共6582字
 扩展B区　　　　20000-2A6D6　　　共42711字
 基本区补充　　　9FA6-9FCB　　　 共38字
 扩展C区　　　　2A700-2B734　　　共4149字
 扩展D区　　　　2B740-2B81D　　　共222字
 扩展E区　　　　2B820-2CEA1　　　共5762字
 康熙部首　　　　2F00-2FD5　　　　共214字
 部首扩展　　　　2E80-2EF3　　　　共115字
 兼容汉字　　　　F900-FAD9　　　　共477字
 兼容扩展 　　　2F800-2FA1D　　　共542字
 PUA(GBK)部件 　E815-E86F　　　　共81字
 部件扩展　　　　E400-E5E8　　　　共452字
 PUA增补　　　　E600-E6CF　　　　共207字
 汉字笔画　　　　31C0-31E3　　　　共36字

 汉语注音　　　　3105-3120　　　　共22字
 注音扩展　　　　31A0-31BA　　　　共22字

 下表总结了编码规则，字母x表示可用编码的位。
 Unicode符号范围     |        UTF-8编码方式
 (十六进制)        |              （二进制）
 ----------------------+---------------------------------------------
 0000 0000-0000 007F | 0xxxxxxx
 0000 0080-0000 07FF | 110xxxxx 10xxxxxx
 0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
 0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
 跟据上表，解读 UTF-8 编码非常简单。如果一个字节的第一位是0，则这个字节单独就是一个字符；如果第一位是1，
 则连续有多少个1，就表示当前字符占用多少个字节。（所以存储汉字要多一个字节表示占用多少个字节）
* */