package com.innova4b.jms;
/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSDestinationDefinitions;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;


//------------------------- Definimos el buzón Message Driven ------------------------------------------------------------------//
@JMSDestinationDefinitions(
      value =  {
              @JMSDestinationDefinition(
                      name = "java:/queue/JndiBuzonMDB",
                      interfaceName = "javax.jms.Queue",
                      destinationName = "JndiBuzonMDB"
              )
      }
)

 //----------------------- Es el MDB Message Driven esclavo que está dentro del buzón -----------------------------------------//
@MessageDriven(name = "JndiBuzonMDB", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "queue/JndiBuzonMDB"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })



public class BuzonMDB implements MessageListener {
	//Recibe el mensaje del que le invoque, en nuestro caso EJB
    public void onMessage(Message rcvMessage) {
        TextMessage msg = null;
        try {
        	//Verifica si es de tipo mensaje
            if (rcvMessage instanceof TextMessage) {
            	//Casting de mensaje
                msg = (TextMessage) rcvMessage;
                //Imprime el mensaje
                System.out.println(msg.getText());
            } else {
            	System.out.println("Error");
            }
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    	
    }
}

