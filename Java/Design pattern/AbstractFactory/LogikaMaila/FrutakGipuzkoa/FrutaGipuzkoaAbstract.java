
package LogikaMaila.FrutakGipuzkoa;


public abstract class FrutaGipuzkoaAbstract {
    
    private String izena;
    private double prezioKilo;
    private String denboraldia;
    private String probintzia;
    private String hiria;

    public FrutaGipuzkoaAbstract() 
    {
        this.setProbintzia("Gipuzkoa");
    }
    

    
    
    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public double getPrezioKilo() {
        return prezioKilo;
    }

    public void setPrezioKilo(double prezioKilo) {
        this.prezioKilo = prezioKilo;
    }

    public String getDenboraldia() {
        return denboraldia;
    }

    public void setDenboraldia(String denboraldia) {
        this.denboraldia = denboraldia;
    }

    public String getHiria() {
        return hiria;
    }

    public void setHiria(String hiria) {
        this.hiria = hiria;
    }

    public String getProbintzia() {
        return probintzia;
    }

    public void setProbintzia(String probintzia) {
        this.probintzia = probintzia;
    }

    
    
    
    
    
    
    
}
