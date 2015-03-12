#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <unistd.h>
#include <signal.h>

#define MAX_BUF 1024
#define PORT 50004


int main()
{
	//------------------------- DEFINIZIOAK -------------------------------------
	//SOCKETAREN IDENTIFIKAZIOA JASOTZEKO
	int sock, elkarrizketa;
	//BUFFERREAN JASOTZEN DEN BYTE KOPURUA
	int	n;
	//HELBIDEAK GORDETZEKO
	struct sockaddr_in zerb_helb;
	//BUFERRA KARAKTERE KATEA GORDETZEKO
	char buf[MAX_BUF];
	//---------------------------------------------------------------------------
	
	//------------------------- SOCKETA SORTU ------------------------------------
	//SOCKET OBJETUA SORTU(sock identifikadore bat jasoko du)
	if((sock = socket(AF_INET, SOCK_STREAM, 0)) < 0)
	{
		perror("Errorea socketa sortzean");
		exit(1);
	}
	//SOCKETAREN PARAMETROAK
	memset(&zerb_helb, 0, sizeof(zerb_helb));
	zerb_helb.sin_family = AF_INET;
	zerb_helb.sin_addr.s_addr = htonl(INADDR_ANY);
	zerb_helb.sin_port = htons(PORT);
	//SOCKETARI PARAMETRO(helbidea,) ETA PORTUAK ASIGNATU
	if(bind(sock, (struct sockaddr *) &zerb_helb, sizeof(zerb_helb)) < 0)
	{
		perror("Errorea socketari helbidea esleitzean");
		exit(1);
	}
	//----------------------------------------------------------------------------
		
	// SOCKETA ENTZUTE MODUAN JARRI 
	if(listen(sock,5) < 0)
	{
		perror("Errorea socketa entzute socket bezala ezartzean");
		exit(1);
	}

	if ( signal(SIGCHLD, SIG_IGN)==SIG_ERR)
	{
		perror("Errorea signalen");
		exit(1);
	}
		

	//BEGIZTA INFINITUA
	while(1)
	{
		//ONARTU KONEXIO BERRI BAT ETA SOCKET BERRI BAT SORTU ELKARRIZKETA IDENTIFIKADOREAREKIN
		if((elkarrizketa = accept(sock, NULL, NULL)) < 0)
		{
			perror("Errorea konexioa onartzean");
			exit(1);
		}
		
		if(fork() == -1)
		{
			perror("Errorea umea sortzean");
			exit(1);
		}
		else
		{
			if ( fork() !=0 )
			{	
				//GURASOA TRATAMENDUA
				close(elkarrizketa);
			}	
			else
			{	
				//UMEAREN TRATAMENDUA
				close(sock);
				//DATUAK IRAKURRI ETA BIDALI
				while((n=read(elkarrizketa, buf, MAX_BUF)) > 0)
				{
					if(write(elkarrizketa, buf, n) < n)
					{
						perror("Errorea erantzuna bidaltzean");
						close(elkarrizketa);
						exit(1);
					}
				}
				if(n < 0)
					perror("Errorea mezua irakurtzean");
				//BEZEROAREN ELKARRIZKETA BUKATU
				close(elkarrizketa);
				exit(0);
		
			}
		}
			

	}
}
