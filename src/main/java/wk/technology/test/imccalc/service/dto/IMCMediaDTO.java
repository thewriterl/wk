package wk.technology.test.imccalc.service.dto;

public class IMCMediaDTO {

    private String range;
    private IMCAgeRangeDTO media;

    public IMCMediaDTO() {
        super();
    }

    public IMCMediaDTO(String range, IMCAgeRangeDTO media) {
        this.setRange(range);
        this.setMedia(media);
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public IMCAgeRangeDTO getMedia() {
        return media;
    }

    public void setMedia(IMCAgeRangeDTO media) {
        this.media = media;
    }
}
