import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;

//Clase Persona deberá estar atenta a los cambios de turno
//por eso tiene que implementar la clase PropertyChangeListener
//y para ello nos pide que tenemos que implementar los métodos correspondientes:
//en este caso el método 
//- propertyChange:  Siempre que se produzca un cambio en una propiedad,
// nosotros recibiremos un evento 
public class Persona implements VetoableChangeListener{
    private String nombre;
    private int turno;

    public Persona(String nombre, int turno){
        this.nombre=nombre;
        this.turno=turno;
    }

    @Override
    public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException{
        int newTurno =(int) evt.getNewValue();
        //System.out.println(newTurno);
        if (newTurno<0){
            throw new PropertyVetoException("El turno no puede ser inferior a 0",evt);
        }
        if (newTurno==0){
            throw new PropertyVetoException("El turno no puede ser 0 ya que quedan personas a la espera",evt);
        }
        //Lo que dice cada persona al cambiar el turno
        if((int) evt.getNewValue()==turno){
            System.out.println(nombre+" Me toca");
             Pantalla pantalla= (Pantalla) evt.getSource(); //evt.getSource() obtiene el origen que es Pantalla
             pantalla.eliminarObservador(this);
        }else {
            System.out.println(nombre + " Sigo esperando...");  
        }
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
