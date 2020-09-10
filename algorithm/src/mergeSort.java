
public class mergeSort {
	static int [] src;
	static int [] temp;
	public static void main(String[] args) {
		src = new int [] {1,9,8,5,4,2,3,7,6};
		temp = new int [src.length];
		mergeSort(0,src.length-1);
		for(int i: src) System.out.print(i +" ");
	}
	static void mergeSort(int start, int end) {
		if(start<end) {
			int mid = (start+end)/2;
			mergeSort(start, mid);
			mergeSort(mid+1, end);
			
			int p = start;
			int q = mid+1;
			int idx = p;
			
			while (p<=mid || q<=end) {
				if(q>end || p<=mid && src[p]<src[q]) {
					temp[idx++] = src[p++];
				}else {
					temp[idx++] = src[q++];
				}
			}
			for(int i=start; i<=end; i++) {
				src[i]=temp[i];
			}
		}
	}

}
