
/* Programa honek parametro gisa pasatzen zaion fitxategiaren 
   azken 10 karaktereak idazten ditu irteera estandarrean.*/

#include <stdio.h>
#include <stdlib.h>
#include <errno.h>
#include <fcntl.h>

#define errore(a) {perror(a); exit(1);};

main (int argc, char *argv[])   /* buztana.c */
{
   int fd, l;
   char buf[80];

   if ((fd = open(argv[1], O_RDONLY, 0666)) == -1) errore("open");

   if (lseek(fd, -10L, 2) == -1) errore("lseek");

   if ((l = read(fd, buf, 10)) != 10) errore("read");

   if (write(1, buf, l) != l) errore("write");

   close(fd);
}
