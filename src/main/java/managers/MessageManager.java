package managers;

import entities.Messenger;
import entities.Review;
import interactors.exceptions.MessageNotAppropriate;
import interactors.exceptions.MessengerNotFound;
import interactors.exceptions.UndefinedUserType;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import interactors.gateway_interfaces.MessengerGateway;
import org.json.JSONArray;
import org.json.JSONObject;

public class MessageManager implements MessengerGateway {

    String messenger_file_path;

    public MessageManager(String m) {
        this.messenger_file_path = m;
    }
    public void storeMessenger(String messenger_ID) throws UndefinedUserType, IOException, MessengerNotFound {

        Messenger messenger = retrieveMessenger(messenger_ID);
        String User1_ID = messenger.getUser1ID();
        String User2_ID = messenger.getUser2ID();
        ArrayList<ArrayList<String>> messageLog = messenger.getMessageLog();
        try {
            String location = messenger_file_path;
            File file = new File(location);
            String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
            JSONObject newMessenger = new JSONObject(content);
            JSONObject newMessengerDetails = new JSONObject();
            newMessengerDetails.put("User1_ID", User1_ID);
            newMessengerDetails.put("User2_ID", User2_ID);
            newMessengerDetails.put("messageLog", messageLog);
            newMessenger.put(messenger_ID, newMessengerDetails);
            try (PrintWriter file2 = new PrintWriter(location)) {
                file2.write(newMessenger.toString());

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {e.printStackTrace();}
    }


    public Messenger retrieveMessenger(String messenger_ID) throws MessengerNotFound, UndefinedUserType, IOException {
        String location = messenger_file_path;
        File file = new File(location);
        String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
        JSONObject obj = new JSONObject(content);
        String user1_ID = obj.getJSONObject(messenger_ID).getString("User1_ID");
        String user2_ID = obj.getJSONObject(messenger_ID).getString("User2_ID");
        JSONArray messageLogArray = obj.getJSONObject(messenger_ID).getJSONArray("messageLog");
        ArrayList<ArrayList<String>> messageLog = new ArrayList<>();
        for (int i = 0; i < messageLogArray.length(); i++) {
            ArrayList<String> Log = new ArrayList<>();
            for (int j = 0; j < messageLogArray.getJSONArray(i).length(); j++) {
                Log.add(messageLogArray.getJSONArray(i).getString(j));
            }
            messageLog.add(Log);
        }
        return new Messenger(user1_ID, user2_ID, messenger_ID, messageLog);
    }

    public ArrayList<Messenger> getMessengers(String sender_ID) throws IOException, MessengerNotFound, UndefinedUserType {
        String location = messenger_file_path;
        File file = new File(location);
        String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
        JSONObject obj = new JSONObject(content);
        ArrayList<Messenger> messengers = new ArrayList<>();
        for (Iterator<String> it = obj.keys(); it.hasNext(); ) {
            String k = it.next();
            String user1_ID = obj.getJSONObject(k).getString("User1_ID");
            String user2_ID = obj.getJSONObject(k).getString("User2_ID");
            if (sender_ID.equals(user1_ID) || sender_ID.equals(user2_ID)) {
                messengers.add(retrieveMessenger(k));
            }
        }
        return messengers;
    }

    public Messenger getMessenger(String User1_ID, String User2_ID) throws MessengerNotFound, IOException, UndefinedUserType {
        String location = messenger_file_path;
        File file = new File(location);
        String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
        JSONObject obj = new JSONObject(content);
        Set<String> keys = obj.keySet();
        boolean user1 = false;
        boolean user2 = false;
        for (Object k: keys.toArray()) {
            String user1_ID = obj.getJSONObject((String) k).getString("User1_ID");
            user1 = User1_ID.equals(user1_ID) || User2_ID.equals(user1_ID);
            String user2_ID = obj.getJSONObject((String)k).getString("User2_ID");
            user2 = User1_ID.equals(user2_ID) || User2_ID.equals(user2_ID);
            if(user1 && user2){
                return retrieveMessenger((String)k);
            }
        }
        throw new MessengerNotFound("Messenger not found.");
    }

    public void addMessage(String sender_ID, String receiver_ID, String message) throws UndefinedUserType, IOException, MessengerNotFound {
        String location = messenger_file_path;
        File file = new File(location);
        String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
        JSONObject obj = new JSONObject(content);
        Messenger messenger = getMessenger(sender_ID, receiver_ID);
        String messengerID = messenger.getID();
        JSONObject messengers = obj.getJSONObject(messengerID);
        JSONArray messageLogArray = messengers.getJSONArray("messageLog");
        String[] newMessage = {sender_ID, message};
        messageLogArray.put(newMessage);
        messengers.put("messageLog", messageLogArray);
        obj.put(messengerID, messengers);
        try (PrintWriter file2 = new PrintWriter(location)) {
            file2.write(obj.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

//            String location = messenger_file_path;
//            File file = new File(location);
//            String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
//            JSONObject obj = new JSONObject(content);
//            String messenger_ID = getMessenger(sender_ID, receiver_ID).getID();
//            JSONObject messenger =  obj.getJSONObject(messenger_ID);
//            JSONArray messageLog = messenger.getJSONArray("messageLog");
//            JSONArray message1 = new JSONArray();
//            message1.put(sender_ID);
//            message1.put(message);
//            messageLog.put(message1);

    }
}