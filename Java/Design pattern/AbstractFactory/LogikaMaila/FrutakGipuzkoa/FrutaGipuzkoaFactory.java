package LogikaMaila.FrutakGipuzkoa;

import LogikaMaila.FabrikaNagusia.FrutaFabrikaNagusiaAbstract;


public class FrutaGipuzkoaFactory extends FrutaFabrikaNagusiaAbstract{
         
   public  FrutaGipuzkoaAbstract sortuLimoia()
   {
       return new GipuzkoaLimoia();
   } 
   public  FrutaGipuzkoaAbstract sortuLaranja()
   {
       return new GipuzkoaLaranja();
   }
   public  FrutaGipuzkoaAbstract sortuSagarra()
   {
       return new GipuzkoaSagarra();
   }   
   
}
