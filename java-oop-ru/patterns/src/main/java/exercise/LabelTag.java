package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    private String text;
    private String tag;

    public LabelTag(String text, TagInterface tag) {
        this.text = text;
        this.tag = tag.render();
    }

    @Override
    public String render() {
        return "<label>" + text + tag + "</label>";
    }
}
// END
