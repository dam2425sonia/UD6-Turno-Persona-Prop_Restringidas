import java.beans.PropertyVetoException;
import java.util.Scanner;

public class Main {
    public static void  main(String[] args){
        Pantalla pantalla=new Pantalla();
        Persona persona1 = new Persona("Andrea",1);
        Persona persona2=new Persona("Marisol",4);
        //Una vez creada la pantalla ponemos los escuchadores
        pantalla.nuevoObservador(persona1);
        pantalla.nuevoObservador(persona2);

        Scanner scanner =new Scanner(System.in);
        int num=0;
        do{
            System.out.println("Introduzca el siguiente turno:");
            num=scanner.nextInt();
            scanner.nextLine();
            try{
                pantalla.setTurno(num);
            }catch(PropertyVetoException ex){
                System.err.println(ex.getMessage());
                num=pantalla.getTurno();
            }
            
        }while(num!=0);
    }
}
