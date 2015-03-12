#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <netdb.h>
#define MAX_BUF 1024
#define PORT 50005
int main(int argc, char *argv[])
{
	//ALDAGAIAK 
	int sock, n;
	char buf[MAX_BUF];
	struct sockaddr_in zerb_helb, zerb_helb_2;
	struct hostent *hp;
	socklen_t helb_tam;
	//ARGUEMNTUAK PASA DIRELA EGIAZTATU
	if(argc != 2)
	{
		fprintf(stderr, "Erabilera: %s <zerbitzari izena | IPv4 helbidea>\n", argv[0]);
		exit(1);
	}
 
	//SOCKET OBJETUA SORTU(sock identificadore bat jasoko du)
	if((sock = socket(AF_INET, SOCK_DGRAM, 0)) < 0)
	{
		perror("Errorea socketa sortzean");
		exit(1);
	}
	//BEZEROAREN SOCKET PARAMETROAK
	memset(&zerb_helb, 0, sizeof(zerb_helb));
	zerb_helb.sin_family = AF_INET;
	zerb_helb.sin_port = htons(PORT);
	//ERABILTZAILEARI AUKERA EMAN IP EDO HELBIDEA IDAZTEKO
	if((hp = gethostbyname(argv[1])) == NULL)
	{
		herror("Errorea zerbitzariaren izena ebaztean");
		exit(1);
	}
	memcpy(&zerb_helb.sin_addr, hp->h_addr, hp->h_length);

	//ALDAGAIA HASIERATU
	helb_tam = sizeof(zerb_helb_2);

	if(fgets(buf, MAX_BUF, stdin) == NULL)
	{
		printf("errorea irakurtzean");
	}

	//-------------------------1. MEZUA ZERBITZARI GURASOARI BIDALI ---------------------------------------------
	//MEZU HONEKIN ZERBITZARIARI ADIERAZIKO DIOGU ALEGIAZKO KONEXIOA BURUTUKO DELA
	//ZERBITZARIAK MOMENTU HORRETAN ZERBITZARI UME BAT SORTUKO DU BEZEROAREN ELKARRIZKETA ZERBITZATZEKO
	if(sendto(sock, buf, strlen(buf), 0,(struct sockaddr *) &zerb_helb, sizeof(zerb_helb)) == -1)	
	{
		printf("errorea mezua socketari bidaltzean");
		exit(1);
	}

	//------------------------- 1. MEZUA ZERBITZARI UMETIK JASO --------------------------------------------------------------------
	//ZERBITZARI GURASOAK SORTU DUEN ZERBITZARI UMEAK BIDALI DU MEZUA ETA ZERBITZARI GURASOAREN HELBIDE DESBERDINA DAUKA UMEAK
	//HEMENDIK AURRERA ZERBITZARI UMEAREN HELBIDEA(zerb_helb_2) ERABILIKO DA MEZUAK BIDALTZEKO
	if((n = recvfrom(sock, buf, MAX_BUF,0,(struct sockaddr *) &zerb_helb_2, &helb_tam))== -1)
	{
		printf("errorea mezua jasotzean");
		exit(1);
	}
	//JASO DITUGUN MEZUEN BUKAERA ADIERAZTEKO
	buf[n]=0;
	//PANTAILARATU MEZUA
	printf("%s",buf); 
	
	//ALEGIAZKO KONEXIOA EGITEN DA ZERBITZARI UMEAREKIN(zerb_helb_2)-
	if(connect(sock, (struct sockaddr *) &zerb_helb_2, sizeof(zerb_helb_2)) < 0)
	{
		perror("Error zerbitzariarekin konektatzean");
		exit(1);
	}

	//DATUAK BIDALI ETA JASO ZERBITZARI UMEAREKIN
	while(fgets(buf, MAX_BUF, stdin) != NULL)
	{	
		//MEZUA BIDALI 
		if(write(sock, buf, strlen(buf)) < strlen(buf))
		{
			perror("Errorea datuak bidaltzean");
			exit(1);
		}
		//MEZUA JASO 
		if((n = read(sock, buf, MAX_BUF)) < 0)
		{
			perror("Errorea datuak jasotzean");
			exit(1);
		}
		//MEZUA BUKATU DELA ADIERAZTEKO
		buf[n] = 0;
		//JASOTAKO MEZUA PANTAILARATU
		printf("%s",buf);
	}

	// ZERBITZARI UMEARI MEZU HUTSA BIDALTZEN ZAIO ESANEZ BEZEROAK BUKATU DUELA 
	if(write(sock, NULL, 0) == -1)
	{
		printf("errorea mezu hutsa bidaltzean");
		exit(1);
	}
	//SOCKETA ITXI
	close(sock);
	exit(0);
}
