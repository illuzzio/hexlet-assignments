package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private String tagBody;
    private List<Tag> childTags;

    public PairedTag(String tagName, Map<String, String> attributes, String tagBody, List<Tag> childTags) {
        super(tagName, attributes);
        this.tagBody = tagBody;
        this.childTags = childTags;
    }

    @Override
    public String toString() {
        var result = attributes == null && attributes.isEmpty() ? "" : attributes.entrySet().stream()
                .map(entry -> String.format("%s=\"%s\"", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(" "));

        StringBuilder tagContent = new StringBuilder();
        if (tagBody != null) {
            tagContent.append(tagBody);
        }
        if (childTags != null) {
            for (Tag childTag : childTags) {
                tagContent.append(childTag.toString());
            }
        }

        return String.format("<%s%s>%s</%s>", getTagName(), result.isEmpty() ? "" : " " + result, tagContent, getTagName());
    }
}
// END
