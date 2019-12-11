import Book_5_7_2.*;
import org.junit.Test;

import javax.swing.plaf.PanelUI;
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
        //since clientA and clientA are not subscribed, therefore not receiving any msg
        //assert
        verify(clientA, never()).receive(message);
        verify(clientB, never()).receive(message);
    }

    @Test
    public void messagesSentToSubscribers() {
        //arrange
        Message  F1_racesMessage = mock(Message.class);
        when(F1_racesMessage.getSubscriptionCategory()).thenReturn(SubscriptionCategory.F1_RACES);
        //act
        raceResults.addSubscriber(clientA, SubscriptionCategory.F1_RACES);
        raceResults.addSubscriber(clientB, SubscriptionCategory.F1_RACES);
        raceResults.send(F1_racesMessage);
        //assert
        verify(clientB).receive(F1_racesMessage);
        verify(clientA, times(1)).receive(F1_racesMessage);
    }

    @Test(expected = IllegalArgumentException.class)
    public void aSubscriberShouldUnsubscribeFromPreSubscribedCategoryOnly(){
        raceResults.addSubscriber(clientA, SubscriptionCategory.BOAT_RACES);
        raceResults.removeSubscriber(clientA, SubscriptionCategory.HORSE_RACES);
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
        verify(clientA).receive(message);
        verify(clientA, times(1)).receive(message);

    }
    @Test
    public void aSubscriberShouldNotReceiveMessageAfterUnsubscribed() {
        //act
        raceResults.addSubscriber(clientA, SubscriptionCategory.F1_RACES);
        raceResults.removeSubscriber(clientA, SubscriptionCategory.F1_RACES);
        raceResults.send(message);
        //assert
        verify(clientA, never()).receive(message);
    }

    @Test
    public void aSubscriberShouldReceiveMessageForSubscribedCategoryOnly(){
        //arrange
        Message F1_racesMessage=mock(Message.class);
        Message HORSE_RACESMessage=mock(Message.class);
        when(F1_racesMessage.getSubscriptionCategory()).thenReturn(SubscriptionCategory.F1_RACES);
        when(HORSE_RACESMessage.getSubscriptionCategory()).thenReturn(SubscriptionCategory.HORSE_RACES);
        //act
        raceResults.addSubscriber(clientA, SubscriptionCategory.F1_RACES);
        raceResults.send(F1_racesMessage);
        raceResults.send(HORSE_RACESMessage);
        //asert/verify
        verify(clientA, times(1)).receive(F1_racesMessage);
        verify(clientA, times(0)).receive(HORSE_RACESMessage);
        verify(clientA, never()).receive(HORSE_RACESMessage);
    }



    @Test
    public void loggerLogsDateAndMessageWhenMessageSent() {
        //arrange
        LocalDate date = LocalDate.now();
        String msgLog = "Message is logged!";
        Message F1_racesMessage = mock(Message.class);
        when(F1_racesMessage.getSubscriptionCategory()).thenReturn(SubscriptionCategory.F1_RACES);
        when(F1_racesMessage.getDate()).thenReturn(date);
        when(F1_racesMessage.getMessage()).thenReturn(msgLog);
        //act
        raceResults.addSubscriber(clientA, SubscriptionCategory.F1_RACES);
        raceResults.send(F1_racesMessage);
        //assert
        verify(logger).log(date, msgLog);
        verify(clientA).receive(F1_racesMessage);
    }

    @Test
    public void loggerDoesnotLogsDateAndMessageWhenMessageNotSent() {
        //arrange
        LocalDate date = LocalDate.now();
        String msgLog = "Message is logged!";
        Message F1_racesMessage = mock(Message.class);
        when(F1_racesMessage.getSubscriptionCategory()).thenReturn(SubscriptionCategory.F1_RACES);
        when(F1_racesMessage.getDate()).thenReturn(date);
        when(F1_racesMessage.getMessage()).thenReturn(msgLog);
        //act
        raceResults.addSubscriber(clientA, SubscriptionCategory.F1_RACES);
        //assert
        verify(logger, never()).log(date, msgLog);
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
        //assert
        verify(clientA, times(1)).receive(F1_racesMessage);
        verify(clientA, times(1)).receive(BOAT_RACESMessage);
    }

    @Test(expected = IllegalArgumentException.class)
    public void notSubscribedClientShouldNotUnsubscribe() {
        //act
        raceResults.removeSubscriber(clientA, SubscriptionCategory.F1_RACES);
    }

}
