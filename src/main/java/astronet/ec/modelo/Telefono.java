package astronet.ec.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Telefono")
@SequenceGenerator(
	    name="TelefonoSeq",
	    sequenceName = "Telefono_SEQ",
	    initialValue = 6000,
	    allocationSize = 1
)

public class Telefono implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "tel_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TelefonoSeq")
	@NotNull
	private int id;


	@Column(name = "tel_tipo")
	private String tipoTelefono;

	@Column(name = "tel_numero")
	private String telNumero;

	/*
	 * Relacion Telefono con Cliente
	 */
	@ManyToOne
	@JoinColumn(name="cliTel_fk")
	@JsonIgnore
	private Cliente cliente;

  public Telefono() {
		super();
	}

	public Telefono(int id, String tipoTelefono, String telNumero, Cliente cliente) {
		super();
		this.id = id;
		this.tipoTelefono = tipoTelefono;
		this.telNumero = telNumero;
		this.cliente = cliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipoTelefono() {
		return tipoTelefono;
	}

	public void setTipoTelefono(String tipoTelefono) {
		this.tipoTelefono = tipoTelefono;
	}

	public String getTelNumero() {
		return telNumero;
	}

	public void setTelNumero(String telNumero) {
		this.telNumero = telNumero;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefono other = (Telefono) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
