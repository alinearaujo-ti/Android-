package com.example.cadastrodecarros;
import java.io.Serializable;

public class Car implements Serializable {
  private Integer ID;
  private String marca, modelo;

  public Car(Integer ID, String marca, String modelo) {
    this.ID = ID;
    this.marca = marca;
    this.modelo = modelo;
  }

  public Integer getID() {
    return ID;
  }

  public void setID(Integer ID) {
    this.ID = ID;
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  @Override
  public String toString() {
    return "Car{" +
            "ID=" + ID +
            ", marca='" + marca + '\'' +
            ", modelo='" + modelo + '\'' +
            '}';
  }
}
