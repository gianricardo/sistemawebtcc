package br.com.sistemaWebTCC.rotina;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class RotinaDeTempo implements Runnable{
	
	public static void main(String[] args) {
   
            RotinaDeTempo rotina = new RotinaDeTempo();
            Thread t = new Thread(rotina);
            t.run();
            
        }
	public void run(){
		    long delay = 1000;   // delay de 1 seg.
		    long interval = 5000;  // intervalo de 1 min.
		    Timer timer = new Timer();
		    
		    timer.scheduleAtFixedRate(new TimerTask() {
		    	  public void run() {
		    		    Date data = new Date();
		    		    System.out.println(data);
		                System.out.println("TESTE DEIWYS TIMER");
		          }
		        }, delay, interval);
		
	}
}