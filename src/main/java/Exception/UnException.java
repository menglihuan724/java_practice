package Exception;

public class UnException {
	public static void main(String[] args) {
		UnException.sql();
	}
	public static void sql(){
		try{
			System.out.println("123");
		}catch(Exception e){
				throw new RuntimeException("runtime异常");
		}
	}

}


