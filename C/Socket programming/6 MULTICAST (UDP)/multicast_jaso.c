#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#define MULTICAST "224.0.0.11"
#define IZENAK "Telmo eta Karlos"
#define MAX_BUF 1024
#define PORT 50007

//JASOTZAILEA : GU
//BIDALTZAILEA : MEZUAK BIDALTZEN DITUENA (ZERB)


int main()
{
	//ALDAGAIAK DEFINITU
	int sock, n,ertamaina;
	struct sockaddr_in jasotzailea_helb, bidaltzailea_helb;
	socklen_t helb_tam;
	char buf[MAX_BUF],erantzun[MAX_BUF];
	struct ip_mreq imr;
	//SORTU SOCKETA
	if((sock = socket(AF_INET, SOCK_DGRAM, 0)) < 0)
	{
		perror("Errorea socketa sortzean");
		exit(1);
	}
	//sockaddr_in EGITURA OSOA ZEROZ BETE
	memset(&jasotzailea_helb, 0, sizeof(jasotzailea_helb));
	//sockaddr_in EGITURA GURE DATUEKIN BETE
	jasotzailea_helb.sin_family = AF_INET;
	jasotzailea_helb.sin_addr.s_addr = htonl(INADDR_ANY);
	jasotzailea_helb.sin_port = htons(PORT);
	//SOCK-RI ESLEITU GURE HELBIDEA ETA PORTUA
	if(bind(sock, (struct sockaddr *) &jasotzailea_helb, sizeof(jasotzailea_helb)) < 0)
	{
		perror("Errorea socketari helbide bat esleitzean");
		exit(1);
	}
	
	// IMR EGITURA OSOA ZEROZ BETEZ
	memset(&imr,0,sizeof(imr));
	//MULTICAST EGITURA BETE. ip_mreq EGITURA BETE.
	//MULTICAST HELBIDEA ->  imr.imr_multiaddr = MULTICAST
	inet_aton(MULTICAST,&imr.imr_multiaddr);
	//GURE HELBIDEA -> imr.imr_interface = INADDR_ANY
	imr.imr_interface.s_addr=htonl(INADDR_ANY);
	//JOIN EGIN BIDALTZAILEAREKIN, MULTICAST HELBIDEAREKIN
	//HORRELA MEZUAK JASOTZEN HASIKO GERA
	if(setsockopt(sock, IPPROTO_IP, IP_ADD_MEMBERSHIP, &imr, sizeof(imr))==-1)
	{
		printf("errorea multicast helbidea esleitzerakoan");
		exit(1);
	}

	helb_tam = sizeof(bidaltzailea_helb);
	//BIDALLTZAILEAREN 1GO MEZUA JASO, MULTICAST HELBIDEA DUGULAKO
	if((n=recvfrom(sock, buf, MAX_BUF, 0, (struct sockaddr *) &bidaltzailea_helb, &helb_tam)) < 0)
	{
		perror("Errorea datuak jasotzean");
		exit(1);
	}
	//BIDALTZAILEAREN MEZUA ETA GURE IZENA ALDAGAI BATEAN GORDE
	strcpy(erantzun,buf);
	strcat(erantzun,IZENAK);
		
	ertamaina=strlen(erantzun);
	//JASOTAKOA OK EZ DEN BITARTEAN
	//JASOTAKOA ER BADA, BERRIRO SAIATUKO DA BIDALTZEN
	while(strncmp(buf, "OK", 2) != 0)
		{
		//BIDALI MEZUA
		if(sendto(sock, erantzun, ertamaina, 0, (struct sockaddr *) &bidaltzailea_helb, helb_tam) < 0)
		{
			perror("Errorea datuak bidaltzean");
			exit(1);
		}
		//JASOTZAILEAREN 2GO MEZUA JASO( OK / ER )
		if((recvfrom(sock, buf, MAX_BUF, 0, (struct sockaddr *) &bidaltzailea_helb, &helb_tam)) < 0)	
		{
			printf("Errorea datuak jasotzean");
			exit(1);
		}
		//BUF-EN OK ONDOREN EZABATU
		buf[2]=0;
		printf("iritsi da mezua (Kodea) : %s ",buf);
	}		
		
	//MULTICAST HELBIDEA ASKATU ( LEAVE ) GURE SOCKETETIK
	if(setsockopt(sock, IPPROTO_IP, IP_DROP_MEMBERSHIP, &imr, sizeof(imr))==-1)
	{
		printf("errorea multicast helbidea esleitzerakoan");
		exit(1);
	}
	//SOCKETA ITXI	
	close(sock);

	//PROGRAMA AMAITU DELA JAKINARAZI
	printf("\n-- PROGRAMA AMAITU DA!!! ----\n");
}
