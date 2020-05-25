#!/bin/bash

sftp -i /root/.ssh/id_rsa root@192.168.240.167:/root/ <<< $'put /root/Captura.PNG'

# Obtener el resultado del ultimo comando
SFTP_RETURN_CODE=${?}

# If the return code is non-zero then the upload was not successful

if [[ 0 != ${SFTP_RETURN_CODE} ]]
then
   # Failed
   
   
else
   # successful
   
fi

exit 0