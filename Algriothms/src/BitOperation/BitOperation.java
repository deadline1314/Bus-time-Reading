package BitOperation;

public class BitOperation {
	
	//1. check the target position bit is 1 or not
	public boolean getHit(int i, int pos) {
		int mask = 1;
		mask = mask << pos - 1;
		if((i & mask) == 0)
			return false;
		return true;
	}
	
	//2. set the target position bit into 1
	public int setBit(int i, int pos) {
		int mask = 1;
		mask = mask << pos - 1;
		return (i | mask);
	}
	
	//3. clear the rest of the bit to 0 expect the target position
	public int clearBit(int i, int pos) {
		int mask = 1;
		mask = ~(mask << pos - 1);
		return (i & mask);
	}
	
	//4. clear from MSB(Most Significant Bit) to target position
	public int clearMSBToPos(int i, int pos) {
		int mask = 1;
		mask = mask << pos;
		mask--;
		return (i & mask);
	}
	
	//5. clear from LSB(Least Significant Bit) to target position
	public int clearLSBToPos(int i, int pos) {
		int mask = 1;
		mask = (~0) - ((mask << pos) - 1);
		return (i & mask);
	}
	
	//6. replace the target bits from position high to position low into temp
	public int replaceBits(int target, int temp, int high, int low) {
		int left = (~0) - ((1 << high) - 1);
		int right = (1 << low) - 1;
		int mask = left | right;
		return ((target & mask) | (temp << low));
	}
	
	//7. count the number of bits which have been set
	public int countSetBits(int num) {
		int count = 0;
		while(num > 0) {
			if(num % 2 != 0)
				count++;
			num >>>= 1; //must be >>>, >>> is logical shift right
		}
		return count;
	}
	
	//8. get the bit value in the even position
	public int getEvenPos(int num) {
		return (num & 0xAAAAAAAA);
	}
	
	//9. get the bit value in the odd position
	public int getOddPos(int num) {
		return (num & 0x55555555);
	}
	
	//10. swap the bit value between the odd position and even position
	public int swapBitValue(int num) {
		return (((num & 0xAAAAAAAA) >>> 1) | ((num & 0x55555555) << 1));
	}
	
	//11. multiple by 7
	public int multipleBy7(int num) {
		return num << 3 - num;
	}
	
	//12. multiple by 3.5
	public int multipleBy3half(int num) {
		return num << 1 + num + num >> 1;
	}
	
	//13. multiple by 7/8
	public int multipleBy7Of8(int num) {
		return num - num >> 3;
	}
	
	//14. check big endian or little endian
	//true -> little endian, false -> big endian
	public boolean checkEndianess(){
		int val = 1;
		char c = (char)val;
		return c == 1;
	}
	
	//15. only leave big endian of a number
	public int leaveBigEndian(int num) {
		return num & (num - 1);
	}
	
	//16. check a number is a power of 2
	public boolean powerOf2(int num) {
		while(num != 1) {
			if((num & 1) == 1)
				return false;
			num >>>= 1;
		}
		return true;
	}
	
	//17. count digit of a number
	public int countDigit(int num) {
		int count = 0;
		while(num != 0) {
			num >>>= 1;
			count++;
		}
		return count;
	}
	
	//18. left rotate when left shift making the big endian erase
	public int leftRotate(int num, int d) {
		int max = 32;
		return (num << d) | (num >>> (max - d));
	}
	
	//19. swap value between two numbers without extra space;
	public void swapValue(int x, int y) {
		x = x ^ y;
		y = y ^ x;
		x = x ^ y;
	}

	public static void main(String[] args) {
		BitOperation bo = new BitOperation();
		System.out.println(bo.checkEndianess()); //true -> little endian
	}

}
