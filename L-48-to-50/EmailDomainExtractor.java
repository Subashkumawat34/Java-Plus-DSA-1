
public class EmailDomainExtractor {

    public static void main(String[] args) {
        String email = "subhashkumawat34@gmail.com";
        System.out.println(getDomainName(email));

    }

    public static String getDomainName(String email) {
        int atIndex = email.indexOf("@");
        System.out.println(atIndex);
        int dotIndex = email.indexOf(".");
        System.err.println(dotIndex);
        return email.substring(atIndex + 1, dotIndex);
    }
}
