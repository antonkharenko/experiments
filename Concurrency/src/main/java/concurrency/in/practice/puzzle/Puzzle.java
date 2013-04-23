package concurrency.in.practice.puzzle;

import java.util.Set;

public interface Puzzle<P, M> {
    
	public P initialPosition();
    
	public boolean isGoal(P position);
    
	public Set<M> legalMoves(P position);
    
	public P move(P position, M move);
}
