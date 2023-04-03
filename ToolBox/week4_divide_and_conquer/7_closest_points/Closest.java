import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class Closest {

	static class Point {
		long x, y;

		public Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}

	public static double dist(Point p1, Point p2) {
		return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
	}

	public static double minimalDistance(Point[] points, int start, int end) {
		if ((end - start) <= 2){
			return bruteForce(points,start,end);
		}
		int mid = (start+end)/2;
		Point midP = points[mid];
		double d1 = minimalDistance(points,start,mid);
		double d2 = minimalDistance(points,mid+1,end);
		double d= Math.min(d1,d2);
		Point[] stripe = new Point[end+1];
		int j=0;
		for (int i=0;i<=end;++i){
			if (Math.abs(points[i].x-midP.x)<d){
				stripe[j] = points[i];
				j++;
			}
		}
		return Math.min(d,stripeClosest(stripe,d,j));
	}

	public static double bruteForce(Point[] points, int start, int end) {
		double min = Double.POSITIVE_INFINITY;
		for (int i = start; i <= end; ++i) {
			for (int j = i + 1; j <= end; ++j) {
				double curMin = dist(points[i], points[j]);
				if (curMin < min) {
					min = curMin;
				}
			}
		}
		return min;
	}

	public static double stripeClosest(Point[] stripe, double d,int size) {
		double min = d;
		Arrays.sort(stripe, 0,size,new SortByY());
		for (int i = 0; i < size; ++i) {
			for (int j = i + 1; j < size && (j-i)<7; ++j) {
				double curMin = dist(stripe[i], stripe[j]);
				if (curMin < min) {
					min = curMin;
				}
			}
		}
		return min;
	}


	public static void main(String[] args) throws Exception {
		reader = new BufferedReader(new InputStreamReader(System.in));
		writer = new PrintWriter(System.out);
		int n = nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		Point[] points = new Point[n];
		for (int i = 0; i < n; i++) {
			x[i] = nextInt();
			y[i] = nextInt();
			points[i] = new Point((long)x[i], (long)y[i]);
		}
		Arrays.sort(points, new SortByX());
		System.out.println(minimalDistance(points, 0, points.length - 1));
		writer.close();
	}

	static BufferedReader reader;
	static PrintWriter writer;
	static StringTokenizer tok = new StringTokenizer("");


	static String next() {
		while (!tok.hasMoreTokens()) {
			String w = null;
			try {
				w = reader.readLine();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (w == null)
				return null;
			tok = new StringTokenizer(w);
		}
		return tok.nextToken();
	}

	static int nextInt() {
		return Integer.parseInt(next());
	}
}

class SortByY implements Comparator<Closest.Point> {
	public int compare(Closest.Point p1, Closest.Point p2) {
		return (int) (p1.y - p2.y);
	}
}

class SortByX implements Comparator<Closest.Point> {
	public int compare(Closest.Point p1, Closest.Point p2) {
		return (int) (p1.x - p2.x);
	}
}