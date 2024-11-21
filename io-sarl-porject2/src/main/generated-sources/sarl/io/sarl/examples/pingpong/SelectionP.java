package io.sarl.examples.pingpong;

import io.sarl.lang.core.Address;
import io.sarl.lang.core.Event;
import io.sarl.lang.core.annotation.SarlElementType;
import io.sarl.lang.core.annotation.SarlSpecification;
import io.sarl.lang.core.annotation.SyntheticMember;

/**
 * L'Agente Order si occupa di far selezionare al utente i prodotti che vuole oridnare, Fare effettuare il pagamento e aggiornarlo sulla spedizione
 */
@SarlSpecification("0.13")
@SarlElementType(15)
@SuppressWarnings("all")
public class SelectionP extends Event {
  @SyntheticMember
  public SelectionP() {
    super();
  }

  @SyntheticMember
  public SelectionP(final Address source) {
    super(source);
  }

  @SyntheticMember
  private static final long serialVersionUID = 588368462L;
}
