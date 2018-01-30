package local_alignment_prct11;

public class ScoreParam {
	private int match;
	private int gap;
	private int mismatch;
	
	public ScoreParam(int match, int gap, int mismatch)
	{
		this.match = match;
		this.gap = gap;
		this.mismatch = mismatch;
	}
	
	public int Match() {return this.match;}
	
	public int Gap() {return this.gap;}
	
	public int MisMatch() {return this.mismatch;}

}
