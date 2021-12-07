import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		try {
			Socket s = new Socket("localhost", 8080);
			DataInputStream dis = new DataInputStream(s.getInputStream());
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			System.out.print("\nEnter a Number: ");
			int num = scan.nextInt();
			dout.writeInt(num);
			String ans = (String) dis.readUTF();
			System.out.println("\nNumber " + num + " is a prime number? " + ans);
			dout.flush();
			dout.close();
			s.close();
		} catch (Exception e) {
           		System.out.println(e);
		}
		scan.close();
	}
}