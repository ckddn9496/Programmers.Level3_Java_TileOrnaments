public class Main {

	public static void main(String[] args) {
//		int N = 5; // return 26
		int N = 6; // return 42
		
		System.out.println(new Solution().solution(N));
	}

}
class Solution {
    public long solution(int N) {
        /* 필요한 것
         * 1. Fibonacci arrays : F[n] = F[n-1] + F[n-2], (F[0] = 0이라 두자) F[1] = 1, F[2] = 1
         * 2. N = n, return = (F[n-2]+F[n-1])*2 + (F[n-1]+F[n])*2
         * 3. (예외) N = 1, return 1*2 + 1*2 (=4)
         * => int[] F = new int[3] ??
         * 제출 후 수정 
         * 2. N = n, return = (F[n-2]+F[n-1])*2 + (F[n-1]+F[n])*2 => (F[n]*2 + F[n-1])*2 : int[] F = new int[2] 가능
         * */
        
        long[] F = {0, 1}; // F[0], F[1], F[2]  
        
        if (N == 1) {
        	return 4;
        }
        // N = n이면  n-2번 수행 => F[n-2] F[n-1] F[n] 생성
        for (int i = 0; i < N-1; i++) {
        	long nextFn = F[1] + F[0];
        	F[0] = F[1];
        	F[1] = nextFn;
        }
        
        return (F[1]*2 + F[0])*2;
    }
}