package concurrency.in.practice.puzzle;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentPuzzleSolver<P, M> {
    private final Puzzle<P, M> puzzle;
    private final ExecutorService exec;
    private final ConcurrentMap<P, Boolean> seen;
    final ValueLatch<Node<P, M>> solution = new ValueLatch<Node<P, M>>();

    public ConcurrentPuzzleSolver(Puzzle<P, M> puzzle) {
		this.puzzle = puzzle;
		exec = Executors.newFixedThreadPool(100);
		seen = new ConcurrentHashMap<P, Boolean>();
	}

    public List<M> solve() throws InterruptedException {
        try {
            P p = puzzle.initialPosition();
            exec.execute(newTask(p, null, null));
            // block until solution found
            Node<P, M> solnNode = solution.getValue();
            return (solnNode == null) ? null : solnNode.asMoveList();
        } finally {
            exec.shutdown();
        }
    }

    protected Runnable newTask(P p, M m, Node<P,M> n) {
        return new SolverTask(p, m, n);
    }

    class SolverTask extends Node<P, M> implements Runnable {
        
        SolverTask(P pos, M move, Node<P, M> prev) {
			super(pos, move, prev);
		}

		public void run() {
            if (solution.isSet()
                    || seen.putIfAbsent(pos, true) != null)
                return; // already solved or seen this position
            if (puzzle.isGoal(pos))
                solution.setValue(this);
            else
                for (M m : puzzle.legalMoves(pos))
                    exec.execute(
                        newTask(puzzle.move(pos, m), m, this));
        }
    }
    
    static class Node<P, M> {
		final P pos;
		final M move;
		final Node<P, M> prev;

		Node(P pos, M move, Node<P, M> prev) {
			this.pos = pos;
			this.move = move;
			this.prev = prev;
		}

		List<M> asMoveList() {
			List<M> solution = new LinkedList<M>();
			for (Node<P, M> n = this; n.move != null; n = n.prev) {
				solution.add(0, n.move);
			}
			return solution;
		}
	}
}
