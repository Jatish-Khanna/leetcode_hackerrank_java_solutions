

public class Solution {



  public static void main(String[] args) throws FileNotFoundException {
    
    Object a[] = new Object[Integer.MAX_VALUE/8];
    
    long start = System.nanoTime();
    
    
    
    Arrays.stream(a).parallel().map(Sample::convert).mapToDouble(Double::doubleValue).sum();
    
    long end = System.nanoTime();
    print(start, end);

    start = end;
    Double sum = 0.0;
    for (Object ar: a) {
      sum += convert(ar);
    }
    end = System.nanoTime();
    print(start, end);

    start = end;
    double sum1 = 0.0;
    for (Object ar: a) {
      sum1 += convert(ar);
    }
    end = System.nanoTime();
    print(start, end);

  }

  private static void print(long start, long end) {
    System.out.println(TimeUnit.SECONDS.convert(end - start, TimeUnit.NANOSECONDS));
  }
  
  private static double convert(Object obj) {
    return Optional.ofNullable((Double)obj).orElse(0.0);
  }
}
