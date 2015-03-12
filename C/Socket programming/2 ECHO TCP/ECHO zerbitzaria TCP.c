//-------------------------------------------------------------------------
// ------------------------ ECHO zerbitzaria TCP erabiliz --------------
//-------------------------------------------------------------------------
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <unistd.h>

#define MAX_BUF 1024
#define PORT 50002

int main()
{
	//------------------------- DEFINIZIOAK -------------------------------------
	//SOCKETAREN IDENTIFIKAZIOA JASOTZEKO
	int sock, elkarrizketa;
	//BUFFERREAN JASOTZEN DEN BYTE KOPURUA
	int n;
	//HELBIDEAK GORDETZEKO
	struct sockaddr_in zerb_helb;
	//BUFERRA KARAKTERE KATEA GORDETZEKO
	char buf[MAX_BUF];
	//---------------------------------------------------------------------------
	
	//------------------------- SOCKETA SORTU ------------------------------------
	//SOCKET OBJETUA SORTU(sock identifikadore bat jasoko du)
	if((sock = socket(AF_INET, SOCK_STREAM, 0))==-1)
	{
		printf("ERROREA SOCKETA SORTZERAKOAN");
	}
	//SOCKETAREN PARAMETROAK
	zerb_helb.sin_family = AF_INET;
	zerb_helb.sin_addr.s_addr = htonl(INADDR_ANY);
	zerb_helb.sin_port = htons(PORT);
	//SOCKETARI PARAMETRO(helbidea,) ETA PORTUAK ASIGNATU
	if(bind(sock, (struct sockaddr *) &zerb_helb, sizeof(zerb_helb))==-1)
	{	
		printf("ERROREA SOCKETARI PARAMETRO ETA PORTUAK ASIGNATZEAN");
		exit(1);
	}
	//----------------------------------------------------------------------------
		
	//--------------------- SOCKETA ENTZUTE MODUAN JARRI ----------------------------
	
	if(listen(sock,5)==-1)
	{	
		printf("KONEXIOA EZARTZERAKO MOMENTUAN ERROREA!!!!");
		exit(1);
	}
	//-------------------------------------------------------------------------------
	
	//--------------------------- DATUAK JASO ETA BIDALI -----------------------------------------------
	while(1)
	{
		//ONARTU KONEXIO BERRI BAT ETA SOCKET BERRI BAT SORTU ELKARRIZKETA IDENTIFIKADOREAREKIN
		if((elkarrizketa = accept(sock, NULL, NULL))==-1)
		{
			printf("ERROREA KONEXIOA ONARTZERAKOAN");
			exit(1);
		}
		while(elkarrizketa!=0)
		{
			//BEZEROAK BIDALITAKOA JASO buf-N
			n = read(elkarrizketa, buf, MAX_BUF);
			//BEZEROARI buf BIDALI
			
			if(write(elkarrizketa, buf, n)==-1)
			{
				printf("ERROREA BEZEROARI BUF BIDALTZEAN");
				exit(1);
			}
			
		}
		//-------------------------------BEZERO BAKOITZAREN KONEXIOA ITXI --------------------------------- 
		if(close(elkarrizketa)==-1)
		{
			printf("ERROREA KONEXIOA IXTEAN");
			exit(1);
		}
		//-------------------------------------------------------------------------------
	}
	//-------------------------------------------------------------------------------------------------

	//------------------------------- KONEXIOA OROKORRA ITXI ---------------------------------
	if(close(sock)==-1)
		{
			printf("ERROREA KONEXIOA IXTEAN");
			exit(1);
		}
	//-------------------------------------------------------------------------------
}
