package io.sarl.examples.pingpong;

import io.sarl.lang.core.Event;
import io.sarl.lang.core.annotation.SarlElementType;
import io.sarl.lang.core.annotation.SarlSpecification;
import io.sarl.lang.core.annotation.SyntheticMember;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@SarlSpecification("0.13")
@SarlElementType(15)
@SuppressWarnings("all")
public class CheckAvelable extends Event {
  public final int raw;

  public final int qty;

  public CheckAvelable(final int raw, final int qty) {
    this.raw = raw;
    this.qty = qty;
  }

  @Override
  @Pure
  @SyntheticMember
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    CheckAvelable other = (CheckAvelable) obj;
    if (other.raw != this.raw)
      return false;
    if (other.qty != this.qty)
      return false;
    return super.equals(obj);
  }

  @Override
  @Pure
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    final int prime = 31;
    result = prime * result + Integer.hashCode(this.raw);
    result = prime * result + Integer.hashCode(this.qty);
    return result;
  }

  /**
   * Returns a String representation of the CheckAvelable event's attributes only.
   */
  @SyntheticMember
  @Pure
  protected void toString(final ToStringBuilder builder) {
    super.toString(builder);
    builder.add("raw", this.raw);
    builder.add("qty", this.qty);
  }

  @SyntheticMember
  private static final long serialVersionUID = 692429855L;
}
