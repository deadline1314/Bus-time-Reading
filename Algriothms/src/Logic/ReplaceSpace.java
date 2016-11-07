package Logic;

public class ReplaceSpace {
	
	public void replaceSpace(char[] str, int length) {
		int spaceCount = 0;
		for(int i = 0; i < length; i++){
			if(str[i] == ' ')
				spaceCount++;
		}
		
		int newLength = length + spaceCount * 2;
		char[] str1 = new char[newLength];
		//str[newLength] = '\0';
		for(int i = length - 1; i >= 0; i--){
			if(str[i] == ' '){
				str1[newLength - 1] = '%';
				str1[newLength - 2] = '0';
				str1[newLength - 3] = '2';
				newLength -= 3;
			}else{
				str1[newLength - 1] = str[i];
				newLength--;
			}	
		}
		for(int i = 0; i < length + spaceCount * 2; i++)
			System.out.print(str1[i]+ " ");
	}

	public static void main(String[] args) {
		ReplaceSpace rs = new ReplaceSpace();
		
		char[] str = {'a', ' ', 'b'};
		int length = 3;
		rs.replaceSpace(str, length);
	}

}
