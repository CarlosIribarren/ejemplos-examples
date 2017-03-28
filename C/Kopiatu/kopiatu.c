
/* Fitxategi bat kopiatzen du sarrera estandarretik 
   irteera estandarrera, read eta write deiak erabiliz. */

#include <stdio.h>
#include <stdlib.h>
#include <errno.h>

#define errore(a) {perror(a); exit(1);};
#define BUFSIZE 512

main (int argc, char *argv[])   /* kopiatu.c */
{
   int n;
   char buf[BUFSIZE];

   /* irakurketa eta idazketa zikloa */
   while ((n = read(0, buf, BUFSIZE)) > 0)
      if (write(1, buf, n) != n) errore("write");

   if (n == -1) errore("read");
}
