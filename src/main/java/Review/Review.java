package Review;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Set;
import java.time.format.DateTimeFormatter;

import org.json.JSONObject;
import org.json.JSONArray;
import Users.Owner;
import Users.User;

public class Review {
    private String review;
    private Owner owner;
    private User user;
    private String date;

    public Review(String review, Owner owner, User user){
        this.review = review;
        this.owner = owner;
        this.user = user;
        DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        this.date = dateformat.format(now);
    }
    //https://github.com/thisandagain/washyourmouthoutwithsoap.git (where to get banned words database)
    public boolean calculateIfAppropriate(){
        try {
            String location = "C:\\Users\\Omar\\IdeaProjects\\course-project-group-103\\src\\main\\java\\Review\\_en.json";
            File file = new File(location);
            String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
            JSONObject json = new JSONObject(content);
            Set<String> banned_words = json.keySet();
            String[] review_words = this.review.split(" ");
            for(String word: review_words){
                if (banned_words.contains(word)){
                    return false;
                }
            }
        }
        catch (IOException e) {e.printStackTrace();}
        return true;
    }


    public String getReview(){
        return this.review;
    }

    public String getUserName(){
        return user.getName();
    }

    public String getOwnerName(){
        return owner.getName();
    }

    public void addReview(){

        try {
            String location = "C:\\Users\\Omar\\IdeaProjects\\course-project-group-103\\src\\main\\Databases\\ReviewList.json";
            File file = new File(location);
            String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
            JSONObject addedReview = new JSONObject(content);
            Set<String> owners = addedReview.keySet();
            if (owners.contains(this.owner.getName())){
                JSONObject newReview = new JSONObject();
                newReview.put("UserName", this.user.getName());
                newReview.put("Review", this.review);
                newReview.put("Date and time", this.date);
                JSONArray newReviews = addedReview.getJSONArray(this.owner.getName()).put(newReview);
                addedReview.put(this.owner.getName(), newReviews);
            }
            else{
                JSONArray arrayReview = new JSONArray();
                JSONObject newReview = new JSONObject();
                newReview.put("UserName", this.user.getName());
                newReview.put("Review", this.review);
                newReview.put("Date and time", this.date);
                addedReview.put(this.owner.getName(), arrayReview.put(newReview));
            }
            try (PrintWriter file2 = new PrintWriter(location)) {
                //We can write any JSONArray or JSONObject instance to the file
                file2.write(addedReview.toString());

            } catch (IOException e) {
                e.printStackTrace();
            }
            this.owner.setExtraReview(this);

        }
        catch (IOException e) {e.printStackTrace();}
    }

}
