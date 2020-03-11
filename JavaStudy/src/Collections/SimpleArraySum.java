package Collections;

import java.util.Arrays;

public class SimpleArraySum {
	
//static int simpleArraySum1 (int[] ar) {
//		int a = 0;
//		
//		for(int r : ar) {
//			a += ar[r];
//		}
//	return a;
//}
//
//	private static final Scanner scanner = new Scanner(System.in);
//	
//	public static void main(String[] args) throws IOException {
//		// TODO Auto-generated method stub
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int arCount = Integer.parseInt(scanner.nextLine().trim());
//
//        int[] ar = new int[arCount];
//
//        String[] arItems = scanner.nextLine().split(" ");
//
//        for (int arItr = 0; arItr < arCount; arItr++) {
//            int arItem = Integer.parseInt(arItems[arItr].trim());
//            ar[arItr] = arItem;
//        }
//
//        int result = simpleArraySum1(ar);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//	}
	/*
	static void solution(String [] participant, String[] completion) {
		System.out.println("테스트 시작"+participant.length);
		String answer="";
		
		for(int i=0;i<participant.length;i++) {
			boolean flag = true;
			for(int j=0; j<completion.length;j++) {
				if(participant[i].equals(completion[j])) {
					completion[j]=null;
					flag = false;
					
					System.out.println("배열 길이 확인" + completion.length);
					break;
				}
				
				
//				else{
//					j++;
//					if(j>=completion.length) {
//						System.out.println("j확인"+j);
//					answer = participant[i];
//					}
//				}
			}
			if(flag) {
				answer +=participant[i];
			}
		}
		System.out.println("확인"+answer);
	}
	
	*/
	static public String array(String [] participant, String completion[]) {
		Arrays.sort(participant);
		Arrays.sort(completion);
		String answer;
		
		for(int a=0; a<participant.length;a++) {
		System.out.print("확인 테스트 : " +participant[a]+"  ");
		}
		System.out.println();
		for(int a=0; a<completion.length;a++) {
			System.out.print("확인 테스트 : " +completion[a]+"  ");
		}
		System.out.println();
		int i;
		for(i=0; i<completion.length;i++) {
			if(!participant[i].equals(completion[i])) {
				return participant[i];
			}
		}
		return participant[i];
		
	}
	
	public static void main(String[] args) {
		
			String [] participant = {"mislav", "stanko", "mislav", "ana"};
			String [] completion = {"stanko", "ana", "mislav"};
//			solution(participant, completion);
			String a = array(participant, completion);
			System.out.println("확인.."+a);
		}
	}
