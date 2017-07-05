########################################################
## Cuenta los fitxeros y directorios
########################################################

echo "**********************************"
echo "Cuenta los fitxeros y directorios "
echo "**********************************"
## 

FILECOUNT=0
DIRCOUNT=0

for item in *
do
if [ -f "$item" ]
    then
         FILECOUNT=$[$FILECOUNT+1]
    elif [ -d "$item" ]
        then
         DIRCOUNT=$[$DIRCOUNT+1]
fi
done

echo "Fitxategi kopurua: $FILECOUNT "
echo "Karpeta kopurua: $DIRCOUNT "

echo " "
read -n1 -r -p "****** Botoi bat sakatu amaitzeko ******" key