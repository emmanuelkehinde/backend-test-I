public class Util {


    static String[] getFormattedHashTags(String hashtags) {
        hashtags = hashtags.replaceAll("\\s+", "#");
        hashtags = hashtags.replaceAll(",", "#");
        hashtags = hashtags.replaceAll("#+", " #");
        String[] formattedHashtags = hashtags.split(" ");
        if (!formattedHashtags[0].isEmpty()) {
            if (formattedHashtags[0].charAt(0) != '#') {
                formattedHashtags[0] = String.format("#%s", formattedHashtags[0]);
            }
        }
        return formattedHashtags;
    }

    static boolean isNullOrEmpty(String s) {
        return  s == null || s.trim().isEmpty();
    }
}
