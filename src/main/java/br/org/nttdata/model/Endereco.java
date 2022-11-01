package br.org.nttdata.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;
import org.springframework.ui.Model;

@Entity
@Table(name = "user")
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String logradouro;
	private String complemento;

	@NonNull
    private String bairro;
	@NonNull
    private String localidade;
	@NonNull
    private String uf;
	private String ibge;
	private String gia;
	private String ddd;
	private String siafi;


	@NonNull
    private String cep;
	
	@ManyToOne
	private ModelCliente cliente;

    public String getLogradouro() {
        return logradouro;
    }

   

	public String getBairro() {
		return bairro;
	}



	public String getLocalidade() {
		return localidade;
	}



	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public ModelCliente getCliente() {
		return cliente;
	}

	public void setCliente(ModelCliente cliente) {
		this.cliente = cliente;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getIbge() {
		return ibge;
	}

	public void setIbge(String ibge) {
		this.ibge = ibge;
	}

	public String getGia() {
		return gia;
	}

	public void setGia(String gia) {
		this.gia = gia;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getSiafi() {
		return siafi;
	}

	public void setSiafi(String siafi) {
		this.siafi = siafi;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}
	
	

}