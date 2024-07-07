package br.com.parc3ria.verify.model.email;

public class Email {
    private String email;
    private String entrega;
    private Double qualidade;
    private String emailValido;
    private String emailGratis;

    public String getEmail() { return emailGratis; }
    public String getEntrega() { return entrega; }
    public String getEmailValido() { return emailValido; }
    public Double getQualidade() { return qualidade; }
    public String getEmailGratis() { return emailGratis; }

    public Email(DadosEmail dadosEmail){
        boolean isValidoFormato = dadosEmail.isValidoFormato().valor();
        boolean isEmailGratis = dadosEmail.isEmailGratis().valor();
        boolean isDeliverable = dadosEmail.entrega().equals("DELIVERABLE");

        this.email = dadosEmail.email();
        this.entrega = isDeliverable ? "Entregue" : "Não entregavel";
        this.emailGratis = isEmailGratis ? "Sim" : "Não";
        this.emailValido = isValidoFormato ? "Sim" : "Não";

        try{
            this.qualidade = Double.valueOf(dadosEmail.qualidade());
        } catch (NumberFormatException e){
            this.qualidade = 0.0;
        }
    }
}
