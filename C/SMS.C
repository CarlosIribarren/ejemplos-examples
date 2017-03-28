// Makina.h

#include <dos.h>
#include <conio.h>
#include <stdio.h>
#include <stdlib.h>

#define HELB_PANT_MOTA   0x0449
#define OHELB_PANT_MOTA1 0xB000
#define OHELB_PANT_MOTA2 0xB800

#define OHELB_PANT_GRAF 0xA000	// Pantaila grafikoaren oinarri helbidea

#define INDIZE_ERREG_CRTC 0x3D4   // Bideo kontroladorearen indize-erregistroa
#define DATU_ERREG_CRTC   0x3D5   // Bideo kontroladorearen datu-erregistroa


#define DATU_ERREG_TEKLATU  0x60
#define KONTROL_ERREG_TEKLATU 0x61

#define KONTROL_ERREG_EK8259 0x20
#define MASKARA_ERREG_EK8259 0x21

#define MASK_BREAK  0x80
#define MASK_MAKE   0x80
#define MASK_STROBE_TEK_1 0x80
#define MASK_STROBE_TEK_0 0x7F

#define MASK_IRR_TEK 0x02
#define MASK_IMR_TEK_1 0x02
#define MASK_IMR_TEK_0 0xFD

#define BAL_EOI 0x20

#define EnableInts()	enable()
#define DisableInts()	disable()

#define InPort(port)       inp((port))
#define OutPort(port,bal)  outp((port),(bal))

#define InPortW(port)       inpw((port))
#define OutPortW(port,bal)  outpw((port),(bal))

#define Ip(name)  FP_OFF((name))
#define Cs(name)  FP_SEG((name))

//----------------------------------------------------------------------
unsigned char IrakurByteFis(unsigned short Seg, unsigned short Desp)
{
	return( peekb(Seg,Desp));
}

unsigned short IrakurHitzFis(unsigned short Seg, unsigned short Desp)
{
	   return( peek(Seg,Desp));
}

void IdatzByteFis(unsigned short Seg, unsigned short Desp, unsigned char k)
{
	pokeb(Seg,Desp,k);
}

void IdatzHitzFis(unsigned short Seg, unsigned short Desp,
			unsigned short h)
{
	poke(Seg,Desp,h);
}
//----------------------------------------------------------------------
void AldatuEB(int sarrera, unsigned short IPBerria, unsigned short CSBerria,
				unsigned short * IPZah, unsigned short * CSZah)
{DisableInts();
*IPZah = IrakurHitzFis(0x0,4*sarrera);
*CSZah = IrakurHitzFis(0x0,(4*sarrera)+2);
IdatzHitzFis (0x0,4*sarrera,IPBerria);
IdatzHitzFis (0x0,(4*sarrera)+2, CSBerria);
EnableInts();
	// Eten-bektorea aldatu "sarrera" adierazten duen osagaian.
	// Bertako balio berriak parametro bezala pasatzen zaizkigu,
	// baita ere non utzi balio zaharrak gero berreskuratu ahal
	// izateko. Aldatu bitartean etenak galerazi behar dira.
}

void BerreskuratuEB(int sarrera, unsigned short IPZah, unsigned short CSZah)
{DisableInts();
IdatzHitzFis(0,4*sarrera,IPZah);
IdatzHitzFis(0,4*sarrera +2, CSZah);
EnableInts();
	// Eten-bektorean berreskuratuko dira "sarrera" osagaiak
	// zituen hasierako balioak. Balio horiek parametro bezala
	// pasatzen zaizkigu. Lehen bezala, aldatu bitartean etenak
	// galerazi behar dira.
}

void Eoi()
{OutPort(0x20,0x20);
   //Etenen kontroladoreari Zerbitzu Errutina baten amaiera adierazteko.
}
//----------------------------------------------------------------------
//  Pantalla.h

						//  Atzekaldea   Karakterea
						//  xxxx    xxxx
#define ATRIB_NORMALA    	 0x07    	//  BELTZA  ZURIA
#define ATRIB_GORRI_URDIN 	 0x41		//  GORRIA  URDINA
#define ATRIB_BERDE_ZURI    0x27   		//  BERDEA  ZURIA
#define ATRIB_URDINL_GORRIL  0x9C    	//  URDIN L. GORRI L.

//----------------------------------------------------------------------
unsigned short PantHas;

unsigned short PantHelb()
{
	unsigned char PantModua =IrakurByteFis(0, HELB_PANT_MOTA);

	switch(PantModua)
	{
		case 7:  return (OHELB_PANT_MOTA1);
		case 2:
		case 3:  return (OHELB_PANT_MOTA2);
		default: return (0);
	}
}

void IdatzKar(int lerro, int zut, unsigned char kar, unsigned char atrib)
{
	IdatzByteFis(PantHas, ((lerro*80)+zut)*2, kar);
	IdatzByteFis(PantHas, (((lerro*80)+zut)*2)+1, atrib);
}

void IdatzTestu(int lerro, int zut, char * testu, unsigned char atrib)
{
	int i;

	for (i=0; i<strlen(testu);i++)
	{
		IdatzKar(lerro,zut+i,testu[i],atrib);
	}

}

void PantEzabatu()
{

	int i,j;

	for (i=0;i<25;i++)
		for (j=0;j<80;j++)
		{
			IdatzKar(i,j,' ',ATRIB_NORMALA);
		}
}

void IrakurKarPant(int lerro, int zut, unsigned char *kar, unsigned char *atrib)
{
	*kar   = IrakurByteFis(PantHas, ((lerro*80)+zut)*2);
	*atrib = IrakurByteFis(PantHas, (((lerro*80)+zut)*2)+1);
}


void ScrollPant(int LerroKop)
{

	int i,j;
	unsigned char kar, atrib;

	for (i=LerroKop;i<25;i++)
		for (j=0;j<80;j++)
		{
			IrakurKarPant(i,j,&kar,&atrib);
			IdatzKar(i-LerroKop,j,kar,atrib);

		}
	for (i=24;i>24-LerroKop; i--)
		for (j=0; j<80; j++)
			IdatzKar (i, j, ' ', ATRIB_NORMALA);

}

void JarriKurtsore(int x, int y)
{

	unsigned int pos = x*80+y;

	unsigned char ZatiBaxua, ZatiAltua;

	ZatiBaxua = (unsigned char) pos;

	ZatiAltua = (unsigned char) (pos >>8);

	OutPort(INDIZE_ERREG_CRTC,15);
	OutPort(DATU_ERREG_CRTC,ZatiBaxua);

	OutPort(INDIZE_ERREG_CRTC,14);
	OutPort(DATU_ERREG_CRTC,ZatiAltua);

}

void IrakurKurtsorePos(int *x, int *y)
{

	unsigned int Pos ;

	unsigned char ZatiBaxua, ZatiAltua;

	OutPort(INDIZE_ERREG_CRTC,15);	// Zati Baxua duen erregistroa aukeratu
	ZatiBaxua = InPort(DATU_ERREG_CRTC);

	OutPort(INDIZE_ERREG_CRTC,14);	// Zati Altua duen erregistroa aukeratu
	ZatiAltua = InPort(DATU_ERREG_CRTC);
	Pos = ZatiAltua << 8;
	Pos |= ZatiBaxua;

	*x = Pos / 80;
	*y = Pos % 80;

}


void KurtsoreForma(int Hasi, int Buk)
{

	unsigned char H, B;

	H =  (unsigned char) Hasi;
	B =  (unsigned char) Buk;

	OutPort(INDIZE_ERREG_CRTC,10);	// Hasiera-lerroa jarri
	OutPort(DATU_ERREG_CRTC,H);

	OutPort(INDIZE_ERREG_CRTC,11);	// Bukaera-lerroa jarri
	OutPort(DATU_ERREG_CRTC,B);

}
//----------------------------------------------------------------------
unsigned char IRR_Irakurri()
{
	// IRR erregistroaren edukia itzultzen duen funtzioa
	unsigned char bal;
	OutPort (0x20, 0x0A);
	bal = InPort (0x20);
	return bal;	
}

unsigned char TeklatuDatErregIrakurri()
{
	// Teklatuaren datu-erregistroaren edukia itzultzen duen funtzioa
	unsigned char teklakod;
	teklakod = InPort (0x60);
	return teklakod;	
}

void TeketenGalarazi()
{
	// Teklatuaren etenak maskaratzen dituen funtzioa. Hori egin bitartean etenak
	// galeraziko dira (IF=0) eta bukatu eta gero baimenduko dira berriz (IF=1)
	unsigned char bal;
	DisableInts();
	bal= InPort (0x21);
	bal= bal|0x02;
	OutPort(0x21,bal);
	EnableInts();
}

void TeketenBaimendu()
{
	// Teklatuaren etenak baimentzen dituen funtzioa. Hori egin bitartean etenak
	// galeraziko dira (IF=0) eta bukatu eta gero baimenduko dira berriz (IF=1)
	unsigned char bal;
	DisableInts();
	bal = InPort (0x21);
	bal = bal & 0xFD;
	OutPort (0x21,bal);
	EnableInts();
}


void StrobeTeklatu()

{	unsigned char bal;
	bal = InPort (0x61);
	bal = bal|0x80;
	OutPort (0x61, bal);
	bal = bal & 0x7F;
	OutPort (0x61, bal);
}

//----------------------------------------------------------------------
#define LIMITEA 10
#define ATZERAPEN1 10
#define ATZERAPEN2 50000

void Atzeratu(int n)
{
   long i,j;

   for(i=0;i<ATZERAPEN1*n;i++)
	for (j=0;j<ATZERAPEN2; j++) ;
}

#define HASIERA 0
#define BUKATU 1
#define AMAITU 2
#define DINAMIC 3
#define BIDALTZEN 4
#define NORABIDALI 5
#define IDATZIL 6
#define IDATZIZ 7
#define BUKATUMEZUA 8
#define TAULA_A 9
#define TAULA_B 10
#define TAULA_C 11
int aukerak,ae,letrak,ok,azk,i;
unsigned short IPOldErlojua, CSOldErlojua;
unsigned short IPOldTek, CSOldTek;
unsigned char irr,scankode;
unsigned char TAULAA[] = {' ','A','D','G','J','M','O','R','U','X'};
unsigned char TAULAB[] = {' ','B','E','H','K','N','P','S','V','Y'};
unsigned char TAULAC[] = {' ','C','F','I','L','¥','Q','T','W','Z'};

unsigned char ASCII_TAULA[] = {
'*', 27 , '1', '2', '3', '4', '5', '6', '7', '8', '9', '0','\'', '­',   8,  // 14
9 , 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', '`', '+',  13, '*',  // 29
'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', '¥', '*', '§',  14, '‡',       // 43
'Z', 'X', 'C', 'V', 'B', 'N', 'M', ',', '.', '-',  15,                // 54
'*', '*', ' ', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', // 68
'*', '*', '7', '8', '9', '-', '4', '5', '6', '+', '1', '2', '3', '0', // 82
'.', '*', '*', '<', '*', '*', '*', '*', //90
};
//----------------------------------------------------------------------


//-------------------------------------------------------------
//---------- ZERBITZU ERRUTINA ERLOJUA ------------------------
//------------------------------------------------------------
int t1seg,t3seg,t5seg;
void interrupt ZerErrErl()
{
  if ( ae==DINAMIC )
  {
  t1seg=0;
  t3seg=0;
  t5seg=0;
  }

  if ( ae == TAULA_A )
   {
    t1seg++;
    if ( t1seg == 18 )
     {
      ae = TAULA_B;
      t1seg=0;
     }
   }
  if ( ae == TAULA_B )
   {
    t1seg++;
    if ( t1seg == 18 )
     {
      ae = TAULA_C;
      t1seg=0;
     }
    }
   if ( ae == TAULA_C )
    {
     t1seg++;
     if ( t1seg == 18 )
     {
       ae = TAULA_A;
       t1seg=0;
     }
    }

   if ( ae == BUKATUMEZUA )
   {
     t3seg = t3seg +1;
     if ( t3seg==54)
     {
       ae=DINAMIC;
       t3seg=0;
     }
   }
      if ( ae == BUKATU )
   {
     t3seg = t3seg +1;
     if ( t3seg==54)
     {
       ae=AMAITU;
       t3seg=0;
     }
   }
      if ( ae == HASIERA )
   {
     t5seg = t5seg +1;
     if ( t5seg==90)
     {
       t5seg=0;
       ae=DINAMIC;
       PantEzabatu();
     }
   }
      if ( ae == BIDALTZEN )
   {
     t5seg = t5seg +1;
     if ( t5seg==90)
     {
       ae=DINAMIC;
       t5seg=0;
       PantEzabatu();
     }
   }

}

//-------------------------------------------------------------
//---------- ZERBITZU ERRUTINA TEKLATUA  ETENEKIN -------------
//-------------------------------------------------------------
int a,b,zenb;
int x=5,y=5;
unsigned char z,lag;
void AurreraKurtsorea(){
	IrakurKurtsorePos( &a, &b);
	JarriKurtsore( a, b+1);
}
void AtzeraKurtsorea(){
	IrakurKurtsorePos( &a, &b);
	JarriKurtsore( a, b-1);
}
void interrupt ZerErrTek()
{
 if ( y==60 )
  {
   x++;
   y=5;
}

  scankode = TeklatuDatErregIrakurri();
  StrobeTeklatu();
  if ( (scankode & 0x80) == 0 ) //Meak
  {
   if ( scankode == 74 && ae == DINAMIC ) //Mezu
   {
    ae=IDATZIL;
    PantEzabatu();
    JarriKurtsore(5 ,5);
    x=5;
    y=5;
   }
   if ( (ae==IDATZIL && scankode ==55) || ( ae==IDATZIZ && scankode ==55 ))
   {
   ae=BUKATUMEZUA;
   t3seg=0;
   }
   if ( scankode == 83 && ae == DINAMIC ) // Supr
   {
    ae=BUKATU;
    t3seg=0;
   }
   if ( scankode == 83 && ae == IDATZIL )  //Supr
   {
	IrakurKurtsorePos( &a, &b);
	JarriKurtsore( a, b-1);
	IdatzKar(a,b-1,' ',ATRIB_NORMALA);
	y--;

   }
   if ( scankode == 83 && ae == IDATZIZ )   //Supr
   {
	IrakurKurtsorePos( &a, &b);
	JarriKurtsore( a, b-1);
	IdatzKar(a,b-1,' ',ATRIB_NORMALA);
	y--;
   }
   if ( ae==NORABIDALI && scankode ==83 )  //Supr
   {
	IrakurKurtsorePos( &a, &b);
	JarriKurtsore( a, b-1);
	IdatzKar(a,b-1,' ',ATRIB_NORMALA);
	y--;
   }
   if ( scankode==69)  //Zen
   {
	if ( ae== IDATZIL)
	{
		ae= IDATZIZ;
	}
	else
	{
	  if ( ae==IDATZIZ)
	{
		ae=IDATZIL;
	}
	}
   }
   if ( ae==NORABIDALI && scankode ==78 )   //OK
   {
    ae=BIDALTZEN;
    t5seg=0;
    IdatzTestu(10,4,"BIDALTZEN...",ATRIB_NORMALA);
    x=5;
    y=5;
   }
   if ( (ae== IDATZIL && scankode ==78) || (ae==IDATZIZ && scankode ==78 ) )
   {
    ae=NORABIDALI;
    PantEzabatu();
    IdatzTestu(5,5,"Sartu Zenbakia:",ATRIB_NORMALA);
    JarriKurtsore( 5, 20);
   }

   if ( ae == IDATZIL )
   {
     if ( (scankode == 71) || (scankode == 72) || (scankode == 73) || (scankode == 75) || (scankode == 76) || (scankode == 77) || (scankode == 79) || (scankode == 80) || (scankode == 81) || (scankode == 82) )
      {
       ae=TAULA_A;
       t1seg=0;
      }
   }
   if ( ae==IDATZIZ)
   {
     if ( (scankode == 71) || (scankode == 72) || (scankode == 73) || (scankode == 75) || (scankode == 76) || (scankode == 77) || (scankode == 79) || (scankode == 80) || (scankode == 81) || (scankode == 82) )
     {
       IdatzKar(x,y++,ASCII_TAULA[scankode],ATRIB_NORMALA);
	JarriKurtsore(x,y);
     }
   }
   if ( ae==NORABIDALI)
   {
     if ( (scankode == 71) || (scankode == 72) || (scankode == 73) || (scankode == 75) || (scankode == 76) || (scankode == 77) || (scankode == 79) || (scankode == 80) || (scankode == 81) || (scankode == 82) )
     {
	IrakurKurtsorePos( &a, &b);
	JarriKurtsore( a, b+1);
       IdatzKar(a,b,ASCII_TAULA[scankode],ATRIB_NORMALA);
     }
   }
  }
  else //Brake
  {
//hemen ez da sartzen
//if ( scankode == 83 )
//IdatzTestu(10,6,"break 83",ATRIB_NORMALA);
//if ( scankode == 55 )
//IdatzTestu(10,6,"break 55",ATRIB_NORMALA);
  if  (ae == BUKATU)
  {
   //if ( (scankode) == 83 )   //surp
    // {
	ae=DINAMIC;
	t3seg=0;
    // }
   }
  if (ae == BUKATUMEZUA)
  {
  //if ( (scankode) == 55 )  //BukMezu
     //{
     ae=IDATZIL;
     t3seg=0;
    // }
    }
 // if ( (scankode == 71) || (scankode == 72) || (scankode == 73) || (scankode == 75) ||  (scankode == 76) || (scankode == 77) || (scankode == 79) || (scankode == 80) || (scankode == 81) || (scankode == 82) )
 //     {
 //	IdatzTestu(14,6,"scankode BAI !!!!!!",ATRIB_NORMALA);
 //	z=ASCII_TAULA[scankode];
 //	zenb= atoi(&z);
 //	zenb=(int)zenb;

 //	if (ae==TAULA_A)
 //	{
 //	 IdatzKar(x,y++,TAULAA[zenb],ATRIB_NORMALA);
 //	}
 //	if (ae==TAULA_B)
 //	{
 //	 IdatzKar(x,y++,TAULAB[zenb],ATRIB_NORMALA);
 //	}
 //	if (ae==TAULA_C)
 //	{
 //	 IdatzKar(x,y++,TAULAC[zenb],ATRIB_NORMALA);
 //	}
 //	ae=IDATZIL;
 //	JarriKurtsore(x,y);
 //
 //     }
  switch(scankode)
  {
  case 71 : zenb =7;
  case 72 : zenb =8;
  case 73 : zenb=9;
  case 75 : zenb=4;
  case 76 : zenb=5;
  case 77 : zenb=6;
  case 79 : zenb=1;
  case 80 : zenb=2;
  case 81 : zenb=3;
  case 82 : zenb=0;
  }
  if (ae==TAULA_A)
  {
	 IdatzKar(x,y++,TAULAA[zenb],ATRIB_NORMALA);
	ae=IDATZIL;
	JarriKurtsore(x,y);
  }
  if (ae==TAULA_B)
  {
	 IdatzKar(x,y++,TAULAB[zenb],ATRIB_NORMALA);
	ae=IDATZIL;
	JarriKurtsore(x,y);
  }
  if (ae==TAULA_C)
  {
	 IdatzKar(x,y++,TAULAC[zenb],ATRIB_NORMALA);
	ae=IDATZIL;
	JarriKurtsore(x,y);

  }

 }
Eoi();
//Iret();
}
//-------------------------------------------------------------------
//-----------------nagusia----------------------------------------
//---------------------------------------------------------------

char gakoa[]={'1','2','3','4'};
void main()
{
TeketenGalarazi();
PantHas= PantHelb();
PantEzabatu();
ae=AMAITU;
aukerak =0;
IdatzTestu(3+aukerak,3, "-----------Mezuak Bidali------------",ATRIB_NORMALA);
while ( aukerak < 3 && ae==AMAITU )
{
  letrak =0;
  gakoa[0]=0;
  gakoa[1]=0;
  gakoa[2]=0;
  gakoa[3]=0;
  IdatzTestu(4+aukerak,3, "PASSWORD:",ATRIB_NORMALA);
  JarriKurtsore(4+aukerak,12);
  azk=0;
  while ( letrak < 4 )
  {
   irr=IRR_Irakurri();
   while ( (irr & 0x02) == 0 )
   {
     irr=IRR_Irakurri();
   }
   scankode = TeklatuDatErregIrakurri();
   StrobeTeklatu();
   if ( (scankode & 0x80) == 0 )
   {

     if ( scankode >70 && scankode <83 && scankode != 78 && scankode !=74)
     {
       gakoa[letrak]= ASCII_TAULA[scankode];
       IdatzTestu(4+aukerak,12+letrak,"*",ATRIB_NORMALA);
       //JarriKurtsore(4+aukerak,12+letrak+1);
       AurreraKurtsorea();
	letrak=letrak + 1;

     }
     if ( letrak > 0 && scankode ==83 )
     {
       letrak=letrak-1;
       gakoa[letrak-1]=0;
       IdatzTestu(4+aukerak,12+letrak, " ",ATRIB_NORMALA);
       JarriKurtsore(4+aukerak,12+letrak);

     }
   }
  }
  ok=0;
  while ( ok == 0 )
  {
      irr=IRR_Irakurri();
      while ( (irr & 0x02) == 0 )
       {
	 irr=IRR_Irakurri();
       }
      scankode = TeklatuDatErregIrakurri();
      StrobeTeklatu();
      if ( (scankode & 0x80) == 0 && scankode ==78 )
      {
	  if ( gakoa[0]=='1' && gakoa[1]=='2' && gakoa[2]=='3' && gakoa[3]=='4'  )
	  {
	   IdatzTestu(4+aukerak,12+letrak+2, "ongi",ATRIB_NORMALA);
	   ae=HASIERA;
	   t5seg=0;
	  }

	  else
	  {
	   IdatzTestu(4+aukerak,12+letrak+2, "gaizki",ATRIB_NORMALA);
	   ae=AMAITU;
	  }
	aukerak = aukerak+1;
	ok=1;

      }

  }


}

TeketenBaimendu();

AldatuEB(0x1c,Ip(ZerErrErl), Cs(ZerErrErl), &IPOldErlojua, &CSOldErlojua);
AldatuEB(0x09,Ip (ZerErrTek), Cs(ZerErrTek), &IPOldTek, &CSOldTek);


while ( ae != AMAITU )
{
   if ( ae==DINAMIC )
     {
	 i=i+1;
	 IdatzTestu(1,i,  "         ||::|:||   .--------,                                 ",ATRIB_NORMALA);
	 IdatzTestu(2,i,  "         |:||:|:|   |_______ /        .-.                      ",ATRIB_NORMALA);
	 IdatzTestu(3,i,  "         ||::|:|| .""  ___  "".    {\('v')/}                   ",ATRIB_NORMALA);
	 IdatzTestu(4,i,  "         \\\/\///:  .'`   `'.  ;____`(   )'____                ",ATRIB_NORMALA);
	 IdatzTestu(5,i,  "          \====/ './  o   o  \|~     ^" "^      ~|             ",ATRIB_NORMALA);
	 IdatzTestu(6,i,  "           \\//   |   ())) .  |                  |             ",ATRIB_NORMALA);
	 IdatzTestu(7,i,  "            ||     \ `.__.'  /|     KARLOS       |             ",ATRIB_NORMALA);
	 IdatzTestu(8,i,  "            ||   _{``-.___.-'\|    IRIBARREN     |             ",ATRIB_NORMALA);
	 IdatzTestu(9,i,  "            || _." "-.__ __.-'§|                  |             ",ATRIB_NORMALA);
	 IdatzTestu(10,i, "            ||`        __ \   |___/   \__________|             ",ATRIB_NORMALA);
	 IdatzTestu(11,i, "          ."         " ( )"    " |    |                        ",ATRIB_NORMALA);
	 IdatzTestu(12,i, "         /   `\/       __   vvvvv'\___/                        ",ATRIB_NORMALA);
	 IdatzTestu(13,i, "         |     |      (__)        |                            ",ATRIB_NORMALA);
	 IdatzTestu(14,i, "          \___/\                 /                             ",ATRIB_NORMALA);
	 IdatzTestu(15,i, "            ||  |     .___.     |                              ",ATRIB_NORMALA);
	 IdatzTestu(16,i, "            ||  |       |       |                              ",ATRIB_NORMALA);
	 IdatzTestu(17,i, "            ||.-'       |       '-.                            ",ATRIB_NORMALA);
	 IdatzTestu(18,i, "            ||          |          )                           ",ATRIB_NORMALA);
	 IdatzTestu(19,i, "            ||----------'---------'                            ",ATRIB_NORMALA);
	 Atzeratu(500);
	 if ( i==80 )
		i=0;

     }

}

BerreskuratuEB(0x1c, IPOldErlojua, CSOldErlojua);
BerreskuratuEB(0x09, IPOldTek, CSOldTek);
}