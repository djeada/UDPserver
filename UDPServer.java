import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;

public class UDPServer {

	static ArrayList<String> clients = new ArrayList<String>();
	static int numberOfItems = 0;
	
    public static void main(String[] args) throws Exception{

        //Otwarcie gniazda z okreslonym portem
        DatagramSocket datagram = new DatagramSocket(Config.PORT);

        while (true)  
        { 
           
        	Thread t1 = new Receive(datagram); 
            Thread t2 = new Send(datagram); 

            t1.start();  
            t2.start();  
        }
    }
}