import java.util.ArrayList;
import java.util.Random;

public class TestJuegoRoles {
    public static void main(String[] args) {
        Personaje guerrero = new Guerrero(12,13,100,0);
        Personaje mago = new Mago(10,15,100,0);
        
        Personaje arquero = new Arquero(15,15,100,56);
        
        System.out.println(guerrero.combate(guerrero, mago));
        System.out.println("Estadisticas p1: " + guerrero.xP);
        System.out.println("Estadisticas p2: " + mago.xP);
        
        System.out.println(arquero.combate(arquero, guerrero));
        System.out.println("Estadisticas p1: " + arquero.xP);
        System.out.println("Estadisticas p2: " + mago.xP);
        
    }
}
abstract class Personaje{
public int puntosVida;
public int xP;


    public Personaje(int puntosVida, int xP) {
        this.puntosVida = puntosVida;
        this.xP = xP;
        
    }

    public abstract String ataque();
    public abstract String defensa();
    
    public String combate(Personaje p1 , Personaje p2){
        Random rand = new Random();
        
        while(true){
            p1.puntosVida -= rand.nextInt(35);
            p2.puntosVida -= rand.nextInt(35);
            if (p1.puntosVida <= 0 || p2.puntosVida <= 0) {
                break;
            }
        }
        
        if (p1.puntosVida <= 0) {
            p1.xP -= 1;
            p2.xP += 1;
           return "Ganador P2"; 
        } else {
            p1.xP += 1;
            p2.xP -= 1;
            return "Ganador P1";
        }
        
    }
}
class Guerrero extends Personaje{
    public int fuerza;
    public int habilidadCaC;

    public Guerrero(int fuerza, int habilidadCaC, int puntosVida, int xP) {
        super(puntosVida, xP);
        this.fuerza = fuerza;
        this.habilidadCaC = habilidadCaC;
    }
    
    public String ataque(){
        return "Guerrero Atacando";
    }
    
    public String defensa(){
        return "Guerrero Defendiendo";
    }
    
}
class Mago extends Personaje{
    public int hechizo;
    public int poderMagico;

    public Mago(int hechizo, int poderMagico, int puntosVida, int xP) {
        super(puntosVida, xP);
        this.hechizo = hechizo;
        this.poderMagico = poderMagico;
    }
    
    public String ataque(){
        return "Mago Atacando";
    }
    
    public String defensa(){
        return "Mago Defendiendo";
    }
}
class Arquero extends Personaje{
    public int precision;
    public int habilidadDistancia;

    public Arquero(int precision, int habilidadDistancia, int puntosVida, int xP) {
        super(puntosVida, xP);
        this.precision = precision;
        this.habilidadDistancia = habilidadDistancia;
    }
    
    public String ataque(){
        return "Arquero Atacando";
    }
    
    public String defensa(){
        return "Arquero Defendiendo";
    }
}
