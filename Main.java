import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.nio.Buffer;
import java.util.Stack;

//import jdk.internal.org.jline.utils.InputStreamReader;

/**
 * Main
 */
public class Main {

    public static int priority(char temp) {

        switch (temp) {
            case '-':
                return 1 ;
            case '+':
                return 1 ;
                
            case '*':
                return 2 ;
            case '/':
                return 2 ;

            case '^':
                return 3 ;
        }

        return -1 ;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in)) ;
        String str = read.readLine();

        String result = new String("") ;
        Stack<Character> st = new Stack<>() ;
        for(int i=0; i<str.length(); i++) {
            char temp = str.charAt(i) ;

            if(Character.isLetterOrDigit(temp)) {
                result += temp ;
            }
            else if (temp == '(') {
                st.push(temp) ;
            }
            else if (temp == ')') {
                while (st.isEmpty() == false && st.peek() != '(') {
                    result += st.pop() ;
                    //'st.pop() ;
                }
                st.pop() ;
            }
            else {
                while (st.isEmpty() == false && priority(st.peek()) >= priority(temp)) {
                    result += st.pop() ;
                }
                st.push(temp) ;
            }
        }

        while (st.isEmpty() == false) {
            result += st.pop() ;      
        }

        System.out.println(result);

    }
}