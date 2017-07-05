########################################################
## 1 Maialako Azpi katalogoak guztiak imprimatzen ditu
########################################################

echo "************************************************"
echo "Directorio honentan dauden karpetak hauek dira:"
echo "************************************************"


for i in *
do
	if [ -d "$i" ] 
	then
		echo "azpi_katalogoa : $i/"
	fi
done

echo " "
read -n1 -r -p "****** Botoi bat sakatu amaitzeko ******" key