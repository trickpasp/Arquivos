package br.com.exemplo.model;

public class Fornecedor {

	private int id;
	private String cnpj;
	private String nome;
	private boolean ativo;
	private boolean recadastrado;
	private Integer idMunicipio;
	private String uf;
	private int idNaturezaJuridica;
	private int idPorteEmpresa;
	private int idRamoNegocio;
	private int idUnidadeCadastradora;
	private int idCnae;
	private boolean habilitadoLicitar;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public boolean isRecadastrado() {
		return recadastrado;
	}
	public void setRecadastrado(boolean recadastrado) {
		this.recadastrado = recadastrado;
	}
	public Integer getIdMunicipio() {
		return idMunicipio;
	}
	public void setIdMunicipio(Integer idMunicipio) {
		this.idMunicipio = idMunicipio;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public int getIdNaturezaJuridica() {
		return idNaturezaJuridica;
	}
	public void setIdNaturezaJuridica(int idNaturezaJuridica) {
		this.idNaturezaJuridica = idNaturezaJuridica;
	}
	public int getIdPorteEmpresa() {
		return idPorteEmpresa;
	}
	public void setIdPorteEmpresa(int idPorteEmpresa) {
		this.idPorteEmpresa = idPorteEmpresa;
	}
	public int getIdRamoNegocio() {
		return idRamoNegocio;
	}
	public void setIdRamoNegocio(int idRamoNegocio) {
		this.idRamoNegocio = idRamoNegocio;
	}
	public int getIdUnidadeCadastradora() {
		return idUnidadeCadastradora;
	}
	public void setIdUnidadeCadastradora(int idUnidadeCadastradora) {
		this.idUnidadeCadastradora = idUnidadeCadastradora;
	}
	public boolean isHabilitadoLicitar() {
		return habilitadoLicitar;
	}
	public void setHabilitadoLicitar(boolean habilitadoLicitar) {
		this.habilitadoLicitar = habilitadoLicitar;
	}
	public int getIdCnae() {
		return idCnae;
	}
	public void setIdCnae(int idCnae) {
		this.idCnae = idCnae;
	}
	
	@Override
		public String toString() {
			
			return 	getId() + ","+ getCnpj() + "," + getNome() + "," + isAtivo() + ","
					+ isRecadastrado() + "," + getIdMunicipio() + "," + getUf() + ","
					+ getIdNaturezaJuridica() + "," + getIdPorteEmpresa() + "," + getIdRamoNegocio()
					+ "," + getIdUnidadeCadastradora() + "," +getCnpj()+ "," + isHabilitadoLicitar();
		}
}
