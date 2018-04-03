package Nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Demo1 {
	public static void main(String[] args) {
		Demo1.readFile("D:\\test\\text.txt");
	}
	
	public static void readFile(String path){
		try {
			RandomAccessFile aFile = new RandomAccessFile(path, "rw");  
			FileChannel inChannel = aFile.getChannel();  
			  
			//create buffer with capacity of 48 bytes  
			ByteBuffer buf = ByteBuffer.allocate(48);  
			  
			/*int bytesRead = inChannel.read(buf); //read into buffer.  
			while (bytesRead != -1) {  
			  
			  buf.flip();  //make buffer ready for read  
			  
			  while(buf.hasRemaining()){  
			      System.out.println((char) buf.get());
			  }  
			  
			  buf.clear(); //make buffer ready for writing  
			} */ 
			String s=new String("孟立焕");
			buf.clear();
			 buf.put(s.getBytes());
			 buf.flip();
			  //while(buf.hasRemaining()){
				 // System.out.println((char)buf.get());
				  inChannel.write(buf); 
			  //}
			aFile.close();
			
		} catch (Exception e) {
			System.err.println(e);
		}

	}
}
