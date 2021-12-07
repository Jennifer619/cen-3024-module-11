import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client extends Server {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		try {
			Socket s = new Socket("localhost", 6000);
			DataInputStream din = new DataInputStream(s.getInputStream());
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			System.out.print("\nEnter a Number: ");
			int num = scan.nextInt();
			dout.writeInt(num);
			String ans = (String) din.readUTF();
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