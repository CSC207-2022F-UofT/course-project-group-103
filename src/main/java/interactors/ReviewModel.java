package interactors;

public class ReviewModel {

    /**
     * Content of the review.
     */
    String content;
    /**
     * Rating given with review.
     */
    int rating;
    /**
     * Name of the user who wrote the review.
     */
    String writer_name;
    /**
     * Date review was written.
     */
    String date;

    /**
     * Constructor for the review model, assigns its attributes.
     *
     * @param content: content of the review
     * @param rating: rating given
     * @param name: name of reviewer
     * @param date: date of review
     */
    public ReviewModel(String content, int rating, String name, String date) {
        this.content = content;
        this.rating = rating;
        this.writer_name = name;
        this.date = date;
    }

    /**
     * Gets the content of the review.
     * @return string representation of the review content.
     */
    public String getContent() {
        return this.content;
    }

    /**
     * Gets the rating of the review.
     * @return int representation of the rating.
     */
    public int getRating() {
        return this.rating;
    }

    /**
     * Gets the name of the review writer.
     * @return string representation of reviewer name.
     */
    public String getWriterName() {
        return this.writer_name;
    }

    /**
     * Gets the date the review was written.
     * @return string representation of the date.
     */
    public String getDate() {
        return this.date;
    }
}
