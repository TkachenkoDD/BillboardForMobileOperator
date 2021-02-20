package ru.tkachenko.ecarebillboard.mdb;

import ru.tkachenko.ecarebillboard.rest.RestEJB;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(mappedName = "MyQueue", activationConfig = {@ActivationConfigProperty(propertyName = "destination",
        propertyValue = "jms/queue/test")})
public class ClassMDB implements MessageListener {

    @Inject
    private RestEJB restEJB;

    @Inject @Push
    private PushContext push;

    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            try {
                String text = ((TextMessage) message).getText();
                System.out.println("Message " + text + " received.");
                restEJB.getTariffs();
                push.send("update");

            } catch (final JMSException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
