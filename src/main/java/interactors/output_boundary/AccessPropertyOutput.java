package interactors.output_boundary;

import interactors.PropertyModel;

public interface AccessPropertyOutput {

    /**
     * Called with the property model of accessed property if successful.
     *
     * @param property: PropertyModel of accessed to be passed to the view.
     */
    void onAccessPropertySuccess(PropertyModel property);
    /**
     * Called when accessing a property has failed.
     *
     * @param message: failure message.
     */
    void onAccessPropertyFailure(String message);
}
