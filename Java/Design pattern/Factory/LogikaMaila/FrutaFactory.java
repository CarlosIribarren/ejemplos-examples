package LogikaMaila;

public class FrutaFactory {
    
   public  FrutaAbstract limoiaSortu()
   {
       return new Limoia();
   } 
   public  FrutaAbstract laranjaSortu()
   {
       return new Laranja();
   }
   public  FrutaAbstract sagarraSortu()
   {
       return new Sagarra();
   }            
}
