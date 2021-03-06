import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Send extends Thread  { 
          
        DatagramSocket datagramSocket;
        
        // Constructor 
        public Send(DatagramSocket datagramSocket){ 
        	this.datagramSocket = datagramSocket;
        } 
      
        @Override
        public void run()  
        { 
            while (true)  
            { 
                try { 

                	 byte[] byteResponse = "OK".getBytes("utf8");

                     while (true){

                         DatagramPacket receivedPacket
                                 = new DatagramPacket( new byte[Config.BUFFER_SIZE], Config.BUFFER_SIZE);

                         datagramSocket.receive(receivedPacket);

                         int length = receivedPacket.getLength();
                         String message =
                                 new String(receivedPacket.getData(), 0, length, "utf8");

                         // Port i host który wysłał nam zapytanie
                         InetAddress address = receivedPacket.getAddress();
                         int port = receivedPacket.getPort();

                         System.out.println(message);
                         Thread.sleep(1000); //To oczekiwanie nie jest potrzebne dla
                         // obsługi gniazda

                         DatagramPacket response
                                 = new DatagramPacket(
                                     byteResponse, byteResponse.length, address, port);

                         datagramSocket.send(response);
               
                     	} 
                }   catch (IOException e) { 
                System.out.println("errors");
            } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
            } 
            
            } 
        } 