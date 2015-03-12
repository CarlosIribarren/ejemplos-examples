#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <netdb.h>		// gethostbyname funtzioarentzat.
#include <sys/time.h>	// select funtzioarentzat.

#define MAX_BUF 1024
#define PORT 50003
#define TIMER 1					// Birtransmisio bat egin baino lehen zain egon behar den denbora segundotan.
#define SAIAKERA_MAX 3	// Bidalketa kopuru maximoa mezu batentzat.


int main(int argc, char *argv[])
{
	//SOCKETAREN IDENTIFIKAZIOA JASOTZEKO
	int sock; 
	//KONTAGAILUAK
	int n,saiakera,bez_kop;
	//BUFERRA KARAKTERE KATEA GORDETZEKO
	char buf[MAX_BUF];
	//HELBIDEAK GORDETZEKO
	struct sockaddr_in zerb_helb;
	
	struct  hostent *zerbitzari;
	fd_set readfds;
	//ITXAROTE DENBORA KONTROLATZEKO
	struct timeval denbora;
	//DENBORAREN HASIERAKETA
	denbora.tv_sec=TIMER;
	denbora.tv_usec=0;
	// EGIAZTATU ARGUMENTU BAT PASA DELA.
	if(argc != 2)
	{
		fprintf(stderr, "Erabilera: %s <zerbitzari izena | IPv4 helbidea>\n", argv[0]);
		exit(1);
	}
	
	//----------------------------SOCKETAREN SORRERA-----------------------
	//SOCKET OBJETUA SORTU(sock identifikadore bat jasoko du)
	if((sock = socket(AF_INET, SOCK_DGRAM, 0)) < 0)
	{
		perror("Errorea socketa sortzean");
		exit(1);
	}
	//SOCKETAREN PARAMETROAK

	memset(&zerb_helb, 0, sizeof(zerb_helb));
	zerb_helb.sin_family = AF_INET;
	zerb_helb.sin_port = htons(PORT);
	//--------------------------------------------------------------------------

	//--------------------IP HELBIDEA LORTU DNS IZENAREN BITARTEZ-----------------

	if ((zerbitzari = gethostbyname(argv[1])) == NULL)	
	
	{	
		fprintf(stderr,"Errora lehenbiziko parametroan: %s\n", argv[1]);
		exit(1);

	}
	//----------------------------------------------------------------------------
	
	//ZERBITZARIKO HELBIDE ZERRENDAKO LEHENBIZIKOAREN ESLEIPENA zerb_helb aldagaiari
	memcpy(&zerb_helb.sin_addr, zerbitzari->h_addr_list[0],zerbitzari->h_length);
	

	//----------------- KONEXIOA----------------------------------------------------------
	if(connect(sock, (struct sockaddr *) &zerb_helb, sizeof(zerb_helb)) ==-1)
	{
		printf("ERROREA KONEKTATZEAN\n");
		exit(1);
	}
	//-------------------------------------------------------------------------------------

	//------------------------------------ DATUAK BIDALI ETA JASO --------------------------
	while(fgets(buf, MAX_BUF, stdin) != NULL)
	{
		//BIDALKETA PROZESUA
		if ((n = write(sock, buf, strlen(buf))) == -1)
		{
			printf("ERROREA DATUAK BIDALTZEAN");
			exit(1);
		}
		saiakera=0;

		//------------BIRTRANSMISIO PROZESUA--------------------------------------

		while (saiakera++ < SAIAKERA_MAX)		
		{
			//fd_set-en ALDAGAIAK HASIERATU			
			FD_ZERO(&readfds);		
    			FD_SET(sock, &readfds);			
			//denbora-ren parametroak hasieratu			
			denbora.tv_sec = TIMER;		
        		denbora.tv_usec = 0;		
			bez_kop = select(sock+1, &readfds, NULL, NULL, &denbora);	
			if (bez_kop==-1) 
			{
				printf("ERROREA SELECTEAN");
				exit(1);
			}	


			//BEZERORIK EZ DAGO ERANTZUTEKO, SAIAKERA GALDUA
			if (bez_kop==0)	
			{
				printf("Itxarote denbora agortua!!!  %d  .saiakera burutua \n", saiakera);
				if ((n = write(sock, buf, strlen(buf))) == -1)
				{
					printf("ERROREA BIDALKETAN");
					exit(1);
				}

			}

			//DATAGRAMA ONGI JASO DA
			else break; 	
		}
		//-----------------------------------------------------------------------------------------------------

		if(saiakera ==4 )
		{
			printf("\n Saiakera kopurua agortuta, honenbestez programa amaituko da \n");
			exit(1);
		}
		//SOCKETETIK IRAKURTZEA
		if(read(sock, buf, n) == -1)			
		{
			printf("ERROREA DATUAK JASOTZEAN");
			exit(1);	
		}
		
		buf[n] = 0;
		//PANTALLAN INPRIMITUKO DA JASOTAKO MEZUA
		printf("%s",buf);	
	
	}
	close(sock);
	exit(0);
}
