package org.modelcatalogue.spreadsheet.builder.api;

import java.io.InputStream;

public interface ImageCreator {

    void from(String fileOrUrl);
    void from(InputStream stream);
    void from(byte[] imageData);

}
