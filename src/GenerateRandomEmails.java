import java.util.Random;

public class GenerateRandomEmails {
  private static String[] domains = {
      "gmail.com",
      "miners.utep.edu",
      //"utep.edu",
      //"google.com",
      "hotmail.com",
      "deblasio.cc"};
  
  public static String[] generateRandomEmails(int number) {
    String[] rtn = new String[number];
    Random random = new Random(4962768);
    for(int i=0; i<number; i++) {
      int randLength = random.nextInt(8) + 4;
      int randDomain = random.nextInt(domains.length);
      StringBuilder buffer = new StringBuilder(randLength + 1 + domains[randDomain].length());
      buffer.append(randomString(randLength, random.nextInt()));
      buffer.append('@');
      buffer.append(domains[randDomain]);
      rtn[i] = buffer.toString();
    }
    return rtn;
  }
  
  private static String randomString(int len, int randomLong) {
    //int leftLimit = 97; // letter 'a'
    //int rightLimit = 122; // letter 'z'
    char[] validChars = new char[26*2+10];
    for(int i=0;i<26;i++) {
      validChars[i] = (char)(97 + i);
      validChars[26+i] = (char)(65 + i);
    }
    for(int i=0; i<10; i++) {
      validChars[26*2 + i] = (char)(48 + i);
    }
    int targetStringLength = len;
    Random random = new Random(randomLong);
    StringBuilder buffer = new StringBuilder(targetStringLength);
    for (int i = 0; i < targetStringLength; i++) {
        //int randomLimitedInt = leftLimit + (int) 
        //  (random.nextFloat() * (rightLimit - leftLimit + 1));
        //buffer.append((char) randomLimitedInt);
      buffer.append(validChars[random.nextInt(validChars.length)]);
    }
    String generatedString = buffer.toString();
    return generatedString;
  }
}
