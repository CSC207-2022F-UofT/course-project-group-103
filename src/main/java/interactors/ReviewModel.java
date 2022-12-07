package interactors;

public class ReviewModel {

    String content;
    int rating;
    String writer_name;
    String date;

    public ReviewModel(String content, int rating, String name, String date) {
        this.content = content;
        this.rating = rating;
        this.writer_name = name;
        this.date = date;
    }

    public String getContent() {
        return this.content;
    }

    public int getRating() {
        return this.rating;
    }

    public String getWriterName() {
        return this.writer_name;
    }

    public String getDate() {
        return this.date;
    }
}
