
/**
 * FirstWebServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package org.apache.ws.axis2;

    /**
     *  FirstWebServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class FirstWebServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public FirstWebServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public FirstWebServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for saludar method
            * override this method for handling normal response from saludar operation
            */
           public void receiveResultsaludar(
                    org.apache.ws.axis2.FirstWebServiceStub.SaludarResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from saludar operation
           */
            public void receiveErrorsaludar(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for sumar method
            * override this method for handling normal response from sumar operation
            */
           public void receiveResultsumar(
                    org.apache.ws.axis2.FirstWebServiceStub.SumarResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from sumar operation
           */
            public void receiveErrorsumar(java.lang.Exception e) {
            }
                


    }
    