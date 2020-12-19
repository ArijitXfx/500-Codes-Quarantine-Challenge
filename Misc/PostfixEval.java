import java.util.*;

public class PostfixEval{
	
	public static int operation(int num1, int num2, char op){
		if(op=='+') return num2+num1;
		else if(op=='-') return num2-num1;
		else if(op=='*') return num2*num1;
		else return num2/num1;
	}
	
	public static int solver(String str){
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0;i<str.length();i++){
			if(!Character.isDigit(str.charAt(i))){
				int num1 = stack.pop();
				int num2 = stack.pop();
				stack.push(operation(num1,num2,str.charAt(i)));
			}else{
				stack.push(Character.getNumericValue(str.charAt(i)));
			}
		}
		return stack.pop();
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while(test-->0){
			System.out.println(solver(sc.next()));
		}
		sc.close();
	}
}