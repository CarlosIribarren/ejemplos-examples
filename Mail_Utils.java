package es.lacaixa.absis.batch.app.ccfccf.util;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class EmailUtils {
//	Parametros de envio de email

	//public static String mail_host="000.00.00.000"; IP
	private String mail_host="megaout.megamail.es"; //DNS
	private String mail_port="25";
	private String smtpHost;
	private String smtpPort;
	private String id_fichero="";

	protected static Log logger = LogFactory.getLog(EmailUtils.class);
	
	public EmailUtils(){	
		//lee las propiedades para conectarse al servidor de correo
		try {
			this.smtpHost =mail_host; 
			this.smtpPort = mail_port;
		} catch (Exception e) {
			logger.error("Error al crear la clase EmailUtils : " + e.getMessage());
		}
	}
	
	public void envia_Un_Email_A_Cada_Direccion(String destinos, String origen, String copia, String oculto, String asunto, String texto, String directorio, Vector<String> contenido) throws AddressException, MessagingException 
	{
		 //  INFO : Envia un email a cada direccion que aparezca en destinos, separada por ";" 
		 //			Ejemplo : destinos = direccion_1;direccion_2   => Envio Mail (direccion_1) y Envio Mail (direccion_2) . Resultado, se envian dos Mails.
		
		
    	//Compribar que los campos de destino y origen estan informados
    	if (destinos!=null ) 
    	{
    		if(origen!=null)
    		{
    			String direccionMail ="";
    			
    			//Envio de Mail por separado, se envia un email a cada direccion de correo
    			StringTokenizer un_destino = new StringTokenizer(destinos,";");

    			while(un_destino.hasMoreTokens())
    			{
    				direccionMail = un_destino.nextToken();
    				enviaEmailGenerico(direccionMail, origen, copia, oculto, asunto, texto, directorio, contenido);
    				logger.info("INFO : Mail enviado con exito (destino = " + direccionMail + ", origen = " + origen + ", copia = " + copia + ", oculto = " + oculto + ", asunto = " + asunto + ", texto = " + texto.replaceAll("\n", "") + ", directorio = " + directorio + ", contenido = " + contenido.toString() + ")." );
    			}
    		}
    		else
    		{
        		//Origen vacio
        		logger.error("ERROR : El origen del Mail tiene el valor de null");
    		}
    	} 
    	else 
    	{
    		//Destino vacio
    		logger.error("ERROR : El destino del Mail tiene el valor de null");
    	}
    	
	}
	
	/*
	 * 02/06/2015  
	 * Para el envio de email con ficheros adjuntos
	 * Parametros:
	 * 	dir destino
	 *  dir origen
	 *  dir copia
	 *  dir copia oculta
	 *  asunto
	 *  texto del correo
	 *  ruta de los ficheros que vamos a adjuntar
	 *  vector con el nombre de los ficheros que queremos adjuntar
	 *  INFO : Envia un unico email con todos los destinos en el mismo Mail, en la parte de From. 
	 *  Ejemplo : destinos = direccion_1;direccion_2   => Envio Mail (direccion_1, direccion_2) . Resultado, se envian un unico Mail.
	 */
    public boolean enviaEmailGenerico(String destino, String origen, String copia, String oculto, String asunto, String texto, String directorio, Vector<String> contenido) throws AddressException, MessagingException 
    {
    	//Preparar respuesta
    	boolean respuesta_Mail_Enviado=false;
    	
    	//Compribar que los campos de destino y origen estan informados
    	if (destino!=null ) 
    	{
    		if(origen!=null)
    		{
    	    	BodyPart messageBodyPart2 =null;
    	    	DataSource source=null;

    	    	// Crea una sesion de email
    	    	java.util.Properties props = new java.util.Properties();
    	    	props.put("mail.smtp.host", this.smtpHost);
    	    	props.put("mail.smtp.port", this.smtpPort);
    	    	Session session = Session.getDefaultInstance(props, null);

    	    	//Construye el mensaje
    	    	Message msg = new MimeMessage(session);
    	    	msg.setFrom(new InternetAddress(origen));


    	    	// Create the message part 
    	    	BodyPart messageBodyPart = new MimeBodyPart();

    	    	// Fill the message
    	    	texto = replaceAll(texto, "<BR>", System.getProperty("line.separator"));
    	    	texto = texto + pieEmail(origen);
    	    	messageBodyPart.setText(texto);

    	    	Multipart multipart = new MimeMultipart();
    	    	multipart.addBodyPart(messageBodyPart);

    	    	// Part two is attachments ( para todos los ficheros a adjuntar)

    	    	for (int j=0; j<contenido.size(); j++)
    	    	{
    	    		id_fichero=(String)contenido.get(j);	
    	    		String file=directorio + id_fichero;

    	    		messageBodyPart2 = new MimeBodyPart();
    	    		source = new FileDataSource(file);

    	    		messageBodyPart2.setDataHandler(new DataHandler(source));
    	    		messageBodyPart2.setFileName(id_fichero);
    	    		multipart.addBodyPart(messageBodyPart2);
    	    	}

    	    	//	Put parts in message
    	    	msg.setContent(multipart);



    	    	//*********** Destinatario *************
    	    	if (destino.indexOf(",") > 0) {
    	    		StringTokenizer stkn=new StringTokenizer(destino,",");
    	    		while (stkn.hasMoreTokens()){
    	    			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(stkn.nextToken()));	
    	    		}

    	    	} else msg.setRecipient(Message.RecipientType.TO, new InternetAddress(destino));

    	    	//********** En copia *****************
    	    	if (copia!=null) 
    	    	{
    	    		if (copia.indexOf(",") > 0) {
    	    			StringTokenizer stkn=new StringTokenizer(copia,",");
    	    			while (stkn.hasMoreTokens()){
    	    				msg.addRecipient(Message.RecipientType.CC, new InternetAddress(stkn.nextToken()));	
    	    			}
    	    		} else msg.setRecipient(Message.RecipientType.CC, new InternetAddress(copia));
    	    	}

    	    	//*********** En copia oculta ***************
    	    	if (oculto!=null) 
    	    	{
    	    		if (oculto.indexOf(",") > 0) {
    	    			StringTokenizer stkn=new StringTokenizer(oculto,",");
    	    			while (stkn.hasMoreTokens()){
    	    				msg.addRecipient(Message.RecipientType.BCC, new InternetAddress(stkn.nextToken()));	
    	    			}  											
    	    		} else msg.setRecipient(Message.RecipientType.BCC, new InternetAddress(oculto));
    	    	}

    	    	//Asunto
    	    	msg.setSubject(asunto);

    	    	//Lo enviamos
    	    	Transport.send(msg);

    	    	respuesta_Mail_Enviado=true;

    		}
    		else
    		{
        		//Origen vacio
        		logger.error("ERROR : El origen del Mail tiene el valor de null");
    		}

    	} 
    	else 
    	{
    		//Destino vacio
    		logger.error("ERROR : El destino del Mail tiene el valor de null");
    	}
    	return respuesta_Mail_Enviado;
    }
	
    
	private String pieEmail(String email) {
	    
		String texto;
				
		texto = System.getProperty("line.separator")+" "+System.getProperty("line.separator")
		+ "Este mensaje electr\u00F3nico ha sido generado autom\u00E1ticamente; rogamos no "
		+ "respondan a este correo utilizando como destinatario la direcci\u00F3n "
		+ email + " ya que su mensaje no podr\u00E1 ser atendido."
		+ System.getProperty("line.separator")
		+ "Gracias"
		+ System.getProperty("line.separator");
					
		return texto;
	}
	
	/**
	 * Sustituye dentro de la cadena original, la cadena a substituir por la nueva cadena 
	 * @param cadenaOriginal
	 * @param cadenaSubstituir
	 * @param cadenaNueva
	 * @return
	 */
	private String replaceAll(String cadenaOriginal, String cadenaSubstituir, String cadenaNueva)
	{
		String aux="";
		int corte=0;
		if (cadenaOriginal != null && cadenaSubstituir != null && cadenaNueva != null)
		{
			while (corte!=-1)
			{
				corte = cadenaOriginal.indexOf(cadenaSubstituir);
				if (corte!=-1){
					aux = aux + cadenaOriginal.substring(0,corte);
					aux = aux + cadenaNueva;
					cadenaOriginal = cadenaOriginal.substring(corte + cadenaSubstituir.length());					
				}
			}
			cadenaOriginal = aux + cadenaOriginal;
		}
		else return aux; 
		return cadenaOriginal;
	}
}
