package triangle;

public class triCalculate {
	
	private int num_50 = 1,num_20 = 1,num_5 = 2,num_1 = 3;
	//���ֳ�Ʊ��������ʹ������п�������
	private int numOfall = num_50 * 50 + num_20 * 20 + num_5 * 5 + num_1 * 1;
	//���г�Ʊ��ֵ�ܺ�
	public int triangle(int x) {
		if (x > numOfall) {
			return 0;
		}
		//��������ֵ�����ܺ���ֱ���ж�Ϊʧ��
		while (num_50 > 0) {
			if (x >= 50) {
				x = x - 50;
			}
			num_50--;
		}
		while (num_20 > 0) {
			if (x >= 20) {
				x = x - 20;
			}
			num_20--;
		}
		while (num_5 > 0) {
			if (x >= 5) {
				x = x - 5;
			}
			num_5--;
		}
		while (num_1 > 0) {
			if (x >= 1) {
				x = x - 1;
			}
			num_1--;
		}
		if (x == 0) {
			return 1;
		}
		return 0;
		//��δ��ǡ���ó���Ӧ��Ʊ����ʧ��
	}
	

}
