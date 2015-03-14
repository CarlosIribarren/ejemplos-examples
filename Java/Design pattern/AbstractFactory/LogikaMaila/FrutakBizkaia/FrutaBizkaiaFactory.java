
package LogikaMaila.FrutakBizkaia;

import LogikaMaila.FabrikaNagusia.FrutaFabrikaNagusiaAbstract;

public class FrutaBizkaiaFactory extends FrutaFabrikaNagusiaAbstract
{

    public FrutaBizkaiaAbstract sortuLimoia()
    {
        return new BizkaiaLimoia();
    }
    public FrutaBizkaiaAbstract sortuLaranja()
    {
        return new BizkaiaLaranja();
    }
    public FrutaBizkaiaAbstract sortuSagarra()
    {
        return new BizkaiaSagarra();
    }
        
}
