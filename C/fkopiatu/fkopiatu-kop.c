
/* Fitxategi bat kopiatzen du sarrera estandarretik 
   irteera estandarrera, fread eta fwrite deiak erabiliz. */

#include <stdio.h>
#include <stdlib.h>
#include <errno.h>

#define errore(a) {perror(a); exit(-1);};
#define BUFSIZE 512

main (int argc, char *argv[])   /* fkopiatu-kop.c */
{
   int n, kopurua = BUFSIZE;
   char buf[BUFSIZE];

   if (argc == 2) {
      kopurua = atoi(argv[1]);
      if ((kopurua < 1) || (kopurua > 512))
         errore("kopurua ez dago 1..512 tartean\n");
   }

   /* irakurketa eta idazketa zikloa */
   while ((n = fread(buf, sizeof(char), kopurua, stdin)) > 0)
      if (fwrite(buf, sizeof(char), n, stdout) != n) errore("fwrite");

   if (n == -1) errore("fread");
}
