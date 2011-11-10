
public class MyList {
	private Entity head;
	private Entity tail;
	
	public void addToEnd(Object element) {
		Entity newEntity = new Entity(element);
		if (head == null) {
			head = newEntity;
			tail = newEntity;
		} else {
			tail.next = newEntity;
			newEntity.previous = tail;
			tail = newEntity;
		}
	}
	
	@Override
	public String toString() {
		Entity currentEntity = head;
		StringBuilder s = new StringBuilder("[");
		while (currentEntity != null) {
			s.append(currentEntity.value).append(" ");
			currentEntity = currentEntity.next;
		}
		s.append("]");
		return s.toString();
	}


	public void reverse() {
		Entity currentEntity = head;
		while (currentEntity != null) {
			Entity tmp = currentEntity.previous;
			currentEntity.previous = currentEntity.next;
			currentEntity.next = tmp;
			currentEntity = currentEntity.previous;
		}
		Entity tmp = tail;
		tail = head;
		head = tmp;
	}

	private static class Entity {
		private Entity next;
		private Entity previous;
		private Object value;
		
		public Entity(Object value) {
			this.value = value;
		}
	}
}
