
interface shape {
	int length = 0;
	  void getLength();
		
}

 abstract class squareShape{
	 private int width;
	 public squareShape(int width) {
		 
	 }
 }

 class circle extends squareShape{
 
	 private int height;
	
	public circle(int width, int height) {
		super(width);
		this.height=height;
		
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	 
 }
 class quiz {
	
	
public static void main(String[] args) {
System.out.print("sss");

}
}
