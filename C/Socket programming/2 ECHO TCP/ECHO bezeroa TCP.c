
//-------------------------------------------------------------------------
// ------------------------ ECHO bezeroa TCP erabiliz --------------
//-------------------------------------------------------------------------
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <unistd.h>

#define MAX_BUF 1024
#define PORT 50002

int main(int argc, char *argv[])
{
	
	//------------------------- DEFINIZIOAK -------------------------------------
	//KONTAGAILUAK 
	int m,mezluz;
	//SOCKETAREN IDENTIFIKAZIOA JASOTZEKO
	int sock; 
	//BUFFERREAN JASOTZEN DEN BYTE KOPURUA
	int n;
	//BUFERRA KARAKTERE KATEA GORDETZEKO
	char buf[MAX_BUF];
	//HELBIDEAK GORDETZEKO
	struct sockaddr_in zerb_helb;
	//----------------------------------------------------------------------------

	//--------------------- EGIAZTATU ARGUMENTU BAT PASA DELA---------------------------------
	if(argc != 2)
	{
		fprintf(stderr, "EZ DA ARGUMENTURIK PASA, MESEDEZ IP HELBIDEA IDATZI!!!", argv[0]);
		exit(1);
	}
	//----------------------------------------------------------------------------------------

	//----------------------------- SOCKETA SORTU -------------------------------------------
	//SOCKET OBJETUA SORTU(sock identifikadore bat jasoko du)
	
	if((sock = socket(AF_INET, SOCK_STREAM, 0)) ==-1)
	{
		printf("ERROREA SOCKETA SORTZERAKOAN");
		exit(1);

	}
	//SOCKETAREN PARAMETROAK
	zerb_helb.sin_family = AF_INET;
	zerb_helb.sin_port = htons(PORT);
	inet_aton(argv[1],&zerb_helb.sin_addr);
	//------------------------------------------------------------------------------
	
	//----------------- ZERBITZARIAREKIN KONEXIOA EZARRI ----------------------------------
	if(connect(sock, (struct sockaddr *) &zerb_helb, sizeof(zerb_helb)) ==-1)
	{
		printf("ERROREA ZERBITZARIAREKIN KONEKTATZERAKOAN");
		exit(1);
	}
	//-------------------------------------------------------------------------------------
	
	//------------------------------------ DATUAK BIDALI ETA JASO --------------------------
	while(fgets(buf, MAX_BUF, stdin) != NULL)
	{
		m=0;
		//BEZEROARI buf BIDALI
		if(write(sock, buf, strlen(buf))==-1)
		{
			printf("ERROREA MEZUA BIDALTZEAN");
			exit(1);
		}
		//BIDALITAKO MEZUAREN LUZERA GORDETZEN DA
		mezluz=strlen(buf);
		while(m<mezluz)
		{
		//BEZEROAK BIDALITAKOA JASO buf-N
			if((n = read(sock, buf, MAX_BUF))==-1)
			{
				printf("ERROREA MEZUA JASOTZEAN");
				exit(1);
			}
			buf[n]=0; //BUF-EN INFORMAZIOAREN BUKAERA NON DAGOEN ADIERAZTEKO
			//PANTAILARATU JASOTAKO BUF
			printf("Zerbitzaritik jasotako textua : %s" , buf);
			m=m+n;			

		}
		
	}
	//-------------------------------------------------------------------------------------

	//------------------------------- KONEXIOA ITXI ---------------------------------
	if(close(sock)==-1)
		{
			printf("ERROREA KONEXIOA IXTEAN");
			exit(1);
		}
	//-------------------------------------------------------------------------------
}
