package Exception;

public class unException {
	public static void main(String[] args) {
		unException.sql();
	}
	public static void sql(){
		try{
			System.out.println("123");
		}catch(Exception e){
				throw new RuntimeException("runtime异常");
		}
	}

}
