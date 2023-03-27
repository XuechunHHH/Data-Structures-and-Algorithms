import java.util.*;

public class CoveringSegments {

    private static ArrayList<Integer> optimalPoints(Segment[] segments) {
        ArrayList<Integer> points = new ArrayList<>();
        Arrays.sort(segments);
        ArrayList<Segment> seg = new ArrayList<>();
        for (int i = 0;i<segments.length;++i){
            seg.add(segments[i]);
        }
        return addPoints(seg,points);
    }

    private static ArrayList<Integer> addPoints(ArrayList<Segment> seg,ArrayList<Integer> points){
        if (seg.isEmpty()) return points;
        int point = seg.get(0).end;
        for (int i=0;i<seg.size();++i){
            if (seg.get(i).start<=point){
                seg.remove(i);
                i--;
            }
        }
        points.add(point);
        return addPoints(seg,points);
    }

    private static class Segment implements Comparable<Segment> {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Segment s) {
            return this.end - s.end;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        ArrayList<Integer> points = optimalPoints(segments);
        System.out.println(points.size());
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
