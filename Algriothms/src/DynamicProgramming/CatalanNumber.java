package DynamicProgramming;

public class CatalanNumber {
	
	int catalanNumber(int num){ //recursion
		if(num == 0 || num == 1)
			return 1;
		int sum = 0;
		for(int i = 1; i <= num; i++)
			sum += catalanNumber(i-1) * catalanNumber(num-i);
		return sum;
	}
	
	int catalanNumDynamic(int num){ //memorize
		int[] table = new int[num+1];
		table[0] = 1;
		table[1] = 1;
		for (int i = 2; i <= num; i++) {
			for(int j = 0; j < i; j++){
				table[i] += table[j]*table[i-j-1];
			}
		}
		return table[num];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
