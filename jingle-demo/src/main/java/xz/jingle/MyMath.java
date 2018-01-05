package xz.jingle;

//早期作品,编码已损坏
public class MyMath {

	public static void main(String[] args) {
		MyMath m = new MyMath();
//		StringBuilder sb = new StringBuilder(154+"");
//		System.out.println(sb.substring(sb.length()-1));
//		sb.deleteCharAt(sb.length()-1);
//		System.out.println(sb.toString());
//		m.daffodilNum(0,9999999);
//		String str = "0123456789";
		//substring��ȡ���ַ�������begin��������end���ַ���Ϊbegin-end
//		System.out.println(str.substring(1));
//		System.out.println(str.substring(5, 7));
//		System.out.println(m.printFactorNumByRecursion(6255));
//		m.conmmonSubmultiple(17*7*3, 17*11*2);
//		m.conmmonMultiple(35, 25);
//		m.countCharacter("aaabbAAABB111222");
		System.out.println(m.sumNums(3, 3));
	}
	/**
	 * ���ص�idx��쳲��������������idx�������õ����ķ�ʽ
	 */
	public int printNatureSeriesByLoop(int idx){
		int num1=0,num2=1,num3=1;
		for (int i = 0; i < idx; i++) {
			System.out.print(num3+"\t");
			num3 = num1+num2;
			num1 = num2;
			num2 = num3;
		}
		return num3;
	}
	/**
	 * ���ص�idx��쳲��������������idx�������õݹ�ķ�ʽ
	 */
	public int printNatureSeriesByRecursion(int idx){
		if(idx <= 2 ){
			return 1;
		}else{
			return printNatureSeriesByRecursion(idx-1)+printNatureSeriesByRecursion(idx-2);
		}
		
	}
	/**
	 *  �ж��Ƿ�Ϊ����
	 */
	public boolean isPrimeNum(int num){
		//i < num/2����Ȼ���������ڱ�����һ��Ļ�������������
		for (int i = 2; i <= num/2; i++) {
			if(num%i==0){
//				System.out.println("������"+i);
				return false;
			}
		}
		return true;
	}
	/**
	 * ��ӡ��begin��end֮�������
	 */
	public int printPrimeNum(int begin,int end){
		int count = 0;
		for (int i = begin; i < end; i++) {
			if(isPrimeNum(i)){
				System.out.print(i+"\t");
				count++;
			}
		}
		return count;
	}
	//����
	private int cube(int num){
		return num*num*num;
	}
	/**
	 * ˮ�ɻ���
	 */
	public void daffodilNum(int begin,int end){
		for(int i = begin; i < end; i++) {
			int sum = 0;
			//ˮ�ɻ�����ָ��λ����������չ��sb��û��ʲô��
//			StringBuilder sb = new StringBuilder(i+"");
//			while(sb.length()>0){
//				sum = sum + cube(Integer.parseInt(sb.substring(sb.length()-1)));
//				sb.deleteCharAt(sb.length()-1);
//			}
			int num1 = cube(i/100);
			int num2 = cube((i%100)/10);
			int num3 = cube(i%10);
			sum = num1+num2+num3;
			if(i==sum){
				System.out.println(i);
			}
		}
	}
	/**
	 * ��ʽ�ֽ⣬����
	 */
	public void printFactorNumByLoop(int num){
		int tempNum = num;
		for (int i = 2; i < num; i++) {
			if(tempNum%i==0 ){
				System.out.println(i);
				tempNum = tempNum/i;
				i--;
			}
		}
	}
	/**
	 * ��ʽ�ֽ⣬�ݹ�
	 * @return �����ĺ�
	 */
	public int printFactorNumByRecursion(int num){
		for (int i = 2; i <= num; i++) {
			if(num%i==0 ){
				System.out.println(i);
				//�� printFactorNumByRecursion(num/i)����������ֻ��������������������
				return i + printFactorNumByRecursion(num/i);
			}
		}
		return 0;
	}
	/**
	 * ���Լ��
	 */
	public int conmmonSubmultiple(int num1,int num2){
		int biggestSubmul = 0;
		for (int i = 1; i<=num1 && i<=num2; i++) {
			if(num1%i==0 && num2%i==0){
				biggestSubmul = i;
			}
		}
		System.out.println(biggestSubmul);
		return biggestSubmul;
	}
	/**
	 * ��С������
	 */
	public int conmmonMultiple(int num1,int num2){
		for (int i = (num1>num2?num1:num2);; i++) {
			if(i%num1==0 && i%num2==0){
				System.out.println(i);
				return i;
			}
		}
	}
	/**
	 *	�����ַ����д�дСд��ĸ�Լ����ֵ����� 
	 */
	public void countCharacter(String str){
		int countUpperCh=0,countLowerCh=0,countNum=0;
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i)<='Z' && str.charAt(i)>='A')
				countUpperCh++;
			if(str.charAt(i)<='z' && str.charAt(i)>='a')
				countLowerCh++;
			if(str.charAt(i)<='9' && str.charAt(i)>='0')
				countNum++;
		}
		System.out.println("��д��"+countUpperCh+"Сд��"+countLowerCh+"����"+countNum);
	}
	/**
	 * num*10^inv,Ҫ��inv > 0
	 */
	private int involution(int num,int inv){
		int res = num;
		if(inv<0){
			System.err.println("inv����С����");
			return -1;
		}else{
			for (int i = 1; i < inv; i++) {
				res = res*10;
			}
		}
		
		return res;
	}
	public int sumNums(int num,int times){
		int inv = num;
		int sum = 0;
		int bigSum = 0;
		for (int i = 1; i <=times; i++) {
			inv = inv*10;
			sum = sum + involution(num,i);
			bigSum+=sum;
		}
		System.out.println(bigSum);
		return sum;
	}
}
