package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private String tagBody;
    private List<Tag> children;

    public PairedTag(String name, Map<String, String> attrs, String tagBody, List<Tag> children) {
        super(name, attrs);
        this.tagBody = tagBody;
        this.children = children;
    }

    @Override
    public String toString() {
        return super.toString() + this.tagBody + children.stream().map(e -> e.toString()).collect(Collectors.joining())
            + "</" + super.getName() + '>';
    }
}
// END
