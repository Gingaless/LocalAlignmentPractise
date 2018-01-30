package local_alignment_prct11;

public class LocalAlignmentPractise11 {

	public static void main(String[] args)
	{
		System.out.println("Hello Java!");
		LocalAlignment1("CTCGTC","AGCGTAG");
	}
	
	
	
	public static void LocalAlignment1(String query, String database)
	{
		ScoreParam sp = new ScoreParam(10,-7,-5);
		
		Integer[][] scorematrix = new Integer[query.length() + 1][database.length() + 1];
		
		int max_score = 0;
		
		int[] max_index = {0,0};
		
		for (int i=0;i<=query.length();i++)
			{for (int j=0;j<=database.length();j++) scorematrix[i][j]=0;}
		
		for (int i=1; i<=query.length(); i++)
		{
			for (int j=1; j<=database.length();j++)
			{
				Integer[] arr = {scorematrix[i-1][j] + sp.Gap(), scorematrix[i][j-1] + sp.Gap(), scorematrix[i-1][j-1] + (query.charAt(i-1)==database.charAt(j-1) ? sp.Match() : sp.MisMatch()), 0};
				if ((scorematrix[i][j] = Max(arr))>max_score) {max_score = scorematrix[i][j]; max_index[0] = i; max_index[1] = j;}
				
			}
		}
		PrintMatrix(scorematrix,query.length() + 1, database.length() + 1);
		System.out.println(max_score);
		System.out.println(String.format("%d, %d", max_index[0], max_index[1]));
	}
	
	public static <E extends Comparable<E>> E Max(E[] args)
	{
		E max = null;
		for (int i=0; i<args.length;i++) {if ((max == null)||(args[i].compareTo(max)>0)) max = args[i];}
		return max;
	}
	
	public static <E> void PrintMatrix(E[][] args, int row, int column)
	{
		for (int i=0;i<row;i++) 
		{
			for (int j=0;j<column;j++) {System.out.print(args[i][j]);System.out.print(" ");}
			System.out.println();
		}
	}
}