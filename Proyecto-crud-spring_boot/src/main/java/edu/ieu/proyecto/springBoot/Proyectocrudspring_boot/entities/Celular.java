package edu.ieu.proyecto.springBoot.Proyectocrudspring_boot.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "celulares")
public class Celular {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private Double precio;
	
	@Column
	private String modelo;
	
	@Column
	private String tamaño;
	
	@Column
	private String android;
	
	@Column
	private String marca;
	
	@Column
	private Integer Gb_en_ram;
	
	@Column
	private String procesador;
	
	@Column
	private Integer almacenamiento_interno;
	
	@Column
	private String camara;
	
	@Column
	private int bateria;
	
	public Celular() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTamaño() {
		return tamaño;
	}

	public void setTamaño(String tamaño) {
		this.tamaño = tamaño;
	}

	public String getAndroid() {
		return android;
	}

	public void setAndroid(String android) {
		this.android = android;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Integer getGb_en_ram() {
		return Gb_en_ram;
	}

	public void setGb_en_ram(Integer gb_en_ram) {
		Gb_en_ram = gb_en_ram;
	}

	public String getProcesador() {
		return procesador;
	}

	public void setProcesador(String procesador) {
		this.procesador = procesador;
	}

	public Integer getAlmacenamiento_interno() {
		return almacenamiento_interno;
	}

	public void setAlmacenamiento_interno(Integer almacenamiento_interno) {
		this.almacenamiento_interno = almacenamiento_interno;
	}

	public String getCamara() {
		return camara;
	}

	public void setCamara(String camara) {
		this.camara = camara;
	}

	public int getBateria() {
		return bateria;
	}

	public void setBateria(int bateria) {
		this.bateria = bateria;
	}

	
}
