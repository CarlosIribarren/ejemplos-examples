//-------------------------------------------------------------------------
// ------------------------ ECHO bezeroa UDP erabiliz --------------
//-------------------------------------------------------------------------
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>

#define MAX_BUF 1024
#define PORT 50001

//----------------------- ARGV ----------------------------
// [ PROG_IZENA, ZERB_IP_HELB ]
//-------------------------------------------------------

int main(int argc, char *argv[])
{
	//------------------------- DEFINIZIOAK ------------------------------------
	//BUFFERRA KARAKTERE KATEA DATUAK JASOTZEKO
	char buf[MAX_BUF];
	//SOCKETAREN IDENTIFIKAZIORAKO ZENBAKIA
	int sock;
	//MEZUAREN LUZEERA
	int n=0;
	//HELBIDEA ALDAGAIAK
	struct sockaddr_in zerb_helb,bez_helb;
	//-------------------------------------------------------------------------

	// -------------- EGIAZTATU ARGUMENTU BAT PASA DELA -----------------------
	if(argc != 2)
	{
		fprintf(stderr, "ARGUMENTUA FALTA, IP HELBIDE BAT SARTU BEHAR DA!!!!", argv[0]);
		exit(1);
	}
	//-------------------------------------------------------------------------
	
	//------------------------- SOCKETA SORTU ------------------------------------
	//SOCKET OBJETUA SORTU(sock identificadore bat jasoko du)
	sock = socket(AF_INET,SOCK_DGRAM,0);	
	
	//BEZEROAREN SOCKET PARAMETROAK
	bez_helb.sin_family = AF_INET;
	//HOBEKUNTZA= BEZEROAK EZ DU ZERGATIK PORTU JAKIN BAT ERABILI BEHAR,
	//HORRELA SISTEMA ERAGILEAK LIBRE DAGOENA AUKERATUKO DU
	bez_helb.sin_port = 0;
	//ZERBITZAREAREN IP HELBIDEA
	bez_helb.sin_addr.s_addr = htonl(INADDR_ANY);
	
	//ZERBITZARIA HASIERATU
	zerb_helb.sin_family = AF_INET;
	zerb_helb.sin_port = htons(50001);
	//ZERBITZARIA IP HELBIDEA
	//IP helbide bat -> 32 biteko helbide batera itzultzen du
	inet_aton(argv[1],&zerb_helb.sin_addr);
	
	//SOCKETARI PARAMETRO(helbidea,) ETA PORTUAK ASIGNATU
	bind(sock, (struct sockaddr *) &bez_helb, sizeof(bez_helb));
	
	//------------------------------------------------------------------------------------------------------
	
	//------ TEXTUA TEKLATUTIK IRAKURRI, BIDALI ZERBITZARIARI ETA JASOTAKOA PANTAILAN INPRIMATU -------------
	while(fgets(buf, MAX_BUF, stdin) != NULL)
	{
		//KARAKTERE KATEA BIDALI
		sendto(sock, buf,strlen(buf),0,(struct sockaddr *) &zerb_helb,sizeof(zerb_helb));
		//Erantzunaren jasoera
		n=recvfrom(sock,buf,MAX_BUF,0,NULL,NULL);
		buf[n]=0;
		//Erantzuna inprimatu
		printf("Zerbitzaritik jasotako textua : %s" , buf);
	}
	//-------------------------------------------------------------------------------------------------------
		//SOCKETA ITXI
		close(sock);
}
