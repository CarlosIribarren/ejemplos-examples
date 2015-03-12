//-------------------------------------------------------------------------
// ------------------------ Daytime zerbitzaria UDP erabiliz --------------
//-------------------------------------------------------------------------
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>

#define MAX_BUF 1024
#define PORT 50001

//------------------------- DEFINIZIOAK ------------------------------------
//SOCKETAREN IDENTIFIKAZIORAKO ZENBAKIA
int sock;
//HELBIDEA ALDAGAIAK
struct sockaddr_in zerb_helb, bez_helb;
//HELBIDEAREN TAMAINA
socklen_t helb_tam;
//BUFFERRA KARAKTERE KATEA
char buf[MAX_BUF];
//TIME ALDAGAIA
time_t ticks;
//---------------------------------------------------------------------------

//------------------------- SOCKETA SORTU ------------------------------------
//SOCKET OBJETUA SORTU(sock identificadore bat jasoko du)
sock = socket(AF_INET, SOCK_DGRAM, 0);
//SOCKETAREN PARAMETROAK
zerb_helb.sin_family = AF_INET;
zerb_helb.sin_addr.s_addr = htonl(INADDR_ANY);
zerb_helb.sin_port = htons(PORT);
//SOCKETARI PARAMETRO(helbidea,) ETA PORTUAK ASIGNATU
bind(sock, (struct sockaddr *) &zerb_helb, sizeof(zerb_helb));
//---------------------------------------------------------------------------

//------------- KOMUNIKATU SOCKETAREN BITARTEZ ----------------------
while(1)
{
	//BEZEROAREN HELBIDEAREN TAMAINA PRESTATZEN
	helb_tam = sizeof(bez_helb);
	//SOCKETA DATUAK JASO buf-EN ETA BEZEROAREN HELBIDEA JASO ERE
	recvfrom(sock, buf, MAX_BUF, 0,	(struct sockaddr *) &bez_helb, &helb_tam);
	//TIME PARAMETROA 
	ticks = time(NULL);
	//TIME PARAMETROA buf-EN GORDE
	snprintf(buf, MAX_BUF, "%s\r\n", ctime(&ticks));
	//SOCKETA BIDALI BEZEROARI ARRAIAREN TAMAINA MUGATUZ
	sendto(sock, buf, strlen(buf), 0, (struct sockaddr *) &bez_helb, helb_tam);
}