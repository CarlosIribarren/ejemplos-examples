package logikaMaila;
import logikaMaila.Batura;
// KLASE ADAPTER = ENVOLTORIOA = 
// BI GAUZA EGITEN DA
// 1.- ABSTRACT KLASEKO METODOAK DEFINITU
// 2.- METODOAK BIR-DEFINITZEAN ORDUAN EGIN LOTURA KLASE NORMALAKIN
//implements hitzarekin interfacea birdefinitu dezakegu
//interfacean ez daude metodoen inplementazioa egina
//metodoen implementazioa hemen definitu behar da, implements clasean
public class BaturaAdapter  implements BiderInterface {

    public BaturaAdapter()
    {
    }
    
    //BiderInterface clasearen metodoa bir-Definitu
    @Override
    public Integer bizenbakiBiderkatu(Integer zenbakia, Integer biderkadura) 
    {
        Batura nereBatura = new Batura();
        Integer emaitza = new Integer(0);
        int a;
        for (a=0; a<biderkadura ;a++)
        {
            emaitza = nereBatura.bizenbakibatu(emaitza, zenbakia);
            
        }
        return emaitza;
        
    }

    
}
