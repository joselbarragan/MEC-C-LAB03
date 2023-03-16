
import java.util.Timer;
import java.util.TimerTask;
import java.util.Scanner;

public class Tiempo {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		Timer timer = new Timer();
        
        System.out.println("opcion 1: cronometro\nopcion 2: alarma");
        int opcion = scanner.nextInt();
        
    switch(opcion){
        case 1:
    		TimerTask task = new TimerTask() {
    		  int a = 0,b=0,c=0;
    		  public void run() {
    		    System.out.printf("%2d:%2d:%2d\n",a,b,c);
    		    c++;
    		    if (b>58 && c>59){
    		        a++;
    		        c=0;
    		        b=0;
    		    }else 
    		    if (c>59){
    		        b++;
    		        c=0;
    		    }
    		     
    		  }
    		};
    		
    	  timer.schedule(task, 1000, 1000);
    	  break;
        case 2:
            System.out.println("cuanto tiempo en activar la alarma en minutos");
            int alarma = scanner.nextInt();
            System.out.println("cada cuanto se repite la alarma en segundos");
            int repeticion = scanner.nextInt();
            repeticion = repeticion * 1000;
            alarma = alarma * 60000;
            TimerTask taskq = new TimerTask() {
                boolean tic = true;
        		public void run() {
        		  System.out.print(tic ? "tic " : "toc ");
        		  tic = !tic;
        		  }
        		};
	        timer.schedule(taskq, alarma, repeticion);
            break;
        default:
            System.out.println("opcion incorrecta");
            break;
	}
	}
}