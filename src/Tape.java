
public class Tape {
	
	private int currentIndex;
	private int size;
	private int arr[];
	
	
	public Tape(int size) {
		this.currentIndex = 0;
		this.size = size;
		this.arr = new int[this.size];
		
	}

	public void stringToTape(String s){
		for (int i = 0; i < s.length(); i++){
			if (s.charAt(i) == ('-')){
				i++;
				int temp = Character.getNumericValue(s.charAt(i));
				temp *= -1;
				write(temp);
			}else{
				write(Character.getNumericValue(s.charAt(i)));
			}
			this.currentIndex++;
		}
		this.currentIndex = 0;
	}
	
	public void write(int toBeWritten){
		this.arr[currentIndex] = toBeWritten;
	}
	
	public void printTape(){
		for (int i = 0; i < this.arr.length; i++){
			System.out.print(this.arr[i]);
			System.out.print(" ");
		}
		System.out.println();
	}
	
	public void printTapeHead(){
		for (int i = 0; i < this.arr.length; i++){
			if (i == this.currentIndex){
				System.out.print("[" + this.arr[i] + "] ");
			}else{
				System.out.print(this.arr[i]);
				System.out.print(" ");
			}
		}
		System.out.println();
	}
	
	public int read(){
		return this.arr[this.currentIndex];
	}
	
	public void moveLeft(){
		this.currentIndex--;
	}
	
	public void moveRight(){
		this.currentIndex++;
	}
	
	public String toString(){
		String s = "";
		for (int i = 0; i < this.arr.length; i++){
			if (i == 0){
				s = s + this.arr[i];
			}else{
				s = s + " " + this.arr[i];
			}
		}
		return s;
	}
}
