package Library.domain

import Library.domain.Status.Healthy

final case class Player(
                         id: Id,
                         name: Name,
                         surname: Surname,
                         club: Club,
                         price: Price,
                         position: Position,
                         status: Status = Healthy,
                       )
