/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio5e;

/**
 *
 * @author jorge
 */
public class Coordenada {
    
    // Atributos
    private int coordenadaX;
    private int coordenadaY;
    private int elemento;
    
    // Constructor
    public Coordenada() {

    }
    
    // Setters
    public void setCoordenadaX(int coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public void setCoordenadaY(int coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public void setElemento(int elemento) {
        this.elemento = elemento;
    }
    
    // Getters
    public int getCoordenadaX() {
        return coordenadaX;
    }

    public int getCoordenadaY() {
        return coordenadaY;
    }

    public int getElemento() {
        return elemento;
    }
    
    // Método toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Coordenada{");
        sb.append("coordenadaX=").append(coordenadaX);
        sb.append(", coordenadaY=").append(coordenadaY);
        sb.append(", elemento=").append(elemento);
        sb.append('}');
        return sb.toString();
    }
    
    // Métodos equals y hashCode
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.coordenadaX;
        hash = 67 * hash + this.coordenadaY;
        hash = 67 * hash + this.elemento;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Coordenada other = (Coordenada) obj;
        if (this.coordenadaX != other.coordenadaX) {
            return false;
        }
        if (this.coordenadaY != other.coordenadaY) {
            return false;
        }
        return this.elemento == other.elemento;
    }
}
