
import java.util.ArrayList;

public class TestRestaurante {
    public static void main(String[] args) {
        
        Menu carta = new MenuCarta(10.0, 2.0, 3.0, 10.0, "Menu Carta", 0);
        Menu dia = new MenuDia(8.0, 1.5, 2.0, "Menu Dia", 0);
        Menu kids = new MenuKids(6.0, 1.0, 1.0, "Menu Kids", 0);
        Menu economico = new MenuEconomico(5.0, 20.0, "Menu Economico", 0);
        
        
        carta.valorMenu = carta.calcularValorMenu();
        dia.valorMenu = dia.calcularValorMenu();
        kids.valorMenu = kids.calcularValorMenu();
        economico.valorMenu = economico.calcularValorMenu();
        
        
        ArrayList<Menu> menus = new ArrayList<>();
        menus.add(carta);
        menus.add(dia);
        menus.add(kids);
        menus.add(economico);
        
        Cuenta cuenta = new Cuenta("Josesito", menus, 0, 0, 0);
        cuenta.calcularTotal();
        
        // Imprimir la cuenta
        System.out.println("Nombre del Cliente: " + cuenta.nombreCliente);
        for(Menu menu : cuenta.menus) {
            System.out.println("Menu: " + menu.nombrePlato + " - Valor: " + menu.valorMenu);
        }
        System.out.println("Subtotal: " + cuenta.subTotal);
        System.out.println("IVA: " + cuenta.iva);
        System.out.println("Total: " + cuenta.total);
    }
}

class Restaurante {
    public String nombre;
}

class Cuenta {
    public String nombreCliente;
    public ArrayList<Menu> menus;
    public double subTotal;
    public double iva;
    public double total;

    public Cuenta(String nombreCliente, ArrayList<Menu> menus, double subTotal, double iva, double total) {
        this.nombreCliente = nombreCliente;
        this.menus = menus;
        this.subTotal = subTotal;
        this.iva = iva;
        this.total = total;
    }
    
    public void calcularTotal() {
        subTotal = 0;
        for(Menu menu : menus) {
            subTotal += menu.valorMenu;
        }
        iva = subTotal * 0.12; // Suponiendo un IVA del 12%
        total = subTotal + iva;
    }
}

abstract class Menu {
    public String nombrePlato;
    public double valorMenu;

    public Menu(String nombrePlato, double valorMenu) {
        this.nombrePlato = nombrePlato;
        this.valorMenu = valorMenu;
    }
    
    public abstract double calcularValorMenu();
}

class MenuCarta extends Menu {
    public double valorInicial;
    public double valorGuarnicion;
    public double valorMedida;
    public double porcentajeAdicional;

    public MenuCarta(double valorInicial, double valorGuarnicion, double valorMedida, double porcentajeAdicional, String nombrePlato, double valorMenu) {
        super(nombrePlato, valorMenu);
        this.valorInicial = valorInicial;
        this.valorGuarnicion = valorGuarnicion;
        this.valorMedida = valorMedida;
        this.porcentajeAdicional = porcentajeAdicional;
    }
    
    @Override
    public double calcularValorMenu() {
        return valorInicial + valorGuarnicion + valorMedida + (valorInicial * porcentajeAdicional / 100);
    }
}

class MenuDia extends Menu {
    public double valorInicial;
    public double valorPostre;
    public double valorBebida;

    public MenuDia(double valorInicial, double valorPostre, double valorBebida, String nombrePlato, double valorMenu) {
        super(nombrePlato, valorMenu);
        this.valorInicial = valorInicial;
        this.valorPostre = valorPostre;
        this.valorBebida = valorBebida;
    }
    
    @Override
    public double calcularValorMenu() {
        return valorInicial + valorPostre + valorBebida;
    }
}

class MenuKids extends Menu {
    public double valorInicial;
    public double valorHelado;
    public double valorPastel;

    public MenuKids(double valorInicial, double valorHelado, double valorPastel, String nombrePlato, double valorMenu) {
        super(nombrePlato, valorMenu);
        this.valorInicial = valorInicial;
        this.valorHelado = valorHelado;
        this.valorPastel = valorPastel;
    }
    
    @Override
    public double calcularValorMenu() {
        return valorInicial + valorHelado + valorPastel;
    }
}

class MenuEconomico extends Menu {
    public double valorInicial;
    public double porcentajeDescuento;

    public MenuEconomico(double valorInicial, double porcentajeDescuento, String nombrePlato, double valorMenu) {
        super(nombrePlato, valorMenu);
        this.valorInicial = valorInicial;
        this.porcentajeDescuento = porcentajeDescuento;
    }
    
    @Override
    public double calcularValorMenu() {
        return valorInicial - (valorInicial * porcentajeDescuento / 100);
    }
}


