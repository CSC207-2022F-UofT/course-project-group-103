package interactors.output_boundary;

import interactors.PropertyModel;

public interface AccessPropertyOutput {
    void onAccessPropertySuccess(PropertyModel property);
    void onAccessPropertyFailure(String message);
}
