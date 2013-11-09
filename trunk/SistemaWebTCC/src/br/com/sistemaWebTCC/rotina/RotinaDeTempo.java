package br.com.sistemaWebTCC.rotina;

import java.util.Timer;
import java.util.TimerTask;

import br.com.sistemaWebTCC.entity.Configuracao;
import br.com.sistemaWebTCC.jdbc.ConfiguracaoDAO;
public class RotinaDeTempo implements Runnable{
	
	public void run(){
	    long delay = 1000;   // delay de 1 seg.
	    long interval = 60000;  // intervalo de 1 min.
	    Timer timer = new Timer();
	    
	    timer.scheduleAtFixedRate(new TimerTask() {
	    	  public void run() {
	    		    
	                System.out.println("TESTE DEIWYS TIMER");
	                
	                ConfiguracaoDAO dao = null;
					try {
						dao = new ConfiguracaoDAO();
					} catch (ClassNotFoundException | InstantiationException
							| IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                Configuracao config = dao.consultarConfig();
	                
	                System.out.println("Hora 1: "+config.getHora1());
	                System.out.println("Hora 2: "+config.getHora2());
	                System.out.println("Hora 3: "+config.getHora3());
	                System.out.println("Hora 4: "+config.getHora4());
	                
	                if(config.getHora1().equals("13:00") || 
	                   config.getHora2().equals("15:00") || 
	                   config.getHora3().equals("13:00") || 
	                   config.getHora4().equals("13:00")){
	                   System.out.println("Enviando dados para arduino");
	                }
	                else{
	                   System.out.println("Não tem horario");
	                }
	                
	          }
	        }, delay, interval);
	}
}