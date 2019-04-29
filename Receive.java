import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Receive extends Thread  { 
          
        DatagramSocket datagramSocket;
        
        // Constructor 
        public Receive(DatagramSocket datagramSocket){ 
        	this.datagramSocket = datagramSocket;
        } 
      
        @Override
        public void run()  
        { 
            while (true)  
            { 
                try { 

                    DatagramPacket receivedPacket
                            = new DatagramPacket( new byte[Config.BUFFER_SIZE], Config.BUFFER_SIZE);

                    datagramSocket.receive(receivedPacket);

                    int length = receivedPacket.getLength();
                    String message = new String(receivedPacket.getData(), 0, length, "utf8");

                    System.out.println(message);
                    System.out.println(receivedPacket.getAddress());
                    System.out.println(receivedPacket.getPort());
                    Thread.sleep(1000); 
                   
                 } catch (IOException e) { 
                    System.out.println("errors");
                } catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
               
            } 
               
        } 
    } 