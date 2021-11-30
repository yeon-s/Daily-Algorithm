package practice;

import javax.sound.midi.Soundbank;

public class nhn {

	public static void main(String[] args) {
		Operation[] operations = new Operation[5];
		
		Integer num = 3;
		
		System.out.println(num);
		int[] arr = new int[5];
		boolean[] list = new boolean[5];
		list[num] = true;
		
		for(int i=0;i<list.length;i++) {
			System.out.println(list[i]);
			
		}
		
		
		

	}
	
	static class Operation{
		OperationType type;
		Integer value;
		public Operation(OperationType type, Integer value) {
			super();
			this.type = type;
			this.value = value;
		}
		
		
	}
	
	private static enum OperationType {
		branch,
		merge;
	}

}
