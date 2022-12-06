package Managers;

import Exceptions.MessageNotAppropriate;
import Exceptions.MessengerNotFound;
import Exceptions.UndefinedUserType;
import Review.Review;
import Users.User;
import Messenger.Messenger;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class MessageManager {
    public void storeMessenger(String messenger_ID) throws UndefinedUserType, IOException, MessengerNotFound {

        Messenger messenger = retrieveMessenger(messenger_ID);
        String User1_ID = messenger.getUser1_ID();
        String User2_ID = messenger.getUser2_ID();
        ArrayList<ArrayList<String>> messageLog = messenger.getMessageLog();
        try {
            String location = "src/main/Databases/Messenger.Database.json";
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


    public static Messenger retrieveMessenger(String messenger_ID) throws MessengerNotFound, UndefinedUserType, IOException {
        String location = "src/main/Databases/MessengerDatabase.json";
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

    public static Messenger getMessenger(String User1_ID, String User2_ID) throws MessengerNotFound, IOException, UndefinedUserType {
        String location = "src/main/Databases/MessengerDatabase.json";
        File file = new File(location);
        String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
        JSONObject obj = new JSONObject(content);
        ArrayList<String> keys = (ArrayList<String>) obj.keys();
        boolean user1 = false;
        boolean user2 = false;
        for (String k: keys) {
            String user1_ID = obj.getJSONObject(k).getString("User1_ID");
            user1 = User1_ID.equals(user1_ID) | User2_ID.equals(user1_ID);
            String user2_ID = obj.getJSONObject(k).getString("User2_ID");
            user2 = User1_ID.equals(user2_ID) | User1_ID.equals(user2_ID);
            if(user1 && user2){
                return retrieveMessenger(k);
            }
        }
        throw new MessengerNotFound("Messenger not found.");
    }

    public static void addMessage(String sender_ID, String receiver_ID, String message) throws UndefinedUserType, IOException, MessengerNotFound, MessageNotAppropriate {
        if (Review.calculateIfAppropriate(message)) {
            String location = "src/main/Databases/MessengerDatabase.json";
            File file = new File(location);
            String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
            JSONObject obj = new JSONObject(content);
            String messenger_ID = getMessenger(sender_ID, receiver_ID).getID();
            JSONObject messenger =  obj.getJSONObject(messenger_ID);
            JSONArray messageLog = messenger.getJSONArray("messageLog");
            JSONArray message1 = new JSONArray();
            message1.put(sender_ID);
            message1.put(message);
            messageLog.put(message1);
        } else {
            throw new MessageNotAppropriate("This message is not appropriate");
        }

    }
}