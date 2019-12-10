import Book_5_7_2.RaceResultsService;
import org.junit.Test;

import java.time.LocalDate;

import static org.mockito.Mockito.*;


public class RaceResultsServiceTest {
    //arrange
    private Logger logger = mock(Logger.class);
    private RaceResultsService raceResults = new RaceResultsService(logger);
    private Message message = mock(Message.class);
    private Client clientA = mock(Client.class, "clientA");
    private Client clientB = mock(Client.class, "clientB");

    @Test
    public void nonSubscribersShouldNotReceiveMessage() {
        //act
        raceResults.send(message);
        //since clientA and clientA are not subscribed, therefore should not receiving any msg
        //assert

    }

    @Test
    public void messagesSentToSubscribers() {
        //arrange
        Message  F1_racesMessage = mock(Message.class);
        when(F1_racesMessage.getSubscriptionCategory()).thenReturn(SubscriptionCategory.F1_RACES);
        //act

        //assert

    }


    @Test
    public void aSubscriberShouldReceiveOneMessagePerCategory() {
        //arrange
        when(message.getSubscriptionCategory()).thenReturn(SubscriptionCategory.F1_RACES);
        //act
        raceResults.addSubscriber(clientA, SubscriptionCategory.F1_RACES);
        raceResults.addSubscriber(clientA, SubscriptionCategory.F1_RACES);
        raceResults.send(message);
        //assert


    }
    @Test
    public void aSubscriberShouldNotReceiveMessageAfterUnsubscribed() {
        //act
        raceResults.addSubscriber(clientA, SubscriptionCategory.F1_RACES);
        raceResults.removeSubscriber(clientA, SubscriptionCategory.F1_RACES);
        raceResults.send(message);
        //assert
    }
    @Test
    public void loggerLogsDateAndMessageWhenMessageSent() {
        //arrange
        LocalDate date = LocalDate.now();
        String msgLog = "Message Logged!";
        Message F1_racesMessage = mock(Message.class);
        when(F1_racesMessage.getSubscriptionCategory()).thenReturn(SubscriptionCategory.F1_RACES);
        when(F1_racesMessage.getDate()).thenReturn(date);
        when(F1_racesMessage.getMessage()).thenReturn(msgLog);
        //act
        raceResults.addSubscriber(clientA, SubscriptionCategory.F1_RACES);
        raceResults.send(F1_racesMessage);

    }



    @Test
    public void multipleMessagesAreSentToSubscribersForeachCategory() {
        //arrange
        Message  F1_racesMessage = mock(Message.class);
        Message  BOAT_RACESMessage = mock(Message.class);
        when(F1_racesMessage.getSubscriptionCategory()).thenReturn(SubscriptionCategory.F1_RACES);
        when(BOAT_RACESMessage.getSubscriptionCategory()).thenReturn(SubscriptionCategory.BOAT_RACES);
        //act
        raceResults.addSubscriber(clientA, SubscriptionCategory.F1_RACES);
        raceResults.addSubscriber(clientA, SubscriptionCategory.BOAT_RACES);
        raceResults.send(F1_racesMessage);
        raceResults.send(BOAT_RACESMessage);

    }

    @Test(expected = IllegalArgumentException.class)
    public void notSubscribedClientShouldNotUnsubscribe() {
        //act
        raceResults.removeSubscriber(clientA, SubscriptionCategory.F1_RACES);
    }

}
