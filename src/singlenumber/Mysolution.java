package singlenumber;

public class Mysolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int[] A = new int[] {1,3,5,7,5,3,1};
		counting(A);
		
		A = new int[] {7,3,5,5,3,1,1};
		counting(A);
		
		A = new int[] {1,3,7,7,3,1,5};	
		counting(A);		
		

		A = new int[] {5,3,7,7,3,5,1};	
		counting(A);		

		A = new int[] {120,257,275,231,3,-98,181,-127,80,-37,154,-7,68,201,126,1,271,71,121,-117,-5,387,87,-33,234,-95,340,275,97,37,-109,-86,71,-185,45,-34,315,311,358,163,379,377,273,1,288,185,-60,-135,76,-101,-165,399,149,319,-150,-53,170,95,263,138,369,5,225,126,178,160,278,300,142,-63,-110,62,347,59,391,188,-13,-192,244,234,273,369,48,340,-117,261,-93,214,196,278,142,-8,349,-127,321,-102,183,-170,61,151,-29,286,201,377,2,-78,-181,268,339,154,249,-49,242,347,70,-77,-170,193,-60,226,-98,315,328,102,70,214,160,78,65,13,211,335,-50,120,309,-53,302,391,-179,3,65,-67,-99,-121,95,-94,123,55,-49,371,27,218,360,165,30,-40,-160,55,159,7,26,-38,74,207,-119,85,-179,321,-160,-82,363,310,350,284,168,182,133,-145,-94,335,-185,-75,227,331,-80,-96,58,78,362,138,235,53,211,395,-187,-29,-13,322,-115,-115,348,19,272,149,-119,17,58,203,181,-91,263,-31,17,207,271,-105,-136,-129,-40,319,2,-34,212,390,105,135,382,289,-101,268,-33,328,185,-31,-22,182,87,191,168,85,332,-24,349,-187,244,288,203,-24,227,365,371,-195,-38,30,-102,289,344,-96,121,97,231,-135,390,-192,298,286,144,212,318,26,102,258,225,-195,311,27,144,322,117,-77,105,-82,48,170,-5,310,-43,-93,264,218,235,-109,392,-194,194,59,178,45,-80,-7,117,287,80,226,284,5,-181,206,276,61,264,249,365,302,-129,392,-75,362,196,155,-63,387,151,-37,-145,74,331,62,287,37,261,159,135,-50,325,-165,-22,399,123,-121,216,318,238,199,53,332,10,350,191,325,183,41,272,216,165,-86,300,133,258,10,7,-43,163,-67,194,188,298,199,309,76,-16,379,344,19,193,360,68,242,-136,-110,339,382,13,-95,-91,276,-105,238,206,-99,-150,41,-16,358,-78,-8,155,257,395,363,-194};
		counting(A);		
	}
	
	public static void counting(int[] A){
		Solution su = new Solution();
		long tStart = System.currentTimeMillis();
		System.out.println(su.singleNumber7(A));		
		long tEnd = System.currentTimeMillis();
		long tDelta = tEnd - tStart;
		double elapsedSeconds = tDelta;		
		System.out.println(String.format("executed time: %9.8f (ms)", elapsedSeconds));
	}

}
