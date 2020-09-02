import java.util.Random;

public class GenerateRandomEmails {
  private static String[] domains = {"gmail.com","live.com","miners.utep.edu","utep.edu","google.com","hotmail.com"};
  
  public static String[] generateRandomEmails(int number) {
    String[] rtn = new String[number];
    Random random = new Random();
    for(int i=0; i<number; i++) {
      int randLength = random.nextInt(15) + 5;
      int randDomain = random.nextInt(domains.length);
      StringBuilder buffer = new StringBuilder(randLength + 1 + domains[randDomain].length());
      buffer.append(randomString(randLength));
      buffer.append('@');
      buffer.append(domains[randDomain]);
      rtn[i] = buffer.toString();
    }
    return rtn;
  }
  
  private static String randomString(int len) {
    int leftLimit = 97; // letter 'a'
    int rightLimit = 122; // letter 'z'
    int targetStringLength = len;
    Random random = new Random();
    StringBuilder buffer = new StringBuilder(targetStringLength);
    for (int i = 0; i < targetStringLength; i++) {
        int randomLimitedInt = leftLimit + (int) 
          (random.nextFloat() * (rightLimit - leftLimit + 1));
        buffer.append((char) randomLimitedInt);
    }
    String generatedString = buffer.toString();
    return generatedString;
  }
}
