package br.com.lojaoriodopeixe.vg.calc.implementations;

/**
 * Classe de entidade Parcela.
 *
 * @author Vagner Barbosa (contato@vagnerbarbosa.com)
 *
 * @since 07/09/2015
 *
 * @version 0.1
 */
public class Parcela {
    
    private String numero;
    private String parcela;
    private String totalParcelado;
    private String totalGeral;

    public Parcela() {
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getParcela() {
        return parcela;
    }

    public void setParcela(String parcela) {
        this.parcela = parcela;
    }

    public String getTotalParcelado() {
        return totalParcelado;
    }

    public void setTotalParcelado(String totalParcelado) {
        this.totalParcelado = totalParcelado;
    }

    public String getTotalGeral() {
        return totalGeral;
    }

    public void setTotalGeral(String totalGeral) {
        this.totalGeral = totalGeral;
    }

    @Override
    public String toString() {
        return "Parcela{" + "numero=" + numero + ", parcela=" + parcela + ", totalParcelado=" + totalParcelado + ", totalGeral=" + totalGeral + '}';
    }
      
}
