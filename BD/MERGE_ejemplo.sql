NOTA : En este ejemplo se muestra como en la Select se seleciona un registro usando la clausula WHERE

MERGE INTO TDE_FAMILIA ANTES
     USING (SELECT 
            '1' FAM_IDFAMILIA,
            'Ocio' FAM_NOMCAS                
              FROM TDE_FAMILIA
              WHERE FAM_IDFAMILIA=1) DESPUES
        ON (ANTES.FAM_IDFAMILIA = DESPUES.FAM_IDFAMILIA)
WHEN MATCHED
THEN
   UPDATE SET
      ANTES.FAM_NOMCAS = DESPUES.FAM_NOMCAS
WHEN NOT MATCHED
THEN
   INSERT     (FAM_IDFAMILIA, 
                FAM_NOMCAS)
       VALUES (DESPUES.FAM_IDFAMILIA,
               DESPUES.FAM_NOMCAS);


------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------

NOTA : En este ejemplo se muestra como en la Select crea un registro con la clausula "FROM DUAL" y se mira 
si en la tabla esa existe un registro igual (todos los campos iguales)

MERGE INTO TDE_FAMILIA ANTES
     USING (SELECT 
            '1' FAM_IDFAMILIA,
            'Ocio' FAM_NOMCAS                
              FROM DUAL) DESPUES
        ON (ANTES.FAM_IDFAMILIA = DESPUES.FAM_IDFAMILIA)
WHEN MATCHED
THEN
   UPDATE SET
      ANTES.FAM_NOMCAS = DESPUES.FAM_NOMCAS
WHEN NOT MATCHED
THEN
   INSERT     (FAM_IDFAMILIA, 
                FAM_NOMCAS)
       VALUES (DESPUES.FAM_IDFAMILIA,
               DESPUES.FAM_NOMCAS);
