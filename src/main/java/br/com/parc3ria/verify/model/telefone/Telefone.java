package br.com.parc3ria.verify.model.telefone;

public class Telefone {
    private String telefone;
    private String valido;
    private String internacional;
    private String local;
    private String sigla;
    private String nome;
    private String prefixo;
    private String localizacao;

    public String getTelefone() { return telefone; }
    public String getValido() { return valido; }
    public String getInternacional() { return internacional; }
    public String getLocal() { return local; }
    public String getSigla() { return sigla; }
    public String getNome() { return nome; }
    public String getPrefixo() { return prefixo; }
    public String getLocalizacao() { return localizacao; }

    public Telefone(DadosTelefone dadosTelefone){
        this.telefone = dadosTelefone.telefone();
        this.valido = dadosTelefone.valido() ? "Sim" : "Não";
        this.internacional = dadosTelefone.dadosFormat().internacional();
        this.local = dadosTelefone.dadosFormat().local();
        this.sigla = dadosTelefone.dadosCountry().sigla();
        this.nome = dadosTelefone.dadosCountry().nome();
        this.prefixo = dadosTelefone.dadosCountry().prefixo();
        this.localizacao = dadosTelefone.localizacao();
    }
}
