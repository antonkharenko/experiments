package org.hibernate.auction.model;

public abstract class Entity {
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	/**
	 * Returns true, if the given object is of same type as <code>this</code>
	 * and their identifier values resulted by calling <code>Persistent.getId()</code>
	 * are equal. 
	 */
	@Override 
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (obj == null)	{
			return false;
		}
		
		if (!getClass().equals(obj.getClass())) {
			return false;
		}
		
		Entity p = (Entity) obj;
		if (getId() != null && p.getId() != null)	{
			// both have id's, rely on id equality
			return getId().equals(p.getId());
		} else if (getId() == null && p.getId() == null)	{
			// both don't have id, use object equality
			return super.equals(obj);
		} else {
			return false;
		}
	}

	/**
	 * Returns has code computed on identifier value.
	 */
	@Override 
	public int hashCode() {
		return hashCode(this);
	}
	
	protected static int hashCode(Entity e)	{
		return (e != null ? 
				(e.getId() != null ?
						e.getId().hashCode() : -1)
						: 0);
	}
}
