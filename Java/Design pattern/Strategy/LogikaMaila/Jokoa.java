
package LogikaMaila;

public abstract class Jokoa {
    
    //JOKUAREN PARAMETROAK
    private Integer maila;
    private Integer metroak;
    
    public abstract void HasiJokoa();

    public Integer getMaila() {
        return maila;
    }

    public void setMaila(Integer maila) {
        this.maila = maila;
    }

    public Integer getMetroak() {
        return metroak;
    }

    public void setMetroak(Integer metroak) {
        this.metroak = metroak;
    }
    
    
    
}
