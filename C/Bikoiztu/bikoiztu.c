#include <stdio.h>
#include <stdlib.h>
#include <errno.h>
#include <fcntl.h>
#define errore(a){perror(a);exit(1);};
#define BUFSIZE 512
main (int argc, char *argv[])
{
int n,fd;
char buf[BUFSIZE];
	//argumentuen tratamendua
	if (argc != 2) errore("argumentuak gaizki daude.");

	//fitxategia ireki
	if ((fd=open(argv[1],O_WRONLY)) == -1) errore("open");

	//Sarrera stand irakurri
	while ((n=read(0,buf,BUFSIZE))>0)
	{
		if (write(1,buf,n) !=n ) errore("write");
		if (write(fd,buf,n) !=n) errore("write");	
	}	
	if (n==-1)errore("read");	 

}
