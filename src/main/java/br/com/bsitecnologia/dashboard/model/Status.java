package br.com.bsitecnologia.dashboard.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.bsitecnologia.dashboard.util.BaseEntity;

@Entity
@Table(name = "Status", catalog = "dashboard")
public class Status implements Serializable, BaseEntity {

	private static final long serialVersionUID = -4554195991608067482L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente")
	private Cliente cliente;
	
	@Column(name = "nome", nullable = false, length = 100)
	private String nome;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "status")
	private List<Demanda> demandas = new ArrayList<Demanda>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "statusPara")
	private List<TransicaoStatus> transicaoStatusPara = new ArrayList<TransicaoStatus>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "statusDe")
	private List<TransicaoStatus> transicaoStatusDe = new ArrayList<TransicaoStatus>(0);

	public Status() {
	}

	public Status(String nome) {
		this.nome = nome;
	}

	public Status(Cliente cliente, String nome, List<Demanda> demandas,
			List<TransicaoStatus> transicaoStatusPara,
			List<TransicaoStatus> transicaoStatusDe) {
		this.cliente = cliente;
		this.nome = nome;
		this.demandas = demandas;
		this.transicaoStatusPara = transicaoStatusPara;
		this.transicaoStatusDe = transicaoStatusDe;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Demanda> getDemandas() {
		return this.demandas;
	}

	public void setDemandas(List<Demanda> demandas) {
		this.demandas = demandas;
	}

	public List<TransicaoStatus> getTransicaoStatusPara() {
		return this.transicaoStatusPara;
	}

	public void setTransicaoStatusPara(List<TransicaoStatus> transicaoStatusPara) {
		this.transicaoStatusPara = transicaoStatusPara;
	}

	public List<TransicaoStatus> getTransicaoStatusDe() {
		return this.transicaoStatusDe;
	}

	public void setTransicaoStatusDe(List<TransicaoStatus> transicaoStatusDe) {
		this.transicaoStatusDe = transicaoStatusDe;
	}

	@Override
	public String getEntityDescription() {
		return nome;
	}

}
