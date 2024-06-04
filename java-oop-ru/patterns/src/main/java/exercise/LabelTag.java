package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    private String caption;
    private TagInterface tag;

    public LabelTag(String type, TagInterface tag) {
        this.caption = type;
        this.tag = tag;
    }

    @Override
    public String render() {
        return "<label>" + caption + tag.render() + "</label>";
    }
}
// END
