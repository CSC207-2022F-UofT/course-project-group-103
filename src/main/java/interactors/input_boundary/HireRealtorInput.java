package interactors.input_boundary;

public interface HireRealtorInput {
    /**
     * Hires a realtor to a given user.
     *
     * @param userID: ID of user to hire realtor.
     * @param realtorID: ID of the realtor to hire.
     */
    void hireRealtor(String userID, String realtorID);
}
