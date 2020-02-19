public static final String ACTUALIZARTABLA = "MERGE INTO TRX_CLI_TARJETACLIENTE ANTES "+
                     "USING (SELECT :numPerso TCLI_NUMPERSO, "+
                     ":panTarjeta TCLI_PANTARJETA, "+
                     ":numApoderado TCLI_NUMAPODERADO, "+
                     ":tipoPersonaUsuario TCLI_TIPOPERSONA, "+
                     ":contratoTarjeta TCLI_CODCONTRATO, "+
                     ":relacionProducto TCLI_RELACIONPRODUCTO, "+
                     ":nombreTenedor TCLI_NOMBREBENEFICIARIO, "+
                     ":estadoTarjeta TCLI_CODESTADO, "+
                     ":tipoCargoTarjeta TCLI_TIPOCARGOTARJETA, "+
                     ":marcaTarjeta TCLI_MARCATARJETA, "+
                     ":indAhorraCambio TCLI_AHORRACAMBIO, "+
                     ":indAseguraSaldoPend TCLI_SEGUROSALDO, "+
                     "'I' TCLI_INDICADORVISIBILIDAD, "+
                     "sysdate TCLI_FECHAACTUALIZACION, "+
                     "'ActuTarj' TCLI_ORIGENACTUALIZACION "+
                     " FROM DUAL) DESPUES "+
                     "ON (ANTES.TCLI_NUMPERSO = DESPUES.TCLI_NUMPERSO AND ANTES.TCLI_PANTARJETA = DESPUES.TCLI_PANTARJETA AND ANTES.TCLI_NUMAPODERADO = DESPUES.TCLI_NUMAPODERADO) "+
                     "WHEN MATCHED THEN UPDATE SET ANTES.TCLI_TIPOPERSONA = DESPUES.TCLI_TIPOPERSONA, "+
                                                   "ANTES.TCLI_CODCONTRATO = DESPUES.TCLI_CODCONTRATO, "+
                                                   "ANTES.TCLI_RELACIONPRODUCTO = DESPUES.TCLI_RELACIONPRODUCTO, "+
                                                   "ANTES.TCLI_NOMBREBENEFICIARIO = DESPUES.TCLI_NOMBREBENEFICIARIO, "+
                                                   "ANTES.TCLI_CODESTADO = DESPUES.TCLI_CODESTADO, "+
                                                   "ANTES.TCLI_TIPOCARGOTARJETA = DESPUES.TCLI_TIPOCARGOTARJETA, "+
                                                   "ANTES.TCLI_ORIGENACTUALIZACION = DESPUES.TCLI_ORIGENACTUALIZACION, "+
                                                   "ANTES.TCLI_FECHAACTUALIZACION = DESPUES.TCLI_FECHAACTUALIZACION, "+
                                                   "ANTES.TCLI_AHORRACAMBIO = DESPUES.TCLI_AHORRACAMBIO, "+
                                                   "ANTES.TCLI_SEGUROSALDO = DESPUES.TCLI_SEGUROSALDO, "+
                                                   "ANTES.TCLI_MARCATARJETA = DESPUES.TCLI_MARCATARJETA "+
                     "WHEN NOT MATCHED THEN INSERT (TCLI_NUMPERSO, "+
                                                   "TCLI_PANTARJETA, "+
                                                   "TCLI_NUMAPODERADO, "+                             
                                                   "TCLI_TIPOPERSONA, "+
                                                   "TCLI_CODCONTRATO, "+
                                                   "TCLI_RELACIONPRODUCTO, "+
                                                   "TCLI_NOMBREBENEFICIARIO, "+
                                                   "TCLI_CODESTADO, "+
                                                   "TCLI_TIPOCARGOTARJETA, "+
                                                   "TCLI_MARCATARJETA, "+
                                                   "TCLI_INDICADORVISIBILIDAD, "+
                                                   "TCLI_FECHAACTUALIZACION, "+
                                                   "TCLI_AHORRACAMBIO, "+
                                                   "TCLI_SEGUROSALDO, "+
                                                   "TCLI_ORIGENACTUALIZACION "+
                                                   ") VALUES (DESPUES.TCLI_NUMPERSO, "+
                                                   "DESPUES.TCLI_PANTARJETA, "+
                                                   "DESPUES.TCLI_NUMAPODERADO, "+
                                                   "DESPUES.TCLI_TIPOPERSONA, "+
                                                   "DESPUES.TCLI_CODCONTRATO, "+
                                                   "DESPUES.TCLI_RELACIONPRODUCTO, "+
                                                   "DESPUES.TCLI_NOMBREBENEFICIARIO, "+
                                                   "DESPUES.TCLI_CODESTADO, "+
                                                   "DESPUES.TCLI_TIPOCARGOTARJETA, "+
                                                   "DESPUES.TCLI_MARCATARJETA, "+
                                                   "DESPUES.TCLI_INDICADORVISIBILIDAD, "+
                                                   "DESPUES.TCLI_FECHAACTUALIZACION, "+
                                                   "DESPUES.TCLI_AHORRACAMBIO, "+
                                                   "DESPUES.TCLI_SEGUROSALDO, "+
                                                   "DESPUES.TCLI_ORIGENACTUALIZACION)";
