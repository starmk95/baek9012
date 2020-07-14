import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        String stringCnt = br.readLine();
        int cnt = Integer.parseInt(stringCnt);
        for(int i=0;i<cnt;i++) {
            Stack<Character> stack = new Stack();
            boolean flag = true;
            String bracket = br.readLine();
            for (int j=0;j<bracket.length();j++) {
                if (bracket.charAt(j) == '(') {
                    stack.push(bracket.charAt(j)); // 열린 괄호 들어올 때는 항상 push
                } else { // ')' 들어올 경우
                    if (stack.empty()) { // stack이 비어있으면 VPS 아님 (stack에는 '('만 들어감)
                        flag = false;
                        break;
                    } else { // stack의 top이 '('일 경우
                        stack.pop();
                    }
                }
            }
            if (flag && stack.empty()) {
                bw.write("YES\n");
                bw.flush();
            } else {
                bw.write("NO\n");
                bw.flush();
            }
        }
        bw.close(); // 버퍼 닫기
    }
}
