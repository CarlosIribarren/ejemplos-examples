#include <stdio.h>
#include <stdlib.h>
#include <string.h>


#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <sys/select.h> // select funtziorako
#include <signal.h>

#define MAX_BUF 1024
#define PORT 50005
#define MAX_WAIT 120 // Itxoite denbora maximoa

int main()
{
	
	//SOCKETAREN IDENTIFIKAZIO ZENBAKIAK 	
	int sock,elkarrizketa;
	//PID ETA SELECTAREN ALDAGAI LAGUNTZAILEAK
	int pid,i,n;
	//HELBIDE ALDAGAIAK	
	struct sockaddr_in zerb_helb, bez_helb;
	socklen_t helb_tam;
	//SELECT AGINDUKO DENBORA KONTROLATZEKO ALDAGAIA
	struct timeval denbora;
	fd_set readfds;
	char buf[MAX_BUF];
	
	//SOCKETAREN SORRERA
	if((sock = socket(AF_INET, SOCK_DGRAM, 0)) < 0)
	{
		perror("Errorea socketa sortzean");
		exit(1);
	}
	//zerb_helb-EN HASIERAKETA
	memset(&zerb_helb, 0, sizeof(zerb_helb));
	zerb_helb.sin_family = AF_INET;
	zerb_helb.sin_addr.s_addr = htonl(INADDR_ANY);
	zerb_helb.sin_port = htons(PORT);
	//SOCKETARI PARAMETRO(helbidea,) ETA PORTUAK ASIGNATU
	if(bind(sock, (struct sockaddr *) &zerb_helb, sizeof(zerb_helb)) < 0)
	{
		perror("Errorea socketari helbide bat esleitzean");
		exit(1);
	}
	//UME ZONBIAK EKIDITEKO
	if(signal(SIGCHLD,SIG_IGN) == SIG_ERR)
	{
		printf("errorea signalean");
	}
		
	while(1)
	{
		helb_tam = sizeof(bez_helb);
		//1. MEZUA JASOTZEN DU BEZEROTIK GURASO ZERBITZARIAK
		if((n=recvfrom(sock, buf, MAX_BUF, 0, (struct sockaddr *) &bez_helb, &helb_tam)) < 0)
		{
			perror("Errorea datuak jasotzean");
			exit(1);
		}
		//UME BAT SORTU , PID UMEA=0 ETA  PID GURASOA=UMEAREN PID
		pid = fork();	
		switch(pid)
		{
			//PROZESU UMEA
			case(0):
				//HASIERAN SORTURIKO SOCKETA (GURASOARENA) ITXI EGINGO DA
				close(sock);
				//SOCKET BERRIA SORTU
				//SOCKET HAU BEZEROAREKIN KOMUNIKATZEKO ERABILIKO DA
				if((elkarrizketa = socket(AF_INET, SOCK_DGRAM, 0)) == -1)
				{
					printf("errorea ume socketa sortzean");
					exit(1);
				}
				if(connect(elkarrizketa,(struct sockaddr *) &bez_helb, sizeof(bez_helb)) == -1)
				{
					printf("errorea connect egitean");
					exit(1);
				}
				
				
				while ( n > 0)
				{
						//DESKRIPTORE BAT EZARRI,KENDU EDO AZTERTZEKO FUNTZIOEN HASIERAKETA(FD_ZERO,FD_SET)
						
						FD_ZERO(&readfds);		
    						FD_SET(elkarrizketa, &readfds);		
						//DENBORA TARTEAREN SEGUNDO KOPURUA ESLEITU
						denbora.tv_sec = MAX_WAIT;		
        					//DENBORA TARTEAREN MIKROSEGUNDU KOPURUA
						denbora.tv_usec = 0;		
						//MEZUA IDATZI
						if(write(elkarrizketa, buf, n) == -1)
						{	
							printf("errorea idaztean");
							exit(1);
							
						}	
						// SELECT=0 denenean DENBORA AGORTU DA ETA EZ DAGO BEZERORIK
						//SELECT > 0 PREST DAUDEN DESKRIPTORE KOPURUA
						i = select(elkarrizketa+1, &readfds, NULL, NULL, &denbora); 
						

								switch(i)
								{
									//EZ DAGO BEZERORIK ZAIN
									case(0): 
										printf("Bukatu da itxarote denbora");		
										close(elkarrizketa);					
										exit(1);
									
									//ERROREA SELECTEAN
									case(-1): 
										printf("errorea selectean");
										exit(1);
									//BEZEROA DAGO ZAIN
									default: 
										
										if((n=read(elkarrizketa, buf, MAX_BUF)) == -1)
										{
											printf("errorea mezua jasotzean");
											exit(1);
										}
						
								}
					}
			//ELKARRIZKETA SOCKETA ITXI			
				close(elkarrizketa);							
				exit(0);	
			//ERROREA FORKEN
			case (-1): 
				printf("ERROREA FORK");
			//GURASO PROZESUA
			default:	break; 
		
		}
	}
	//SOCKETA ITXI
	close(sock);
}
