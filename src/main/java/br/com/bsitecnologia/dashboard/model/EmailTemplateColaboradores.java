package br.com.bsitecnologia.dashboard.model;

// Generated 15/09/2012 10:17:48 by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.bsitecnologia.dashboard.util.BaseEntity;

/**
 * EmailTemplateColaboradores generated by hbm2java
 */
@Entity
@Table(name = "EmailTemplateColaboradores", catalog = "dashboard")
public class EmailTemplateColaboradores implements Serializable, BaseEntity{

	private static final long serialVersionUID = -8986513113064296858L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "equipe")
	private Equipe equipe;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cargo")
	private Cargo cargo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "emailTemplate", nullable = false)
	private EmailTemplate emailTemplate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "colaborador")
	private Colaborador colaborador;

	public EmailTemplateColaboradores() {
	}

	public EmailTemplateColaboradores(EmailTemplate emailTemplate) {
		this.emailTemplate = emailTemplate;
	}

	public EmailTemplateColaboradores(Equipe equipe, Cargo cargo,
			EmailTemplate emailTemplate, Colaborador colaborador) {
		this.equipe = equipe;
		this.cargo = cargo;
		this.emailTemplate = emailTemplate;
		this.colaborador = colaborador;
	}

	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Equipe getEquipe() {
		return this.equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public Cargo getCargo() {
		return this.cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public EmailTemplate getEmailTemplate() {
		return this.emailTemplate;
	}

	public void setEmailTemplate(EmailTemplate emailTemplate) {
		this.emailTemplate = emailTemplate;
	}

	public Colaborador getColaborador() {
		return this.colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	@Override
	public String getEntityDescription() {
		return String.format("Relacionamento template email colaborador - %s", id.toString());
	}

}
