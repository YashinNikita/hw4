package hw.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DataHW {
    @JsonProperty("benefitsImgAmount")
    int benefitsImgAmount;

    @JsonProperty("numberOfTextUnderImgs")
    int numberOfTextUnderImgs;

    @JsonProperty("homepage")
    String homepageTitle;

    @JsonProperty("headerBtnElements")
    String[] headerBtnElements;

    @JsonProperty("textUnderImg")
    String[] textUnderImg;

    @JsonProperty("jgiGithubText")
    String jgiGithubText;

    @JsonProperty("jdiGitHref")
    String jdiGitHref;

    @JsonProperty("diElemPageMenuItems")
    String[] diElemPageMenuItems;

    @JsonProperty("checkBoxesQuantity")
    int checkBoxesQuantity;

    @JsonProperty("radiosQuantity")
    int radiosQuantity;

    @JsonProperty("dropdownQuantity")
    int dropdownQuantity;

    @JsonProperty("buttonsQuantity")
    int buttonsQuantity;

    public List<String> getDiElemPageMenuItems() {
        List menuItems = new ArrayList(Arrays.asList(diElemPageMenuItems));
        return menuItems;
    }

    public String getJdiGitHref() {
        return jdiGitHref;
    }

    public String getJgiGithubText() {
        return jgiGithubText;
    }

    public List<String> getHeaderBtnElements() {
        List headerBtn = new ArrayList(Arrays.asList(headerBtnElements));
        return headerBtn;
    }

    public List<String> getTextUnderImg() {
        List text = new ArrayList(Arrays.asList(textUnderImg));
        return text;
    }

    public int getBenefitsImgAmount() {
        return benefitsImgAmount;
    }

    public int getNumberOfTextUnderImgs() {
        return numberOfTextUnderImgs;
    }

    public String getHomepageTitle() {
        return homepageTitle;
    }

    public int getCheckBoxesQuantity() {
        return checkBoxesQuantity;
    }

    public int getRadiosQuantity() {
        return radiosQuantity;
    }

    public int getDropdownQuantity() {
        return dropdownQuantity;
    }

    public int getButtonsQuantity() {
        return buttonsQuantity;
    }


    public static DataHW get(String filename) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(filename), DataHW.class);
    }

}
